package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class BofEntryEntity(
    @Id var id: Long = 0,
    
    @Index var entryId: String = "", // 用于存储原来的 id: "${date}_${entry.no}"
    var no: Int = 0,
    var team: String = "",
    @Index var date: String = "",
    var artist: String = "",
    var genre: String = "",
    var title: String = "",
    var regist: String = "",
    var update: String = ""
) {
    constructor() : this(
        id = 0,
        entryId = "",
        no = 0,
        team = "",
        date = "",
        artist = "",
        genre = "",
        title = "",
        regist = "",
        update = ""
    )
}
