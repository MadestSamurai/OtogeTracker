package com.madsam.otora.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.data.bof.local.model.BofCommentTimeSeriesEntity
import com.madsam.otora.data.bof.local.model.BofRangeEntity
import com.madsam.otora.data.bof.local.model.BofRangeEntity_
import com.madsam.otora.data.bof.local.model.BofTeamEntity
import com.madsam.otora.data.bof.local.model.BofWorkEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.NumberFormat
import java.util.Locale

private data class BofHomeRankRow(
    val rank: Int,
    val title: String,
    val subtitle: String,
    val score: String
)

private data class BofHomeSection(
    val title: String,
    val subtitle: String,
    val emptyText: String,
    val tabIndex: Int,
    val rows: List<BofHomeRankRow> = emptyList()
)

private data class BofHomeSummary(
    val competitionName: String = "",
    val sections: List<BofHomeSection> = defaultBofHomeSections(),
    val isLoading: Boolean = true
)

@Composable
fun HomeScreen(
    snackbarHostState: SnackbarHostState,
    onShowBofScreen: (Int) -> Unit
) {
    HomeMainContent(
        onNavigateToBOF = onShowBofScreen
    )
}

@Composable
private fun HomeMainContent(
    onNavigateToBOF: (Int) -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val bofSummary by produceState(initialValue = BofHomeSummary()) {
        value = loadBofHomeSummary()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surface)
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "OtogeTracker",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = plexBold,
                color = colorScheme.primary
            )

            BofHomeBlock(
                summary = bofSummary,
                onNavigateToBOF = onNavigateToBOF
            )
        }
    }
}

@Composable
private fun BofHomeBlock(
    summary: BofHomeSummary,
    onNavigateToBOF: (Int) -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Surface(
                modifier = Modifier.size(52.dp),
                shape = RoundedCornerShape(8.dp),
                color = colorScheme.primaryContainer,
                contentColor = colorScheme.onPrimaryContainer
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Filled.EmojiEvents,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "BOF",
                    fontSize = 30.sp,
                    fontFamily = plexBold,
                    color = colorScheme.onSurface
                )
                Text(
                    text = "BMS OF FIGHTERS",
                    fontSize = 13.sp,
                    fontFamily = plexBold,
                    color = colorScheme.primary
                )
                Text(
                    text = "BMS 制谱比赛排名追踪",
                    fontSize = 14.sp,
                    color = colorScheme.onSurfaceVariant
                )
            }
        }

        summary.sections.forEach { section ->
            BofEntranceCard(
                section = section,
                competitionName = summary.competitionName,
                isLoading = summary.isLoading,
                onClick = { onNavigateToBOF(section.tabIndex) }
            )
        }
    }
}

@Composable
private fun BofEntranceCard(
    section: BofHomeSection,
    competitionName: String,
    isLoading: Boolean,
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = section.title,
                    fontSize = 20.sp,
                    fontFamily = plexBold,
                    color = colorScheme.onSurface
                )
                Text(
                    text = section.subtitle,
                    fontSize = 12.sp,
                    color = colorScheme.onSurfaceVariant
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    BofEntrancePreview(
                        rows = section.rows,
                        emptyText = section.emptyText,
                        competitionName = competitionName,
                        isLoading = isLoading
                    )
                }

                Surface(
                    modifier = Modifier
                        .width(58.dp)
                        .fillMaxHeight()
                        .clickable(onClick = onClick),
                    shape = RoundedCornerShape(8.dp),
                    color = colorScheme.primaryContainer,
                    contentColor = colorScheme.onPrimaryContainer
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 10.dp, horizontal = 6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "进入",
                            fontSize = 12.sp,
                            fontFamily = plexBold,
                            maxLines = 1
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun BofEntrancePreview(
    rows: List<BofHomeRankRow>,
    emptyText: String,
    competitionName: String,
    isLoading: Boolean
) {
    val colorScheme = MaterialTheme.colorScheme

    when {
        isLoading -> {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(18.dp),
                    strokeWidth = 2.dp
                )
                Text(
                    text = "读取 BOF 本地排行...",
                    fontSize = 13.sp,
                    color = colorScheme.onSurfaceVariant
                )
            }
        }

        rows.isEmpty() -> {
            Text(
                text = emptyText,
                fontSize = 13.sp,
                color = colorScheme.onSurfaceVariant
            )
        }

        else -> {
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(
                    text = "${competitionName.ifBlank { "BOF" }} 总分前三",
                    fontSize = 12.sp,
                    color = colorScheme.onSurfaceVariant
                )
                rows.forEach { row ->
                    BofRankPreviewRow(row = row)
                }
            }
        }
    }
}

@Composable
private fun BofRankPreviewRow(row: BofHomeRankRow) {
    val colorScheme = MaterialTheme.colorScheme

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "#${row.rank}",
            modifier = Modifier.width(30.dp),
            fontSize = 13.sp,
            fontFamily = plexBold,
            color = colorScheme.primary
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = row.title.ifBlank { "Untitled" },
                fontSize = 14.sp,
                fontFamily = plexBold,
                color = colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = row.subtitle.ifBlank { "No detail" },
                fontSize = 12.sp,
                color = colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Text(
            text = row.score,
            fontSize = 13.sp,
            fontFamily = plexBold,
            color = colorScheme.onSurface
        )
    }
}

