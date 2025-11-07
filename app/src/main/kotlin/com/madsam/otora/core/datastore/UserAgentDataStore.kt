package com.madsam.otora.core.datastore

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
private val Context.userAgentDataStore: DataStore<Preferences> by preferencesDataStore(name = "user_agent")

/**
 * UserAgent DataStore 服务
 * 存储网络请求所需的 User-Agent 信息
 */
class UserAgentDataStore(private val context: Context) {

    companion object {
        private val USER_AGENT = stringPreferencesKey("user_agent")
        
        /**
         * 默认的 User-Agent
         */
        const val DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
    }

    /**
     * 保存 User-Agent
     */
    suspend fun saveUserAgent(userAgent: String) {
        context.userAgentDataStore.edit { preferences ->
            preferences[USER_AGENT] = userAgent
        }
    }

    /**
     * 获取 User-Agent Flow
     */
    fun getUserAgentFlow(): Flow<String> {
        return context.userAgentDataStore.data.map { preferences ->
            preferences[USER_AGENT] ?: ""
        }
    }

    /**
     * 获取 User-Agent（一次性）
     */
    suspend fun getUserAgent(): String {
        return getUserAgentFlow().first()
    }
}
