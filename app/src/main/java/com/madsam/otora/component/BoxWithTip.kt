package com.madsam.otora.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

@Composable
fun BoxWithTip(
    modifier: Modifier,
    onClick: (IntOffset) -> Unit,
    content: @Composable () -> Unit
) {
    var position by remember { mutableStateOf(IntOffset(0,0)) }

    Box(
        modifier = modifier
            .clickable(onClick = { onClick(position) })
            .onGloballyPositioned { coordinates ->
                position = IntOffset(
                    x = coordinates.parentCoordinates?.positionInParent()?.x?.roundToInt() ?: 0,
                    y = coordinates.parentCoordinates?.positionInParent()?.y?.roundToInt()
                        ?.plus(coordinates.size.height) ?: 0
                )
            }
    ) {
        content()
    }
}