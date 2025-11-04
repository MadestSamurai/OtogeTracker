package com.madsam.otora.data.chunithm.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.madsam.otora.data.chunithm.remote.model.ChuniUserExtendDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

// DataStore 实例
private val Context.chunithmUserExtDataStore: DataStore<Preferences> by preferencesDataStore(name = "chunithm_user_ext")

/**
 * Chunithm 用户扩展数据 DataStore 服务
 * 使用 DataStore Preferences 存储用户扩展配置数据
 */
internal class ChunithmUserExtDataStore(private val context: Context) {
    
    companion object {
        private val FRIEND_CODE = stringPreferencesKey("friend_code")
        private val POINT = stringPreferencesKey("point")
        private val TOTAL_POINT = stringPreferencesKey("total_point")
        private val PLAY_COUNT = stringPreferencesKey("play_count")
    }
    
    /**
     * 保存用户扩展数据
     */
    suspend fun saveUserExtData(userExt: ChuniUserExtendDTO) {
        context.chunithmUserExtDataStore.edit { preferences ->
            preferences[FRIEND_CODE] = userExt.friendCode
            preferences[POINT] = userExt.point
            preferences[TOTAL_POINT] = userExt.totalPoint
            preferences[PLAY_COUNT] = userExt.playCount
        }
    }
    
    /**
     * 获取用户扩展数据 Flow
     */
    fun getUserExtDataFlow(): Flow<ChuniUserExtendDTO?> {
        return context.chunithmUserExtDataStore.data.map { preferences ->
            val friendCode = preferences[FRIEND_CODE] ?: ""
            if (friendCode.isEmpty()) {
                null
            } else {
                ChuniUserExtendDTO(
                    friendCode = friendCode,
                    point = preferences[POINT] ?: "",
                    totalPoint = preferences[TOTAL_POINT] ?: "",
                    playCount = preferences[PLAY_COUNT] ?: ""
                )
            }
        }
    }
    
    /**
     * 获取用户扩展数据（挂起函数）
     * 获取当前 DataStore 中的第一个值
     */
    suspend fun getUserExtData(): ChuniUserExtendDTO? {
        return getUserExtDataFlow().first()
    }
    
    /**
     * 清除用户扩展数据
     */
    suspend fun clearUserExtData() {
        context.chunithmUserExtDataStore.edit { preferences ->
            preferences.clear()
        }
    }
}
