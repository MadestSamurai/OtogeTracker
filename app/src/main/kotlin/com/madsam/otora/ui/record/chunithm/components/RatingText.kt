package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.theme.plexRegular
import com.madsam.otora.core.theme.plexSemi
import com.madsam.otora.core.utils.BrushUtils.getRatingTextBrush
import com.madsam.otora.core.utils.BrushUtils.getRatingTextColor
import com.madsam.otora.core.utils.BrushUtils.getRatingTextStrokeColor

@Composable
internal fun RatingValueText(
    rating: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily = plexBold,
    outlineWidth: Float = 4.2f,
) {
    val isDark = isSystemInDarkTheme()
    val fillColor = getRatingTextColor(rating, isDark)
    val strokeColor = getRatingTextStrokeColor(rating, isDark)
    val fillBrush = getRainbowRatingBrushOrNull(rating, isDark)
    val resolvedFontFamily = when (fontFamily) {
        plexBold -> plexSemi
        plexSemi -> plexRegular
        else -> plexRegular
    }
    val actualOutlineWidth = if (isDark) outlineWidth else outlineWidth * 0.95f

    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = rating,
            color = strokeColor,
            fontSize = fontSize,
            fontFamily = resolvedFontFamily,
            style = TextStyle(
                drawStyle = Stroke(width = actualOutlineWidth)
            )
        )
        Text(
            text = rating,
            color = if (fillBrush == null) fillColor else fillColor,
            fontSize = fontSize,
            fontFamily = resolvedFontFamily,
            style = if (fillBrush != null) {
                TextStyle(brush = fillBrush)
            } else {
                TextStyle.Default
            }
        )
    }
}

private fun getRainbowRatingBrushOrNull(rating: String, isDark: Boolean): Brush? {
    return try {
        when (rating.toFloat()) {
            in 16.00..18.000 -> getRatingTextBrush(rating, isDark)
            else -> null
        }
    } catch (_: NumberFormatException) {
        null
    }
}

@Composable
internal fun LabeledRatingText(
    rating: String,
    modifier: Modifier = Modifier,
    label: String = "RATING",
    labelFontSize: TextUnit,
    ratingFontSize: TextUnit,
    fontFamily: FontFamily = plexBold,
    labelColor: Color = MaterialTheme.colorScheme.primary,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = labelColor,
            fontSize = labelFontSize,
            fontFamily = plexRegular
        )
        Spacer(modifier = Modifier.width(2.dp))
        RatingValueText(
            rating = rating,
            fontSize = ratingFontSize,
            fontFamily = fontFamily
        )
    }
}