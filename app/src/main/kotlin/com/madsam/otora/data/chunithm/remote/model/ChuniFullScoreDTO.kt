package com.madsam.otora.data.chunithm.remote.model

internal data class ChuniFullScoreDTO(
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
    var isFullChain2 : Boolean = false,
    var rank : String = "",
    var jacket : String = "",
    var date : String = "",
    var trackNumber: String = "",
)
