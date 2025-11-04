package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * 角色实体
 */
@Entity
data class ChunithmCharacterEntity(
    @Id var id: Long = 0,
    
    /** 角色 ID */
    @Index
    val charaId: String = "",
    
    /** 角色名称 */
    @Index
    val name: String = "",
    
    /** 角色图片 URL */
    val imageUrl: String = "",
    
    /** 角色边框类型 (normal, copper, silver, gold, platina) */
    val frameType: String = "",
    
    /** 角色等级 */
    val level: Int = 0,
    
    /** 经验进度条宽度 (px) */
    val expBarWidth: Int = 0,
    
    /** 是否已满级 */
    val isMaxLevel: Boolean = false,
    
    /** 技能种子图片 URL (可选) */
    val skillSeedImageUrl: String = "",
    
    /** 技能种子文本 (可选) */
    val skillSeedText: String = "",
    
    /** 技能种子版本图片 URL (可选) */
    val skillSeedVersionImageUrl: String = "",
    
    /** 是否为当前使用的角色 */
    val isCurrentlyUsed: Boolean = false,
    
    /** Token */
    val token: String = "",
    
    /** 同步时间 */
    val syncedAt: Long = System.currentTimeMillis()
) {
    companion object {
        const val FRAME_NORMAL = "normal"
        const val FRAME_COPPER = "copper"
        const val FRAME_SILVER = "silver"
        const val FRAME_GOLD = "gold"
        const val FRAME_PLATINA = "platina"
    }
}
