package com.madsam.otora.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.madsam.otora.entity.bof.BofEntryEntity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.dao.BofEntryDao
 * 创建者: MadSamurai
 * 创建时间: 2024/10/15
 * 描述: BOF数据访问对象
 */
@Dao
interface BofEntryDao {
    @Query("SELECT * FROM bof_entries")
    fun getAll(): List<BofEntryEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entry: BofEntryEntity): Long

    @Update
    fun update(entry: BofEntryEntity)

    @Transaction
    fun insertOrUpdate(entry: BofEntryEntity) {
        val id = insert(entry)
        if (id == -1L) {
            update(entry)
        }
    }
}