package com.madsam.otora.ui.record

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.R
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.utils.ScreenUtil

/**
 * 游戏数据模型
 */
data class GameInfo(
    val id: String,
    val name: String,
    @param:StringRes val descriptionResId: Int,
    val icon: ImageVector,
    val primaryColor: Color,
    val route: String,
    val isEnabled: Boolean = true
)

/**
 * 可用游戏列表
 */
object GameRegistry {
    val games = listOf(
        GameInfo(
            id = "osu",
            name = "osu!",
            descriptionResId = R.string.record_game_osu_desc,
            icon = Filled.OsuIcon,
            primaryColor = Color(0xFFFF66AB),
            route = "game/osu",
            isEnabled = true
        ),
        GameInfo(
            id = "maimai",
            name = "maimai",
            descriptionResId = R.string.record_game_maimai_desc,
            icon = Filled.MaimaiIcon,
            primaryColor = Color(0xFF4FC3F7),
            route = "game/maimai",
            isEnabled = true
        ),
        GameInfo(
            id = "chunithm",
            name = "CHUNITHM",
            descriptionResId = R.string.record_game_chunithm_desc,
            icon = Filled.ChunithmIcon,
            primaryColor = Color(0xFFFFD54F),
            route = "game/chunithm",
            isEnabled = true
        )
    )
}

/**
 * 游戏列表页面 - 显示所有可用游戏的卡片列表
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameListScreen(
    onNavigateToGame: (String) -> Unit,
    onNavigateToSettings: () -> Unit
) {
    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()
    val colorScheme = MaterialTheme.colorScheme
    
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.record_title),
                        fontFamily = plexBold,
                        fontSize = 20.sp
                    )
                },
                actions = {
                    IconButton(onClick = onNavigateToSettings) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = stringResource(R.string.settings_title),
                            tint = colorScheme.onSurface,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorScheme.surfaceContainer,
                    titleContentColor = colorScheme.onSurface,
                    actionIconContentColor = colorScheme.onSurface
                )
            )
        },
        containerColor = colorScheme.surface
    ) { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .windowInsetsPadding(
                    WindowInsets.displayCutout.only(
                        if (useNavigationRail) {
                            WindowInsetsSides.End
                        } else {
                            WindowInsetsSides.Horizontal
                        }
                    )
                )
                .windowInsetsPadding(
                    if (useNavigationRail) {
                        WindowInsets.navigationBars.only(WindowInsetsSides.Bottom)
                    } else {
                        WindowInsets(0, 0, 0, 0)
                    }
                )
        ) {
            items(GameRegistry.games) { game ->
                GameCard(
                    game = game,
                    onClick = { 
                        if (game.isEnabled) {
                            onNavigateToGame(game.route)
                        }
                    }
                )
            }
        }
    }
}

/**
 * 游戏卡片组件
 */
@Composable
private fun GameCard(
    game: GameInfo,
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 104.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(enabled = game.isEnabled, onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = if (game.isEnabled) colorScheme.surfaceContainerHigh else colorScheme.surfaceContainerHighest.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 104.dp)
                .padding(horizontal = 16.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(game.primaryColor.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = game.icon,
                    contentDescription = game.name,
                    tint = if (game.isEnabled) game.primaryColor else colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(34.dp)
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = game.name,
                    fontFamily = plexBold,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (game.isEnabled) colorScheme.onSurface else colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = stringResource(game.descriptionResId),
                    fontSize = 13.sp,
                    lineHeight = 17.sp,
                    color = if (game.isEnabled) colorScheme.onSurfaceVariant else colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = if (game.isEnabled) {
                        stringResource(R.string.record_game_open)
                    } else {
                        stringResource(R.string.record_game_coming_soon)
                    },
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (game.isEnabled) game.primaryColor else colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                )
            }

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = if (game.isEnabled) colorScheme.onSurfaceVariant else colorScheme.onSurfaceVariant.copy(alpha = 0.38f),
                modifier = Modifier.size(22.dp)
            )
        }
    }
}
