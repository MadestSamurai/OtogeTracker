package com.madsam.otora.utils

import android.content.Context
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.utils.SpDpUtil
 * 创建者: MadSamurai
 * 创建时间: 2024/10/19
 * 描述: SpDp匹配工具
 */
@Composable
fun Int.nsp() = getRealDp(LocalContext.current, this.toDouble(), isDp = false).sp

@Composable
fun Float.nsp(): TextUnit = getRealDp(LocalContext.current, this.toDouble(), isDp = false).sp

@Composable
fun Double.nsp() = getRealDp(LocalContext.current, this, isDp = false).sp

@Composable
fun Int.ndp() = getRealDp(LocalContext.current, this.toDouble()).dp

@Composable
fun Float.ndp() = getRealDp(LocalContext.current, this.toDouble()).dp

@Composable
fun Double.ndp() = getRealDp(LocalContext.current, this).dp

private fun getRealDp(context: Context, value: Double, isDp: Boolean = true): Double {
    val density =
        if (isDp) context.resources.displayMetrics.density else context.resources.displayMetrics.scaledDensity
    val screenWidth =
        (if (context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) context.resources.displayMetrics.heightPixels else context.resources.displayMetrics.widthPixels) / 850.0
    return screenWidth * 2 * value / density
}
