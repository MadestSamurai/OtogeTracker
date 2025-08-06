package com.madsam.otora.core.utils

import android.content.Context

object UserAgentUtils {
    
    /**
     * 检查User-Agent是否已设置且合理
     */
    fun isUserAgentValid(context: Context): Boolean {
        val userAgent = ShareUtil.getString("userAgent", context) ?: ""
        return userAgent.isNotBlank() && userAgent.length > 10 && userAgent.contains("Mozilla")
    }
    
    /**
     * 获取保存的User-Agent
     */
    fun getUserAgent(context: Context): String {
        return ShareUtil.getString("userAgent", context) ?: ""
    }
    
    /**
     * 获取默认的User-Agent
     */
    fun getDefaultUserAgent(): String {
        return "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
    }
}
