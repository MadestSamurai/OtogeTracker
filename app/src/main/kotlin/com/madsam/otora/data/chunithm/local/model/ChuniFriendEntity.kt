package com.madsam.otora.data.chunithm.local.model

import io.github.xilinjia.krdb.types.RealmObject
import io.github.xilinjia.krdb.types.annotations.PrimaryKey

internal class ChuniFriendEntity : RealmObject {
    @PrimaryKey
    var friendCode: String = "" // 使用友人代码作为主键
    
    var friendName: String = ""
    var profileBackground: String = ""
    var reborn: Int = 0
    var level: Int = 0
    var rating: String = ""
    var ratingMax: String = ""
    var overpower: String = ""
    var lastPlay: String = ""
    var roleImageUrl: String = ""
    var roleBase: String = ""
    var honorText: String = ""
    var honorBase: String = ""
    var isFavorite: Boolean = false
    var isScored: Boolean = false
    var classEmblemBase: String = ""
    var classEmblemTop: String = ""
    
    // 记录更新时间
    var lastUpdated: String = ""
}
