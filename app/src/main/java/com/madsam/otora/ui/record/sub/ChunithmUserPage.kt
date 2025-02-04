package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.madsam.otora.consts.BRIGHT_RED
import com.madsam.otora.model.chuni.net.ChuniGenre
import com.madsam.otora.ui.record.chunithm.AvatarLayout
import com.madsam.otora.ui.record.chunithm.Card
import com.madsam.otora.ui.record.chunithm.CookieDialog
import com.madsam.otora.ui.record.viewmodel.ChuniViewModel
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.JsonUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
    val chuniMasterRecord = remember { mutableStateOf(listOf<ChuniGenre>()) }
    val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    val scope = rememberCoroutineScope()

    val masterRecordListType = Types.newParameterizedType(List::class.java, ChuniGenre::class.java)
    val masterRecordJsonAdapter = moshi.adapter<List<ChuniGenre>>(masterRecordListType)
    val masterRecordJson = JsonUtil.readJsonFromFile(context, "chuniPlayRecordMaster.json")
    if (masterRecordJson != null) {
        chuniMasterRecord.value = masterRecordJsonAdapter.fromJson(masterRecordJson) ?: listOf()
    }

    var totalMasterScore = 0
    for (masterScore in chuniMasterRecord.value) {
        for (fullScore in masterScore.fullScoreList) {
            totalMasterScore += CommonUtils.bigNumberToInt(fullScore.score)
        }
    }

    LazyColumn(
        modifier = Modifier.background(color = BRIGHT_RED)
    ) {
        item {
            Button(onClick = { onNavigateToTopRating() }) {
                Text("Go to Top Rating")
            }
        }
        item {
            Button(onClick = { viewModel.requestChuniUserData(context) }) {
                Text("Update Data")
            }
        }
        item {
            Button(onClick = { viewModel.requestChuniSongData(context) }) {
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
            Card(chuniCard = viewModel.chuniCard)
        }
        item {
            Row {
                AvatarLayout(chuniAvatar = viewModel.chuniAvatar)
            }
        }
        item {
            Text(text = "Chunithm Master Record")
        }
        item {
            Text(text = "Total Master Score: $totalMasterScore")
        }
        item {
            Text(text = "Chunithm Record")
        }
    }

    if (showDialog) {
        CookieDialog(
            showDialog = remember { mutableStateOf(showDialog) },
            context = context,
            snackbarHostState = snackbarHostState,
            onResult = { success ->
                if (success) {
                    scope.launch {
                        snackbarHostState.showSnackbar("Cookies Saved")
                    }
                }
                onDismissDialog()
            }
        )
    }
}