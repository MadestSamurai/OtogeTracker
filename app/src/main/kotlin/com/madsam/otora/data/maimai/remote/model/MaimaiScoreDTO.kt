package com.madsam.otora.data.maimai.remote.model

/**
 * Maimai 乐曲成绩 DTO
 */
internal data class MaimaiScoreDTO(
    var id: String = "",                         // 乐曲 ID
    var title: String = "",                      // 乐曲标题
    var difficulty: String = "",                 // 难度 (BASIC, ADVANCED, EXPERT, MASTER, Re:MASTER)
    var level: String = "",                      // 难度等级 (如 "13+")
    var score: String = "",                      // 得分
    var rank: String = "",                       // 评级 (SSS+, SSS, SS+, SS, S+, S, AAA, AA, A, BBB, BB, B, C)
    var comboStatus: String = "",                // Combo 状态 (fc, fcp, ap, app)
    var syncStatus: String = "",                 // Sync 状态 (fs, fsp, fdx, fdxp)
    var deluxscore: String = "",                 // DX 分数
    var genre: String = "",                      // 曲风类型
    var coverUrl: String = ""                    // 封面图片 URL
)

/**
 * Maimai Rating 数据 DTO
 */
internal data class MaimaiRatingDTO(
    val type: String = "",                       // Rating 类型 (BEST, NEW)
    val songs: List<MaimaiScoreDTO> = emptyList() // 乐曲列表
)
