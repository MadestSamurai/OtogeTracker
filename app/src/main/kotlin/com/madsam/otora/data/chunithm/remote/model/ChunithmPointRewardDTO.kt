package com.madsam.otora.data.chunithm.remote.model

/**
 * 虚拟形象积分与奖励数据
 */
internal data class ChunithmPointRewardDTO(
    val currentPoints: Int = 0,                  // 当前积分
    val nextRewardPoints: Int = 0,               // 下一个奖励所需积分
    val nextRewardName: String = "",             // 下一个奖励名称
    val nextRewardImageUrl: String = "",         // 下一个奖励图片URL
    val pickupRewardPoints: Int = 0,             // 特别奖励所需积分
    val pickupRewardName: String = "",           // 特别奖励名称
    val pickupRewardImageUrl: String = "",       // 特别奖励图片URL
    val gaugeProgress: Double = 0.0              // 进度条百分比（0-100）
)
