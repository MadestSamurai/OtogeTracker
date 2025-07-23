package com.madsam.otora.core.utils

import android.content.res.Configuration
import android.os.Build
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat

object ScreenUtil {
    fun isLandscape(configuration: Configuration): Boolean {
        return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    }

    fun isPortrait(configuration: Configuration): Boolean {
        return configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }

    fun getSafeInsetLeftDp(view: View): Dp {
        val insets = ViewCompat.getRootWindowInsets(view)
        val safeInsetLeftPx = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            insets?.displayCutout?.safeInsetLeft ?: 0
        } else {
            0
        }
        val density = view.context.resources.displayMetrics.density
        return (safeInsetLeftPx / density).dp
    }

    fun getSafeInsetRightDp(view: View): Dp {
        val insets = ViewCompat.getRootWindowInsets(view)
        val safeInsetRightPx = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            insets?.displayCutout?.safeInsetRight ?: 0
        } else {
            0
        }
        val density = view.context.resources.displayMetrics.density
        return (safeInsetRightPx / density).dp
    }
    
    /**
     * 判断是否应该使用 NavigationRail 而不是 BottomNavigation
     * 判断标准：屏幕宽度大于高度（横屏）或屏幕宽度大于 600dp（平板尺寸）
     * 
     * @return true 如果应该使用 NavigationRail，false 如果应该使用 BottomNavigation
     */
    @Composable
    fun shouldUseNavigationRail(): Boolean {
        val density = LocalDensity.current
        val windowInfo = LocalWindowInfo.current
        val screenWidth = with(density) { windowInfo.containerSize.width.toDp() }
        val screenHeight = with(density) { windowInfo.containerSize.height.toDp() }
        return screenWidth > screenHeight || screenWidth > 600.dp
    }
}