package com.madsam.otora.data.bof.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

internal class BofTeamEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var date: String = ""
    var team: String = ""
    var title1: String = ""
    var title2: String = ""
    var title3: String = ""
    var title4: String = ""
    var artist1: String = ""
    var artist2: String = ""
    var artist3: String = ""
    var artist4: String = ""
    var fs1: String = ""
    var fs2: String = ""
    var fs3: String = ""
    var fs4: String = ""
}