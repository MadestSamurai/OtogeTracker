package com.madsam.otora.data.bof.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

internal class BofPointEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var no: Int = 0
    var time: Long = 0
    var impr: Int = 0
    var total: Int = 0
    var median: Double = 0.0
    var avg: Double = 0.0
}