package com.madsam.otora.ui.record

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
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
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Beige600
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.Red800
import com.madsam.otora.core.theme.sarasaFont
import com.madsam.otora.core.utils.ShareUtil
import com.madsam.otora.ui.components.CustomTabRow
import com.madsam.otora.ui.navigation.ChunithmNavHost
import com.madsam.otora.ui.record.chunithm.ChuniViewModelFactory
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.maimai.MaimaiUserPage
import com.madsam.otora.ui.record.osu.OsuUserPage
import com.madsam.otora.ui.record.osu.OsuViewModel
import com.madsam.otora.ui.record.osu.OsuViewModelFactory
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

    var showOsuDialog by remember { mutableStateOf(false) }
    var showMaimaiDialog by remember { mutableStateOf(false) }
    var showChunithmDialog by remember { mutableStateOf(false) }

    val osuViewModel: OsuViewModel = viewModel(
        factory = OsuViewModelFactory(
            userId = ShareUtil.getString("userId", context) ?: "2",
            mode = ShareUtil.getString("mode", context) ?: "osu",
            context = context
        )
    )
    val chunithmViewModel: ChunithmViewModel = viewModel(factory = ChuniViewModelFactory(context))
    val osuScreenState = OsuScreenState()
    val chunithmNavController = rememberNavController()
    
    // 检测是否为横屏或宽屏
    val windowInfo = LocalWindowInfo.current
    val density = LocalDensity.current
    val screenWidth = with(density) { windowInfo.containerSize.width.toDp() }
    val screenHeight = with(density) { windowInfo.containerSize.height.toDp() }
    val useNavigationRail = screenWidth > screenHeight || screenWidth > 600.dp

    if (useNavigationRail) {
        // 横屏或宽屏时使用CustomTabRow作为紧凑的子导航
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Red500)
                    .windowInsetsPadding(WindowInsets.statusBars)
                    .height(64.dp) // TopAppBar的标准高度
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 左侧类型切换tabs
                CustomTabRow(
                    selectedTabIndex = items.indexOf(selectedItem),
                    containerColor = Red500,
                    modifier = Modifier.wrapContentWidth()
                ) {
                    items.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedItem == screen,
                            onClick = { selectedItem = screen },
                            text = {
                                Text(
                                    text = screen.route,
                                    fontFamily = sarasaFont,
                                    fontSize = 14.sp,
                                    color = if (selectedItem == screen) Beige500 else Beige600
                                )
                            },
                            modifier = Modifier.height(48.dp)
                        )
                    }
                }
                
                // 右侧占位，将action按钮推到最右边
                Spacer(modifier = Modifier.weight(1f))
                
                // 右侧action按钮
                Row {
                    if (selectedItem == Screen.Page3) {
                        IconButton(
                            onClick = {
                                chunithmViewModel.fetchSongData(context)
                            }
                        ) {
                            Icon(
                                imageVector = Filled.Download,
                                contentDescription = "Download Data",
                                tint = Beige400
                            )
                        }
                    }
                    IconButton(
                        onClick = {
                            when (selectedItem) {
                                Screen.Page1 -> showOsuDialog = true
                                Screen.Page2 -> showMaimaiDialog = true
                                Screen.Page3 -> showChunithmDialog = true
                                Screen.Page4 -> { /* Action for Page 4 */ }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = when (selectedItem) {
                                Screen.Page1 -> Icons.Default.Add
                                Screen.Page2 -> Icons.Default.Edit
                                Screen.Page3 -> Filled.ArrowRotate
                                Screen.Page4 -> Icons.Default.Delete
                            },
                            contentDescription = "Action",
                            tint = Beige400
                        )
                    }
                }
            }

            // Content
            Box(modifier = Modifier.fillMaxSize()) {
                when (selectedItem) {
                    Screen.Page1 -> OsuUserPage(
                        showOsuDialog,
                        osuViewModel,
                        osuScreenState,
                        onDismissDialog = { showOsuDialog = false }
                    )

                    Screen.Page2 -> MaimaiUserPage(
                        showMaimaiDialog,
                        onDismissDialog = { showMaimaiDialog = false }
                    )

                    Screen.Page3 -> {
                        ChunithmNavHost(
                            navController = chunithmNavController,
                            viewModel = chunithmViewModel,
                            chuniScreenState = ChunithmScreenState(),
                            snackbarHostState = snackbarHostState,
                            showDialog = showChunithmDialog,
                            onDismissDialog = { showChunithmDialog = false }
                        )
                    }
                    Screen.Page4 -> TestPage4()
                }
            }
        }
    } else {
        // 竖屏时使用原有的ModalNavigationDrawer
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(
                    modifier = Modifier.width(300.dp),
                    drawerContainerColor = Red500,
                    drawerContentColor = Beige400
                ) {
                    Spacer(modifier = Modifier.height(12.dp))
                    items.forEach { screen ->
                        NavigationDrawerItem(
                            icon = {
                                when (screen) {
                                    Screen.Page1 -> Icon(Filled.OsuIcon, "Osu", Modifier.size(26.dp))
                                    Screen.Page2 -> Icon(Filled.MaimaiIcon, "Maimai", Modifier.padding(1.dp).size(24.dp))
                                    Screen.Page3 -> Icon(Filled.ChunithmIcon, "Chunithm", Modifier.padding(1.dp).size(24.dp))
                                    Screen.Page4 -> Icon(Icons.Default.Delete, null)
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
                }
            }
        ) {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = selectedItem.route,
                            fontFamily = sarasaFont,
                            fontWeight = FontWeight.Bold,
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    },
                    actions = {
                        if (selectedItem == Screen.Page3) {
                            IconButton(
                                onClick = {
                                    chunithmViewModel.fetchSongData(context)
                                }
                            ) {
                                Icon(
                                    imageVector = Filled.Download,
                                    contentDescription = "Download Data",
                                    tint = Beige400
                                )
                            }
                        }
                        IconButton(
                            onClick = {
                                when (selectedItem) {
                                    Screen.Page1 -> showOsuDialog = true
                                    Screen.Page2 -> showMaimaiDialog = true
                                    Screen.Page3 -> showChunithmDialog = true
                                    Screen.Page4 -> { /* Action for Page 4 */ }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = when (selectedItem) {
                                    Screen.Page1 -> Icons.Default.Add
                                    Screen.Page2 -> Icons.Default.Edit
                                    Screen.Page3 -> Filled.ArrowRotate
                                    Screen.Page4 -> Icons.Default.Delete
                                },
                                contentDescription = "Action",
                                tint = Beige400
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
                        Screen.Page1 -> OsuUserPage(
                            showOsuDialog,
                            osuViewModel,
                            osuScreenState,
                            onDismissDialog = { showOsuDialog = false }
                        )

                        Screen.Page2 -> MaimaiUserPage(
                            showMaimaiDialog,
                            onDismissDialog = { showMaimaiDialog = false }
                        )

                        Screen.Page3 -> {
                            ChunithmNavHost(
                                navController = chunithmNavController,
                                viewModel = chunithmViewModel,
                                chuniScreenState = ChunithmScreenState(),
                                snackbarHostState = snackbarHostState,
                                showDialog = showChunithmDialog,
                                onDismissDialog = { showChunithmDialog = false }
                            )
                        }
                        Screen.Page4 -> TestPage4()
                    }
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
        fontFamily = sarasaFont,
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