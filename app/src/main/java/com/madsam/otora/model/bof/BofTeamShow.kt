package com.madsam.otora.model.bof

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.model.bof.BofEntryShow
 * 创建者: MadSamurai
 * 创建时间: 2024/10/23
 * 描述: BOF团队数据展示实体
 */
data class BofTeamShow(
    var no: Int = 0,
    var index: Int = 0,
    var oldIndex: Int = 0,
    var team: String = "",
    var total: Double = 0.0,
    var median: String = "",
    var impr: Int = 0,
    var title1: String = "",
    var artist1: String = "",
    var fs1: String = "",
    var total1: String = "",
    var median1: String = "",
    var title2: String = "",
    var artist2: String = "",
    var fs2: String = "",
    var total2: String = "",
    var median2: String = "",
    var title3: String = "",
    var artist3: String = "",
    var fs3: String = "",
    var total3: String = "",
    var median3: String = "",
    var title4: String = "",
    var artist4: String = "",
    var fs4: String = "",
    var total4: String = "",
    var median4: String = "",
    var oldTotal: Double = 0.0,
    var oldMedian: String = "",
    var oldImpr: Int = 0,
    var rankDiff: Int = 0,
    var time: String = "",
)
