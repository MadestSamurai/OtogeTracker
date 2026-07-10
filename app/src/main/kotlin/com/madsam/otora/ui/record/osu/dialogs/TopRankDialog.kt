package com.madsam.otora.ui.record.osu.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.madsam.otora.R
import com.madsam.otora.core.theme.BlackAlpha80
import com.madsam.otora.data.osu.ui.model.OsuTopRankUiModel
import com.madsam.otora.ui.record.osu.components.TopRankCard
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun TopRankDialog(
    title: String,
    topRankList: MutableStateFlow<List<OsuTopRankUiModel>>,
    onDismiss: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val data by topRankList.collectAsState()
    val density = LocalDensity.current
    val windowInfo = LocalWindowInfo.current
    val screenWidthDp = with(density) {
        windowInfo.containerSize.width.toDp()
    }
    val screenHeightDp = with(density) {
        windowInfo.containerSize.height.toDp()
    }
    val cardWidthDp = screenWidthDp * 0.9f - 32.dp

    val scrimColor = BlackAlpha80
    val properties = DialogProperties(
        dismissOnClickOutside = true,
        usePlatformDefaultWidth = false
    )

    Dialog(
        onDismissRequest = onDismiss,
        properties = properties
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(scrimColor)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    if (properties.dismissOnClickOutside) {
                        onDismiss()
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .width(screenWidthDp * 0.9f)
                    .heightIn(
                        min = 100.dp,
                        max = screenHeightDp * 0.8f
                    )
                    .clip(RoundedCornerShape(16.dp))
                    .background(colorScheme.surfaceContainerHigh)
                    .padding(16.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { /* Prevent click propagation */ }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineSmall,
                        color = colorScheme.onSurface
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = stringResource(R.string.osu_action_close),
                            tint = colorScheme.onSurface,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                if (data.isEmpty()) {
                    Text(
                        text = stringResource(R.string.osu_no_records_found),
                        color = colorScheme.onSurface,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.clip(RoundedCornerShape(6.dp))
                    ) {
                        items(
                            count = data.size,
                            key = { index -> data[index].scoreId }
                        ) { index ->
                            TopRankCard(
                                item = data[index],
                                itemWidth = cardWidthDp
                            )
                            if (index != data.size - 1) {
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
