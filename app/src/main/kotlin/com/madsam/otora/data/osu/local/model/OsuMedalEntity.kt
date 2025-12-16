package com.madsam.otora.data.osu.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import io.objectbox.annotation.Unique

/**
 * osu! 成就/奖章实体
 */
@Entity
internal data class OsuMedalEntity(
    @Id var id: Long = 0,
    @Index var odUserId: Long = 0,         // osu! 用户ID
    var odAchievementId: Long = 0,         // osu! 成就ID
    @Unique var uniqueKey: String = "",    // "${odUserId}_${odAchievementId}"
    
    // 成就信息
    var name: String = "",
    var slug: String = "",
    var description: String = "",
    var mode: String = "",                 // 可为空，表示全模式
    var grouping: String = "",             // 分组名称
    var instructions: String = "",
    var ordering: Int = 0,
    var iconUrl: String = "",
    
    // 获得时间
    var achievedAt: String = "",           // ISO8601 格式
    
    // 时间戳
    var updatedAt: Long = 0
) {
    constructor() : this(id = 0)
}
