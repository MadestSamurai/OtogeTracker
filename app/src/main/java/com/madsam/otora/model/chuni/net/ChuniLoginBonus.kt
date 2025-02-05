package com.madsam.otora.model.chuni.net

data class ChuniLoginBonus(
    val currentMonth: Int,          // 当前月份
    val monthlyDays: Int,          // 当月达成天数
    val totalDays: Int             // 累计总天数
)