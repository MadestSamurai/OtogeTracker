package com.madsam.otora.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.madsam.otora.entity.bof.BofPointEntity
import com.madsam.otora.entity.bof.BofTeamPointEntity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.dao.BofPointDao
 * 创建者: MadSamurai
 * 创建时间: 2024/10/15
 * 描述: BOF评分数据访问对象
 */
@Dao
interface BofTeamPointDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(points: List<BofTeamPointEntity>)

    @Update
    fun updateAll(points: List<BofTeamPointEntity>)

    @Query("SELECT * FROM bof_team_points WHERE timeAndEntry BETWEEN :startId AND :endId")
    fun getPointsByRange(startId: Int, endId: Int): List<BofTeamPointEntity>

    @Query("SELECT MAX(timeAndEntry) FROM bof_team_points")
    fun getMaxId(): Int
}