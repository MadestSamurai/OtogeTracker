package com.madsam.otora.ui.settings

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.data.BOF_URL
import com.madsam.otora.data.bof.local.model.BofWorkEntity
import com.madsam.otora.data.bof.local.objectbox.BofObjectBoxService
import com.madsam.otora.data.bof.local.repository.BofRepository
import com.madsam.otora.data.bof.remote.api.BofAPI
import com.madsam.otora.data.bof.remote.model.BofWorkData
import com.madsam.otora.data.bof.remote.model.BofWorkResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * BOF 数据更新页面的 ViewModel
 */
class BOFDataUpdateViewModel : ViewModel() {
    companion object {
        private const val TAG = "BOFDataUpdateViewModel"
    }

    // UI 状态
    private val _uiState = MutableStateFlow(BOFUpdateUiState())
    val uiState: StateFlow<BOFUpdateUiState> = _uiState.asStateFlow()
    
    // 仓库
    private val bofRepository by lazy {
        val boxStore = ObjectBoxManager.getBoxStore()
        val bofWorkBox = boxStore.boxFor(BofWorkEntity::class.java)
        val scoreHistoryBox = boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofWorkScoreHistoryEntity::class.java)
        val titleHistoryBox = boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofWorkTitleHistoryEntity::class.java)
        val artistHistoryBox = boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofWorkArtistHistoryEntity::class.java)
        val teamScoreHistoryBox = boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofTeamScoreHistoryEntity::class.java)
        val teamTitleHistoryBox = boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofTeamTitleHistoryEntity::class.java)
        val teamArtistHistoryBox = boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofTeamArtistHistoryEntity::class.java)
        val teamFinalStrikerHistoryBox = boxStore.boxFor(com.madsam.otora.data.bof.local.model.BofTeamFinalStrikerHistoryEntity::class.java)
        BofRepository(
            bofWorkBox, 
            scoreHistoryBox, 
            titleHistoryBox, 
            artistHistoryBox,
            teamScoreHistoryBox,
            teamTitleHistoryBox,
            teamArtistHistoryBox,
            teamFinalStrikerHistoryBox
        )
    }
    
    // ObjectBox服务
    private val bofObjectBoxService by lazy {
        BofObjectBoxService()
    }

    // Retrofit API
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BOF_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    private val api = retrofit.create(BofAPI::class.java)

    init {
        // 初始化时加载可用的比赛列表
        loadAvailableCompetitions()
    }

    /**
     * 从网络下载 Range 数据
     */
    fun downloadRangeData() {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(
                    isLoadingCompetitions = true,
                    message = "正在从网络下载 Range 数据...",
                    isError = false
                )
                
                // 调用API下载Range数据
                val response = withContext(Dispatchers.IO) {
                    api.getBofRangeData().execute()
                }
                
                if (!response.isSuccessful) {
                    throw Exception("Range 数据API请求失败: ${response.code()} - ${response.message()}")
                }
                
                val rangeDataList = response.body()
                if (rangeDataList == null) {
                    throw Exception("Range 数据API响应为空")
                }
                
                // 保存到数据库
                bofObjectBoxService.saveBofRangeData(rangeDataList)
                
                Log.d(TAG, "Successfully downloaded and saved ${rangeDataList.size} range data")
                
                // 下载完成后重新加载列表
                loadAvailableCompetitions()
                
                _uiState.value = _uiState.value.copy(
                    message = "成功从网络下载 ${rangeDataList.size} 个比赛的 Range 数据",
                    isError = false
                )
                
            } catch (e: Exception) {
                Log.e(TAG, "Failed to download range data", e)
                _uiState.value = _uiState.value.copy(
                    isLoadingCompetitions = false,
                    message = "下载 Range 数据失败: ${e.message}",
                    isError = true
                )
            }
        }
    }
    
    /**
     * 加载可用的比赛列表（从本地数据库）
     */
    fun loadAvailableCompetitions() {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoadingCompetitions = true)
                
                // 获取数据库中的range数据
                val competitions = bofObjectBoxService.getAllAvailableCompetitions()
                
                // 转换为UI显示项目
                val competitionItems = competitions.map { range ->
                    // 每个比赛都获取作品数量、团队数量和评论数量
                    val workCount = bofRepository.getWorksCount(range.path)
                    val teamCount = bofRepository.getTeamCount(range.path)
                    // 根据比赛配置使用正确的日期来获取评论数量
                    val dateToCheck = range.commentDate.ifEmpty {
                        range.current.ifEmpty { "2025-01-08" }
                    }
                    val commentCount = try {
                        runBlocking { bofObjectBoxService.getCommentCount(dateToCheck) }
                    } catch (e: Exception) {
                        Log.w(TAG, "Failed to get comment count for ${range.path} on date $dateToCheck: ${e.message}")
                        0L
                    }
                    val totalDataCount = workCount + teamCount + commentCount
                    
                    val lastUpdatedText = if (totalDataCount > 0) {
                        java.text.SimpleDateFormat("yyyy-MM-dd HH:mm", java.util.Locale.getDefault())
                            .format(java.util.Date(range.lastUpdated))
                    } else {
                        "无数据"
                    }
                    
                    CompetitionUpdateItem(
                        path = range.path,
                        shortName = range.shortName.ifEmpty { range.path },
                        fullName = range.fullName.ifEmpty { range.path },
                        isStart = range.isStart,
                        isEnd = range.isEnd,
                        hasData = totalDataCount > 0,
                        dataCount = totalDataCount,
                        lastUpdated = lastUpdatedText,
                        startTime = range.start,
                        endTime = range.current,
                        // 添加详细的数据统计信息
                        workCount = workCount,
                        teamCount = teamCount,
                        commentCount = commentCount
                    )
                }.sortedWith(
                    compareByDescending { it.startTime }
                )
                
                _uiState.value = _uiState.value.copy(
                    availableCompetitions = competitionItems,
                    isLoadingCompetitions = false
                )
                
                Log.d(TAG, "Loaded ${competitionItems.size} available competitions")
                
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load available competitions", e)
                _uiState.value = _uiState.value.copy(
                    isLoadingCompetitions = false,
                    message = "加载比赛列表失败: ${e.message}",
                    isError = true
                )
            }
        }
    }

    /**
     * 下载并保存指定比赛类型的BOF数据
     * 每个比赛都会同时下载作品数据和团队数据
     */
    fun downloadBofData(competitionPath: String, competitionName: String) {
        viewModelScope.launch {
            try {
                // 更新比赛项目状态为更新中
                updateCompetitionItemStatus(competitionPath, isUpdating = true)
                
                // 更新UI状态为下载中
                _uiState.value = _uiState.value.copy(
                    isLoading = true,
                    message = "正在下载 $competitionName 数据...",
                    isError = false
                )

                // 每个比赛都同时下载作品数据和团队数据
                var workCount = 0L
                var teamCount = 0L
                val errors = mutableListOf<String>()

                // 下载作品数据
                try {
                    _uiState.value = _uiState.value.copy(
                        message = "正在下载 $competitionName 作品数据..."
                    )
                    workCount = downloadWorkData(competitionPath, competitionName)
                } catch (e: Exception) {
                    val errorMsg = "作品数据下载失败: ${e.message}"
                    Log.e(TAG, errorMsg, e)
                    errors.add(errorMsg)
                }

                // 下载团队数据
                try {
                    _uiState.value = _uiState.value.copy(
                        message = "正在下载 $competitionName 团队数据..."
                    )
                    teamCount = downloadTeamData(competitionPath, competitionName)
                } catch (e: Exception) {
                    val errorMsg = "团队数据下载失败: ${e.message}"
                    Log.e(TAG, errorMsg, e)
                    errors.add(errorMsg)
                }

                // 下载评论数据
                var commentCount = 0L
                try {
                    _uiState.value = _uiState.value.copy(
                        message = "正在下载 $competitionName 评论数据..."
                    )
                    commentCount = downloadCommentData(competitionPath, competitionName)
                } catch (e: Exception) {
                    val errorMsg = "评论数据下载失败: ${e.message}"
                    Log.e(TAG, errorMsg, e)
                    errors.add(errorMsg)
                }

                // 更新完成状态
                if (errors.isEmpty()) {
                    // 全部成功
                    val successMsg = mutableListOf<String>()
                    if (workCount > 0) successMsg.add("${workCount}部作品")
                    if (teamCount > 0) successMsg.add("${teamCount}个团队") 
                    if (commentCount > 0) successMsg.add("${commentCount}条评论")
                    
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        message = "成功保存 $competitionName 数据: ${successMsg.joinToString(", ")}",
                        isError = false
                    )
                } else if (workCount > 0 || teamCount > 0 || commentCount > 0) {
                    // 部分成功
                    val successMsg = mutableListOf<String>()
                    if (workCount > 0) successMsg.add("${workCount}部作品")
                    if (teamCount > 0) successMsg.add("${teamCount}个团队")
                    if (commentCount > 0) successMsg.add("${commentCount}条评论")
                    
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        message = "$competitionName 部分成功: ${successMsg.joinToString(", ")}。错误: ${errors.joinToString("; ")}",
                        isError = true
                    )
                } else {
                    // 全部失败
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        message = "$competitionName 下载失败: ${errors.joinToString("; ")}",
                        isError = true
                    )
                }

                // 重新加载比赛列表以更新数据统计
                loadAvailableCompetitions()

                Log.d(TAG, "Download completed for $competitionName: $workCount works, $teamCount teams")

            } catch (e: Exception) {
                Log.e(TAG, "Failed to download $competitionName data", e)
                
                // 更新状态为错误
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    message = "下载 $competitionName 失败: ${e.message}",
                    isError = true
                )
            } finally {
                // 取消比赛项目的更新状态
                updateCompetitionItemStatus(competitionPath, isUpdating = false)
            }
        }
    }
    
    /**
     * 下载作品数据
     * @return 保存的作品数量
     */
    private suspend fun downloadWorkData(competitionPath: String, competitionName: String): Long {
        // 调用API
        val response = withContext(Dispatchers.IO) {
            api.getBofWorkData(competitionPath).execute()
        }

        if (!response.isSuccessful) {
            throw Exception("作品数据API请求失败: ${response.code()} - ${response.message()}")
        }

        val worksMap = response.body()
        if (worksMap == null) {
            throw Exception("作品数据API响应为空")
        }

        // 转换Map格式到BofWorkResponse
        val worksAsMap = worksMap.mapValues { (workId: String, workData: BofWorkData) ->
            workData.copy(id = workId)
        }
        val bofData = BofWorkResponse(works = worksAsMap)

        // 保存数据到Repository
        bofRepository.saveBofApiResponse(bofData, competitionPath)
        val savedCount = bofRepository.getWorksCount(competitionPath)

        Log.d(TAG, "Successfully downloaded and saved $savedCount $competitionName works")
        return savedCount
    }
    
    /**
     * 下载团队数据
     * @return 保存的团队数量
     */
    private suspend fun downloadTeamData(competitionPath: String, competitionName: String): Long {
        // 调用团队API
        val response = withContext(Dispatchers.IO) {
            api.getBofTeamData(competitionPath).execute()
        }

        if (!response.isSuccessful) {
            throw Exception("团队数据API请求失败: ${response.code()} - ${response.message()}")
        }

        val teamDataList = response.body()
        if (teamDataList == null) {
            throw Exception("团队数据API响应为空")
        }

        // 将List转换为Map，以团队名称为key
        val teamDataMap = teamDataList.associateBy { it.team }

        // 保存团队数据到ObjectBox
        bofObjectBoxService.saveBofTeamApiResponse(teamDataMap, competitionPath)
        val savedCount = bofRepository.getTeamCount(competitionPath)

        Log.d(TAG, "Successfully downloaded and saved $savedCount $competitionName teams")
        return savedCount
    }
    
    /**
     * 下载评论数据
     * @return 保存的评论数量
     */
    private suspend fun downloadCommentData(competitionPath: String, competitionName: String): Long {
        // 首先获取range数据来检查singleComment字段
        val rangeData = bofObjectBoxService.getBofRangeData()
        val competitionRange = rangeData.find { it.path == competitionPath }
        
        if (competitionRange == null) {
            Log.w(TAG, "No '$competitionPath' range found in range data, skipping comment data download")
            return 0L
        }
        
        // 检查比赛是否已开始
        if (!competitionRange.isStart) {
            Log.i(TAG, "BOF:${competitionPath.uppercase()} has not started yet, skipping comment data download")
            return 0L
        }
        
        // 根据singleComment字段选择API端点
        val response = withContext(Dispatchers.IO) {
            if (competitionRange.singleComment) {
                Log.d(TAG, "Using fixed comment data for competition: $competitionPath")
                api.getBofCommentData(competitionPath).execute()
            } else {
                Log.d(TAG, "Time-based comment data not implemented yet for competition: $competitionPath")
                // 时间序列评论数据还未设计好，跳过
                return@withContext null
            }
        }
        
        if (response == null) {
            Log.w(TAG, "Comment data download skipped for $competitionPath (time-based not implemented)")
            return 0L
        }
        
        if (!response.isSuccessful) {
            throw Exception("评论数据API请求失败: ${response.code()} - ${response.message()}")
        }

        val commentDataList = response.body()
        if (commentDataList == null) {
            throw Exception("评论数据API响应为空")
        }

        // 使用commentDate字段作为保存日期
        val dateToSave = competitionRange.commentDate.ifEmpty {
            // 如果没有commentDate，使用current字段或默认日期
            competitionRange.current.ifEmpty { "2025-01-08" }
        }
        
        // 保存评论数据到ObjectBox
        bofObjectBoxService.saveBofCommentApiResponse(commentDataList, dateToSave)
        val savedCount = bofObjectBoxService.getCommentCount(dateToSave)

        Log.d(TAG, "Successfully downloaded and saved $savedCount $competitionName comments")
        return savedCount
    }
    
    /**
     * 更新特定比赛项目的状态
     */
    private fun updateCompetitionItemStatus(path: String, isUpdating: Boolean) {
        val currentCompetitions = _uiState.value.availableCompetitions
        val updatedCompetitions = currentCompetitions.map { item ->
            if (item.path == path) {
                item.copy(isUpdating = isUpdating)
            } else {
                item
            }
        }
        _uiState.value = _uiState.value.copy(availableCompetitions = updatedCompetitions)
    }

    /**
     * 清除消息状态
     */
    fun clearMessage() {
        _uiState.value = _uiState.value.copy(
            message = null,
            isError = false
        )
    }

    /**
     * 获取当前数据统计
     */
    fun getDataStatistics() {
        viewModelScope.launch {
            try {
                val competitions = _uiState.value.availableCompetitions
                
                // 统计总数
                val totalWorks = competitions.sumOf { it.workCount }
                val totalTeams = competitions.sumOf { it.teamCount }
                val totalData = totalWorks + totalTeams
                
                val activeCompetitions = competitions.count { it.isStart && !it.isEnd }
                val competitionsWithData = competitions.count { it.hasData }
                
                val message = if (totalData > 0) {
                    val dataParts = mutableListOf<String>()
                    if (totalWorks > 0) dataParts.add("${totalWorks}部作品")
                    if (totalTeams > 0) dataParts.add("${totalTeams}个团队")
                    
                    "数据库统计: ${dataParts.joinToString(" | ")} | $competitionsWithData/${competitions.size} 个比赛有数据 | $activeCompetitions 个比赛进行中"
                } else {
                    "数据库为空，请下载数据"
                }

                _uiState.value = _uiState.value.copy(
                    message = message,
                    isError = false
                )
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get data statistics", e)
                _uiState.value = _uiState.value.copy(
                    message = "获取统计信息失败: ${e.message}",
                    isError = true
                )
            }
        }
    }
}

/**
 * BOF 数据更新页面的 UI 状态
 */
data class BOFUpdateUiState(
    val isLoading: Boolean = false,
    val message: String? = null,
    val isError: Boolean = false,
    val availableCompetitions: List<CompetitionUpdateItem> = emptyList(),
    val isLoadingCompetitions: Boolean = false
)

/**
 * 比赛更新项目
 */
data class CompetitionUpdateItem(
    val path: String,
    val shortName: String,
    val fullName: String,
    val isStart: Boolean, // 是否已开始
    val isEnd: Boolean, // 是否已结束
    val hasData: Boolean, // 是否已有数据
    val dataCount: Long, // 总数据数量 (作品+团队+评论)
    val lastUpdated: String, // 最后更新时间
    val startTime: String, // 开始时间，用于排序
    val endTime: String, // 结束时间，用于排序
    val isUpdating: Boolean = false, // 是否正在更新
    val workCount: Long = 0, // 作品数量
    val teamCount: Long = 0, // 团队数量
    val commentCount: Long = 0 // 评论数量
)

/**
 * ViewModel Factory
 */
class BOFDataUpdateViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BOFDataUpdateViewModel::class.java)) {
            return BOFDataUpdateViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
