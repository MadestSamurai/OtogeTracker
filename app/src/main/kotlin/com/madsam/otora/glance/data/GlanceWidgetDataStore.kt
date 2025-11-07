package com.madsam.otora.glance.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

/**
 * Glance Widget 数据存储
 * 
 * 专门用于存储 Widget 需要跨进程访问的数据
 * 使用 SharedPreferences 是因为：
 * 1. Widget 运行在独立进程，需要跨进程数据访问
 * 2. SharedPreferences 支持跨进程，性能更好
 * 3. Widget 数据更新频率低，不需要响应式
 * 
 * 如果未来需要迁移到 DataStore，只需修改此类实现，
 * 而不影响其他业务代码
 */
object GlanceWidgetDataStore {
    
    private const val PREFS_NAME = "widget_data"
    private const val KEY_OSU_GLANCE = "osuGlance"
    private const val KEY_CHUNITHM_GLANCE = "chunithmGlance"
    
    private var sharedPreferences: SharedPreferences? = null
    
    /**
     * 获取 SharedPreferences 实例（延迟初始化）
     */
    private fun getPreferences(context: Context): SharedPreferences {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        }
        return sharedPreferences!!
    }
    
    /**
     * 保存字符串数据
     */
    private fun saveString(context: Context, key: String, value: String) {
        if (value.isNotBlank()) {
            getPreferences(context).edit {
                putString(key, value)
            }
        }
    }
    
    /**
     * 获取字符串数据
     */
    private fun getString(context: Context, key: String): String? {
        return getPreferences(context).getString(key, null)
    }
    
    /**
     * 保存 Osu Widget 数据（JSON 格式）
     */
    fun saveOsuWidgetData(context: Context, jsonData: String) {
        saveString(context, KEY_OSU_GLANCE, jsonData)
    }
    
    /**
     * 获取 Osu Widget 数据（JSON 格式）
     */
    fun getOsuWidgetData(context: Context): String? {
        return getString(context, KEY_OSU_GLANCE)
    }
    
    /**
     * 保存 Chunithm Widget 数据（JSON 格式）
     */
    fun saveChunithmWidgetData(context: Context, jsonData: String) {
        saveString(context, KEY_CHUNITHM_GLANCE, jsonData)
    }
    
    /**
     * 获取 Chunithm Widget 数据（JSON 格式）
     */
    fun getChunithmWidgetData(context: Context): String? {
        return getString(context, KEY_CHUNITHM_GLANCE)
    }
    
    /**
     * 清除所有 Widget 数据
     */
    fun clearAllWidgetData(context: Context) {
        getPreferences(context).edit {
            clear()
        }
    }
}
