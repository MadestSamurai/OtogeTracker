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
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.layout.onGloballyPositioned
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
import com.madsam.otora.core.theme.interTight
import com.madsam.otora.data.bof.ui.model.BofTeamUI
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.core.icon.Filled
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

@Composable
internal fun BofTeamScreen(
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

    val teamData = vm.teamData.asStateFlow().collectAsState()
    val oldMax = teamData.value.maxOfOrNull { it.oldTotal } ?: 0.0
    val maxTotal = max(
        teamData.value.maxOfOrNull { it.total } ?: 0.0,
        oldMax
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
            vm.requestTeamData()
            vm.generateSelectedTimeStr()
        }
    }

    val showDialog = remember { mutableStateOf(false) }

    val isCompare = teamData.value.isNotEmpty() && oldMax != 0.0
    println(isCompare)

    val screenWidthDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }
    val textWidth = when {
        screenWidthDp > 800.dp && isCompare ->
            // Compare: 62, Rank: 36, Impr: 36, Median: 110
            screenWidthDp - 244.ndp()

        screenWidthDp <= 800.dp && isCompare ->
            // Compare: 58, Median: 96
            screenWidthDp - 154.ndp()

        screenWidthDp <= 800.dp && !isCompare ->
            // Rank: 36, Median: 96
            screenWidthDp - 132.ndp()

        // Rank: 36, Impr: 36, Median: 96
        else -> screenWidthDp - 168.ndp()
    }
    // Impr: 36
    val barWidth = if (screenWidthDp <= 800.dp) (textWidth - 36.ndp()).value.toDouble()
    else textWidth.value.toDouble()

    LaunchedEffect(configuration) {
        vm.updatePadding(view)
    }

    TeamCapture(
        showDialog = showDialog,
        context = context,
        snackbarHostState = snackbarHostState,
        teamData = teamData.value,
        selectedTimeStr = selectedTimeStr,
        maxTotal = maxTotal,
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
                TeamHeader(
                    configuration = configuration,
                    leftPadding = leftPadding,
                    rightPadding = rightPadding,
                    screenWidthDp = screenWidthDp,
                    isCompare = isCompare,
                    barWidth = barWidth,
                    teamData = teamData.value,
                    selectedTimeStr = selectedTimeStr
                )
                if (teamData.value.isEmpty()) return@Box
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
        if (teamData.value.isNotEmpty()) {
            itemsIndexed(teamData.value) { index, entry ->
                BofTeamRowTotal(
                    entry = entry,
                    index = index + 1,
                    maxTotal = maxTotal,
                    rowWidth = screenWidthDp,
                    isCompare = isCompare,
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
internal fun TeamCapture(
    showDialog: MutableState<Boolean>,
    context: Context,
    snackbarHostState: SnackbarHostState,
    teamData: List<BofTeamUI>,
    selectedTimeStr: String,
    maxTotal: Double,
    isCompare: Boolean,
    configuration: Configuration,
    leftPadding: Dp,
    rightPadding: Dp,
) {
    val screenWidthImage = 1000.dp
    val textWidthImage = 1000.dp - 244.ndp()
    val barWidthImage = textWidthImage.value.toDouble()
    val scope = rememberCoroutineScope()
    if (!showDialog.value) return
    val captureControllerList = mutableListOf<CaptureController>()
    repeat(teamData.size / 40 + 1) {
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
                for (i in 0..teamData.size / 40) {
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
                                TeamHeader(
                                    configuration = configuration,
                                    leftPadding = leftPadding,
                                    rightPadding = rightPadding,
                                    screenWidthDp = screenWidthImage,
                                    isCompare = isCompare,
                                    barWidth = barWidthImage,
                                    isImage = true,
                                    teamData = teamData,
                                    selectedTimeStr = selectedTimeStr,
                                )
                            if (teamData.isEmpty()) return@Box
                            for ((index, entry) in teamData.withIndex()) {
                                if (index !in i * 40..<(i + 1) * 40) continue
                                BofTeamRowTotal(
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
                            "bof_team_${timeStr}_$selectedTimeStr",
                            "BOF Team Score Ranking"
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

@Composable
internal fun TeamHeader(
    configuration: Configuration,
    leftPadding: Dp,
    rightPadding: Dp,
    screenWidthDp: Dp,
    isCompare: Boolean,
    barWidth: Double,
    isImage: Boolean = false,
    teamData: List<BofTeamUI> = emptyList(),
    selectedTimeStr: String = ""
) {
    Column {
        if (teamData.isEmpty() || teamData[0].total == 0.0) {
            Text(
                text = selectedTimeStr,
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        } else {
            Text(
                text = "Total Team Score Ranking",
                fontFamily = interTight,
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
                fontFamily = interTight,
                fontSize = 12.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(end = if (isLandscape(configuration) && !isImage) rightPadding else 0.dp)
            )
        }
        if (teamData.isEmpty()) return
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
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                fontSize = 16.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(end = if (screenWidthDp < 800.dp && isCompare) 22.ndp() else 0.dp)
                    .width(if (screenWidthDp >= 800.dp && isCompare) 98.ndp() else 36.ndp())
            )
            Text(
                text = "",
                modifier = Modifier
                    .width(barWidth.dp)
                    .padding(start = 13.ndp(), end = 8.ndp(), top = 2.ndp())
            )
            Text(
                text = "Impr",
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                fontSize = 16.nsp(),
                color = Color.White,
                modifier = Modifier
                    .width(36.ndp())
            )
            Text(
                text = "Median",
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                fontSize = 16.nsp(),
                textAlign = TextAlign.End,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 8.ndp())
                    .width(102.ndp())
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

@Composable
internal fun BofTeamRowTotal(
    entry: BofTeamUI,
    index: Int,
    maxTotal: Double,
    isCompare: Boolean = true,
    isImage: Boolean = false,
    rowWidth: Dp,
    barWidth: Double,
    textWidth: Dp,
    configuration: Configuration = LocalConfiguration.current,
    leftPadding: Dp = 0.dp,
    rightPadding: Dp = 0.dp,
    highlightedText: String = ""
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black

    val newBarWidth = if (maxTotal == 0.0) 0.0
    else entry.total / maxTotal * barWidth
    val oldBarWidth = if (maxTotal == 0.0) 0.0
    else entry.oldTotal / maxTotal * barWidth

    val rowHeight = remember { mutableIntStateOf(0) }

    val annotatedString = buildAnnotatedString {
        if (highlightedText.isNotEmpty()) {
            var startIndex = entry.team.indexOf(highlightedText, ignoreCase = true)
            var currentIndex = 0
            while (startIndex >= 0) {
                append(entry.team.substring(currentIndex, startIndex))
                withStyle(style = SpanStyle(background = Color.Red)) {
                    append(entry.team.substring(startIndex, startIndex + highlightedText.length))
                }
                currentIndex = startIndex + highlightedText.length
                startIndex = entry.team.indexOf(
                    highlightedText,
                    startIndex + highlightedText.length,
                    ignoreCase = true
                )
            }
            append(entry.team.substring(currentIndex))
        } else {
            append(entry.team)
        }
    }

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
        if (isLandscape(configuration) && isImage) {
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
                            if (it > 0) rememberVectorPainter(image = Filled.ArrowWindUp)
                            else if (it < 0) rememberVectorPainter(image = Filled.ArrowWindDown)
                            else rememberVectorPainter(image = Filled.ArrowFlat)
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
                        text = if (entry.oldTotal == 0.0) "NEW" else entry.rankDiff.toString(),
                        fontFamily = interTight,
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
                    text = entry.currentRank.toString(),
                    fontFamily = interTight,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.nsp(),
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
                            rememberVectorPainter(image = Filled.ArrowWindUp)
                        } else if (it < 0) {
                            rememberVectorPainter(image = Filled.ArrowWindDown)
                        } else {
                            rememberVectorPainter(image = Filled.ArrowFlat)
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
                    text = if (entry.oldTotal == 0.0) "NEW" else entry.rankDiff.toString(),
                    fontFamily = interTight,
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
                text = entry.currentRank.toString(),
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                fontSize = 20.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(36.ndp())
            )
        }
        Column {
            Row {
                Column {
                    Box(
                        modifier = Modifier
                            .width(barWidth.dp)
                            .background(color = Color.Transparent)
                            .padding(start = 13.ndp())
                    ) {
                        Box(
                            Modifier
                                .padding(top = 2.ndp())
                                .background(color = Color.Transparent)
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(newBarWidth.dp)
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
                                text = CommonUtils.truncateToTwoDecimalPlaces(entry.total),
                                color = Color.White,
                                fontSize = if (isCompare) 14.nsp() else 20.nsp(),
                                lineHeight = if (isCompare) 18.nsp() else 24.nsp(),
                                fontFamily = interTight,
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
                                .width(barWidth.dp)
                                .background(color = Color.Transparent)
                                .padding(start = 13.ndp())
                        ) {
                            Box(
                                Modifier
                                    .background(color = Color.Transparent)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .width(oldBarWidth.dp)
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
                                    text = CommonUtils.truncateToTwoDecimalPlaces(entry.oldTotal),
                                    color = Color.White,
                                    fontSize = 12.nsp(),
                                    lineHeight = 14.nsp(),
                                    fontFamily = interTight,
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
                if (rowWidth < 800.dp) {
                    Text(
                        text = entry.impr.toString(),
                        fontFamily = interTight,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.nsp(),
                        lineHeight = 34.nsp(),
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .width(36.ndp())
                    )
                }
            }
            Text(
                text = annotatedString,
                fontSize = 16.nsp(),
                lineHeight = 16.nsp(),
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .width(textWidth)
                    .padding(start = 13.ndp(), end = 8.ndp(), top = 2.ndp())
                    .then(
                        if (!isImage) {
                            Modifier.basicMarquee(spacing = MarqueeSpacing(15.ndp()))
                        } else {
                            Modifier
                        }
                    )
            )
            val titles = listOf(entry.title1, entry.title2, entry.title3, entry.title4)
            val artists = listOf(entry.artist1, entry.artist2, entry.artist3, entry.artist4)
            val fss = listOf(entry.fs1, entry.fs2, entry.fs3, entry.fs4)
            val totals = listOf(entry.total1, entry.total2, entry.total3, entry.total4)

            titles.forEachIndexed { index, title ->
                if (title.isNotEmpty()) {
                    Row {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.Star),
                            contentDescription = "Final Striker",
                            tint = if (fss[index] == "1") RANKING_YELLOW else Color.Transparent,
                            modifier = Modifier
                                .size(13.ndp())
                        )
                        Text(
                            text = "$title - ${artists[index]}",
                            fontSize = 11.nsp(),
                            lineHeight = 13.nsp(),
                            fontFamily = interTight,
                            textAlign = TextAlign.Start,
                            color = TEXT_GRAY,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(end = 10.ndp())
                                .width(textWidth - 81.ndp())
                                .then(
                                    if (!isImage) {
                                        Modifier.basicMarquee(spacing = MarqueeSpacing(15.ndp()))
                                    } else {
                                        Modifier
                                    }
                                )
                        )
                        Text(
                            text = totals[index],
                            fontSize = 11.nsp(),
                            lineHeight = 13.nsp(),
                            fontFamily = interTight,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End,
                            color = TEXT_GRAY,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(end = 8.ndp())
                                .width(50.ndp())
                        )
                    }
                }
            }
        }
        if (rowWidth >= 800.dp) {
            Text(
                text = entry.impr.toString(),
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                fontSize = 20.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(36.ndp())
            )
        }
        val medianValue = entry.median.toDoubleOrNull()
        val width = if (rowWidth < 800.dp) 88.ndp() else 102.ndp()
        if (medianValue != null) {
            Text(
                text = CommonUtils.truncateToTwoDecimalPlaces(medianValue),
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                fontSize = 24.nsp(),
                lineHeight = 114.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.ndp())
                    .width(width)
                    .background(calculateColor(medianValue))
                    .padding(end = 4.ndp())
            )
        } else {
            Text(
                text = entry.median,
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                fontSize = 13.nsp(),
                lineHeight = 114.nsp(),
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.ndp())
                    .width(width)
                    .background(Color.Black)
                    .padding(end = 4.ndp())
            )
        }
        if (isLandscape(configuration) && isImage) {
            Box(
                modifier = Modifier
                    .width(rightPadding)
                    .height(36.ndp())
            )
        }
    }
}