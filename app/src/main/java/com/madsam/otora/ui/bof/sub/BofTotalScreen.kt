package com.madsam.otora.ui.bof.sub

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.madsam.otora.R
import com.madsam.otora.consts.BG_DARK_GRAY
import com.madsam.otora.consts.RANKING_BLUE
import com.madsam.otora.consts.RANKING_GREEN
import com.madsam.otora.consts.RANKING_RED
import com.madsam.otora.consts.RANKING_YELLOW
import com.madsam.otora.consts.TEXT_GRAY
import com.madsam.otora.fonts.sarasaFont
import com.madsam.otora.model.bof.ui.BofEntryShow
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.ui.record.osu.saveImageBitmapToFile
import com.madsam.otora.ui.record.osu.saveImageToGallery
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.ScreenUtil.isLandscape
import com.madsam.otora.utils.ndp
import com.madsam.otora.utils.nsp
import dev.shreyaspatil.capturable.capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.time.LocalDate
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
    snackbarHostState: SnackbarHostState,
    listState: LazyListState
) {
    val scope = rememberCoroutineScope()

    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val view = LocalView.current

    val totalData = vm.totalData.asStateFlow().collectAsState()
    val maxTotal = max(
        totalData.value.maxOfOrNull { it.total } ?: 1,
        totalData.value.maxOfOrNull { it.oldTotal } ?: 1
    )
    val selectedDate = vm.selectedDate.asStateFlow().collectAsState().value
    val selectedTime = vm.selectedTime.asStateFlow().collectAsState().value
    val selectedTimeStr = vm.selectedTimeStr.asStateFlow().collectAsState().value
    val leftPadding = vm.leftPadding.asStateFlow().collectAsState().value
    val rightPadding = vm.rightPadding.asStateFlow().collectAsState().value

    val highlightedText = vm.highlightedText.asStateFlow().collectAsState().value

    LaunchedEffect(selectedDate, selectedTime) {
        scope.launch {
            vm.requestTotalData()
            vm.generateSelectedTimeStr()
        }
    }

    val showDialog = remember { mutableStateOf(false) }
    val dataSwitch = remember { mutableStateOf(false) }

    val isCompare = totalData.value.isNotEmpty() && totalData.value[0].oldTotal != 0

    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    val barWidth = when (screenWidthDp) {
        in 0.dp..400.dp -> (screenWidthDp.value * 0.4f)
        in 400.dp..800.dp -> ((screenWidthDp.value - 400) * 0.3f + 160)
        else -> 280f
    }
    val textWidth = when {
        screenWidthDp > 800.dp && isCompare ->
            // Compare: 62, Rank: 40, Impr: 36, Median: 82, Avg: 74
            screenWidthDp - 294.ndp() - barWidth.ndp()
        screenWidthDp > 800.dp && !isCompare ->
            // Rank: 40, Impr: 36, Median: 82, Avg: 74
            screenWidthDp - 232.ndp() - barWidth.ndp()
        screenWidthDp < 800.dp && isCompare ->
            // Rank: 58,
            screenWidthDp - 58.ndp() - barWidth.ndp()
        else ->
            // Rank: 40,
            screenWidthDp - 40.ndp() - barWidth.ndp()
    }

    LaunchedEffect(configuration) {
        vm.updatePadding(view)
    }

    TotalCapture(
        showDialog = showDialog,
        context = context,
        snackbarHostState = snackbarHostState,
        totalData = totalData.value,
        selectedDate = selectedDate,
        selectedTimeStr = selectedTimeStr,
        maxTotal = maxTotal,
        isCompare = isCompare,
        configuration = configuration,
        leftPadding = leftPadding,
        rightPadding = rightPadding
    )

    LazyColumn(state = listState) {
        item {
            Box {
                TotalHeader(
                    configuration = configuration,
                    leftPadding = leftPadding,
                    rightPadding = rightPadding,
                    screenWidthDp = screenWidthDp,
                    isCompare = isCompare,
                    barWidth = barWidth,
                    textWidth = textWidth,
                    totalData = totalData.value,
                    selectedDate = selectedDate,
                    selectedTimeStr = selectedTimeStr,
                    dataSwitch = dataSwitch.value
                )
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .align(Alignment.TopEnd)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_picture),
                        contentDescription = "Capture",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(22.dp)
                            .clickable(onClick = { showDialog.value = true })
                    )
                    if (screenWidthDp <= 800.dp) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_switch_arrow),
                            contentDescription = "Capture",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(22.dp)
                                .clickable(onClick = { dataSwitch.value = !dataSwitch.value })
                        )
                    }
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
                    textWidth = textWidth,
                    configuration = configuration,
                    leftPadding = leftPadding,
                    rightPadding = rightPadding,
                    dataSwitch = dataSwitch.value,
                    highlightedText = highlightedText
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TotalCapture(
    showDialog: MutableState<Boolean>,
    context: Context,
    snackbarHostState: SnackbarHostState,
    totalData: List<BofEntryShow>,
    selectedDate: LocalDate,
    selectedTimeStr: String,
    maxTotal: Int,
    isCompare: Boolean,
    configuration: Configuration,
    leftPadding: Dp,
    rightPadding: Dp,
) {
    val screenWidthImage = 1000.dp
    val barWidthImage = 280f
    val textWidthImage = 1000.dp - 294.ndp() - barWidthImage.ndp()
    val scope = rememberCoroutineScope()
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
                            .requiredHeight(10000.dp)
                            .requiredWidth(screenWidthImage)
                    ) {
                        Column(
                            modifier = Modifier
                                .capturable(captureController)
                                .fillMaxWidth()
                        ) {
                            TotalHeader(
                                configuration = configuration,
                                leftPadding = leftPadding,
                                rightPadding = rightPadding,
                                screenWidthDp = screenWidthImage,
                                isCompare = isCompare,
                                barWidth = barWidthImage,
                                textWidth = textWidthImage,
                                isImage = true,
                                totalData = totalData,
                                selectedDate = selectedDate,
                                selectedTimeStr = selectedTimeStr,
                            )
                            if (totalData.isNotEmpty()) {
                                for ((index, entry) in totalData.withIndex()) {
                                    if (entry.index > 475) break
                                    BofEntryRowTotal(
                                        entry = entry,
                                        index = index + 1,
                                        maxTotal = maxTotal,
                                        isCompare = isCompare,
                                        isImage = true,
                                        rowWidth = screenWidthImage,
                                        barWidth = barWidthImage,
                                        textWidth = textWidthImage,
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
}

@Composable
fun TotalHeader(
    configuration: Configuration,
    leftPadding: Dp,
    rightPadding: Dp,
    screenWidthDp: Dp,
    isCompare: Boolean,
    barWidth: Float,
    textWidth: Dp,
    isImage: Boolean = false,
    totalData: List<BofEntryShow> = emptyList(),
    selectedDate: LocalDate = LocalDate.now(),
    selectedTimeStr: String = "",
    dataSwitch: Boolean = false
) {
    Column {
        if (totalData.isEmpty() || totalData[0].total == 0) {
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
                    .padding(end = if (isLandscape(configuration) && !isImage) rightPadding else 0.dp)
            )
        }
        Row(
            modifier = Modifier
                .background(BG_DARK_GRAY)
                .fillMaxWidth()
        ) {
            if (isLandscape(configuration) && !isImage) {
                Box(
                    modifier = Modifier
                        .width(leftPadding)
                )
            }
            Text(
                text = "Rank",
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                fontSize = 16.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(end = if (screenWidthDp < 800.dp && isCompare) 22.ndp() else 4.dp)
                    .width(if (screenWidthDp >= 800.dp && isCompare) 98.ndp() else 36.ndp())
            )
            Text(
                text = "",
                modifier = Modifier
                    .width(textWidth)
                    .padding(end = 8.ndp(), top = 2.ndp())
            )
            if (!dataSwitch) {
                Text(
                    text = "Total",
                    fontFamily = sarasaFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.nsp(),
                    color = Color.White,
                    modifier = Modifier
                        .width(barWidth.ndp())
                )
            }
            if (screenWidthDp > 800.dp || dataSwitch) {
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
                        .padding(end = 4.ndp())
                )
            }
            if (isLandscape(configuration) && !isImage) {
                Box(
                    modifier = Modifier
                        .width(rightPadding)
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
    barWidth: Float,
    textWidth: Dp,
    configuration: Configuration = LocalConfiguration.current,
    leftPadding: Dp = 0.dp,
    rightPadding: Dp = 0.dp,
    dataSwitch: Boolean = false,
    highlightedText: String = ""
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black

    val newBarWidth = if (maxTotal == 0) 0f
    else entry.total.toFloat() / maxTotal * barWidth
    val oldBarWidth = if (maxTotal == 0) 0f
    else entry.oldTotal.toFloat() / maxTotal * barWidth

    val annotatedString = buildAnnotatedString {
        if (highlightedText.isNotEmpty()) {
            var startIndex = entry.title.indexOf(highlightedText, ignoreCase = true)
            var currentIndex = 0
            while (startIndex >= 0) {
                append(entry.title.substring(currentIndex, startIndex))
                withStyle(style = SpanStyle(background = Color.Red)) {
                    append(entry.title.substring(startIndex, startIndex + highlightedText.length))
                }
                currentIndex = startIndex + highlightedText.length
                startIndex = entry.title.indexOf(highlightedText, startIndex + highlightedText.length, ignoreCase = true)
            }
            append(entry.title.substring(currentIndex))
        } else {
            append(entry.title)
        }
    }

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
        if (isLandscape(configuration) && !isImage) {
            Box(
                modifier = Modifier
                    .width(leftPadding)
                    .height(36.ndp())
            )
        }
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
                        tint = if (entry.rankDiff < 0) RANKING_RED
                        else if (entry.rankDiff > 0) RANKING_GREEN
                        else RANKING_YELLOW,
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
                        color = if (entry.rankDiff < 0) RANKING_RED
                        else if (entry.rankDiff > 0) RANKING_GREEN
                        else RANKING_YELLOW,
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
                    tint = if (entry.rankDiff < 0) RANKING_RED
                    else if (entry.rankDiff > 0) RANKING_GREEN
                    else RANKING_YELLOW,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(30.ndp())
                )
                Text(
                    text = if (entry.oldTotal == 0) "NEW" else entry.rankDiff.toString(),
                    fontFamily = sarasaFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.nsp(),
                    color = if (entry.rankDiff < 0) RANKING_RED
                    else if (entry.rankDiff > 0) RANKING_GREEN
                    else RANKING_YELLOW,
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
            /**
             * Please add (topPadding,height) in the round bracket.
             */
            val textMod = @Composable { top: Dp, height: Dp ->
                Modifier
                    .width(textWidth)
                    .padding(end = 8.ndp(), top = top)
                    .height(height)
                    .then(
                        if (!isImage) {
                            Modifier.basicMarquee(spacing = MarqueeSpacing(15.ndp()))
                        } else {
                            Modifier
                        }
                    )
            }
            Text(
                text = annotatedString,
                fontSize = 15.nsp(),
                lineHeight = 16.nsp(),
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = textMod(2.ndp(), 18.ndp())
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
                modifier = textMod(0.ndp(), 16.ndp())
            )
        }
        if (rowWidth > 800.dp || !dataSwitch) {
            Column {
                Box(
                    modifier = Modifier
                        .width(barWidth.ndp())
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
                                .width(newBarWidth.ndp())
                                .padding(end = 20.ndp())
                                .height(if (isCompare) 18.ndp() else 34.ndp())
                                .background(
                                    color = RANKING_RED,
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
                            .width(barWidth.ndp())
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
                                    .width(oldBarWidth.ndp())
                                    .padding(end = 20.ndp())
                                    .height(14.ndp())
                                    .background(
                                        color = RANKING_BLUE,
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
        }
        if (rowWidth > 800.dp || dataSwitch) {
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
        if (isLandscape(configuration) && !isImage) {
            Box(
                modifier = Modifier
                    .width(rightPadding)
                    .height(36.ndp())
            )
        }
    }
}