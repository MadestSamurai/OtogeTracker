package com.madsam.otora.data.bof.remote.model

import com.squareup.moshi.Json

internal data class BofEntryDTO(
    @Json(name = "No.") var no: Int = 0,
    @Json(name = "Team") var team: String = "",
    @Json(name = "Artist") var artist: String = "",
    @Json(name = "Genre") var genre: String = "",
    @Json(name = "Title") var title: String = "",
    @Json(name = "Regist") var regist: String = "",
    @Json(name = "Update") var update: String = "",
    @Json(name = "Impr") var impr: List<PointInt> = emptyList(),
    @Json(name = "Total") var total: List<PointInt> = emptyList(),
    @Json(name = "Median") var median: List<PointDouble> = emptyList(),
    @Json(name = "Avg") var avg: List<PointDouble> = emptyList(),
) {
    internal data class PointInt(
        var time: String = "",
        var value: Int = 0
    )

    internal data class PointDouble(
        var time: String = "",
        var value: Double = 0.0
    )
}
