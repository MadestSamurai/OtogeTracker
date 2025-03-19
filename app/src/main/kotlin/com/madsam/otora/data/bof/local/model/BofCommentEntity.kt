package com.madsam.otora.data.bof.local.model

import io.github.xilinjia.krdb.types.RealmObject
import io.github.xilinjia.krdb.types.annotations.PrimaryKey

internal class BofCommentEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var date: String = ""
    var user: String = ""
    var pattern: String = ""
    var country: String = ""
    var vote: Int = 0
    var voteTotal: Int = 0
    var voteAve: Double = 0.0
    var short: Int = 0
    var shortTotal: Int = 0
    var shortAve: Double = 0.0
    var shortComment: Int = 0
    var long: Int = 0
    var longTotal: Int = 0
    var longAve: Double = 0.0
    var longComment: Int = 0
    var total: Int = 0
    var totalAve: Double = 0.0
}