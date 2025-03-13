package com.madsam.otora.data.chunithm.remote.model

internal data class ChuniPlayRecordDTO(
    var rateSSSp: Pair<Int, Int> = Pair(0, 0), // FIXME: 总曲目数冗余，待优化
    var rateSSS: Pair<Int, Int> = Pair(0, 0),
    var rateSSp: Pair<Int, Int> = Pair(0, 0),
    var rateSS: Pair<Int, Int> = Pair(0, 0),
    var rateSp: Pair<Int, Int> = Pair(0, 0),
    var rateS: Pair<Int, Int> = Pair(0, 0),
    var rateFC: Pair<Int, Int> = Pair(0, 0),
    var rateAJ: Pair<Int, Int> = Pair(0, 0),
    var rateAJC: Pair<Int, Int> = Pair(0, 0),
    var rateFChain: Pair<Int, Int> = Pair(0, 0),
    var rateFChainP: Pair<Int, Int> = Pair(0, 0),
    var rateClear: Pair<Int, Int> = Pair(0, 0),
    var rateHard: Pair<Int, Int> = Pair(0, 0),
    var rateAbs: Pair<Int, Int> = Pair(0, 0),
    var rateAbsP: Pair<Int, Int> = Pair(0, 0),
    var rateCatas: Pair<Int, Int> = Pair(0, 0),
    var genreList: List<ChuniGenreDTO> = listOf()
)