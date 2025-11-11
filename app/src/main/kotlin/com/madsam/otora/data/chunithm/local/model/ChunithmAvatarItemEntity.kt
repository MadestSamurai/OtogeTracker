package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Avatar 自定义部件实体
 */
@Entity
data class ChunithmAvatarItemEntity(
    @Id var id: Long = 0,
    
    /** 部件 ID (idx) */
    @Index
    val itemId: String = "",
    
    /** 部件名称 */
    @Index
    val name: String = "",
    
    /** 部件类型 (face, head, wear, item, back, front) */
    @Index
    val category: String = "",
    
    /** 部件图片 URL */
    val imageUrl: String = "",
    
    /** 是否为当前使用的部件 */
    val isCurrentlyUsed: Boolean = false,
    
    /** Token (用于设置) */
    val token: String = "",
    
    /** 同步时间 */
    val syncedAt: Long = System.currentTimeMillis()
) {
    companion object {
        const val CATEGORY_FACE = "face"       // 面孔
        const val CATEGORY_HEAD = "head"       // 头部
        const val CATEGORY_WEAR = "wear"       // 服装
        const val CATEGORY_ITEM = "item"       // 道具
        const val CATEGORY_BACK = "back"       // 背部
        const val CATEGORY_FRONT = "front"     // 前部
    }
}
