package com.madsam.otora.data.bof.local.model

import android.util.Log
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import java.text.SimpleDateFormat
import java.util.*

/**
 * BOF 评论详细评价记录实体（时序版本）
 * 存储每个用户对每个作品的详细评价信息
 */
@Entity
internal data class BofCommentDetailTimeSeriesEntity(
    @Id var id: Long = 0,
    
    // 关联用户（用户名）
    @Index var username: String = "",
    
    // 所属比赛路径
    @Index var path: String = "",
    
    // 评价类型：vote, short, long
    @Index var type: String = "",
    
    // 作品ID
    @Index var workId: String = "",
    
    // 评价时间戳
    @Index var timestamp: Long = 0,
    
    // 评价日期字符串
    var dateString: String = "",
    
    // 评分
    // > 0: 正常有效评价
    // = 0: 作品被取消资格(Disq)，评价失效
    // = -1: 评价被删除
    var score: Int = 0
) {
    companion object {
        const val TYPE_VOTE = "vote"
        const val TYPE_SHORT = "short"
        const val TYPE_LONG = "long"
        
        /**
         * 解析时间字符串为时间戳
         */
        fun parseTimestamp(timeString: String): Long {
            return try {
                val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                format.parse(timeString)?.time ?: 0L
            } catch (e: Exception) {
                Log.e("BofCommentDetailTimeSeriesEntity", "Failed to parse timestamp: $timeString", e)
                0L
            }
        }
        
        /**
         * 判断评价是否有效
         */
        fun isValidScore(score: Int): Boolean {
            return score > 0
        }
    }
}
