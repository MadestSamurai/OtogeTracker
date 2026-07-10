package com.madsam.otora.ui.bof

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import com.madsam.otora.ui.common.RankingTableColors

internal object BofRankingColors {
    val Background: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.surfaceContainerLowest

    val RowAlt: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.surfaceContainerLow

    val Header: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.surfaceContainerHigh

    val ToolbarContainer: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.surfaceContainerHigh

    val BackContainer: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.secondaryContainer

    val OnBackContainer: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.onSecondaryContainer

    val PrimaryContainer: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.primaryContainer

    val OnPrimaryContainer: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.onPrimaryContainer

    val Text: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.onSurface

    val TextSecondary: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.onSurfaceVariant

    val Primary: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.primary

    val Positive: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.tertiary

    val Negative: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.error

    val Blue: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.secondary

    val Tertiary: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.tertiary

    val Accent: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.tertiary

    val Neutral: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.outline

    val Score: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.primary

    val OnScore: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.onPrimary

    val OnBlue: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.onSecondary

    val Compare: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.tertiary

    val OnCompare: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.onTertiary

    val Table: RankingTableColors
        @Composable
        @ReadOnlyComposable
        get() {
            val scheme = MaterialTheme.colorScheme
            return RankingTableColors(
                background = scheme.surfaceContainerLowest,
                rowAlt = scheme.surfaceContainerLow,
                header = scheme.surfaceContainerHigh,
                text = scheme.onSurface,
                textSecondary = scheme.onSurfaceVariant,
                positive = scheme.tertiary,
                negative = scheme.error,
                neutral = scheme.outline,
                scoreBar = scheme.primary,
                scoreBarText = scheme.onPrimary,
                compareBar = scheme.tertiary,
                compareBarText = scheme.onTertiary,
                searchHighlight = scheme.tertiaryContainer,
                searchHighlightText = scheme.onTertiaryContainer,
                scoreHeat = { score ->
                    scoreHeat(
                        score = score,
                        lowColor = scheme.surfaceContainerLowest,
                        highColor = scheme.primaryContainer
                    )
                }
            )
        }

    @Composable
    @ReadOnlyComposable
    fun scoreHeat(score: Number): Color {
        val scheme = MaterialTheme.colorScheme
        return scoreHeat(
            score = score,
            lowColor = scheme.surfaceContainerLowest,
            highColor = scheme.primaryContainer
        )
    }

    private fun scoreHeat(score: Number, lowColor: Color, highColor: Color): Color {
        val intensity = (score.toDouble() / 1000.0).toFloat().coerceIn(0f, 1f)
        return lerp(lowColor, highColor, intensity)
    }
}
