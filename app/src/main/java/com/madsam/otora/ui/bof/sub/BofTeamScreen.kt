package com.madsam.otora.ui.bof.sub

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.consts.Colors
import com.madsam.otora.consts.OsuDiffColor
import com.madsam.otora.fonts.sarasaFont
import com.madsam.otora.model.bof.BofTeamShow
import com.madsam.otora.service.BofDataRequestService
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.ndp
import com.madsam.otora.utils.nsp
import com.patrykandpatrick.vico.compose.cartesian.layer.stacked
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Calendar
import kotlin.text.toFloat

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.bof.sub.BofTeamScreen
 * 创建者: MadSamurai
 * 创建时间: 2024/10/23
 * 描述: BOF团队数据展示界面
 */
@Composable
fun BofTeamScreen() {
    val context = LocalContext.current
    val bofDataRequestService = BofDataRequestService(context)
    val todayLatestData = remember { mutableStateOf<List<BofTeamShow>>(emptyList()) }
    val coroutineScope = rememberCoroutineScope()
    val dateTime = LocalDate.now()
    var selectedDate by remember { mutableStateOf(dateTime) }
    var selectedTime by remember { mutableStateOf("-1") }

    fun refreshData() {
        coroutineScope.launch {
            bofDataRequestService.getBofttTeamData(dateTime)
        }
    }

    fun selectTime() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
                TimePickerDialog(context, { _, hourOfDay, minute ->
                    selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                    refreshData()
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    fun roundDownToNearestFiveMinutes(hms: String): String {
        val parts = hms.split(":").map { it.toInt() }
        val hours = parts[0]
        val minutes = parts[1] / 5 * 5
        return String.format("%02d:%02d:00", hours, minutes)
    }

    LaunchedEffect(selectedDate, selectedTime) {
        Log.d("BofScreen", "selectedDate: $selectedDate, selectedTime: $selectedTime")
        val data: List<BofTeamShow>
        if (selectedTime == "-1") {
            data = bofDataRequestService.getBofttTeamLatest()
        } else {
            val timeInMillis = CommonUtils.ymdToMillis(
                selectedDate.toString(),
                roundDownToNearestFiveMinutes(selectedTime)
            )
            val startInMillis = CommonUtils.ymdToMillis("2024-10-13", "00:00:00")
            data =
                bofDataRequestService.getBofttTeamByTime(((timeInMillis - startInMillis) / 10).toInt())
        }
        // Sort the data by oldTotal in descending order
        var sortedData = data.sortedByDescending { it.oldTotal }
        // Assign rankings
        var currentOldRank = 1
        sortedData.forEachIndexed { index, entry ->
            if (index > 0 && sortedData[index - 1].oldTotal != entry.oldTotal) {
                currentOldRank = index + 1
            }
            entry.oldIndex = currentOldRank
        }
        sortedData = data.sortedBy { it.impr }
        // Sort the data by total in descending order
        sortedData = data.sortedByDescending { it.total }
        // Assign rankings
        var currentRank = 1
        sortedData.forEachIndexed { index, entry ->
            if (index > 0 && sortedData[index - 1].total != entry.total) {
                currentRank = index + 1
            }
            entry.index = currentRank
        }
        sortedData.forEach {
            it.rankDiff = it.oldIndex - it.index
        }
        todayLatestData.value = sortedData
    }

    val maxTotal = todayLatestData.value.maxOfOrNull { it.total } ?: 1.0

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                Row {
                    Button(onClick = { selectTime() }, modifier = Modifier.padding(16.dp)) {
                        Text(text = "Select Date and Time")
                    }
                    Button(onClick = { refreshData() }, modifier = Modifier.padding(16.dp)) {
                        Text(text = "Refresh Data")
                    }
                }
            }
            item {
                val selectedTimeStr: String = if (selectedTime == "-1") {
                    if (todayLatestData.value.isEmpty()) {
                        ""
                    } else {
                        roundDownToNearestFiveMinutes(todayLatestData.value.first().time)
                    }
                } else {
                    roundDownToNearestFiveMinutes(selectedTime)
                }
                if (todayLatestData.value.isEmpty()) {
                    Text(text = "No Data at $selectedDate $selectedTimeStr")
                } else {
                    Text(
                        text = "Total Team Score Ranking",
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
            item {
                Row(
                    modifier = Modifier
                        .background(Colors.BG_DARK_GRAY)
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
                            .fillMaxWidth(0.7f)
                    )
                    Text(
                        text = " ",
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
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
                            .padding(start = 26.ndp())
                            .width(36.ndp())
                    )
                    Text(
                        text = "Median",
                        fontFamily = sarasaFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.nsp(),
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 44.ndp())
                            .width(70.ndp())
                    )
                }
            }
            itemsIndexed(todayLatestData.value) { index, entry ->
                BofTeamRowTotal(entry, index + 1, maxTotal)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BofTeamRowTotal(
    entry: BofTeamShow,
    index: Int,
    maxTotal: Double
) {
    val backgroundColor = if (index % 2 == 0) Colors.BG_DARK_GRAY else Color.Black
    val barWidthFraction = (entry.total / maxTotal) * 1f
    val barWidthOldFaction = ((entry.oldTotal) / maxTotal) * 1f
    var rowHeight = remember { mutableIntStateOf(0) }

    fun calculateColor(value: Double): Color {
        val normalizedValue = value.toInt().coerceIn(0, 1000) / 1000f
        return Color(red = normalizedValue, green = 0f, blue = 0f)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .onGloballyPositioned { coordinates ->
                rowHeight.intValue = coordinates.size.height
            }
    ) {
        Icon(
            painter = entry.rankDiff.let {
                if (it > 0) {
                    painterResource(id = com.madsam.otora.R.drawable.ic_wind_up)
                } else if (it < 0) {
                    painterResource(id = com.madsam.otora.R.drawable.ic_wind_down)
                } else {
                    painterResource(id = com.madsam.otora.R.drawable.ic_flat)
                }
            },
            contentDescription = null,
            tint = if (entry.rankDiff < 0) Colors.RANKING_RED else if (entry.rankDiff > 0) Colors.RANKING_GREEN else Colors.RANKING_YELLOW,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(30.ndp())
        )
        Text(
            text = if (entry.oldTotal < 1.0) "NEW" else entry.rankDiff.toString(),
            fontFamily = sarasaFont,
            fontWeight = FontWeight.Bold,
            fontSize = 14.nsp(),
            color = if (entry.rankDiff < 0) Colors.RANKING_RED else if (entry.rankDiff > 0) Colors.RANKING_GREEN else Colors.RANKING_YELLOW,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(32.ndp())
        )
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
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(
                        color = Color.Transparent,
                    )
                    .padding(start = 13.ndp())
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
                            .fillMaxWidth(barWidthFraction.toFloat())
                            .height(18.ndp())
                            .background(
                                color = Colors.RANKING_RED,
                                shape = RoundedCornerShape(
                                    topEnd = 50.ndp(),
                                    bottomEnd = 50.ndp()
                                )
                            )
                    )
                    Text(
                        text = CommonUtils.formatNumber(entry.total),
                        color = Color.White,
                        fontSize = 14.nsp(),
                        lineHeight = 16.nsp(),
                        fontFamily = sarasaFont,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Visible,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(end = 24.ndp())
                            .align(Alignment.CenterEnd)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(
                        color = Color.Transparent,
                    )
                    .padding(start = 13.ndp())
            ) {
                Box(
                    Modifier
                        .background(
                            color = Color.Transparent,
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .padding(end = 20.ndp())
                            .fillMaxWidth(barWidthOldFaction.toFloat())
                            .height(14.ndp())
                            .background(
                                color = Colors.RANKING_BLUE,
                                shape = RoundedCornerShape(
                                    topEnd = 10.ndp(),
                                    bottomEnd = 10.ndp()
                                )
                            )
                    )
                    Text(
                        text = CommonUtils.formatNumber(entry.oldTotal),
                        color = Color.White,
                        fontSize = 12.nsp(),
                        lineHeight = 14.nsp(),
                        fontFamily = sarasaFont,
                        overflow = TextOverflow.Visible,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(end = 24.ndp())
                            .align(Alignment.CenterEnd)
                    )
                }
            }
            Text(
                text = entry.team,
                fontSize = 16.nsp(),
                lineHeight = 16.nsp(),
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 13.ndp(), end = 8.ndp(), top = 2.ndp())
                    .fillMaxWidth(0.8f)
                    .horizontalScroll(rememberScrollState())
                // use horizontalScroll for capturing, basicMarquee is more useful
//                    .basicMarquee(
//                        spacing = MarqueeSpacing(10.dp)
//                    )
            )

            val titles = listOf(entry.title1, entry.title2, entry.title3, entry.title4)
            val artists = listOf(entry.artist1, entry.artist2, entry.artist3, entry.artist4)
            val fss = listOf(entry.fs1, entry.fs2, entry.fs3, entry.fs4)
            val totals = listOf(entry.total1, entry.total2, entry.total3, entry.total4)

            titles.forEachIndexed { index, title ->
                if (title.isNotEmpty()) {
                    val inlineContent = mapOf(
                        "icon" to InlineTextContent(
                            Placeholder(
                                width = 13.nsp(),
                                height = 11.nsp(),
                                placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
                            )
                        ) {
                            Icon(
                                painter = painterResource(id = com.madsam.otora.R.drawable.ic_star),
                                contentDescription = null,
                                tint = if (fss[index] == "1") Colors.RANKING_YELLOW else Color.Transparent,
                            )
                        }
                    )
                    Row {
                        Text(
                            text = buildAnnotatedString {
                                appendInlineContent("icon", "[icon]")
                                append("$title - ${artists[index]}")
                            },
                            inlineContent = inlineContent,
                            fontSize = 11.nsp(),
                            lineHeight = 13.nsp(),
                            fontFamily = sarasaFont,
                            textAlign = TextAlign.Start,
                            color = Colors.TEXT_GRAY,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(end = 10.ndp())
                                .fillMaxWidth(0.72f)
                                .horizontalScroll(rememberScrollState())
                                // use horizontalScroll for capturing, basicMarquee is more useful
//                                .basicMarquee(
//                                    spacing = MarqueeSpacing(10.dp)
//                                )
                        )
                        Text(
                            text = totals[index],
                            fontSize = 11.nsp(),
                            lineHeight = 13.nsp(),
                            fontFamily = sarasaFont,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End,
                            color = Colors.TEXT_GRAY,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(end = 8.ndp())
                                .fillMaxWidth(0.22f)
                                .horizontalScroll(rememberScrollState())
                                // use horizontalScroll for capturing, basicMarquee is more useful
                        )
                    }
                }
            }
        }

        Text(
            text = entry.impr.toString(),
            fontFamily = sarasaFont,
            fontWeight = FontWeight.Bold,
            fontSize = 24.nsp(),
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(48.ndp())
        )
        val medianValue = entry.median.toDoubleOrNull()
        if (medianValue != null) {
            Text(
                text = CommonUtils.formatNumber(medianValue),
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                fontSize = 24.nsp(),
                lineHeight = 114.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.ndp())
                    .width(110.ndp())
                    .background(calculateColor(medianValue))
                    .padding(end = 4.ndp())
            )
        } else {
            Text(
                text = entry.median,
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                fontSize = 16.nsp(),
                lineHeight = 114.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.ndp())
                    .width(110.ndp())
                    .background(Color.Black)
                    .padding(end = 4.ndp())
            )
        }
    }
}