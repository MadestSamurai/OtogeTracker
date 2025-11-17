package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Chunithm 任务数据实体
 */
@Entity
internal data class ChunithmMissionEntity(
    @Id var id: Long = 0,
    
    var title: String = "",                      // 任务标题
    var rewardImageUrl: String = "",             // 主要奖励图片URL
    var startDate: String = "",                  // 开始日期
    var endDate: String = "",                    // 结束日期
    var currentPoints: Int = 0,                  // 当前气球数
    var nextRewardPoints: Int = 0,               // 下一个奖励所需气球数
    var nextRewardName: String = "",             // 下一个奖励名称
    var nextRewardImageUrl: String = "",         // 下一个奖励图片URL
    var pickupRewardPoints: Int = 0,             // 特别奖励所需气球数
    var pickupRewardName: String = "",           // 特别奖励名称
    var pickupRewardImageUrl: String = "",       // 特别奖励图片URL
    var syncedAt: Long = 0                       // 同步时间
) {
    constructor() : this(
        id = 0,
        title = "",
        rewardImageUrl = "",
        startDate = "",
        endDate = "",
        currentPoints = 0,
        nextRewardPoints = 0,
        nextRewardName = "",
        nextRewardImageUrl = "",
        pickupRewardPoints = 0,
        pickupRewardName = "",
        pickupRewardImageUrl = "",
        syncedAt = 0
    )
}

/**
 * Chunithm 任务进度实体
 */
@Entity
internal data class ChunithmMissionPatternEntity(
    @Id var id: Long = 0,
    
    var missionTitle: String = "",               // 关联的任务标题
    var stageNumber: Int = 0,                    // 当前阶段
    var stageDenominator: Int = 0,               // 总阶段数
    var iconUrl: String = "",                    // 任务类型图标URL
    var description: String = "",                // 任务描述
    var currentProgress: Int = 0,                // 当前进度
    var totalProgress: Int = 0,                  // 总进度
    var progressUnit: String = "",               // 进度单位
    var rewardPoints: Int = 0,                   // 奖励气球数
    var syncedAt: Long = 0                       // 同步时间
) {
    constructor() : this(
        id = 0,
        missionTitle = "",
        stageNumber = 0,
        stageDenominator = 0,
        iconUrl = "",
        description = "",
        currentProgress = 0,
        totalProgress = 0,
        progressUnit = "",
        rewardPoints = 0,
        syncedAt = 0
    )
}
