package com.madsam.otora.core.utils

import android.content.res.Configuration
import android.os.Build
import android.view.View
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.core.utils.ScreenUtil
 * 创建者: MadSamurai
 * 创建时间: 2024/12/23
 * 描述: 屏幕工具类
 */
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
}