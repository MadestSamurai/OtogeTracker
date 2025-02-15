package com.madsam.otora.entity

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.ChuniSongsEntity
 * 创建者: MadSamurai
 * 创建时间: 2024/11/15
 * 描述: Chunithm歌曲实体
 */

class ChuniSongsEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var genre: String = ""
    var title: String = ""
    var artist: String = ""
    var bpm: Double = 0.0
    var imageName: String = ""
    var version: String = ""
    var releaseDate: String = ""
    var isNew: Boolean = false
    var isLocked: Boolean = false
    var comment: String = ""
    var cnId: Int = 0
    var map: String = ""
    var aliases: String = ""
}

class ChuniSheetsEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var type: String = ""
    var difficulty: String = ""
    var levelJp: String = ""
    var levelValueJp: Double = 0.0
    var internalLevelJp: String = ""
    var internalLevelValueJp: Double = 0.0
    var levelCn: String = ""
    var levelValueCn: Double = 0.0
    var noteDesigner: String = ""
    var tap: Int = 0
    var hold: Int = 0
    var slide: Int = 0
    var air: Int = 0
    var flick: Int = 0
    var total: Int = 0
    var jp: Boolean = false
    var intl: Boolean = false
    var cn: Boolean = false
    var isSpecial: Boolean = false
    var version: Int = 0
    var originId: Int = 0
    var kanji: String = ""
    var star: Int = 0
}
