package com.madsam.otora.model.chuni

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.chuni.ChuniFullScore
 * 创建者: MadSamurai
 * 创建时间: 2024/9/17
 * 描述: 中二节奏完整成绩
 */
data class ChuniFullScore(
    var id : String = "",
    var title : String = "",
    var genre : String = "",
    var diff : String = "",
    var token : String = "",
    var score : String = "",
    var isClear : Boolean = false,
    var isFullCombo : Boolean = false,
    var isAllJustice : Boolean = false,
    var isAJC : Boolean = false,
    var isFullChain : Boolean = false,
    var rank : String = "",
    var jacket : String = "",
    var date : String = "",
    var trackNumber: String = "",
)
