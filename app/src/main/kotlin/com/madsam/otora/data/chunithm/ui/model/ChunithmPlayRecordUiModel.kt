package com.madsam.otora.data.chunithm.ui.model

data class ChunithmPlayRecordUiModel(
    val difficulty: String = "",
    
    // Rating statistics
    val rateSSSp: Pair<Int, Int> = Pair(0, 0),
    val rateSSS: Pair<Int, Int> = Pair(0, 0),
    val rateSSp: Pair<Int, Int> = Pair(0, 0),
    val rateSS: Pair<Int, Int> = Pair(0, 0),
    val rateSp: Pair<Int, Int> = Pair(0, 0),
    val rateS: Pair<Int, Int> = Pair(0, 0),
    
    // Clear statistics
    val rateClear: Pair<Int, Int> = Pair(0, 0),
    val rateFC: Pair<Int, Int> = Pair(0, 0),
    val rateAJ: Pair<Int, Int> = Pair(0, 0),
    val rateAJC: Pair<Int, Int> = Pair(0, 0),
    val rateFChain: Pair<Int, Int> = Pair(0, 0),
    val rateFChainP: Pair<Int, Int> = Pair(0, 0),
    
    // Difficulty statistics
    val rateHard: Pair<Int, Int> = Pair(0, 0),
    val rateAbs: Pair<Int, Int> = Pair(0, 0),
    val rateAbsP: Pair<Int, Int> = Pair(0, 0),
    val rateCatas: Pair<Int, Int> = Pair(0, 0),
    
    val lastUpdated: String = "",
    val scores: List<ChunithmFullScoreUiModel> = emptyList()
) {
    data class ChunithmFullScoreUiModel(
        val songId: String = "",
        val title: String = "",
        val diff: String = "",
        val score: Int = 0,
        val genre: String = "",
        val clear: String = "",
        val combo: String = "",
        val chain: String = "",
        val rank: Int = -1,
        val jacket: String = "",
        val date: String = "",
        val trackNumber: String = "",
        val genreName: String = "",
        val difficulty: String = ""
    )
}


