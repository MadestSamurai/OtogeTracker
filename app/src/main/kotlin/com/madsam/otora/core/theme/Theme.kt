package com.madsam.otora.core.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * Otoge Tracker 默认主题色 (紫罗兰)
 */
val OtogeDefaultSourceColor = Color(0xFF7C5CBF)

@Composable
fun OtogeTrackerTheme(
    sourceColor: Color = OtogeDefaultSourceColor, // 源颜色，默认紫罗兰
    style: DynamicColorScheme.Style = DynamicColorScheme.Style.TONAL_SPOT,
    darkTheme: Boolean = isSystemInDarkTheme(), // 跟随系统主题
    content: @Composable () -> Unit
) {
    val colorScheme: ColorScheme = rememberDynamicColorScheme(
        sourceColor = sourceColor,
        isDark = darkTheme,
        style = style
    )

    // Handle system bars
    val view = LocalView.current
    if (!view.isInEditMode) {
        DisposableEffect(darkTheme) {
            val window = (view.context as Activity).window
            WindowCompat.setDecorFitsSystemWindows(window, false)
            
            // Update system bars appearance based on theme
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = !darkTheme
                isAppearanceLightNavigationBars = !darkTheme
            }

            onDispose {}
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}