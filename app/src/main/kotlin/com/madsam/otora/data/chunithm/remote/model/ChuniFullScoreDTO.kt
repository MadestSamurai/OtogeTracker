package com.madsam.otora.data.chunithm.remote.model

internal data class ChuniFullScoreDTO(
    var id : String = "",
    var title : String = "",
    var genre : String = "",
    var diff : String = "",
    var token : String = "",
    var score : String = "",
    var clear : String = "",
    var combo : String = "",
    var chain : String = "",
    var rank : Int = 0,
    var date : String = "",
    var trackNumber: String = "",
    var isPersonalRecord: Boolean = true // 标记是否为个人记录，true=自己的分数，false=友人分数
)
