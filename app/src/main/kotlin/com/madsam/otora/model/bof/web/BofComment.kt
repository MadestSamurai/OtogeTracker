package com.madsam.otora.model.bof.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.model.bof.web.BofComment
 * 创建者: MadSamurai
 * 创建时间: 2025/1/10
 * 描述: BOF评论数据
 */
data class BofComment(
    @Json(name = "user") var user: String = "",
    @Json(name = "pattern") var pattern: Any? = null,
    @Json(name = "id_code") var idCode: List<String> = listOf(),
    @Json(name = "country") var country: String = "",
    @Json(name = "vote") var vote: Int = 0,
    @Json(name = "vote_total") var voteTotal: Int = 0,
    @Json(name = "vote_ave") var voteAve: Double = 0.0,
    @Json(name = "vote_detail") var voteDetail: List<Detail> = listOf(),
    @Json(name = "short") var short: Int = 0,
    @Json(name = "short_total") var shortTotal: Int = 0,
    @Json(name = "short_ave") var shortAve: Double = 0.0,
    @Json(name = "short_comment") var shortComment: Int = 0,
    @Json(name = "short_detail") var shortDetail: List<Detail> = listOf(),
    @Json(name = "long") var long: Int = 0,
    @Json(name = "long_total") var longTotal: Int = 0,
    @Json(name = "long_ave") var longAve: Double = 0.0,
    @Json(name = "long_comment") var longComment: Int = 0,
    @Json(name = "long_detail") var longDetail: List<Detail> = listOf(),
    @Json(name = "total") var total: Int = 0,
    @Json(name = "total_ave") var totalAve: Double = 0.0
) {
    data class Detail(
        @Json(name = "score") var score: Int = 0,
        @Json(name = "eval_number") var evalNumber: String = "",
        @Json(name = "eval_position") var evalPosition: String = "",
        @Json(name = "work_number") var workNumber: Int = 0
    )
}
