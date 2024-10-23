package com.madsam.otora.entity.bof

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.bof.BofTeamEntity
 * 创建者: MadSamurai
 * 创建时间: 2024/10/23
 * 描述: TODO
 */
@Entity(tableName = "bof_teams")
data class BofTeamEntity(
    @PrimaryKey(autoGenerate = true) val no: Int = 0,
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