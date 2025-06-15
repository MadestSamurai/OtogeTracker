package com.madsam.otora.ui.record.chunithm.dialogs

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.ShareUtil
import kotlinx.coroutines.launch

@Composable
fun CookieDialog(
    context: Context,
    snackbarHostState: SnackbarHostState,
    onResult: (Boolean) -> Unit,
    onDismiss: () -> Unit
) {
    val requestState = remember { mutableStateOf("") }
    val responseState = remember { mutableStateOf("") }
    val uaState = remember { mutableStateOf("") }

    val requestError = remember { mutableStateOf(false) }
    val responseError = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Enter Cookies") },
        text = {
            Column {
                TextField(
                    value = requestState.value,
                    onValueChange = {
                        requestState.value = it
                        requestError.value = it.isEmpty()
                    },
                    label = { Text("Enter Request Cookies") },
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
                    label = { Text("Enter Response Cookies") },
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
                    label = { Text("Enter User-Agent") },
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
                ShareUtil.putString("chuniToken", responseCookieMap["_t"] ?: "", context)
                ShareUtil.putString("chuniUserId", requestCookieMap["userId"] ?: "", context)
                ShareUtil.putString("chuniFriendCodeList", requestCookieMap["friendCodeList"] ?: "", context)
                ShareUtil.putString("chuniExpires", responseCookieMap["expires"] ?: "", context)
                ShareUtil.putString("chuniMaxAge", responseCookieMap["Max-Age"] ?: "", context)
                ShareUtil.putString("chuniPath", responseCookieMap["path"] ?: "", context)
                ShareUtil.putString("chuniSameSite", responseCookieMap["SameSite"] ?: "", context)
                ShareUtil.putString("chuniGa", requestCookieMap["_ga"] ?: "", context)
                val gaCount = requestCookieMap.count { it.key.startsWith("_ga_") }
                if (gaCount == 1) {
                    val entry = requestCookieMap.entries.first { it.key.startsWith("_ga_") }
                    ShareUtil.putString("chuniGaKey", entry.key, context)
                    ShareUtil.putString("chuniGaValue", entry.value, context)
                }
                onResult(true)
            }) {
                Text("Save Cookies")
            }
        },
        dismissButton = {
            Button(onClick = { onResult(false) }) {
                Text("Cancel")
            }
        }
    )
}