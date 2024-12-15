package com.madsam.otora.ui.record.chunithm

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.ShareUtil
import kotlinx.coroutines.launch

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.chunithm.CookieDialog
 * 创建者: MadSamurai
 * 创建时间: 2024/12/12
 * 描述: Cookie对话框
 */
@Composable
fun CookieDialog(
    showDialog: MutableState<Boolean>,
    context: Context,
    snackbarHostState: SnackbarHostState,
    onResult: (Boolean) -> Unit
) {
    val requestState = remember { mutableStateOf("") }
    val responseState = remember { mutableStateOf("") }
    val uaState = remember { mutableStateOf("") }

    val requestError = remember { mutableStateOf(false) }
    val responseError = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    AlertDialog(
        onDismissRequest = { showDialog.value = false },
        title = { Text("Input Cookies") },
        text = {
            Column {
                TextField(
                    value = requestState.value,
                    onValueChange = {
                        requestState.value = it
                        requestError.value = it.isEmpty()
                    },
                    label = { Text("Input Request Cookies") },
                    isError = requestError.value,
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        errorContainerColor = Color.Transparent
                    )
                )
                if (requestError.value) {
                    Text("Request Cookies cannot be empty", color = MaterialTheme.colorScheme.error)
                }
                TextField(
                    value = responseState.value,
                    onValueChange = {
                        responseState.value = it
                        responseError.value = it.isEmpty()
                    },
                    label = { Text("Input Response Cookies") },
                    isError = responseError.value,
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        errorContainerColor = Color.Transparent
                    )
                )
                if (responseError.value) {
                    Text("Response Cookies cannot be empty", color = MaterialTheme.colorScheme.error)
                }
                TextField(
                    value = uaState.value,
                    onValueChange = { uaState.value = it },
                    label = { Text("Input User-Agent") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        errorContainerColor = Color.Transparent
                    )
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                requestError.value = requestState.value.isEmpty()
                responseError.value = responseState.value.isEmpty()
                if (requestError.value || responseError.value) {
                    return@Button
                }
                val requestCookieMap = CommonUtils.parseCookie(requestState.value)
                val responseCookieMap = CommonUtils.parseCookie(responseState.value)
                if (requestCookieMap.isEmpty() || responseCookieMap.isEmpty()) {
                    scope.launch {
                        snackbarHostState.showSnackbar("Invalid Cookies")
                    }
                    return@Button
                }
                ShareUtil.putString("chuniToken", requestCookieMap["_t"] ?: "", context)
                ShareUtil.putString("chuniUserId", requestCookieMap["userId"] ?: "", context)
                ShareUtil.putString("chuniFriendCodeList", requestCookieMap["friendCodeList"] ?: "", context)
                ShareUtil.putString("chuniExpires", responseCookieMap["expires"] ?: "", context)
                ShareUtil.putString("chuniMaxAge", responseCookieMap["Max-Age"] ?: "", context)
                ShareUtil.putString("chuniPath", responseCookieMap["path"] ?: "", context)
                ShareUtil.putString("chuniSameSite", responseCookieMap["SameSite"] ?: "", context)
                onResult(true)
                showDialog.value = false
            }) {
                Text("Save Cookies")
            }
        },
        dismissButton = {
            Button(onClick = {
                onResult(false)
                showDialog.value = false
            }) {
                Text("Cancel")
            }
        }
    )
}