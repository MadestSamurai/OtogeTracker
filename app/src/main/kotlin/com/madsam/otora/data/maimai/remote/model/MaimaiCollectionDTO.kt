package com.madsam.otora.data.maimai.remote.model

/**
 * Maimai 收藏品 DTO
 */
internal data class MaimaiCollectionDTO(
    var icons: List<IconInfo> = emptyList(),     // 头像列表
    var plates: List<PlateInfo> = emptyList(),   // 背景板列表
    var frames: List<FrameInfo> = emptyList(),   // 边框列表
    var trophies: List<TrophyInfo> = emptyList() // 姓名框列表
)

/**
 * 头像信息
 */
internal data class IconInfo(
    val id: String = "",                         // 头像 ID
    val name: String = "",                       // 头像名称
    val imageUrl: String = "",                   // 头像图片 URL
    val isOwned: Boolean = false                 // 是否拥有
)

/**
 * 背景板信息
 */
internal data class PlateInfo(
    val id: String = "",                         // 背景板 ID
    val name: String = "",                       // 背景板名称
    val imageUrl: String = "",                   // 背景板图片 URL
    val isOwned: Boolean = false                 // 是否拥有
)

/**
 * 边框信息
 */
internal data class FrameInfo(
    val id: String = "",                         // 边框 ID
    val name: String = "",                       // 边框名称
    val imageUrl: String = "",                   // 边框图片 URL
    val isOwned: Boolean = false                 // 是否拥有
)

/**
 * 姓名框信息
 */
internal data class TrophyInfo(
    val id: String = "",                         // 姓名框 ID
    val name: String = "",                       // 姓名框名称
    val isOwned: Boolean = false                 // 是否拥有
)
