package com.madsam.otora.activity

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.madsam.otora.ui.record.RecordScreen

/**
 * 项目名: OtogeTracker
 * 文件名: MainActivity
 * 创建者: MadSamurai
 * 创建时间: 2023/2/24 17:10
 * 描述: 客户端主Activity
 */
const val KEY_ROUTE = "route"

@Composable
fun MainActivityScreen(mainViewModel: MainViewModel) {
    val items = listOf(Screen.Screen1, Screen.Screen2)
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
            NavHost(navController = navController, startDestination = Screen.Screen1.route) {
                composable(Screen.Screen1.route) {
                    RecordScreen()
                }
                composable(Screen.Screen2.route) {
                    Screen2()
                }
            }
        }
    }
}

class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

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
            MainActivityScreen(mainViewModel)
        }
    }
}

sealed class Screen(val route: String, val label: String) {
    data object Screen1 : Screen("record", "Record")
    data object Screen2 : Screen("report", "Report")
}

@Composable
fun Screen2() {
    Text(text = "Report Page")
}