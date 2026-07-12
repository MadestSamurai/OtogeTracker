package com.madsam.otora.core.datastore

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

// DataStore 实例
private val Context.themeDataStore: DataStore<Preferences> by preferencesDataStore(name = "theme_settings")

/**
 * 预设主题颜色
 */
enum class ThemeColor(val color: Color) {
    VIOLET(Color(0xFF7C5CBF)),      // 默认色
    BLUE(Color(0xFF2196F3)),
    CYAN(Color(0xFF00BCD4)),
    TEAL(Color(0xFF009688)),
    GREEN(Color(0xFF4CAF50)),
    LIME(Color(0xFF8BC34A)),
    YELLOW(Color(0xFFFFEB3B)),
    ORANGE(Color(0xFFFF9800)),
    RED(Color(0xFFF44336)),
    PINK(Color(0xFFE91E63)),
    PURPLE(Color(0xFF9C27B0)),
    INDIGO(Color(0xFF3F51B5));

    companion object {
        fun fromColorValue(colorValue: Long): ThemeColor {
            return entries.find { it.color.value.toLong() == colorValue } ?: VIOLET
        }
    }
}

/**
 * 语言设置
 */
enum class AppLanguage(val code: String) {
    FOLLOW_SYSTEM(""),
    ENGLISH("en"),
    CHINESE_SIMPLIFIED("zh-CN");
    
    companion object {
        fun fromCode(code: String): AppLanguage {
            return entries.find { it.code == code } ?: FOLLOW_SYSTEM
        }
    }
}

/**
 * 主题设置 DataStore 服务
 * 存储深色模式相关的主题配置
 */
class ThemeDataStore(private val context: Context) {

    companion object {
        private val AUTO_DARK_MODE = booleanPreferencesKey("auto_dark_mode")
        private val DARK_MODE_ENABLED = booleanPreferencesKey("dark_mode_enabled")
        private val THEME_COLOR = longPreferencesKey("theme_color")
        private val APP_LANGUAGE = stringPreferencesKey("app_language")
        private val FOLLOW_SYSTEM_LANGUAGE = booleanPreferencesKey("follow_system_language")
        private val LANGUAGE_ORDER = stringPreferencesKey("language_order")
        
        // 默认主题色值
        val DEFAULT_THEME_COLOR = ThemeColor.VIOLET.color
        // 默认语言顺序
        val DEFAULT_LANGUAGE_ORDER = listOf("zh-CN", "en")
    }

    /**
     * 保存自动深色模式设置
     */
    suspend fun saveAutoDarkMode(enabled: Boolean) {
        context.themeDataStore.edit { preferences ->
            preferences[AUTO_DARK_MODE] = enabled
        }
    }

    /**
     * 保存深色模式设置
     */
    suspend fun saveDarkModeEnabled(enabled: Boolean) {
        context.themeDataStore.edit { preferences ->
            preferences[DARK_MODE_ENABLED] = enabled
        }
    }

    /**
     * 获取自动深色模式设置 Flow
     */
    fun getAutoDarkModeFlow(): Flow<Boolean> {
        return context.themeDataStore.data.map { preferences ->
            preferences[AUTO_DARK_MODE] ?: true // 默认跟随系统
        }
    }

    /**
     * 获取深色模式设置 Flow
     */
    fun getDarkModeEnabledFlow(): Flow<Boolean> {
        return context.themeDataStore.data.map { preferences ->
            preferences[DARK_MODE_ENABLED] ?: false // 默认浅色模式
        }
    }

    /**
     * 获取自动深色模式设置（一次性）
     */
    suspend fun getAutoDarkMode(): Boolean {
        return getAutoDarkModeFlow().first()
    }

    /**
     * 获取深色模式设置（一次性）
     */
    suspend fun getDarkModeEnabled(): Boolean {
        return getDarkModeEnabledFlow().first()
    }

