package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * BOFTT紧凑存储Entity - 层次化数据压缩到单个实体
 */
@Entity
internal data class BofTTCompactEntity(
    @Id var id: Long = 0,
    @Index var workId: String = "",
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
    var latestAverageScore: Double = 0.0,
    var lastUpdated: Long = 0
) {
    constructor() : this(
        id = 0,
        workId = "",
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
        latestAverageScore = 0.0,
        lastUpdated = 0
    )
}
