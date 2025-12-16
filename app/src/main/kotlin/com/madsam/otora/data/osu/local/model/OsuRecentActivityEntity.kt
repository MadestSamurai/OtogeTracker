package com.madsam.otora.data.osu.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import io.objectbox.annotation.Unique

/**
 * osu! 最近活动实体
 */
@Entity
internal data class OsuRecentActivityEntity(
    @Id var id: Long = 0,
    @Index var odUserId: Long = 0,         // osu! 用户ID
    @Unique var odActivityId: Long = 0,    // osu! 活动ID，全局唯一
    
    // 活动信息
    var type: String = "",                 // rank, achievement, beatmapsetUpload等
    var rank: Int = 0,                     // 排名（如果是rank类型）
    var scoreRank: String = "",            // SSH, SS, SH, S, A等
    var mode: String = "osu",
    
    // 成就信息（如果是成就类型）
    var achievementName: String = "",
    var achievementDescription: String = "",
    var achievementIconUrl: String = "",
    var achievementId: Long = 0,
    
    // 谱面信息（如果有关联谱面）
    var beatmapId: Long = 0,
    var beatmapTitle: String = "",
    var beatmapUrl: String = "",
    
    // 谱面集信息
    var beatmapsetId: Long = 0,
    var beatmapsetTitle: String = "",
    var beatmapsetUrl: String = "",
    
    // 时间戳
    var createdAt: String = "",            // ISO8601 格式
    var updatedAt: Long = 0
) {
    constructor() : this(id = 0)
}
