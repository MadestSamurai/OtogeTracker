package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.madsam.otora.consts.Colors
import com.madsam.otora.model.chuni.net.ChuniCard
import com.madsam.otora.model.chuni.net.ChuniGenre
import com.madsam.otora.ui.record.chunithm.Card
import com.madsam.otora.ui.record.chunithm.CookieDialog
import com.madsam.otora.ui.record.viewmodel.ChuniViewModel
import com.madsam.otora.ui.record.viewmodel.ChuniViewModelFactory
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.JsonUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Composable
fun ChunithmUserPage(
    navController: NavController,
    snackbarHostState: SnackbarHostState
) {
    val context = LocalContext.current

    val chuniViewModel: ChuniViewModel = viewModel(factory = ChuniViewModelFactory())
    val showDialog = remember { mutableStateOf(false) }
    val chuniCard = MutableStateFlow(ChuniCard())
    val chuniMasterRecord = remember { mutableStateOf(listOf<ChuniGenre>()) }
    val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        chuniCard.value = chuniViewModel.getChuniCardFromShare(context)
    }

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
        modifier = Modifier.background(color = Colors.BRIGHT_RED)
    ) {
        item {
            Button(onClick = { showDialog.value = true }) {
                Text("Input Cookies")
            }
        }
        item {
            Button(onClick = {
                chuniViewModel.requestChuniUserData(context) {
                    chuniCard.update { chuniViewModel.getChuniCardFromShare(context) }
                }
            }) {
                Text("Update Data")
            }
        }
        item {
            Button(onClick = {
                    chuniViewModel.requestChuniSongData(context) {
                        chuniCard.update { chuniViewModel.getChuniCardFromShare(context) }
                    }
                }
            ) {
                Text("Update Song Data")
            }
        }
        item {
            Button(onClick = {
                navController.navigate("topRating")
            }) {
                Text("Go to Top Rating")
            }
        }
        item {
            Card(chuniCard = chuniCard)
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

    if (showDialog.value) {
        CookieDialog(
            showDialog = showDialog,
            context = context,
            snackbarHostState = snackbarHostState,
            onResult = { success ->
                if (success) {
                    scope.launch {
                        snackbarHostState.showSnackbar("Cookies Saved")
                    }
                }
            }
        )
    }
}