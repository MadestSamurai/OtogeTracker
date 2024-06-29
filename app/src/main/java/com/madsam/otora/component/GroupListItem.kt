package com.madsam.otora.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.madsam.otora.R
import com.madsam.otora.consts.Colors
import com.madsam.otora.entity.web.OsuGroup

/**
 * 项目名: OtogeTracker
 * 文件名: GroupListAdapter
 * 创建者: MadSamurai
 * 创建时间:2023/3/23 16:47
 * 描述:
 */

@Composable
fun GroupListItem(osuGroup: OsuGroup, onClick: (IntOffset) -> Unit) {
    var size by remember { mutableStateOf(IntOffset.Zero) }

    Row(
        modifier = Modifier
            .clickable(onClick = { onClick(size) })
            .onGloballyPositioned { coordinates ->
                val position = coordinates.size
                size = IntOffset (
                    0,
                    position.height
                )
            }
            .padding(start = 8.dp)
            .background(
                color = Colors.BG_HALF_TRANS_BLACK,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(
                start = 12.dp,
                end = 6.dp,
                top = 4.dp,
                bottom = 4.dp
            )
    ) {
        // Display group data here
        Text(
            text = osuGroup.shortName,
            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor(osuGroup.colour)),
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        if (osuGroup.hasPlaymodes) {
            Image(
                painter = painterResource(id = when (osuGroup.playmodes[0]) {
                    "osu" -> R.drawable.ic_osumode_std
                    "taiko" -> R.drawable.ic_osumode_taiko
                    "fruits" -> R.drawable.ic_osumode_ctb
                    "mania" -> R.drawable.ic_osumode_mania
                    else -> R.drawable.ic_osumode_std
                } ),
                colorFilter = ColorFilter.tint(Colors.TEXT_WHITE),
                contentDescription = "Playmodes",
                modifier = Modifier
                    .height(20.dp)
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview
@Composable
fun GroupListItemPreview() {
    GroupListItem(
        OsuGroup(
            id = 1,
            name = "osu!",
            shortName = "osu!",
            colour = "#ff66aa",
            hasPlaymodes = true,
            playmodes = listOf("osu")
        )
    ) {}
}
