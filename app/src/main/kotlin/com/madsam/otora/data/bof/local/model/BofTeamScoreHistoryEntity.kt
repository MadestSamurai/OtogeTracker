package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import java.util.Calendar

/**
 * BOF团队分数历史记录Entity
 * 存储团队在特定时间点的分数快照
 */
@Entity
internal data class BofTeamScoreHistoryEntity(
    @Id var id: Long = 0,
    @Index var compositeTeamId: String = "", // {path}_{teamName}
    @Index var path: String = "",
    @Index var timestamp: Long = 0, // 时间戳，用于查询
    
    // 时间显示字段（用于UI展示）
    var year: Int = 0,
    var month: Int = 0,
    var day: Int = 0,
    var hour: Int = 0,
    var minute: Int = 0,
    
    // 团队总分数据
    var impression: Double = 0.0,
    var total: Double = 0.0,
    var median: Double = 0.0,
    var average: Double = 0.0,
    
    // 各作品分数（total）
    var total1: Double = 0.0,
    var total2: Double = 0.0,
    var total3: Double = 0.0,
    var total4: Double = 0.0,
    
    // 各作品中位数
    var median1: Double = 0.0,
    var median2: Double = 0.0,
    var median3: Double = 0.0,
    var median4: Double = 0.0
) {
    companion object {
        /**
         * 从年月日时分创建时间戳
         */
        fun createTimestamp(year: Int, month: Int, day: Int, hour: Int, minute: Int): Long {
            val calendar = Calendar.getInstance()
            calendar.set(year, month - 1, day, hour, minute, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            return calendar.timeInMillis
        }
    }
}
