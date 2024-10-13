package com.madsam.otora.entity.bof

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.bof.Entry
 * 创建者: MadSamurai
 * 创建时间: 2024/10/13
 * 描述: TODO
 */
data class BofEntry(
    @Json(name = "No.") var no: Int = 0,
    @Json(name = "Name") var team: String = "",
    @Json(name = "Artist") var artist: String = "",
    @Json(name = "Genre") var genre: String = "",
    @Json(name = "Title") var title: String = "",
    @Json(name = "Regist") var regist: String = "",
    @Json(name = "Update") var update: String = "",
    @Json(name = "Impr") var impr: List<Point> = emptyList(),
    @Json(name = "Total") var total: List<Point> = emptyList(),
    @Json(name = "Median") var median: List<Point> = emptyList(),
    @Json(name = "Avg") var avg: List<Point> = emptyList(),
) {
    data class Point(
        var time: String = "",
        var value: Int = 0
    )
}
