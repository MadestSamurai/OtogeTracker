package com.madsam.otora.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.madsam.otora.entity.bof.BofPointEntity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.dao.BofPointDao
 * 创建者: MadSamurai
 * 创建时间: 2024/10/15
 * 描述: BOF评分数据访问对象
 */
@Dao
interface BofPointDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(points: List<BofPointEntity>)

    @Update
    fun updateAll(points: List<BofPointEntity>)

    @Query("SELECT * FROM bof_points WHERE timeAndEntry BETWEEN :startId AND :endId")
    fun getPointsByRange(startId: Int, endId: Int): List<BofPointEntity>

    @Query("SELECT MAX(timeAndEntry) FROM bof_points")
    fun getMaxId(): Int
}