package com.madsam.otora.core.utils

import android.util.Log
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.madsam.otora.core.theme.*
import com.madsam.otora.core.theme.GradientBrush.BlueGradientBg
import com.madsam.otora.core.theme.GradientBrush.BronzeGradientBg
import com.madsam.otora.core.theme.GradientBrush.BronzeGradientText
import com.madsam.otora.core.theme.GradientBrush.GoldGradientBg
import com.madsam.otora.core.theme.GradientBrush.GoldGradientText
import com.madsam.otora.core.theme.GradientBrush.GreenGradientBg
import com.madsam.otora.core.theme.GradientBrush.GreenGradientText
import com.madsam.otora.core.theme.GradientBrush.PlatinumGradientBg
import com.madsam.otora.core.theme.GradientBrush.PlatinumGradientText
import com.madsam.otora.core.theme.GradientBrush.PurpleGradientBg
import com.madsam.otora.core.theme.GradientBrush.PurpleGradientText
import com.madsam.otora.core.theme.GradientBrush.RainbowGradientBg
import com.madsam.otora.core.theme.GradientBrush.RainbowGradientText
import com.madsam.otora.core.theme.GradientBrush.RedGradientBg
import com.madsam.otora.core.theme.GradientBrush.RedGradientText
import com.madsam.otora.core.theme.GradientBrush.SilverGradientBg
import com.madsam.otora.core.theme.GradientBrush.SilverGradientText
import com.madsam.otora.core.theme.GradientBrush.WhiteGradientBg
import com.madsam.otora.core.theme.GradientBrush.WhiteGradientText
import com.madsam.otora.core.theme.GradientBrush.YellowGradientBg
import com.madsam.otora.core.theme.GradientBrush.YellowGradientText

/**
 * Brush 工具类
 * 
 * 提供根据等级、Rating等获取对应渐变色的功能
 */
object BrushUtils {
    /**
     * 获取等级对应的颜色
     *
     * @param value 等级值
     * @return 对应的渐变色 Brush
     */
    fun getLevelBrush(value: Int): Brush {
        return when (value) {
            in 0..14 -> WhiteGradientBg
            in 15..29 -> BlueGradientBg
            in 30..44 -> GreenGradientBg
            in 45..59 -> YellowGradientBg
            in 60..69 -> RedGradientBg
            in 70..79 -> PurpleGradientBg
            in 80..89 -> BronzeGradientBg
            in 90..99 -> SilverGradientBg
            in 100..104 -> GoldGradientBg
            in 105..109 -> PlatinumGradientBg
            else -> RainbowGradientBg
        }
    }

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
     * 获取 Rating 对应的颜色
     *
     * @param value Rating 值字符串
     * @return 对应的渐变色 Brush
     */
    fun getRatingBrush(value: String): Brush {
        try {
            val valueFloat = value.toFloat()
            return when (valueFloat) {
                in 0.00..3.999 -> GreenGradientText
                in 4.00..6.999 -> YellowGradientText
                in 7.00..9.999 -> RedGradientText
                in 10.00..11.999 -> PurpleGradientText
                in 12.00..13.249 -> BronzeGradientText
                in 13.25..14.499 -> SilverGradientText
                in 14.50..15.249 -> GoldGradientText
                in 15.25..15.999 -> PlatinumGradientText
                in 16.00..18.000 -> RainbowGradientText
                else -> WhiteGradientText
            }
        } catch (nfe: NumberFormatException) {
            Log.e("BrushUtils", "Rating value is not a number: $nfe")
            return WhiteGradientText
        }
    }
}
