package com.madsam.otora.data.chunithm.remote.model

/**
 * Chunithm 功能票数据
 */
internal data class ChunithmTicketDTO(
    val tickets: List<TicketInfo> = emptyList()   // 功能票列表
)

/**
 * 功能票信息
 */
internal data class TicketInfo(
    val name: String = "",                        // 功能票名称
    val imageUrl: String = "",                    // 功能票图片URL
    val holdCount: Int = 0,                       // 持有数量
    val description: String = ""                  // 功能票描述
)
