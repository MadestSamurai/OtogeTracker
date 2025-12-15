package com.madsam.otora.core.theme

import android.app.Activity
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
    style: DynamicColorScheme.Style = DynamicColorScheme.Style.FIDELITY,
    content: @Composable () -> Unit
) {
    // 固定使用暗色主题
    val darkTheme = true
    
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
            
            // Update system bars appearance (always dark)
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = false
                isAppearanceLightNavigationBars = false
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