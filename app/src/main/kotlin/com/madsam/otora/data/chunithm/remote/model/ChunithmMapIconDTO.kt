package com.madsam.otora.data.chunithm.remote.model

/**
 * Chunithm 地图头像数据
 */
internal data class ChunithmMapIconDTO(
    val currentMapIcon: MapIconInfo? = null,  // 当前使用的地图头像
    val mapIcons: List<MapIconInfo> = emptyList()  // 所有地图头像列表
)

/**
 * 地图头像信息
 */
internal data class MapIconInfo(
    val idx: String = "",                     // 地图头像ID
    val name: String = "",                    // 地图头像名称
    val imageUrl: String = "",                // 地图头像图片URL
    val token: String = "",                   // 表单token
    val isCurrentlyUsed: Boolean = false      // 是否正在使用
)
