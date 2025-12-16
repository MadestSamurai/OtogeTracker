package com.madsam.otora

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.OtogeTrackerTheme
import com.madsam.otora.core.utils.ScreenUtil
import com.madsam.otora.data.bof.remote.api.BofRequestService
import com.madsam.otora.data.bof.remote.model.BofRangeResponse
import com.madsam.otora.ui.bof.BofScreen
import com.madsam.otora.ui.home.HomeScreen
import com.madsam.otora.ui.record.GameListScreen
import com.madsam.otora.ui.record.chunithm.ChunithmGameScreen
import com.madsam.otora.ui.record.chunithm.ChunithmSongListScreen
import com.madsam.otora.ui.record.maimai.MaimaiGameScreen
import com.madsam.otora.ui.record.osu.OsuGameScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun MainActivityScreen(navController: NavHostController) {
    val snackbarHostState = remember { SnackbarHostState() }
    val overlayManager = remember { OverlayManager() }
    
    Box(modifier = Modifier.fillMaxSize()) {
        // 主界面（带底部导航）
        MainScreenWithNavigation(
            navController = navController,
            snackbarHostState = snackbarHostState,
            overlayManager = overlayManager
        )
        
        // 全局覆盖层
        GlobalOverlays(
            overlayManager = overlayManager
        )
    }
}

/**
 * 全局覆盖层组件 - 统一管理所有全屏覆盖层
 */
@Composable
private fun GlobalOverlays(
    overlayManager: OverlayManager
) {
    // BOF覆盖层
    OverlayWithSlideAnimation(
        visible = overlayManager.showBofScreen
    ) {
        BofScreen(
            bofScreenState = overlayManager.bofScreenState,
            onNavigateBack = { overlayManager.showBofScreen = false }
        )
    }
    
    // 曲目列表覆盖层
    OverlayWithSlideAnimation(
        visible = overlayManager.showSongListScreen
    ) {
        ChunithmSongListScreen(
            onNavigateBack = {
                overlayManager.showSongListScreen = false
            }
        )
    }
}

/**
 * 带滑动动画的覆盖层容器
 */
@Composable
private fun OverlayWithSlideAnimation(
    visible: Boolean,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInHorizontally(initialOffsetX = { it }) + fadeIn(),
        exit = slideOutHorizontally(targetOffsetX = { it }) + fadeOut()
    ) {
        content()
    }
}

