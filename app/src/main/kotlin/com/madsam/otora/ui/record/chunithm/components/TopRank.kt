package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.BlackAlpha50
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.utils.CommonUtils.getRatingBrush
import com.madsam.otora.data.chunithm.ui.model.ChunithmTopRankUiModel
import com.madsam.otora.ui.components.RoundedBarChart
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Locale

@Composable
internal fun TopRank(
    topRankUI: MutableStateFlow<ChunithmTopRankUiModel>
) {
    val topRank by topRankUI.collectAsState()
    val screenWidthDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }
    val cardWidthDp = screenWidthDp - 24.dp
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Red700)
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .width(cardWidthDp * 0.73f)
                .padding(start = 4.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Red500)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 6.dp, top = 6.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(BlackAlpha50)
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                Text(
                    text = "Best 30",
                    fontSize = 12.sp,
                    color = White1000
                )
                Text(
                    text = String.format(Locale.US, "%.2f", topRank.best30),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        brush = getRatingBrush(topRank.best30.toString())
                    )
                )
            }
            if (topRank.bestList.isNotEmpty()) {
                RoundedBarChart(
                    values = topRank.bestList.map { it.rating },
                    minValue = topRank.bestList.minOfOrNull { it.rating } ?: 0.0,
                    maxValue = topRank.bestList.maxOfOrNull { it.rating } ?: 0.0,
                    height = 80.dp,
                    modifier = Modifier
                        .width(cardWidthDp / 10 * 7)
                        .padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 4.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .width(cardWidthDp * 0.27f)
                .padding(horizontal = 4.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Red500)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 6.dp, top = 6.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(BlackAlpha50)
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                Text(
                    text = "Recent 10",
                    fontSize = 12.sp,
                    color = White1000
                )
                Text(
                    text = String.format(Locale.US, "%.2f", topRank.recent10),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        brush = getRatingBrush(topRank.recent10.toString())
                    )
                )
            }
            if (topRank.bestList.isNotEmpty()) {
                RoundedBarChart(
                    values = topRank.recentList.map { it.rating },
                    minValue = topRank.recentList.minOfOrNull { it.rating } ?: 0.0,
                    maxValue = topRank.recentList.maxOfOrNull { it.rating } ?: 0.0,
                    height = 80.dp,
                    modifier = Modifier
                        .width(cardWidthDp / 10 * 3)
                        .padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 4.dp)
                )
            }
        }
    }
}