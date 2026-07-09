package com.madsam.otora.ui.bof.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.R
import com.madsam.otora.ui.bof.BofRankingColors
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.theme.plexRegular
import com.madsam.otora.core.utils.ImageUtils
import com.madsam.otora.ui.bof.TeamRankingItem
import dev.shreyaspatil.capturable.capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BofTeamDiffCaptureDialog(
    showDialog: MutableState<Boolean>,
    context: Context,
    snackbarHostState: SnackbarHostState,
    teams: List<TeamRankingItem>,
    title: String,
    subtitle: String
) {
    val scope = rememberCoroutineScope()
    val captureTitle = stringResource(R.string.bof_capture_title)
    val captureMessage = stringResource(R.string.bof_capture_team_diff_message)
    val captureAction = stringResource(R.string.bof_capture_action)
    val cancelAction = stringResource(R.string.bof_action_cancel)

    if (showDialog.value) {
        // 过滤掉总分小于等于0的数据
        val filteredTeams = teams.filter { it.totalScore > 0 }

        // 分批，每50个团队一组
        val batchSize = 50
        val batches = filteredTeams.chunked(batchSize)
        val controllers = List(batches.size) { rememberCaptureController() }

        // 计算全局最大分数
        val globalMaxScore = filteredTeams.maxOfOrNull { it.totalScore } ?: 1.0

        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = captureTitle) },
            text = {
                Column {
                    Text(
                        text = captureMessage,
                        modifier = Modifier.padding(8.dp)
                    )

                    // 渲染所有批次
                    batches.forEachIndexed { index, batch ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .height(0.dp)
                                .requiredWidth(900.dp)
                                .requiredHeight(5000.dp)
                        ) {
                            Column(
                                modifier = Modifier.capturable(controllers[index])
                            ) {
                                BofTeamDiffCaptureContent(
                                    teams = batch,
                                    title = title,
                                    subtitle = subtitle,
                                    showTitle = index == 0,
                                    showHeader = index == 0,
                                    globalMaxScore = globalMaxScore
                                )
                            }
                        }
                    }

                    if (batches.size > 1) {
                        Text(
                            text = stringResource(R.string.bof_capture_batches_format, batches.size),
                            fontSize = 13.sp,
                            color = BofRankingColors.Neutral,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        scope.launch {
                            val bitmaps = mutableListOf<android.graphics.Bitmap>()
                            for ((i, _) in batches.withIndex()) {
                                val bmp = controllers[i].captureAsync().await().asAndroidBitmap()
                                val softwareBitmap =
                                    if (bmp.config == android.graphics.Bitmap.Config.HARDWARE) {
                                        bmp.copy(android.graphics.Bitmap.Config.ARGB_8888, false)
                                    } else {
                                        bmp
                                    }
                                bitmaps.add(softwareBitmap)
                                if (softwareBitmap != bmp) {
                                    bmp.recycle()
                                }
                            }
                            val finalBitmap = ImageUtils.combineBitmaps(bitmaps, maxHeight = 30000)
                            val current = LocalDateTime.now()
                            val formatter = DateTimeFormatter.ofPattern("MMddHHmm")
                            val timeStr = current.format(formatter)
                            ImageUtils.saveBitmapToGallery(
                                context = context,
                                bitmap = finalBitmap,
                                title = "BOF_Team_Diff_$timeStr",
                                description = "BOF Team Diff Ranking Capture"
                            )
                            snackbarHostState.showSnackbar(
                                context.getString(R.string.bof_capture_saved_format, batches.size)
                            )
                        }
                        showDialog.value = false
                    }
                ) {
                    Text(text = captureAction)
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showDialog.value = false
                    }
                ) {
                    Text(text = cancelAction)
                }
            }
        )
    }
}

