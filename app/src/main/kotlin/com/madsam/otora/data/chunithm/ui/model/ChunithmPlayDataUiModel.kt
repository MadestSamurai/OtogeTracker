package com.madsam.otora.data.chunithm.ui.model

internal data class ChunithmPlayDataUiModel(
    var basicPlayData: ChunithmPlayDataItemUI = ChunithmPlayDataItemUI(),
    var advancedPlayData: ChunithmPlayDataItemUI = ChunithmPlayDataItemUI(),
    var expertPlayData: ChunithmPlayDataItemUI = ChunithmPlayDataItemUI(),
    var masterPlayData: ChunithmPlayDataItemUI = ChunithmPlayDataItemUI(),
    var ultimaPlayData: ChunithmPlayDataItemUI = ChunithmPlayDataItemUI()
) {
    internal data class ChunithmPlayDataItemUI(
        var scoreTotal: Long = 0,
        var totalSongs: Int = 0, // 总曲目数（所有难度共享）
        var rateSSSp: Int = 0, // SSS+ 达成数量
        var rateSSS: Int = 0,  // SSS 达成数量
        var rateSSp: Int = 0,  // SS+ 达成数量
        var rateSS: Int = 0,   // SS 达成数量
        var rateSp: Int = 0,   // S+ 达成数量
        var rateS: Int = 0,    // S 达成数量
        var rateFC: Int = 0,   // Full Combo 达成数量
        var rateAJ: Int = 0,   // All Justice 达成数量
        var rateAJC: Int = 0,  // All Justice Critical 达成数量
        var rateFChain: Int = 0,  // Full Chain 达成数量
        var rateFChainP: Int = 0, // Full Chain Platinum 达成数量
        var rateClear: Int = 0,   // Clear 达成数量
        var rateHard: Int = 0,    // Hard Clear 达成数量
        var rateBrave: Int = 0,   // Brave 达成数量
        var rateAbs: Int = 0,     // Absolute 达成数量
        var rateCatas: Int = 0,   // Catastrophe 达成数量
    )
}
