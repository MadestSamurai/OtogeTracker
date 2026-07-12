package com.madsam.otora.ui.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.em
import com.madsam.otora.core.datastore.ThemeDataStore
import com.madsam.otora.core.theme.OtogeTrackerTheme

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // 从 DataStore 读取主题设置
            val themeDataStore = remember { ThemeDataStore(this@SettingsActivity) }
            val themeSettings by themeDataStore.getThemeSettingsFlow().collectAsState(
                initial = ThemeDataStore.ThemeSettings()
            )
            
            // 计算实际的深色模式状态
            val systemDarkTheme = isSystemInDarkTheme()
            val darkTheme = if (themeSettings.autoDarkMode) {
                systemDarkTheme
            } else {
                themeSettings.darkModeEnabled
            }
            
            OtogeTrackerTheme(sourceColor = themeSettings.themeColor, darkTheme = darkTheme) {
                CompositionLocalProvider(
                    LocalTextStyle provides LocalTextStyle.current.copy(lineHeight = 1.4.em)
                ) {
                    SettingsScreen(
                        onNavigateBack = { finish() }
                    )
                }
            }
        }
    }
}
