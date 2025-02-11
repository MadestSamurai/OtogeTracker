package com.madsam.otora.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * 项目名: OtogeTracker
 * 文件名: Colors
 * 创建者: MadSamurai
 * 创建时间:2023/3/9 16:59
 * 描述: 颜色常量类
 */

val Purple700 = Color(0xFF3700B3)
val PurpleTheme = Color(0xFF674FA3)
val Black333 = Color(0xFF333333)
val White1000: Color = Color(0xFFFFFFFF)
val White800: Color = Color(0xFFE0E0E0)
val BlackAlpha80: Color = Color(0xAA000000)
val BlackAlpha50: Color = Color(0x7F000000)
val Beige300: Color = Color(0xFF4A9CAF)
val Red500: Color = Color(0xFF371722)
val Red700: Color = Color(0xFF1A4650)
val Red800: Color = Color(0xFF250A0A)
val Red900: Color = Color(0xFF160808)
val Beige400: Color = Color(0xFFDDC7B7)
val Beige500: Color = Color(0xFFBBAB9B)

val OSU_BRIGHT_RED: Color = Color(0xFFDE4C9B)
val OSU_DARK_RED: Color = Color(0xFF73184D)
val OSU_BRIGHT_RED_HALF_TRANS: Color = Color(0x80DE4C9B)
val OSU_BRIGHT_YELLOW: Color = Color(0xFFFFCC22)
val OSU_BRIGHT_YELLOW_HALF_TRANS: Color = Color(0x80FFCC22)

val OSU_LEVEL_WHITE_1: Color = Color(0xFFF0F0F0)
val OSU_LEVEL_WHITE_2: Color = Color(0xFFFDF6FB)
val OSU_LEVEL_BLUE_1: Color = Color(0xFFA3E7FF)
val OSU_LEVEL_BLUE_2: Color = Color(0xFF77E1FD)
val OSU_LEVEL_GREEN_1: Color = Color(0xFFB1FF9D)
val OSU_LEVEL_GREEN_2: Color = Color(0xFF5DF237)
val OSU_LEVEL_YELLOW_1: Color = Color(0xFFFFFA7B)
val OSU_LEVEL_YELLOW_2: Color = Color(0xFFFAF100)
val OSU_LEVEL_RED_1: Color = Color(0xFFFF9394)
val OSU_LEVEL_RED_2: Color = Color(0xFFF34143)
val OSU_LEVEL_PURPLE_1: Color = Color(0xFFD392FF)
val OSU_LEVEL_PURPLE_2: Color = Color(0xFFB953FE)
val OSU_LEVEL_BRONZE_1: Color = Color(0xFFFACA9C)
val OSU_LEVEL_BRONZE_2: Color = Color(0xFFEBAD7B)
val OSU_LEVEL_SILVER_1: Color = Color(0xFFD5FAFC)
val OSU_LEVEL_SILVER_2: Color = Color(0xFF95B4CA)
val OSU_LEVEL_GOLD_1: Color = Color(0xFFF5FB62)
val OSU_LEVEL_GOLD_2: Color = Color(0xFFD2AC27)
val OSU_LEVEL_PLATINUM_1: Color = Color(0xFFFFFEB3)
val OSU_LEVEL_PLATINUM_2: Color = Color(0xFFCFD360)

val OSU_ROTATE_GREEN: Color = Color(0xFF66FF73)
val OSU_HEART_RED: Color = Color(0xFFFF66AB)
val OSU_ARROW_YELLOW: Color = Color(0xFFFFD966)

val OSU_X_BG: Color = Color(0xFF000000)
val OSU_DISCORD_BG: Color = Color(0xFF5865F2)
val OSU_DISCORD_TEXT: Color = Color(0xFFFFFFFF)

val TEXT_GRAY: Color = Color(0xFF818181)
val BG_DARK_GRAY: Color = Color(0xFF2A2A2A)

val RANKING_RED: Color = Color(0xFFD32F2F)
val RANKING_BLUE: Color = Color(0xFF2A518D)
val RANKING_GREEN: Color = Color(0xFF388E3C)
val RANKING_YELLOW: Color = Color(0xFFFBC02D)

val CHUNI_DIFF_BASIC: Color = Color(0xFF4CAF50)
val CHUNI_DIFF_ADVANCED: Color = Color(0xFFFF9800)
val CHUNI_DIFF_EXPERT: Color = Color(0xFFE35454)
val CHUNI_DIFF_MASTER: Color = Color(0xFFBF6AFF)
val CHUNI_DIFF_ULTIMA_1: Color = Color(0xFF202020)
val CHUNI_DIFF_ULTIMA_2: Color = Color(0xFFFF3A3A)

val tab_indicator_background: Color = Color(0xFFDCDCDC)
val tab_background: Color = Color(0xFFFAFAFA)

