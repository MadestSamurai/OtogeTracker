package com.madsam.otora.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.madsam.otora.entity.bof.BofEntryEntity
import com.madsam.otora.entity.bof.BofTeamEntity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.dao.BofEntryDao
 * 创建者: MadSamurai
 * 创建时间: 2024/10/15
 * 描述: BOF数据访问对象
 */
@Dao
interface BofTeamDao {
    @Query("SELECT * FROM bof_teams")
    fun getAll(): List<BofTeamEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entry: BofTeamEntity): Long

    @Update
    fun update(entry: BofTeamEntity)

    @Transaction
    fun insertOrUpdate(entry: BofTeamEntity): String {
        val id = insert(entry)
        if (id == -1L) {
            update(entry)
        }
        return entry.id
    }

    @Query("SELECT * FROM bof_teams WHERE date = :date")
    fun getTeamsByDate(date: String): List<BofTeamEntity>
}