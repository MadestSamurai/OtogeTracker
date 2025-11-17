package com.madsam.otora.data.chunithm.remote.model

/**
 * 中二节奏任务数据
 */
internal data class ChunithmMissionDTO(
    val title: String = "",                      // 任务标题（如：グランレイス）
    val rewardImageUrl: String = "",             // 主要奖励图片URL
    val startDate: String = "",                  // 开始日期
    val endDate: String = "",                    // 结束日期
    val currentPoints: Int = 0,                  // 当前气球数
    val nextRewardPoints: Int = 0,               // 下一个奖励所需气球数
    val nextRewardName: String = "",             // 下一个奖励名称
    val nextRewardImageUrl: String = "",         // 下一个奖励图片URL
    val pickupRewardPoints: Int = 0,             // 特别奖励所需气球数
    val pickupRewardName: String = "",           // 特别奖励名称
    val pickupRewardImageUrl: String = "",       // 特别奖励图片URL
    val patterns: List<MissionPattern> = emptyList()  // 任务进度列表
)

/**
 * 单个任务进度
 */
internal data class MissionPattern(
    val stageNumber: Int = 0,                    // 当前阶段（如：4/6）
    val stageDenominator: Int = 0,               // 总阶段数
    val iconUrl: String = "",                    // 任务类型图标URL
    val description: String = "",                // 任务描述（如：游玩乐曲）
    val currentProgress: Int = 0,                // 当前进度（如：3）
    val totalProgress: Int = 0,                  // 总进度（如：6）
    val progressUnit: String = "",               // 进度单位（如：乐曲）
    val rewardPoints: Int = 0                    // 完成该阶段奖励的气球数
)
