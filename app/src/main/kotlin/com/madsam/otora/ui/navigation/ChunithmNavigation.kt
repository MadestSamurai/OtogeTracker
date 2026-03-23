package com.madsam.otora.ui.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.madsam.otora.OverlayManager
import com.madsam.otora.ui.record.ChunithmScreenState
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.ChunithmUserPage
import com.madsam.otora.ui.record.chunithm.pages.ChunithmRatingPreviewPage
import com.madsam.otora.ui.record.chunithm.pages.ChunithmSongDetailPage

/**
 * 定义导航路由常量
 */
object ChunithmRoutes {
    const val CHUNITHM_USER = "chunithm_user"
    const val CHUNITHM_SONG_DETAIL = "chunithm_song_detail/{songTitle}"
    const val CHUNITHM_RATING_PREVIEW = "chunithm_rating_preview"
}

/**
 * Chunithm模块的导航图
 * 
 * 使用示例：
 * ```kotlin
 * ChunithmNavHost(
 *     navController = navController,
 *     startDestination = ChunithmRoutes.CHUNITHM_USER,
 *     viewModel = chunithmViewModel,
 *     chuniScreenState = chuniScreenState,
 *     snackbarHostState = snackbarHostState,
 *     overlayManager = overlayManager
 * )
 * ```
 */
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
internal fun ChunithmNavHost(
    navController: NavHostController,
    startDestination: String = ChunithmRoutes.CHUNITHM_USER,
    viewModel: ChunithmViewModel,
    chunithmScreenState: ChunithmScreenState,
    snackbarHostState: SnackbarHostState,
    overlayManager: OverlayManager
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Chunithm 用户主页 (包含Tab页面)
        composable(ChunithmRoutes.CHUNITHM_USER) {
            ChunithmUserPage(
                viewModel = viewModel,
                chunithmScreenState = chunithmScreenState,
                snackbarHostState = snackbarHostState,
                navController = navController,
                onShowSongList = {
                    overlayManager.showSongListScreen = true
                }
            )
        }

        composable(ChunithmRoutes.CHUNITHM_RATING_PREVIEW) {
            viewModel.setOnBackCallback {
                navController.popBackStack()
            }

            ChunithmRatingPreviewPage(viewModel = viewModel)
        }
        
        // Chunithm 歌曲详情页
        composable(
            route = ChunithmRoutes.CHUNITHM_SONG_DETAIL,
            arguments = listOf(
                navArgument("songTitle") { 
                    type = NavType.StringType 
                }
            ),
            enterTransition = {
                scaleIn(
                    initialScale = 0.1f,
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                )
            },
            exitTransition = {
                scaleOut(
                    targetScale = 0.1f,
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                )
            }
        ) { backStackEntry ->
            val songTitle = backStackEntry.arguments?.getString("songTitle") ?: ""
            
            // 设置返回回调
            viewModel.setOnBackCallback {
                navController.popBackStack()
            }
            
            ChunithmSongDetailPage(
                songTitle = songTitle,
                viewModel = viewModel,
                onNavigateBack = {
                    viewModel.resetPageTitle()
                    navController.popBackStack()
                }
            )
        }
    }
}
