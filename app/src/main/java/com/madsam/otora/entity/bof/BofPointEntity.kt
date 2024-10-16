package com.madsam.otora.entity.bof

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.bof.BofPointEntity
 * 创建者: MadSamurai
 * 创建时间: 2024/10/15
 * 描述: BOF评分实体（数据库）
 */

@Entity(tableName = "bof_points")
data class BofPointEntity(
    @PrimaryKey var timeAndEntry: Int = 0, // 时间戳 + Entry编号，用于唯一标识，其中时间戳从 2024-10-13 00:00:00 开始，每小时递增
    var impr: Int = 0,
    var total: Int = 0,
    var median: Double = 0.0,
    var avg: Double = 0.0,
)