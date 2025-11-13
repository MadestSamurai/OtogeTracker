package com.madsam.otora.data.chunithm.ui.model

/**
 * PlayData 分类方式枚举
 */
enum class PlayDataCategoryType {
    DIFFICULTY,  // 难度分类（Basic/Advanced/Expert/Master/Ultima）
    GENRE,       // 类型分类（POPS & ANIME, niconico, 東方Project 等）
    VERSION,     // 版本分类（CHUNITHM, AIR, STAR 等）
    LEVEL        // 定数分类（1-5, 6-10, 11-12, 12+, 13, 13+, 14, 14+, 15）
}

/**
 * PlayData 分类信息
 */
data class PlayDataCategory(
    val type: PlayDataCategoryType,
    val name: String,          // 显示名称
    val key: String,           // 用于查询的键（如 difficulty="master", genre="POPS & ANIME"）
    val color: androidx.compose.ui.graphics.Color? = null  // 可选的颜色标识
)

/**
 * PlayData 分类数据（通用结构，适用于所有分类方式）
 */
data class PlayDataCategoryStats(
    val category: PlayDataCategory,
    val scoreTotal: Long = 0,
    val totalSongs: Int = 0,
    
    // Rating statistics
    val rateSSSp: Int = 0,
    val rateSSS: Int = 0,
    val rateSSp: Int = 0,
    val rateSS: Int = 0,
    val rateSp: Int = 0,
    val rateS: Int = 0,
    
    // Clear statistics
    val rateClear: Int = 0,
    val rateHard: Int = 0,
    val rateBrave: Int = 0,
    val rateAbs: Int = 0,
    val rateCatas: Int = 0,
    
    // Combo & Chain statistics
    val rateFC: Int = 0,
    val rateAJ: Int = 0,
    val rateAJC: Int = 0,
    val rateFChain: Int = 0,
    val rateFChainP: Int = 0
)
