package com.madsam.otora.ui.bof.sub

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.madsam.otora.R
import com.madsam.otora.consts.Colors
import com.madsam.otora.fonts.sarasaFont
import com.madsam.otora.model.bof.ui.BofEntryShow
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.ui.record.osu.saveImageBitmapToFile
import com.madsam.otora.ui.record.osu.saveImageToGallery
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.ndp
import com.madsam.otora.utils.nsp
import dev.shreyaspatil.capturable.capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File
import kotlin.math.max

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.bof.sub.BofScreen
 * 创建者: MadSamurai
 * 创建时间: 2024/10/7
 * 描述: BOF数据展示界面
 */

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BofTotalScreen(
    vm: BofViewModel,
    snackbarHostState: SnackbarHostState
) {
    val totalData = vm.totalData.asStateFlow().collectAsState()
    val maxTotal = max(totalData.value.maxOfOrNull { it.total } ?: 1,
        totalData.value.maxOfOrNull { it.oldTotal } ?: 1)
    val selectedDate = vm.selectedDate.asStateFlow().collectAsState().value
    val selectedTime = vm.selectedTime.asStateFlow().collectAsState().value
    val context = LocalContext.current

    val selectedTimeStr = vm.selectedTimeStr.asStateFlow().collectAsState().value
    var showDialog = remember { mutableStateOf(false) }

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    // Calculate the width of the bar and text
    var isCompare: Boolean = if (totalData.value.isNotEmpty()) {
        totalData.value[0].oldTotal != 0
    } else {
        false
    }
    val barWidth = when (screenWidthDp) {
        in 0.dp..400.dp -> (screenWidthDp.value * 0.4f).ndp()
        in 400.dp..800.dp -> ((screenWidthDp.value - 400) * 0.3f + 160).ndp()
        else -> 280.ndp()
    }
    val textWidth =
        if (screenWidthDp > 800.dp) screenWidthDp - 302.ndp() - barWidth
        else if (isCompare) screenWidthDp - 58.ndp() - barWidth
        else screenWidthDp - 40.ndp() - barWidth - 36.ndp()
    val screenWidthImage = 1000.dp
    val barWidthImage = 280.ndp()
    val textWidthImage = 1000.dp - 302.ndp() - barWidthImage

    val scope = rememberCoroutineScope()
    LaunchedEffect(selectedDate, selectedTime) {
        scope.launch {
            vm.requestTotalData()
            vm.generateSelectedTimeStr()
        }
    }

    if (showDialog.value) {
        val captureController = rememberCaptureController()
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Capture Content") },
            modifier = Modifier.height(500.dp),
            text = {
                Column {
                    Text(
                        text = "Capturing content will save the current content to your gallery. " +
                                "Image may be too large to show in the dialog, " +
                                "including the parts that are not visible on the screen.",
                        modifier = Modifier.padding(8.dp)
                    )
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .height(250.dp)
                            .requiredHeight(6000.dp)
                            .requiredWidth(1000.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .capturable(captureController)
                                .fillMaxWidth()
                        ) {
                            if (totalData.value.isEmpty() || totalData.value[0].total == 0) {
                                Text(text = "No Data at $selectedDate $selectedTimeStr")
                            } else {
                                Text(
                                    text = "Total Score Ranking",
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
                                Row(
                                    modifier = Modifier
                                        .background(Colors.BG_DARK_GRAY)
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = "Rank",
                                        fontFamily = sarasaFont,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.nsp(),
                                        color = Color.White,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier
                                            .padding(end = 4.ndp())
                                            .width(98.ndp())
                                    )
                                    Text(
                                        text = "",
                                        modifier = Modifier
                                            .padding(end = 8.ndp(), top = 2.ndp())
                                            .width(textWidthImage)
                                    )
                                    Text(
                                        text = "Total",
                                        fontFamily = sarasaFont,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.nsp(),
                                        color = Color.White,
                                        modifier = Modifier
                                            .width(barWidthImage)
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
                                    Text(
                                        text = "Median",
                                        fontFamily = sarasaFont,
                                        fontWeight = FontWeight.Bold,
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
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.nsp(),
                                        color = Color.White,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .width(74.ndp())
                                    )
                                }
                            }
                            if (totalData.value.isNotEmpty()) {
                                var isCompare: Boolean = if (totalData.value.isNotEmpty()) {
                                    totalData.value[0].oldTotal != 0
                                } else {
                                    false
                                }
                                for ((index, entry) in totalData.value.withIndex()) {
                                    if (entry.index > 150) {
                                        break
                                    }
                                    BofEntryRowTotal(
                                        entry = entry,
                                        index = index + 1,
                                        maxTotal = maxTotal,
                                        isCompare = isCompare,
                                        isImage = true,
                                        rowWidth = screenWidthImage,
                                        barWidth = barWidthImage,
                                        textWidth = textWidthImage
                                    )
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        scope.launch {
                            val bitmapAsync = captureController.captureAsync()
                            try {
                                val bitmap = bitmapAsync.await()
                                val file = File(context.cacheDir, "bof_total.png")
                                saveImageBitmapToFile(bitmap, file)
                                saveImageToGallery(context, file, "bof_total")
                                snackbarHostState.showSnackbar("Captured content saved to gallery")
                            } catch (error: Throwable) {
                                Log.e("Capture", "Error capturing content", error)
                                snackbarHostState.showSnackbar("Error capturing content")
                                error.printStackTrace()
                            }
                        }
                        showDialog.value = false
                    }
                ) {
                    Text(text = "Capture")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showDialog.value = false
                    }
                ) {
                    Text(text = "Cancel")
                }
            }
        )
    }

    LazyColumn {
        item {
            Button(
                onClick = { showDialog.value = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "Show Capture Dialog")
            }
        }
        item {
            if (totalData.value.isEmpty() || totalData.value[0].total == 0) {
                Text(text = "No Data at $selectedDate $selectedTimeStr")
            } else {
                Text(
                    text = "Total Score Ranking",
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
                    text = "Rank",
                    fontFamily = sarasaFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.nsp(),
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .padding(end = if (screenWidthDp < 800.dp || !isCompare) 22.ndp() else 4.ndp())
                        .width(if (screenWidthDp < 800.dp || !isCompare) 36.ndp() else 98.ndp())
                )
                Text(
                    text = "",
                    modifier = Modifier
                        .padding(end = 8.ndp(), top = 2.ndp())
                        .width(textWidth)
                )
                Text(
                    text = "Total",
                    fontFamily = sarasaFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.nsp(),
                    color = Color.White,
                    modifier = Modifier
                        .width(barWidth)
                )
                if (screenWidthDp > 800.dp) {
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
                    Text(
                        text = "Median",
                        fontFamily = sarasaFont,
                        fontWeight = FontWeight.Bold,
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
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.nsp(),
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(74.ndp())
                    )
                }
            }
        }
        if (totalData.value.isNotEmpty()) {
            itemsIndexed(totalData.value) { index, entry ->
                BofEntryRowTotal(
                    entry = entry,
                    index = index + 1,
                    maxTotal = maxTotal,
                    isCompare = isCompare,
                    isImage = false,
                    rowWidth = screenWidthDp,
                    barWidth = barWidth,
                    textWidth = textWidth
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BofEntryRowTotal(
    entry: BofEntryShow,
    index: Int,
    maxTotal: Int,
    isCompare: Boolean = true,
    isImage: Boolean = false,
    rowWidth: Dp,
    barWidth: Dp,
    textWidth: Dp,
) {
    val backgroundColor = if (index % 2 == 0) Colors.BG_DARK_GRAY else Color.Black

    val newBarWidth = if (maxTotal == 0) 0.dp
    else (entry.total.toFloat() / maxTotal * barWidth.value).ndp()
    val oldBarWidth = if (maxTotal == 0) 0.dp
    else (entry.oldTotal.toFloat() / maxTotal * barWidth.value).ndp()

    fun calculateColor(value: Double): Color {
        val normalizedValue = value.toInt().coerceIn(0, 1000) / 1000f
        return Color(red = normalizedValue, green = 0f, blue = 0f)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.ndp())
            .background(backgroundColor)
    ) {
        if (rowWidth < 800.dp && isCompare) {
            Column {
                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    Icon(
                        painter = entry.rankDiff.let {
                            if (it > 0) {
                                painterResource(id = R.drawable.ic_wind_up)
                            } else if (it < 0) {
                                painterResource(id = R.drawable.ic_wind_down)
                            } else {
                                painterResource(id = R.drawable.ic_flat)
                            }
                        },
                        contentDescription = null,
                        tint = if (entry.rankDiff < 0) Colors.RANKING_RED
                        else if (entry.rankDiff > 0) Colors.RANKING_GREEN else Colors.RANKING_YELLOW,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = 2.ndp(), start = 8.ndp())
                            .width(16.ndp())
                    )
                    Text(
                        text = if (entry.oldTotal == 0) "NEW" else entry.rankDiff.toString(),
                        fontFamily = sarasaFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.nsp(),
                        color = if (entry.rankDiff < 0) Colors.RANKING_RED
                        else if (entry.rankDiff > 0) Colors.RANKING_GREEN else Colors.RANKING_YELLOW,
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
                    fontSize = 16.nsp(),
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .width(36.ndp())
                )
            }
        } else {
            if (isCompare) {
                Icon(
                    painter = entry.rankDiff.let {
                        if (it > 0) {
                            painterResource(id = R.drawable.ic_wind_up)
                        } else if (it < 0) {
                            painterResource(id = R.drawable.ic_wind_down)
                        } else {
                            painterResource(id = R.drawable.ic_flat)
                        }
                    },
                    contentDescription = null,
                    tint = if (entry.rankDiff < 0) Colors.RANKING_RED
                    else if (entry.rankDiff > 0) Colors.RANKING_GREEN else Colors.RANKING_YELLOW,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(30.ndp())
                )
                Text(
                    text = if (entry.oldTotal == 0) "NEW" else entry.rankDiff.toString(),
                    fontFamily = sarasaFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.nsp(),
                    color = if (entry.rankDiff < 0) Colors.RANKING_RED
                    else if (entry.rankDiff > 0) Colors.RANKING_GREEN else Colors.RANKING_YELLOW,
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
                    .padding(end = 4.ndp())
                    .width(36.ndp())
            )
        }
        Column {
            val modText = if (isImage) {
                Modifier
                    .padding(end = 8.ndp(), top = 2.ndp())
                    .width(textWidth)
            } else {
                Modifier
                    .padding(end = 8.ndp(), top = 2.ndp())
                    .width(textWidth)
                    .basicMarquee(
                        spacing = MarqueeSpacing(15.ndp())
                    )
            }
            Text(
                text = entry.title,
                fontSize = 15.nsp(),
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = modText
                    .height(18.ndp())
            )
            Text(
                text = entry.artist,
                fontSize = 12.nsp(),
                fontFamily = sarasaFont,
                textAlign = TextAlign.End,
                color = Colors.TEXT_GRAY,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = modText
                    .height(16.ndp())
            )
        }
        Column {
            Box(
                modifier = Modifier
                    .width(barWidth)
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
                            .width(newBarWidth)
                            .height(if (isCompare) 18.ndp() else 34.ndp())
                            .background(
                                color = Colors.RANKING_RED,
                                shape = RoundedCornerShape(
                                    topEnd = 50.ndp(),
                                    bottomEnd = 50.ndp()
                                )
                            )
                    )
                    Text(
                        text = entry.total.toString(),
                        color = Color.White,
                        fontSize = if (isCompare) 14.nsp() else 20.nsp(),
                        lineHeight = if (isCompare) 18.nsp() else 24.nsp(),
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
            if (isCompare) {
                Box(
                    modifier = Modifier
                        .width(barWidth)
                        .background(
                            color = Color.Transparent,
                        )
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
                                .width(oldBarWidth)
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
                            text = entry.oldTotal.toString(),
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
            }
        }
        if (rowWidth > 800.dp) {
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
            Text(
                text = CommonUtils.formatNumber(entry.median),
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                fontSize = 20.nsp(),
                lineHeight = 36.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.ndp())
                    .width(74.ndp())
                    .background(calculateColor(entry.median))
                    .padding(end = 4.ndp())
            )
            Text(
                text = CommonUtils.formatNumber(entry.avg),
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                fontSize = 20.nsp(),
                lineHeight = 36.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(74.ndp())
                    .background(calculateColor(entry.avg))
                    .padding(end = 4.ndp())
            )
        }
    }
}