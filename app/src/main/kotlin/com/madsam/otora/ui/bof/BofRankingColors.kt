package com.madsam.otora.ui.bof

import androidx.compose.ui.graphics.Color
import com.madsam.otora.ui.common.RankingTableColors

internal object BofRankingColors {
    val Background = Color(0xFF080A0D)
    val RowAlt = Color(0xFF151A20)
    val Header = Color(0xFF1C242C)
    val Text = Color(0xFFE8EAED)
    val TextSecondary = Color(0xFFA6AFBA)
    val Positive = Color(0xFF62C986)
    val Negative = Color(0xFFE75A66)
    val Blue = Color(0xFF6F9FE8)
    val Accent = Color(0xFFFFCF66)
    val Neutral = Color(0xFF858E99)
    val Table = RankingTableColors(
        background = Background,
        rowAlt = RowAlt,
        header = Header,
        text = Text,
        textSecondary = TextSecondary,
        positive = Positive,
        negative = Negative,
        neutral = Neutral,
        scoreBar = Negative,
        compareBar = Blue,
        searchHighlight = Negative.copy(alpha = 0.72f),
        scoreHeat = ::scoreHeat
    )

    fun scoreHeat(score: Number): Color {
        val intensity = (score.toDouble() / 1000.0).toFloat().coerceIn(0f, 1f)
        return if (intensity <= 0f) {
            Color.Transparent
        } else {
            Negative.copy(alpha = 0.2f + intensity * 0.55f)
        }
    }
}
