package com.madsam.otora.data.chunithm.ui.model

import com.madsam.otora.data.chunithm.remote.model.ChuniUserDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniUserExtendDTO

internal data class ChunithmCardUiModel(
    var nameIn: String = "",
    var profileBackground: String = "",
    var reborn: Int = 0,
    var level: Int = 0,
    var rating: String = "",
    var ratingMax: String = "",
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
    constructor(chuniUserDTO: ChuniUserDTO, chuniUserExt: ChuniUserExtendDTO): this (
        nameIn = chuniUserDTO.nameIn,
        profileBackground = chuniUserDTO.profileBackground,
        reborn = chuniUserDTO.reborn,
        level = chuniUserDTO.level,
        rating = chuniUserDTO.rating,
        ratingMax = chuniUserDTO.ratingMax,
        overpower = chuniUserDTO.overpower,
        lastPlay = chuniUserDTO.lastPlay,
        roleImageUrl = chuniUserDTO.roleImageUrl,
        roleBase = chuniUserDTO.roleBase,
        classEmblemBase = chuniUserDTO.classEmblemBase,
        classEmblemTop = chuniUserDTO.classEmblemTop,
        honor1 = chuniUserDTO.honor1,
        honor2 = chuniUserDTO.honor2,
        honor3 = chuniUserDTO.honor3,
        honorBase1 = chuniUserDTO.honorBase1,
        honorBase2 = chuniUserDTO.honorBase2,
        honorBase3 = chuniUserDTO.honorBase3,
        friendCode = chuniUserExt.friendCode,
        point = chuniUserExt.point,
        totalPoint = chuniUserExt.totalPoint,
        playCount = chuniUserExt.playCount
    )
}