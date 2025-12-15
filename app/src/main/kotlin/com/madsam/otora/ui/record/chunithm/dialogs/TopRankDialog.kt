package com.madsam.otora.ui.record.chunithm.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.material3.MaterialTheme
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.data.chunithm.ui.model.ChunithmTopRankUiModel
import com.madsam.otora.ui.record.chunithm.components.TopRankCaptureDialog
import com.madsam.otora.ui.record.chunithm.components.TopRating
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun TopRankDialog(
    chunithmTopRankUiModel: MutableStateFlow<ChunithmTopRankUiModel>,
    snackbarHostState: SnackbarHostState,
    onDismiss: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val screenHeightDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.height.toDp()
    }
    
    val context = LocalContext.current
    val showCaptureDialog = remember { mutableStateOf(false) }
    
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
                containerColor = colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorScheme.surface)
            ) {
                TopRating(
                    chunithmTopRankUiModel = chunithmTopRankUiModel,
                    onBack = onDismiss
                )
                
                // 截图按钮
                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                ) {
                    Icon(
                        painter = rememberVectorPainter(image = Filled.Picture),
                        contentDescription = "Capture",
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                showCaptureDialog.value = true
                            }
                    )
                }
            }
        }
    }
    
    // 截图对话框
    TopRankCaptureDialog(
        showDialog = showCaptureDialog,
        context = context,
        snackbarHostState = snackbarHostState,
        chunithmTopRankUiModel = chunithmTopRankUiModel
    )
}
