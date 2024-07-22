package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madsam.otora.consts.Colors
import com.madsam.otora.ui.record.RecordViewModel
import com.madsam.otora.ui.record.RecordViewModelFactory
import com.madsam.otora.ui.record.osu.OsuCard
import com.madsam.otora.ui.record.osu.OsuLevel
import com.madsam.otora.ui.record.osu.OsuPlayData
import com.madsam.otora.ui.record.osu.OsuRankGraph

@Composable
fun OsuUserPage() {
    val context = LocalContext.current
    val recordViewModel: RecordViewModel = viewModel(factory = RecordViewModelFactory(
        userId = "10351684",
        mode = "mania",
        context = context
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