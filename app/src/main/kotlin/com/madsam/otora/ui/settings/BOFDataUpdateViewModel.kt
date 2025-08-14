package com.madsam.otora.ui.settings

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.data.BASE_URL
import com.madsam.otora.data.bof.local.model.BofTTCompactEntity
import com.madsam.otora.data.bof.local.repository.BofRepository
import com.madsam.otora.data.bof.remote.api.BofAPI
import com.madsam.otora.data.bof.remote.model.BofTTApiResponse
import com.madsam.otora.data.bof.remote.model.BofTTWork
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
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
        val bofTTBox = boxStore.boxFor(BofTTCompactEntity::class.java)
        BofRepository(bofTTBox)
    }

    // Retrofit API
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    private val api = retrofit.create(BofAPI::class.java)

    /**
     * 下载并保存BOF TT详细数据
     */
    fun downloadBofTTData() {
        viewModelScope.launch {
            try {
                // 更新UI状态为下载中
                _uiState.value = _uiState.value.copy(
                    isLoading = true,
                    message = "正在下载 BOF TT 数据...",
                    isError = false
                )

                // 调用API
                val response = withContext(Dispatchers.IO) {
                    api.getBofTTDetailedData().execute()
                }

                if (!response.isSuccessful) {
                    throw Exception("API请求失败: ${response.code()} - ${response.message()}")
                }

                val worksMap = response.body()
                if (worksMap == null) {
                    throw Exception("API响应数据为空")
                }

                // 转换Map格式到BofTTApiResponse
                val worksAsMap = worksMap.mapValues { (workId, workData) ->
                    BofTTWork(
                        id = workId,
                        Score = workData.Score,
                        Title = workData.Title,
                        Artist = workData.Artist,
                        Team = workData.Team,
                        Genre = workData.Genre
                    )
                }
                val bofTTData = BofTTApiResponse(works = worksAsMap)

                // 更新状态为处理中
                _uiState.value = _uiState.value.copy(
                    message = "正在处理并保存数据..."
                )

                // 保存数据到Repository
                bofRepository.saveBofTTApiResponse(bofTTData)
                val savedCount = bofRepository.getWorksCount()

                // 更新状态为完成
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    message = "成功保存 $savedCount 条作品数据！",
                    isError = false
                )

                Log.d(TAG, "Successfully downloaded and saved $savedCount BOF TT works")

            } catch (e: Exception) {
                Log.e(TAG, "Failed to download BOF TT data", e)
                
                // 更新状态为错误
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    message = "下载失败: ${e.message}",
                    isError = true
                )
            }
        }
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
                val worksCount = bofRepository.getWorksCount()
                val message = if (worksCount > 0) {
                    "当前数据库中有 $worksCount 部作品"
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
    val isError: Boolean = false
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
