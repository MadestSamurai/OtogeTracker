package com.madsam.otora.data.chunithm.remote.model

internal data class ChuniFriendDTO (
    var friendName: String,
    var friendCode: String,
    var profileBackground: String,
    var reborn: Int = 0,
    var level: Int,
    var rating: String,
    var overpower: String,
    var lastPlay: String,
    var roleImageUrl: String,
    var roleBase: String,
    var classEmblemTop: String,
    var classEmblemBase: String,
    // 荣誉称号（支持最多3个）
    var honor1: String,
    var honor2: String,
    var honor3: String,
    // 荣誉背景类型（支持最多3个）
    var honorBase1: String,
    var honorBase2: String,
    var honorBase3: String,
    var isFavorite: Boolean = false,
    var isScored: Boolean = false,
)