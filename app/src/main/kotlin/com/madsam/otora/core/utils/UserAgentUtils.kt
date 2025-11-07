package com.madsam.otora.core.utils

import android.content.Context
import com.madsam.otora.core.datastore.UserAgentDataStore

object UserAgentUtils {
    
    /**
     * 检查User-Agent是否已设置且合理
     */
    suspend fun isUserAgentValid(context: Context): Boolean {
        val userAgent = getUserAgent(context)
        return userAgent.isNotBlank() && userAgent.length > 10 && userAgent.contains("Mozilla")
    }
    
    /**
     * 获取保存的User-Agent
     */
    suspend fun getUserAgent(context: Context): String {
        return UserAgentDataStore(context).getUserAgent()
    }
    
    /**
     * 获取默认的User-Agent
     */
    fun getDefaultUserAgent(): String {
        return UserAgentDataStore.DEFAULT_USER_AGENT
    }
}
