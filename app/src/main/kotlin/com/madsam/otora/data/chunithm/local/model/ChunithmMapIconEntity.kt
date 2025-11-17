package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Chunithm 地图头像实体
 */
@Entity
internal data class ChunithmMapIconEntity(
    @Id var id: Long = 0,
    
    @Index var idx: String = "",              // 地图头像ID（建立索引）
    var name: String = "",                    // 地图头像名称
    var imageUrl: String = "",                // 地图头像图片URL
    var token: String = "",                   // 表单token
    var isCurrentlyUsed: Boolean = false,     // 是否正在使用
    var syncedAt: Long = 0                    // 同步时间
) {
    constructor() : this(
        id = 0,
        idx = "",
        name = "",
        imageUrl = "",
        token = "",
        isCurrentlyUsed = false,
        syncedAt = 0
    )
}
