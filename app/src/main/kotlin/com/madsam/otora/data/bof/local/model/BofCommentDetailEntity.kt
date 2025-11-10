package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class BofCommentDetailEntity(
    @Id var id: Long = 0,
    
    @Index var detailId: String = "",
    @Index var user: String = "",
    var score: Int = 0,
    var code: String = "", // evalNumber
    var country: String = "", // evalPosition
    var workNumber: Int = 0,
    @Index var date: String = "",
    @Index var type: String = "" // "vote", "short", "long"
)
