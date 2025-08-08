package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class BofCommentEntity(
    @Id var id: Long = 0,
    
    @Index var commentId: String = "", // 用于存储原来的 id: "${date}_${comment.user}${if (comment.pattern != null) "_${comment.pattern}" else ""}"
    @Index var date: String = "",
    @Index var user: String = "",
    var pattern: String = "",
    var country: String = "",
    var vote: Int = 0,
    var voteTotal: Int = 0,
    var voteAve: Double = 0.0,
    var short: Int = 0,
    var shortTotal: Int = 0,
    var shortAve: Double = 0.0,
    var shortComment: Int = 0,
    var long: Int = 0,
    var longTotal: Int = 0,
    var longAve: Double = 0.0,
    var longComment: Int = 0,
    var total: Int = 0,
    var totalAve: Double = 0.0
) {
    constructor() : this(
        id = 0,
        commentId = "",
        date = "",
        user = "",
        pattern = "",
        country = "",
        vote = 0,
        voteTotal = 0,
        voteAve = 0.0,
        short = 0,
        shortTotal = 0,
        shortAve = 0.0,
        shortComment = 0,
        long = 0,
        longTotal = 0,
        longAve = 0.0,
        longComment = 0,
        total = 0,
        totalAve = 0.0
    )
}
