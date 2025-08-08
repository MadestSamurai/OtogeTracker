package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.CHUNI_DIFF_ADVANCED
import com.madsam.otora.core.theme.CHUNI_DIFF_BASIC
import com.madsam.otora.core.theme.CHUNI_DIFF_EXPERT
import com.madsam.otora.core.theme.CHUNI_DIFF_MASTER
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_1
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_2
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.utils.CommonUtils.formatNumberThousand
import com.madsam.otora.data.chunithm.ui.model.ChunithmPlayDataUiModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun PlayDataList(
    width: Dp,
    chunithmPlayDataUiModel: MutableStateFlow<ChunithmPlayDataUiModel>
) {
    val playData by chunithmPlayDataUiModel.collectAsState()
    val diffArray = arrayOf("Basic", "Advanced", "Expert", "Master", "Ultima")
    val typeArray = arrayOf("Total", "SSSp", "SSS", "SSp", "SS", "Sp", "S", "FC", "AJ", "AJC",
        "FChain", "FChainP", "Clear", "Hard", "Abs", "AbsP", "Catas")
    val pagerState = rememberPagerState(pageCount = { typeArray.size })

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(width)
            .height(264.dp)
            .background(Red700)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(horizontal = 6.dp)
        ) { page ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .height(264.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                val itemWidth = width - 12.dp
                for (diff in diffArray) {
                    PlayDataItem(
                        width = itemWidth,
                        diff = diff,
                        type = typeArray[page],
                        playDataItem = when (diff) {
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
}

@Composable
internal fun PlayDataItem(
    width: Dp,
    diff: String,
    type: String,
    playDataItem: ChunithmPlayDataUiModel.ChuniPlayDataItemUI
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .width(width)
            .height(45.dp)
            .background(Red500)
    ) {
        Row {
            Text(
                text = diff.toUpperCase(Locale.current),
                fontSize = 12.sp,
                fontFamily = sarasaBold,
                color = White1000,
                modifier = Modifier
                    .padding(2.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(
                        when (diff) {
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
                text = when (type) {
                    "Total" -> "Total"
                    "SSSp" -> "SSS+"
                    "SSS" -> "SSS"
                    "SSp" -> "SS+"
                    "SS" -> "SS"
                    "Sp" -> "S+"
                    "S" -> "S"
                    "FC" -> "Full Combo"
                    "AJ" -> "All Justice"
                    "AJC" -> "AJC"
                    "FChain" -> "Full Chain"
                    "FChainP" -> "Full Chain+"
                    "Clear" -> "Clear"
                    "Hard" -> "Hard"
                    "Abs" -> "Absolute"
                    "AbsP" -> "Absolute+"
                    "Catas" -> "Catastrophy"
                    else -> "Unknown"
                },
                fontSize = 12.sp,
                color = White1000,
                modifier = Modifier.padding(4.dp),
                maxLines = 1
            )
        }
        Text(
            text = when (type) {
                "Total" -> formatNumberThousand(playDataItem.scoreTotal)
                "SSSp" -> "${playDataItem.rateSSSp.first}/${playDataItem.rateSSSp.second}"
                "SSS" -> "${playDataItem.rateSSS.first}/${playDataItem.rateSSS.second}"
                "SSp" -> "${playDataItem.rateSSp.first}/${playDataItem.rateSSp.second}"
                "SS" -> "${playDataItem.rateSS.first}/${playDataItem.rateSS.second}"
                "Sp" -> "${playDataItem.rateSp.first}/${playDataItem.rateSp.second}"
                "S" -> "${playDataItem.rateS.first}/${playDataItem.rateS.second}"
                "FC" -> "${playDataItem.rateFC.first}/${playDataItem.rateFC.second}"
                "AJ" -> "${playDataItem.rateAJ.first}/${playDataItem.rateAJ.second}"
                "AJC" -> "${playDataItem.rateAJC.first}/${playDataItem.rateAJC.second}"
                "FChain" -> "${playDataItem.rateFChain.first}/${playDataItem.rateFChain.second}"
                "FChainP" -> "${playDataItem.rateFChainP.first}/${playDataItem.rateFChainP.second}"
                "Clear" -> "${playDataItem.rateClear.first}/${playDataItem.rateClear.second}"
                "Hard" -> "${playDataItem.rateHard.first}/${playDataItem.rateHard.second}"
                "Abs" -> "${playDataItem.rateAbs.first}/${playDataItem.rateAbs.second}"
                "AbsP" -> "${playDataItem.rateAbsP.first}/${playDataItem.rateAbsP.second}"
                "Catas" -> "${playDataItem.rateCatas.first}/${playDataItem.rateCatas.second}"
                else -> "0/0"
            },
            fontSize = 16.sp,
            color = Beige500,
            modifier = Modifier.padding(2.dp)
        )
    }
}