package com.madsam.otora.data.bof.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

internal class BofTeamPointEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var time: Long = 0
    var team: String = ""
    var total: Double = 0.0
    var median: String = ""
    var impr: Int = 0
    var total1: String = ""
    var median1: String = ""
    var total2: String = ""
    var median2: String = ""
    var total3: String = ""
    var median3: String = ""
    var total4: String = ""
    var median4: String = ""
}