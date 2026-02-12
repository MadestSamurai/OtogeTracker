package com.madsam.otora.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.BlackAlpha80
import com.madsam.otora.core.theme.White800
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.theme.plexSemi
import com.madsam.otora.data.osu.remote.model.OsuGroupDTO
import kotlinx.coroutines.delay

@Composable
internal fun GroupListItem(
    osuGroupDTO: OsuGroupDTO,
) {
    var showPopup by remember { mutableStateOf(false) }
    val density = LocalDensity.current
    val iconHeight = with(density) { 18.sp.toDp() }
    
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
            .wrapContentHeight()
            .padding(
                start = 12.dp,
                end = if (osuGroupDTO.hasPlaymodes) 6.dp else 12.dp,
                top = 4.dp,
                bottom = 4.dp
            )
    ) {
        AnimatedVisibility(
            visible = !showPopup,
        ) {
            Text(
                text = osuGroupDTO.shortName,
                fontFamily = plexBold,
                color = Color(osuGroupDTO.colour.ifEmpty { "#FFFFFF" }.toColorInt()),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        AnimatedVisibility(
            visible = showPopup,
        ) {
            Text(
                text = osuGroupDTO.name,
                fontFamily = plexSemi,
                color = Color(osuGroupDTO.colour.ifEmpty { "#FFFFFF" }.toColorInt()),
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
                contentDescription = "Play Modes",
                modifier = Modifier
                    .height(iconHeight)
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
