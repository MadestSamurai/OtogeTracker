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

    @Query("SELECT * FROM bof_teams WHERE team = :team LIMIT 1")
    fun getByTeam(team: String): BofTeamEntity?

    @Transaction
    fun insertOrUpdate(entry: BofTeamEntity): Int {
        val existingEntry = getByTeam(entry.team)
        return if (existingEntry == null) {
            insert(entry).toInt()
        } else {
            val updatedEntry = existingEntry.copy(
                title1 = entry.title1,
                title2 = entry.title2,
                title3 = entry.title3,
                title4 = entry.title4,
                artist1 = entry.artist1,
                artist2 = entry.artist2,
                artist3 = entry.artist3,
                artist4 = entry.artist4,
                fs1 = entry.fs1,
                fs2 = entry.fs2,
                fs3 = entry.fs3,
                fs4 = entry.fs4
            )
            update(updatedEntry)
            existingEntry.no
        }
    }

    @Query("SELECT * FROM bof_teams WHERE `no` IN (:ids)")
    fun getTeamsByIds(ids: List<Int>): List<BofTeamEntity>
}