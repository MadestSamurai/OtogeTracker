package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * BOF 作品标题历史记录实体
 * 存储标题变更历史
 */
@Entity
internal data class BofWorkTitleHistoryEntity(
    @Id var id: Long = 0,
    
    // 关联到作品
    @Index var compositeWorkId: String = "", // 关联到 BofWorkEntity
    @Index var path: String = "", // 比赛类型路径，冗余字段便于查询
    
    // 时间信息
    @Index var timestamp: Long = 0, // 解析后的时间戳
    var timeString: String = "", // 原始时间字符串 "YYYY-MM-DD HH:MM:SS"
    
    // 标题值
    var title: String = ""
) {
    constructor() : this(
        id = 0,
        compositeWorkId = "",
        path = "",
        timestamp = 0,
        timeString = "",
        title = ""
    )
    
    companion object {
        /**
         * 从时间字符串解析时间戳
         * 格式: "2024-10-21 23:00:14"
         */
        fun parseTimestamp(timeString: String): Long {
            return try {
                val parts = timeString.split(" ")
                val dateParts = parts[0].split("-")
                val timeParts = parts[1].split(":")
                
                val year = dateParts[0].toInt()
                val month = dateParts[1].toInt()
                val day = dateParts[2].toInt()
                val hour = timeParts[0].toInt()
                val minute = timeParts[1].toInt()
                val second = timeParts[2].toInt()
                
                val calendar = java.util.Calendar.getInstance()
                calendar.set(year, month - 1, day, hour, minute, second)
                calendar.set(java.util.Calendar.MILLISECOND, 0)
                calendar.timeInMillis
            } catch (e: Exception) {
                0L
            }
        }
    }
}
