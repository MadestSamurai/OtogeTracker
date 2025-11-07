package com.madsam.otora.core.utils

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * 字符串工具类
 * 
 * 提供字符串处理、转换等功能
 */
object StringUtils {
    /**
     * URL 编码
     *
     * @param url 字符串
     * @return 编码后的字符串
     */
    fun encodeURL(url: String): String {
        val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
        return encodedUrl.replace("%3A", ":").replace("%2F", "/")
    }

    /**
     * Cookie 处理为键值对
     *
     * @param cookie 字符串
     * @return 字符串键值对
     */
    fun parseCookie(cookie: String): Map<String, String> {
        val cookieMap = cookie.split(";")
            .map { it.trim() }
            .map { it.split("=") }
        return if (cookieMap.size < 2) {
            mapOf()
        } else {
            cookieMap.associate { it[0] to it[1] }
        }
    }
}
