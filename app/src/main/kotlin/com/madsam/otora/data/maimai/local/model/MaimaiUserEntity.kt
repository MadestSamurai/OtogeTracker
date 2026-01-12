package com.madsam.otora.data.maimai.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Maimai 用户信息实体
 */
@Entity
internal data class MaimaiUserEntity(
    @Id var id: Long = 0,
    
    var userName: String = "",
    var rating: String = "",
    var maxRating: String = "",
    var title: String = "",
    var titlePlate: String = "",
    var trophyName: String = "",
    var iconUrl: String = "",
    var plateUrl: String = "",
    var frameUrl: String = "",
    var playCount: Int = 0,
    var totalScore: Long = 0L,
    var starCount: Int = 0,
    var syncedAt: Long = 0
) {
    constructor() : this(
        id = 0,
        userName = "",
        rating = "",
        maxRating = "",
        title = "",
        titlePlate = "",
        trophyName = "",
        iconUrl = "",
        plateUrl = "",
        frameUrl = "",
        playCount = 0,
        totalScore = 0L,
        starCount = 0,
        syncedAt = 0
    )
}
