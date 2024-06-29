package com.madsam.otora.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GradientBorderCircle(
    modifier: Modifier = Modifier,
    gradient: Brush,
    borderSize: Dp,
    circleSize: Dp,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        Canvas(
            modifier = Modifier.size(circleSize)
        ) {
            val strokeWidth = borderSize.toPx()
            val halfSize = size.minDimension / 2
            val radius = halfSize - strokeWidth / 2
            drawCircle(
                brush = gradient,
                radius = radius,
                center = Offset(halfSize, halfSize),
                style = Stroke(strokeWidth, cap = StrokeCap.Round)
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(circleSize)
                .padding(borderSize)
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun GradientBorderSurfacePreview() {
    GradientBorderCircle(
        gradient = Brush.verticalGradient(
            colors = listOf(
                Color.Red,
                Color.Blue
            )
        ),
        borderSize = 4.dp,
        circleSize = 100.dp
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Hello, World!",
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}