@Composable
internal fun BofTeamDiffCaptureContent(
    teams: List<TeamRankingItem>,
    title: String,
    subtitle: String,
    showTitle: Boolean = true,
    showHeader: Boolean = true,
    globalMaxScore: Double? = null
) {
    val maxScore = globalMaxScore ?: (teams.maxOfOrNull { it.totalScore } ?: 1.0)
    val rankColumn = stringResource(R.string.bof_column_rank)
    val teamColumn = stringResource(R.string.bof_column_team)
    val increaseColumn = stringResource(R.string.bof_column_increase)
    val decreaseColumn = stringResource(R.string.bof_column_decrease)
    val diffDecreaseTitle = stringResource(R.string.bof_team_diff_decrease_title)
    val changeColumn = if (title == diffDecreaseTitle) decreaseColumn else increaseColumn

    Box(
        modifier = Modifier
            .width(900.dp)
            .background(BofRankingColors.Background)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            if (showTitle) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BofRankingColors.Background)
                        .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        fontFamily = plexBold,
                        fontSize = 20.sp,
                        color = BofRankingColors.Text,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = subtitle,
                        fontFamily = plexRegular,
                        fontSize = 12.sp,
                        color = BofRankingColors.TextSecondary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            if (showHeader) {
                // Diff表头 - 只有三列：排名、团队、增长/减少
                Row(
                    modifier = Modifier
                        .background(BofRankingColors.Header)
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = rankColumn,
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.Text,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(50.dp)
                    )
                    
                    Text(
                        text = teamColumn,
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.Text,
                        textAlign = TextAlign.End,
                        modifier = Modifier.weight(0.6f)
                    )
                    
                    Text(
                        text = changeColumn,
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.Text,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(0.4f)
                    )
                }
            }

            // Diff数据行
            Column {
                teams.forEachIndexed { index, team ->
                    TeamDiffCaptureRow(
                        team = team,
                        index = index,
                        maxScore = maxScore
                    )
                }
            }
        }
    }
}

@Composable
private fun TeamDiffCaptureRow(
    team: TeamRankingItem,
    index: Int,
    maxScore: Double
) {
    val backgroundColor = if (index % 2 == 0) BofRankingColors.RowAlt else BofRankingColors.Background
    val scoreRatio = if (maxScore > 0) team.totalScore / maxScore else 0.0

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ) {
        // 团队主要信息行
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 排名列 - 只显示排名，不显示变化
            Text(
                text = team.rank.toString(),
                fontFamily = plexBold,
                fontSize = 16.sp,
                color = BofRankingColors.Text,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(50.dp)
            )

            // 团队名称
            Text(
                text = team.teamName,
                fontFamily = plexBold,
                fontSize = 16.sp,
                color = BofRankingColors.Text,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .weight(0.6f)
                    .padding(end = 4.dp)
            )

            // 差值分数条 - 使用嵌套Box设计
            Box(
                modifier = Modifier
                    .weight(0.4f)
                    .padding(start = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .padding(horizontal = 2.dp)
                ) {
                    Box {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth(scoreRatio.toFloat().coerceAtMost(1f))
                                .height(20.dp)
                                .background(
                                    color = BofRankingColors.Negative,
                                    shape = RoundedCornerShape(
                                        topEnd = 10.dp,
                                        bottomEnd = 10.dp
                                    )
                                )
                        )
                        Text(
                            text = String.format("%.2f", team.totalScore),
                            fontFamily = plexBold,
                            fontSize = 14.sp,
                            color = BofRankingColors.Text,
                            overflow = TextOverflow.Visible,
                            maxLines = 1,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 4.dp)
                        )
                    }
                }
            }
        }

        // 团队作品列表 - 单行设计
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 54.dp, end = 4.dp, top = 2.dp)
        ) {
            listOf(
                Triple(team.title1, team.artist1, team.score1 - (team.compareScore1 ?: team.score1)),
                Triple(team.title2, team.artist2, team.score2 - (team.compareScore2 ?: team.score2)),
                Triple(team.title3, team.artist3, team.score3 - (team.compareScore3 ?: team.score3)),
                Triple(team.title4, team.artist4, team.score4 - (team.compareScore4 ?: team.score4))
            ).filter { it.first.isNotEmpty() }.forEach { (title, artist, scoreDiff) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp, vertical = 1.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$title - $artist",
                        fontFamily = plexRegular,
                        fontSize = 12.sp,
                        color = BofRankingColors.TextSecondary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                    
                    if (scoreDiff != 0.0) {
                        Text(
                            text = if (scoreDiff > 0) "+${String.format("%.1f", scoreDiff)}" else String.format("%.1f", scoreDiff),
                            fontFamily = plexBold,
                            fontSize = 12.sp,
                            color = if (scoreDiff > 0) BofRankingColors.Positive else BofRankingColors.Negative,
                            textAlign = TextAlign.End,
                            modifier = Modifier.width(70.dp)
                        )
                    } else {
                        Spacer(modifier = Modifier.width(70.dp))
                    }
                }
            }
        }
    }
}
