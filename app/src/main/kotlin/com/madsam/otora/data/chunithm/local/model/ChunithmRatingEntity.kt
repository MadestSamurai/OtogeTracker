package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Chunithm Rating 数据实体
 * 包含 Best、Recent、Suggest 三种类型的成绩
 */
@Entity
internal data class ChunithmRatingEntity(
    @Id var id: Long = 0,
    
    // 曲目信息
    var songId: String = "",        // 曲目ID
    @Index var title: String = "",  // 曲名（建立索引用于搜索）
    var genre: String = "",          // 类型
    var diff: String = "",           // 难度 (0=Basic, 1=Advanced, 2=Expert, 3=Master, 4=Ultima)
    var token: String = "",          // Token（用于详情查询）
    var highScore: String = "",      // 最高分数
    
    // Rating 类型
    @Index var ratingType: String = "", // "best" / "recent" / "suggest"
    
    // 时间戳
    var createdAt: Long = 0,         // 记录创建时间（毫秒时间戳）
    var updatedAt: Long = 0          // 最后更新时间（毫秒时间戳）
) {
    constructor() : this(
        id = 0,
        songId = "",
        title = "",
        genre = "",
        diff = "",
        token = "",
        highScore = "",
        ratingType = "",
        createdAt = 0,
        updatedAt = 0
    )
    
    companion object {
        const val TYPE_BEST = "best"
        const val TYPE_RECENT = "recent"
        const val TYPE_SUGGEST = "suggest"
    }
}
