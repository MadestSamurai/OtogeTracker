package com.madsam.otora.data.chunithm.ui.model

import com.madsam.otora.data.chunithm.remote.model.ChuniUserDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniUserExtendDTO

internal data class ChuniCardUI(
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
    var honorBase: String = "",
    var honorText: String = "",
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
        honorBase = chuniUserDTO.honorBase,
        honorText = chuniUserDTO.honorText,
        friendCode = chuniUserExt.friendCode,
        point = chuniUserExt.point,
        totalPoint = chuniUserExt.totalPoint,
        playCount = chuniUserExt.playCount
    )
}