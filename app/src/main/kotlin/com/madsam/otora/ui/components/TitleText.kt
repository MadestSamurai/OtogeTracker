package com.madsam.otora.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.sarasaSemiBold

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
        color = Red500,
        modifier = modifier
    ) {
        Column {
            Text(
                text = textTitle,
                fontSize = titleSize,
                color = color,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
            Text(
                text = text,
                fontSize = titleTextSize,
                fontFamily = sarasaSemiBold,
                color = color,
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
            )
        }
    }
}