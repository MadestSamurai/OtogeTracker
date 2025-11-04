package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Chunithm 游玩历史记录实体
 * 存储用户的每次游玩记录，包含日期和时间戳
 */
@Entity
internal data class ChunithmPlayLogEntity(
    @Id var id: Long = 0,
    
    // 曲目信息
    var songId: String = "",        // 曲目ID（如果有）
    @Index var title: String = "",  // 曲名（建立索引用于搜索）
    var genre: String = "",          // 类型
    var diff: String = "",           // 难度
    var token: String = "",          // Token
    
    // 成绩信息
    var score: String = "",          // 分数
    var clear: String = "",          // Clear 标记 (failed, clear, hard, absolute, catastrophe)
    var combo: String = "",          // Combo 标记 (fullcombo, alljustice, ajc)
    var chain: String = "",          // Chain 标记 (fullchain, fullchain2)
    var rank: Int = 0,               // Rank 等级
    
    // 游玩信息
    var playDate: String = "",       // 游玩日期（游戏内显示的日期，如"2025/01/04 12:34"）
    var trackNumber: String = "",    // Track 编号
    
    // 时间戳
    var createdAt: Long = 0,         // 记录创建时间（毫秒时间戳）
    var syncedAt: Long = 0           // 最后同步时间（毫秒时间戳）
) {
    constructor() : this(
        id = 0,
        songId = "",
        title = "",
        genre = "",
        diff = "",
        token = "",
        score = "",
        clear = "",
        combo = "",
        chain = "",
        rank = 0,
        playDate = "",
        trackNumber = "",
        createdAt = 0,
        syncedAt = 0
    )
}
