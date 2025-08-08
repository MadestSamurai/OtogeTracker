package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class ChunithmFriendScoreEntity(
    @Id var id: Long = 0,
    
    @Index var friendCode: String = "", // 友人代码
    @Index var title: String = "", // 歌曲名称
    var score: Int = 0, // 友人分数
    
    // 友人成绩页面中只有Combo相关标记是有意义的
    var combo: String = "", // fullcombo, alljustice, ajc等
    
    // 难度名称 (Basic, Advanced, Expert, Master, Ultima)
    @Index var difficulty: String = "",
    
    // 记录创建时间
    var recordedAt: String = "",
    
    // 复合键标识符，用于查询去重
    @Index var uniqueKey: String = "" // friendCode_title_difficulty
) {
    constructor() : this(
        id = 0,
        friendCode = "",
        title = "",
        score = 0,
        combo = "",
        difficulty = "",
        recordedAt = "",
        uniqueKey = ""
    )
}
