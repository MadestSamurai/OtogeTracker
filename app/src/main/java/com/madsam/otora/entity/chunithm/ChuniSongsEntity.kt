package com.madsam.otora.entity.chunithm

import androidx.room.Entity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.chunithm.ChuniSongsEntity
 * 创建者: MadSamurai
 * 创建时间: 2024/11/15
 * 描述: TODO
 */
@Entity(tableName = "chuni_songs", primaryKeys = ["id"])
data class ChuniSongsEntity(
    val id: String = "",
    var category: String = "",
    var title: String = "",
    var artist: String = "",
    var bpm: Double = 0.0,
    var imageName: String = "",
    var version: String = "",
    var releaseDate: String = "",
    var isNew: Boolean = false,
    var isLocked: Boolean = false,
    var comment: String = ""
)