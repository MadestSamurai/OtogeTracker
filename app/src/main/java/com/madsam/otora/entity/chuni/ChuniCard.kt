package com.madsam.otora.entity.chuni

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.chuni.ChuniCard
 * 创建者: MadSamurai
 * 创建时间: 2024/7/25
 * 描述: Chunithm卡片
 */
data class ChuniCard(
    var charaInfo: String = "",
    var charaBase: String = "",
    var honorBase: String = "",
    var honorText: String = "",
    var reborn: Int = 0,
    var lv: Int = 0,
    var nameIn: String = "",
    var classEmblemBase: Int = 0,
    var classEmblemTop: Int = 0,
    var rating: String = "",
    var ratingMax: String = "",
    var overpower: String = "",
    var lastPlay: String = "",
)