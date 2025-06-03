package com.madsam.otora.ui.bof.sub

import android.content.Context
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.theme.BG_DARK_GRAY
import com.madsam.otora.core.theme.RANKING_BLUE
import com.madsam.otora.core.theme.RANKING_GREEN
import com.madsam.otora.core.theme.RANKING_RED
import com.madsam.otora.core.theme.RANKING_YELLOW
import com.madsam.otora.core.theme.TEXT_GRAY
import com.madsam.otora.core.theme.sarasaFont
import com.madsam.otora.data.bof.ui.model.BofEntryUI
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.ImageUtils.saveBitmapToGallery
import com.madsam.otora.core.utils.ScreenUtil.isLandscape
import com.madsam.otora.core.utils.ScreenUtil.isPortrait
import com.madsam.otora.core.utils.ndp
import com.madsam.otora.core.utils.nsp
import dev.shreyaspatil.capturable.capturable
import dev.shreyaspatil.capturable.controller.CaptureController
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.max
import androidx.core.graphics.createBitmap
import androidx.core.graphics.scale

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.bof.sub.BofScreen
 * 创建者: MadSamurai
 * 创建时间: 2024/10/7
 * 描述: BOF数据展示界面
 */

@Composable
internal fun BofMedianScreen(
    vm: BofViewModel,
    snackbarHostState: SnackbarHostState,
    listState: LazyListState,
    scrollThreshold: Float,
    bofScreenState: BofScreenState,
    setIsTabRowVisible: (Boolean) -> Unit
) {
    val scope = rememberCoroutineScope()

    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val view = LocalView.current

    val medianData = vm.medianData.asStateFlow().collectAsState()
    val maxMedian = max(
        medianData.value.maxOfOrNull { it.median } ?: 1.0,
        medianData.value.maxOfOrNull { it.oldMedian } ?: 1.0
    )
    val selectedTimeStr = vm.selectedTimeStr.asStateFlow().collectAsState().value
    val leftPadding = vm.leftPadding.asStateFlow().collectAsState().value
    val rightPadding = vm.rightPadding.asStateFlow().collectAsState().value

    val highlightedText = vm.highlightedText.asStateFlow().collectAsState().value

    val currentDate = bofScreenState.selectedCurrentDate.asStateFlow().collectAsState().value
    val currentTime = bofScreenState.selectedCurrentTime.asStateFlow().collectAsState().value
    val compareDate = bofScreenState.selectedCompareDate.asStateFlow().collectAsState().value
    val compareTime = bofScreenState.selectedCompareTime.asStateFlow().collectAsState().value
    LaunchedEffect(currentDate, currentTime, compareDate, compareTime) {
        scope.launch {
            vm.requestMedianData()
            vm.generateSelectedTimeStr()
        }
    }

    val thresholdImpr = vm.thresholdImpr.asStateFlow().collectAsState()
    val thresholdImprOld = vm.thresholdImprOld.asStateFlow().collectAsState()

    val showDialog = remember { mutableStateOf(false) }

    val isCompare = medianData.value.isNotEmpty() && medianData.value[0].oldMedian != 0.0

    val screenWidthDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }
    val barWidth = when (screenWidthDp) {
        in 0.dp..800.dp -> (screenWidthDp.value * 0.3)
        else -> 240.0
    }
    val textWidth = when {
        screenWidthDp > 800.dp && isCompare ->
            // Compare: 62, Rank: 40, Impr: 36
            screenWidthDp - 138.ndp() - barWidth.ndp()

        screenWidthDp > 800.dp && !isCompare ->
            // Rank: 40, Impr: 36
            screenWidthDp - 76.ndp() - barWidth.ndp()

        screenWidthDp < 800.dp && isCompare ->
            // Rank: 58, Impr: 36
            screenWidthDp - 94.ndp() - barWidth.ndp()

        else ->
            // Rank: 40, Impr: 36
            screenWidthDp - 76.ndp() - barWidth.ndp()
    }

    LaunchedEffect(configuration) {
        vm.updatePadding(view)
    }

    MedianCapture(
        showDialog = showDialog,
        context = context,
        snackbarHostState = snackbarHostState,
        medianData = medianData.value,
        selectedTimeStr = selectedTimeStr,
        maxMedian = maxMedian,
        isCompare = isCompare,
        configuration = configuration,
        leftPadding = leftPadding,
        rightPadding = rightPadding,
        thresholdImpr = thresholdImpr.value,
        thresholdImprOld = thresholdImprOld.value
    )

    LazyColumn(
        state = listState,
        modifier = Modifier
            .nestedScroll(object : NestedScrollConnection {
                private var totalScroll = 0f

                override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                    totalScroll += available.y
                    if (totalScroll < -scrollThreshold) {
                        setIsTabRowVisible(false)
                        totalScroll = 0f
                    } else if (totalScroll > scrollThreshold) {
                        setIsTabRowVisible(true)
                        totalScroll = 0f
                    }
                    return Offset.Zero
                }
            })
    ) {
        item {
            Box {
                MedianHeader(
                    configuration = configuration,
                    leftPadding = leftPadding,
                    rightPadding = rightPadding,
                    screenWidthDp = screenWidthDp,
                    isCompare = isCompare,
                    barWidth = barWidth,
                    textWidth = textWidth,
                    medianData = medianData.value,
                    selectedTimeStr = selectedTimeStr,
                    thresholdImpr = thresholdImpr.value
                )

                if (medianData.value.isEmpty()) return@Box
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .align(Alignment.TopEnd)
                ) {
                    Icon(
                        painter = rememberVectorPainter(image = Filled.Picture),
                        contentDescription = "Capture",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(22.dp)
                            .clickable(onClick = { showDialog.value = true })
                    )
                }
            }
        }
        if (medianData.value.isNotEmpty()) {
            itemsIndexed(medianData.value) { index, entry ->
                BofEntryRowMedian(
                    entry = entry,
                    index = index + 1,
                    maxMedian = maxMedian,
                    isCompare = isCompare,
                    isImage = false,
                    rowWidth = screenWidthDp,
                    barWidth = barWidth,
                    textWidth = textWidth,
                    configuration = configuration,
                    leftPadding = leftPadding,
                    rightPadding = rightPadding,
                    highlightedText = highlightedText,
                    thresholdImprOld = thresholdImprOld.value
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun MedianCapture(
    showDialog: MutableState<Boolean>,
    context: Context,
    snackbarHostState: SnackbarHostState,
    medianData: List<BofEntryUI>,
    selectedTimeStr: String,
    maxMedian: Double,
    isCompare: Boolean,
    configuration: Configuration,
    leftPadding: Dp,
    rightPadding: Dp,
    thresholdImpr: Int,
    thresholdImprOld: Int
) {
    val screenWidthImage = 1000.dp
    val barWidthImage = 280.0
    val textWidthImage = 1000.dp - 138.ndp() - barWidthImage.ndp()
    val scope = rememberCoroutineScope()
    if (showDialog.value) {
        val captureControllerList = mutableListOf<CaptureController>()
        repeat(medianData.size / 100 + 1) {
            captureControllerList.add(rememberCaptureController())
        }
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Capture Content") },
            modifier = Modifier.height(300.dp),
            text = {
                Column {
                    Text(
                        text = "Capturing content will save the current content to your gallery. ",
                        modifier = Modifier.padding(8.dp)
                    )
                    for (i in 0..medianData.size / 100) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .height(0.dp)
                                .requiredHeight(5000.dp)
                                .requiredWidth(screenWidthImage)
                        ) {
                            Column(
                                modifier = Modifier
                                    .capturable(captureControllerList[i])
                                    .fillMaxWidth()
                            ) {
                                if (i == 0)
                                    MedianHeader(
                                        configuration = configuration,
                                        leftPadding = leftPadding,
                                        rightPadding = rightPadding,
                                        screenWidthDp = screenWidthImage,
                                        isCompare = isCompare,
                                        barWidth = barWidthImage,
                                        textWidth = textWidthImage,
                                        isImage = true,
                                        medianData = medianData,
                                        selectedTimeStr = selectedTimeStr,
                                        thresholdImpr = thresholdImpr
                                    )
                                if (medianData.isEmpty()) return@Box
                                for ((index, entry) in medianData.withIndex()) {
                                    if (index !in i * 100..<(i + 1) * 100) continue
                                    BofEntryRowMedian(
                                        entry = entry,
                                        index = index + 1,
                                        maxMedian = maxMedian,
                                        isCompare = isCompare,
                                        isImage = true,
                                        rowWidth = screenWidthImage,
                                        barWidth = barWidthImage,
                                        textWidth = textWidthImage,
                                        thresholdImprOld = thresholdImprOld
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
                        val bitmapList = mutableListOf<Bitmap>()
                        scope.launch {
                            for (captureController in captureControllerList) {
                                val bitmapAsync = captureController.captureAsync()
                                try {
                                    bitmapList.add(bitmapAsync.await().asAndroidBitmap())
                                } catch (error: Throwable) {
                                    Log.e("Capture", "Error capturing content", error)
                                    snackbarHostState.showSnackbar("Error capturing content")
                                    error.printStackTrace()
                                }
                            }
                            val totalHeight = bitmapList.sumOf { it.height }
                            val maxHeight = 32000
                            val bitmap = if (totalHeight > maxHeight) {
                                val scaleFactor = maxHeight.toFloat() / totalHeight
                                val newWidth = (bitmapList[0].width * scaleFactor).toInt()
                                createBitmap(newWidth, maxHeight)
                                    .apply {
                                        val canvas = Canvas(this)
                                        var currentHeight = 0
                                        for (hardwareBitmap in bitmapList) {
                                            val scaledBitmap =
                                                hardwareBitmap.copy(Bitmap.Config.ARGB_8888, false)
                                                    .scale(
                                                        newWidth,
                                                        (hardwareBitmap.height * scaleFactor).toInt()
                                                    )
                                            canvas.drawBitmap(
                                                scaledBitmap,
                                                0f,
                                                currentHeight.toFloat(),
                                                null
                                            )
                                            currentHeight += scaledBitmap.height
                                        }
                                    }
                            } else {
                                createBitmap(bitmapList[0].width, totalHeight).apply {
                                    val canvas = Canvas(this)
                                    var currentHeight = 0
                                    for (hardwareBitmap in bitmapList) {
                                        val softwareBitmap =
                                            hardwareBitmap.copy(Bitmap.Config.ARGB_8888, false)
                                        canvas.drawBitmap(
                                            softwareBitmap,
                                            0f,
                                            currentHeight.toFloat(),
                                            null
                                        )
                                        currentHeight += softwareBitmap.height
                                    }
                                }
                            }
                            val current = LocalDateTime.now()
                            val formatter = DateTimeFormatter.ofPattern("MMddHHmm")
                            val timeStr = current.format(formatter)
                            saveBitmapToGallery(
                                context,
                                bitmap,
                                "bof_median_${timeStr}_$selectedTimeStr",
                                "BOF Median Score Ranking"
                            )
                            snackbarHostState.showSnackbar("Image saved to gallery")
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
internal fun MedianHeader(
    configuration: Configuration,
    leftPadding: Dp,
    rightPadding: Dp,
    screenWidthDp: Dp,
    isCompare: Boolean,
    barWidth: Double,
    textWidth: Dp,
    isImage: Boolean = false,
    medianData: List<BofEntryUI> = emptyList(),
    selectedTimeStr: String = "",
    thresholdImpr: Int
) {
    Column {
        if (medianData.isEmpty() || medianData[0].median == 0.0) {
            Text(
                text = selectedTimeStr,
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        } else {
            Text(
                text = "Median Score Ranking",
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
                text = "Exclude Impr below $thresholdImpr",
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                fontSize = 18.nsp(),
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
            )
            Text(
                text = selectedTimeStr,
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
        if (medianData.isEmpty()) return
        Row(
            modifier = Modifier
                .background(BG_DARK_GRAY)
                .fillMaxWidth()
        ) {
            if (isLandscape(configuration) && !isImage) {
                Box(
                    modifier = Modifier.width(leftPadding)
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
            Text(
                text = "Median",
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                fontSize = 16.nsp(),
                color = Color.White,
                modifier = Modifier
                    .width(barWidth.ndp())
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
            if (isPortrait(configuration) || !isImage) return
            Box(
                modifier = Modifier
                    .width(rightPadding)
            )
        }
    }
}

@Composable
internal fun BofEntryRowMedian(
    entry: BofEntryUI,
    index: Int,
    maxMedian: Double,
    isCompare: Boolean = true,
    isImage: Boolean = false,
    rowWidth: Dp,
    barWidth: Double,
    textWidth: Dp,
    configuration: Configuration = LocalConfiguration.current,
    leftPadding: Dp = 0.dp,
    rightPadding: Dp = 0.dp,
    highlightedText: String = "",
    thresholdImprOld: Int
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black
    val newBarWidth = if (entry.median == 0.0) 0.0
    else entry.median / maxMedian * barWidth
    val oldBarWidth = if (entry.avg == 0.0) 0.0
    else entry.oldMedian / maxMedian * barWidth

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
                startIndex = entry.title.indexOf(
                    highlightedText,
                    startIndex + highlightedText.length,
                    ignoreCase = true
                )
            }
            append(entry.title.substring(currentIndex))
        } else {
            append(entry.title)
        }
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
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Icon(
                        painter = entry.medianDiff.let {
                            if (it > 0) rememberVectorPainter(image = Filled.ArrowWindUp)
                            else if (it < 0) rememberVectorPainter(image = Filled.ArrowWindDown)
                            else rememberVectorPainter(image = Filled.ArrowFlat)
                        },
                        contentDescription = null,
                        tint = if (entry.medianDiff > 0) RANKING_GREEN else if (entry.medianDiff < 0) RANKING_RED else RANKING_YELLOW,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = 2.ndp(), start = 8.ndp())
                            .width(16.ndp())
                    )
                    Text(
                        text = if (entry.oldMedian < thresholdImprOld) "NEW" else entry.medianDiff.toString(),
                        fontFamily = sarasaFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.nsp(),
                        color = if (entry.medianDiff > 0) RANKING_GREEN else if (entry.medianDiff < 0) RANKING_RED else RANKING_YELLOW,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(32.ndp())
                    )
                }
                Text(
                    text = entry.currentRank.toString(),
                    fontFamily = sarasaFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.nsp(),
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier.width(36.ndp())
                )
            }
        } else {
            if (isCompare) {
                Icon(
                    painter = entry.medianDiff.let {
                        if (it > 0) rememberVectorPainter(image = Filled.ArrowWindUp)
                        else if (it < 0) rememberVectorPainter(image = Filled.ArrowWindDown)
                        else rememberVectorPainter(image = Filled.ArrowFlat)
                    },
                    contentDescription = null,
                    tint = if (entry.medianDiff > 0) RANKING_GREEN else if (entry.medianDiff < 0) RANKING_RED else RANKING_YELLOW,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(30.ndp())
                )
                Text(
                    text = if (entry.oldMedian < thresholdImprOld) "NEW" else entry.medianDiff.toString(),
                    fontFamily = sarasaFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.nsp(),
                    color = if (entry.medianDiff > 0) RANKING_GREEN else if (entry.medianDiff < 0) RANKING_RED else RANKING_YELLOW,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(32.ndp())
                )
            }
            Text(
                text = entry.currentRank.toString(),
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
        Column {
            Box(
                modifier = Modifier
                    .width(barWidth.ndp())
                    .background(color = Color.Transparent)
            ) {
                Box(
                    Modifier
                        .padding(top = 2.ndp())
                        .background(color = Color.Transparent)
                ) {
                    Box(
                        modifier = Modifier
                            .width(newBarWidth.ndp())
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
                        text = CommonUtils.truncateToTwoDecimalPlaces(entry.median),
                        color = Color.White,
                        fontSize = if (isCompare) 14.nsp() else 20.nsp(),
                        lineHeight = if (isCompare) 18.nsp() else 24.nsp(),
                        fontFamily = sarasaFont,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Visible,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(end = 4.ndp())
                            .align(Alignment.CenterEnd)
                    )
                }
            }
            if (isCompare) {
                Box(
                    modifier = Modifier
                        .width(barWidth.ndp())
                        .background(color = Color.Transparent)
                ) {
                    Box(
                        Modifier.background(color = Color.Transparent)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(oldBarWidth.ndp())
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
                            text = CommonUtils.truncateToTwoDecimalPlaces(entry.oldMedian),
                            color = Color.White,
                            fontSize = 12.nsp(),
                            lineHeight = 14.nsp(),
                            fontFamily = sarasaFont,
                            overflow = TextOverflow.Visible,
                            maxLines = 1,
                            modifier = Modifier
                                .padding(end = 4.ndp())
                                .align(Alignment.CenterEnd)
                        )
                    }
                }
            }
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
        if (isLandscape(configuration) && !isImage) {
            Box(
                modifier = Modifier
                    .width(rightPadding)
                    .height(36.ndp())
            )
        }
    }
}