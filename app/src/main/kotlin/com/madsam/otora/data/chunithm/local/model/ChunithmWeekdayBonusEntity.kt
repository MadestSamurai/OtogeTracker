package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * 每周加成配置实体
 * 每个星期固定的加成效果，每月更新一次配置
 * isToday字段在使用时动态判断（根据手机时间，凌晨4点为分界线）
 */
@Entity
internal data class ChunithmWeekdayBonusEntity(
    @Id var id: Long = 0,
    
    @Index var weekday: String = "",        // 星期几（星期一、星期二等）
    var iconUrl: String = "",               // 加成图标URL
    var description: String = "",           // 加成描述
    
    var lastUpdated: Long = System.currentTimeMillis()
)
