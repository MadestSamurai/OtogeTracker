package com.madsam.otora.data.chunithm.remote.model

internal data class ChunithmGenreDTO(
    var name : String = "",
    var fullScoreList : List<ChunithmFullScoreDTO> = listOf(),
)
