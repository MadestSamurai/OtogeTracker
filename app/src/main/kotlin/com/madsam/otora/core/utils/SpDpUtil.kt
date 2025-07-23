package com.madsam.otora.core.utils

import android.content.Context
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 响应式尺寸工具类
 * 
 * 基于屏幕宽度进行动态尺寸调整，以适应不同尺寸的设备
 * 基准宽度：850px (约等于中等尺寸手机的宽度)
 * 
 * 使用示例：
 * - 12.nsp() // 响应式字体大小
 * - 16.ndp() // 响应式尺寸
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

/**
 * 计算响应式尺寸
 * 
 * @param context Android Context
 * @param value 原始值
 * @param isDp true 为 dp 单位，false 为 sp 单位
 * @return 调整后的尺寸值
 */
private fun getRealDp(context: Context, value: Double, isDp: Boolean = true): Double {
    // 获取密度值
    val density = if (isDp) {
        context.resources.displayMetrics.density
    } else {
        context.resources.displayMetrics.densityDpi / 160.0f
    }
    
    // 获取屏幕宽度（横屏时使用较小的尺寸作为"宽度"）
    val screenWidth = if (context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        context.resources.displayMetrics.heightPixels
    } else {
        context.resources.displayMetrics.widthPixels
    }
    
    // 基准宽度：850px（中等尺寸手机）
    val baseWidth = 850.0
    
    // 缩放比例：当前屏幕宽度 / 基准宽度
    val scale = screenWidth / baseWidth
    
    // 应用缩放：原始值 * 缩放比例 * 2（调整系数）/ 密度
    return scale * 2 * value / density
}
