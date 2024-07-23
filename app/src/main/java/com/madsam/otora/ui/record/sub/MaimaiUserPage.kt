package com.madsam.otora.ui.record.sub

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.madsam.otora.ui.record.RecordUpdateViewModel
import com.madsam.otora.activity.MainActivity
import com.madsam.otora.service.FilePickerSource
import com.madsam.otora.utils.ShareUtil

@Composable
fun MaimaiUserPage(recordUpdateViewModel: RecordUpdateViewModel) {
    val context = LocalContext.current
    val state = remember { mutableStateOf("init") }
    state.value = ShareUtil.getString("analysedText", context) ?: "null"

    LaunchedEffect(recordUpdateViewModel.filePicked.value) {
        if (recordUpdateViewModel.filePicked.value) {
            state.value = ShareUtil.getString("analysedText", context) ?: "null"
            println(state.value)
            recordUpdateViewModel.filePicked.value = false
        }
    }
    Text(
        text = "Maimai User Page",
    )
    Button(onClick = {
        (context as? MainActivity)?.pickFile(FilePickerSource.HOME_BUTTON)

    }) {
        Text("Pick a File")
    }
    Text(text = state.value)
}