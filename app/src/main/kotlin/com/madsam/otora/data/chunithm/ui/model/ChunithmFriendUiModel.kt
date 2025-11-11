package com.madsam.otora.data.chunithm.ui.model

import com.madsam.otora.data.chunithm.remote.model.ChunithmFriendDTO

internal data class ChunithmFriendUiModel(
    var friendName: String,
    var profileBackground: String,
    var reborn: Int = 0,
    var level: Int,
    var rating: String,
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
    constructor(chunithmFriendDTO: ChunithmFriendDTO): this (
        friendName = chunithmFriendDTO.friendName,
        profileBackground = chunithmFriendDTO.profileBackground,
        reborn = chunithmFriendDTO.reborn,
        level = chunithmFriendDTO.level,
        rating = chunithmFriendDTO.rating,
        overpower = chunithmFriendDTO.overpower,
        lastPlay = chunithmFriendDTO.lastPlay,
        roleImageUrl = chunithmFriendDTO.roleImageUrl,
        roleBase = chunithmFriendDTO.roleBase,
        classEmblemTop = chunithmFriendDTO.classEmblemTop,
        classEmblemBase = chunithmFriendDTO.classEmblemBase,
        honor1 = chunithmFriendDTO.honor1,
        honor2 = chunithmFriendDTO.honor2,
        honor3 = chunithmFriendDTO.honor3,
        honorBase1 = chunithmFriendDTO.honorBase1,
        honorBase2 = chunithmFriendDTO.honorBase2,
        honorBase3 = chunithmFriendDTO.honorBase3,
        isFavorite = chunithmFriendDTO.isFavorite,
        isScored = chunithmFriendDTO.isScored
    )
}
