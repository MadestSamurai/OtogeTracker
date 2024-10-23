package com.madsam.otora.entity.bof

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.bof.BofTeamPointEntity
 * 创建者: MadSamurai
 * 创建时间: 2024/10/23
 * 描述: TODO
 */
@Entity(tableName = "bof_team_points")
data class BofTeamPointEntity(
    @PrimaryKey var timeAndEntry: Int = 0, // 时间戳 + Team编号，用于唯一标识，其中时间戳从 2024-10-13 00:00:00 开始，每小时递增
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