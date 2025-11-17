package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Chunithm 虚拟形象积分与奖励实体
 */
@Entity
internal data class ChunithmPointRewardEntity(
    @Id var id: Long = 0,
    
    var currentPoints: Int = 0,                  // 当前积分
    var nextRewardPoints: Int = 0,               // 下一个奖励所需积分
    var nextRewardName: String = "",             // 下一个奖励名称
    var nextRewardImageUrl: String = "",         // 下一个奖励图片URL
    var pickupRewardPoints: Int = 0,             // 特别奖励所需积分
    var pickupRewardName: String = "",           // 特别奖励名称
    var pickupRewardImageUrl: String = "",       // 特别奖励图片URL
    var gaugeProgress: Double = 0.0,             // 进度条百分比
    var syncedAt: Long = 0                       // 同步时间
) {
    constructor() : this(
        id = 0,
        currentPoints = 0,
        nextRewardPoints = 0,
        nextRewardName = "",
        nextRewardImageUrl = "",
        pickupRewardPoints = 0,
        pickupRewardName = "",
        pickupRewardImageUrl = "",
        gaugeProgress = 0.0,
        syncedAt = 0
    )
}
