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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.windowInsetsPadding
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
                    composable(Screen.ReportScreen.route) { Screen2() }
                    
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
                    composable(Screen.ReportScreen.route) { Screen2() }
                    
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
fun Screen2() {
    Text(text = "Report Page")
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