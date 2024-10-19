package com.madsam.otora.ui.bof.sub

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.madsam.otora.consts.Colors
import com.madsam.otora.fonts.sarasaBold
import com.madsam.otora.fonts.sarasaFont
import com.madsam.otora.model.bof.BofEntryShow
import com.madsam.otora.service.BofDataRequestService
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.ndp
import com.madsam.otora.utils.nsp
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Calendar

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.bof.sub.BofScreen
 * 创建者: MadSamurai
 * 创建时间: 2024/10/7
 * 描述: TODO
 */

@Composable
fun BofTotalScreen() {
    val context = LocalContext.current
    val bofDataRequestService = BofDataRequestService(context)
    val todayLatestData = remember { mutableStateOf<List<BofEntryShow>>(emptyList()) }
    val coroutineScope = rememberCoroutineScope()
    val dateTime = LocalDate.now()
    var selectedDate by remember { mutableStateOf(dateTime) }
    var selectedTime by remember { mutableStateOf("-1") }

    fun refreshData() {
        coroutineScope.launch {
            bofDataRequestService.getBofttData(dateTime)
        }
    }

    fun selectTime() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(context, { _, year, month, dayOfMonth ->
            selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
            TimePickerDialog(context, { _, hourOfDay, minute ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                refreshData()
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    fun roundDownToNearestFiveMinutes(hms: String): String {
        val parts = hms.split(":").map { it.toInt() }
        val hours = parts[0]
        val minutes = parts[1] / 5 * 5
        return String.format("%02d:%02d:00", hours, minutes)
    }

    LaunchedEffect(selectedDate, selectedTime) {
        Log.d("BofScreen", "selectedDate: $selectedDate, selectedTime: $selectedTime")
        val data: List<BofEntryShow>
        if (selectedTime == "-1") {
            data = bofDataRequestService.getBofttEntryLatest()
        } else {
            val timeInMillis = CommonUtils.ymdToMillis(selectedDate.toString(), roundDownToNearestFiveMinutes(selectedTime))
            val startInMillis = CommonUtils.ymdToMillis("2024-10-13", "00:00:00")
            data = bofDataRequestService.getBofttEntryByTime(((timeInMillis - startInMillis)/10).toInt())
        }
        // Sort the data by total in descending order
        val sortedData = data.sortedByDescending { it.total }
        // Assign rankings
        var currentRank = 1
        sortedData.forEachIndexed { index, entry ->
            if (index > 0 && sortedData[index - 1].total != entry.total) {
                currentRank = index + 1
            }
            entry.index = currentRank
        }
        todayLatestData.value = sortedData
    }

    val maxTotal = todayLatestData.value.maxOfOrNull { it.total } ?: 1

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                Button(onClick = { selectTime() }, modifier = Modifier.padding(16.dp)) {
                    Text(text = "Select Date and Time")
                }
                Button(onClick = { refreshData() }, modifier = Modifier.padding(16.dp)) {
                    Text(text = "Refresh Data")
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
                        text = "Total Score Ranking",
                        fontFamily = sarasaFont,
                        fontSize = 24.nsp(),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(0.93f)
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
                            .fillMaxWidth(0.93f)
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
                            .width(36.ndp())
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
                            .fillMaxWidth(0.4f)
                    )
                    Text(
                        text = "Impr",
                        fontFamily = sarasaFont,
                        fontSize = 16.nsp(),
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(36.ndp())
                    )
                    Text(
                        text = "Median",
                        fontFamily = sarasaFont,
                        fontSize = 16.nsp(),
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 8.ndp())
                            .width(70.ndp())
                    )
                    Text(
                        text = "Avg",
                        fontFamily = sarasaFont,
                        fontSize = 16.nsp(),
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(70.ndp())
                    )
                }
            }
            itemsIndexed(todayLatestData.value) { index, entry ->
                BofEntryRowTotal(entry, index+1, maxTotal)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BofEntryRowTotal(
    entry: BofEntryShow,
    index: Int,
    maxTotal: Int
) {
    val backgroundColor = if (index % 2 == 0) Colors.BG_DARK_GRAY else Color.Black
    val barWidthFraction = (entry.total.toFloat() / maxTotal) * 1f
    val barWidthOldFaction = ((entry.oldTotal).toFloat() / maxTotal) * 1f
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
        Text(
            text = entry.index.toString(),
            fontFamily = sarasaBold,
            fontSize = 18.nsp(),
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(36.ndp())
        )
        Column {
            Text(
                text = entry.title,
                fontSize = 14.nsp(),
                lineHeight = 16.nsp(),
                fontFamily = sarasaFont,
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
                color = Colors.TEXT_GRAY,
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
                    .fillMaxWidth(0.4f)
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
                        text = entry.total.toString(),
                        color = Color.White,
//                        fontSize = 14.nsp(),
//                        lineHeight = 18.nsp(),
                        fontSize = 22.nsp(),
                        lineHeight = 24.nsp(),
                        fontFamily = sarasaBold,
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
//                    .fillMaxWidth(0.4f)
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
//                        fontFamily = sarasaBold,
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
            fontFamily = sarasaBold,
            fontSize = 18.nsp(),
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(36.ndp())
        )
        Text(
            text = entry.median.toString(),
            fontFamily = sarasaBold,
            fontSize = 18.nsp(),
            lineHeight = 36.nsp(),
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 8.ndp())
                .width(70.ndp())
                .background(calculateColor(entry.median))
        )
        Text(
            text = entry.avg.toString(),
            fontFamily = sarasaBold,
            fontSize = 18.nsp(),
            lineHeight = 36.nsp(),
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(70.ndp())
                .background(calculateColor(entry.avg))
        )
    }
}