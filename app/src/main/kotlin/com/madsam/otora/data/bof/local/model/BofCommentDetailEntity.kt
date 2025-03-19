package com.madsam.otora.data.bof.local.model

import io.github.xilinjia.krdb.types.RealmObject
import io.github.xilinjia.krdb.types.annotations.PrimaryKey

internal class BofCommentDetailEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var user: String = ""
    var score: Int = 0
    var code: String = ""
    var country: String = ""
    var workNumber: Int = 0
    var date: String = ""
    var type: String = ""
}