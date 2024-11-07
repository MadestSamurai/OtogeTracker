package com.madsam.otora.entity.bof

import androidx.room.Entity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.bof.BofPointEntity
 * 创建者: MadSamurai
 * 创建时间: 2024/10/15
 * 描述: BOF评分实体（数据库）
 */

@Entity(tableName = "bof_points", primaryKeys = ["time", "no"])
data class BofPointEntity(
    val time: Long = 0,
    val no: Int = 0,
    var impr: Int = 0,
    var total: Int = 0,
    var median: Double = 0.0,
    var avg: Double = 0.0,
)