object GradientBrush {
    val WhiteGradientBg: Brush = Brush.verticalGradient(
        colors = listOf(
            OSU_LEVEL_WHITE_1,
            OSU_LEVEL_WHITE_2
        )
    )
    val BlueGradientBg: Brush = Brush.verticalGradient(
        colors = listOf(
            OSU_LEVEL_BLUE_1,
            OSU_LEVEL_BLUE_2
        )
    )
    val GreenGradientBg: Brush = Brush.verticalGradient(
        colors = listOf(
            OSU_LEVEL_GREEN_1,
            OSU_LEVEL_GREEN_2
        )
    )
    val YellowGradientBg: Brush = Brush.verticalGradient(
        colors = listOf(
            OSU_LEVEL_YELLOW_1,
            OSU_LEVEL_YELLOW_2
        )
    )
    val RedGradientBg: Brush = Brush.verticalGradient(
        colors = listOf(
            OSU_LEVEL_RED_1,
            OSU_LEVEL_RED_2
        )
    )
    val PurpleGradientBg: Brush = Brush.verticalGradient(
        colors = listOf(
            OSU_LEVEL_PURPLE_1,
            OSU_LEVEL_PURPLE_2
        )
    )
    val BronzeGradientBg: Brush = Brush.verticalGradient(
        colors = listOf(
            OSU_LEVEL_BRONZE_1,
            OSU_LEVEL_BRONZE_2
        )
    )
    val SilverGradientBg: Brush = Brush.verticalGradient(
        colors = listOf(
            OSU_LEVEL_SILVER_1,
            OSU_LEVEL_SILVER_2
        )
    )
    val GoldGradientBg: Brush = Brush.verticalGradient(
        colors = listOf(
            OSU_LEVEL_GOLD_1,
            OSU_LEVEL_GOLD_2
        )
    )
    val PlatinumGradientBg: Brush = Brush.verticalGradient(
        colors = listOf(
            OSU_LEVEL_PLATINUM_1,
            OSU_LEVEL_PLATINUM_2
        )
    )
    val RainbowGradientBg: Brush = Brush.verticalGradient(
        colors = listOf(
            OSU_LEVEL_RED_1,
            OSU_LEVEL_YELLOW_1,
            OSU_LEVEL_BLUE_1,
            OSU_LEVEL_GREEN_1,
            OSU_LEVEL_PURPLE_1,
        )
    )
    val WhiteGradientText: Brush = Brush.verticalGradient(
        0.2f to OSU_LEVEL_WHITE_1,
        0.8f to OSU_LEVEL_WHITE_2
    )
    val BlueGradientText: Brush = Brush.verticalGradient(
        0.2f to OSU_LEVEL_BLUE_1,
        0.8f to OSU_LEVEL_BLUE_2
    )
    val GreenGradientText: Brush = Brush.verticalGradient(
        0.2f to OSU_LEVEL_GREEN_1,
        0.8f to OSU_LEVEL_GREEN_2
    )
    val YellowGradientText: Brush = Brush.verticalGradient(
        0.2f to OSU_LEVEL_YELLOW_1,
        0.8f to OSU_LEVEL_YELLOW_2
    )
    val RedGradientText: Brush = Brush.verticalGradient(
        0.2f to OSU_LEVEL_RED_1,
        0.8f to OSU_LEVEL_RED_2
    )
    val PurpleGradientText: Brush = Brush.verticalGradient(
        0.2f to OSU_LEVEL_PURPLE_1,
        0.8f to OSU_LEVEL_PURPLE_2
    )
    val BronzeGradientText: Brush = Brush.verticalGradient(
        0.2f to OSU_LEVEL_BRONZE_1,
        0.8f to OSU_LEVEL_BRONZE_2
    )
    val SilverGradientText: Brush = Brush.verticalGradient(
        0.2f to OSU_LEVEL_SILVER_1,
        0.8f to OSU_LEVEL_SILVER_2
    )
    val GoldGradientText: Brush = Brush.verticalGradient(
        0.2f to OSU_LEVEL_GOLD_1,
        0.8f to OSU_LEVEL_GOLD_2
    )
    val PlatinumGradientText: Brush = Brush.verticalGradient(
        0.2f to OSU_LEVEL_PLATINUM_1,
        0.8f to OSU_LEVEL_PLATINUM_2
    )
    val RainbowGradientText: Brush = Brush.verticalGradient(
        0.2f to OSU_LEVEL_RED_1,
        0.4f to OSU_LEVEL_YELLOW_1,
        0.5f to OSU_LEVEL_BLUE_1,
        0.6f to OSU_LEVEL_GREEN_1,
        0.8f to OSU_LEVEL_PURPLE_1
    )
}