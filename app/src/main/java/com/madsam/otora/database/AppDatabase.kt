package com.madsam.otora.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.madsam.otora.dao.BofEntryDao
import com.madsam.otora.dao.BofPointDao
import com.madsam.otora.entity.bof.BofEntryEntity
import com.madsam.otora.entity.bof.BofPointEntity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.database.AppDatabase
 * 创建者: MadSamurai
 * 创建时间: 2024/10/15
 * 描述: 数据库类
 */
@Database(entities = [BofEntryEntity::class, BofPointEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bofEntryDao(): BofEntryDao
    abstract fun bofPointDao(): BofPointDao
}