package com.madsam.otora.ui.home

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.R
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.data.bof.local.model.BofCommentTimeSeriesEntity
import com.madsam.otora.data.bof.local.model.BofTeamEntity
import com.madsam.otora.data.bof.local.model.BofWorkEntity
import com.madsam.otora.ui.record.GameEntranceGroup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.NumberFormat
import java.util.Locale

private data class BofHomeRankRow(
    val rank: Int,
    val title: String,
    val score: String
)

private data class BofHomeSection(
    @param:StringRes val titleResId: Int,
    @param:StringRes val emptyTextResId: Int,
    val tabIndex: Int,
    val rows: List<BofHomeRankRow> = emptyList()
)

private data class BofHomeSummary(
    val sections: List<BofHomeSection> = defaultBofHomeSections(),
    val isLoading: Boolean = true
)

@Composable
fun HomeScreen(
    snackbarHostState: SnackbarHostState,
    onShowBofScreen: (Int) -> Unit,
    onNavigateToGame: (String) -> Unit,
    onNavigateToSettings: () -> Unit
) {
    HomeMainContent(
        onNavigateToBOF = onShowBofScreen,
        onNavigateToGame = onNavigateToGame,
        onNavigateToSettings = onNavigateToSettings
    )
}

@Composable
private fun HomeMainContent(
    onNavigateToBOF: (Int) -> Unit,
    onNavigateToGame: (String) -> Unit,
    onNavigateToSettings: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val bofSummary by produceState(initialValue = BofHomeSummary()) {
        value = loadBofHomeSummary()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surface)
            .windowInsetsPadding(WindowInsets.statusBars),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    modifier = Modifier.weight(1f),
                    fontSize = 32.sp,
                    lineHeight = 42.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = plexBold,
                    color = colorScheme.primary
                )
                IconButton(onClick = onNavigateToSettings) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = stringResource(R.string.settings_title),
                        tint = colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            HomeSectionTitle(text = stringResource(R.string.record_title))

            GameEntranceGroup(onNavigateToGame = onNavigateToGame)

            Spacer(modifier = Modifier.height(24.dp))

            BofHomeBlock(
                summary = bofSummary,
                onNavigateToBOF = onNavigateToBOF
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun HomeSectionTitle(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(bottom = 12.dp),
        fontSize = 20.sp,
        lineHeight = 26.sp,
        fontFamily = plexBold,
        color = MaterialTheme.colorScheme.onSurface
    )
}

@Composable
private fun BofHomeBlock(
    summary: BofHomeSummary,
    onNavigateToBOF: (Int) -> Unit
) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        HomeSectionTitle(text = "BOF")

        BofHomeGroupCard(
            summary = summary,
            isExpanded = isExpanded,
            onHeaderClick = { isExpanded = !isExpanded },
            onNavigateToBOF = onNavigateToBOF
        )
    }
}

