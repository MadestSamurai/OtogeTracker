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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.data.osu.ui.model.OsuBriefUiModel
import com.madsam.otora.data.osu.ui.model.OsuTopRankUiModel

@Composable
internal fun TopRankList(
    items: OsuBriefUiModel<OsuTopRankUiModel>,
    title: String,
    cardWidth: Dp,
    onMoreClick: () -> Unit = {}
) {
    val list = items.items
    Column(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .clip(RoundedCornerShape(6.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Beige400,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            if (items.isComplete) return@Row
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
        val itemWidth = cardWidth - 16.dp
        list.forEach {
            TopRankCard(it, itemWidth)
            if (list.indexOf(it) < list.size - 1) {
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
