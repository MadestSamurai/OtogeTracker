package com.madsam.otora.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(
    textTitle: String,
    text: AnnotatedString,
    color: Color,
    modifier: Modifier
) {
    val colorScheme = MaterialTheme.colorScheme
    Surface(
        shape = RoundedCornerShape(
            topStart = 6.dp,
            topEnd = 6.dp,
            bottomStart = 6.dp,
            bottomEnd = 6.dp
        ),
        color = colorScheme.surfaceContainer,
        modifier = modifier
    ) {
        Column {
            Text(
                text = textTitle,
                style = MaterialTheme.typography.bodyLarge,
                color = color,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
            Text(
                text = text,
                style = MaterialTheme.typography.titleLarge,
                color = color,
                letterSpacing = (-0.5).sp,
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
            )
        }
    }
}