    /**
     * 获取主题设置数据类
     */
    data class ThemeSettings(
        val autoDarkMode: Boolean = true,
        val darkModeEnabled: Boolean = false,
        val themeColor: Color = DEFAULT_THEME_COLOR
    )

    /**
     * 获取完整主题设置 Flow
     */
    fun getThemeSettingsFlow(): Flow<ThemeSettings> {
        return context.themeDataStore.data.map { preferences ->
            ThemeSettings(
                autoDarkMode = preferences[AUTO_DARK_MODE] ?: true,
                darkModeEnabled = preferences[DARK_MODE_ENABLED] ?: false,
                themeColor = preferences[THEME_COLOR]?.let { Color(it.toULong()) } ?: DEFAULT_THEME_COLOR
            )
        }
    }

    /**
     * 保存主题颜色
     */
    suspend fun saveThemeColor(color: Color) {
        context.themeDataStore.edit { preferences ->
            preferences[THEME_COLOR] = color.value.toLong()
        }
    }

    /**
     * 获取主题颜色 Flow
     */
    fun getThemeColorFlow(): Flow<Color> {
        return context.themeDataStore.data.map { preferences ->
            preferences[THEME_COLOR]?.let { Color(it.toULong()) } ?: DEFAULT_THEME_COLOR
        }
    }

    /**
     * 获取主题颜色（一次性）
     */
    suspend fun getThemeColor(): Color {
        return getThemeColorFlow().first()
    }

    /**
     * 保存语言设置
     */
    suspend fun saveLanguage(language: AppLanguage) {
        context.themeDataStore.edit { preferences ->
            preferences[APP_LANGUAGE] = language.code
        }
    }

    /**
     * 获取语言设置 Flow
     */
    fun getLanguageFlow(): Flow<AppLanguage> {
        return context.themeDataStore.data.map { preferences ->
            val code = preferences[APP_LANGUAGE] ?: ""
            AppLanguage.fromCode(code)
        }
    }

    /**
     * 获取语言设置（一次性）
     */
    suspend fun getLanguage(): AppLanguage {
        return getLanguageFlow().first()
    }

    /**
     * 保存是否跟随系统语言
     */
    suspend fun saveFollowSystemLanguage(followSystem: Boolean) {
        context.themeDataStore.edit { preferences ->
            preferences[FOLLOW_SYSTEM_LANGUAGE] = followSystem
        }
    }

    /**
     * 获取是否跟随系统语言 Flow
     */
    fun getFollowSystemLanguageFlow(): Flow<Boolean> {
        return context.themeDataStore.data.map { preferences ->
            preferences[FOLLOW_SYSTEM_LANGUAGE] ?: true // 默认跟随系统
        }
    }

    /**
     * 保存语言优先级顺序
     */
    suspend fun saveLanguageOrder(order: List<String>) {
        context.themeDataStore.edit { preferences ->
            preferences[LANGUAGE_ORDER] = order.joinToString(",")
        }
    }

    /**
     * 获取语言优先级顺序 Flow
     */
    fun getLanguageOrderFlow(): Flow<List<String>> {
        return context.themeDataStore.data.map { preferences ->
            preferences[LANGUAGE_ORDER]?.split(",")?.filter { it.isNotEmpty() }
                ?: DEFAULT_LANGUAGE_ORDER
        }
    }

    /**
     * 获取当前显示的语言名称（用于设置页面显示）
     */
    fun getCurrentLanguageDisplayFlow(): Flow<String> {
        return context.themeDataStore.data.map { preferences ->
            val followSystem = preferences[FOLLOW_SYSTEM_LANGUAGE] ?: true
            if (followSystem) {
                "" // 空字符串表示跟随系统
            } else {
                val order = preferences[LANGUAGE_ORDER]?.split(",")?.filter { it.isNotEmpty() }
                    ?: DEFAULT_LANGUAGE_ORDER
                order.firstOrNull() ?: "zh-CN"
            }
        }
    }
}
