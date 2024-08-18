package com.madsam.otora.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.madsam.otora.consts.Colors

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.component.TitleText
 * 创建者: MadSamurai
 * 创建时间: 2024/8/1
 * 描述: 标题文字
 */

@Composable
fun TitleText(
    textTitle: String,
    text: String,
    titleSize: TextUnit,
    titleTextSize: TextUnit,
    color: Color,
    modifier: Modifier
) {
    Surface(
        shape = RoundedCornerShape(
            topStart = 6.dp,
            topEnd = 6.dp,
            bottomStart = 6.dp,
            bottomEnd = 6.dp
        ),
        color = Colors.DARK_RED_DEEPER,
        modifier = modifier
    ) {
        Column {
            Text(
                text = textTitle,
                fontSize = titleSize,
                color = color,
                modifier = Modifier.padding(start = 14.dp, top = 8.dp, end = 16.dp)
            )
            Text(
                text = text,
                fontSize = titleTextSize,
                fontWeight = FontWeight.Bold,
                color = color,
                modifier = Modifier.padding(start = 14.dp, end = 16.dp, bottom = 8.dp)
            )
        }
    }
}

@Composable
fun TitleText(
    textTitle: String,
    text: AnnotatedString,
    titleSize: TextUnit,
    titleTextSize: TextUnit,
    color: Color,
    modifier: Modifier
) {
    Surface(
        shape = RoundedCornerShape(
            topStart = 6.dp,
            topEnd = 6.dp,
            bottomStart = 6.dp,
            bottomEnd = 6.dp
        ),
        color = Colors.DARK_RED_DEEPER,
        modifier = modifier
    ) {
        Column {
            Text(
                text = textTitle,
                fontSize = titleSize,
                color = color,
                modifier = Modifier.padding(start = 14.dp, top = 8.dp, end = 16.dp)
            )
            Text(
                text = text,
                fontSize = titleTextSize,
                fontWeight = FontWeight.Bold,
                color = color,
                modifier = Modifier.padding(start = 14.dp, end = 16.dp, bottom = 8.dp)
            )
        }
    }
}