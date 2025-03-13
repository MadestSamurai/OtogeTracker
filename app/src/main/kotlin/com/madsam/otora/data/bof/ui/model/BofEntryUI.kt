package com.madsam.otora.data.bof.ui.model

internal data class BofEntryUI(
    override var oldIndex: Int,
    override var index: Int,
    var team: String = "",
    var artist: String = "",
    var genre: String = "",
    var title: String = "",
    var regist: String = "",
    var update: String = "",
    var impr: Int = 0,
    var total: Int = 0,
    var median: Double = 0.0,
    var avg: Double = 0.0,
    var oldImpr: Int = 0,
    var oldTotal: Int = 0,
    var oldMedian: Double = 0.0,
    var oldAvg: Double = 0.0,
    var time: String = "",
    var rankDiff: Int = 0,
    var imprDiff: Int = 0,
    var totalDiff: Int = 0,
    var medianRank: Int = 0,
    var medianDiff: Int = 0,
    var avgRank: Int = 0,
    var avgDiff: Int = 0,
    var div: Int = 0
) : Rankable
