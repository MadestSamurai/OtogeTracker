package com.madsam.otora.data.chunithm.local.model

import io.github.xilinjia.krdb.types.RealmObject
import io.github.xilinjia.krdb.types.annotations.PrimaryKey

internal class ChuniFriendScoreEntity : RealmObject {
    @PrimaryKey
    var id: String = "" // combination of friendCode_title_difficulty for unique comparison records
    
    var friendCode: String = "" // 友人代码
    var title: String = "" // 歌曲名称
    var score: Int = 0 // 友人分数
    
    // 友人成绩页面中只有Combo相关标记是有意义的
    var combo: String = "" // fullcombo, alljustice, ajc等
    
    // 难度名称 (Basic, Advanced, Expert, Master, Ultima)
    var difficulty: String = ""
    
    // 记录创建时间
    var recordedAt: String = ""
}
