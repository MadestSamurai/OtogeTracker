package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class BofTeamPointEntity(
    @Id var id: Long = 0,
    
    @Index var pointId: String = "", // 用于存储原来的 id: "${timeInMillis}_${team.team}"
    @Index var time: Long = 0, // 时间戳
    @Index var team: String = "",
    var total: Double = 0.0,
    var median: String = "",
    var impr: Int = 0,
    var total1: String = "",
    var median1: String = "",
    var total2: String = "",
    var median2: String = "",
    var total3: String = "",
    var median3: String = "",
    var total4: String = "",
    var median4: String = ""
) {
    constructor() : this(
        id = 0,
        pointId = "",
        time = 0,
        team = "",
        total = 0.0,
        median = "",
        impr = 0,
        total1 = "",
        median1 = "",
        total2 = "",
        median2 = "",
        total3 = "",
        median3 = "",
        total4 = "",
        median4 = ""
    )
}
