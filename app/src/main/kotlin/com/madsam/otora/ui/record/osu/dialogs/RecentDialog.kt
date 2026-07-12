package com.madsam.otora.ui.record.osu.dialogs

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.madsam.otora.R
import com.madsam.otora.data.osu.ui.model.OsuRecentUiModel
import com.madsam.otora.ui.record.osu.components.RecentItem
import com.madsam.otora.ui.record.osu.components.RecentItemSpacing
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun RecentDialog(
    recentActivityList: MutableStateFlow<List<OsuRecentUiModel>>,
    onDismiss: () -> Unit
) {
    val activities by recentActivityList.collectAsState()

    OsuExpandableBottomSheet(
        title = stringResource(R.string.osu_dialog_recent_activities),
        onDismiss = onDismiss
    ) { contentWidth ->
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            items(
                count = activities.size,
                key = { index -> index }
            ) { index ->
                RecentItem(
                    activity = activities[index],
                    cardWidthDp = contentWidth
                )
                if (index != activities.lastIndex) {
                    Spacer(modifier = Modifier.height(RecentItemSpacing))
                }
            }
        }
    }
}
