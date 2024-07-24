package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.madsam.otora.activity.MainActivity
import com.madsam.otora.service.FilePickerSource
import com.madsam.otora.ui.record.RecordUpdateViewModel
import com.madsam.otora.utils.ShareUtil

@Composable
fun ChunithmUserPage(recordUpdateViewModel: RecordUpdateViewModel) {
    val context = LocalContext.current
    val state = remember { mutableStateOf("init") }
    state.value = ShareUtil.getString("analysedText", context) ?: "null"

    LaunchedEffect(recordUpdateViewModel.isFilePicked()) {
        if (recordUpdateViewModel.isFilePicked()) {
            state.value = ShareUtil.getString("analysedText", context) ?: "null"
            println(state.value)
            recordUpdateViewModel.resetPickedFile()
        }
    }
    Column {
        Text(
            text = "Chunithm User Page",
        )
        Button(onClick = {
            (context as? MainActivity)?.pickFile(FilePickerSource.CHUNI_PLAYDATA_BUTTON)

        }) {
            Text("Pick Chunithm PlayData File")
        }
        Text(text = state.value)
    }
}