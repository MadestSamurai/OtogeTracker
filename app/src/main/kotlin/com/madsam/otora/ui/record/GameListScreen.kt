package com.madsam.otora.ui.record

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.R
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.icon.fa.Cog
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.utils.ScreenUtil

/**
 * 游戏数据模型
 */
data class GameInfo(
    val id: String,
    val name: String,
    val icon: ImageVector,
    val primaryColor: Color,
    val secondaryColor: Color,
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
            icon = Filled.OsuIcon,
            primaryColor = Color(0xFFFF66AB),
            secondaryColor = Color(0xFFCC5289),
            route = "game/osu",
            isEnabled = true
        ),
        GameInfo(
            id = "maimai",
            name = "maimai",
            icon = Filled.MaimaiIcon,
            primaryColor = Color(0xFF4FC3F7),
            secondaryColor = Color(0xFF0288D1),
            route = "game/maimai",
            isEnabled = true
        ),
        GameInfo(
            id = "chunithm",
            name = "CHUNITHM",
            icon = Filled.ChunithmIcon,
            primaryColor = Color(0xFFFFD54F),
            secondaryColor = Color(0xFFFFA000),
            route = "game/chunithm",
            isEnabled = true
        )
    )
}

/**
 * 游戏列表页面 - 显示所有可用游戏的卡片网格
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
                            imageVector = Fa.Cog,
                            contentDescription = "Settings",
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
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 160.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
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
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(enabled = game.isEnabled, onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = if (game.isEnabled) colorScheme.surfaceContainerHigh else colorScheme.surfaceContainerHighest.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // 游戏图标
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(game.primaryColor.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = game.icon,
                    contentDescription = game.name,
                    tint = if (game.isEnabled) game.primaryColor else colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(48.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // 游戏名称
            Text(
                text = game.name,
                fontFamily = plexBold,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = if (game.isEnabled) colorScheme.primary else colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            // 状态提示
            Text(
                text = if (game.isEnabled) "点击查看" else "即将推出",
                fontSize = 12.sp,
                color = if (game.isEnabled) colorScheme.onSurfaceVariant else colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
            )
        }
    }
}
