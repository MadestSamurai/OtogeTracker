package com.madsam.otora.data.bof.remote.model

import com.squareup.moshi.Json

data class BofTeamDetailedResponse(
    @param:Json(name = "Score") var score: List<TeamYearData>? = null,
    @param:Json(name = "Team") var team: String = "",
    @param:Json(name = "Title1") var title1: List<TeamTimeValue>? = null,
    @param:Json(name = "Artist1") var artist1: List<TeamTimeValue>? = null,
    @param:Json(name = "FinalStriker1") var finalStriker1: List<TeamTimeValue>? = null,
    @param:Json(name = "Title2") var title2: List<TeamTimeValue>? = null,
    @param:Json(name = "Artist2") var artist2: List<TeamTimeValue>? = null,
    @param:Json(name = "FinalStriker2") var finalStriker2: List<TeamTimeValue>? = null,
    @param:Json(name = "Title3") var title3: List<TeamTimeValue>? = null,
    @param:Json(name = "Artist3") var artist3: List<TeamTimeValue>? = null,
    @param:Json(name = "FinalStriker3") var finalStriker3: List<TeamTimeValue>? = null,
    @param:Json(name = "Title4") var title4: List<TeamTimeValue>? = null,
    @param:Json(name = "Artist4") var artist4: List<TeamTimeValue>? = null,
    @param:Json(name = "FinalStriker4") var finalStriker4: List<TeamTimeValue>? = null
)

data class TeamTimeValue(
    @param:Json(name = "time") var time: String = "",
    @param:Json(name = "value") var value: String = ""
)

data class TeamYearData(
    @param:Json(name = "y") var year: Int = 0,
    @param:Json(name = "c") var months: List<TeamMonthData>? = null
)

data class TeamMonthData(
    @param:Json(name = "m") var month: Int = 0,
    @param:Json(name = "c") var days: List<TeamDayData>? = null
)

data class TeamDayData(
    @param:Json(name = "d") var day: Int = 0,
    @param:Json(name = "c") var hours: List<TeamHourData>? = null
)

data class TeamHourData(
    @param:Json(name = "h") var hour: Int = 0,
    @param:Json(name = "c") var minutes: List<TeamMinuteData>? = null
)

data class TeamMinuteData(
    @param:Json(name = "n") var minute: Int = 0,
    @param:Json(name = "v") var values: TeamValues? = null
)

data class TeamValues(
    @param:Json(name = "t") var total: Double = 0.0,
    @param:Json(name = "m") var average: Any? = null, // Can be Double or String
    @param:Json(name = "i") var impression: Double = 0.0,
    @param:Json(name = "t1") var total1: Any? = null, // Can be Double or String
    @param:Json(name = "m1") var average1: Any? = null, // Can be Double or String
    @param:Json(name = "t2") var total2: Any? = null, // Can be Double or String
    @param:Json(name = "m2") var average2: Any? = null, // Can be Double or String
    @param:Json(name = "t3") var total3: Any? = null, // Can be Double or String
    @param:Json(name = "m3") var average3: Any? = null, // Can be Double or String
    @param:Json(name = "t4") var total4: Any? = null, // Can be Double or String
    @param:Json(name = "m4") var average4: Any? = null // Can be Double or String
)
