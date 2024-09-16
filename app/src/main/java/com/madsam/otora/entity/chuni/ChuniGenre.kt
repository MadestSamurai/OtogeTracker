package com.madsam.otora.entity.chuni

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.chuni.ChuniGenre
 * 创建者: MadSamurai
 * 创建时间: 2024/9/17
 * 描述: 中二节奏曲目类型
 */
data class ChuniGenre(
    var name : String = "",
    var fullScoreList : List<ChuniFullScore> = listOf(),
)
