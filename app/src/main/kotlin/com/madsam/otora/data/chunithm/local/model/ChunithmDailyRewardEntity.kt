package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * 每日连续签到奖励配置实体
 * 14天循环签到系统，与月度无关
 */
@Entity
internal data class ChunithmDailyRewardEntity(
    @Id var id: Long = 0,
    
    @Index var day: Int = 0,                // 第几天（1-14）
    var imageUrl: String = "",              // 奖励图标URL
    var rewardName: String = "",            // 奖励名称
    var isReceived: Boolean = false,        // 是否已领取
    var isNext: Boolean = false,            // 是否是下一个待领取
    
    var lastUpdated: Long = System.currentTimeMillis()
)
