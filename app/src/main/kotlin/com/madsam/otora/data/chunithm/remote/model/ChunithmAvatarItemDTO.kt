package com.madsam.otora.data.chunithm.remote.model

/**
 * Avatar 自定义部件 DTO
 */
data class ChunithmAvatarItemDTO(
    /** 部件 ID (idx) */
    val itemId: String = "",
    
    /** 部件名称 */
    val name: String = "",
    
    /** 部件类型 (face, head, wear, item, back, front) */
    val category: String = "",
    
    /** 部件图片 URL */
    val imageUrl: String = "",
    
    /** 是否为当前使用的部件 */
    val isCurrentlyUsed: Boolean = false,
    
    /** Token (用于设置) */
    val token: String = ""
)
