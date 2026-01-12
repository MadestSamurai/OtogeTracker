package com.madsam.otora.data.maimai.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Maimai 收藏品实体基类
 */
@Entity
internal data class MaimaiCollectionEntity(
    @Id var id: Long = 0,
    
    @Index var itemId: String = "",              // 物品 ID
    var name: String = "",                       // 物品名称
    @Index var category: String = "",            // 类别 (icon, plate, frame, trophy)
    var imageUrl: String = "",                   // 图片 URL
    var isOwned: Boolean = false,                // 是否拥有
    var syncedAt: Long = 0
) {
    constructor() : this(
        id = 0,
        itemId = "",
        name = "",
        category = "",
        imageUrl = "",
        isOwned = false,
        syncedAt = 0
    )
    
    companion object {
        const val CATEGORY_ICON = "icon"
        const val CATEGORY_PLATE = "plate"
        const val CATEGORY_FRAME = "frame"
        const val CATEGORY_TROPHY = "trophy"
    }
}
