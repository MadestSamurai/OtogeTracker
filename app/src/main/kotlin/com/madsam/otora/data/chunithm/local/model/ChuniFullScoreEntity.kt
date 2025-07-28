package com.madsam.otora.data.chunithm.local.model

import io.github.xilinjia.krdb.types.RealmObject
import io.github.xilinjia.krdb.types.annotations.PrimaryKey

internal class ChuniFullScoreEntity : RealmObject {
    @PrimaryKey
    var id: String = "" // combination of songId_difficulty_timestamp or unique identifier
    
    var songId: String = ""
    var title: String = ""
    var diff: String = ""
    var score: Int = 0
    var genre: String = ""
    var token: String = ""
    
    // Clear status - three separate types
    var clear: String = ""
    var combo: String = ""
    var chain: String = ""
    
    var rank: Int = 0 // Rank as an integer (0-13 for D to SSS+)
    var jacket: String = ""
    var date: String = ""
    var trackNumber: String = ""
    
    // Genre name for grouping
    var genreName: String = ""
    var difficulty: String = "" // The difficulty level (Basic, Advanced, etc.)
    
    var lastUpdated: String = ""
}
