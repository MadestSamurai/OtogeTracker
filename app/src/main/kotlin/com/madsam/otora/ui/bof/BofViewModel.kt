package com.madsam.otora.ui.bof

import android.util.Log
import android.view.View
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.ScreenUtil.getSafeInsetLeftDp
import com.madsam.otora.core.utils.ScreenUtil.getSafeInsetRightDp
import com.madsam.otora.data.bof.local.api.BofLocalService
import com.madsam.otora.data.bof.local.model.BofWorkEntity
import com.madsam.otora.data.bof.local.repository.BofRepository
import com.madsam.otora.data.bof.local.repository.WorkRanking
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.abs

private const val TAG = "BofViewModel"

internal class BofViewModel(
    private val bofScreenState: BofScreenState
) : ViewModel() {
    
    private val bofLocalService = BofLocalService()
    
    // BOF Repository for new functionality
    val bofRepository: BofRepository by lazy {
        Log.d(TAG, "BofRepository lazy initialization")
        val boxStore = ObjectBoxManager.getBoxStore()
        BofRepository(
            boxStore.boxFor(BofWorkEntity::class.java)
        )
    }
    val commentData = MutableStateFlow(listOf<BofCommentUI>())

    // 新的团队排行数据流
    val teamRankingData = MutableStateFlow(listOf<TeamRankingItem>())
    val isTeamRankingLoading = MutableStateFlow(false)
    val teamRankingError = MutableStateFlow("")

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
        if (totalRankingData.value.isEmpty()) {
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
                    path = bofScreenState.selectedRange.value?.path ?: "tt",
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
                } else {
                    // 数据加载完成后，生成其他类型的排行榜
                    Log.d(TAG, "Generating derived rankings...")
                    generateCompositeRanking()
                    generateDifferenceRanking()
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
        
        // 计算当前时间点的综合分数
        val currentCompositeData = filteredData.map { ranking ->
            // 标准化总分到0-1000范围
            val normalizedTotalScore = (ranking.score.toDouble() / maxTotalScore) * 1000.0
            
            // 计算综合分数：标准化总分7% + 中位数80% + 平均分13%
            val compositeScore = normalizedTotalScore * 0.07 + 
                               ranking.median * 0.80 + 
                               ranking.average * 0.13

            ranking.copy(
                score = compositeScore.toInt(), // 保持原有的Int字段用于排序
                compositeScore = compositeScore // 添加Double字段保留小数
            )
        }.sortedByDescending { it.compositeScore ?: it.score.toDouble() }
        
        // 计算对比时间点的综合分数（如果有对比数据）
        val compareCompositeMap = mutableMapOf<String, Int>() // workId -> 对比综合分数排名
        val compareCompositeScoreMap = mutableMapOf<String, Double>() // workId -> 对比综合分数(Double)
        
        val hasCompareData = filteredData.any { 
            it.compareScore != null && it.compareAverage != null && it.compareMedian != null 
        }
        
        if (hasCompareData) {
            // 过滤有完整对比数据的作品
            val compareFilteredData = filteredData.filter { 
                it.compareScore != null && it.compareScore > 0 &&
                it.compareAverage != null && it.compareAverage > 0 &&
                it.compareMedian != null && it.compareMedian > 0 &&
                (it.compareImpression ?: 0) >= minImpression
            }
            
            if (compareFilteredData.isNotEmpty()) {
                // 找到对比时间点的最大总分
                val maxCompareTotalScore = compareFilteredData.maxOfOrNull { it.compareScore!! }?.toDouble() ?: 1000.0
                
                // 计算对比时间点的综合分数并排序
                val compareCompositeData = compareFilteredData.map { ranking ->
                    val normalizedCompareTotalScore = (ranking.compareScore!!.toDouble() / maxCompareTotalScore) * 1000.0
                    val compareCompositeScore = normalizedCompareTotalScore * 0.07 + 
                                              ranking.compareMedian!! * 0.80 + 
                                              ranking.compareAverage!! * 0.13
                    
                    Triple(ranking.workId, compareCompositeScore, ranking)
                }.sortedByDescending { it.second }
                
                // 创建对比排名和分数映射
                compareCompositeData.forEachIndexed { index, (workId, score, _) ->
                    compareCompositeMap[workId] = index + 1
                    compareCompositeScoreMap[workId] = score
                }
            }
        }
        
        // 重新分配排名并计算排名变化
        return currentCompositeData.mapIndexed { index, ranking ->
            val currentRank = index + 1
            val compareRank = compareCompositeMap[ranking.workId]
            val compareCompositeScore = compareCompositeScoreMap[ranking.workId]
            val rankChange = if (compareRank != null) {
                compareRank - currentRank // 对比排名 - 当前排名，正数表示排名上升
            } else null
            
            ranking.copy(
                rank = currentRank,
                compareRank = compareRank,
                rankChange = rankChange,
                compareScore = compareCompositeScore?.toInt(), // 保持Int类型用于兼容性
                compareCompositeScore = compareCompositeScore // 添加Double类型的对比综合分数
            )
        }
    }
    
    // 更新综合分数排行的最低评价数过滤条件
    fun updateCompositeMinImpression(minImpression: Int) {
        compositeMinImpression.update { minImpression }
    }
    
    // 生成差值排行榜 - 基于总分排行数据直接计算
    fun generateDifferenceRanking() {
        Log.d(TAG, "Starting difference ranking generation")
        viewModelScope.launch {
            combine(
                totalRankingData,
                MutableStateFlow(1) // 暂时固定最低评价数为1，可以后续添加筛选参数
            ) { totalData: List<WorkRanking>, minImpression: Int ->
                Log.d(TAG, "Generating difference ranking with ${totalData.size} items")
                generateDifferenceRankingFromTotal(totalData)
            }.collect { diffData: List<WorkRanking> ->
                diffRankingData.update { diffData }
            }
        }
    }
    
    private fun generateDifferenceRankingFromTotal(totalData: List<WorkRanking>): List<WorkRanking> {
        // 过滤有对比数据的作品，并计算分数差值
        val diffData = totalData.mapNotNull { ranking ->
            if (ranking.compareScore != null && ranking.compareScore > 0) {
                val scoreDiff = ranking.score - ranking.compareScore
                val avgDiff = if (ranking.compareAverage != null) ranking.average - ranking.compareAverage else null
                val medianDiff = if (ranking.compareMedian != null) ranking.median - ranking.compareMedian else null
                val impressionDiff = if (ranking.compareImpression != null) ranking.impression - ranking.compareImpression else null
                
                // 创建差值排行项，以分数差值作为主要排序依据
                WorkRanking(
                    workId = ranking.workId,
                    title = ranking.title,
                    artist = ranking.artist,
                    score = scoreDiff, // 分数差值作为主要分数
                    average = avgDiff ?: 0.0, // 平均分差值
                    median = medianDiff ?: 0.0, // 中位数差值
                    impression = impressionDiff ?: 0, // 评价数差值
                    rank = 0 // 稍后分配
                )
            } else null
        }.filter { 
            // 可以根据需要添加更多过滤条件
            abs(it.score) > 0 // 只显示有变化的作品
        }.sortedByDescending { it.score } // 按分数差值降序排列（正数表示增长）
        
        // 重新分配排名
        return diffData.mapIndexed { index, ranking ->
            ranking.copy(rank = index + 1)
        }
    }

    /**
     * 加载团队排行数据 - 支持时间解析和分阶段处理
     */
    fun loadTeamRankingData(path: String) {
        Log.d(TAG, "Starting team ranking data loading with time-based parsing")
        viewModelScope.launch {
            try {
                isTeamRankingLoading.update { true }
                teamRankingError.update { "" }
                
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
                
                Log.d(TAG, "Team ranking - Current timestamp: $currentTimestamp, Compare timestamp: $compareTimestamp")
                
                var isFirstBatch = true
                
                // 使用支持对比的分阶段处理
                bofRepository.getTeamRankingAtTimeStreamed(
                    currentTimestamp = currentTimestamp,
                    compareTimestamp = compareTimestamp,
                    path = path,
                    batchSize = 10
                ) { currentResults ->
                    Log.d(TAG, "Team ranking streamed update: ${currentResults.size} teams available")
                    teamRankingData.update { currentResults }
                    
                    // 第一批数据加载完成后就关闭加载状态
                    if (isFirstBatch && currentResults.isNotEmpty()) {
                        Log.d(TAG, "First batch of team data loaded, setting isLoading to false")
                        isTeamRankingLoading.update { false }
                        isFirstBatch = false
                    }
                }
                
                if (teamRankingData.value.isEmpty()) {
                    teamRankingError.update { "该时间点暂无团队排名数据" }
                }
                
                Log.d(TAG, "Team ranking data loading completed successfully")
                
            } catch (e: Exception) {
                Log.e(TAG, "Error loading team ranking data: ${e.message}", e)
                teamRankingError.update { "加载团队排行数据失败: ${e.message}" }
            } finally {
                // 确保加载状态最终被设置为false
                if (isTeamRankingLoading.value) {
                    Log.d(TAG, "Finally setting team ranking isLoading to false")
                    isTeamRankingLoading.update { false }
                }
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

/**
 * 新的团队排行数据项
 */
data class TeamRankingItem(
    val rank: Int = 0,
    val teamName: String = "",
    val totalScore: Double = 0.0,
    val impressionCount: Double = 0.0,
    val medianScore: Double = 0.0,
    val lastUpdated: Long = 0,
    
    // 团队作品信息
    val title1: String = "",
    val artist1: String = "",
    val finalStriker1: String = "",
    val score1: Double = 0.0, // 作品1分数
    val title2: String = "",
    val artist2: String = "",
    val finalStriker2: String = "",
    val score2: Double = 0.0, // 作品2分数
    val title3: String = "",
    val artist3: String = "",
    val finalStriker3: String = "",
    val score3: Double = 0.0, // 作品3分数
    val title4: String = "",
    val artist4: String = "",
    val finalStriker4: String = "",
    val score4: Double = 0.0, // 作品4分数
    
    // 对比数据（如果有）
    val compareTotalScore: Double? = null,
    val compareImpressionCount: Double? = null,
    val compareMedianScore: Double? = null,
    val compareScore1: Double? = null, // 对比作品1分数
    val compareScore2: Double? = null, // 对比作品2分数
    val compareScore3: Double? = null, // 对比作品3分数
    val compareScore4: Double? = null, // 对比作品4分数
    val compareRank: Int? = null,
    val rankChange: Int? = null // 正数表示排名上升，负数表示排名下降
) {
    fun getFormattedImpressionCount(): String = "%.0f".format(impressionCount)
}
