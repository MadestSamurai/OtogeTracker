package com.madsam.otora.data.bof.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

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