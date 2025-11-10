package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * 月度累计奖励配置实体
 * 每月固定的奖励里程碑（每月重置进度）
 */
@Entity
internal data class ChunithmMonthlyRewardEntity(
    @Id var id: Long = 0,
    
    @Index var day: Int = 0,                // 需要达到的天数（如3, 6, 8等）
    var imageUrl: String = "",              // 奖励图标URL
    var rewardName: String = "",            // 奖励名称
    var isCompleted: Boolean = false,       // 本月是否已完成
    
    var lastUpdated: Long = System.currentTimeMillis()
)
