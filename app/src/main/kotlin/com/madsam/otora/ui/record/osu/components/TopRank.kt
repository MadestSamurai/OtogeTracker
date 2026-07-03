package com.madsam.otora.ui.record.osu.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.plexSemi
import com.madsam.otora.data.osu.ui.model.OsuBriefUiModel
import com.madsam.otora.data.osu.ui.model.OsuTopRankUiModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun TopRank(
    pinnedMaps: MutableStateFlow<OsuBriefUiModel<OsuTopRankUiModel>>,
    topMaps: MutableStateFlow<OsuBriefUiModel<OsuTopRankUiModel>>,
    firstMaps: MutableStateFlow<OsuBriefUiModel<OsuTopRankUiModel>>,
    pinnedOnMoreClick: () -> Unit,
    topOnMoreClick: () -> Unit,
    firstOnMoreClick: () -> Unit,
    cardWidthDp: Dp
) {
    val colorScheme = MaterialTheme.colorScheme
    val pinnedData by pinnedMaps.collectAsState()
    val topData by topMaps.collectAsState()
    val firstData by firstMaps.collectAsState()

    Column(
        modifier = Modifier
            .width(cardWidthDp)
            .padding(bottom = 12.dp)
    ) {
        if (pinnedData.items.isEmpty() && topData.items.isEmpty() && firstData.items.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.BarChart,
                    contentDescription = null,
                    tint = colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "No play records",
                    color = colorScheme.onSurfaceVariant,
                    fontSize = 16.sp,
                    fontFamily = plexSemi
                )
            }
            return@Column
        }
        if (pinnedData.items.isNotEmpty()) {
            TopRankList(pinnedData, "Pinned", cardWidthDp) {
                pinnedOnMoreClick()
            }
        }
        if (topData.items.isNotEmpty()) {
            TopRankList(topData, "Top", cardWidthDp) {
                topOnMoreClick()
            }
        }
        if (firstData.items.isNotEmpty()) {
            TopRankList(firstData, "First", cardWidthDp) {
                firstOnMoreClick()
            }
        }
    }
}
