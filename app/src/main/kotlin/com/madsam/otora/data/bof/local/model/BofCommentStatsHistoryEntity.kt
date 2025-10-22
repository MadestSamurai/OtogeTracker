package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import java.text.SimpleDateFormat
import java.util.*

/**
 * BOF 评论统计历史实体
 * 存储用户在特定时间点的统计数据（树形时间索引扁平化后的数据）
 */
@Entity
internal data class BofCommentStatsHistoryEntity(
    @Id var id: Long = 0,
    
    // 关联用户（用户名）
    @Index var username: String = "",
    
    // 所属比赛路径
    @Index var path: String = "",
    
    // 时间戳（用于排序和查询）
    @Index var timestamp: Long = 0,
    
    // 时间组件（用于快速过滤）
    var year: Int = 0,
    var month: Int = 0,
    var day: Int = 0,
    var hour: Int = 0,
    var minute: Int = 0,
    
    // 统计数据（Stats.v 中的字段）
    var voteCount: Int = 0,      // v
    var voteTotal: Int = 0,      // vt
    var shortCount: Int = 0,     // s
    var shortTotal: Int = 0,     // st
    var shortComment: Int = 0,   // sc
    var longCount: Int = 0,      // l
    var longTotal: Int = 0,      // lt
    var longComment: Int = 0,    // lc
    var total: Int = 0           // t
) {
    constructor() : this(
        id = 0,
        username = "",
        path = "",
        timestamp = 0,
        year = 0,
        month = 0,
        day = 0,
        hour = 0,
        minute = 0,
        voteCount = 0,
        voteTotal = 0,
        shortCount = 0,
        shortTotal = 0,
        shortComment = 0,
        longCount = 0,
        longTotal = 0,
        longComment = 0,
        total = 0
    )
    
    companion object {
        /**
         * 创建时间戳
         */
        fun createTimestamp(year: Int, month: Int, day: Int, hour: Int, minute: Int): Long {
            val calendar = Calendar.getInstance()
            calendar.set(year, month - 1, day, hour, minute, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            return calendar.timeInMillis
        }
        
        /**
         * 解析时间字符串为时间戳
         */
        fun parseTimestamp(timeString: String): Long {
            return try {
                val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                format.parse(timeString)?.time ?: 0L
            } catch (e: Exception) {
                0L
            }
        }
    }
}
