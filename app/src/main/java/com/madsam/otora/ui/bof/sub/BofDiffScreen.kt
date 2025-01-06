package com.madsam.otora.ui.bof.sub

import android.content.Context
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.Canvas
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
import androidx.compose.ui.graphics.asAndroidBitmap
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
import com.madsam.otora.consts.RANKING_RED
import com.madsam.otora.consts.TEXT_GRAY
import com.madsam.otora.fonts.sarasaFont
import com.madsam.otora.model.bof.ui.BofEntryShow
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.utils.ImageUtils.saveBitmapToGallery
import com.madsam.otora.utils.ScreenUtil.isLandscape
import com.madsam.otora.utils.ndp
import com.madsam.otora.utils.nsp
import dev.shreyaspatil.capturable.capturable
import dev.shreyaspatil.capturable.controller.CaptureController
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.bof.sub.BofScreen
 * 创建者: MadSamurai
 * 创建时间: 2024/10/7
 * 描述: BOF数据展示界面
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BofDiffScreen(
    vm: BofViewModel,
    snackbarHostState: SnackbarHostState,
    listState: LazyListState
) {
    val scope = rememberCoroutineScope()

    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val view = LocalView.current

    val diffData = vm.diffData.asStateFlow().collectAsState()
    val maxDiff = diffData.value.maxOfOrNull { it.totalDiff } ?: 1
    val isReverse = vm.isDiffReverse.asStateFlow().collectAsState().value
    val selectedDate = vm.selectedCurrentDate.asStateFlow().collectAsState().value
    val selectedTime = vm.selectedCurrentTime.asStateFlow().collectAsState().value
    val selectedTimeStr = vm.selectedTimeStr.asStateFlow().collectAsState().value
    val leftPadding = vm.leftPadding.asStateFlow().collectAsState().value
    val rightPadding = vm.rightPadding.asStateFlow().collectAsState().value

    val highlightedText = vm.highlightedText.asStateFlow().collectAsState().value

    LaunchedEffect(selectedDate, selectedTime) {
        scope.launch {
            vm.requestDiffData()
            vm.generateSelectedTimeStr()
        }
    }

    val showDialog = remember { mutableStateOf(false) }

    val screenWidthDp = configuration.screenWidthDp.dp
    val barWidth = when (screenWidthDp) {
        in 0.dp..800.dp -> (screenWidthDp.value * 0.3)
        else -> 240.0
    }

    // Rank: 40, ImprDiff: 36
    val textWidth = screenWidthDp - 76.ndp() - barWidth.ndp()

    LaunchedEffect(configuration) {
        vm.updatePadding(view)
    }

    DiffCapture(
        showDialog = showDialog,
        context = context,
        snackbarHostState = snackbarHostState,
        diffData = diffData.value,
        selectedDate = selectedDate,
        selectedTimeStr = selectedTimeStr,
        maxDiff = maxDiff,
        configuration = configuration,
        leftPadding = leftPadding,
        rightPadding = rightPadding,
        isReverse = isReverse
    )

    LazyColumn(state = listState) {
        item {
            Box {
                DiffHeader(
                    configuration = configuration,
                    leftPadding = leftPadding,
                    rightPadding = rightPadding,
                    barWidth = barWidth,
                    textWidth = textWidth,
                    diffData = diffData.value,
                    selectedTimeStr = selectedTimeStr,
                    isReverse = isReverse
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
                }
            }
        }
        if (diffData.value.isNotEmpty()) {
            itemsIndexed(diffData.value) { index, entry ->
                BofEntryRowDiff(
                    entry = entry,
                    index = index + 1,
                    maxDiff = maxDiff,
                    isImage = false,
                    barWidth = barWidth,
                    textWidth = textWidth,
                    configuration = configuration,
                    leftPadding = leftPadding,
                    rightPadding = rightPadding,
                    highlightedText = highlightedText
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DiffCapture(
    showDialog: MutableState<Boolean>,
    context: Context,
    snackbarHostState: SnackbarHostState,
    diffData: List<BofEntryShow>,
    selectedDate: LocalDate,
    selectedTimeStr: String,
    maxDiff: Int,
    configuration: Configuration,
    leftPadding: Dp,
    rightPadding: Dp,
    isReverse: Boolean
) {
    val screenWidthImage = 1000.dp
    val barWidthImage = 280.0
    val textWidthImage = 1000.dp - 138.ndp() - barWidthImage.ndp()
    val scope = rememberCoroutineScope()
    if (showDialog.value) {
        val captureControllerList = mutableListOf<CaptureController>()
        repeat(diffData.size / 100 + 1) {
            captureControllerList.add(rememberCaptureController())
        }
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Capture Content") },
            modifier = Modifier.height(300.dp),
            text = {
                Column {
                    Text(
                        text = "Capturing content will save the current content to your gallery. " +
                                "Image may be too large to show in the dialog, " +
                                "including the parts that are not visible on the screen.",
                        modifier = Modifier.padding(8.dp)
                    )
                    for (i in 0 until diffData.size / 100 + 1) {
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
                                    DiffHeader(
                                        configuration = configuration,
                                        leftPadding = leftPadding,
                                        rightPadding = rightPadding,
                                        barWidth = barWidthImage,
                                        textWidth = textWidthImage,
                                        isImage = true,
                                        diffData = diffData,
                                        selectedTimeStr = selectedTimeStr,
                                        isReverse = isReverse
                                    )
                                if (diffData.isNotEmpty())
                                    for ((index, entry) in diffData.withIndex())
                                        if (index in i * 100..(i + 1) * 100 - 1)
                                            BofEntryRowDiff(
                                                entry = entry,
                                                index = index + 1,
                                                maxDiff = maxDiff,
                                                isImage = true,
                                                barWidth = barWidthImage,
                                                textWidth = textWidthImage
                                            )
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
                                val newHeight = maxHeight
                                Bitmap.createBitmap(newWidth, newHeight, Bitmap.Config.ARGB_8888).apply {
                                    val canvas = Canvas(this)
                                    var currentHeight = 0
                                    for (hardwareBitmap in bitmapList) {
                                        val scaledBitmap = Bitmap.createScaledBitmap(
                                            hardwareBitmap.copy(Bitmap.Config.ARGB_8888, false),
                                            newWidth,
                                            (hardwareBitmap.height * scaleFactor).toInt(),
                                            true
                                        )
                                        canvas.drawBitmap(scaledBitmap, 0f, currentHeight.toFloat(), null)
                                        currentHeight += scaledBitmap.height
                                    }
                                }
                            } else {
                                Bitmap.createBitmap(bitmapList[0].width, totalHeight, Bitmap.Config.ARGB_8888).apply {
                                    val canvas = Canvas(this)
                                    var currentHeight = 0
                                    for (hardwareBitmap in bitmapList) {
                                        val softwareBitmap = hardwareBitmap.copy(Bitmap.Config.ARGB_8888, false)
                                        canvas.drawBitmap(softwareBitmap, 0f, currentHeight.toFloat(), null)
                                        currentHeight += softwareBitmap.height
                                    }
                                }
                            }
                            saveBitmapToGallery(
                                context,
                                bitmap,
                                "bof_diff_${selectedDate}_$selectedTimeStr",
                                "BOF Diff Score Ranking"
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
fun DiffHeader(
    configuration: Configuration,
    leftPadding: Dp,
    rightPadding: Dp,
    barWidth: Double,
    textWidth: Dp,
    isImage: Boolean = false,
    diffData: List<BofEntryShow> = emptyList(),
    selectedTimeStr: String = "",
    isReverse: Boolean = false
) {
    Column {
        if (diffData.isEmpty()) {
            Text(text = "No ${selectedTimeStr.split(",")[0]}")
        } else {
            Text(
                text = "Total ${if (isReverse) "Nerf" else "Difference"} Ranking",
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
                    .padding(end = 4.ndp())
                    .width(36.ndp())
            )
            Text(
                text = "",
                modifier = Modifier
                    .width(textWidth)
                    .padding(end = 8.ndp(), top = 2.ndp())
            )
            Text(
                text = if (isReverse) "Nerf" else "Diff",
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                fontSize = 16.nsp(),
                color = Color.White,
                modifier = Modifier
                    .width(barWidth.ndp() - 36.ndp())
            )
            Text(
                text = "Impr${if (isReverse) "Nerf" else "Diff"}",
                fontFamily = sarasaFont,
                fontWeight = FontWeight.Bold,
                fontSize = 16.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(72.ndp())
            )
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
fun BofEntryRowDiff(
    entry: BofEntryShow,
    index: Int,
    maxDiff: Int,
    isImage: Boolean = false,
    barWidth: Double,
    textWidth: Dp,
    configuration: Configuration = LocalConfiguration.current,
    leftPadding: Dp = 0.dp,
    rightPadding: Dp = 0.dp,
    highlightedText: String = ""
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black

    val newBarWidth = if (maxDiff == 0) 0.0
    else entry.totalDiff.toDouble() / maxDiff * barWidth

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
                            .height(32.ndp())
                            .background(
                                color = RANKING_RED,
                                shape = RoundedCornerShape(
                                    topEnd = 50.ndp(),
                                    bottomEnd = 50.ndp()
                                )
                            )
                    )
                    Text(
                        text = entry.totalDiff.toString(),
                        color = Color.White,
                        fontSize = 20.nsp(),
                        lineHeight = 24.nsp(),
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
        }
        Text(
            text = entry.imprDiff.toString(),
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