package com.madsam.otora.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun ImageWithText(
    painter: Painter,
    contentDescription: String,
    text: String,
    textColor: Color,
    modifier: Modifier,
    iconModifier: Modifier,
    textModifier: Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = iconModifier
        )
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.titleMedium,
            modifier = textModifier
                .align(Alignment.CenterHorizontally)
        )
    }
}