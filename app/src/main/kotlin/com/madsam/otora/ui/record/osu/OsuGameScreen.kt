package com.madsam.otora.ui.record.osu

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.ColorUtils
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madsam.otora.R
import com.madsam.otora.core.datastore.ThemeDataStore
import com.madsam.otora.core.theme.OtogeTrackerTheme
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.ui.settings.SettingsActivity
import androidx.compose.foundation.isSystemInDarkTheme

// osu! 默认主题色相 (333度，粉色)
private const val OsuDefaultHue = 333

/**
 * 从 HSL 色相值创建颜色
 * @param hue 色相值 (0-359)
 * @param saturation 饱和度 (0-1)，默认使用 osu! 的饱和度
 * @param lightness 亮度 (0-1)，默认使用适合主题生成的亮度
 */
private fun colorFromHue(hue: Int, saturation: Float = 0.7f, lightness: Float = 0.5f): Color {
    val rgb = ColorUtils.HSLToColor(floatArrayOf(hue.toFloat(), saturation, lightness))
    return Color(rgb)
}

/**
 * Osu 游戏全屏页面
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OsuGameScreen(
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val viewModel: OsuViewModel = viewModel(factory = OsuViewModelFactory())
    val cardData by viewModel.cardUI.collectAsState()
    
    // 从 DataStore 读取主题设置
    val themeDataStore = remember { ThemeDataStore(context) }
    val themeSettings by themeDataStore.getThemeSettingsFlow().collectAsState(
        initial = ThemeDataStore.ThemeSettings()
    )
    
    // 计算实际的深色模式状态
    val systemDarkTheme = isSystemInDarkTheme()
    val darkTheme = if (themeSettings.autoDarkMode) {
        systemDarkTheme
    } else {
        themeSettings.darkModeEnabled
    }
    
    // 从用户 profile_hue (HSL 色相 0-359) 生成主题色
    // 如果用户没有设置自定义色相，则使用 osu! 默认粉色色相 (333度)
    val userHue = cardData.profileHue ?: OsuDefaultHue
    val userProfileColor = colorFromHue(userHue)
    
    // 使用主题色包装整个 osu! 页面
    OtogeTrackerTheme(sourceColor = userProfileColor, darkTheme = darkTheme) {
        OsuGameScreenContent(
            viewModel = viewModel,
            onNavigateBack = onNavigateBack
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OsuGameScreenContent(
    viewModel: OsuViewModel,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val colorScheme = MaterialTheme.colorScheme

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "osu!",
                        fontFamily = plexBold,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.osu_navigation_back),
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
                            contentDescription = stringResource(R.string.osu_navigation_settings),
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
        contentWindowInsets = WindowInsets.navigationBars.only(WindowInsetsSides.Bottom),
        containerColor = colorScheme.surface
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            OsuUserPage(
                viewModel = viewModel,
                isPageVisible = true,
                includeBottomSystemBarPadding = false,
                avoidStartDisplayCutout = true,
                avoidEndDisplayCutout = true
            )
        }
    }
}