@Composable
internal fun MainScreenWithNavigation(
    navController: NavHostController,
    snackbarHostState: SnackbarHostState,
    overlayManager: OverlayManager
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(Screen.HomeScreen, Screen.RecordScreen, Screen.ReportScreen)
    val selectedIcons = listOf(Filled.Star, Filled.Star, Filled.Star)
    val unselectedIcons =
        listOf(Filled.Star, Filled.Star, Filled.Star)

    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()
    
    // 监听当前路由，决定是否显示导航栏
    var currentRoute by remember { mutableStateOf<String?>(null) }
    val showNavigation = currentRoute in listOf(
        Screen.HomeScreen.route,
        Screen.RecordScreen.route,
        Screen.ReportScreen.route
    )
    
    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            currentRoute = backStackEntry.destination.route
            selectedItem = when (backStackEntry.destination.route) {
                Screen.HomeScreen.route -> 0
                Screen.RecordScreen.route -> 1
                Screen.ReportScreen.route -> 2
                else -> selectedItem // 保持当前选中状态
            }
        }
    }

    if (useNavigationRail) {
        Box(modifier = Modifier.fillMaxSize()) {
            // 主内容区域 - 根据是否显示导航栏决定左边距
            Box(modifier = Modifier
                .fillMaxSize()
                .then(
                    if (showNavigation) {
                        Modifier.padding(start = 80.dp) // NavigationRail的宽度
                    } else {
                        Modifier
                    }
                )
                .windowInsetsPadding(
                    WindowInsets.displayCutout.only(WindowInsetsSides.Start)
                )
            ) {
                NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
                    composable(Screen.HomeScreen.route) { 
                        HomeScreen(
                            snackbarHostState = snackbarHostState,
                            onShowBofScreen = { overlayManager.showBofScreen = true }
                        )
                    }
                    composable(Screen.RecordScreen.route) { 
                        GameListScreen(
                            onNavigateToGame = { route -> navController.navigate(route) },
                            onNavigateToSettings = { 
                                val intent = android.content.Intent(navController.context, com.madsam.otora.ui.settings.SettingsActivity::class.java)
                                navController.context.startActivity(intent)
                            }
                        )
                    }
                    composable(Screen.ReportScreen.route) { ColorRoleExamplesScreen() }
                    
                    // 游戏详情页面 - 全屏，不显示主导航
                    composable("game/osu") {
                        OsuGameScreen(
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                    composable("game/maimai") {
                        MaimaiGameScreen(
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                    composable("game/chunithm") {
                        ChunithmGameScreen(
                            onNavigateBack = { navController.popBackStack() },
                            overlayManager = overlayManager
                        )
                    }
                }
            }

            // NavigationRail 覆盖在最上层 - 只在主页面显示
            if (showNavigation) {
                val colorScheme = MaterialTheme.colorScheme
                NavigationRail(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .background(colorScheme.surfaceContainerLow)
                        .windowInsetsPadding(
                            WindowInsets.displayCutout.only(WindowInsetsSides.Start)
                                .union(WindowInsets.navigationBars.only(WindowInsetsSides.Bottom))
                        ),
                    containerColor = colorScheme.surfaceContainerLow
            ) {
                items.forEachIndexed { index, screen ->
                    NavigationRailItem(
                        icon = {
                            Icon(
                                if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                                contentDescription = screen.label
                            )
                        },
                        label = {
                            Text(
                                text = screen.label,
                                fontSize = 12.sp
                            )
                        },
                        colors = NavigationRailItemDefaults.colors(
                            indicatorColor = colorScheme.primaryContainer,
                            selectedIconColor = colorScheme.primary,
                            selectedTextColor = colorScheme.primary,
                            unselectedIconColor = colorScheme.onSurfaceVariant,
                            unselectedTextColor = colorScheme.onSurfaceVariant
                        ),
                        alwaysShowLabel = true,
                        selected = selectedItem == index,
                        onClick = {
                            if (selectedItem == index) return@NavigationRailItem
                            selectedItem = index
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = false
                                }
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
            }

            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.padding(16.dp)
            )
        }
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            // 主内容区域 - 根据是否显示导航栏决定底部边距
            Box(modifier = Modifier
                .fillMaxSize()
                .then(
                    if (showNavigation) {
                        Modifier.padding(bottom = 64.dp) // 导航栏高度
                    } else {
                        Modifier
                    }
                )
                .windowInsetsPadding(WindowInsets.navigationBars)
            ) {
                NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
                    composable(Screen.HomeScreen.route) { 
                        HomeScreen(
                            snackbarHostState = snackbarHostState,
                            onShowBofScreen = { overlayManager.showBofScreen = true }
                        )
                    }
                    composable(Screen.RecordScreen.route) { 
                        GameListScreen(
                            onNavigateToGame = { route -> navController.navigate(route) },
                            onNavigateToSettings = { 
                                val intent = android.content.Intent(navController.context, com.madsam.otora.ui.settings.SettingsActivity::class.java)
                                navController.context.startActivity(intent)
                            }
                        )
                    }
                    composable(Screen.ReportScreen.route) { ColorRoleExamplesScreen() }
                    
                    // 游戏详情页面 - 全屏，不显示主导航
                    composable("game/osu") {
                        OsuGameScreen(
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                    composable("game/maimai") {
                        MaimaiGameScreen(
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                    composable("game/chunithm") {
                        ChunithmGameScreen(
                            onNavigateBack = { navController.popBackStack() },
                            overlayManager = overlayManager
                        )
                    }
                }
            }

            // NavigationBar - 只在主页面显示
            if (showNavigation) {
                val colorScheme = MaterialTheme.colorScheme
                NavigationBar(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .background(colorScheme.surfaceContainerLow)
                        .windowInsetsPadding(WindowInsets.navigationBars)
                        .height(64.dp),
                    tonalElevation = 0.dp,
                    containerColor = colorScheme.surfaceContainerLow
                ) {
                items.forEachIndexed { index, screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                                contentDescription = screen.label,
                                modifier = Modifier.padding(0.dp)
                            )
                        },
                        label = {
                            Text(
                                text = screen.label,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(0.dp)
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = colorScheme.primaryContainer,
                            selectedIconColor = colorScheme.primary,
                            selectedTextColor = colorScheme.primary,
                            unselectedIconColor = colorScheme.onSurfaceVariant,
                            unselectedTextColor = colorScheme.onSurfaceVariant
                        ),
                        alwaysShowLabel = true,
                        selected = selectedItem == index,
                        onClick = {
                            if (selectedItem == index) return@NavigationBarItem
                            selectedItem = index
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = false
                                }
                                launchSingleTop = true
                            }
                        }
                    )
                }
                }
            }

            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavHostController
    private lateinit var bofRequestService: BofRequestService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 初始化BOF请求服务并预加载range数据
        bofRequestService = BofRequestService()
        preloadBofRangeData()

        val splashScreen = installSplashScreen()
        splashScreen.setOnExitAnimationListener { splashScreenViewProvider ->
            val fadeOut = ObjectAnimator.ofFloat(
                splashScreenViewProvider.view,
                View.ALPHA,
                1f,
                0f
            )
            fadeOut.interpolator = AccelerateInterpolator()
            fadeOut.duration = 500L
            fadeOut.doOnEnd { splashScreenViewProvider.remove() }
            fadeOut.start()
        }
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                scrim = 0x00000000
            ),
            navigationBarStyle = SystemBarStyle.dark(
                scrim = 0x00000000
            )
        )

        setContent {
            navController = rememberNavController()
            OtogeTrackerTheme {
                MainActivityScreen(navController)
            }
        }
    }

    private fun preloadBofRangeData() {
        // 在后台线程预加载range数据
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // 触发获取range数据，这会缓存数据供后续使用
                bofRequestService.getBofRangeDataPublic()
            } catch (e: Exception) {
                // 忽略错误，不影响应用启动
                android.util.Log.w("MainActivity", "Failed to preload BOF range data: ${e.message}")
            }
        }
    }
}

