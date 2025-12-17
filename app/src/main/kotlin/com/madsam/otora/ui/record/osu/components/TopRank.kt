package com.madsam.otora.ui.record.osu.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.sarasaSemiBold
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
            Text(
                text = "No play records",
                color = colorScheme.onSurface,
                fontSize = 24.sp,
                fontFamily = sarasaSemiBold,
                modifier = Modifier.padding(16.dp)
            )
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
