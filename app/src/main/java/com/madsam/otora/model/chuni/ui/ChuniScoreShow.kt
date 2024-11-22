package com.madsam.otora.model.chuni.ui

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.model.chuni.ui.ChuniScoreShow
 * 创建者: MadSamurai
 * 创建时间: 2024/11/20
 * 描述: TODO
 */
data class ChuniScoreShow (
    var title : String = "",
    var artist : String = "",
    var noteDesigner: String = "",
    var genre : String = "",
    var diff : String = "",
    var level: String = "",
    var levelValue: Double = 0.0,
    var score : String = "",
    var isClear : Boolean = false,
    var isFullCombo : Boolean = false,
    var isAllJustice : Boolean = false,
    var isAJC : Boolean = false,
    var isFullChain : Boolean = false,
    var isFullJChain : Boolean = false,
    var rank : String = "",
    var jacket : String = "",
    var date : String = "",
    var trackNumber: String = "",
    var tap: Int = 0,
    var hold: Int = 0,
    var slide: Int = 0,
    var air: Int = 0,
    var flick: Int = 0,
    var total: Int = 0
)