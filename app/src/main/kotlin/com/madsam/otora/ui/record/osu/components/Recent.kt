package com.madsam.otora.ui.record.osu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.OSU_ARROW_YELLOW
import com.madsam.otora.core.theme.OSU_HEART_RED
import com.madsam.otora.core.theme.OSU_ROTATE_GREEN
import com.madsam.otora.core.theme.Yellow1000
import com.madsam.otora.core.utils.DateTimeUtils.dateCodeToRecent
import com.madsam.otora.data.osu.ui.model.OsuBriefUiModel
import com.madsam.otora.data.osu.ui.model.OsuRecentUiModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun Recent(
    recentActivityList: MutableStateFlow<OsuBriefUiModel<OsuRecentUiModel>>,
    cardWidthDp: Dp,
    onMoreClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val activities by recentActivityList.collectAsState()
    if (activities.items.isEmpty()) return

    val screenWidthDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }

    Surface(
        modifier = Modifier
            .width(screenWidthDp)
            .padding(top = 12.dp),
        shape = RoundedCornerShape(20.dp),
        color = colorScheme.surfaceContainerHigh
    ) {
        Column(
            modifier = Modifier.padding(16.dp, 10.dp)
        ) {
            // Header row
            RecentHeader(
                isComplete = activities.isComplete,
                onMoreClick = onMoreClick
            )
            
            // Items list
            activities.items.forEachIndexed { index, item ->
                RecentItem(item, cardWidthDp)
                if (index < activities.items.size - 1) {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Composable
private fun RecentHeader(
    isComplete: Boolean,
    onMoreClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Recent",
            style = MaterialTheme.typography.titleLarge,
            color = colorScheme.onSurface,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        
        if (!isComplete) {
            TextButton(
                onClick = onMoreClick,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .defaultMinSize(1.dp, 1.dp)
                    .height(24.dp)
            ) {
                Text(
                    text = "More",
                    color = colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

@Composable
internal fun RecentItem(
    activity: OsuRecentUiModel,
    cardWidthDp: Dp
) {
    val colorScheme = MaterialTheme.colorScheme
    val textFormat =
        buildAnnotatedString {
            appendInlineContent("icon", "[${activity.type}]")
            when (activity.type) {
                "rank" -> {
                    withStyle(style = SpanStyle(color = colorScheme.onSurface)) {
                        append("achieved #${activity.rank} on ")
                    }
                    appendInlineContent("mode", "[${activity.mode}]")
                    withStyle(style = SpanStyle(color = Yellow1000, fontWeight = FontWeight.SemiBold)) {
                        append(activity.beatmapTitle)
                    }
                }

                "rankLost" -> {
                    withStyle(style = SpanStyle(color = colorScheme.onSurface)) {
                        append("lost first place on ")
                    }
                    appendInlineContent("mode", "[${activity.mode}]")
                    withStyle(style = SpanStyle(color = Yellow1000, fontWeight = FontWeight.SemiBold)) {
                        append(activity.beatmapTitle)
                    }
                }

                "beatmapsetUpload" -> {
                    withStyle(style = SpanStyle(color = colorScheme.onSurface)) {
                        append("submitted a new beatmap ")
                    }
                    withStyle(style = SpanStyle(color = Yellow1000, fontWeight = FontWeight.SemiBold)) {
                        append(activity.beatmapSetTitle)
                    }
                }

                "beatmapsetUpdate" -> {
                    withStyle(style = SpanStyle(color = colorScheme.onSurface)) {
                        append("updated a beatmap ")
                    }
                    withStyle(style = SpanStyle(color = Yellow1000, fontWeight = FontWeight.SemiBold)) {
                        append(activity.beatmapSetTitle)
                    }
                }

                "userSupportGift" -> {
                    withStyle(style = SpanStyle(color = colorScheme.onSurface)) {
                        append("received the gift of osu!supporter")
                    }
                }

                "userSupportAgain" -> {
                    withStyle(style = SpanStyle(color = colorScheme.onSurface)) {
                        append("support osu! again")
                    }
                }

                "beatmapsetRevive" -> {
                    withStyle(style = SpanStyle(color = colorScheme.onSurface)) {
                        append("revived a beatmap ")
                    }
                    withStyle(style = SpanStyle(color = Yellow1000, fontWeight = FontWeight.SemiBold)) {
                        append(activity.beatmapSetTitle)
                    }
                }

                "beatmapsetApprove" -> {
                    withStyle(style = SpanStyle(color = Yellow1000, fontWeight = FontWeight.SemiBold)) {
                        append(activity.beatmapSetTitle)
                    }
                    withStyle(style = SpanStyle(color = colorScheme.onSurface)) {
                        append(" has been ${activity.approval}")
                    }
                }

                "achievement" -> {
                    withStyle(style = SpanStyle(color = colorScheme.onSurface)) {
                        append("achieved ")
                    }
                    withStyle(style = SpanStyle(color = Yellow1000, fontWeight = FontWeight.SemiBold)) {
                        append(activity.achievement)
                    }
                }

                else -> {
                    withStyle(style = SpanStyle(color = colorScheme.onSurface)) {
                        append("achieved #${activity.rank} on ${activity.beatmapTitle}")
                    }
                }
            }
        }
    Column(
        modifier = Modifier
            .width(cardWidthDp)
            .clip(RoundedCornerShape(6.dp))
            .background(colorScheme.surfaceContainer)
            .padding(vertical = 2.dp)
    ) {
        val textWidth = cardWidthDp - 8.dp
        val inlineContent = mapOf(
            "mode" to InlineTextContent(
                Placeholder(
                    width = 16.sp,
                    height = 14.sp,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.TextBottom
                )
            ) {
                Icon(
                    painter = rememberVectorPainter(
                        image = when (activity.mode) {
                            "mania" -> Filled.OsumodeMania
                            "osu" -> Filled.OsumodeStd
                            "taiko" -> Filled.OsumodeTaiko
                            "fruits" -> Filled.OsumodeCtb
                            else -> Filled.OsumodeStd
                        }
                    ),
                    contentDescription = "Osu Mode",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 2.dp)
                )
            },
            "icon" to InlineTextContent(
                Placeholder(
                    width = when (activity.type) {
                        "rank" -> 28.sp
                        "achievement" -> 24.sp
                        else -> 18.sp
                    },
                    height = when (activity.type) {
                        "achievement" -> 20.sp
                        else -> 14.sp
                    },
                    placeholderVerticalAlign = when (activity.type) {
                        "achievement" -> PlaceholderVerticalAlign.TextTop
                        else -> PlaceholderVerticalAlign.TextBottom
                    }
                )
            ) {
                when (activity.type) {
                    "rank" -> {
                        Image(
                            painter = rememberVectorPainter(
                                image = when (activity.scoreRank) {
                                    "XH" -> Filled.OsuSsh
                                    "X" -> Filled.OsuSs
                                    "SH" -> Filled.OsuSh
                                    "S" -> Filled.OsuS
                                    "A" -> Filled.OsuA
                                    "B" -> Filled.OsuB
                                    "C" -> Filled.OsuC
                                    "D" -> Filled.OsuD
                                    else -> Filled.OsuF
                                }
                            ),
                            contentDescription = "Rank",
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "rankLost" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.DoubleDown),
                            contentDescription = "Osu Mode",
                            tint = Color.White,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "beatmapsetUpload", "beatmapsetUpdate" -> {
                        Icon(
                            painter = rememberVectorPainter(
                                image = when (activity.type) {
                                    "beatmapsetUpload" -> Filled.ArrowUp
                                    "beatmapsetUpdate" -> Filled.ArrowRotate
                                    else -> Filled.ArrowUp
                                }
                            ),
                            contentDescription = "Beatmap Upload",
                            tint = when (activity.type) {
                                "beatmapsetUpload" -> OSU_ARROW_YELLOW
                                "beatmapsetUpdate" -> OSU_ROTATE_GREEN
                                else -> Color.White
                            },
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "userSupportGift" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.Gift),
                            contentDescription = "Osu Mode",
                            tint = OSU_HEART_RED,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "userSupportAgain" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.Heart1),
                            contentDescription = "Osu Mode",
                            tint = OSU_HEART_RED,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "beatmapsetApprove" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.Tick),
                            contentDescription = "Osu Mode",
                            tint = when (activity.approval) {
                                "qualified" -> OSU_ARROW_YELLOW
                                "approved" -> OSU_ROTATE_GREEN
                                "loved" -> OSU_HEART_RED
                                else -> Color.White
                            },
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "beatmapsetRevive" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.TrashArrowUp),
                            contentDescription = "Osu Mode",
                            tint = Color.White,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "achievement" -> {
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = activity.achievementIcon,
                                contentScale = ContentScale.Fit
                            ),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Achievement Icon",
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }
                }
            }
        )
        Text(
            text = textFormat,
            inlineContent = inlineContent,
            style = MaterialTheme.typography.bodyMedium,
            lineHeight = 16.sp,
            color = Color.White,
            modifier = Modifier
                .width(textWidth)
                .padding(start = 8.dp, top = 4.dp, end = 8.dp)
        )
        Text(
            text = dateCodeToRecent(activity.createdAt),
            fontSize = 12.sp,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Light,
            color = Color.Gray,
            modifier = Modifier
                .padding(end = 8.dp, bottom = 4.dp)
                .align(End)
        )
    }
}