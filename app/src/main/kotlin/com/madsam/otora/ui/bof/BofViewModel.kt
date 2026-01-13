package com.madsam.otora.ui.bof

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.core.utils.DateTimeUtils
import com.madsam.otora.data.bof.local.api.BofLocalService
import com.madsam.otora.data.bof.local.model.BofWorkEntity
import com.madsam.otora.data.bof.local.repository.BofRepository
import com.madsam.otora.data.bof.local.repository.WorkRanking
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
            boxStore.boxFor(BofWorkEntity::class.java),
            boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofWorkScoreHistoryEntity::class.java),
            boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofWorkTitleHistoryEntity::class.java),
            boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofWorkArtistHistoryEntity::class.java),
            boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofTeamScoreHistoryEntity::class.java),
            boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofTeamTitleHistoryEntity::class.java),
            boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofTeamArtistHistoryEntity::class.java),
            boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofTeamFinalStrikerHistoryEntity::class.java)
        )
    }
    val commentData = MutableStateFlow(listOf<BofCommentUI>())

    // 新的团队排行数据流
    val teamRankingData = MutableStateFlow(listOf<TeamRankingItem>())
    val teamDiffRankingData = MutableStateFlow(listOf<TeamRankingItem>()) // 团队差值排行
    val teamReverseDiffRankingData = MutableStateFlow(listOf<TeamRankingItem>()) // 团队逆差值排行
    val isTeamRankingLoading = MutableStateFlow(false)
    val teamRankingError = MutableStateFlow("")
    
    // Comment 差值数据流
    val commentDiffData = MutableStateFlow(listOf<BofCommentUI>()) // 评价差值排行
    val commentReverseDiffData = MutableStateFlow(listOf<BofCommentUI>()) // 评价逆差值排行

    // 新的排名数据流
    val totalRankingData = MutableStateFlow(listOf<WorkRanking>())
    val avgRankingData = MutableStateFlow(listOf<WorkRanking>())
    val medianRankingData = MutableStateFlow(listOf<WorkRanking>())
    val diffRankingData = MutableStateFlow(listOf<WorkRanking>())
    val reverseDiffRankingData = MutableStateFlow(listOf<WorkRanking>()) // 逆差值排行数据
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

    var selectedTimeStrNoComp = MutableStateFlow("")

    // 搜索相关状态
    val searchText = MutableStateFlow("")
    val matchedIndices = MutableStateFlow(listOf<Int>()) // 匹配的索引列表
    val currentMatchIndex = MutableStateFlow(0) // 当前高亮的匹配项索引（在matchedIndices中的位置）

    /**
     * 执行搜索，根据当前 tab 页搜索对应的列表
     * @param query 搜索关键字
     * @param tabIndex 当前 tab 索引 (0=总分, 1=平均分, 2=中位数, 3=差值, 4=综合, 5=团队, 6=评论)
     */
    fun search(query: String, tabIndex: Int) {
        Log.d(TAG, "search called: query='$query', tabIndex=$tabIndex")
        
        if (query.isBlank()) {
            matchedIndices.update { emptyList() }
            currentMatchIndex.update { 0 }
            searchText.update { "" }
            Log.d(TAG, "Search cleared")
            return
        }
        
        searchText.update { query }
        val lowerQuery = query.lowercase()
        
        // 根据 tab 页获取对应的数据列表并搜索
        val indices = when (tabIndex) {
            0 -> { // 总分排行
                totalRankingData.value.mapIndexedNotNull { index, item ->
                    if (item.title.lowercase().contains(lowerQuery) || 
                        item.artist.lowercase().contains(lowerQuery)) {
                        index
                    } else null
                }
            }
            1 -> { // 平均分排行
                avgRankingData.value.mapIndexedNotNull { index, item ->
                    if (item.title.lowercase().contains(lowerQuery) || 
                        item.artist.lowercase().contains(lowerQuery)) {
                        index
                    } else null
                }
            }
            2 -> { // 中位数排行
                medianRankingData.value.mapIndexedNotNull { index, item ->
                    if (item.title.lowercase().contains(lowerQuery) || 
                        item.artist.lowercase().contains(lowerQuery)) {
                        index
                    } else null
                }
            }
            3 -> { // 差值排行
                diffRankingData.value.mapIndexedNotNull { index, item ->
                    if (item.title.lowercase().contains(lowerQuery) || 
                        item.artist.lowercase().contains(lowerQuery)) {
                        index
                    } else null
                }
            }
            4 -> { // 综合排行
                compositeRankingData.value.mapIndexedNotNull { index, item ->
                    if (item.title.lowercase().contains(lowerQuery) || 
                        item.artist.lowercase().contains(lowerQuery)) {
                        index
                    } else null
                }
            }
            5 -> { // 团队排行
                teamRankingData.value.mapIndexedNotNull { index, item ->
                    if (item.teamName.lowercase().contains(lowerQuery) ||
                        item.title1.lowercase().contains(lowerQuery) ||
                        item.artist1.lowercase().contains(lowerQuery) ||
                        item.title2.lowercase().contains(lowerQuery) ||
                        item.artist2.lowercase().contains(lowerQuery) ||
                        item.title3.lowercase().contains(lowerQuery) ||
                        item.artist3.lowercase().contains(lowerQuery) ||
                        item.title4.lowercase().contains(lowerQuery) ||
                        item.artist4.lowercase().contains(lowerQuery)) {
                        index
                    } else null
                }
            }
            6 -> { // 评论
                commentData.value.mapIndexedNotNull { index, item ->
                    if (item.user.lowercase().contains(lowerQuery)) {
                        index
                    } else null
                }
            }
            else -> emptyList()
        }
        
        Log.d(TAG, "Search found ${indices.size} matches for query '$query' in tab $tabIndex")
        matchedIndices.update { indices }
        currentMatchIndex.update { if (indices.isNotEmpty()) 0 else -1 }
        
        if (indices.isNotEmpty()) {
            Log.d(TAG, "First match at index: ${indices[0]}")
        }
    }
    
    /**
     * 跳转到上一个匹配项
     */
    fun scrollToPrevious() {
        val indices = matchedIndices.value
        if (indices.isEmpty()) {
            Log.d(TAG, "scrollToPrevious: no matches")
            return
        }
        
        val current = currentMatchIndex.value
        val newIndex = if (current > 0) current - 1 else indices.size - 1
        currentMatchIndex.update { newIndex }
        Log.d(TAG, "scrollToPrevious: $current -> $newIndex (list index: ${indices[newIndex]})")
    }
    
    /**
     * 跳转到下一个匹配项
     */
    fun scrollToNext() {
        val indices = matchedIndices.value
        if (indices.isEmpty()) {
            Log.d(TAG, "scrollToNext: no matches")
            return
        }
        
        val current = currentMatchIndex.value
        val newIndex = if (current < indices.size - 1) current + 1 else 0
        currentMatchIndex.update { newIndex }
        Log.d(TAG, "scrollToNext: $current -> $newIndex (list index: ${indices[newIndex]})")
    }

    suspend fun requestCommentData() {
        // 获取当前选中的 Range
        val selectedRange = bofScreenState.selectedRange.value
        
        if (selectedRange == null) {
            Log.d(TAG, "No range selected")
            return
        }
        
        // 计算当前时间戳
        val currentTimestamp = if (selectedRange.singleComment) {
            val dateToFetch = if (selectedRange.commentDate.isNotEmpty()) {
                selectedRange.commentDate
            } else {
                bofScreenState.selectedCurrentDate.value.toString()
            }
            DateTimeUtils.ymdToMillis(dateToFetch, "00:00")
        } else {
            DateTimeUtils.ymdToMillis(
                bofScreenState.selectedCurrentDate.value.toString(),
                DateTimeUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCurrentTime.value)
            )
        }
        
        // 计算对比时间戳（如果选择了对比时间）
        val compareTimestamp = if (bofScreenState.selectedCompareTime.value != "-1") {
            DateTimeUtils.ymdToMillis(
                bofScreenState.selectedCompareDate.value.toString(),
                DateTimeUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCompareTime.value)
            )
        } else null
        
        // 加载当前时间点的数据
        val data = if (selectedRange.singleComment) {
            val dateToFetch = if (selectedRange.commentDate.isNotEmpty()) {
                selectedRange.commentDate
            } else {
                bofScreenState.selectedCurrentDate.value.toString()
            }
            bofLocalService.getCommentByTime(dateToFetch)
        } else {
            bofLocalService.getCommentTimeSeries(selectedRange.path, currentTimestamp)
        }
        
        if (data.isEmpty()) {
            Log.d(TAG, "No comment data available for the selected date and time.")
            commentData.update { emptyList() }
            return
        }
        
        // 如果有对比时间，加载对比数据
        val compareData = if (compareTimestamp != null && !selectedRange.singleComment) {
            bofLocalService.getCommentTimeSeries(selectedRange.path, compareTimestamp)
        } else null
        
        // 创建对比数据映射
        val compareMap = compareData?.associateBy { it.user } ?: emptyMap()
        
        // 填充对比数据
        val dataWithCompare = data.map { comment ->
            val compareComment = compareMap[comment.user]
            comment.apply {
                compareTotal = compareComment?.total
            }
        }
        
        // 排序并设置排名
        val updatedData = dataWithCompare.sortedWith(compareByDescending(BofCommentUI::total)
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
        
        // 更新显示的时间字符串
        if (selectedRange.singleComment) {
            selectedTimeStrNoComp.update { 
                if (selectedRange.commentDate.isNotEmpty()) {
                    selectedRange.commentDate
                } else {
                    bofScreenState.selectedCurrentDate.value.toString()
                }
            }
        } else {
            selectedTimeStrNoComp.update { 
                "${bofScreenState.selectedCurrentDate.value} ${DateTimeUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCurrentTime.value)}"
            }
        }
    }

    // JSON解析加载 - 支持两时间点对比
    fun loadRankingData() {
        viewModelScope.launch {
            try {
                isLoading.update { true }
                errorMessage.update { "" }
                
                // 计算当前时间戳（主排序时间点）
                val currentTimestamp = DateTimeUtils.ymdToMillis(
                    bofScreenState.selectedCurrentDate.value.toString(),
                    DateTimeUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCurrentTime.value)
                )
                
                // 计算对比时间戳
                val compareTimestamp = DateTimeUtils.ymdToMillis(
                    bofScreenState.selectedCompareDate.value.toString(),
                    DateTimeUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCompareTime.value)
                )
                
                // 使用支持对比的一次性处理
                bofRepository.getRankingAtTime(
                    currentTimestamp = currentTimestamp,
                    compareTimestamp = compareTimestamp,
                    path = bofScreenState.selectedRange.value?.path?:""
                ) { currentResults ->
                    // 确保在主线程上更新 UI 状态，避免帧顺序混乱
                    withContext(Dispatchers.Main.immediate) {
                        Log.d(TAG, "Loaded full ranking data with comparison: ${currentResults.size} works")
                        val normalizedResults = applyTieAwareTotalRanking(currentResults)
                        totalRankingData.update { normalizedResults }
                        
                        if (currentResults.isNotEmpty()) {
                            isLoading.update { false }
                        }
                    }
                }
                
                if (totalRankingData.value.isEmpty()) {
                    errorMessage.update { "该时间点暂无排名数据" }
                } else {
                    generateCompositeRanking()
                    generateDifferenceRanking()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load ranking data with streamed parsing and comparison", e)
                errorMessage.update { "加载失败: ${e.message}" }
                totalRankingData.update { emptyList() }
            } finally {
                // 确保加载状态最终被设置为false
                if (isLoading.value) {
                    isLoading.update { false }
                }
            }
        }
    }
    
    // 获取当前选择的时间字符串 - 支持对比时间显示
    fun getSelectedTimeString(): String {
        val currentTime = DateTimeUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCurrentTime.value)
        val compareTime = DateTimeUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCompareTime.value)
        
        return "当前: ${bofScreenState.selectedCurrentDate.value} $currentTime | 对比: ${bofScreenState.selectedCompareDate.value} $compareTime"
    }
    
    // 基于总分排行数据生成平均分排行数据
    private fun generateAverageRanking(totalData: List<WorkRanking>, minImpression: Int): List<WorkRanking> {
        // 过滤符合条件的数据
        val filteredData = totalData.filter { it.impression >= minImpression && it.average > 0 }
        
        // 按平均分降序排列
        val sortedByAverage = filteredData.sortedByDescending { it.average }
        val compareAverageRankMap = buildCompareRankMap(
            totalData = totalData,
            minImpression = minImpression,
            valueSelector = { it.compareAverage },
            impressionSelector = { it.compareImpression }
        )
        
        // 重新分配排名并计算平均分排名变化（同分同排名）
        var currentRank = 1
        var previousAverage: Double? = null
        return sortedByAverage.mapIndexed { index, ranking -> 
            // 如果分数与前一个不同，更新排名为当前位置+1
            if (previousAverage != null && ranking.average != previousAverage) {
                currentRank = index + 1
            }
            previousAverage = ranking.average
            val newRank = currentRank
            
            // 计算平均分排名变化
            val compareRankInAverage = compareAverageRankMap[ranking.workId]
            
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
        val compareMedianRankMap = buildCompareRankMap(
            totalData = totalData,
            minImpression = minImpression,
            valueSelector = { it.compareMedian },
            impressionSelector = { it.compareImpression }
        )
        
        // 重新分配排名并计算中位数排名变化（同分同排名）
        var currentRank = 1
        var previousMedian: Double? = null
        return sortedByMedian.mapIndexed { index, ranking -> 
            // 如果分数与前一个不同，更新排名为当前位置+1
            if (previousMedian != null && ranking.median != previousMedian) {
                currentRank = index + 1
            }
            previousMedian = ranking.median
            val newRank = currentRank
            
            // 计算中位数排名变化
            val compareRankInMedian = compareMedianRankMap[ranking.workId]
            
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

    private fun applyTieAwareTotalRanking(results: List<WorkRanking>): List<WorkRanking> {
        if (results.isEmpty()) return results

        val rankByWorkId = mutableMapOf<String, Int>()
        val sortedByScore = results.sortedByDescending { it.score }
        var currentRank = 1
        var previousScore: Int? = null
        sortedByScore.forEachIndexed { index, ranking ->
            if (previousScore != null && ranking.score != previousScore) {
                currentRank = index + 1
            }
            previousScore = ranking.score
            rankByWorkId[ranking.workId] = currentRank
        }

        val compareRankMap = buildCompareRankMap(
            totalData = results,
            minImpression = 1,
            valueSelector = { it.compareScore?.toDouble() },
            impressionSelector = { it.compareImpression }
        )

        return results.map { ranking ->
            val newRank = rankByWorkId[ranking.workId] ?: ranking.rank
            val compareRank = compareRankMap[ranking.workId]
            ranking.copy(
                rank = newRank,
                compareRank = compareRank,
                rankChange = compareRank?.let { it - newRank }
            )
        }
    }

    private fun buildCompareRankMap(
        totalData: List<WorkRanking>,
        minImpression: Int,
        valueSelector: (WorkRanking) -> Double?,
        impressionSelector: (WorkRanking) -> Int?
    ): Map<String, Int> {
        val compareCandidates = totalData.filter { data ->
            val value = valueSelector(data)
            val impression = impressionSelector(data) ?: 0
            value != null && value > 0 && impression >= minImpression
        }

        if (compareCandidates.isEmpty()) return emptyMap()

        val sortedCandidates = compareCandidates.sortedByDescending { valueSelector(it)!! }
        val rankMap = mutableMapOf<String, Int>()
        var currentRank = 1
        var previousValue: Double? = null

        sortedCandidates.forEachIndexed { index, item ->
            val score = valueSelector(item)!!
            if (previousValue != null && score != previousValue) {
                currentRank = index + 1
            }
            previousValue = score
            rankMap[item.workId] = currentRank
        }

        return rankMap
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
                
                // 创建对比排名和分数映射（同分同排名）
                var compareRankCounter = 1
                var previousCompareScore: Double? = null
                compareCompositeData.forEachIndexed { index, (workId, score, _) ->
                    if (previousCompareScore != null && score != previousCompareScore) {
                        compareRankCounter = index + 1
                    }
                    previousCompareScore = score
                    compareCompositeMap[workId] = compareRankCounter
                    compareCompositeScoreMap[workId] = score
                }
            }
        }
        
        // 重新分配排名并计算排名变化（同分同排名）
        var currentRank = 1
        var previousScore: Double? = null
        return currentCompositeData.mapIndexed { index, ranking ->
            // 如果综合分数与前一个不同，更新排名为当前位置+1
            val currentScore = ranking.compositeScore ?: ranking.score.toDouble()
            if (previousScore != null && currentScore != previousScore) {
                currentRank = index + 1
            }
            previousScore = currentScore
            
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
                val (diffData, reverseDiffData) = generateDifferenceRankingFromTotal(totalData)
                Pair(diffData, reverseDiffData)
            }.collect { (diffData, reverseDiffData) ->
                diffRankingData.update { diffData }
                reverseDiffRankingData.update { reverseDiffData }
            }
        }
    }
    
    private fun generateDifferenceRankingFromTotal(totalData: List<WorkRanking>): Pair<List<WorkRanking>, List<WorkRanking>> {
        // 过滤有对比数据的作品，并计算分数差值
        val diffDataRaw = totalData.mapNotNull { ranking ->
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
        }
        
        // 正差值排行（增长）- 只显示正数
        val diffData = diffDataRaw
            .filter { it.score > 0 } // 只保留增长的作品
            .sortedByDescending { it.score } // 按分数差值降序排列
        
        // 逆差值排行（减少）- 只显示负数，并转为正数显示
        val reverseDiffData = diffDataRaw
            .filter { it.score < 0 } // 只保留减少的作品
            .sortedBy { it.score } // 按分数差值升序排列（最负的在前）
            .map { ranking ->
                // 将负数转换为正数显示
                ranking.copy(
                    score = -ranking.score, // 负数变正数
                    average = -ranking.average, // 负数变正数
                    median = -ranking.median, // 负数变正数
                    impression = -ranking.impression // 负数变正数
                )
            }
        
        // 重新分配排名（同分同排名）
        fun assignRanks(data: List<WorkRanking>): List<WorkRanking> {
            var currentRank = 1
            var previousScore: Int? = null
            return data.mapIndexed { index, ranking ->
                // 如果分数差值与前一个不同，更新排名为当前位置+1
                if (previousScore != null && ranking.score != previousScore) {
                    currentRank = index + 1
                }
                previousScore = ranking.score
                ranking.copy(rank = currentRank)
            }
        }
        
        return Pair(assignRanks(diffData), assignRanks(reverseDiffData))
    }

    /**
     * 生成 Team 差值排行
     * 基于当前的 teamRankingData，只计算总分变化
     */
    fun generateTeamDifferenceRanking() {
        viewModelScope.launch {
            val currentTeams = teamRankingData.value
            
            if (currentTeams.isEmpty()) {
                teamDiffRankingData.update { emptyList() }
                teamReverseDiffRankingData.update { emptyList() }
                Log.d(TAG, "No team data available for difference ranking")
                return@launch
            }
            
            // 计算差值数据
            val diffDataRaw = currentTeams.mapNotNull { team ->
                val compareScore = team.compareTotalScore
                if (compareScore != null && compareScore > 0.0) {
                    val scoreDiff = team.totalScore - compareScore
                    team.copy(
                        totalScore = scoreDiff, // 将差值存储为 totalScore
                        rank = 0 // 稍后分配
                    )
                } else null
            }.filter { 
                kotlin.math.abs(it.totalScore) > 0 // 只显示有变化的团队
            }
            
            // 正差值排行（增长）- 只保留正数
            val diffData = diffDataRaw
                .filter { it.totalScore > 0 }
                .sortedByDescending { it.totalScore }
            
            // 逆差值排行（减少）- 只保留负数，转为正数显示
            val reverseDiffData = diffDataRaw
                .filter { it.totalScore < 0 }
                .sortedBy { it.totalScore } // 按差值升序（最负的在前）
                .map { it.copy(totalScore = -it.totalScore) } // 转为正数
            
            // 重新分配排名
            fun assignTeamRanks(data: List<TeamRankingItem>): List<TeamRankingItem> {
                var currentRank = 1
                var previousScore: Double? = null
                return data.mapIndexed { index, team ->
                    if (previousScore != null && kotlin.math.abs(team.totalScore - previousScore!!) > 0.01) {
                        currentRank = index + 1
                    }
                    previousScore = team.totalScore
                    team.copy(rank = currentRank)
                }
            }
            
            teamDiffRankingData.update { assignTeamRanks(diffData) }
            teamReverseDiffRankingData.update { assignTeamRanks(reverseDiffData) }
            
            Log.d(TAG, "Team difference ranking generated: ${diffData.size} increases, ${reverseDiffData.size} decreases")
        }
    }
    
    /**
     * 生成 Comment 差值排行
     * 基于当前的 commentData，只计算总分变化
     */
    fun generateCommentDifferenceRanking() {
        viewModelScope.launch {
            val currentComments = commentData.value
            
            if (currentComments.isEmpty()) {
                commentDiffData.update { emptyList() }
                commentReverseDiffData.update { emptyList() }
                Log.d(TAG, "No comment data available for difference ranking")
                return@launch
            }
            
            // 计算差值数据
            val diffDataRaw = currentComments.mapNotNull { comment ->
                val compareTotal = comment.compareTotal
                if (compareTotal != null && compareTotal > 0) {
                    val totalDiff = comment.total - compareTotal
                    comment.copy(
                        total = totalDiff, // 将差值存储为 total
                        index = 0 // 稍后分配
                    )
                } else null
            }.filter {
                kotlin.math.abs(it.total) > 0 // 只显示有变化的评论
            }
            
            // 正差值排行（增长）- 只保留正数
            val diffData = diffDataRaw
                .filter { it.total > 0 }
                .sortedByDescending { it.total }
            
            // 逆差值排行（减少）- 只保留负数，转为正数显示
            val reverseDiffData = diffDataRaw
                .filter { it.total < 0 }
                .sortedBy { it.total } // 按差值升序（最负的在前）
                .map { it.copy(total = -it.total) } // 转为正数
            
            // 重新分配排名
            fun assignCommentIndexes(data: List<BofCommentUI>): List<BofCommentUI> {
                var currentIndex = 1
                var previousTotal: Int? = null
                return data.mapIndexed { index, comment ->
                    if (previousTotal != null && comment.total != previousTotal) {
                        currentIndex = index + 1
                    }
                    previousTotal = comment.total
                    comment.copy(index = currentIndex)
                }
            }
            
            commentDiffData.update { assignCommentIndexes(diffData) }
            commentReverseDiffData.update { assignCommentIndexes(reverseDiffData) }
            
            Log.d(TAG, "Comment difference ranking generated: ${diffData.size} increases, ${reverseDiffData.size} decreases")
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
                    DateTimeUtils.ymdToMillis(
                        bofScreenState.selectedCurrentDate.value.toString(),
                        DateTimeUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCurrentTime.value)
                    )
                }
                
                // 计算对比时间戳（可选）
                val compareTimestamp = if (bofScreenState.selectedCompareTime.value == "-1") {
                    null
                } else {
                    DateTimeUtils.ymdToMillis(
                        bofScreenState.selectedCompareDate.value.toString(),
                        DateTimeUtils.roundDownToNearestFiveMinutes(bofScreenState.selectedCompareTime.value)
                    )
                }
                
                Log.d(TAG, "Team ranking - Current timestamp: $currentTimestamp, Compare timestamp: $compareTimestamp")

                // 使用新的索引表结构，一次性返回全部团队数据
                bofRepository.getTeamRankingAtTimeStreamed(
                    currentTimestamp = currentTimestamp,
                    compareTimestamp = compareTimestamp,
                    path = path
                ) { currentResults ->
                    // 确保在主线程上更新 UI 状态，避免帧顺序混乱
                    withContext(Dispatchers.Main.immediate) {
                        Log.d(TAG, "Team ranking loaded: ${currentResults.size} teams")
                        val normalizedTeams = applyTieAwareTeamRanking(currentResults)
                        teamRankingData.update { normalizedTeams }
                        
                        if (currentResults.isNotEmpty()) {
                            Log.d(TAG, "Team data loaded, setting isLoading to false")
                            isTeamRankingLoading.update { false }
                        }
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

    private fun applyTieAwareTeamRanking(teamData: List<TeamRankingItem>): List<TeamRankingItem> {
        if (teamData.isEmpty()) return teamData

        val rankByTeam = mutableMapOf<String, Int>()
        var currentRank = 1
        var previousScore: Double? = null
        teamData.sortedByDescending { it.totalScore }.forEachIndexed { index, team ->
            if (previousScore != null && team.totalScore != previousScore) {
                currentRank = index + 1
            }
            previousScore = team.totalScore
            rankByTeam[team.teamName] = currentRank
        }

        val compareRankByTeam = mutableMapOf<String, Int>()
        var compareRankCounter = 1
        var previousCompareScore: Double? = null
        teamData
            .filter { (it.compareTotalScore ?: 0.0) > 0.0 }
            .sortedByDescending { it.compareTotalScore!! }
            .forEachIndexed { index, team ->
                val score = team.compareTotalScore!!
                if (previousCompareScore != null && score != previousCompareScore) {
                    compareRankCounter = index + 1
                }
                previousCompareScore = score
                compareRankByTeam[team.teamName] = compareRankCounter
            }

        return teamData.map { team ->
            val newRank = rankByTeam[team.teamName] ?: team.rank
            val compareRank = compareRankByTeam[team.teamName]
            team.copy(
                rank = newRank,
                compareRank = compareRank,
                rankChange = compareRank?.let { it - newRank }
            )
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
