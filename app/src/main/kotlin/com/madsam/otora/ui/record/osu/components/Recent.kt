package com.madsam.otora.ui.record.osu.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.data.osu.ui.model.OsuBriefUiModel
import com.madsam.otora.data.osu.ui.model.OsuRecentUiModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun Recent(
    recentActivityList: MutableStateFlow<OsuBriefUiModel<OsuRecentUiModel>>,
    onMoreClick: () -> Unit
) {
    val activities by recentActivityList.collectAsState()
    if (activities.items.isEmpty()) {
        return
    }

    val recentList = activities.items
    val isComplete = activities.isComplete

    val screenWidthDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }
    val cardWidthDp = screenWidthDp - 24.dp

    Surface(
        Modifier
            .width(screenWidthDp)
            .padding(top = 12.dp),
        RoundedCornerShape(20.dp),
        Red700
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 10.dp, top = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Recent",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Beige400,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                if (isComplete) return@Row
                TextButton(
                    onClick = onMoreClick,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .defaultMinSize(1.dp, 1.dp)
                        .height(24.dp)
                ) {
                    Text(
                        text = "More",
                        color = Beige400,
                        fontSize = 16.sp
                    )
                }
            }
            recentList.forEach {
                RecentItem(it, cardWidthDp)
                if (recentList.indexOf(it) < recentList.size - 1) {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}