private fun defaultBofHomeSections(): List<BofHomeSection> = listOf(
    BofHomeSection(
        title = "Entry",
        subtitle = "作品总分",
        emptyText = "尚未找到本地 BOF 作品数据",
        tabIndex = 0
    ),
    BofHomeSection(
        title = "Team",
        subtitle = "团队总分",
        emptyText = "尚未找到本地 BOF 团队数据",
        tabIndex = 1
    ),
    BofHomeSection(
        title = "Comment",
        subtitle = "评论总分",
        emptyText = "尚未找到本地 BOF 评论数据",
        tabIndex = 2
    )
)

private suspend fun loadBofHomeSummary(): BofHomeSummary = withContext(Dispatchers.IO) {
    runCatching {
        val boxStore = ObjectBoxManager.getBoxStore()
        val works = boxStore.boxFor(BofWorkEntity::class.java)
            .query()
            .build()
            .find()
            .filter { it.latestTotalScore > 0 && it.path.isNotBlank() }
        val teams = boxStore.boxFor(BofTeamEntity::class.java)
            .query()
            .build()
            .find()
            .filter { it.latestTotalScore > 0.0 && it.path.isNotBlank() }
        val comments = boxStore.boxFor(BofCommentTimeSeriesEntity::class.java)
            .query()
            .build()
            .find()
            .filter { it.latestTotal > 0 && it.path.isNotBlank() }

        val selectedPath = latestPath(
            works.map { it.path to it.lastUpdated },
            teams.map { it.path to it.lastUpdated },
            comments.map { it.path to it.lastUpdated }
        ) ?: return@runCatching BofHomeSummary(
            sections = defaultBofHomeSections().map { it.copy(rows = emptyList()) },
            isLoading = false
        )

        val range = boxStore.boxFor(BofRangeEntity::class.java)
            .query(BofRangeEntity_.path.equal(selectedPath))
            .build()
            .findFirst()
        val competitionName = range?.shortName
            ?.takeIf { it.isNotBlank() }
            ?: range?.fullName?.takeIf { it.isNotBlank() }
            ?: selectedPath.uppercase()

        val sections = listOf(
            BofHomeSection(
                title = "Entry",
                subtitle = "作品总分",
                emptyText = "尚未找到本地 BOF 作品数据",
                tabIndex = 0,
                rows = works
                    .filter { it.path == selectedPath }
                    .sortedByDescending { it.latestTotalScore }
                    .take(3)
                    .mapIndexed { index, work ->
                        BofHomeRankRow(
                            rank = index + 1,
                            title = work.currentTitle,
                            subtitle = work.currentArtist,
                            score = formatIntScore(work.latestTotalScore)
                        )
                    }
            ),
            BofHomeSection(
                title = "Team",
                subtitle = "团队总分",
                emptyText = "尚未找到本地 BOF 团队数据",
                tabIndex = 1,
                rows = teams
                    .filter { it.path == selectedPath }
                    .sortedByDescending { it.latestTotalScore }
                    .take(3)
                    .mapIndexed { index, team ->
                        BofHomeRankRow(
                            rank = index + 1,
                            title = team.teamName,
                            subtitle = team.currentTitle1.ifBlank { "Team ranking" },
                            score = formatDecimalScore(team.latestTotalScore)
                        )
                    }
            ),
            BofHomeSection(
                title = "Comment",
                subtitle = "评论总分",
                emptyText = "尚未找到本地 BOF 评论数据",
                tabIndex = 2,
                rows = comments
                    .filter { it.path == selectedPath }
                    .sortedByDescending { it.latestTotal }
                    .take(3)
                    .mapIndexed { index, comment ->
                        BofHomeRankRow(
                            rank = index + 1,
                            title = comment.currentUser.ifBlank { comment.username },
                            subtitle = comment.currentPattern,
                            score = formatIntScore(comment.latestTotal)
                        )
                    }
            )
        )

        BofHomeSummary(
            competitionName = competitionName,
            sections = sections,
            isLoading = false
        )
    }.getOrElse {
        BofHomeSummary(
            sections = defaultBofHomeSections().map { it.copy(rows = emptyList()) },
            isLoading = false
        )
    }
}

private fun latestPath(vararg pathUpdates: List<Pair<String, Long>>): String? {
    return pathUpdates
        .asSequence()
        .flatMap { it.asSequence() }
        .groupBy({ it.first }, { it.second })
        .maxByOrNull { (_, updates) -> updates.maxOrNull() ?: 0L }
        ?.key
}

private fun formatIntScore(score: Int): String =
    NumberFormat.getIntegerInstance(Locale.US).format(score)

private fun formatDecimalScore(score: Double): String {
    return if (score % 1.0 == 0.0) {
        formatIntScore(score.toInt())
    } else {
        String.format(Locale.US, "%.2f", score)
    }
}
