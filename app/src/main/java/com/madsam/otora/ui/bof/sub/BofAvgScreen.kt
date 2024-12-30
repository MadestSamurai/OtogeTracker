package com.madsam.otora.ui.bof.sub

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.madsam.otora.R
import com.madsam.otora.consts.BG_DARK_GRAY
import com.madsam.otora.consts.RANKING_GREEN
import com.madsam.otora.consts.RANKING_RED
import com.madsam.otora.consts.RANKING_YELLOW
import com.madsam.otora.consts.TEXT_GRAY
import com.madsam.otora.fonts.sarasaFont
import com.madsam.otora.model.bof.ui.BofEntryShow
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.ndp
import com.madsam.otora.utils.nsp
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.bof.sub.BofScreen
 * 创建者: MadSamurai
 * 创建时间: 2024/10/7
 * 描述: BOF数据展示界面
 */

@Composable
fun BofAvgScreen(vm: BofViewModel) {
    val scope = rememberCoroutineScope()
    val avgData = vm.avgData.asStateFlow().collectAsState()
    val thresholdImpr = vm.thresholdImpr.asStateFlow().collectAsState()
    val thresholdImprOld = vm.thresholdImprOld.asStateFlow().collectAsState()
    val selectedDate = vm.selectedDate.asStateFlow().collectAsState().value
    val selectedTime = vm.selectedTime.asStateFlow().collectAsState().value

    LaunchedEffect(selectedDate, selectedTime) {
        scope.launch {
            vm.requestAvgData()
        }
    }

    LazyColumn {
        item {
            val selectedTimeStr: String = if (selectedTime == "-1") {
                if (avgData.value.isEmpty()) {
                    ""
                } else {
                    CommonUtils.roundDownToNearestFiveMinutes(avgData.value.first().time)
                }
            } else {
                CommonUtils.roundDownToNearestFiveMinutes(selectedTime)
            }
            if (avgData.value.isEmpty()) {
                Text(text = "No Data at $selectedDate $selectedTimeStr")
            } else {
                Text(
                    text = "Avg Ranking - Exclude Impr below ${thresholdImpr.value}",
                    fontFamily = sarasaFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.nsp(),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .padding(top = 10.ndp())
                )
                Text(
                    text = "Updated at $selectedDate $selectedTimeStr, all data by MadSamurai",
                    fontFamily = sarasaFont,
                    fontSize = 12.nsp(),
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
            }
        }
        var isCompare: Boolean = if (avgData.value.isNotEmpty()) {
            avgData.value[0].oldTotal != 0
        } else {
            false
        }
        item {
            Row(
                modifier = Modifier
                    .background(BG_DARK_GRAY)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "",
                    modifier = Modifier
                        .width(98.ndp())
                )
                Text(
                    text = "",
                    modifier = Modifier
                        .padding(end = 8.dp, top = 2.dp)
                        .fillMaxWidth(0.5f)
                )
                Text(
                    text = " ",
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                )
                Text(
                    text = "Impr",
                    fontFamily = sarasaFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.nsp(),
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(36.ndp())
                )
            }
        }
        itemsIndexed(avgData.value) { index, entry ->
            BofEntryRowAvg(entry, index + 1, thresholdImprOld.value, isCompare)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BofEntryRowAvg(
    entry: BofEntryShow,
    index: Int,
    oldThre: Int,
    isCompare: Boolean
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black
    val barWidthFraction = (entry.avg.toFloat() / 1000) * 1f
    var rowHeight = remember { mutableIntStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .onGloballyPositioned { coordinates ->
                rowHeight.intValue = coordinates.size.height
            }
    ) {
        if (isCompare) {
            Icon(
                painter = entry.avgDiff.let {
                    if (it > 0 || entry.oldImpr < oldThre) {
                        painterResource(id = R.drawable.ic_wind_up)
                    } else if (it < 0) {
                        painterResource(id = R.drawable.ic_wind_down)
                    } else {
                        painterResource(id = R.drawable.ic_flat)
                    }
                },
                contentDescription = null,
                tint = if (entry.avgDiff > 0 || entry.oldImpr < oldThre)
                    RANKING_GREEN
                else if (entry.avgDiff < 0)
                    RANKING_RED
                else
                    RANKING_YELLOW,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(30.ndp())
            )
            Text(
                text = if (entry.oldImpr < oldThre) "NEW" else entry.avgDiff.toString(),
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                fontSize = 14.nsp(),
                color = if (entry.avgDiff > 0 || entry.oldImpr < oldThre)
                    RANKING_GREEN
                else if (entry.avgDiff < 0)
                    RANKING_RED
                else
                    RANKING_YELLOW,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(32.ndp())
            )
        }
        Text(
            text = entry.index.toString(),
            fontFamily = sarasaFont,
            fontWeight = FontWeight.Bold,
            fontSize = 20.nsp(),
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(36.ndp())
        )
        Column {
            Text(
                text = entry.title,
                fontSize = 15.nsp(),
                lineHeight = 16.nsp(),
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(end = 8.ndp(), top = 2.ndp())
                    .fillMaxWidth(0.5f)
                    .horizontalScroll(rememberScrollState())
                // use horizontalScroll for capturing, basicMarquee is more useful
//                    .basicMarquee(
//                        spacing = MarqueeSpacing(10.dp)
//                    )
            )
            Text(
                text = entry.artist,
                fontSize = 12.nsp(),
                lineHeight = 13.nsp(),
                fontFamily = sarasaFont,
                textAlign = TextAlign.End,
                color = TEXT_GRAY,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(end = 8.ndp())
                    .fillMaxWidth(0.5f)
                    .horizontalScroll(rememberScrollState())
                // use horizontalScroll for capturing, basicMarquee is more useful
//                    .basicMarquee(
//                        spacing = MarqueeSpacing(10.dp)
//                    )
            )
        }
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(
                        color = Color.Transparent,
                    )
            ) {
                Box(
                    Modifier
                        .padding(top = 2.ndp())
                        .background(
                            color = Color.Transparent,
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .padding(end = 20.ndp())
                            .fillMaxWidth(barWidthFraction)
//                            .height(18.ndp())
                            .height(32.ndp())
                            .background(
                                color = Color.Red,
                                shape = RoundedCornerShape(topEnd = 50.ndp(), bottomEnd = 50.ndp())
                            )
                    )
                    Text(
                        text = CommonUtils.formatNumber(entry.avg),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
//                        fontSize = 14.nsp(),
//                        lineHeight = 18.nsp(),
                        fontSize = 22.nsp(),
                        lineHeight = 24.nsp(),
                        fontFamily = sarasaFont,
                        overflow = TextOverflow.Visible,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(end = 24.ndp())
                            .align(Alignment.CenterEnd)
                    )
                }
            }
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth(0.8f)
//                    .background(
//                        color = Color.Transparent,
//                    )
//            ) {
//                Box(
//                    Modifier
//                        .background(
//                            color = Color.Transparent,
//                        )
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .padding(end = 20.ndp())
//                            .fillMaxWidth(barWidthOldFaction)
//                            .height(14.ndp())
//                            .background(
//                                color = Color.Blue,
//                                shape = RoundedCornerShape(topEnd = 10.ndp(), bottomEnd = 10.ndp())
//                            )
//                    )
//                    Text(
//                        text = entry.oldTotal.toString(),
//                        color = Color.White,
//                        fontSize = 12.nsp(),
//                        lineHeight = 14.nsp(),
//                        fontFamily = sarasaFont,
//                        overflow = TextOverflow.Visible,
//                        maxLines = 1,
//                        modifier = Modifier
//                            .padding(end = 24.ndp())
//                            .align(Alignment.CenterEnd)
//                    )
//                }
//            }
        }
        Text(
            text = entry.impr.toString(),
            fontFamily = sarasaFont,
            fontWeight = FontWeight.Bold,
            fontSize = 20.nsp(),
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(36.ndp())
        )
    }
}