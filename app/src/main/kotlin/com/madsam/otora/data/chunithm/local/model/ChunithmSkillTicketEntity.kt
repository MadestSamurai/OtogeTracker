package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Chunithm 技能实体
 */
@Entity
internal data class ChunithmSkillEntity(
    @Id var id: Long = 0,
    
    var idx: String = "",                         // 技能ID
    var iconUrl: String = "",                     // 技能图标URL
    var versionIconUrl: String = "",              // 版本图标URL
    var name: String = "",                        // 技能名称
    var level: Int = 0,                           // 技能等级
    var description: String = "",                 // 技能描述
    var token: String = "",                       // 表单token
    var isCurrentlyUsed: Boolean = false,         // 是否正在使用
    var syncedAt: Long = 0                        // 同步时间
) {
    constructor() : this(
        id = 0,
        idx = "",
        iconUrl = "",
        versionIconUrl = "",
        name = "",
        level = 0,
        description = "",
        token = "",
        isCurrentlyUsed = false,
        syncedAt = 0
    )
}

/**
 * Chunithm 功能票实体
 */
@Entity
internal data class ChunithmTicketEntity(
    @Id var id: Long = 0,
    
    var name: String = "",                        // 功能票名称
    var imageUrl: String = "",                    // 功能票图片URL
    var holdCount: Int = 0,                       // 持有数量
    var description: String = "",                 // 功能票描述
    var syncedAt: Long = 0                        // 同步时间
) {
    constructor() : this(
        id = 0,
        name = "",
        imageUrl = "",
        holdCount = 0,
        description = "",
        syncedAt = 0
    )
}
