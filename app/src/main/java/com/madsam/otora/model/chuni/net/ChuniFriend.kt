package com.madsam.otora.model.chuni.net

data class ChuniFriend (
    val friendName: String,    // 好友昵称
    val level: Int,            // 好友等级
    val ratingMax: String,     // 好友最高评分
    val overpower: String,     // 好友暴走值文本
    val lastPlayDate: String,  // 最近游玩时间
    val roleImageUrl: String,  // 角色图片链接
    val honorText: String      // 荣誉信息文本
)