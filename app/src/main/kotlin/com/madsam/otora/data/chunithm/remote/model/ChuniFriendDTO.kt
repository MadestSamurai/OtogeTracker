package com.madsam.otora.data.chunithm.remote.model

internal data class ChuniFriendDTO (
    var friendName: String,
    var friendCode: String,
    var profileBackground: String,
    var reborn: Int = 0,
    var level: Int,
    var rating: String,
    var ratingMax: String,
    var overpower: String,
    var lastPlay: String,
    var roleImageUrl: String,
    var roleBase: String,
    var classEmblemTop: String,
    var classEmblemBase: String,
    var honorText: String,
    var honorBase: String,
    var isFavorite: Boolean = false,
    var isScored: Boolean = false,
)