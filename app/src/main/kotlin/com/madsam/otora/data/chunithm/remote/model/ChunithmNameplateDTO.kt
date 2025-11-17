package com.madsam.otora.data.chunithm.remote.model

/**
 * Chunithm 名牌版数据
 */
internal data class ChunithmNameplateDTO(
    val currentNameplate: NameplateInfo? = null,  // 当前使用的名牌版
    val nameplates: List<NameplateInfo> = emptyList()  // 所有名牌版列表
)

/**
 * 名牌版信息
 */
internal data class NameplateInfo(
    val idx: String = "",                         // 名牌版ID
    val name: String = "",                        // 名牌版名称
    val imageUrl: String = "",                    // 名牌版图片URL
    val token: String = "",                       // 表单token
    val isCurrentlyUsed: Boolean = false          // 是否正在使用
)
