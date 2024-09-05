package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.madsam.otora.utils.ShareUtil

@Composable
fun MaimaiUserPage() {
    val context = LocalContext.current
    val state = remember { mutableStateOf("init") }
    state.value = ShareUtil.getString("chuniCard", context) ?: "null"

    Column {
        Text(
            text = "Maimai User Page",
        )
        Text(text = state.value,
            modifier = Modifier.fillMaxSize()
        )
    }
}