package com.madsam.otora.data.chunithm.ui.model

internal data class ChunithmSongUiModel (
    var genre: String = "",
    var title: String = "",
    var artist: String = "",
    var bpm: Double = 0.0,
    var imageName: String = "",
    var version: String = "",
    var releaseDate: String = "",
    var isNew: Boolean = false,
    var isLocked: Boolean = false,
    var comment: String = "",
    var cnId: Int = 0,
    var map: String = "",
    var aliases: String = "",
    var sheets: List<ChunithmSheetUiModel> = emptyList()
)