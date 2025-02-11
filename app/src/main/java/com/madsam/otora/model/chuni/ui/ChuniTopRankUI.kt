package com.madsam.otora.model.chuni.ui

data class ChuniTopRankUI(
    var best30: Double = 0.0,
    var recent10: Double = 0.0,
    var suggest10: Double = 0.0,
    var bestList: List<ChuniScoreUI> = listOf(),
    var recentList: List<ChuniScoreUI> = listOf(),
    var suggestList: List<ChuniScoreUI> = listOf()
)
