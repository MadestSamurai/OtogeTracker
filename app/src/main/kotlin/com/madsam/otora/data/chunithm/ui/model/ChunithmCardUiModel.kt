package com.madsam.otora.data.chunithm.ui.model

import com.madsam.otora.data.chunithm.remote.model.ChunithmUserDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmUserExtendDTO

internal data class ChunithmCardUiModel(
    var nameIn: String = "",
    var profileBackground: String = "",
    var reborn: Int = 0,
    var level: Int = 0,
    var rating: String = "",
    var overpower: String = "",
    var lastPlay: String = "",
    var roleImageUrl: String = "",
    var roleBase: String = "",
    var classEmblemBase: String = "",
    var classEmblemTop: String = "",
    var honor1: String = "",
    var honor2: String = "",
    var honor3: String = "",
    var honorBase1: String = "",
    var honorBase2: String = "",
    var honorBase3: String = "",
    var friendCode: String = "",
    var point: String = "",
    var totalPoint: String = "",
    var playCount: String = ""
) {
    constructor(chunithmUserDTO: ChunithmUserDTO, chuniUserExt: ChunithmUserExtendDTO): this (
        nameIn = chunithmUserDTO.nameIn,
        profileBackground = chunithmUserDTO.profileBackground,
        reborn = chunithmUserDTO.reborn,
        level = chunithmUserDTO.level,
        rating = chunithmUserDTO.rating,
        overpower = chunithmUserDTO.overpower,
        lastPlay = chunithmUserDTO.lastPlay,
        roleImageUrl = chunithmUserDTO.roleImageUrl,
        roleBase = chunithmUserDTO.roleBase,
        classEmblemBase = chunithmUserDTO.classEmblemBase,
        classEmblemTop = chunithmUserDTO.classEmblemTop,
        honor1 = chunithmUserDTO.honor1,
        honor2 = chunithmUserDTO.honor2,
        honor3 = chunithmUserDTO.honor3,
        honorBase1 = chunithmUserDTO.honorBase1,
        honorBase2 = chunithmUserDTO.honorBase2,
        honorBase3 = chunithmUserDTO.honorBase3,
        friendCode = chuniUserExt.friendCode,
        point = chuniUserExt.point,
        totalPoint = chuniUserExt.totalPoint,
        playCount = chuniUserExt.playCount
    )
}