package com.madsam.otora.data.chunithm.ui.model

import com.madsam.otora.data.chunithm.remote.model.ChuniFriendDTO

internal data class ChuniFriendUI(
    var friendName: String,
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
) {
    constructor(chuniFriendDTO: ChuniFriendDTO): this (
        friendName = chuniFriendDTO.friendName,
        profileBackground = chuniFriendDTO.profileBackground,
        reborn = chuniFriendDTO.reborn,
        level = chuniFriendDTO.level,
        rating = chuniFriendDTO.rating,
        ratingMax = chuniFriendDTO.ratingMax,
        overpower = chuniFriendDTO.overpower,
        lastPlay = chuniFriendDTO.lastPlay,
        roleImageUrl = chuniFriendDTO.roleImageUrl,
        roleBase = chuniFriendDTO.roleBase,
        classEmblemTop = chuniFriendDTO.classEmblemTop,
        classEmblemBase = chuniFriendDTO.classEmblemBase,
        honorText = chuniFriendDTO.honorText,
        honorBase = chuniFriendDTO.honorBase,
        isFavorite = chuniFriendDTO.isFavorite,
        isScored = chuniFriendDTO.isScored
    )
}
