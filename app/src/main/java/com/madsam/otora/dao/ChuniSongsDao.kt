package com.madsam.otora.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.madsam.otora.entity.chunithm.ChuniSongsEntity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.dao.ChuniSongsDao
 * 创建者: MadSamurai
 * 创建时间: 2024/11/16
 * 描述: TODO
 */
@Dao
interface ChuniSongsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(points: List<ChuniSongsEntity>)

    @Update
    fun updateAll(points: List<ChuniSongsEntity>)

    @Query("SELECT * FROM chuni_songs WHERE id = :id")
    fun getSongById(id: String): ChuniSongsEntity?
}