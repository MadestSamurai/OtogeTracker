package com.madsam.otora.data.chunithm.local.model

import io.github.xilinjia.krdb.types.RealmObject
import io.github.xilinjia.krdb.types.annotations.PrimaryKey

internal class ChuniFullScoreEntity : RealmObject {
    @PrimaryKey
    var id: String = "" // combination of songId_difficulty_timestamp or unique identifier
    
    var songId: String = ""
    var title: String = ""
    var diff: String = ""
    var score: String = ""
    var genre: String = ""
    var token: String = ""
    
    // Clear status
    var isClear: Boolean = false
    var isFullCombo: Boolean = false
    var isAllJustice: Boolean = false
    var isAJC: Boolean = false
    var isFullChain: Boolean = false
    var isFullChain2: Boolean = false
    
    var rank: String = ""
    var jacket: String = ""
    var date: String = ""
    var trackNumber: String = ""
    
    // Genre name for grouping
    var genreName: String = ""
    var difficulty: String = "" // The difficulty level (Basic, Advanced, etc.)
    
    var lastUpdated: String = ""
}
