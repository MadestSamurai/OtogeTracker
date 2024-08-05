package com.madsam.otora.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
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
    text: String,
    color: Color,
    modifier: Modifier,
    showPopup: Boolean,
) {
    AnimatedVisibility(
        visible = showPopup,
        modifier = modifier,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
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
    }
}