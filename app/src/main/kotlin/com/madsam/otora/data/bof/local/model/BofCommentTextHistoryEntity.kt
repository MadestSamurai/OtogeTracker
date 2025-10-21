package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import java.text.SimpleDateFormat
import java.util.*

/**
 * BOF 评论文本字段历史实体
 * 存储用户名、识别码、国家的变化历史
 */
@Entity
internal data class BofCommentTextHistoryEntity(
    @Id var id: Long = 0,
    
    // 关联用户（用户名）
    @Index var username: String = "",
    
    // 所属比赛路径
    @Index var path: String = "",
    
    // 字段类型：user, pattern, country
    @Index var fieldType: String = "",
    
    // 时间戳
    @Index var timestamp: Long = 0,
    
    // 时间字符串
    var timeString: String = "",
    
    // 字段值
    var value: String = ""
) {
    constructor() : this(
        id = 0,
        username = "",
        path = "",
        fieldType = "",
        timestamp = 0,
        timeString = "",
        value = ""
    )
    
    companion object {
        const val FIELD_TYPE_USER = "user"
        const val FIELD_TYPE_PATTERN = "pattern"
        const val FIELD_TYPE_COUNTRY = "country"
        
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
