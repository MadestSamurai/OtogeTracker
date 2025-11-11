package com.madsam.otora.data.chunithm.ui.model

data class ChunithmPlayRecordUiModel(
    val difficulty: String = "",
    val totalSongs: Int = 0, // 总曲目数（所有难度共享）
    
    // Rating statistics
    val rateSSSp: Int = 0, // SSS+ 达成数量
    val rateSSS: Int = 0,  // SSS 达成数量
    val rateSSp: Int = 0,  // SS+ 达成数量
    val rateSS: Int = 0,   // SS 达成数量
    val rateSp: Int = 0,   // S+ 达成数量
    val rateS: Int = 0,    // S 达成数量
    
    // Clear statistics
    val rateClear: Int = 0,   // Clear 达成数量
    val rateFC: Int = 0,      // Full Combo 达成数量
    val rateAJ: Int = 0,      // All Justice 达成数量
    val rateAJC: Int = 0,     // All Justice Critical 达成数量
    val rateFChain: Int = 0,  // Full Chain 达成数量
    val rateFChainP: Int = 0, // Full Chain Platinum 达成数量
    
    // Difficulty statistics
    val rateHard: Int = 0,    // Hard Clear 达成数量
    val rateBrave: Int = 0,   // Brave 达成数量
    val rateAbs: Int = 0,     // Absolute 达成数量
    val rateCatas: Int = 0,   // Catastrophe 达成数量
    
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
        val date: String = "",
        val trackNumber: String = "",
        val genreName: String = "",
        val difficulty: String = ""
    )
}


