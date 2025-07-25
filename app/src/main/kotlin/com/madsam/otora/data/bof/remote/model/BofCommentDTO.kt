package com.madsam.otora.data.bof.remote.model

import com.squareup.moshi.Json

internal data class BofCommentDTO(
    var user: String = "",
    var pattern: Any? = null,
    @param:Json(name = "id_code") var idCode: List<String> = listOf(),
    var country: String = "",
    var vote: Int = 0,
    @param:Json(name = "vote_total") var voteTotal: Int = 0,
    @param:Json(name = "vote_ave") var voteAve: Double = 0.0,
    @param:Json(name = "vote_detail") var voteDetail: List<Detail> = listOf(),
    var short: Int = 0,
    @param:Json(name = "short_total") var shortTotal: Int = 0,
    @param:Json(name = "short_ave") var shortAve: Double = 0.0,
    @param:Json(name = "short_comment") var shortComment: Int = 0,
    @param:Json(name = "short_detail") var shortDetail: List<Detail> = listOf(),
    var long: Int = 0,
    @param:Json(name = "long_total") var longTotal: Int = 0,
    @param:Json(name = "long_ave") var longAve: Double = 0.0,
    @param:Json(name = "long_comment") var longComment: Int = 0,
    @param:Json(name = "long_detail") var longDetail: List<Detail> = listOf(),
    var total: Int = 0,
    @param:Json(name = "total_ave") var totalAve: Double = 0.0
) {
    internal data class Detail(
        var score: Int = 0,
        @param:Json(name = "eval_number") var evalNumber: String = "",
        @param:Json(name = "eval_position") var evalPosition: String = "",
        @param:Json(name = "work_number") var workNumber: Int = 0
    )
}
