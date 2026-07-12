package com.madsam.otora.ui.record.osu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
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
import com.madsam.otora.R
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.data.osu.ui.model.OsuBriefUiModel
import com.madsam.otora.data.osu.ui.model.OsuRecentUiModel
import kotlinx.coroutines.flow.MutableStateFlow

internal val RecentItemSpacing = 2.dp

@Composable
internal fun Recent(
    recentActivityList: MutableStateFlow<OsuBriefUiModel<OsuRecentUiModel>>,
    cardWidthDp: Dp,
    onMoreClick: () -> Unit
) {
    val activities by recentActivityList.collectAsState()
    if (activities.items.isEmpty()) return

    Column(
        modifier = Modifier
            .width(cardWidthDp)
    ) {
        // Header row
        RecentHeader(
            isComplete = activities.isComplete,
            onMoreClick = onMoreClick
        )
        
        // Items list container
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
        ) {
            activities.items.forEachIndexed { index, item ->
                RecentItem(item, cardWidthDp)
                if (index < activities.items.size - 1) {
                    Spacer(modifier = Modifier.height(RecentItemSpacing))
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
            .padding(start = 4.dp, top = 12.dp, end = 4.dp, bottom = 4.dp)
            .heightIn(min = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.osu_section_recent),
            style = MaterialTheme.typography.titleMedium,
            color = colorScheme.onSurface,
            modifier = Modifier.padding(start = 4.dp)
        )
        
        if (!isComplete) {
            TextButton(
                onClick = onMoreClick,
                contentPadding = PaddingValues(horizontal = 12.dp),
                modifier = Modifier.height(32.dp)
            ) {
                Text(
                    text = stringResource(R.string.osu_action_more),
                    color = colorScheme.primary,
                    style = MaterialTheme.typography.labelLarge,
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
    val highlightColor = colorScheme.secondary
    val activityTemplate = when (activity.type) {
        "rank" -> stringResource(
            R.string.osu_activity_rank,
            activity.rank,
            ActivityModeMarker,
            ActivityTitleMarker
        )
        "rankLost" -> stringResource(
            R.string.osu_activity_rank_lost,
            ActivityModeMarker,
            ActivityTitleMarker
        )
        "beatmapsetUpload" -> stringResource(
            R.string.osu_activity_beatmap_upload,
            ActivityTitleMarker
        )
        "beatmapsetUpdate" -> stringResource(
            R.string.osu_activity_beatmap_update,
            ActivityTitleMarker
        )
        "userSupportGift" -> stringResource(R.string.osu_activity_support_gift)
        "userSupportAgain" -> stringResource(R.string.osu_activity_support_again)
        "beatmapsetRevive" -> stringResource(
            R.string.osu_activity_beatmap_revive,
            ActivityTitleMarker
        )
        "beatmapsetApprove" -> stringResource(
            R.string.osu_activity_beatmap_approve,
            ActivityTitleMarker,
            localizedBeatmapStatus(activity.approval)
        )
        "achievement" -> stringResource(
            R.string.osu_activity_achievement,
            ActivityTitleMarker
        )
        else -> stringResource(
            R.string.osu_activity_fallback,
            activity.rank,
            ActivityTitleMarker
        )
    }
    val highlightedValue = when (activity.type) {
        "rank", "rankLost" -> activity.beatmapTitle
        "beatmapsetUpload", "beatmapsetUpdate", "beatmapsetRevive", "beatmapsetApprove" ->
            activity.beatmapSetTitle
        "achievement" -> activity.achievement
        else -> activity.beatmapTitle
    }
    val textFormat = buildAnnotatedString {
        appendInlineContent("icon", "[${activity.type}]")
        appendLocalizedActivityTemplate(
            template = activityTemplate,
            normalStyle = SpanStyle(color = colorScheme.onSurface),
            replacements = buildMap {
                if (ActivityModeMarker in activityTemplate) {
                    put(ActivityModeMarker) {
                        appendInlineContent("mode", "[${activity.mode}]")
                    }
                }
                if (ActivityTitleMarker in activityTemplate) {
                    put(ActivityTitleMarker) {
                        withStyle(
                            SpanStyle(
                                color = highlightColor,
                                fontWeight = FontWeight.SemiBold
                            )
                        ) {
                            append(highlightedValue)
                        }
                    }
                }
            }
        )
    }
    Column(
        modifier = Modifier
            .width(cardWidthDp)
            .background(colorScheme.surfaceContainer)
            .padding(vertical = 8.dp, horizontal = 4.dp)
    ) {
        val textWidth = cardWidthDp - 16.dp
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
                    contentDescription = stringResource(R.string.osu_cd_game_mode),
                    tint = colorScheme.onSurfaceVariant,
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
                            contentDescription = stringResource(R.string.osu_cd_rank),
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "rankLost" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.DoubleDown),
                            contentDescription = stringResource(R.string.osu_cd_beatmap_activity),
                            tint = colorScheme.error,
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
                            contentDescription = stringResource(R.string.osu_cd_beatmap_activity),
                            tint = when (activity.type) {
                                "beatmapsetUpload" -> colorScheme.tertiary
                                "beatmapsetUpdate" -> colorScheme.primary
                                else -> colorScheme.onSurfaceVariant
                            },
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "userSupportGift" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.Gift),
                            contentDescription = stringResource(R.string.osu_cd_supporter_activity),
                            tint = colorScheme.error,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "userSupportAgain" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.Heart1),
                            contentDescription = stringResource(R.string.osu_cd_supporter_activity),
                            tint = colorScheme.error,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "beatmapsetApprove" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.Tick),
                            contentDescription = stringResource(R.string.osu_cd_beatmap_activity),
                            tint = when (activity.approval) {
                                "qualified" -> colorScheme.tertiary
                                "approved" -> colorScheme.primary
                                "loved" -> colorScheme.error
                                else -> colorScheme.onSurfaceVariant
                            },
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "beatmapsetRevive" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.TrashArrowUp),
                            contentDescription = stringResource(R.string.osu_cd_beatmap_activity),
                            tint = colorScheme.onSurfaceVariant,
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
                            contentDescription = stringResource(R.string.osu_cd_achievement),
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
            color = colorScheme.onSurface,
            modifier = Modifier
                .width(textWidth)
                .padding(start = 8.dp, top = 4.dp, end = 8.dp)
        )
        Text(
            text = localizedRelativeTime(activity.createdAt),
            fontSize = 12.sp,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Light,
            color = colorScheme.onSurfaceVariant,
            modifier = Modifier
                .padding(end = 8.dp, bottom = 4.dp)
                .align(End)
        )
    }
}

private const val ActivityModeMarker = "{mode}"
private const val ActivityTitleMarker = "{title}"

private fun AnnotatedString.Builder.appendLocalizedActivityTemplate(
    template: String,
    normalStyle: SpanStyle,
    replacements: Map<String, AnnotatedString.Builder.() -> Unit>
) {
    var startIndex = 0
    while (startIndex < template.length) {
        val nextMarker = replacements.keys
            .mapNotNull { marker ->
                template.indexOf(marker, startIndex)
                    .takeIf { it >= 0 }
                    ?.let { marker to it }
            }
            .minByOrNull { (_, index) -> index }

        if (nextMarker == null) {
            withStyle(normalStyle) { append(template.substring(startIndex)) }
            break
        }

        val (marker, markerIndex) = nextMarker
        if (markerIndex > startIndex) {
            withStyle(normalStyle) {
                append(template.substring(startIndex, markerIndex))
            }
        }
        replacements.getValue(marker).invoke(this)
        startIndex = markerIndex + marker.length
    }
}
