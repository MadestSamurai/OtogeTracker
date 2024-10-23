package com.madsam.otora.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.madsam.otora.dao.BofEntryDao
import com.madsam.otora.dao.BofPointDao
import com.madsam.otora.dao.BofTeamDao
import com.madsam.otora.dao.BofTeamPointDao
import com.madsam.otora.entity.bof.BofEntryEntity
import com.madsam.otora.entity.bof.BofPointEntity
import com.madsam.otora.entity.bof.BofTeamEntity
import com.madsam.otora.entity.bof.BofTeamPointEntity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.database.AppDatabase
 * 创建者: MadSamurai
 * 创建时间: 2024/10/15
 * 描述: 数据库类
 */
@Database(entities = [
    BofEntryEntity::class,
    BofPointEntity::class,
    BofTeamEntity::class,
    BofTeamPointEntity::class
                     ], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bofEntryDao(): BofEntryDao
    abstract fun bofPointDao(): BofPointDao
    abstract fun bofTeamDao(): BofTeamDao
    abstract fun bofTeamPointDao(): BofTeamPointDao
}