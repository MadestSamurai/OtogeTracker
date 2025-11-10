package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Chunithm 登录奖励主实体
 * 存储当前的登录进度和状态
 */
@Entity
internal data class ChunithmLoginBonusEntity(
    @Id var id: Long = 0,
    
    // 月度累计签到（每月重置）
    var currentMonthDays: Int = 0,          // 本月累计签到天数
    
    // 每日连续签到（14天循环，与月度无关）
    var dailyStreakDay: Int = 0,            // 当前连续签到到第几天（1-14）
    
    // 更新时间
    var lastUpdated: Long = System.currentTimeMillis()
)
