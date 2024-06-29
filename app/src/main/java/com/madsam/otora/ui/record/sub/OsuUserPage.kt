package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madsam.otora.consts.Colors
import com.madsam.otora.ui.record.RecordViewModel
import com.madsam.otora.ui.record.RecordViewModelFactory
import com.madsam.otora.ui.record.cards.OsuCard
import com.madsam.otora.ui.record.cards.OsuLevel
import com.madsam.otora.ui.record.cards.OsuPlayData
import com.madsam.otora.ui.record.cards.OsuRankGraph

@Composable
fun OsuUserPage() {
    val recordViewModel: RecordViewModel = viewModel(factory = RecordViewModelFactory(
        userId = "10351684",
        mode = "mania"
    )
    )
    LazyColumn(
        modifier = Modifier
            .background(color = Colors.BRIGHT_RED)
    ) {
        item {
            OsuCard(osuCardData = recordViewModel.osuCardData, osuGroupList = recordViewModel.osuGroupList)
        }
        item {
            OsuRankGraph(osuRankGraphData = recordViewModel.osuRankGraphData, osuRankHighestData = recordViewModel.osuRankHighestData)
        }
        item {
            OsuLevel(osuLevelData = recordViewModel.osuLevelData)
        }
        item {
            OsuPlayData(osuPlayData = recordViewModel.osuPlayData)
        }
    }
}