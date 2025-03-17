package com.madsam.otora.data.chunithm.ui.model

internal data class ChunithmTopRankUiModel(
    var best30: Double = 0.0,
    var recent10: Double = 0.0,
    var suggest10: Double = 0.0,
    var bestList: List<ChunithmScoreUiModel> = listOf(),
    var recentList: List<ChunithmScoreUiModel> = listOf(),
    var suggestList: List<ChunithmScoreUiModel> = listOf()
)
