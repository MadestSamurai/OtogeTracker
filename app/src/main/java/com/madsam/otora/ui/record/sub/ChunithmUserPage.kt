package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.madsam.otora.consts.BRIGHT_RED
import com.madsam.otora.ui.record.chunithm.AvatarLayout
import com.madsam.otora.ui.record.chunithm.Card
import com.madsam.otora.ui.record.chunithm.CookieDialog
import com.madsam.otora.ui.record.chunithm.PlayDataList
import com.madsam.otora.ui.record.viewmodel.ChuniViewModel
import kotlinx.coroutines.launch

@Composable
fun ChunithmUserPage(
    viewModel: ChuniViewModel,
    onNavigateToTopRating: () -> Unit,
    snackbarHostState: SnackbarHostState,
    showDialog: Boolean,
    onDismissDialog: () -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp

    LazyColumn(
        modifier = Modifier
            .background(color = BRIGHT_RED)
            .fillMaxSize()
    ) {
        item {
            Button(onClick = { onNavigateToTopRating() }) {
                Text("Go to Top Rating")
            }
        }
        item {
            Button(onClick = {
                viewModel.fetchUserData(context)
                viewModel.loadData(context)
            }) {
                Text("Update Data")
            }
        }
        item {
            Button(onClick = {
                viewModel.fetchSongData(context)
                viewModel.loadData(context)
            }) {
                Text("Update Song Data")
            }
        }
//        item {
//            Button(onClick = {
//                val realmConfig = RealmConfiguration.Builder(
//                    schema = setOf(
//                        ChuniSongsEntity::class,
//                        ChuniSheetsEntity::class,
//                    )
//                )
//                    .name("otoge-tracker-chuni.realm")
//                    .schemaVersion(1)
//                    .build()
//                val filePath = "${context.filesDir}/"
//                exportChuniSongsToCSV(realmConfig, filePath, "chuniSongs.csv", "chuniSheets.csv")
//            }) {
//                Text("Export to CSV")
//            }
//        }
        item {
            Card(viewModel.chuniCardUI)
        }
        item {
            Row {
                AvatarLayout(viewModel.chuniAvatarUI) // width: 224, height: 264
                val playDataWidth = screenWidthDp - 224.dp - 24.dp - 12.dp
                PlayDataList(
                    width = playDataWidth,
                    chuniPlayDataUI = viewModel.chuniPlayDataUI
                )
            }
        }
    }

    if (showDialog) {
        CookieDialog(
            context = context,
            snackbarHostState = snackbarHostState,
            onResult = { success ->
                if (success) {
                    scope.launch {
                        snackbarHostState.showSnackbar("Cookies Saved")
                    }
                }
                onDismissDialog()
            },
            onDismiss = onDismissDialog
        )
    }
}