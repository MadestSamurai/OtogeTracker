package com.madsam.otora.core.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.materialkolor.PaletteStyle
import com.materialkolor.dynamicColorScheme

/**
 * M3E 动态配色方案生成器
 * 
 * 使用 MaterialKolor 库（封装了 Google Material Color Utilities 的 HCT 算法），
 * 从单一源颜色生成完整的 Material 3 配色方案。
 * 
 * @author MadSam
 */
object DynamicColorScheme {

    /**
     * 配色风格枚举 (对应 MaterialKolor 的 PaletteStyle)
     */
    enum class Style {
        TONAL_SPOT,   // 默认 M3 风格，平衡的色调
        VIBRANT,      // 高饱和度，活力风格
        EXPRESSIVE,   // 表现力强，对比度高
        FIDELITY,     // 忠于源颜色
        CONTENT,      // 内容驱动
        NEUTRAL,      // 中性低调
        MONOCHROME,   // 单色风格
        RAINBOW,      // 彩虹风格
        FRUIT_SALAD   // 水果沙拉风格
    }

    /**
     * 将内部 Style 转换为 MaterialKolor 的 PaletteStyle
     */
    private fun Style.toPaletteStyle(): PaletteStyle = when (this) {
        Style.TONAL_SPOT -> PaletteStyle.TonalSpot
        Style.VIBRANT -> PaletteStyle.Vibrant
        Style.EXPRESSIVE -> PaletteStyle.Expressive
        Style.FIDELITY -> PaletteStyle.Fidelity
        Style.CONTENT -> PaletteStyle.Content
        Style.NEUTRAL -> PaletteStyle.Neutral
        Style.MONOCHROME -> PaletteStyle.Monochrome
        Style.RAINBOW -> PaletteStyle.Rainbow
        Style.FRUIT_SALAD -> PaletteStyle.FruitSalad
    }

    /**
     * 从源颜色生成 ColorScheme
     * 
     * @param sourceColor 源颜色
     * @param isDark 是否深色主题
     * @param isAmoled 是否 AMOLED 模式（纯黑背景）
     * @param style 配色风格
     * @param contrastLevel 对比度级别 (-1.0 到 1.0，0 为标准)
     */
    fun generateColorScheme(
        sourceColor: Color,
        isDark: Boolean,
        isAmoled: Boolean = false,
        style: Style = Style.TONAL_SPOT,
        contrastLevel: Double = 0.0
    ): ColorScheme {
        return dynamicColorScheme(
            seedColor = sourceColor,
            isDark = isDark,
            isAmoled = isAmoled,
            style = style.toPaletteStyle(),
            contrastLevel = contrastLevel
        )
    }
}

/**
 * Composable 版本的动态主题生成
 * 会在源颜色变化时自动重新计算
 */
@Composable
fun rememberDynamicColorScheme(
    sourceColor: Color,
    isDark: Boolean,
    style: DynamicColorScheme.Style = DynamicColorScheme.Style.TONAL_SPOT,
    contrastLevel: Double = 0.0,
    @Suppress("UNUSED_PARAMETER") surfaceChroma: Double = 16.0 // 保留参数兼容性，MaterialKolor 内部处理
): ColorScheme {
    return remember(sourceColor, isDark, style, contrastLevel) {
        DynamicColorScheme.generateColorScheme(
            sourceColor = sourceColor,
            isDark = isDark,
            style = style,
            contrastLevel = contrastLevel
        )
    }
}
