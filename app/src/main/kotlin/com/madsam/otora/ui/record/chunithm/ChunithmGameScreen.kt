package com.madsam.otora.ui.record.chunithm

import android.content.Intent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.madsam.otora.OverlayManager
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.ui.record.ChunithmScreenState
import com.madsam.otora.ui.record.chunithm.pages.ChunithmSongDetailPage
import com.madsam.otora.ui.record.chunithm.pages.ChunithmRatingPreviewPage
import com.madsam.otora.ui.settings.SettingsActivity
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

/**
 * Chunithm 游戏全屏页面
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun ChunithmGameScreen(
    onNavigateBack: () -> Unit,
    overlayManager: OverlayManager
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val chunithmNavController = rememberNavController()
    val chunithmViewModel: ChunithmViewModel = viewModel(factory = ChuniViewModelFactory())
    val chunithmScreenState = remember { ChunithmScreenState() }
    val colorScheme = MaterialTheme.colorScheme
    
    val chunithmPageTitle by chunithmViewModel.pageTitle.collectAsState()
    val chunithmShowBackButton by chunithmViewModel.showBackButton.collectAsState()
    
    // 设置返回回调
    LaunchedEffect(chunithmNavController) {
        chunithmViewModel.setOnBackCallback {
            if (!chunithmNavController.popBackStack()) {
                onNavigateBack()
            }
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    ScrollableTitle(text = chunithmPageTitle)
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            if (chunithmShowBackButton) {
                                chunithmViewModel.triggerBack()
                            } else {
                                onNavigateBack()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            val intent = Intent(context, SettingsActivity::class.java)
                            context.startActivity(intent)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Settings",
                            tint = colorScheme.onSurface,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorScheme.surfaceContainer,
                    navigationIconContentColor = colorScheme.onSurface,
                    titleContentColor = colorScheme.onSurface,
                    actionIconContentColor = colorScheme.onSurface
                )
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        containerColor = colorScheme.surface
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            NavHost(
                navController = chunithmNavController,
                startDestination = "chunithm_user"
            ) {
                composable("chunithm_user") {
                    ChunithmUserPage(
                        viewModel = chunithmViewModel,
                        chunithmScreenState = chunithmScreenState,
                        snackbarHostState = snackbarHostState,
                        navController = chunithmNavController,
                        onShowSongList = {
                            overlayManager.showSongListScreen = true
                        }
                    )
                }
                composable("chunithm_rating_preview") {
                    chunithmViewModel.setOnBackCallback {
                        chunithmNavController.popBackStack()
                    }

                    ChunithmRatingPreviewPage(
                        viewModel = chunithmViewModel
                    )
                }
                composable(
                    route = "chunithm_song_detail/{songTitle}",
                    arguments = listOf(navArgument("songTitle") { type = NavType.StringType })
                ) { backStackEntry ->
                    val encodedTitle = backStackEntry.arguments?.getString("songTitle") ?: ""
                    val songTitle = URLDecoder.decode(encodedTitle, StandardCharsets.UTF_8.toString())
                    ChunithmSongDetailPage(
                        songTitle = songTitle,
                        viewModel = chunithmViewModel,
                        onNavigateBack = { chunithmNavController.popBackStack() }
                    )
                }
            }
        }
    }
}

@Composable
private fun ScrollableTitle(text: String) {
    val scrollState = rememberScrollState()
    var shouldAutoScroll by remember(text) { mutableStateOf(false) }
    
    LaunchedEffect(text, scrollState.maxValue) {
        shouldAutoScroll = scrollState.maxValue > 0
        
        if (shouldAutoScroll) {
            kotlinx.coroutines.delay(2000)
            
            while (shouldAutoScroll) {
                scrollState.animateScrollTo(
                    scrollState.maxValue,
                    animationSpec = androidx.compose.animation.core.tween(
                        durationMillis = (text.length * 80).coerceIn(4000, 8000),
                        easing = androidx.compose.animation.core.LinearEasing
                    )
                )
                
                if (!shouldAutoScroll) break
                kotlinx.coroutines.delay(1500)
                
                scrollState.animateScrollTo(
                    0,
                    animationSpec = androidx.compose.animation.core.tween(
                        durationMillis = 1000,
                        easing = androidx.compose.animation.core.FastOutSlowInEasing
                    )
                )
                
                if (!shouldAutoScroll) break
                kotlinx.coroutines.delay(2000)
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState, enabled = false),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                fontFamily = plexBold,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Visible,
                modifier = Modifier.padding(horizontal = 48.dp)
            )
        }
        
        if (shouldAutoScroll && scrollState.value > 10) {
            val gradientColor = MaterialTheme.colorScheme.surfaceContainer
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(48.dp)
                    .background(
                        androidx.compose.ui.graphics.Brush.horizontalGradient(
                            colors = listOf(
                                gradientColor,
                                gradientColor.copy(alpha = 0f)
                            )
                        )
                    )
                    .align(Alignment.CenterStart)
            )
        }
        
        if (shouldAutoScroll && scrollState.value < scrollState.maxValue - 10) {
            val gradientColor = MaterialTheme.colorScheme.surfaceContainer
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(48.dp)
                    .background(
                        androidx.compose.ui.graphics.Brush.horizontalGradient(
                            colors = listOf(
                                gradientColor.copy(alpha = 0f),
                                gradientColor
                            )
                        )
                    )
                    .align(Alignment.CenterEnd)
            )
        }
    }
}
