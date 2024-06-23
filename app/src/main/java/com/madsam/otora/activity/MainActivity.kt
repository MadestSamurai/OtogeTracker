package com.madsam.otora.activity

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.madsam.otora.R
import com.madsam.otora.ui.record.RecordScreen
import kotlinx.coroutines.delay

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
    val items = listOf(Screen.Screen1, Screen.Screen2)
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                items.forEach { screen ->
                    BottomNavigationItem(
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
            MainActivityScreen()
        }
    }
}

sealed class Screen(val route: String, val label: String) {
    data object Screen1 : Screen("record", "Record")
    data object Screen2 : Screen("screen2", "Screen 2")
}

@Composable
fun Screen2() {
    Text(text = "Screen 2")
}