sealed class Screen(val route: String, val label: String) {
    data object HomeScreen : Screen("home", "Home")
    data object RecordScreen : Screen("record", "Record")
    data object ReportScreen : Screen("report", "Report")
}

@Composable
fun ColorRoleExamplesScreen() {
    val colorScheme = MaterialTheme.colorScheme
    
    androidx.compose.foundation.lazy.LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surface)
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Material 3 Color Role Examples",
                style = MaterialTheme.typography.headlineMedium,
                color = colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Based on Google's official guidelines",
                style = MaterialTheme.typography.bodyMedium,
                color = colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }
        
        // Primary - High-emphasis filled button
        item {
            Text(
                text = "Primary - High-emphasis actions",
                style = MaterialTheme.typography.titleMedium,
                color = colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            androidx.compose.material3.Button(
                onClick = {},
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = colorScheme.primary,
                    contentColor = colorScheme.onPrimary
                )
            ) {
                Text("Filled Button (Primary + onPrimary)")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        // Primary Container - FAB
        item {
            androidx.compose.foundation.layout.Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                androidx.compose.material3.FloatingActionButton(
                    onClick = {},
                    containerColor = colorScheme.primaryContainer,
                    contentColor = colorScheme.onPrimaryContainer
                ) {
                    Icon(Filled.Star, "FAB")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "FAB (primaryContainer + onPrimaryContainer)",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorScheme.onSurface
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        // Secondary - Tonal button
        item {
            Text(
                text = "Secondary - Less prominent actions",
                style = MaterialTheme.typography.titleMedium,
                color = colorScheme.secondary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            androidx.compose.material3.Button(
                onClick = {},
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = colorScheme.secondaryContainer,
                    contentColor = colorScheme.onSecondaryContainer
                )
            ) {
                Text("Tonal Button (secondaryContainer)")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        // Tertiary - Complementary accent
        item {
            Text(
                text = "Tertiary - Complementary accents",
                style = MaterialTheme.typography.titleMedium,
                color = colorScheme.tertiary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        colorScheme.tertiaryContainer,
                        androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = "Selected item (tertiaryContainer + onTertiaryContainer)",
                    color = colorScheme.onTertiaryContainer
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        // Surface containers - Detailed hierarchy example
        item {
            Text(
                text = "Surface - 5-level hierarchy (层级系统)",
                style = MaterialTheme.typography.titleMedium,
                color = colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            // Visual hierarchy demonstration with cards
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorScheme.surface, RoundedCornerShape(12.dp))
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Level 0: surfaceContainerLowest - Base level
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorScheme.surfaceContainerLowest, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Level 0: surfaceContainerLowest",
                            style = MaterialTheme.typography.labelMedium,
                            color = colorScheme.primary
                        )
                        Text(
                            text = "最低层级 - 用于背景或最远的元素",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.onSurface
                        )
                    }
                }
                
                // Level 1: surfaceContainerLow
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorScheme.surfaceContainerLow, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Level 1: surfaceContainerLow",
                            style = MaterialTheme.typography.labelMedium,
                            color = colorScheme.primary
                        )
                        Text(
                            text = "低层级 - 用于略微突出的容器",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.onSurface
                        )
                        // Nested card example
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                                .background(colorScheme.surfaceContainer, RoundedCornerShape(6.dp))
                                .padding(12.dp)
                        ) {
                            Text(
                                text = "嵌套的 Level 2 容器",
                                style = MaterialTheme.typography.bodySmall,
                                color = colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
                
                // Level 2: surfaceContainer (default)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorScheme.surfaceContainer, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Level 2: surfaceContainer (default)",
                            style = MaterialTheme.typography.labelMedium,
                            color = colorScheme.primary
                        )
                        Text(
                            text = "默认层级 - 用于常规卡片和容器",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.onSurface
                        )
                    }
                }
                
                // Level 3: surfaceContainerHigh
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorScheme.surfaceContainerHigh, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Level 3: surfaceContainerHigh",
                            style = MaterialTheme.typography.labelMedium,
                            color = colorScheme.primary
                        )
                        Text(
                            text = "高层级 - 用于需要强调的容器",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.onSurface
                        )
                    }
                }
                
                // Level 4: surfaceContainerHighest
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorScheme.surfaceContainerHighest, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Level 4: surfaceContainerHighest",
                            style = MaterialTheme.typography.labelMedium,
                            color = colorScheme.primary
                        )
                        Text(
                            text = "最高层级 - 用于弹窗、对话框等最前层元素",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.onSurface
                        )
                    }
                }
            }
            
            // Usage guide
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .background(colorScheme.primaryContainer, RoundedCornerShape(8.dp))
                    .padding(12.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = "使用指南 (Usage Guide)",
                        style = MaterialTheme.typography.labelMedium,
                        color = colorScheme.onPrimaryContainer
                    )
                    Text(
                        text = "• Lowest: 应用背景\n• Low: 导航栏、侧边栏\n• Container: 卡片、列表项\n• High: 浮动卡片、菜单\n• Highest: 对话框、模态窗口",
                        style = MaterialTheme.typography.bodySmall,
                        color = colorScheme.onPrimaryContainer
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        // Error
        item {
            Text(
                text = "Error - Attention states",
                style = MaterialTheme.typography.titleMedium,
                color = colorScheme.error,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        colorScheme.errorContainer,
                        androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
            ) {
                androidx.compose.foundation.layout.Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Filled.Star,
                        "Error",
                        tint = colorScheme.onErrorContainer
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Error message (errorContainer + onErrorContainer)",
                        color = colorScheme.onErrorContainer
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        // Outline
        item {
            Text(
                text = "Outline - Boundaries",
                style = MaterialTheme.typography.titleMedium,
                color = colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        colorScheme.surface,
                        RoundedCornerShape(8.dp)
                    )
                    .border(
                        2.dp,
                        colorScheme.outline,
                        RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = "Text field outline (outline)",
                    color = colorScheme.onSurface
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            androidx.compose.foundation.layout.Column {
                androidx.compose.material3.HorizontalDivider(
                    color = colorScheme.outlineVariant
                )
                Text(
                    text = "Divider (outlineVariant)",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        // Inverse colors
        item {
            Text(
                text = "Inverse - Contrasting elements",
                style = MaterialTheme.typography.titleMedium,
                color = colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        colorScheme.inverseSurface,
                        androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
            ) {
                androidx.compose.foundation.layout.Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Snackbar (inverseSurface)",
                        color = colorScheme.inverseOnSurface
                    )
                    androidx.compose.material3.TextButton(
                        onClick = {},
                        colors = androidx.compose.material3.ButtonDefaults.textButtonColors(
                            contentColor = colorScheme.inversePrimary
                        )
                    ) {
                        Text("ACTION")
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun SurfaceContainerExample(
    name: String,
    color: androidx.compose.ui.graphics.Color
) {
    val colorScheme = MaterialTheme.colorScheme
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color, androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Text(
            text = name,
            color = colorScheme.onSurface,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun Screen2() {
    val colorScheme = MaterialTheme.colorScheme
    
    androidx.compose.foundation.lazy.LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surface)
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Material 3 Color Scheme",
                style = MaterialTheme.typography.headlineMedium,
                color = colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        
        // Primary colors
        item { ColorCategory("Primary Colors") }
        item { ColorItem("primary", colorScheme.primary, colorScheme.onPrimary) }
        item { ColorItem("onPrimary", colorScheme.onPrimary, colorScheme.primary) }
        item { ColorItem("primaryContainer", colorScheme.primaryContainer, colorScheme.onPrimaryContainer) }
        item { ColorItem("onPrimaryContainer", colorScheme.onPrimaryContainer, colorScheme.primaryContainer) }
        item { ColorItem("inversePrimary", colorScheme.inversePrimary, colorScheme.surface) }
        
        // Secondary colors
        item { ColorCategory("Secondary Colors") }
        item { ColorItem("secondary", colorScheme.secondary, colorScheme.onSecondary) }
        item { ColorItem("onSecondary", colorScheme.onSecondary, colorScheme.secondary) }
        item { ColorItem("secondaryContainer", colorScheme.secondaryContainer, colorScheme.onSecondaryContainer) }
        item { ColorItem("onSecondaryContainer", colorScheme.onSecondaryContainer, colorScheme.secondaryContainer) }
        
        // Tertiary colors
        item { ColorCategory("Tertiary Colors") }
        item { ColorItem("tertiary", colorScheme.tertiary, colorScheme.onTertiary) }
        item { ColorItem("onTertiary", colorScheme.onTertiary, colorScheme.tertiary) }
        item { ColorItem("tertiaryContainer", colorScheme.tertiaryContainer, colorScheme.onTertiaryContainer) }
        item { ColorItem("onTertiaryContainer", colorScheme.onTertiaryContainer, colorScheme.tertiaryContainer) }
        
        // Background colors
        item { ColorCategory("Background Colors") }
        item { ColorItem("background", colorScheme.background, colorScheme.onBackground) }
        item { ColorItem("onBackground", colorScheme.onBackground, colorScheme.background) }
        
        // Surface colors
        item { ColorCategory("Surface Colors") }
        item { ColorItem("surface", colorScheme.surface, colorScheme.onSurface) }
        item { ColorItem("onSurface", colorScheme.onSurface, colorScheme.surface) }
        item { ColorItem("surfaceVariant", colorScheme.surfaceVariant, colorScheme.onSurfaceVariant) }
        item { ColorItem("onSurfaceVariant", colorScheme.onSurfaceVariant, colorScheme.surface) }
        item { ColorItem("surfaceTint", colorScheme.surfaceTint, colorScheme.onSurface) }
        item { ColorItem("inverseSurface", colorScheme.inverseSurface, colorScheme.inverseOnSurface) }
        item { ColorItem("inverseOnSurface", colorScheme.inverseOnSurface, colorScheme.inverseSurface) }
        item { ColorItem("surfaceBright", colorScheme.surfaceBright, colorScheme.onSurface) }
        item { ColorItem("surfaceDim", colorScheme.surfaceDim, colorScheme.onSurface) }
        
        // Surface container variants
        item { ColorCategory("Surface Container Variants") }
        item { ColorItem("surfaceContainer", colorScheme.surfaceContainer, colorScheme.onSurface) }
        item { ColorItem("surfaceContainerHigh", colorScheme.surfaceContainerHigh, colorScheme.onSurface) }
        item { ColorItem("surfaceContainerHighest", colorScheme.surfaceContainerHighest, colorScheme.onSurface) }
        item { ColorItem("surfaceContainerLow", colorScheme.surfaceContainerLow, colorScheme.onSurface) }
        item { ColorItem("surfaceContainerLowest", colorScheme.surfaceContainerLowest, colorScheme.onSurface) }
        
        // Error colors
        item { ColorCategory("Error Colors") }
        item { ColorItem("error", colorScheme.error, colorScheme.onError) }
        item { ColorItem("onError", colorScheme.onError, colorScheme.error) }
        item { ColorItem("errorContainer", colorScheme.errorContainer, colorScheme.onErrorContainer) }
        item { ColorItem("onErrorContainer", colorScheme.onErrorContainer, colorScheme.errorContainer) }
        
        // Outline colors
        item { ColorCategory("Outline Colors") }
        item { ColorItem("outline", colorScheme.outline, colorScheme.surface) }
        item { ColorItem("outlineVariant", colorScheme.outlineVariant, colorScheme.surface) }
        
        // Fixed colors
        item { ColorCategory("Primary Fixed Colors") }
        item { ColorItem("primaryFixed", colorScheme.primaryFixed, colorScheme.onPrimaryFixed) }
        item { ColorItem("primaryFixedDim", colorScheme.primaryFixedDim, colorScheme.onPrimaryFixed) }
        item { ColorItem("onPrimaryFixed", colorScheme.onPrimaryFixed, colorScheme.primaryFixed) }
        item { ColorItem("onPrimaryFixedVariant", colorScheme.onPrimaryFixedVariant, colorScheme.primaryFixed) }
        
        item { ColorCategory("Secondary Fixed Colors") }
        item { ColorItem("secondaryFixed", colorScheme.secondaryFixed, colorScheme.onSecondaryFixed) }
        item { ColorItem("secondaryFixedDim", colorScheme.secondaryFixedDim, colorScheme.onSecondaryFixed) }
        item { ColorItem("onSecondaryFixed", colorScheme.onSecondaryFixed, colorScheme.secondaryFixed) }
        item { ColorItem("onSecondaryFixedVariant", colorScheme.onSecondaryFixedVariant, colorScheme.secondaryFixed) }
        
        item { ColorCategory("Tertiary Fixed Colors") }
        item { ColorItem("tertiaryFixed", colorScheme.tertiaryFixed, colorScheme.onTertiaryFixed) }
        item { ColorItem("tertiaryFixedDim", colorScheme.tertiaryFixedDim, colorScheme.onTertiaryFixed) }
        item { ColorItem("onTertiaryFixed", colorScheme.onTertiaryFixed, colorScheme.tertiaryFixed) }
        item { ColorItem("onTertiaryFixedVariant", colorScheme.onTertiaryFixedVariant, colorScheme.tertiaryFixed) }
        
        // Scrim
        item { ColorCategory("Other") }
        item { ColorItem("scrim", colorScheme.scrim, colorScheme.surface) }
    }
}

@Composable
private fun ColorCategory(title: String) {
    val colorScheme = MaterialTheme.colorScheme
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        color = colorScheme.primary,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    )
}

@Composable
private fun ColorItem(
    name: String,
    color: androidx.compose.ui.graphics.Color,
    textColor: androidx.compose.ui.graphics.Color
) {
    androidx.compose.foundation.layout.Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(color, androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            color = textColor,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = String.format("#%08X", color.value.toLong()),
            color = textColor.copy(alpha = 0.7f),
            style = MaterialTheme.typography.bodySmall,
            fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace
        )
    }
}

class BofScreenState {
    // 计算当前时间的五分钟粒度
    private val now = LocalDateTime.now()
    private val currentMinutes = now.minute / 5 * 5
    private val roundedNow = now.withMinute(currentMinutes).withSecond(0).withNano(0)
    private val compareDateTime = roundedNow.minusHours(24)
    
    var selectedTab = MutableStateFlow(0)
    var selectedSubTab = MutableStateFlow(0)
    var selectedCurrentDate = MutableStateFlow(roundedNow.toLocalDate())
    var selectedCurrentTime = MutableStateFlow(roundedNow.format(DateTimeFormatter.ofPattern("HH:mm")))
    var selectedCompareDate = MutableStateFlow(compareDateTime.toLocalDate())
    var selectedCompareTime = MutableStateFlow(compareDateTime.format(DateTimeFormatter.ofPattern("HH:mm")))
    var selectedRange = MutableStateFlow<BofRangeResponse?>(null)
}

/**
 * 覆盖层管理器 - 统一管理所有全局覆盖层的显示状态
 */
class OverlayManager {
    // BOF覆盖层
    var showBofScreen by mutableStateOf(false)
    val bofScreenState = BofScreenState()
    
    // 曲目列表覆盖层
    var showSongListScreen by mutableStateOf(false)
}