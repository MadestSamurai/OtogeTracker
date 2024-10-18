package com.madsam.otora.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.madsam.otora.consts.Colors
import kotlinx.coroutines.delay

@Composable
fun PopupTip(
    text: String,
    color: Color,
    modifier: Modifier,
    showPopup: MutableTransitionState<Boolean>,
    alignment: Alignment
) {
    if (showPopup.currentState || showPopup.targetState || !showPopup.isIdle) {
        Box(modifier = modifier) {
            Popup(
                alignment = alignment,
            ) {
                AnimatedVisibility(
                    visibleState = showPopup,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Text(
                        text = text,
                        color = color,
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        modifier = Modifier
                            .background(
                                color = Colors.BG_HALF_TRANS_BLACK,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(3.dp)
                    )
                }
            }
        }
        LaunchedEffect(showPopup.targetState) {
            delay(1500)
            showPopup.targetState = false
        }
    }
}