package com.madsam.otora.core.utils

import android.util.Log
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.madsam.otora.core.theme.*

/**
 * Brush 工具类
 * 
 * 提供根据等级、Rating等获取对应渐变色的功能
 */
object BrushUtils {
    /**
     * 获取等级对应的颜色列表 (用于自定义渐变)
     *
     * @param value 等级值
     * @param isDarkTheme 是否为暗色主题
     * @return 对应的颜色列表
     */
    fun getLevelColors(value: Int, isDarkTheme: Boolean = true): List<Color> {
        if (isDarkTheme) {
            // 使用官方新版 Tier 颜色
            return when {
                value >= 110 -> listOf(TIER_LUSTROUS_1, TIER_LUSTROUS_2) // Lustrous
                value >= 105 -> listOf(TIER_RADIANT_1, TIER_RADIANT_2)   // Radiant
                value >= 100 -> listOf(TIER_RHODIUM_1, TIER_RHODIUM_2)   // Rhodium
                value >= 80 -> listOf(TIER_PLATINUM_1, TIER_PLATINUM_2)  // Platinum
                value >= 60 -> listOf(TIER_GOLD_1, TIER_GOLD_2)          // Gold
                value >= 40 -> listOf(TIER_SILVER_1, TIER_SILVER_2)      // Silver
                value >= 20 -> listOf(TIER_BRONZE_1, TIER_BRONZE_2)      // Bronze
                else -> listOf(TIER_IRON_1, TIER_IRON_2)                 // Iron
            }
        } else {
            // 亮色主题下的深色变体 (基于新版 Tier 逻辑调整)
            return when {
                value >= 110 -> listOf(TIER_LUSTROUS_DARK_1, TIER_LUSTROUS_DARK_2) // Lustrous (Darker Yellow -> Pink)
                value >= 105 -> listOf(TIER_RADIANT_DARK_1, TIER_RADIANT_DARK_2)   // Radiant (Darker Blue -> Purple)
                value >= 100 -> listOf(TIER_RHODIUM_DARK_1, TIER_RHODIUM_DARK_2)   // Rhodium (Dark Green)
                value >= 80 -> listOf(TIER_PLATINUM_DARK_1, TIER_PLATINUM_DARK_2)  // Platinum (Dark Cyan)
                value >= 60 -> listOf(TIER_GOLD_DARK_1, TIER_GOLD_DARK_2)          // Gold (Dark Orange/Gold)
                value >= 40 -> listOf(TIER_SILVER_DARK_1, TIER_SILVER_DARK_2)      // Silver (Dark Grey)
                value >= 20 -> listOf(TIER_BRONZE_DARK_1, TIER_BRONZE_DARK_2)      // Bronze (Dark Brown)
                else -> listOf(TIER_IRON_DARK_1, TIER_IRON_DARK_2)                 // Iron (Grey)
            }
        }
    }

    /**
     * 获取 Rating Text 对应的颜色
     *
     * @param value Rating 值字符串
     * @param isDark 是否深色主题
     * @return 对应的渐变色 Brush
     */
    fun getRatingTextBrush(value: String, isDark: Boolean): Brush {
        try {
            val valueFloat = value.toFloat()
            return when (valueFloat) {
                in 0.00..3.999 -> if (isDark) GradientBrush.TierGreenTextGradientDark else GradientBrush.TierGreenTextGradient
                in 4.00..6.999 -> if (isDark) GradientBrush.TierYellowTextGradientDark else GradientBrush.TierYellowTextGradient
                in 7.00..9.999 -> if (isDark) GradientBrush.TierRedTextGradientDark else GradientBrush.TierRedTextGradient
                in 10.00..11.999 -> if (isDark) GradientBrush.TierPurpleTextGradientDark else GradientBrush.TierPurpleTextGradient
                in 12.00..13.249 -> if (isDark) GradientBrush.TierBronzeTextGradientDark else GradientBrush.TierBronzeTextGradient
                in 13.25..14.499 -> if (isDark) GradientBrush.TierSilverTextGradientDark else GradientBrush.TierSilverTextGradient
                in 14.50..15.249 -> if (isDark) GradientBrush.TierGoldTextGradientDark else GradientBrush.TierGoldTextGradient
                in 15.25..15.999 -> if (isDark) GradientBrush.TierPlatinumTextGradientDark else GradientBrush.TierPlatinumTextGradient
                in 16.00..16.999 -> if (isDark) GradientBrush.TierRainbowTextGradientDark else GradientBrush.TierRainbowTextGradient
                in 17.00..18.000 -> if (isDark) GradientBrush.TierRainbowMaxTextGradientDark else GradientBrush.TierRainbowMaxTextGradient
                else -> if (isDark) GradientBrush.TierWhiteTextGradientDark else GradientBrush.TierWhiteTextGradient
            }
        } catch (nfe: NumberFormatException) {
            Log.e("BrushUtils", "Rating value is not a number: $nfe")
            return if (isDark) GradientBrush.TierWhiteTextGradientDark else GradientBrush.TierWhiteTextGradient
        }
    }

    /**
     * 获取 Rating 背景对应的颜色
     *
     * @param value Rating 值字符串
     * @param isDark 是否深色主题
     * @return 对应的渐变色 Brush
     */
    fun getRatingBrush(value: String, isDark: Boolean): Brush {
        try {
            val valueFloat = value.toFloat()
            return when (valueFloat) {
                in 0.00..3.999 -> if (isDark) GradientBrush.TierGreenGradientDark else GradientBrush.TierGreenGradient
                in 4.00..6.999 -> if (isDark) GradientBrush.TierYellowGradientDark else GradientBrush.TierYellowGradient
                in 7.00..9.999 -> if (isDark) GradientBrush.TierRedGradientDark else GradientBrush.TierRedGradient
                in 10.00..11.999 -> if (isDark) GradientBrush.TierPurpleGradientDark else GradientBrush.TierPurpleGradient
                in 12.00..13.249 -> if (isDark) GradientBrush.TierBronzeGradientDark else GradientBrush.TierBronzeGradient
                in 13.25..14.499 -> if (isDark) GradientBrush.TierSilverGradientDark else GradientBrush.TierSilverGradient
                in 14.50..15.249 -> if (isDark) GradientBrush.TierGoldGradientDark else GradientBrush.TierGoldGradient
                in 15.25..15.999 -> if (isDark) GradientBrush.TierPlatinumGradientDark else GradientBrush.TierPlatinumGradient
                in 16.00..16.999 -> if (isDark) GradientBrush.TierRainbowGradientDark else GradientBrush.TierRainbowGradient
                in 17.00..18.000 -> if (isDark) GradientBrush.TierRainbowMaxGradientDark else GradientBrush.TierRainbowMaxGradient
                else -> if (isDark) GradientBrush.TierWhiteGradientDark else GradientBrush.TierWhiteGradient
            }
        } catch (nfe: NumberFormatException) {
            Log.e("BrushUtils", "Rating value is not a number: $nfe")
            return if (isDark) GradientBrush.TierWhiteGradientDark else GradientBrush.TierWhiteGradient
        }
    }
}
