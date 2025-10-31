package com.madsam.otora.data.chunithm.remote.model

internal data class ChuniUserDTO(
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
    // 荣誉称号（支持最多3个）
    var honor1: String = "",
    var honor2: String = "",
    var honor3: String = "",
    // 荣誉背景类型（支持最多3个）
    var honorBase1: String = "",
    var honorBase2: String = "",
    var honorBase3: String = ""
)