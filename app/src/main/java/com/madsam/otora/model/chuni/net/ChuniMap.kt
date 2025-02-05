package com.madsam.otora.model.chuni.net

data class ChuniMap(
    val title: String,        // 地图标题
    val currentPage: Int,     // 当前页码
    val totalPages: Int,      // 总页数
    val areas: List<ChuniMapArea>  // 每个地图区域的信息
) {
    data class ChuniMapArea(
        val imageUrl: String?,    // 地图图标URL
        val remain: Int,          // 剩余数值
        val skillSeed: String?    // 技能种子文本（可能为"-"或其它）
    )
}
