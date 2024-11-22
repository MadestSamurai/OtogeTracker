package com.madsam.otora.entity.chunithm

import androidx.room.Entity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.chunithm.ChuniSheetsEntity
 * 创建者: MadSamurai
 * 创建时间: 2024/11/16
 * 描述: TODO
 */
@Entity(tableName = "chuni_sheets", primaryKeys = ["id", "difficulty"])
data class ChuniSheetsEntity(
    val id: String = "",
    var type: String = "",
    var difficulty: String = "",
    var level: String = "",
    var levelValue: Double = 0.0,
    var internalLevel: String = "",
    var internalLevelValue: Double = 0.0,
    var noteDesigner: String = "",
    var tap: Int = 0,
    var hold: Int = 0,
    var slide: Int = 0,
    var air: Int = 0,
    var flick: Int = 0,
    var total: Int = 0,
    var jp: Boolean = false,
    var intl: Boolean = false,
    var isSpecial: Boolean = false
)