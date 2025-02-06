package com.madsam.otora.model.chuni.ui

data class ChuniPlayDataUI(
    var basicPlayData: ChuniPlayDataItemUI = ChuniPlayDataItemUI(),
    var advancedPlayData: ChuniPlayDataItemUI = ChuniPlayDataItemUI(),
    var expertPlayData: ChuniPlayDataItemUI = ChuniPlayDataItemUI(),
    var masterPlayData: ChuniPlayDataItemUI = ChuniPlayDataItemUI(),
    var ultimaPlayData: ChuniPlayDataItemUI = ChuniPlayDataItemUI()
) {
    data class ChuniPlayDataItemUI(
        var scoreTotal: Long = 0,
        var divisionSSS: Pair<Int, Int> = Pair(0, 0),
        var divisionSSp: Pair<Int, Int> = Pair(0, 0),
        var divisionSS: Pair<Int, Int> = Pair(0, 0),
        var divisionSp: Pair<Int, Int> = Pair(0, 0),
        var divisionS: Pair<Int, Int> = Pair(0, 0),
        var divisionAJ: Pair<Int, Int> = Pair(0, 0),
        var divisionFC: Pair<Int, Int> = Pair(0, 0)
    )
}
