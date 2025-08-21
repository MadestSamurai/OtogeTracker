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
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.math.max

private const val TAG = "BofViewModel"

internal class BofViewModel(
    private val bofScreenState: BofScreenState
) : ViewModel() {
    init {
        Log.d(TAG, "BofViewModel init started")
    }
    
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
    val isLoading = MutableStateFlow(false)
    val errorMessage = MutableStateFlow("")

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

    // 新的排名数据加载方法 - 异步版本
    fun loadRankingDataAsync() {
        Log.d(TAG, "loadRankingDataAsync called")
        viewModelScope.launch {
            try {
                Log.d(TAG, "Starting data loading - setting isLoading to true")
                isLoading.update { true }
                errorMessage.update { "" }
                
                // 使用选择的时间戳
                val timestamp = if (bofScreenState.selectedCurrentTime.value == "-1") {
                    // 如果没有选择时间，使用当前时间戳
                    System.currentTimeMillis()
                } else {
                    // 使用选择的日期和时间
                    CommonUtils.ymdToMillis(
                        bofScreenState.selectedCurrentDate.value.toString(),
                        CommonUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCurrentTime.value)
                    )
                }
                
                Log.d(TAG, "About to call bofRepository.getRankingAtTime with timestamp: $timestamp")
                val startTime = System.currentTimeMillis()
                val rankings = bofRepository.getRankingAtTime(timestamp)
                val endTime = System.currentTimeMillis()
                Log.d(TAG, "bofRepository.getRankingAtTime completed in ${endTime - startTime}ms, got ${rankings.size} rankings")
                
                totalRankingData.update { rankings }
                
                if (rankings.isEmpty()) {
                    errorMessage.update { "该时间点暂无排名数据" }
                }
                
                Log.d(TAG, "Data loading completed successfully")
                
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load ranking data", e)
                errorMessage.update { "加载失败: ${e.message}" }
                totalRankingData.update { emptyList() }
            } finally {
                Log.d(TAG, "Setting isLoading to false")
                isLoading.update { false }
            }
        }
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
    
    // 兼容性方法 - 同步调用异步版本
    fun loadRankingData() {
        loadRankingDataAsync()
    }
    
    fun refreshData() {
        loadRankingDataAsync()
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
