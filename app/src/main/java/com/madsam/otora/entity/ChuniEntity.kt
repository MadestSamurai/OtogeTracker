package com.madsam.otora.entity

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.ChuniSongsEntity
 * 创建者: MadSamurai
 * 创建时间: 2024/11/15
 * 描述: TODO
 */

class ChuniSongsEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var category: String = ""
    var title: String = ""
    var artist: String = ""
    var bpm: Double = 0.0
    var imageName: String = ""
    var version: String = ""
    var releaseDate: String = ""
    var isNew: Boolean = false
    var isLocked: Boolean = false
    var comment: String = ""
}

class ChuniSheetsEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var type: String = ""
    var difficulty: String = ""
    var level: String = ""
    var levelValue: Double = 0.0
    var internalLevel: String = ""
    var internalLevelValue: Double = 0.0
    var noteDesigner: String = ""
    var tap: Int = 0
    var hold: Int = 0
    var slide: Int = 0
    var air: Int = 0
    var flick: Int = 0
    var total: Int = 0
    var jp: Boolean = false
    var intl: Boolean = false
    var isSpecial: Boolean = false
}
