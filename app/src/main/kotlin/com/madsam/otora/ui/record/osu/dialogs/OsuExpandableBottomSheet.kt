package com.madsam.otora.ui.record.osu.dialogs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun OsuExpandableBottomSheet(
    title: String,
    onDismiss: () -> Unit,
    content: @Composable ColumnScope.(contentWidth: Dp) -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        modifier = Modifier.fillMaxHeight(),
        sheetState = sheetState,
        sheetMaxWidth = Dp.Unspecified,
        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
        containerColor = colorScheme.surfaceContainerHigh,
        contentColor = colorScheme.onSurface,
        dragHandle = {
            BottomSheetDefaults.DragHandle(color = colorScheme.onSurfaceVariant)
        }
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val contentWidth = (maxWidth - 32.dp).coerceAtLeast(0.dp)

            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 52.dp)
                        .padding(start = 20.dp, end = 20.dp, bottom = 4.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineSmall,
                        color = colorScheme.onSurface,
                        lineHeight = 32.sp
                    )
                }

                content(contentWidth)
            }
        }
    }
}
