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
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.ui.bof.components.ScoreChart
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.BG_DARK_GRAY
import com.madsam.otora.core.theme.RANKING_BLUE
import com.madsam.otora.core.theme.RANKING_GREEN
import com.madsam.otora.core.theme.RANKING_RED
import com.madsam.otora.core.theme.TEXT_GRAY
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.ImageUtils.saveBitmapToGallery
import com.madsam.otora.core.utils.ScreenUtil.isLandscape
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
 * 文件名: com.madsam.otora.ui.bof.sub.BofCommentScreen
 * 创建者: MadSamurai
 * 创建时间: 2025/1/10
 * 描述: BOF评论界面
 */

@Composable
internal fun BofCommentScreen(
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

    val commentData = vm.commentData.asStateFlow().collectAsState()
    val maxComment = commentData.value.maxOfOrNull { it.total } ?: 0

    val selectedTimeStrNoComp = vm.selectedTimeStrNoComp.asStateFlow().collectAsState().value
    val leftPadding = vm.leftPadding.asStateFlow().collectAsState().value
    val rightPadding = vm.rightPadding.asStateFlow().collectAsState().value

    val highlightedText = vm.highlightedText.asStateFlow().collectAsState().value

    val currentDate = bofScreenState.selectedCurrentDate.asStateFlow().collectAsState().value
    val currentTime = bofScreenState.selectedCurrentTime.asStateFlow().collectAsState().value
    val compareDate = bofScreenState.selectedCompareDate.asStateFlow().collectAsState().value
    val compareTime = bofScreenState.selectedCompareTime.asStateFlow().collectAsState().value
    LaunchedEffect(currentDate, currentTime, compareDate, compareTime) {
        scope.launch {
            vm.requestCommentData()
            vm.generateSelectedTimeStr()
        }
    }

    val showDialog = remember { mutableStateOf(false) }
    val dataSwitch = remember { mutableStateOf(false) }

    val isCompare = false

    val screenWidthDp = configuration.screenWidthDp.dp
    val barWidth = when {
        screenWidthDp >= 1000.dp -> 280.0
        screenWidthDp in 800.dp..999.dp -> 186.0 + (screenWidthDp.value - 800) / 200.0 * 94.0
        else -> 186.0
    }
    val textWidth = when {
        screenWidthDp > 800.dp ->
            // Rank: 40, Country: 36, Impr: 74, Median: 74, Avg: 74, Total: 36
            screenWidthDp - 334.ndp() - barWidth.ndp()

        else ->
            // Rank: 40, Country: 36, Impr: 74, Median: 74, Avg: 74
            screenWidthDp - 298.ndp()
    }

    LaunchedEffect(configuration) {
        vm.updatePadding(view)
    }

    CommentCapture(
        showDialog = showDialog,
        context = context,
        snackbarHostState = snackbarHostState,
        commentData = commentData.value,
        selectedTimeStr = selectedTimeStrNoComp,
        maxComment = maxComment,
        isCompare = isCompare,
        configuration = configuration,
        leftPadding = leftPadding,
        rightPadding = rightPadding
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
                CommentHeader(
                    configuration = configuration,
                    leftPadding = leftPadding,
                    rightPadding = rightPadding,
                    screenWidthDp = screenWidthDp,
                    barWidth = barWidth,
                    textWidth = textWidth,
                    commentData = commentData.value,
                    selectedTimeStr = selectedTimeStrNoComp,
                    dataSwitch = dataSwitch.value
                )
                if (commentData.value.isEmpty()) return@Box
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
                    if (screenWidthDp <= 800.dp) {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.SwitchArrow),
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
        if (commentData.value.isNotEmpty()) {
            itemsIndexed(commentData.value) { index, entry ->
                BofEntryRowComment(
                    entry = entry,
                    index = index + 1,
                    maxComment = maxComment,
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
internal fun CommentCapture(
    showDialog: MutableState<Boolean>,
    context: Context,
    snackbarHostState: SnackbarHostState,
    commentData: List<BofCommentUI>,
    selectedTimeStr: String,
    maxComment: Int,
    isCompare: Boolean,
    configuration: Configuration,
    leftPadding: Dp,
    rightPadding: Dp,
) {
    val screenWidthImage = 1000.dp
    val barWidthImage = 280.0
    val textWidthImage = 1000.dp - 334.ndp() - barWidthImage.ndp()
    val scope = rememberCoroutineScope()
    if (showDialog.value) {
        val captureControllerList = mutableListOf<CaptureController>()
        repeat(commentData.size / 100 + 1) {
            captureControllerList.add(rememberCaptureController())
        }
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Capture Content") },
            modifier = Modifier.height(300.dp),
            text = {
                Column {
                    Text(
                        text = "Capturing content will save the current content to your gallery.",
                        modifier = Modifier.padding(8.dp)
                    )
                    for (i in 0..commentData.size / 100) {
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
                                    CommentHeader(
                                        configuration = configuration,
                                        leftPadding = leftPadding,
                                        rightPadding = rightPadding,
                                        screenWidthDp = screenWidthImage,
                                        barWidth = barWidthImage,
                                        textWidth = textWidthImage,
                                        isImage = true,
                                        commentData = commentData,
                                        selectedTimeStr = selectedTimeStr,
                                    )
                                if (commentData.isEmpty()) return@Box
                                for ((index, entry) in commentData.withIndex()) {
                                    if (index !in i * 100..<(i + 1) * 100) continue
                                    BofEntryRowComment(
                                        entry = entry,
                                        index = index + 1,
                                        maxComment = maxComment,
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
                            val commentHeight = bitmapList.sumOf { it.height }
                            val maxHeight = 32000
                            val bitmap = if (commentHeight > maxHeight) {
                                val scaleFactor = maxHeight.toFloat() / commentHeight
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
                                createBitmap(bitmapList[0].width, commentHeight).apply {
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
                                "bof_comment_${timeStr}_$selectedTimeStr",
                                "BOF Comment Score Ranking"
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
internal fun CommentHeader(
    configuration: Configuration,
    leftPadding: Dp,
    rightPadding: Dp,
    screenWidthDp: Dp,
    barWidth: Double,
    textWidth: Dp,
    isImage: Boolean = false,
    commentData: List<BofCommentUI> = emptyList(),
    selectedTimeStr: String = "",
    dataSwitch: Boolean = false
) {
    Column {
        if (commentData.isEmpty() || commentData[0].total == 0) {
            Text(
                text = selectedTimeStr,
                fontFamily = sarasaRegular,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        } else {
            Text(
                text = "Comment Score Ranking",
                fontFamily = sarasaRegular,
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
                text = selectedTimeStr,
                fontFamily = sarasaRegular,
                fontSize = 12.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(end = if (isLandscape(configuration) && !isImage) rightPadding else 0.dp)
            )
        }
        if (commentData.isEmpty()) return
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
                fontFamily = sarasaRegular,
                fontWeight = FontWeight.Bold,
                fontSize = 16.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(end = 4.ndp())
                    .width(36.ndp())
            )
            Text(
                text = "Region",
                fontFamily = sarasaRegular,
                fontWeight = FontWeight.Bold,
                fontSize = 16.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .width(textWidth + 36.ndp())
                    .padding(end = 6.ndp())
            )
            if (!dataSwitch) {
                Row(
                    modifier = Modifier
                        .width(barWidth.ndp() - 5.ndp())
                ) {
                    Box(
                        modifier = Modifier
                            .size(14.ndp())
                            .background(RANKING_GREEN)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "Vote",
                        fontFamily = sarasaRegular,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.nsp(),
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(40.ndp())
                            .padding(start = 2.ndp())
                    )
                    Box(
                        modifier = Modifier
                            .size(14.ndp())
                            .background(RANKING_BLUE)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "Short",
                        fontFamily = sarasaRegular,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.nsp(),
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(48.ndp())
                            .padding(start = 2.ndp())
                    )
                    Box(
                        modifier = Modifier
                            .size(14.ndp())
                            .background(RANKING_RED)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "Long",
                        fontFamily = sarasaRegular,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.nsp(),
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(40.ndp())
                            .padding(start = 2.ndp())
                    )
                }
                Text(
                    text = "Total",
                    fontFamily = sarasaRegular,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.nsp(),
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(41.ndp())
                )
            }
            if (screenWidthDp > 800.dp || dataSwitch) {
                Text(
                    text = "VoteAvg",
                    fontFamily = sarasaRegular,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.nsp(),
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(74.ndp())
                )
                Text(
                    text = "ShortAvg",
                    fontFamily = sarasaRegular,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.nsp(),
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(74.ndp())
                )
                Text(
                    text = "LongAvg",
                    fontFamily = sarasaRegular,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.nsp(),
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(74.ndp())
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

@Composable
internal fun BofEntryRowComment(
    entry: BofCommentUI,
    index: Int,
    maxComment: Int,
    isCompare: Boolean = true,
    isImage: Boolean = false,
    rowWidth: Dp,
    barWidth: Double,
    textWidth: Dp,
    configuration: Configuration = LocalConfiguration.current,
    leftPadding: Dp = 0.dp,
    rightPadding: Dp = 0.dp,
    dataSwitch: Boolean = false,
    highlightedText: String = ""
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black
    val voteBarWidth = if (maxComment == 0) 0.0
    else entry.vote.toDouble() / maxComment * barWidth
    val shortBarWidth = if (maxComment == 0) 0.0
    else entry.short.toDouble() / maxComment * barWidth
    val longBarWidth = if (maxComment == 0) 0.0
    else entry.long.toDouble() / maxComment * barWidth

    val annotatedString = buildAnnotatedString {
        if (highlightedText.isNotEmpty()) {
            var startIndex = entry.user.indexOf(highlightedText, ignoreCase = true)
            var currentIndex = 0
            while (startIndex >= 0) {
                append(entry.user.substring(currentIndex, startIndex))
                withStyle(style = SpanStyle(background = Color.Red)) {
                    append(entry.user.substring(startIndex, startIndex + highlightedText.length))
                }
                currentIndex = startIndex + highlightedText.length
                startIndex = entry.user.indexOf(
                    highlightedText,
                    startIndex + highlightedText.length,
                    ignoreCase = true
                )
            }
            append(entry.user.substring(currentIndex))
        } else {
            append(entry.user)
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
        Text(
            text = entry.index.toString(),
            fontFamily = sarasaRegular,
            fontWeight = FontWeight.Bold,
            fontSize = 20.nsp(),
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 4.ndp())
                .width(36.ndp())
        )
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
                fontSize = if (entry.pattern.isEmpty()) 20.nsp() else 15.nsp(),
                lineHeight = if (entry.pattern.isEmpty()) 36.nsp() else 16.nsp(),
                fontFamily = sarasaRegular,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = textMod(
                    if (entry.pattern.isEmpty()) 0.ndp() else 2.ndp(),
                    if (entry.pattern.isEmpty()) 36.ndp() else 18.ndp()
                )
            )
            if (entry.pattern.isNotEmpty()) {
                Text(
                    text = entry.pattern,
                    fontSize = 12.nsp(),
                    lineHeight = 13.nsp(),
                    fontFamily = sarasaRegular,
                    textAlign = TextAlign.End,
                    color = TEXT_GRAY,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = textMod(0.ndp(), 16.ndp())
                )
            }
        }
        Text(
            text = entry.country,
            color = Color.White,
            fontSize = 20.nsp(),
            lineHeight = 24.nsp(),
            fontFamily = sarasaRegular,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            maxLines = 1,
            modifier = Modifier
                .width(36.ndp())
                .align(Alignment.CenterVertically)
                .padding(end = 8.ndp())
        )
        if (rowWidth > 800.dp || !dataSwitch) {
            Column {
                Box(
                    modifier = Modifier
                        .width(barWidth.ndp())
                        .background(color = Color.Transparent)
                ) {
                    if (entry.index <= 50) {
                        Row {
                            entry.voteChartData.takeIf { entry.vote != 0 }?.let { data ->
                                key(entry.index) {
                                    Box(
                                        modifier = Modifier
                                            .width(voteBarWidth.ndp())
                                            .height(34.ndp())
                                    ) {
                                        ScoreChart(
                                            dataList = data,
                                            height = 34.ndp(),
                                            width = voteBarWidth.ndp(),
                                            color = RANKING_GREEN
                                        )
                                    }
                                }
                            }
                            entry.shortChartData.takeIf { entry.short != 0 }?.let { data ->
                                key(entry.index) {
                                    Box(
                                        modifier = Modifier
                                            .width(shortBarWidth.ndp())
                                            .height(34.ndp())
                                    ) {
                                        ScoreChart(
                                            dataList = data,
                                            height = 34.ndp(),
                                            width = shortBarWidth.ndp(),
                                            color = RANKING_BLUE
                                        )
                                    }
                                }
                            }
                            entry.longChartData.takeIf { entry.long != 0 }?.let { data ->
                                key(entry.index) {
                                    Box(
                                        modifier = Modifier
                                            .width(longBarWidth.ndp())
                                            .height(34.ndp())
                                    ) {
                                        ScoreChart(
                                            dataList = data,
                                            height = 34.ndp(),
                                            width = longBarWidth.ndp(),
                                            color = RANKING_RED
                                        )
                                    }
                                }
                            }
                        }
                        Row {
                            val voteMinWidth = when {
                                entry.vote >= 100 -> 30.0
                                entry.vote >= 10 -> 20.0
                                entry.vote == 0 -> voteBarWidth
                                else -> 10.0
                            }
                            val voteDelta = voteMinWidth - voteBarWidth
                            val shortMinWidth = when {
                                entry.short >= 100 -> 30.0
                                entry.short >= 10 -> 20.0
                                entry.short == 0 -> shortBarWidth
                                else -> 10.0
                            }
                            val shortDelta = shortMinWidth - shortBarWidth
                            val longMinWidth = when {
                                entry.long >= 100 -> 30.0
                                entry.long >= 10 -> 20.0
                                entry.long == 0 -> longBarWidth
                                else -> 10.0
                            }
                            val longDelta = longMinWidth - longBarWidth
                            var voteTextWidth = voteBarWidth + max(voteDelta, 0.0)
                            var shortTextWidth = shortBarWidth + max(shortDelta, 0.0)
                            var longTextWidth = longBarWidth + max(longDelta, 0.0)
                            if (shortDelta < 0)
                                shortTextWidth -= (max(voteDelta, 0.0) + max(longDelta, 0.0))
                            if (voteDelta < 0 && shortDelta >= 0 && longDelta < 0) {
                                voteTextWidth -= (max(shortDelta, 0.0) + max(longDelta, 0.0)) / 2
                                longTextWidth -= (max(voteDelta, 0.0) + max(shortDelta, 0.0)) / 2
                            }
                            if (voteDelta >= 0 && shortDelta >= 0 && longDelta < 0)
                                longTextWidth -= (max(voteDelta, 0.0) + max(shortDelta, 0.0))
                            if (voteDelta < 0 && shortDelta >= 0 && longDelta >= 0)
                                voteTextWidth -= (max(shortDelta, 0.0) + max(longDelta, 0.0))
                            if (entry.vote != 0) {
                                Box(
                                    modifier = Modifier
                                        .height(if (isCompare) 18.ndp() else 34.ndp())
                                ) {
                                    ScoreText(
                                        text = entry.vote.toString(),
                                        color = RANKING_GREEN,
                                        textAlign = if (voteDelta >= 0) TextAlign.Start else TextAlign.End,
                                        modifier = Modifier
                                            .width(voteTextWidth.ndp())
                                            .align(Alignment.BottomEnd)
                                    )
                                }
                            }
                            if (entry.short != 0) {
                                Box(
                                    modifier = Modifier
                                        .height(if (isCompare) 18.ndp() else 34.ndp())
                                ) {
                                    ScoreText(
                                        text = entry.short.toString(),
                                        color = RANKING_BLUE,
                                        textAlign = if (shortDelta >= 0 && entry.long != 0 && entry.vote == 0) TextAlign.Start else TextAlign.End,
                                        modifier = Modifier
                                            .width(shortTextWidth.ndp())
                                            .align(Alignment.BottomEnd)
                                    )
                                }
                            }
                            if (entry.long != 0) {
                                Box(
                                    modifier = Modifier
                                        .height(if (isCompare) 18.ndp() else 34.ndp())
                                ) {
                                    ScoreText(
                                        text = entry.long.toString(),
                                        color = RANKING_RED,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier
                                            .width(longTextWidth.ndp())
                                            .align(Alignment.BottomEnd)
                                    )
                                }
                            }
                        }
                    } else {
                        Row(
                            Modifier
                                .padding(top = 2.ndp())
                                .background(color = Color.Transparent)
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(voteBarWidth.ndp())
                                    .height(34.ndp())
                                    .background(color = RANKING_GREEN)
                            )
                            Box(
                                modifier = Modifier
                                    .width(shortBarWidth.ndp())
                                    .height(34.ndp())
                                    .background(color = RANKING_BLUE)
                            )
                            Box(
                                modifier = Modifier
                                    .width(longBarWidth.ndp())
                                    .height(34.ndp())
                                    .background(color = RANKING_RED)
                            )
                        }
                    }
                }
            }
            Text(
                text = entry.total.toString(),
                color = Color.White,
                fontSize = 20.nsp(),
                lineHeight = 24.nsp(),
                fontFamily = sarasaRegular,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                maxLines = 1,
                modifier = Modifier
                    .width(36.ndp())
                    .align(Alignment.CenterVertically)
                    .padding(end = 2.ndp())
            )
        }
        if (rowWidth > 800.dp || dataSwitch) {
            Text(
                text = CommonUtils.truncateToTwoDecimalPlaces(entry.voteAve),
                fontFamily = sarasaRegular,
                fontWeight = FontWeight.Bold,
                fontSize = 20.nsp(),
                lineHeight = 36.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(74.ndp())
                    .background(calculateColor(entry.voteAve))
                    .padding(end = 4.ndp())
            )
            Text(
                text = CommonUtils.truncateToTwoDecimalPlaces(entry.shortAve),
                fontFamily = sarasaRegular,
                fontWeight = FontWeight.Bold,
                fontSize = 20.nsp(),
                lineHeight = 36.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(74.ndp())
                    .background(calculateColor(entry.shortAve))
                    .padding(end = 4.ndp())
            )
            Text(
                text = CommonUtils.truncateToTwoDecimalPlaces(entry.longAve),
                fontFamily = sarasaRegular,
                fontWeight = FontWeight.Bold,
                fontSize = 20.nsp(),
                lineHeight = 36.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(74.ndp())
                    .background(calculateColor(entry.longAve))
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

@Composable
fun ScoreText(
    text: String,
    color: Color,
    textAlign: TextAlign,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = color.copy(alpha = 1.0f).copy(
            red = color.red * 2f,
            green = color.green * 2f,
            blue = color.blue * 2f
        ),
        fontSize = 14.nsp(),
        fontFamily = sarasaRegular,
        fontWeight = FontWeight.Bold,
        style = TextStyle(
            shadow = Shadow(
                color = color,
                offset = Offset(0f, 0f),
                blurRadius = 20f
            )
        ),
        overflow = TextOverflow.Visible,
        maxLines = 1,
        textAlign = textAlign,
        modifier = modifier
    )
}
