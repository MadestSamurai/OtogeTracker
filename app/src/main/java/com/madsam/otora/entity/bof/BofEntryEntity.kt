package com.madsam.otora.entity.bof

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.bof.BofEntry
 * 创建者: MadSamurai
 * 创建时间: 2024/10/15
 * 描述: BOF条目实体（数据库）
 */

@Entity(tableName = "bof_entries")
data class BofEntryEntity(
    @PrimaryKey val no: Int = 0,
    var team: String = "",
    var artist: String = "",
    var genre: String = "",
    var title: String = "",
    var regist: String = "",
    var update: String = "",
)
