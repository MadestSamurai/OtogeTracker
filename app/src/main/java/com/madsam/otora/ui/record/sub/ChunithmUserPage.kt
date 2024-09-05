package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.madsam.otora.entity.chuni.ChuniCard
import com.madsam.otora.ui.record.RecordViewModel
import com.madsam.otora.ui.record.chunithm.Card
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.ShareUtil

@Composable
fun ChunithmUserPage(recordViewModel: RecordViewModel) {
    val context = LocalContext.current
    val requestState = remember { mutableStateOf("") }
    val responseState = remember { mutableStateOf("") }
    val uaState = remember { mutableStateOf("") }
    val chuniCard = remember { mutableStateOf(ChuniCard()) }
    chuniCard.value = recordViewModel.getChuniCardFromShare(context)

    Column {
        TextField(
            value = requestState.value,
            onValueChange = { requestState.value = it },
            label = { Text("Input Request Cookies") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = responseState.value,
            onValueChange = { responseState.value = it },
            label = { Text("Input Response Cookies") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = uaState.value,
            onValueChange = { uaState.value = it },
            label = { Text("Input User-Agent") },
            modifier = Modifier.fillMaxWidth()
        )
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
            ShareUtil.putString("chuniUserAgent", uaState.value, context)
        }) {
            Text("Save Cookies")
        }
        Button(onClick = {
            recordViewModel.requestChuniData(context)
            println("Request Sent")
        }) {
            Text("Update Data")
        }
        Card(chuniCard = chuniCard.value)
    }
}