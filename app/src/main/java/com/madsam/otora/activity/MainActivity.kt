package com.madsam.otora.activity

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.madsam.otora.ui.bof.BofScreen
import com.madsam.otora.ui.record.RecordScreen
import kotlinx.coroutines.flow.MutableStateFlow
import java.time.LocalDate

/**
 * 项目名: OtogeTracker
 * 文件名: MainActivity
 * 创建者: MadSamurai
 * 创建时间: 2023/2/24 17:10
 * 描述: 客户端主Activity
 */

@Composable
fun MainActivityScreen(navController: NavHostController) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(Screen.RecordScreen, Screen.ReportScreen, Screen.BOFScreen)
    val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Star)
    val unselectedIcons =
        listOf(Icons.Outlined.Home, Icons.Outlined.FavoriteBorder, Icons.Outlined.Star)
    val snackbarHostState = remember { SnackbarHostState() }

    // Observe the NavController's back stack
    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            selectedItem = when (backStackEntry.destination.route) {
                Screen.RecordScreen.route -> 0
                Screen.ReportScreen.route -> 1
                Screen.BOFScreen.route -> 2
                else -> 0
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .windowInsetsPadding(
                        WindowInsets.navigationBars.only(
                            WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
                        )
                    )
                    .height(64.dp)
                ,
                tonalElevation = 0.dp
            ) {
                items.forEachIndexed { index, screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                                contentDescription = screen.label,
                                modifier = Modifier.padding(0.dp)  // 移除所有padding
                            )
                        },
                        label = { 
                            Text(
                                text = screen.label,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(0.dp)  // 移除所有padding
                            ) 
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.secondaryContainer,
                            selectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            selectedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        ),
                        alwaysShowLabel = false,
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
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            NavHost(navController = navController, startDestination = Screen.RecordScreen.route) {
                lateinit var bofNavController: NavHostController
                val bofScreenState = BofScreenState()
                composable(Screen.RecordScreen.route) { RecordScreen(snackbarHostState) }
                composable(Screen.ReportScreen.route) { Screen2() }
                composable(Screen.BOFScreen.route) {
                    bofNavController = rememberNavController()
                    BofScreen(snackbarHostState, bofNavController, bofScreenState)
                }
            }
        }
    }
}

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        setContent {
            navController = rememberNavController()
            Surface(tonalElevation = 5.dp) {
                MainActivityScreen(navController)
            }
        }
    }
}

sealed class Screen(val route: String, val label: String) {
    data object RecordScreen : Screen("record", "Record")
    data object ReportScreen : Screen("report", "Report")
    data object BOFScreen : Screen("bof", "BOF")
}

@Composable
fun Screen2() {
    Text(text = "Report Page")
}

class BofScreenState {
    var selectedTab = MutableStateFlow(0)
    var selectedSubTab = MutableStateFlow(0)
    var selectedCurrentDate = MutableStateFlow(LocalDate.now())
    var selectedCurrentTime = MutableStateFlow("00:00")
    var selectedCompareDate = MutableStateFlow(LocalDate.now().minusDays(1))
    var selectedCompareTime = MutableStateFlow("00:00")
}