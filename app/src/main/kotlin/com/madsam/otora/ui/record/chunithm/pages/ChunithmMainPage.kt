package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.components.AvatarLayout
import com.madsam.otora.ui.record.chunithm.components.Card
import com.madsam.otora.ui.record.chunithm.components.FriendList
import com.madsam.otora.ui.record.chunithm.components.PlayDataList
import com.madsam.otora.ui.record.chunithm.components.TopRank

@Composable
internal fun ChunithmMainPage(
    viewModel: ChunithmViewModel,
    scrollThreshold: Float,
    setIsTabRowVisible: (Boolean) -> Unit,
    onNavigateToTopRating: () -> Unit,
) {
    val screenWidthDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }

    LazyColumn(
        modifier = Modifier
            .background(color = Red300)
            .fillMaxSize()
            .nestedScroll(object : NestedScrollConnection {
                private var totalScroll = 0f

                override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                    totalScroll += available.y
                    if (totalScroll < -scrollThreshold) {
                        setIsTabRowVisible(false)
                        totalScroll = 0f
                    } else if (totalScroll > scrollThreshold) {
                        setIsTabRowVisible(true)
                        totalScroll = 0f
                    }
                    return Offset.Zero
                }
            })
    ) {
        item {
            Card(viewModel.chunithmCardUiModel)
        }
        item {
            Box(
                modifier = Modifier.clickable {
                    onNavigateToTopRating()
                }
            ) {
                TopRank(viewModel.chunithmTopRankUiModel)
            }
        }
        item {
            Row {
                AvatarLayout(viewModel.chunithmAvatarUiModel)
                val playDataWidth = screenWidthDp - 224.dp - 24.dp - 12.dp
                PlayDataList(
                    width = playDataWidth,
                    chunithmPlayDataUiModel = viewModel.chunithmPlayDataUiModel
                )
            }
        }
        item {
            FriendList(viewModel.chuniFriendDataUI)
        }
    }
}