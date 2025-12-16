package com.madsam.otora.data.osu.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import io.objectbox.annotation.Unique

/**
 * osu! 徽章实体
 */
@Entity
internal data class OsuBadgeEntity(
    @Id var id: Long = 0,
    @Index var odUserId: Long = 0,         // osu! 用户ID
    @Unique var uniqueKey: String = "",    // "${odUserId}_${imageUrl}" 因为badge没有ID
    
    // 徽章信息
    var imageUrl: String = "",
    var image2xUrl: String = "",
    var description: String = "",
    var awardedAt: String = "",            // ISO8601 格式
    var url: String = "",
    
    // 时间戳
    var updatedAt: Long = 0
) {
    constructor() : this(id = 0)
}
