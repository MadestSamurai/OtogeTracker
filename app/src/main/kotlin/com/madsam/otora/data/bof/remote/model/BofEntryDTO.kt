package com.madsam.otora.data.bof.remote.model

import com.squareup.moshi.Json

internal data class BofEntryDTO(
    @param:Json(name = "No.") var no: Int = 0,
    @param:Json(name = "Team") var team: String = "",
    @param:Json(name = "Artist") var artist: String = "",
    @param:Json(name = "Genre") var genre: String = "",
    @param:Json(name = "Title") var title: String = "",
    @param:Json(name = "Regist") var regist: String = "",
    @param:Json(name = "Update") var update: String = "",
    @param:Json(name = "Impr") var impr: List<PointInt> = emptyList(),
    @param:Json(name = "Total") var total: List<PointInt> = emptyList(),
    @param:Json(name = "Median") var median: List<PointDouble> = emptyList(),
    @param:Json(name = "Avg") var avg: List<PointDouble> = emptyList(),
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
