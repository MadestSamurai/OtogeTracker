package com.madsam.otora.ui.record.chunithm

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.consts.CHUNI_DIFF_ADVANCED
import com.madsam.otora.consts.CHUNI_DIFF_BASIC
import com.madsam.otora.consts.CHUNI_DIFF_EXPERT
import com.madsam.otora.consts.CHUNI_DIFF_MASTER
import com.madsam.otora.consts.CHUNI_DIFF_ULTIMA_1
import com.madsam.otora.consts.CHUNI_DIFF_ULTIMA_2
import com.madsam.otora.consts.DARK_RED_DEEP
import com.madsam.otora.consts.DARK_RED_DEEPER
import com.madsam.otora.consts.DARK_RED_TEXT
import com.madsam.otora.consts.White1000
import com.madsam.otora.model.chuni.ui.ChuniPlayDataUI
import com.madsam.otora.utils.CommonUtils.formatNumberThousand
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun PlayDataList(
    width: Dp,
    chuniPlayDataUI: MutableStateFlow<ChuniPlayDataUI>
) {
    val playData by chuniPlayDataUI.collectAsState()
    val diffArray = arrayOf("Basic", "Advanced", "Expert", "Master", "Ultima")
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(width)
            .height(264.dp)
            .background(DARK_RED_DEEP)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 6.dp)
                .height(264.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            val itemWidth = width - 12.dp
            for(diff in diffArray) {
                PlayDataItem(
                    width = itemWidth,
                    diff = diff,
                    playDataItem = when(diff) {
                        "Basic" -> playData.basicPlayData
                        "Advanced" -> playData.advancedPlayData
                        "Expert" -> playData.expertPlayData
                        "Master" -> playData.masterPlayData
                        "Ultima" -> playData.ultimaPlayData
                        else -> playData.masterPlayData
                    }
                )
            }
        }
    }
}

@Composable
fun PlayDataItem(
    width: Dp,
    diff: String,
    playDataItem: ChuniPlayDataUI.ChuniPlayDataItemUI
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .width(width)
            .height(45.dp)
            .background(DARK_RED_DEEPER)
    ) {
        Row {
            Text(
                text = diff.toUpperCase(Locale.current),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = White1000,
                modifier = Modifier
                    .padding(2.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(
                        when(diff) {
                            "Basic" -> CHUNI_DIFF_BASIC
                            "Advanced" -> CHUNI_DIFF_ADVANCED
                            "Expert" -> CHUNI_DIFF_EXPERT
                            "Master" -> CHUNI_DIFF_MASTER
                            "Ultima" -> CHUNI_DIFF_ULTIMA_1
                            else -> CHUNI_DIFF_MASTER
                        }
                    )
                    .border(
                        width = if (diff == "Ultima") 1.dp else 0.dp,
                        color = if (diff == "Ultima") CHUNI_DIFF_ULTIMA_2 else Color.Transparent,
                        shape = RoundedCornerShape(3.dp)
                    )
                    .padding(vertical = 2.dp, horizontal = 6.dp)
            )
            Text(
                text = "Total",
                fontSize = 12.sp,
                color = White1000,
                modifier = Modifier.padding(4.dp)
            )
        }
        Text (
            text = formatNumberThousand(playDataItem.scoreTotal),
            fontSize = 16.sp,
            color = DARK_RED_TEXT,
            modifier = Modifier.padding(2.dp)
        )
    }
}