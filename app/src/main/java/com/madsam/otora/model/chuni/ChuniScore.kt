package com.madsam.otora.model.chuni

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.chuni.ChuniScore
 * 创建者: MadSamurai
 * 创建时间: 2024/9/16
 * 描述: 中二节奏成绩
 */
data class ChuniScore(
    var id: String = "",
    var title: String = "",
    var genre: String = "",
    var diff: String = "",
    var token: String = "",
    var highScore: String = "",
)