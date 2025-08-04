package com.madsam.otora.data.chunithm.local.model

import io.github.xilinjia.krdb.types.RealmObject
import io.github.xilinjia.krdb.types.annotations.PrimaryKey

internal class ChuniFriendScoreEntity : RealmObject {
    @PrimaryKey
    var id: String = "" // combination of friendCode_songId_difficulty_isMyScore for unique comparison records
    
    var friendCode: String = "" // 友人代码
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
    
    // 标识这条记录是谁的分数
    var isMyScore: Boolean = true // true=我的分数, false=友人分数
    
    // 难度名称 (Basic, Advanced, Expert, Master, Ultima)
    var difficulty: String = ""
    
    // 记录创建时间
    var recordedAt: String = ""
}
