package com.madsam.otora.ui.record.chunithm.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.data.chunithm.ui.model.ChunithmTopRankUiModel
import com.madsam.otora.ui.record.chunithm.components.TopRating
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun TopRankDialog(
    chunithmTopRankUiModel: MutableStateFlow<ChunithmTopRankUiModel>,
    onDismiss: () -> Unit
) {
    val screenHeightDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.height.toDp()
    }
    
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeightDp * 0.9f)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Red300
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Red300)
            ) {
                TopRating(
                    chunithmTopRankUiModel = chunithmTopRankUiModel,
                    onBack = onDismiss
                )
            }
        }
    }
}
