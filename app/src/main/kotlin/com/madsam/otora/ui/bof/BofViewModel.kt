package com.madsam.otora.ui.bof

import android.util.Log
import android.view.View
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madsam.otora.BofScreenState
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import com.madsam.otora.data.bof.ui.model.BofEntryUI
import com.madsam.otora.data.bof.ui.model.BofTeamUI
import com.madsam.otora.data.bof.ui.model.RankTracking
import com.madsam.otora.data.bof.local.api.BofLocalService
import com.madsam.otora.data.bof.local.repository.BofRepository
import com.madsam.otora.data.bof.local.model.BofTTCompactEntity
import com.madsam.otora.data.bof.local.repository.WorkRanking
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.ScreenUtil.getSafeInsetLeftDp
import com.madsam.otora.core.utils.ScreenUtil.getSafeInsetRightDp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.combine
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.math.max

private const val TAG = "BofViewModel"

internal class BofViewModel(
    private val bofScreenState: BofScreenState
) : ViewModel() {
    
    private val bofLocalService = BofLocalService()
    
    // BOFTT Repository for new functionality
    val bofRepository: BofRepository by lazy {
        Log.d(TAG, "BofRepository lazy initialization")
        BofRepository(ObjectBoxManager.getBoxStore().boxFor(BofTTCompactEntity::class.java))
    }
    val totalData = MutableStateFlow(listOf<BofEntryUI>())
    val avgData = MutableStateFlow(listOf<BofEntryUI>())
    val medianData = MutableStateFlow(listOf<BofEntryUI>())
    val diffData = MutableStateFlow(listOf<BofEntryUI>())
    val isDiffReverse = MutableStateFlow(false)
    val teamData = MutableStateFlow(listOf<BofTeamUI>())
    val commentData = MutableStateFlow(listOf<BofCommentUI>())

    // 新的排名数据流
    val totalRankingData = MutableStateFlow(listOf<WorkRanking>())
    val avgRankingData = MutableStateFlow(listOf<WorkRanking>())
    val medianRankingData = MutableStateFlow(listOf<WorkRanking>())
    val diffRankingData = MutableStateFlow(listOf<WorkRanking>())
    val compositeRankingData = MutableStateFlow(listOf<WorkRanking>())
    
    // 平均分排行的过滤参数
    val avgMinImpression = MutableStateFlow(1)
    
    // 中位数排行的过滤参数
    val medianMinImpression = MutableStateFlow(1)
    
    // 综合分数排行的过滤参数
    val compositeMinImpression = MutableStateFlow(1)
    
    val isLoading = MutableStateFlow(false)
    val errorMessage = MutableStateFlow("")

    init {
        Log.d(TAG, "BofViewModel init started")
        
        // 监听总分排行数据和过滤参数变化，自动生成平均分排行数据
        viewModelScope.launch {
            combine(totalRankingData, avgMinImpression) { totalData, minImpression ->
                generateAverageRanking(totalData, minImpression)
            }.collect { avgData ->
                avgRankingData.update { avgData }
            }
        }
        
        // 监听总分排行数据和过滤参数变化，自动生成中位数排行数据
        viewModelScope.launch {
            combine(totalRankingData, medianMinImpression) { totalData, minImpression ->
                generateMedianRanking(totalData, minImpression)
            }.collect { medianData ->
                medianRankingData.update { medianData }
            }
        }
    }

    var thresholdImpr = MutableStateFlow(1)
    var thresholdImprOld = MutableStateFlow(1)

    var selectedTimeStr = MutableStateFlow("")
    var selectedTimeStrNoComp = MutableStateFlow("")

    val leftPadding = MutableStateFlow(0.dp)
    val rightPadding = MutableStateFlow(0.dp)

    val highlightedText = MutableStateFlow("")
    val scrollToIndexListTotal = MutableStateFlow(listOf<Int>())
    val currentIndexTotal = MutableStateFlow(0)
    val scrollToIndexListAvg = MutableStateFlow(listOf<Int>())
    val currentIndexAvg = MutableStateFlow(0)
    val scrollToIndexListMedian = MutableStateFlow(listOf<Int>())
    val currentIndexMedian = MutableStateFlow(0)
    val scrollToIndexListDiff = MutableStateFlow(listOf<Int>())
    val currentIndexDiff = MutableStateFlow(0)
    val scrollToIndexListTeam = MutableStateFlow(listOf<Int>())
    val currentIndexTeam = MutableStateFlow(0)
    val scrollToIndexListComment = MutableStateFlow(listOf<Int>())
    val currentIndexComment = MutableStateFlow(0)

    fun findItemIndex(query: String, originalData: List<BofEntryUI>, pageIndex: Int) {
        val scrollToIndexList = when (pageIndex) {
            0 -> scrollToIndexListTotal
            1 -> scrollToIndexListAvg
            2 -> scrollToIndexListMedian
            3 -> scrollToIndexListDiff
            else -> scrollToIndexListTotal
        }
        val currentIndex = when (pageIndex) {
            0 -> currentIndexTotal
            1 -> currentIndexAvg
            2 -> currentIndexMedian
            3 -> currentIndexDiff
            else -> currentIndexTotal
        }
        currentIndex.update { 0 }
        scrollToIndexList.update {
            originalData.mapIndexedNotNull { index, item ->
                if (item.title.contains(query, ignoreCase = true)) index else null
            }
        }
        highlightedText.update { query }
    }

    fun findTeamItemIndex(query: String, originalData: List<BofTeamUI>) {
        currentIndexTeam.update { 0 }
        scrollToIndexListTeam.update {
            originalData.mapIndexedNotNull { index, item ->
                if (item.team.contains(query, ignoreCase = true)) index else null
            }
        }
        highlightedText.update { query }
    }

    fun scrollToPrevious(pageIndex: Int) {
        val currentIndex = when (pageIndex) {
            0 -> currentIndexTotal
            1 -> currentIndexAvg
            2 -> currentIndexMedian
            3 -> currentIndexDiff
            else -> currentIndexTotal
        }
        if (currentIndex.value > 0) {
            currentIndex.update { it - 1 }
        } else {
            currentIndex.update { it }
        }
    }

    fun scrollToNext(pageIndex: Int) {
        val currentIndex = when (pageIndex) {
            0 -> currentIndexTotal
            1 -> currentIndexAvg
            2 -> currentIndexMedian
            3 -> currentIndexDiff
            else -> currentIndexTotal
        }
        val scrollToIndexList = when (pageIndex) {
            0 -> scrollToIndexListTotal
            1 -> scrollToIndexListAvg
            2 -> scrollToIndexListMedian
            3 -> scrollToIndexListDiff
            else -> scrollToIndexListTotal
        }
        if (currentIndex.value < scrollToIndexList.value.size - 1) {
            currentIndex.update { it + 1 }
        } else {
            currentIndex.update { it }
        }
    }

    fun updatePadding(view: View) {
        leftPadding.update { getSafeInsetLeftDp(view) }
        rightPadding.update { getSafeInsetRightDp(view) }
    }

    fun generateSelectedTimeStr() {
        if (totalData.value.isEmpty()) {
            selectedTimeStr.update {
                "No data available for the selected date and time."
            }
        } else {
            val currentTime = CommonUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCurrentTime.value)
            val compareTime = CommonUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCompareTime.value)
            selectedTimeStr.update {
                "Data at ${bofScreenState.selectedCurrentDate.value} $currentTime, " +
                        "compare with ${bofScreenState.selectedCompareDate.value} $compareTime, " +
                        "all data scraped by MadSamurai."
            }
            selectedTimeStrNoComp.update {
                "Data at ${bofScreenState.selectedCurrentDate.value} $currentTime, " +
                        "all data scraped by MadSamurai."
            }
        }
    }

    private suspend fun <T> fetchData(
        fetchLatest: suspend () -> List<T>,
        fetchByTime: suspend (Long, Long) -> List<T>
    ): List<T> {
        return if (bofScreenState.selectedCurrentTime.value == "-1") {
            fetchLatest()
        } else {
            val currentTime = CommonUtils.ymdToMillis(
                bofScreenState.selectedCurrentDate.value.toString(),
                CommonUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCurrentTime.value)
            )
            val compareTime = CommonUtils.ymdToMillis(
                bofScreenState.selectedCompareDate.value.toString(),
                CommonUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCompareTime.value)
            )
            fetchByTime(currentTime, compareTime)
        }
    }

    private fun <T, R : Comparable<R>> updateRanks(
        data: List<T>,
        oldSelector: (T) -> R,
        selector: (T) -> R,
        oldRankSetter: (T, Int) -> Unit,
        rankSetter: (T, Int) -> Unit,
        diffSetter: (T, Int) -> Unit,
        filter: (T) -> Boolean,
        reviewCountSelector: (T) -> Int
    ): List<T> where T : RankTracking {
        val sortedDataOld = data.sortedWith(compareByDescending(oldSelector)).filter { filter(it) }
        var currentOldRank = 1
        sortedDataOld.forEachIndexed { index, entry ->
            if (index > 0 && oldSelector(sortedDataOld[index - 1]) != oldSelector(entry)) {
                currentOldRank = index + 1
            }
            oldRankSetter(entry, currentOldRank)
        }
        val sortedData =
            sortedDataOld.sortedWith(compareByDescending(selector).thenByDescending(reviewCountSelector))
        var currentRank = 1
        sortedData.forEachIndexed { index, entry ->
            if (index > 0 && selector(sortedData[index - 1]) != selector(entry)) {
                currentRank = index + 1
            }
            rankSetter(entry, currentRank)
        }
        sortedData.forEach {
            diffSetter(it, it.previousRank - it.currentRank)
        }
        return sortedData
    }

    private fun calculateThresholds(data: List<BofEntryUI>) {
        val sortedDataByOldImpr = data.sortedByDescending { it.oldImpr }
        thresholdImprOld.update { max(sortedDataByOldImpr.getOrNull(239)?.oldImpr ?: 0, 3) }

        val sortedDataByImpr = data.sortedByDescending { it.impr }
        thresholdImpr.update { max(sortedDataByImpr.getOrNull(239)?.impr ?: 0, 3) }
    }

    suspend fun requestTotalData() {
        val data = fetchData(
            { bofLocalService.getBofttEntryLatest() },
            { currentTime, compareTime -> bofLocalService.getBofttEntryByTime(currentTime, compareTime) }
        )

        if (data.isEmpty()) {
            Log.d(TAG, "No data available for the selected date and time.")
            return
        }
        val updatedData = updateRanks(
            data,
            { it.oldTotal },
            { it.total },
            { entry, rank -> entry.previousRank = rank },
            { entry, rank -> entry.currentRank = rank },
            { entry, diff -> entry.rankDiff = diff },
            { true },
            { it.impr }
        )
        totalData.update { updatedData }
    }

    suspend fun requestAvgData() {
        val data = fetchData(
            { bofLocalService.getBofttEntryLatest() },
            { time, compareTime -> bofLocalService.getBofttEntryByTime(time, compareTime) }
        )
        calculateThresholds(data)
        if (data.isEmpty()) {
            Log.d(TAG, "No avg data available for the selected date and time.")
            return
        }
        val updatedData = updateRanks(
            data,
            { it.oldAvg },
            { it.avg },
            { entry, rank -> entry.previousRank = rank },
            { entry, rank -> entry.currentRank = rank },
            { entry, diff -> entry.avgDiff = diff },
            { it.impr >= thresholdImpr.value },
            { it.impr }
        )
        avgData.update { updatedData }
    }

    suspend fun requestMedianData() {
        val data = fetchData(
            { bofLocalService.getBofttEntryLatest() },
            { time, compareTime -> bofLocalService.getBofttEntryByTime(time, compareTime) }
        )
        calculateThresholds(data)
        if (data.isEmpty()) {
            Log.d(TAG, "No median data available for the selected date and time.")
            return
        }
        val updatedData = updateRanks(
            data,
            { it.oldMedian },
            { it.median },
            { entry, rank -> entry.previousRank = rank },
            { entry, rank -> entry.currentRank = rank },
            { entry, diff -> entry.medianDiff = diff },
            { it.impr >= thresholdImpr.value },
            { it.impr }
        )
        medianData.update { updatedData }
    }

    suspend fun requestDiffData() {
        val data = fetchData(
            { bofLocalService.getBofttEntryLatest() },
            { time, compareTime -> bofLocalService.getBofttEntryByTime(time, compareTime) }
        )
        data.forEach {
            it.totalDiff = it.total - it.oldTotal
            it.imprDiff = it.impr - it.oldImpr
        }
        val updatedData = updateRanks(
            data,
            { it.totalDiff },
            { it.totalDiff },
            { entry, rank -> entry.previousRank = rank },
            { entry, rank -> entry.currentRank = rank },
            { entry, diff -> entry.totalDiff = entry.totalDiff },
            { true },
            { it.imprDiff }
        )
        val maxTotalDiff = updatedData.maxOfOrNull { it.totalDiff } ?: 0
        val minTotalDiff = updatedData.minOfOrNull { it.totalDiff } ?: 0
        if (minTotalDiff < 0 && maxTotalDiff == 0) {
            val reverseData = updatedData.map {
                it.totalDiff = -it.totalDiff
                it.imprDiff = -it.imprDiff
                it
            }.sortedByDescending { it.totalDiff }
            isDiffReverse.update { true }
            diffData.update { reverseData }
        } else diffData.update { updatedData }
    }

    suspend fun requestTeamData() {
        val data = fetchData(
            { bofLocalService.getBofttTeamLatest() },
            { currentTime, compareTime -> bofLocalService.getBofttTeamByTime(currentTime, compareTime) }
        )

        if (data.isEmpty()) {
            Log.d(TAG, "No team data available for the selected date and time.")
            return
        }
        val updatedData = updateRanks(
            data,
            { it.oldTotal },
            { it.total },
            { entry, rank -> entry.previousRank = rank },
            { entry, rank -> entry.currentRank = rank },
            { entry, diff -> entry.rankDiff = diff },
            { true },
            { it.impr }
        )
        teamData.update { updatedData }
    }

    suspend fun requestCommentData() {
        val data = fetchData(
            { bofLocalService.getBofttCommentLatest() },
            { currentTime, compareTime -> bofLocalService.getBofttCommentByTime("2025-01-08") }
        )
        if (data.isEmpty()) {
            Log.d(TAG, "No comment data available for the selected date and time.")
            return
        }
        val updatedData = data.sortedWith(compareByDescending(BofCommentUI::total)
                .thenByDescending(BofCommentUI::long)
                .thenByDescending(BofCommentUI::short)
                .thenByDescending(BofCommentUI::vote))
        var currentRank = 1
        updatedData.forEachIndexed { index, entry ->
            if (index > 0 && updatedData[index - 1].total != entry.total) {
                currentRank = index + 1
            }
            entry.index = currentRank
        }
        commentData.update { updatedData }
    }

    // 流式JSON解析加载 - 支持两时间点对比
    fun loadRankingDataWithStreamedParsing() {
        Log.d(TAG, "Starting streamed JSON parsing data loading with comparison")
        viewModelScope.launch {
            try {
                isLoading.update { true }
                errorMessage.update { "" }
                
                // 计算当前时间戳（主排序时间点）
                val currentTimestamp = if (bofScreenState.selectedCurrentTime.value == "-1") {
                    System.currentTimeMillis()
                } else {
                    CommonUtils.ymdToMillis(
                        bofScreenState.selectedCurrentDate.value.toString(),
                        CommonUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCurrentTime.value)
                    )
                }
                
                // 计算对比时间戳（可选）
                val compareTimestamp = if (bofScreenState.selectedCompareTime.value == "-1") {
                    null
                } else {
                    CommonUtils.ymdToMillis(
                        bofScreenState.selectedCompareDate.value.toString(),
                        CommonUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCompareTime.value)
                    )
                }
                
                Log.d(TAG, "Current timestamp: $currentTimestamp, Compare timestamp: $compareTimestamp")
                
                var isFirstBatch = true
                
                // 使用支持对比的流式处理
                bofRepository.getRankingAtTimeStreamedWithComparison(
                    currentTimestamp = currentTimestamp,
                    compareTimestamp = compareTimestamp,
                    batchSize = 30
                ) { currentResults ->
                    Log.d(TAG, "Streamed update with comparison: ${currentResults.size} rankings available")
                    totalRankingData.update { currentResults }
                    
                    // 第一批数据加载完成后就关闭加载状态
                    if (isFirstBatch && currentResults.isNotEmpty()) {
                        Log.d(TAG, "First batch loaded, setting isLoading to false")
                        isLoading.update { false }
                        isFirstBatch = false
                    }
                }
                
                if (totalRankingData.value.isEmpty()) {
                    errorMessage.update { "该时间点暂无排名数据" }
                }
                
                Log.d(TAG, "Streamed data loading with comparison completed successfully")
                
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load ranking data with streamed parsing and comparison", e)
                errorMessage.update { "加载失败: ${e.message}" }
                totalRankingData.update { emptyList() }
            } finally {
                // 确保加载状态最终被设置为false
                if (isLoading.value) {
                    Log.d(TAG, "Finally setting isLoading to false")
                    isLoading.update { false }
                }
            }
        }
    }
    
    // 获取当前选择的时间字符串 - 支持对比时间显示
    fun getSelectedTimeString(): String {
        val currentTime = if (bofScreenState.selectedCurrentTime.value == "-1") {
            "最新数据"
        } else {
            val time = CommonUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCurrentTime.value)
            "${bofScreenState.selectedCurrentDate.value} $time"
        }
        
        val compareTime = if (bofScreenState.selectedCompareTime.value == "-1") {
            null
        } else {
            val time = CommonUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCompareTime.value)
            "${bofScreenState.selectedCompareDate.value} $time"
        }
        
        return if (compareTime != null) {
            "当前: $currentTime | 对比: $compareTime"
        } else {
            "数据时间: $currentTime"
        }
    }
    
    // 基于总分排行数据生成平均分排行数据
    private fun generateAverageRanking(totalData: List<WorkRanking>, minImpression: Int): List<WorkRanking> {
        // 过滤符合条件的数据
        val filteredData = totalData.filter { it.impression >= minImpression && it.average > 0 }
        
        // 按平均分降序排列
        val sortedByAverage = filteredData.sortedByDescending { it.average }
        
        // 重新分配排名并计算平均分排名变化
        return sortedByAverage.mapIndexed { index, ranking -> 
            val newRank = index + 1
            
            // 计算平均分排名变化
            // 需要基于对比数据重新计算平均分排名
            val compareRankInAverage = if (ranking.compareAverage != null && ranking.compareAverage > 0) {
                // 在对比数据中找到该作品在平均分排行中的位置
                val compareFilteredData = totalData.filter { 
                    it.compareAverage != null && it.compareAverage > 0 &&
                    (ranking.compareImpression ?: 0) >= minImpression 
                }
                val compareSortedByAverage = compareFilteredData.sortedByDescending { it.compareAverage!! }
                val compareIndex = compareSortedByAverage.indexOfFirst { it.workId == ranking.workId }
                if (compareIndex >= 0) compareIndex + 1 else null
            } else {
                null
            }
            
            // 计算排名变化（正数表示排名提升，负数表示排名下降）
            val rankChange = if (compareRankInAverage != null) {
                compareRankInAverage - newRank // 对比排名 - 当前排名
            } else {
                null
            }
            
            ranking.copy(
                rank = newRank,
                compareRank = compareRankInAverage,
                rankChange = rankChange
            )
        }
    }
    
    // 更新平均分排行的最低评价数过滤条件
    fun updateAverageMinImpression(minImpression: Int) {
        avgMinImpression.update { minImpression }
    }
    
    // 基于总分排行数据生成中位数排行数据
    private fun generateMedianRanking(totalData: List<WorkRanking>, minImpression: Int): List<WorkRanking> {
        // 过滤符合条件的数据
        val filteredData = totalData.filter { it.impression >= minImpression && it.median > 0 }
        
        // 按中位数降序排列
        val sortedByMedian = filteredData.sortedByDescending { it.median }
        
        // 重新分配排名并计算中位数排名变化
        return sortedByMedian.mapIndexed { index, ranking -> 
            val newRank = index + 1
            
            // 计算中位数排名变化
            // 需要基于对比数据重新计算中位数排名
            val compareRankInMedian = if (ranking.compareMedian != null && ranking.compareMedian > 0) {
                // 在对比数据中找到该作品在中位数排行中的位置
                val compareFilteredData = totalData.filter { 
                    it.compareMedian != null && it.compareMedian > 0 &&
                    (ranking.compareImpression ?: 0) >= minImpression 
                }
                val compareSortedByMedian = compareFilteredData.sortedByDescending { it.compareMedian!! }
                val compareIndex = compareSortedByMedian.indexOfFirst { it.workId == ranking.workId }
                if (compareIndex >= 0) compareIndex + 1 else null
            } else {
                null
            }
            
            // 计算排名变化（正数表示排名提升，负数表示排名下降）
            val rankChange = if (compareRankInMedian != null) {
                compareRankInMedian - newRank // 对比排名 - 当前排名
            } else {
                null
            }
            
            ranking.copy(
                rank = newRank,
                compareRank = compareRankInMedian,
                rankChange = rankChange
            )
        }
    }
    
    // 更新中位数排行的最低评价数过滤条件
    fun updateMedianMinImpression(minImpression: Int) {
        medianMinImpression.update { minImpression }
    }
    
    // 生成综合分数排行榜
    fun generateCompositeRanking() {
        Log.d(TAG, "Starting composite ranking generation")
        viewModelScope.launch {
            combine(
                totalRankingData,
                compositeMinImpression
            ) { totalData: List<WorkRanking>, minImpression: Int ->
                Log.d(TAG, "Generating composite ranking with ${totalData.size} items, minImpression: $minImpression")
                generateCompositeRankingFromTotal(totalData, minImpression)
            }.collect { compositeData: List<WorkRanking> ->
                compositeRankingData.update { compositeData }
            }
        }
    }
    
    private fun generateCompositeRankingFromTotal(totalData: List<WorkRanking>, minImpression: Int): List<WorkRanking> {
        // 过滤符合条件的数据
        val filteredData = totalData.filter { 
            it.impression >= minImpression && 
            it.average > 0 && 
            it.median > 0 && 
            it.score > 0 
        }
        
        // 找到最大总分用于标准化
        val maxTotalScore = filteredData.maxOfOrNull { it.score }?.toDouble() ?: 1000.0
        Log.d(TAG, "Maximum total score for normalization: $maxTotalScore")
        
        // 计算综合分数并排序
        val rankedData = filteredData.map { ranking ->
            // 标准化总分到0-1000范围
            val normalizedTotalScore = (ranking.score.toDouble() / maxTotalScore) * 1000.0
            
            // 计算综合分数：标准化总分7% + 中位数80% + 平均分13%
            val compositeScore = normalizedTotalScore * 0.07 + 
                               ranking.median * 0.80 + 
                               ranking.average * 0.13
            
            Log.d(TAG, "Work ${ranking.title}: totalScore=${ranking.score}, normalized=$normalizedTotalScore, median=${ranking.median}, avg=${ranking.average}, composite=$compositeScore")
            
            ranking.copy(score = compositeScore.toInt())
        }.sortedByDescending { it.score }
        
        // 重新分配排名
        return rankedData.mapIndexed { index, ranking ->
            ranking.copy(rank = index + 1)
        }
    }
    
    // 更新综合分数排行的最低评价数过滤条件
    fun updateCompositeMinImpression(minImpression: Int) {
        compositeMinImpression.update { minImpression }
    }
    
    // 加载差值排行数据
    fun loadDifferenceRankingData() {
        Log.d(TAG, "Starting difference ranking data loading")
        viewModelScope.launch {
            try {
                isLoading.update { true }
                errorMessage.update { "" }
                
                // 计算当前时间戳
                val currentTimestamp = if (bofScreenState.selectedCurrentTime.value == "-1") {
                    System.currentTimeMillis()
                } else {
                    CommonUtils.ymdToMillis(
                        bofScreenState.selectedCurrentDate.value.toString(),
                        CommonUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCurrentTime.value)
                    )
                }
                
                // 计算对比时间戳
                val compareTimestamp = if (bofScreenState.selectedCompareTime.value == "-1") {
                    System.currentTimeMillis() - 86400000L // 默认对比一天前
                } else {
                    CommonUtils.ymdToMillis(
                        bofScreenState.selectedCompareDate.value.toString(),
                        CommonUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCompareTime.value)
                    )
                }
                
                Log.d(TAG, "Current timestamp: $currentTimestamp, Compare timestamp: $compareTimestamp")
                
                // 获取差值排行数据
                val differenceData = bofRepository.getDifferenceRankingBetweenTimes(
                    currentTimestamp = currentTimestamp,
                    compareTimestamp = compareTimestamp,
                    limit = 500
                )
                
                diffRankingData.update { differenceData }
                
                if (differenceData.isEmpty()) {
                    errorMessage.update { "该时间段暂无差值数据" }
                }
                
                Log.d(TAG, "Difference ranking data loading completed successfully, got ${differenceData.size} items")
                
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load difference ranking data", e)
                errorMessage.update { "加载失败: ${e.message}" }
                diffRankingData.update { emptyList() }
            } finally {
                isLoading.update { false }
            }
        }
    }
}

class BofViewModelFactory(
    private val bofScreenState: BofScreenState
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d(TAG, "BofViewModelFactory.create called")
        if (modelClass.isAssignableFrom(BofViewModel::class.java)) {
            Log.d(TAG, "Creating BofViewModel instance")
            @Suppress("UNCHECKED_CAST")
            return BofViewModel(bofScreenState) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
