package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import io.objectbox.annotation.Unique
import io.objectbox.annotation.ConflictStrategy

@Entity
internal data class BofWorkEntity(
    @Id var id: Long = 0,
    @Unique(onConflict = ConflictStrategy.REPLACE) @Index var compositeWorkId: String = "",
    @Index var path: String = "", // 比赛类型路径 (tt, bms等)
    var originalWorkId: String = "", // 原始workId
    var currentTitle: String = "",
    var currentArtist: String = "",
    var team: String = "",
    var genre: String = "",
    
    // JSON数据存储
    var scoreDataJson: String = "",
    var titleHistoryJson: String = "",
    var artistHistoryJson: String = "",
    
    // 查询优化索引
    @Index var earliestTimestamp: Long = 0,
    @Index var latestTimestamp: Long = 0,
    @Index var latestTotalScore: Int = 0,
    var latestAverage: Double = 0.0,
    var lastUpdated: Long = 0
) {
    constructor() : this(
        id = 0,
        compositeWorkId = "",
        path = "",
        originalWorkId = "",
        currentTitle = "",
        currentArtist = "",
        team = "",
        genre = "",
        scoreDataJson = "",
        titleHistoryJson = "",
        artistHistoryJson = "",
        earliestTimestamp = 0,
        latestTimestamp = 0,
        latestTotalScore = 0,
        latestAverage = 0.0,
        lastUpdated = 0
    )
    
    companion object {
        /**
         * 构造复合workId
         */
        fun createCompositeWorkId(path: String, originalWorkId: String): String {
            return "${path}_${originalWorkId}"
        }
    }
}
