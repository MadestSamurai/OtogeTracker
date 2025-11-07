package com.madsam.otora.data.osu.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

// DataStore 实例
private val Context.osuConfigDataStore: DataStore<Preferences> by preferencesDataStore(name = "osu_config")

/**
 * Osu 配置 DataStore 服务
 * 存储 osu! 用户ID和游戏模式配置
 */
class OsuConfigDataStore(private val context: Context) {

    companion object {
        private val USER_ID = stringPreferencesKey("user_id")
        private val MODE = stringPreferencesKey("mode")
        
        /**
         * 默认游戏模式
         */
        const val DEFAULT_MODE = "osu"
    }

    /**
     * 保存配置数据
     */
    suspend fun saveConfig(userId: String, mode: String) {
        context.osuConfigDataStore.edit { preferences ->
            preferences[USER_ID] = userId
            preferences[MODE] = mode
        }
    }

    /**
     * 获取配置 Flow
     */
    fun getConfigFlow(): Flow<Pair<String, String>> {
        return context.osuConfigDataStore.data.map { preferences ->
            val userId = preferences[USER_ID] ?: ""
            val mode = preferences[MODE] ?: DEFAULT_MODE
            Pair(userId, mode)
        }
    }

    /**
     * 获取配置（一次性）
     */
    suspend fun getConfig(): Pair<String, String> {
        return getConfigFlow().first()
    }
}
