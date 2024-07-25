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
import com.madsam.otora.ui.record.RecordViewModel
import com.madsam.otora.ui.record.chunithm.ChuniCard
import com.madsam.otora.entity.chuni.ChuniCard

@Composable
fun ChunithmUserPage(recordViewModel: RecordViewModel) {
    val context = LocalContext.current
    val chuniCard = remember { mutableStateOf(ChuniCard()) }
    chuniCard.value = recordViewModel.getChuniCardFromShare(context)

    LaunchedEffect(recordViewModel.isFilePicked()) {
        if (recordViewModel.isFilePicked()) {
            chuniCard.value = recordViewModel.getChuniCardFromShare(context)
            recordViewModel.resetPickedFile()
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
        ChuniCard(chuniCard = chuniCard.value)
    }
}