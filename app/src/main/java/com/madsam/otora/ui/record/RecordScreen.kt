package com.madsam.otora.ui.record

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madsam.otora.fonts.sarasaFont
import com.madsam.otora.ui.record.chunithm.TopRating
import com.madsam.otora.ui.record.sub.ChunithmUserPage
import com.madsam.otora.ui.record.sub.MaimaiUserPage
import com.madsam.otora.ui.record.sub.OsuUserPage
import com.madsam.otora.ui.record.viewmodel.ChuniViewModel
import com.madsam.otora.ui.record.viewmodel.ChuniViewModelFactory
import com.madsam.otora.ui.record.viewmodel.OsuViewModel
import com.madsam.otora.ui.record.viewmodel.OsuViewModelFactory
import com.madsam.otora.ui.theme.Beige400
import com.madsam.otora.ui.theme.Beige500
import com.madsam.otora.ui.theme.Beige600
import com.madsam.otora.ui.theme.Red500
import com.madsam.otora.ui.theme.Red800
import com.madsam.otora.utils.ShareUtil
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
    var showChunithmTopRating by remember { mutableStateOf(false) }

    val osuViewModel: OsuViewModel = viewModel(
        factory = OsuViewModelFactory(
            userId = ShareUtil.getString("userId", context) ?: "2",
            mode = ShareUtil.getString("mode", context) ?: "osu",
            context = context
        )
    )
    val chuniViewModel: ChuniViewModel = viewModel(factory = ChuniViewModelFactory(context))

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
                                Screen.Page1 -> Icon(Icons.Default.Add, null)
                                Screen.Page2 -> Icon(Icons.Default.Edit, null)
                                Screen.Page3 -> Icon(Icons.Default.Share, null)
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
                        fontWeight = FontWeight.Bold
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
                    // Add action button based on selected item
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
                                Screen.Page3 -> Icons.Default.Share
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
                        onDismissDialog = { showOsuDialog = false }
                    )

                    Screen.Page2 -> MaimaiUserPage(
                        showMaimaiDialog,
                        onDismissDialog = { showMaimaiDialog = false }
                    )

                    Screen.Page3 -> {
                        Box(modifier = Modifier.fillMaxSize()) {
                            TopRating(
                                chuniTopRankUI = chuniViewModel.chuniTopRankUI,
                                onBack = { showChunithmTopRating = false }
                            )
                            ChunithmUserPage(
                                chuniViewModel,
                                onNavigateToTopRating = { showChunithmTopRating = true },
                                snackbarHostState = snackbarHostState,
                                showDialog = showChunithmDialog,
                                onDismissDialog = { showChunithmDialog = false }
                            )
                        }
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