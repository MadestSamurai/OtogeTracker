package com.madsam.otora.data.chunithm.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

internal class ChuniSheetsEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var title: String = ""
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
