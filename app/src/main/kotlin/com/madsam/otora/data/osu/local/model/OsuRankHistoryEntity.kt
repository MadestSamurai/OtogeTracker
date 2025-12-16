package com.madsam.otora.data.osu.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import io.objectbox.annotation.Unique

/**
 * osu! 排名历史实体
 * 存储用户的排名历史数据（最近90天）
 */
@Entity
internal data class OsuRankHistoryEntity(
    @Id var id: Long = 0,
    @Index var odUserId: Long = 0,         // osu! 用户ID
    var mode: String = "osu",              // 游戏模式
    @Unique var uniqueKey: String = "",    // "${odUserId}_${mode}"
    
    // 排名历史，最多90天，逗号分隔的数字
    var rankData: String = "",             // "12345,12340,12335,..."
    
    // 时间戳
    var updatedAt: Long = 0
) {
    constructor() : this(id = 0)
    
    fun getRankList(): List<Int> {
        if (rankData.isBlank()) return emptyList()
        return rankData.split(",").mapNotNull { it.toIntOrNull() }
    }
    
    fun setRankList(ranks: List<Int>) {
        rankData = ranks.joinToString(",")
    }
}
