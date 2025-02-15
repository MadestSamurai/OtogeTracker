package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.madsam.otora.ui.record.chunithm.AvatarLayout
import com.madsam.otora.ui.record.chunithm.Card
import com.madsam.otora.ui.record.chunithm.CookieDialog
import com.madsam.otora.ui.record.chunithm.FriendList
import com.madsam.otora.ui.record.chunithm.PlayDataList
import com.madsam.otora.ui.record.chunithm.TopRank
import com.madsam.otora.ui.record.viewmodel.ChuniViewModel
import com.madsam.otora.ui.theme.Red300
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
            .background(color = Red300)
            .fillMaxSize()
    ) {
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
            Box(
                modifier = Modifier.clickable {
                    onNavigateToTopRating()
                }
            ) {
                TopRank(viewModel.chuniTopRankUI)
            }
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
        item {
            FriendList(viewModel.chuniFriendDataUI)
        }
    }

    if (showDialog) {
        CookieDialog(
            context = context,
            snackbarHostState = snackbarHostState,
            onResult = { success ->
                if (success) {
                    scope.launch {
                        viewModel.fetchUserData(context)
                        viewModel.loadData(context)
                        snackbarHostState.showSnackbar("Cookies Saved")
                    }
                }
                onDismissDialog()
            },
            onDismiss = onDismissDialog
        )
    }
}