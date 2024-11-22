package com.madsam.otora.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.madsam.otora.entity.chunithm.ChuniSheetsEntity

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.dao.ChuniSheetsDao
 * 创建者: MadSamurai
 * 创建时间: 2024/11/16
 * 描述: TODO
 */
@Dao
interface ChuniSheetsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(points: List<ChuniSheetsEntity>)

    @Update
    fun updateAll(points: List<ChuniSheetsEntity>)

    @Query("SELECT * FROM chuni_sheets WHERE id = :id AND difficulty = :difficulty")
    fun getSheetById(id: String, difficulty: String): ChuniSheetsEntity?
}