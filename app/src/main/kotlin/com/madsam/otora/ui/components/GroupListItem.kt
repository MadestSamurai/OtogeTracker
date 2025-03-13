package com.madsam.otora.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.theme.BlackAlpha80
import com.madsam.otora.core.theme.White800
import com.madsam.otora.data.osu.remote.model.OsuGroupDTO
import com.madsam.otora.core.icon.Filled
import kotlinx.coroutines.delay

/**
 * 项目名: OtogeTracker
 * 文件名: GroupListAdapter
 * 创建者: MadSamurai
 * 创建时间:2023/3/23 16:47
 * 描述:
 */

@Composable
internal fun GroupListItem(
    osuGroupDTO: OsuGroupDTO,
) {
    var showPopup by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .clickable(onClick = {
                showPopup = true
            })
            .padding(start = 8.dp)
            .background(
                color = BlackAlpha80,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(
                start = 12.dp,
                end = if (osuGroupDTO.hasPlaymodes) 6.dp else 12.dp,
                top = 4.dp,
                bottom = 4.dp
            )
    ) {
        androidx.compose.animation.AnimatedVisibility(
            visible = !showPopup,
        ) {
            Text(
                text = osuGroupDTO.shortName,
                fontWeight = FontWeight.Bold,
                color = Color(android.graphics.Color.parseColor(osuGroupDTO.colour.ifEmpty { "#FFFFFF" })),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        androidx.compose.animation.AnimatedVisibility(
            visible = showPopup,
        ) {
            Text(
                text = osuGroupDTO.name,
                color = Color(android.graphics.Color.parseColor(osuGroupDTO.colour.ifEmpty { "#FFFFFF" })),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        if (osuGroupDTO.hasPlaymodes) {
            Image(
                painter = rememberVectorPainter(
                    image = when (osuGroupDTO.playmodes[0]) {
                        "osu" -> Filled.OsumodeStd
                        "taiko" -> Filled.OsumodeTaiko
                        "fruits" -> Filled.OsumodeCtb
                        "mania" -> Filled.OsumodeMania
                        else -> Filled.OsumodeStd
                    }
                ),
                colorFilter = ColorFilter.tint(White800),
                contentDescription = "Playmodes",
                modifier = Modifier
                    .height(18.dp)
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
    LaunchedEffect(showPopup) {
        delay(1500)
        showPopup = false
    }
}
