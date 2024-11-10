package com.madsam.otora.entity.bof

import androidx.room.Entity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.bof.BofTeamPointEntity
 * 创建者: MadSamurai
 * 创建时间: 2024/10/23
 * 描述: BOF团队得分实体（数据库）
 */
@Entity(tableName = "bof_team_points", primaryKeys = ["time", "id"])
data class BofTeamPointEntity(
    var time: Long = 0,
    var id: String = "",
    var total: Double = 0.0,
    var median: String = "",
    var impr: Int = 0,
    var total1: String = "",
    var median1: String = "",
    var total2: String = "",
    var median2: String = "",
    var total3: String = "",
    var median3: String = "",
    var total4: String = "",
    var median4: String = ""
)