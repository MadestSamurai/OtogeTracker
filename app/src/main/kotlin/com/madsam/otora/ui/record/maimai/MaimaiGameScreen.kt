package com.madsam.otora.ui.record.maimai

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.fa.`Chevron-left`
import com.madsam.otora.core.icon.fa.Cog
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.utils.ScreenUtil
import com.madsam.otora.ui.settings.SettingsActivity

/**
 * Maimai 游戏全屏页面
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaimaiGameScreen(
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    var showMaimaiDialog by remember { mutableStateOf(false) }
    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()
    val colorScheme = MaterialTheme.colorScheme

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "maimai",
                        fontFamily = sarasaBold,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Fa.`Chevron-left`,
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
                            imageVector = Fa.Cog,
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
                .windowInsetsPadding(
                    WindowInsets.displayCutout.only(
                        if (useNavigationRail) {
                            WindowInsetsSides.End
                        } else {
                            WindowInsetsSides.Horizontal
                        }
                    )
                )
                .windowInsetsPadding(
                    if (useNavigationRail) {
                        WindowInsets.navigationBars.only(WindowInsetsSides.Bottom)
                    } else {
                        WindowInsets(0, 0, 0, 0)
                    }
                )
        ) {
            MaimaiUserPage(
                showDialog = showMaimaiDialog,
                onDismissDialog = { showMaimaiDialog = false }
            )
        }
    }
}
