package com.madsam.otora.data.chunithm.local.model

import io.github.xilinjia.krdb.types.RealmObject
import io.github.xilinjia.krdb.types.annotations.PrimaryKey

internal class ChuniSongsEntity : RealmObject {
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