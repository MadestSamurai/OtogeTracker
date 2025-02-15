package com.madsam.otora.model.chuni.net

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.chuni.ChuniCard
 * 创建者: MadSamurai
 * 创建时间: 2024/7/25
 * 描述: Chunithm卡片
 */
data class ChuniUser(
    var nameIn: String = "",
    var profileBackground: String = "",
    var reborn: Int = 0,
    var level: Int = 0,
    var rating: String = "",
    var ratingMax: String = "",
    var overpower: String = "",
    var lastPlay: String = "",
    var roleImageUrl: String = "",
    var roleBase: String = "",
    var classEmblemTop: String = "",
    var classEmblemBase: String = "",
    var honorText: String = "",
    var honorBase: String = ""
)