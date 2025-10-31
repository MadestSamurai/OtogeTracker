package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class ChunithmFriendEntity(
    @Id var id: Long = 0,
    @Index var friendCode: String = "", // 使用友人代码作为唯一标识符
    
    var friendName: String = "",
    var profileBackground: String = "",
    var reborn: Int = 0,
    var level: Int = 0,
    var rating: String = "",
    var ratingMax: String = "",
    var overpower: String = "",
    var lastPlay: String = "",
    var roleImageUrl: String = "",
    var roleBase: String = "",
    // 荣誉称号（支持最多3个）
    var honor1: String = "",
    var honor2: String = "",
    var honor3: String = "",
    // 荣誉背景类型（支持最多3个）
    var honorBase1: String = "",
    var honorBase2: String = "",
    var honorBase3: String = "",
    var isFavorite: Boolean = false,
    var isScored: Boolean = false,
    var classEmblemBase: String = "",
    var classEmblemTop: String = ""
) {
    constructor() : this(
        id = 0,
        friendCode = "",
        friendName = "",
        profileBackground = "",
        reborn = 0,
        level = 0,
        rating = "",
        ratingMax = "",
        overpower = "",
        lastPlay = "",
        roleImageUrl = "",
        roleBase = "",
        honor1 = "",
        honor2 = "",
        honor3 = "",
        honorBase1 = "",
        honorBase2 = "",
        honorBase3 = "",
        isFavorite = false,
        isScored = false,
        classEmblemBase = "",
        classEmblemTop = ""
    )
}
