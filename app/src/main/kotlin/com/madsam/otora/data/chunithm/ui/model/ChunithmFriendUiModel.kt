package com.madsam.otora.data.chunithm.ui.model

import com.madsam.otora.data.chunithm.remote.model.ChuniFriendDTO

internal data class ChunithmFriendUiModel(
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
    var honor1: String,
    var honor2: String,
    var honor3: String,
    var honorBase1: String,
    var honorBase2: String,
    var honorBase3: String,
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
        honor1 = chuniFriendDTO.honor1,
        honor2 = chuniFriendDTO.honor2,
        honor3 = chuniFriendDTO.honor3,
        honorBase1 = chuniFriendDTO.honorBase1,
        honorBase2 = chuniFriendDTO.honorBase2,
        honorBase3 = chuniFriendDTO.honorBase3,
        isFavorite = chuniFriendDTO.isFavorite,
        isScored = chuniFriendDTO.isScored
    )
}
