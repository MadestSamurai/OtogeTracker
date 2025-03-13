package com.madsam.otora.data.chunithm.remote.model

internal data class ChuniGenreDTO(
    var name : String = "",
    var fullScoreList : List<ChuniFullScoreDTO> = listOf(),
)
