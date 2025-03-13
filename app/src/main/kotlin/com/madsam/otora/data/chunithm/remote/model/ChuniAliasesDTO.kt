package com.madsam.otora.data.chunithm.remote.model

import com.squareup.moshi.Json

internal data class ChuniAliasesDTO(
    @Json(name = "aliases") var aliases: List<ChuniAlias> = listOf()
) {
    internal data class ChuniAlias(
        @Json(name = "song_id") var id: Int = 0,
        @Json(name = "aliases") var aliases: List<String> = listOf()
    )
}