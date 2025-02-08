package com.madsam.otora.model.chuni.net

data class ChuniFriend (
    var friendName: String,    // 好友昵称
    var friendCode: String,    // 好友ID
    var profileBackground: String,  // 好友背景板
    var reborn: Int = 0,       // 转生次数
    var level: Int,            // 好友等级
    var rating: String,        // 好友评分
    var ratingMax: String,     // 好友最高评分
    var overpower: String,     // 好友暴走值文本
    var lastPlay: String,      // 最近游玩时间
    var roleImageUrl: String,  // 角色图片链接
    var roleBase: String,      // 角色背景板
    var classEmblemTop: String,
    var classEmblemBase: String,
    var honorText: String,     // 荣誉信息文本
    var honorBase: String,     // 荣誉背景板
    var isFavorite: Boolean = false,  // 是否已收藏
    var isScored: Boolean = false,    // 是否已加入分数对比
)