package com.madsam.otora.ui.record.maimai

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun MaimaiUserPage(
    showDialog: Boolean,
    onDismissDialog: () -> Unit
) {
    val context = LocalContext.current

    Column {
        Text(
            text = "Maimai User Page",
        )
    }
}