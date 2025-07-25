package com.madsam.otora.data.bof.remote.model

import com.squareup.moshi.Json

internal data class BofTeamDTO (
    var id: String = "",
    @param:Json(name = "Team") var team: String = "",
    @param:Json(name = "Title1") var title1: String = "",
    @param:Json(name = "Title2") var title2: String = "",
    @param:Json(name = "Title3") var title3: String = "",
    @param:Json(name = "Title4") var title4: String = "",
    @param:Json(name = "Artist1") var artist1: String = "",
    @param:Json(name = "Artist2") var artist2: String = "",
    @param:Json(name = "Artist3") var artist3: String = "",
    @param:Json(name = "Artist4") var artist4: String = "",
    @param:Json(name = "FinalStriker1") var fs1: String = "",
    @param:Json(name = "FinalStriker2") var fs2: String = "",
    @param:Json(name = "FinalStriker3") var fs3: String = "",
    @param:Json(name = "FinalStriker4") var fs4: String = "",
    @param:Json(name = "Total") var total: List<PointDouble> = emptyList(),
    @param:Json(name = "Mid") var median: List<PointString> = emptyList(),
    @param:Json(name = "Imp") var impr: List<PointInt> = emptyList(),
    @param:Json(name = "Total1") var total1: List<PointString> = emptyList(),
    @param:Json(name = "Median1") var median1: List<PointString> = emptyList(),
    @param:Json(name = "Total2") var total2: List<PointString> = emptyList(),
    @param:Json(name = "Median2") var median2: List<PointString> = emptyList(),
    @param:Json(name = "Total3") var total3: List<PointString> = emptyList(),
    @param:Json(name = "Median3") var median3: List<PointString> = emptyList(),
    @param:Json(name = "Total4") var total4: List<PointString> = emptyList(),
    @param:Json(name = "Median4") var median4: List<PointString> = emptyList()
) {
    internal data class PointInt(
        var time: String = "",
        var value: Int = 0
    )

    internal data class PointDouble(
        var time: String = "",
        var value: Double = 0.0
    )

    internal data class PointString(
        var time: String = "",
        var value: String = ""
    )
}
