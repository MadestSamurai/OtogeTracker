package com.madsam.otora.ui.record.maimai.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun MaimaiCard(
    maimaiCardData: MutableStateFlow<Map<String, String>>,
) {
    val cardData = maimaiCardData.collectAsState(initial = emptyMap()).value
}