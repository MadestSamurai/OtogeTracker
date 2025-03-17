package com.madsam.otora.data.chunithm.ui.model

internal data class ChunithmScoreUiModel(
    var title: String = "",
    var artist: String = "",
    var noteDesigner: String = "",
    var genre: String = "",
    var diff: String = "",
    var level: String = "",
    var levelValue: Double = 0.0,
    var score: String = "",
    var rating: Double = 0.0,
    var isClear: Boolean = false,
    var isFullCombo: Boolean = false,
    var isAllJustice: Boolean = false,
    var isAJC: Boolean = false,
    var isFullChain: Boolean = false,
    var isFullJChain: Boolean = false,
    var rank: String = "",
    var jacket: String = "",
    var date: String = "",
    var trackNumber: String = "",
    var tap: Int = 0,
    var hold: Int = 0,
    var slide: Int = 0,
    var air: Int = 0,
    var flick: Int = 0,
    var total: Int = 0
)