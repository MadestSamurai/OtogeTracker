package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class ChunithmSheetsEntity(
    @Id var id: Long = 0,
    @Index var title: String = "",
    var type: String = "",
    @Index var difficulty: String = "",
    var levelJp: String = "",
    var levelValueJp: Double = 0.0,
    var internalLevelJp: String = "",
    var internalLevelValueJp: Double = 0.0,
    var levelCn: String = "",
    var levelValueCn: Double = 0.0,
    var noteDesigner: String = "",
    var tap: Int = 0,
    var hold: Int = 0,
    var slide: Int = 0,
    var air: Int = 0,
    var flick: Int = 0,
    var total: Int = 0,
    var jp: Boolean = false,
    var intl: Boolean = false,
    var cn: Boolean = false,
    var isSpecial: Boolean = false
) {
    constructor() : this(
        id = 0,
        title = "",
        type = "",
        difficulty = "",
        levelJp = "",
        levelValueJp = 0.0,
        internalLevelJp = "",
        internalLevelValueJp = 0.0,
        levelCn = "",
        levelValueCn = 0.0,
        noteDesigner = "",
        tap = 0,
        hold = 0,
        slide = 0,
        air = 0,
        flick = 0,
        total = 0,
        jp = false,
        intl = false,
        cn = false,
        isSpecial = false
    )
}
