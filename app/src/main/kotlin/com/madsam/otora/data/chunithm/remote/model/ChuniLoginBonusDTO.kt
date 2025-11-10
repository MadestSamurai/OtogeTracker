package com.madsam.otora.data.chunithm.remote.model

import java.util.Calendar

/**
 * Chunithm 登录奖励 DTO
 */
data class ChuniLoginBonusDTO(
    // 月度累计登录
    val currentMonth: Int = 0,          // 当前月份累计登录天数
    val monthlyDays: Int = 0,           // 本月累计登录天数（deprecated，与currentMonth相同）
    val totalDays: Int = 0,             // 总累计登录天数
    val monthlyRewards: List<MonthlyReward> = emptyList(),  // 月度累计奖励列表
    
    // 每日登录奖励
    val dailyLoginDay: Int = 0,         // 当前每日登录天数（1-14天循环）
    val dailyRewards: List<DailyReward> = emptyList(),      // 每日奖励列表
    
    // 每周奖励
    val weekdayBonuses: List<WeekdayBonus> = emptyList()    // 每周七天的奖励
)

/**
 * 月度累计奖励项
 */
data class MonthlyReward(
    val day: Int = 0,                   // 需要达到的天数（如3, 6, 8等）
    val imageUrl: String = "",          // 奖励图标URL
    val rewardName: String = "",        // 奖励名称
    val isCompleted: Boolean = false    // 是否已完成
)

/**
 * 每日登录奖励项
 */
data class DailyReward(
    val day: Int = 0,                   // 第几天（1-14）
    val imageUrl: String = "",          // 奖励图标URL
    val rewardName: String = "",        // 奖励名称
    val isReceived: Boolean = false,    // 是否已领取
    val isNext: Boolean = false         // 是否是下一个待领取
)

/**
 * 每周奖励项
 */
data class WeekdayBonus(
    val weekday: String = "",           // 星期几（星期一、星期二等）
    val iconUrl: String = "",           // 奖励图标URL
    val description: String = "",       // 奖励描述
    val isToday: Boolean = false        // 是否是今天（使用时动态判断）
) {
    /**
     * 判断是否是今天（考虑凌晨4点为分界线）
     */
    fun isTodayBonus(): Boolean {
        val calendar = Calendar.getInstance()
        
        // 如果当前时间在凌晨0点到4点之间，需要看作前一天
        val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        if (currentHour < 4) {
            calendar.add(Calendar.DAY_OF_MONTH, -1)
        }
        
        // 获取当前是星期几（1=星期日, 2=星期一, ..., 7=星期六）
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        
        // 转换为中文星期
        val todayWeekday = when (dayOfWeek) {
            Calendar.SUNDAY -> "星期天"
            Calendar.MONDAY -> "星期一"
            Calendar.TUESDAY -> "星期二"
            Calendar.WEDNESDAY -> "星期三"
            Calendar.THURSDAY -> "星期四"
            Calendar.FRIDAY -> "星期五"
            Calendar.SATURDAY -> "星期六"
            else -> ""
        }
        
        return weekday == todayWeekday
    }
}