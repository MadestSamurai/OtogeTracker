package com.madsam.otora.entity.bof

import androidx.room.Entity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.bof.BofTeamEntity
 * 创建者: MadSamurai
 * 创建时间: 2024/10/23
 * 描述: TODO
 */
@Entity(tableName = "bof_teams", primaryKeys = ["id", "date"])
data class BofTeamEntity(
    var id: String = "",
    val date: String = "",
    var team: String = "",
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
    var fs4: String = "",
)