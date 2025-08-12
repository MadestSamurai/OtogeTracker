package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class ChunithmSongsEntity(
    @Id var id: Long = 0,
    var genre: String = "",
    @Index var title: String = "",
    var artist: String = "",
    var bpm: Double = 0.0,
    var imageName: String = "",
    var version: String = "",
    var releaseDate: String = "",
    var isNew: Boolean = false,
    var isLocked: Boolean = false,
    var map: String = "",
    var aliases: String = ""
) {
    constructor() : this(
        id = 0,
        genre = "",
        title = "",
        artist = "",
        bpm = 0.0,
        imageName = "",
        version = "",
        releaseDate = "",
        isNew = false,
        isLocked = false,
        map = "",
        aliases = ""
    )
}
