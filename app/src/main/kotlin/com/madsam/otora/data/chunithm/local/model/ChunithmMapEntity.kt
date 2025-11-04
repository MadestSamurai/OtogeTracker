package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Chunithm 地图主表实体
 * 存储地图的基本信息和统计数据
 */
@Entity
internal data class ChunithmMapEntity(
    @Id var id: Long = 0,
    
    // 地图信息
    @Index var mapName: String = "",    // 地图名称（建立索引用于查询）
    var totalPages: Int = 0,             // 总页数
    
    // 统计信息
    var completedAreas: Int = 0,         // 已完成格子数（remain = 0）
    var totalAreas: Int = 0,             // 总格子数（非空格子）
    var progressPercentage: Double = 0.0, // 完成百分比
    
    // 时间戳
    var createdAt: Long = 0,             // 创建时间（毫秒时间戳）
    var updatedAt: Long = 0              // 最后更新时间（毫秒时间戳）
) {
    constructor() : this(
        id = 0,
        mapName = "",
        totalPages = 0,
        completedAreas = 0,
        totalAreas = 0,
        progressPercentage = 0.0,
        createdAt = 0,
        updatedAt = 0
    )
}
