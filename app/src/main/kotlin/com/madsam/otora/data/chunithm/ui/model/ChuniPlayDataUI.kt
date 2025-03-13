package com.madsam.otora.data.chunithm.ui.model

internal data class ChuniPlayDataUI(
    var basicPlayData: ChuniPlayDataItemUI = ChuniPlayDataItemUI(),
    var advancedPlayData: ChuniPlayDataItemUI = ChuniPlayDataItemUI(),
    var expertPlayData: ChuniPlayDataItemUI = ChuniPlayDataItemUI(),
    var masterPlayData: ChuniPlayDataItemUI = ChuniPlayDataItemUI(),
    var ultimaPlayData: ChuniPlayDataItemUI = ChuniPlayDataItemUI()
) {
    internal data class ChuniPlayDataItemUI(
        var scoreTotal: Long = 0,
        var rateSSSp: Pair<Int, Int> = Pair(0, 0), // SSS+评级数/总曲目数
        var rateSSS: Pair<Int, Int> = Pair(0, 0),  // SSS评级数/总曲目数
        var rateSSp: Pair<Int, Int> = Pair(0, 0),  // SS+评级数/总曲目数
        var rateSS: Pair<Int, Int> = Pair(0, 0),   // SS评级数/总曲目数
        var rateSp: Pair<Int, Int> = Pair(0, 0),   // S+评级数/总曲目数
        var rateS: Pair<Int, Int> = Pair(0, 0),    // S评级数/总曲目数
        var rateFC: Pair<Int, Int> = Pair(0, 0),   // FC数/总曲目数
        var rateAJ: Pair<Int, Int> = Pair(0, 0),   // AJ数/总曲目数
        var rateAJC: Pair<Int, Int> = Pair(0, 0),  // AJC数/总曲目数
        var rateFChain: Pair<Int, Int> = Pair(0, 0), // FChain数/总曲目数
        var rateFChainP: Pair<Int, Int> = Pair(0, 0), // FChainP数/总曲目数
        var rateClear: Pair<Int, Int> = Pair(0, 0), // Clear数/总曲目数
        var rateHard: Pair<Int, Int> = Pair(0, 0), // Hard数/总曲目数
        var rateAbs: Pair<Int, Int> = Pair(0, 0), // Abs数/总曲目数
        var rateAbsP: Pair<Int, Int> = Pair(0, 0), // AbsP数/总曲目数
        var rateCatas: Pair<Int, Int> = Pair(0, 0), // Catas数/总曲目数
    )
}
