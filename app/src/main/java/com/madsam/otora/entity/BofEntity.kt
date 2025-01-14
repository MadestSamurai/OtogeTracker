package com.madsam.otora.entity

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.bof.BofEntity
 * 创建者: MadSamurai
 * 创建时间: 2024/12/7
 * 描述: BOF数据实体
 */
class BofEntryEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var no: Int = 0
    var team: String = ""
    var date: String = ""
    var artist: String = ""
    var genre: String = ""
    var title: String = ""
    var regist: String = ""
    var update: String = ""
}

class BofPointEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var no: Int = 0
    var time: Long = 0
    var impr: Int = 0
    var total: Int = 0
    var median: Double = 0.0
    var avg: Double = 0.0
}

class BofTeamEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var date: String = ""
    var team: String = ""
    var title1: String = ""
    var title2: String = ""
    var title3: String = ""
    var title4: String = ""
    var artist1: String = ""
    var artist2: String = ""
    var artist3: String = ""
    var artist4: String = ""
    var fs1: String = ""
    var fs2: String = ""
    var fs3: String = ""
    var fs4: String = ""
}

class BofTeamPointEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var time: Long = 0
    var team: String = ""
    var total: Double = 0.0
    var median: String = ""
    var impr: Int = 0
    var total1: String = ""
    var median1: String = ""
    var total2: String = ""
    var median2: String = ""
    var total3: String = ""
    var median3: String = ""
    var total4: String = ""
    var median4: String = ""
}

class BofCommentEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var date: String = ""
    var user: String = ""
    var pattern: String = ""
    var country: String = ""
    var vote: Int = 0
    var voteTotal: Int = 0
    var voteAve: Double = 0.0
    var short: Int = 0
    var shortTotal: Int = 0
    var shortAve: Double = 0.0
    var shortComment: Int = 0
    var long: Int = 0
    var longTotal: Int = 0
    var longAve: Double = 0.0
    var longComment: Int = 0
    var total: Int = 0
    var totalAve: Double = 0.0
}

class BofCommentDetailEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var user: String = ""
    var score: Int = 0
    var code: String = ""
    var country: String = ""
    var workNumber: Int = 0
    var date: String = ""
    var type: String = ""
}