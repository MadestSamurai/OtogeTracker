package com.madsam.otora.data.bof.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

internal class BofEntryEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var no: Int = 0
    var team: String = ""
    var date: String = ""
    var artist: String = ""
    var genre: String = ""
    var title: String = ""
    var regist: String = ""
    var update: String = ""
}