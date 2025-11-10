package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class BofCommentEntity(
    @Id var id: Long = 0,

    @Index var commentId: String = "",
    @Index var date: String = "",
    @Index var user: String = "",
    var pattern: String = "",
    var country: String = "",
    var voteCount: Int = 0,
    var voteTotal: Int = 0,
    var voteAve: Double = 0.0,
    var shortCount: Int = 0,
    var shortTotal: Int = 0,
    var shortAve: Double = 0.0,
    var shortComment: Int = 0,
    var longCount: Int = 0,
    var longTotal: Int = 0,
    var longAve: Double = 0.0,
    var longComment: Int = 0,
    var total: Int = 0,
    var totalAve: Double = 0.0
)
