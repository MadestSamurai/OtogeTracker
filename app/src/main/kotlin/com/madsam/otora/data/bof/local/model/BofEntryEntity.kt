package com.madsam.otora.data.bof.local.model

import io.github.xilinjia.krdb.types.RealmObject
import io.github.xilinjia.krdb.types.annotations.PrimaryKey

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