package com.madsam.otora.data.maimai.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Maimai 乐曲成绩实体
 */
@Entity
internal data class MaimaiScoreEntity(
    @Id var id: Long = 0,
    
    @Index var songId: String = "",              // 乐曲 ID
    var title: String = "",
    @Index var difficulty: String = "",
    var level: String = "",
    var score: String = "",
    var rank: String = "",
    var comboStatus: String = "",
    var syncStatus: String = "",
    var deluxscore: String = "",
    var genre: String = "",
    var coverUrl: String = "",
    @Index var ratingType: String = "",          // BEST 或 NEW
    var syncedAt: Long = 0
) {
    constructor() : this(
        id = 0,
        songId = "",
        title = "",
        difficulty = "",
        level = "",
        score = "",
        rank = "",
        comboStatus = "",
        syncStatus = "",
        deluxscore = "",
        genre = "",
        coverUrl = "",
        ratingType = "",
        syncedAt = 0
    )
    
    companion object {
        const val TYPE_BEST = "BEST"
        const val TYPE_NEW = "NEW"
    }
}
