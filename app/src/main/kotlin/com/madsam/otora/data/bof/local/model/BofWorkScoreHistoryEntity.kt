package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * BOF 作品分数历史记录实体
 * 存储每个时间点的分数数据
 */
@Entity
internal data class BofWorkScoreHistoryEntity(
    @Id var id: Long = 0,
    
    // 关联到作品
    @Index var compositeWorkId: String = "", // 关联到 BofWorkEntity
    @Index var path: String = "", // 比赛类型路径，冗余字段便于查询
    
    // 时间信息 - 只索引 timestamp 用于高效时序查询
    @Index var timestamp: Long = 0, // 时间戳，用于快速查询和排序（主要索引）
    var year: Int = 0,               // 年份，仅用于显示和调试
    var month: Int = 0,              // 月份，仅用于显示和调试
    var day: Int = 0,                // 日期，仅用于显示和调试
    var hour: Int = 0,               // 小时，仅用于显示和调试
    var minute: Int = 0,             // 分钟，仅用于显示和调试
    
    // 分数数据 (对应 JSON 中的 v 对象)
    var impression: Int = 0,      // i: impression count (评价数)
    var total: Int = 0,            // t: total score (总分)
    var median: Double = 0.0,      // m: median score (中位数)
    var average: Double = 0.0      // a: average score (平均分)
) {
    companion object {
        /**
         * 从年月日时分创建时间戳
         */
        fun createTimestamp(year: Int, month: Int, day: Int, hour: Int, minute: Int): Long {
            val calendar = java.util.Calendar.getInstance()
            calendar.set(year, month - 1, day, hour, minute, 0)
            calendar.set(java.util.Calendar.MILLISECOND, 0)
            return calendar.timeInMillis
        }
    }
}
