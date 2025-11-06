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
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Beige600
import com.madsam.otora.core.theme.OtogeTrackerTheme
import com.madsam.otora.core.theme.Red800
import com.madsam.otora.core.theme.Red900
import com.madsam.otora.core.utils.ScreenUtil
import com.madsam.otora.data.bof.remote.api.BofRequestService
import com.madsam.otora.data.bof.remote.model.BofRangeResponse
import com.madsam.otora.ui.bof.BofScreen
import com.madsam.otora.ui.home.HomeScreen
import com.madsam.otora.ui.record.RecordScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun MainActivityScreen(navController: NavHostController) {
    val snackbarHostState = remember { SnackbarHostState() }
    var showBofScreen by remember { mutableStateOf(false) }
    val bofScreenState = remember { BofScreenState() }
    
    Box(modifier = Modifier.fillMaxSize()) {
        // 主界面（带底部导航）
        MainScreenWithNavigation(
            navController = navController,
            snackbarHostState = snackbarHostState,
            onShowBofScreen = { showBofScreen = true }
        )
        
        // BOF覆盖层 - 覆盖整个应用（包括导航栏）
        AnimatedVisibility(
            visible = showBofScreen,
            enter = slideInHorizontally(
                initialOffsetX = { it }
            ) + fadeIn(),
            exit = slideOutHorizontally(
                targetOffsetX = { it }
            ) + fadeOut()
        ) {
            BofScreen(
                bofScreenState = bofScreenState,
                onNavigateBack = { showBofScreen = false }
            )
        }
    }
}

@Composable
fun MainScreenWithNavigation(
    navController: NavHostController,
    snackbarHostState: SnackbarHostState,
    onShowBofScreen: () -> Unit
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(Screen.HomeScreen, Screen.RecordScreen, Screen.ReportScreen)
    val selectedIcons = listOf(Filled.Star, Filled.Star, Filled.Star)
    val unselectedIcons =
        listOf(Filled.Star, Filled.Star, Filled.Star)

    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()
    
    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            selectedItem = when (backStackEntry.destination.route) {
                Screen.HomeScreen.route -> 0
                Screen.RecordScreen.route -> 1
                Screen.ReportScreen.route -> 2
                else -> 0
            }
        }
    }

    if (useNavigationRail) {
        Box(modifier = Modifier.fillMaxSize()) {
            // 主内容区域 - 添加左边距避免被NavigationRail遮挡，并考虑WindowInsets
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(start = 80.dp) // NavigationRail的宽度
                .windowInsetsPadding(
                    WindowInsets.displayCutout.only(WindowInsetsSides.Start)
                )
            ) {
                NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
                    composable(Screen.HomeScreen.route) { 
                        HomeScreen(
                            snackbarHostState = snackbarHostState,
                            onShowBofScreen = onShowBofScreen
                        )
                    }
                    composable(Screen.RecordScreen.route) { RecordScreen(snackbarHostState) }
                    composable(Screen.ReportScreen.route) { Screen2() }
                }
            }

            // NavigationRail 覆盖在最上层
            NavigationRail(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .background(Red900)
                    .windowInsetsPadding(
                        WindowInsets.displayCutout.only(WindowInsetsSides.Start)
                            .union(WindowInsets.navigationBars.only(WindowInsetsSides.Bottom))
                    ),
                containerColor = Red900
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
                            indicatorColor = Red800,
                            selectedIconColor = Beige500,
                            selectedTextColor = Beige500,
                            unselectedIconColor = Beige600,
                            unselectedTextColor = Beige600
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

            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.padding(16.dp)
            )
        }
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            // 主内容区域 - 添加底部 padding 避免被导航栏覆盖
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 64.dp) // 导航栏高度
                .windowInsetsPadding(WindowInsets.navigationBars)
            ) {
                NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
                    composable(Screen.HomeScreen.route) { 
                        HomeScreen(
                            snackbarHostState = snackbarHostState,
                            onShowBofScreen = onShowBofScreen
                        )
                    }
                    composable(Screen.RecordScreen.route) { RecordScreen(snackbarHostState) }
                    composable(Screen.ReportScreen.route) { Screen2() }
                }
            }

            NavigationBar(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(Red900)
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .height(64.dp),
                tonalElevation = 0.dp,
                containerColor = Red900
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
                            indicatorColor = Red800,
                            selectedIconColor = Beige500,
                            selectedTextColor = Beige500,
                            unselectedIconColor = Beige600,
                            unselectedTextColor = Beige600
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