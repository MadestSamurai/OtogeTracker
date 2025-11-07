package com.madsam.otora.core.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp

object ScreenUtil {
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