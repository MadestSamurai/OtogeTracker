package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Chunithm 名牌版实体
 */
@Entity
internal data class ChunithmNameplateEntity(
    @Id var id: Long = 0,
    
    @Index var idx: String = "",                  // 名牌版ID（建立索引）
    var name: String = "",                        // 名牌版名称
    var imageUrl: String = "",                    // 名牌版图片URL
    var token: String = "",                       // 表单token
    var isCurrentlyUsed: Boolean = false,         // 是否正在使用
    var syncedAt: Long = 0                        // 同步时间
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
