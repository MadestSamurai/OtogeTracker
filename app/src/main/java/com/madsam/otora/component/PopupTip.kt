package com.madsam.otora.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.madsam.otora.consts.Colors
import kotlinx.coroutines.delay

@Composable
fun PopupTip(
    showPopup: Boolean,
    offset: IntOffset,
    onDismissRequest: () -> Unit,
    text: String,
    color: Color
) {
    if (showPopup) {
        Popup(
            onDismissRequest = onDismissRequest,
            content = {
                Text(
                    text = text,
                    color = color,
                    modifier = Modifier
                        .background(
                            color = Colors.BG_HALF_TRANS_BLACK,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(4.dp)
                )
            },
            offset = IntOffset(offset.x, offset.y+8),
        )

    }
    LaunchedEffect(key1 = showPopup) {
        delay(1500L) // Wait for 1.5 seconds
        onDismissRequest()
    }
}