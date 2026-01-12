package com.madsam.otora.data.maimai.remote.model

/**
 * Maimai 用户基本信息 DTO
 */
internal data class MaimaiUserDTO(
    var userName: String = "",                   // 用户名
    var rating: String = "",                     // Rating 值
    var maxRating: String = "",                  // 最高 Rating
    var title: String = "",                      // 称号
    var titlePlate: String = "",                 // 称号版图片 URL
    var trophyName: String = "",                 // 姓名框名称
    var iconUrl: String = "",                    // 头像图片 URL
    var plateUrl: String = "",                   // 背景板图片 URL
    var frameUrl: String = "",                   // 边框图片 URL
    var playCount: Int = 0,                      // 游玩次数
    var totalScore: Long = 0L,                   // 总分数
    var starCount: Int = 0                       // 星星数量
)
