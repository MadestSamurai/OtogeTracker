package com.madsam.otora.ui.record

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.icon.fa.Cog
import com.madsam.otora.core.icon.fa.Trash
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Beige600
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.Red800
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.ui.navigation.ChunithmNavHost
import com.madsam.otora.ui.record.chunithm.ChuniViewModelFactory
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.maimai.MaimaiUserPage
import com.madsam.otora.ui.record.osu.OsuUserPage
import com.madsam.otora.ui.record.osu.OsuViewModel
import com.madsam.otora.ui.record.osu.OsuViewModelFactory
import com.madsam.otora.ui.settings.SettingsActivity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordScreen(
    snackbarHostState: SnackbarHostState
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(Screen.Page1, Screen.Page2, Screen.Page3, Screen.Page4)
    var selectedItem by remember { mutableStateOf(items[0]) }
    val context = LocalContext.current

    var showMaimaiDialog by remember { mutableStateOf(false) }

    // 移除ViewModel创建，让各个页面自己管理
    val osuScreenState = OsuScreenState()
    val chunithmNavController = rememberNavController()
    
    // 检测是否为横屏或宽屏
    val windowInfo = LocalWindowInfo.current
    val density = LocalDensity.current
    val screenWidth = with(density) { windowInfo.containerSize.width.toDp() }
    val screenHeight = with(density) { windowInfo.containerSize.height.toDp() }
    val useNavigationRail = screenWidth > screenHeight || screenWidth > 600.dp

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(if (useNavigationRail) 280.dp else 300.dp),
                drawerContainerColor = Red500,
                drawerContentColor = Beige400
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                items.forEach { screen ->
                    NavigationDrawerItem(
                        icon = {
                            when (screen) {
                                Screen.Page1 -> Icon(Filled.OsuIcon, "Osu", Modifier.size(24.dp))
                                Screen.Page2 -> Icon(Filled.MaimaiIcon, "Maimai", Modifier.size(24.dp))
                                Screen.Page3 -> Icon(Filled.ChunithmIcon, "Chunithm", Modifier.size(24.dp))
                                Screen.Page4 -> Icon(Fa.Trash, null, Modifier.size(24.dp))
                            }
                        },
                        label = { Text(screen.route) },
                        selected = selectedItem == screen,
                        onClick = {
                            selectedItem = screen
                            scope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(horizontal = 12.dp),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Red800,
                            unselectedContainerColor = Red500,
                            selectedIconColor = Beige500,
                            unselectedIconColor = Beige600,
                            selectedTextColor = Beige500,
                            unselectedTextColor = Beige600
                        )
                    )
                }
                
                Spacer(modifier = Modifier.weight(1f))
                
                // 设置按钮放在底部
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            imageVector = Fa.Cog,
                            contentDescription = "Settings",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Settings") },
                    selected = false,
                    onClick = {
                        val intent = Intent(context, SettingsActivity::class.java)
                        context.startActivity(intent)
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(horizontal = 12.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Red800,
                        unselectedContainerColor = Red500,
                        selectedIconColor = Beige500,
                        unselectedIconColor = Beige600,
                        selectedTextColor = Beige500,
                        unselectedTextColor = Beige600
                    )
                )
                
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    ) {
        Column {
            CenterAlignedTopAppBar(
                title = {
                    // 简化标题逻辑，各页面自行管理
                    ScrollableTitle(text = selectedItem.route)
                },
                navigationIcon = {
                    // 简化导航图标，统一使用Menu按钮
                    IconButton(onClick = {
                        scope.launch { drawerState.open() }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
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
                            imageVector = Fa.Cog,
                            contentDescription = "Settings",
                            tint = Beige400,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Red500,
                    titleContentColor = Beige400,
                    navigationIconContentColor = Beige400
                )
            )

            // Content
            Box(modifier = Modifier.fillMaxSize()) {
                when (selectedItem) {
                    Screen.Page1 -> {
                        val osuViewModel: OsuViewModel = viewModel(factory = OsuViewModelFactory())
                        OsuUserPage(
                            osuViewModel, 
                            osuScreenState,
                            isPageVisible = selectedItem == Screen.Page1
                        )
                    }

                    Screen.Page2 -> MaimaiUserPage(
                        showMaimaiDialog,
                        onDismissDialog = { showMaimaiDialog = false }
                    )

                    Screen.Page3 -> {
                        val chunithmViewModel: ChunithmViewModel = viewModel(factory = ChuniViewModelFactory())
                        ChunithmNavHost(
                            navController = chunithmNavController,
                            viewModel = chunithmViewModel,
                            chuniScreenState = ChunithmScreenState(),
                            snackbarHostState = snackbarHostState
                        )
                    }
                    Screen.Page4 -> TestPage4()
                }
            }
        }
    }
}

@Composable
fun TestPage4() {
    Text(
        text = "TestPage4",
        modifier = Modifier.fillMaxSize(),
        fontFamily = sarasaBold,
        fontSize = 20.sp
    )
}

sealed class Screen(val route: String) {
    data object Page1 : Screen("Osu")
    data object Page2 : Screen("Maimai")
    data object Page3 : Screen("Chunithm")
    data object Page4 : Screen("Page4")
}

class OsuScreenState {
    var selectedTab = MutableStateFlow(0)
}

class ChunithmScreenState {
    var selectedTab = MutableStateFlow(0)
}

@Composable
private fun ScrollableTitle(text: String) {
    val scrollState = rememberScrollState()
    var shouldAutoScroll by remember(text) { mutableStateOf(false) }
    
    // 检查是否需要滚动，并启动自动滚动效果
    LaunchedEffect(text, scrollState.maxValue) {
        shouldAutoScroll = scrollState.maxValue > 0
        
        if (shouldAutoScroll) {
            kotlinx.coroutines.delay(2000)
            
            while (shouldAutoScroll) {
                // 滚动到末尾
                scrollState.animateScrollTo(
                    scrollState.maxValue,
                    animationSpec = androidx.compose.animation.core.tween(
                        durationMillis = (text.length * 80).coerceIn(4000, 8000), // 控制滚动速度
                        easing = androidx.compose.animation.core.LinearEasing
                    )
                )
                
                if (!shouldAutoScroll) break
                kotlinx.coroutines.delay(1500)
                
                // 滚动回开头
                scrollState.animateScrollTo(
                    0,
                    animationSpec = androidx.compose.animation.core.tween(
                        durationMillis = 1000, // 快速回到开头
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
                .horizontalScroll(scrollState, enabled = false), // 禁用手动滚动
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                fontFamily = sarasaBold,
                
                maxLines = 1,
                overflow = TextOverflow.Visible,
                modifier = Modifier.padding(horizontal = 48.dp)
            )
        }
        
        // 左侧渐隐遮罩 - 只在滚动时显示
        if (shouldAutoScroll && scrollState.value > 10) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(48.dp)
                    .background(
                        androidx.compose.ui.graphics.Brush.horizontalGradient(
                            colors = listOf(
                                Red500, // TopAppBar的背景色
                                Red500.copy(alpha = 0f)
                            )
                        )
                    )
                    .align(Alignment.CenterStart)
            )
        }
        
        // 右侧渐隐遮罩 - 只在滚动时显示
        if (shouldAutoScroll && scrollState.value < scrollState.maxValue - 10) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(48.dp)
                    .background(
                        androidx.compose.ui.graphics.Brush.horizontalGradient(
                            colors = listOf(
                                Red500.copy(alpha = 0f),
                                Red500 // TopAppBar的背景色
                            )
                        )
                    )
                    .align(Alignment.CenterEnd)
            )
        }
    }
}
