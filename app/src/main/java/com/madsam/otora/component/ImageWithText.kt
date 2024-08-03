package com.madsam.otora.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.component.ImageWithText
 * 创建者: MadSamurai
 * 创建时间: 2024/8/3
 * 描述: TODO
 */
@Composable
fun ImageWithText(
    painter: Painter,
    contentDescription: String,
    text: String,
    textSize: TextUnit,
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
            fontSize = textSize,
            fontWeight = FontWeight.Bold,
            modifier = textModifier
                .align(Alignment.CenterHorizontally)
        )
    }
}