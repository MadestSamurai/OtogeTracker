package com.madsam.otora.model.chuni.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.model.chuni.web.ChuniSongs
 * 创建者: MadSamurai
 * 创建时间: 2024/11/15
 * 描述: Chunithm歌曲
 */
data class ChuniSong (
    @Json(name = "songId") var songId: String = "",
    @Json(name = "category") var category: String = "",
    @Json(name = "title") var title: String = "",
    @Json(name = "artist") var artist: String = "",
    @Json(name = "bpm") var bpm: Double = 0.0,
    @Json(name = "imageName") var imageName: String = "",
    @Json(name = "version") var version: String = "",
    @Json(name = "releaseDate") var releaseDate: String = "",
    @Json(name = "isNew") var isNew: Boolean = false,
    @Json(name = "isLocked") var isLocked: Boolean = false,
    @Json(name = "comment") var comment: String = "",
    @Json(name = "sheets") var sheets: List<ChuniSongSheet> = listOf()
)