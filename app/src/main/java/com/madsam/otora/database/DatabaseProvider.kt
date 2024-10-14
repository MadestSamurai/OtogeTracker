package com.madsam.otora.database

import android.content.Context
import androidx.room.Room

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.database.DatabaseProvider
 * 创建者: MadSamurai
 * 创建时间: 2024/10/15
 * 描述: 数据库提供者
 */
object DatabaseProvider {
    private var db: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        if (db == null) {
            db = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "otora-database"
            ).build()
        }
        return db!!
    }
}