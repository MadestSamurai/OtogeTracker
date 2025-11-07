package com.madsam.otora.core.utils

import android.util.Log
import androidx.compose.ui.graphics.Brush
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
