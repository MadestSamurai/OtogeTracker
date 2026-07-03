package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.BG_DARK_GRAY

@Composable
internal fun SearchBar(
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val colorScheme = MaterialTheme.colorScheme
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = BG_DARK_GRAY
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
        ) {
            Icon(
                painter = rememberVectorPainter(image = Filled.Magnify),
                contentDescription = "Search",
                tint = colorScheme.onSurface,
                modifier = Modifier.padding(start = 4.dp, end = 8.dp)
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .height(32.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (searchText.isEmpty()) {
                    Text(
                        text = "Search Songs...",
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                BasicTextField(
                    value = searchText,
                    onValueChange = onSearchTextChanged,
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    textStyle = TextStyle(
                        color = Color.White
                    ),
                    singleLine = true,
                    cursorBrush = SolidColor(colorScheme.surfaceContainer),
                    interactionSource = interactionSource,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
                )
            }

            if (searchText.isNotEmpty()) {
                IconButton(
                    onClick = { onSearchTextChanged("") },
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .size(16.dp)
                ) {
                    Icon(
                        painter = rememberVectorPainter(image = Icons.Filled.Close),
                        contentDescription = "Clear",
                        tint = colorScheme.onSurface
                    )
                }
            }
        }
    }
}
