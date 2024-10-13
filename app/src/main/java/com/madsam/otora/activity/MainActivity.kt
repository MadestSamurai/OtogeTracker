package com.madsam.otora.activity

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.animation.AccelerateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.madsam.otora.ui.bof.BofScreen
import com.madsam.otora.ui.record.RecordScreen
import com.madsam.otora.ui.theme.AppTheme

/**
 * 项目名: OtogeTracker
 * 文件名: MainActivity
 * 创建者: MadSamurai
 * 创建时间: 2023/2/24 17:10
 * 描述: 客户端主Activity
 */
const val KEY_ROUTE = "route"

@Composable
fun MainActivityScreen() {
    val items = listOf(Screen.RecordScreen, Screen.ReportScreen, Screen.BOFScreen)
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        label = { Text(screen.label) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(it) {
                                        inclusive = true
                                    }
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
                composable(Screen.RecordScreen.route) {
                    RecordScreen()
                }
                composable(Screen.ReportScreen.route) {
                    Screen2()
                }
                composable(Screen.BOFScreen.route) {
                    BofScreen()
                }
            }
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

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
            AppTheme {
                Surface(tonalElevation = 5.dp) {
                    MainActivityScreen()
                }
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