package com.madsam.otora.ui.record.osu.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Red700
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
    val pinnedData by pinnedMaps.collectAsState()
    val topData by topMaps.collectAsState()
    val firstData by firstMaps.collectAsState()

    val screenWidthDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }

    Surface(
        Modifier
            .width(screenWidthDp)
            .padding(vertical = 12.dp),
        RoundedCornerShape(20.dp),
        Red700
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 10.dp, top = 10.dp)
        ) {
            if (pinnedData.items.isEmpty() && topData.items.isEmpty() && firstData.items.isEmpty()) {
                Text(
                    text = "No play records",
                    color = Beige400,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
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
}
