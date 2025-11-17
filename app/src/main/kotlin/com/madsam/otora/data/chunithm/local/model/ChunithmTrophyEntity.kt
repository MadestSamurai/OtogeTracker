package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Chunithm 称号实体
 */
@Entity
internal data class ChunithmTrophyEntity(
    @Id var id: Long = 0,
    
    @Index var idx: String = "",                  // 称号ID（建立索引）
    var text: String = "",                        // 称号文本
    var rarity: String = "",                      // 稀有度 (normal/silver/gold/platina)
    var description: String = "",                 // 获得条件描述
    var token: String = "",                       // 表单token
    var isCurrentlyUsed: Boolean = false,         // 是否正在使用
    var syncedAt: Long = 0                        // 同步时间
) {
    constructor() : this(
        id = 0,
        idx = "",
        text = "",
        rarity = "",
        description = "",
        token = "",
        isCurrentlyUsed = false,
        syncedAt = 0
    )
}
