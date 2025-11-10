package com.madsam.otora.data.bof.local.model

import android.util.Log
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * BOF团队作品艺术家历史记录Entity
 * 存储团队作品艺术家的变更历史
 * 使用 workSlot 字段区分不同的作品位置（1-4）
 */
@Entity
internal data class  BofTeamArtistHistoryEntity(
    @Id var id: Long = 0,
    @Index var compositeTeamId: String = "", // {path}_{teamName}
    @Index var path: String = "",
    @Index var workSlot: Int = 1, // 作品槽位：1-4
    @Index var timestamp: Long = 0, // 时间戳，用于查询
    var timeString: String = "", // 原始时间字符串 "YYYY-MM-DD HH:MM:SS"
    var artist: String = "" // 艺术家名称
) {
    companion object {
        /**
         * 解析时间字符串为时间戳
         * 格式: "YYYY-MM-DD HH:MM:SS"
         */
        fun parseTimestamp(timeString: String): Long {
            return try {
                val parts = timeString.split(" ")
                if (parts.size != 2) return 0L
                
                val dateParts = parts[0].split("-")
                val timeParts = parts[1].split(":")
                
                if (dateParts.size != 3 || timeParts.size != 3) return 0L
                
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
                Log.e("BofTeamArtistHistory", "Failed to parse timestamp: $timeString", e)
                0L
            }
        }
    }
}
