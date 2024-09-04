package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.madsam.otora.activity.MainActivity
import com.madsam.otora.service.FilePickerSource
import com.madsam.otora.ui.record.RecordViewModel
import com.madsam.otora.utils.ShareUtil

@Composable
fun MaimaiUserPage(recordViewModel: RecordViewModel) {
    val context = LocalContext.current
    val state = remember { mutableStateOf("init") }
    state.value = ShareUtil.getString("chuniCard", context) ?: "null"

    LaunchedEffect(recordViewModel.isFilePicked()) {
        if (recordViewModel.isFilePicked()) {
            state.value = ShareUtil.getString("chuniCard", context) ?: "null"
            println(state.value)
            recordViewModel.resetPickedFile()
        }
    }
    Column {
        Text(
            text = "Maimai User Page",
        )
        Button(onClick = {
            (context as? MainActivity)?.pickFile(FilePickerSource.BUTTON2)

        }) {
            Text("Pick a File")
        }
        Text(text = state.value,
            modifier = Modifier.fillMaxSize()
        )
    }
}