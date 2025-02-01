package com.madsam.otora.model.bof.ui

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.model.bof.ui.BofCommentShow
 * 创建者: MadSamurai
 * 创建时间: 2025/1/11
 * 描述: BOF评论展示实体
 */
data class BofCommentUI(
    var index: Int = 0,
    var user: String = "",
    var pattern: String = "",
    var country: String = "",
    var vote: Int = 0,
    var voteTotal: Int = 0,
    var voteAve: Double = 0.0,
    var voteChartData: List<Int> = listOf(),
    var short: Int = 0,
    var shortTotal: Int = 0,
    var shortAve: Double = 0.0,
    var shortComment: Int = 0,
    var shortChartData: List<Int> = listOf(),
    var long: Int = 0,
    var longTotal: Int = 0,
    var longAve: Double = 0.0,
    var longComment: Int = 0,
    var longChartData: List<Int> = listOf(),
    var total: Int = 0,
    var totalAve: Double = 0.0
)