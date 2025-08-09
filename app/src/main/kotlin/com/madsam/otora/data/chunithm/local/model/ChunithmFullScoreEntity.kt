package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class ChunithmFullScoreEntity(
    @Id var id: Long = 0,
    
    @Index var songId: String = "",
    @Index var title: String = "",
    @Index var diff: String = "", // 0-4 for difficulties
    var score: Int = 0,
    var genre: String = "",
    var token: String = "",
    
    // Clear status - three separate types
    var clear: String = "",
    var combo: String = "",
    var chain: String = "",
    
    var rank: Int = 0, // Rank as an integer (0-13 for D to SSS+)
    var date: String = "",
    var trackNumber: String = "",
    
    // Genre name for grouping
    var genreName: String = "",
    
    var recordedAt: String = "", // When this specific record was created (timestamp)
    @Index var isPersonalBest: Boolean = false // Whether this is the current personal best for this song+difficulty
) {
    // ObjectBox requires a no-args constructor
    constructor() : this(
        id = 0,
        songId = "",
        title = "",
        diff = "",
        score = 0,
        genre = "",
        token = "",
        clear = "",
        combo = "",
        chain = "",
        rank = 0,
        date = "",
        trackNumber = "",
        genreName = "",
        recordedAt = "",
        isPersonalBest = false
    )
}