@Composable
private fun BofHomeGroupCard(
    summary: BofHomeSummary,
    isExpanded: Boolean,
    onHeaderClick: () -> Unit,
    onNavigateToBOF: (Int) -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val indicatorRotation by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        label = "BOF section indicator rotation"
    )

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 92.dp)
                    .clickable(onClick = onHeaderClick)
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Surface(
                    modifier = Modifier.size(48.dp),
                    shape = RoundedCornerShape(8.dp),
                    color = colorScheme.primaryContainer,
                    contentColor = colorScheme.onPrimaryContainer
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Filled.EmojiEvents,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Text(
                        text = "BMS OF FIGHTERS",
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        fontFamily = plexBold,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onSurface
                    )
                    Text(
                        text = stringResource(R.string.bof_home_tagline),
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        color = colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    tint = colorScheme.primary,
                    modifier = Modifier
                        .size(20.dp)
                        .graphicsLayer { rotationZ = indicatorRotation }
                )
            }

            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorScheme.surface)
                ) {
                    Spacer(modifier = Modifier.height(2.dp))
                    summary.sections.forEachIndexed { index, section ->
                        BofEntranceRow(
                            section = section,
                            isLoading = summary.isLoading,
                            onClick = { onNavigateToBOF(section.tabIndex) }
                        )
                        if (index < summary.sections.lastIndex) {
                            Spacer(modifier = Modifier.height(2.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun BofEntranceRow(
    section: BofHomeSection,
    isLoading: Boolean,
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme.surfaceContainer)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(section.titleResId),
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontFamily = plexBold,
                color = colorScheme.onSurface
            )

            BofEntrancePreview(
                rows = section.rows,
                emptyText = stringResource(section.emptyTextResId),
                isLoading = isLoading
            )
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = null,
            tint = colorScheme.primary,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
private fun BofEntrancePreview(
    rows: List<BofHomeRankRow>,
    emptyText: String,
    isLoading: Boolean
) {
    val colorScheme = MaterialTheme.colorScheme

    when {
        isLoading -> {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 2.dp
                )
                Text(
                    text = stringResource(R.string.bof_home_loading),
                    fontSize = 12.sp,
                    lineHeight = 15.sp,
                    color = colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        rows.isEmpty() -> {
            Text(
                text = emptyText,
                fontSize = 12.sp,
                lineHeight = 15.sp,
                color = colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        else -> {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                rows.forEach { row ->
                    BofCompactRankPreviewRow(row = row)
                }
            }
        }
    }
}

@Composable
private fun BofCompactRankPreviewRow(row: BofHomeRankRow) {
    val colorScheme = MaterialTheme.colorScheme
    val untitledText = stringResource(R.string.bof_home_untitled)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "#${row.rank}",
            modifier = Modifier.width(24.dp),
            fontSize = 12.sp,
            lineHeight = 15.sp,
            fontFamily = plexBold,
            color = colorScheme.primary
        )
        Text(
            text = row.title.ifBlank { untitledText },
            modifier = Modifier.weight(1f),
            fontSize = 12.sp,
            lineHeight = 15.sp,
            color = colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = row.score,
            fontSize = 12.sp,
            lineHeight = 15.sp,
            fontFamily = plexBold,
            color = colorScheme.onSurface
        )
    }
}

private fun defaultBofHomeSections(): List<BofHomeSection> = listOf(
    BofHomeSection(
        titleResId = R.string.bof_home_title_entry,
        emptyTextResId = R.string.bof_home_entry_empty,
        tabIndex = 0
    ),
    BofHomeSection(
        titleResId = R.string.bof_home_title_team,
        emptyTextResId = R.string.bof_home_team_empty,
        tabIndex = 1
    ),
    BofHomeSection(
        titleResId = R.string.bof_home_title_comment,
        emptyTextResId = R.string.bof_home_comment_empty,
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

        val sections = listOf(
            BofHomeSection(
                titleResId = R.string.bof_home_title_entry,
                emptyTextResId = R.string.bof_home_entry_empty,
                tabIndex = 0,
                rows = works
                    .filter { it.path == selectedPath }
                    .sortedByDescending { it.latestTotalScore }
                    .take(3)
                    .mapIndexed { index, work ->
                        BofHomeRankRow(
                            rank = index + 1,
                            title = work.currentTitle,
                            score = formatIntScore(work.latestTotalScore)
                        )
                    }
            ),
            BofHomeSection(
                titleResId = R.string.bof_home_title_team,
                emptyTextResId = R.string.bof_home_team_empty,
                tabIndex = 1,
                rows = teams
                    .filter { it.path == selectedPath }
                    .sortedByDescending { it.latestTotalScore }
                    .take(3)
                    .mapIndexed { index, team ->
                        BofHomeRankRow(
                            rank = index + 1,
                            title = team.teamName,
                            score = formatDecimalScore(team.latestTotalScore)
                        )
                    }
            ),
            BofHomeSection(
                titleResId = R.string.bof_home_title_comment,
                emptyTextResId = R.string.bof_home_comment_empty,
                tabIndex = 2,
                rows = comments
                    .filter { it.path == selectedPath }
                    .sortedByDescending { it.latestTotal }
                    .take(3)
                    .mapIndexed { index, comment ->
                        BofHomeRankRow(
                            rank = index + 1,
                            title = comment.currentUser.ifBlank { comment.username },
                            score = formatIntScore(comment.latestTotal)
                        )
                    }
            )
        )

        BofHomeSummary(
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
