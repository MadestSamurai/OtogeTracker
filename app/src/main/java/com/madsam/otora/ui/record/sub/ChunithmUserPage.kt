package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.madsam.otora.consts.Colors
import com.madsam.otora.entity.chunithm.ChuniSheetsEntity
import com.madsam.otora.entity.chunithm.ChuniSongsEntity
import com.madsam.otora.model.chuni.net.ChuniCard
import com.madsam.otora.model.chuni.net.ChuniFullScore
import com.madsam.otora.model.chuni.net.ChuniGenre
import com.madsam.otora.model.chuni.net.ChuniScore
import com.madsam.otora.service.ChuniDataRequestService
import com.madsam.otora.ui.record.RecordViewModel
import com.madsam.otora.ui.record.chunithm.Card
import com.madsam.otora.ui.record.chunithm.TopRating
import com.madsam.otora.utils.CalcUtils
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.JsonUtil
import com.madsam.otora.utils.ShareUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@Composable
fun ChunithmUserPage(recordViewModel: RecordViewModel) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val requestState = remember { mutableStateOf("") }
    val responseState = remember { mutableStateOf("") }
    val uaState = remember { mutableStateOf("") }
    val chuniCard = remember { mutableStateOf(ChuniCard()) }

    val chuniMasterRecord = remember { mutableStateOf(listOf<ChuniGenre>()) }
    val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    chuniCard.value = recordViewModel.getChuniCardFromShare(context)
    recordViewModel.requestChuniSongData(context)

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
            TextField(
                value = requestState.value,
                onValueChange = { requestState.value = it },
                label = { Text("Input Request Cookies") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            TextField(
                value = responseState.value,
                onValueChange = { responseState.value = it },
                label = { Text("Input Response Cookies") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            TextField(
                value = uaState.value,
                onValueChange = { uaState.value = it },
                label = { Text("Input User-Agent") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            Button(onClick = {
                if (requestState.value.isEmpty() || responseState.value.isEmpty()) {
                    return@Button
                }
                val requestCookieMap = CommonUtils.parseCookie(requestState.value)
                val responseCookieMap = CommonUtils.parseCookie(responseState.value)
                ShareUtil.putString("chuniToken", requestCookieMap["_t"] ?: "", context)
                ShareUtil.putString("chuniUserId", requestCookieMap["userId"] ?: "", context)
                ShareUtil.putString("chuniFriendCodeList", requestCookieMap["friendCodeList"] ?: "", context)
                ShareUtil.putString("chuniExpires", responseCookieMap["expires"] ?: "", context)
                ShareUtil.putString("chuniMaxAge", responseCookieMap["Max-Age"] ?: "", context)
                ShareUtil.putString("chuniPath", responseCookieMap["path"] ?: "", context)
                ShareUtil.putString("chuniSameSite", responseCookieMap["SameSite"] ?: "", context)
                if (uaState.value.isNotEmpty()) {
                    ShareUtil.putString("chuniUserAgent", uaState.value, context)
                }
            }) {
                Text("Save Cookies")
            }
        }
        item {
            Button(onClick = {
                recordViewModel.requestChuniUserData(context)
                println("Request Sent")
            }) {
                Text("Update Data")
            }
        }
        item {
            Card(chuniCard = chuniCard.value)
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
        item {
            TopRating()
        }
    }
}