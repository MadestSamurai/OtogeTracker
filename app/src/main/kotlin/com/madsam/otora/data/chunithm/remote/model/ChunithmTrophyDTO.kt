package com.madsam.otora.data.chunithm.remote.model

/**
 * Chunithm 称号数据
 */
internal data class ChunithmTrophyDTO(
    val currentTrophy: TrophyInfo? = null,        // 当前使用的称号
    val trophies: List<TrophyInfo> = emptyList()  // 所有称号列表
)

/**
 * 称号信息
 */
internal data class TrophyInfo(
    val idx: String = "",                         // 称号ID
    val text: String = "",                        // 称号文本
    val rarity: String = "",                      // 稀有度 (normal/silver/gold/platina)
    val description: String = "",                 // 获得条件描述
    val token: String = "",                       // 表单token
    val isCurrentlyUsed: Boolean = false          // 是否正在使用
)
