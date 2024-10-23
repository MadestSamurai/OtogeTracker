package com.madsam.otora.model.bof

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.model.bof.BofTeam
 * 创建者: MadSamurai
 * 创建时间: 2024/10/23
 * 描述: TODO
 */
data class BofTeam (
    var no: Int = 0,
    @Json(name = "Team") var team: String = "",
    @Json(name = "Title1") var title1: String = "",
    @Json(name = "Title2") var title2: String = "",
    @Json(name = "Title3") var title3: String = "",
    @Json(name = "Title4") var title4: String = "",
    @Json(name = "Artist1") var artist1: String = "",
    @Json(name = "Artist2") var artist2: String = "",
    @Json(name = "Artist3") var artist3: String = "",
    @Json(name = "Artist4") var artist4: String = "",
    @Json(name = "FinalStriker1") var fs1: String = "",
    @Json(name = "FinalStriker2") var fs2: String = "",
    @Json(name = "FinalStriker3") var fs3: String = "",
    @Json(name = "FinalStriker4") var fs4: String = "",
    @Json(name = "Total") var total: List<PointDouble> = emptyList(),
    @Json(name = "Mid") var median: List<PointString> = emptyList(),
    @Json(name = "Imp") var impr: List<PointInt> = emptyList(),
    @Json(name = "Total1") var total1: List<PointString> = emptyList(),
    @Json(name = "Median1") var median1: List<PointString> = emptyList(),
    @Json(name = "Total2") var total2: List<PointString> = emptyList(),
    @Json(name = "Median2") var median2: List<PointString> = emptyList(),
    @Json(name = "Total3") var total3: List<PointString> = emptyList(),
    @Json(name = "Median3") var median3: List<PointString> = emptyList(),
    @Json(name = "Total4") var total4: List<PointString> = emptyList(),
    @Json(name = "Median4") var median4: List<PointString> = emptyList()
) {
    data class PointInt(
        var time: String = "",
        var value: Int = 0
    )

    data class PointDouble(
        var time: String = "",
        var value: Double = 0.0
    )

    data class PointString(
        var time: String = "",
        var value: String = ""
    )
}
