package com.madsam.otora.model.chuni.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.model.chuni.web.ChuniSongSheet
 * 创建者: MadSamurai
 * 创建时间: 2024/11/15
 * 描述: TODO
 */
data class ChuniSongSheet(
    @Json(name = "type") var type: String = "",
    @Json(name = "difficulty") var difficulty: String = "",
    @Json(name = "level") var level: String = "",
    @Json(name = "levelValue") var levelValue: Double = 0.0,
    @Json(name = "internalLevel") var internalLevel: String = "",
    @Json(name = "internalLevelValue") var internalLevelValue: Double = 0.0,
    @Json(name = "noteDesigner") var noteDesigner: String = "",
    @Json(name = "noteCounts") var noteCounts: NoteCounts = NoteCounts(),
    @Json(name = "regions") var regions: Regions = Regions(),
    @Json(name = "isSpecial") var isSpecial: Boolean = false
) {
    data class NoteCounts(
        @Json(name = "tap") var tap: Int = 0,
        @Json(name = "hold") var hold: Int = 0,
        @Json(name = "slide") var slide: Int = 0,
        @Json(name = "air") var air: Int = 0,
        @Json(name = "flick") var flick: Int = 0,
        @Json(name = "total") var total: Int = 0
    )

    data class Regions(
        @Json(name = "jp") var jp: Boolean = false,
        @Json(name = "intl") var intl: Boolean = false
    )
}
