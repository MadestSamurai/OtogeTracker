package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class BofTeamEntity(
    @Id var id: Long = 0,
    
    @Index var teamId: String = "", // 用于存储原来的 id: "${date}_${team.team}"
    @Index var date: String = "",
    @Index var team: String = "",
    var title1: String = "",
    var title2: String = "",
    var title3: String = "",
    var title4: String = "",
    var artist1: String = "",
    var artist2: String = "",
    var artist3: String = "",
    var artist4: String = "",
    var fs1: String = "",
    var fs2: String = "",
    var fs3: String = "",
    var fs4: String = ""
) {
    constructor() : this(
        id = 0,
        teamId = "",
        date = "",
        team = "",
        title1 = "",
        title2 = "",
        title3 = "",
        title4 = "",
        artist1 = "",
        artist2 = "",
        artist3 = "",
        artist4 = "",
        fs1 = "",
        fs2 = "",
        fs3 = "",
        fs4 = ""
    )
}
