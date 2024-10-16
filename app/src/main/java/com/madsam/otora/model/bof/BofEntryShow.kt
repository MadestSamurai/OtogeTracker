package com.madsam.otora.model.bof

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.model.bof.BofEntryShow
 * 创建者: MadSamurai
 * 创建时间: 2024/10/17
 * 描述: BOF数据展示实体
 */
data class BofEntryShow(
    var no: Int = 0,
    var team: String = "",
    var artist: String = "",
    var genre: String = "",
    var title: String = "",
    var regist: String = "",
    var update: String = "",
    var impr: Int = 0,
    var total: Int = 0,
    var median: Double = 0.0,
    var avg: Double = 0.0,
    var oldImpr: Int = 0,
    var oldTotal: Int = 0,
    var oldMedian: Double = 0.0,
    var oldAvg: Double = 0.0,
)
