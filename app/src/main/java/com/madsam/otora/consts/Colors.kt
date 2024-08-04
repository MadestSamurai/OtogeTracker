package com.madsam.otora.consts

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * 项目名: OtogeTracker
 * 文件名: Colors
 * 创建者: MadSamurai
 * 创建时间:2023/3/9 16:59
 * 描述: 颜色常量类
 */
object Colors {
    val TEXT_WHITE: Color = Color(android.graphics.Color.parseColor("#e0e0e0"))
    val BG_HALF_TRANS_BLACK: Color = Color(android.graphics.Color.parseColor("#aa000000"))
    val DARK_RED_DEEP: Color = Color(android.graphics.Color.parseColor("#2b0f0f"))
    val DARK_RED_DEEPER: Color = Color(android.graphics.Color.parseColor("#250a0a"))
    val DARK_RED: Color = Color(android.graphics.Color.parseColor("#371722"))
    val DARKER_RED: Color = Color(android.graphics.Color.parseColor("#160808"))
    val BRIGHT_RED: Color = Color(android.graphics.Color.parseColor("#834858"))
    val DARK_RED_TEXT: Color = Color(android.graphics.Color.parseColor("#bbab9b"))
    val DARK_RED_TEXT_LIGHT: Color = Color(android.graphics.Color.parseColor("#ddc7b7"))

    val OSU_BRIGHT_RED: Color = Color(android.graphics.Color.parseColor("#de4c9b"))
    val OSU_DARK_RED: Color = Color(android.graphics.Color.parseColor("#73184d"))
    val OSU_BRIGHT_RED_HALF_TRANS: Color = Color(android.graphics.Color.parseColor("#aade4c9b"))
    val OSU_BRIGHT_YELLOW: Color = Color(android.graphics.Color.parseColor("#ffcc22"))
    val OSU_BRIGHT_YELLOW_HALF_TRANS: Color = Color(android.graphics.Color.parseColor("#aaffcc22"))

    val OSU_LEVEL_WHITE_1: Color = Color(android.graphics.Color.parseColor("#f0f0f0"))
    val OSU_LEVEL_WHITE_2: Color = Color(android.graphics.Color.parseColor("#fdf6fb"))
    val OSU_LEVEL_BLUE_1: Color = Color(android.graphics.Color.parseColor("#a3e7ff"))
    val OSU_LEVEL_BLUE_2: Color = Color(android.graphics.Color.parseColor("#77e1fd"))
    val OSU_LEVEL_GREEN_1: Color = Color(android.graphics.Color.parseColor("#b1ff9d"))
    val OSU_LEVEL_GREEN_2: Color = Color(android.graphics.Color.parseColor("#5df237"))
    val OSU_LEVEL_YELLOW_1: Color = Color(android.graphics.Color.parseColor("#fffa7b"))
    val OSU_LEVEL_YELLOW_2: Color = Color(android.graphics.Color.parseColor("#faf100"))
    val OSU_LEVEL_RED_1: Color = Color(android.graphics.Color.parseColor("#ff9394"))
    val OSU_LEVEL_RED_2: Color = Color(android.graphics.Color.parseColor("#f34143"))
    val OSU_LEVEL_PURPLE_1: Color = Color(android.graphics.Color.parseColor("#d392ff"))
    val OSU_LEVEL_PURPLE_2: Color = Color(android.graphics.Color.parseColor("#b953fe"))
    val OSU_LEVEL_BRONZE_1: Color = Color(android.graphics.Color.parseColor("#faca9c"))
    val OSU_LEVEL_BRONZE_2: Color = Color(android.graphics.Color.parseColor("#ebad7b"))
    val OSU_LEVEL_SILVER_1: Color = Color(android.graphics.Color.parseColor("#d5fafc"))
    val OSU_LEVEL_SILVER_2: Color = Color(android.graphics.Color.parseColor("#95b4ca"))
    val OSU_LEVEL_GOLD_1: Color = Color(android.graphics.Color.parseColor("#f5fb62"))
    val OSU_LEVEL_GOLD_2: Color = Color(android.graphics.Color.parseColor("#d2ac27"))
    val OSU_LEVEL_PLATINUM_1: Color = Color(android.graphics.Color.parseColor("#fffeb3"))
    val OSU_LEVEL_PLATINUM_2: Color = Color(android.graphics.Color.parseColor("#cfd360"))

    val OSU_X_BG: Color = Color(android.graphics.Color.parseColor("#000000"))
    val OSU_X_TEXT: Color = Color(android.graphics.Color.parseColor("#ffffff"))
    val OSU_DISCORD_BG: Color = Color(android.graphics.Color.parseColor("#5865f2"))
    val OSU_DISCORD_TEXT: Color = Color(android.graphics.Color.parseColor("#ffffff"))
}

object GradientBrush {
    val OSU_LEVEL_WHITE: Brush = Brush.verticalGradient(
        colors = listOf(
            Colors.OSU_LEVEL_WHITE_1,
            Colors.OSU_LEVEL_WHITE_2
        )
    )
    val OSU_LEVEL_BLUE: Brush = Brush.verticalGradient(
        colors = listOf(
            Colors.OSU_LEVEL_BLUE_1,
            Colors.OSU_LEVEL_BLUE_2
        )
    )
    val OSU_LEVEL_GREEN: Brush = Brush.verticalGradient(
        colors = listOf(
            Colors.OSU_LEVEL_GREEN_1,
            Colors.OSU_LEVEL_GREEN_2
        )
    )
    val OSU_LEVEL_YELLOW: Brush = Brush.verticalGradient(
        colors = listOf(
            Colors.OSU_LEVEL_YELLOW_1,
            Colors.OSU_LEVEL_YELLOW_2
        )
    )
    val OSU_LEVEL_RED: Brush = Brush.verticalGradient(
        colors = listOf(
            Colors.OSU_LEVEL_RED_1,
            Colors.OSU_LEVEL_RED_2
        )
    )
    val OSU_LEVEL_PURPLE: Brush = Brush.verticalGradient(
        colors = listOf(
            Colors.OSU_LEVEL_PURPLE_1,
            Colors.OSU_LEVEL_PURPLE_2
        )
    )
    val OSU_LEVEL_BRONZE: Brush = Brush.verticalGradient(
        colors = listOf(
            Colors.OSU_LEVEL_BRONZE_1,
            Colors.OSU_LEVEL_BRONZE_2
        )
    )
    val OSU_LEVEL_SILVER: Brush = Brush.verticalGradient(
        colors = listOf(
            Colors.OSU_LEVEL_SILVER_1,
            Colors.OSU_LEVEL_SILVER_2
        )
    )
    val OSU_LEVEL_GOLD: Brush = Brush.verticalGradient(
        colors = listOf(
            Colors.OSU_LEVEL_GOLD_1,
            Colors.OSU_LEVEL_GOLD_2
        )
    )
    val OSU_LEVEL_PLATINUM: Brush = Brush.verticalGradient(
        colors = listOf(
            Colors.OSU_LEVEL_PLATINUM_1,
            Colors.OSU_LEVEL_PLATINUM_2
        )
    )
    val OSU_LEVEL_RAINBOW: Brush = Brush.verticalGradient(
        colors = listOf(
            Colors.OSU_LEVEL_RED_1,
            Colors.OSU_LEVEL_YELLOW_1,
            Colors.OSU_LEVEL_BLUE_1,
            Colors.OSU_LEVEL_GREEN_1,
            Colors.OSU_LEVEL_PURPLE_1,
        )
    )
}