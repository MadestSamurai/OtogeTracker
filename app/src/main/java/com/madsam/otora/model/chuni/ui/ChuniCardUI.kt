package com.madsam.otora.model.chuni.ui

import com.madsam.otora.model.chuni.net.ChuniUser
import com.madsam.otora.model.chuni.net.ChuniUserExtend

data class ChuniCardUI(
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
    constructor(chuniUser: ChuniUser, chuniUserExt: ChuniUserExtend): this (
        nameIn = chuniUser.nameIn,
        profileBackground = chuniUser.profileBackground,
        reborn = chuniUser.reborn,
        level = chuniUser.level,
        rating = chuniUser.rating,
        ratingMax = chuniUser.ratingMax,
        overpower = chuniUser.overpower,
        lastPlay = chuniUser.lastPlay,
        roleImageUrl = chuniUser.roleImageUrl,
        roleBase = chuniUser.roleBase,
        classEmblemBase = chuniUser.classEmblemBase,
        classEmblemTop = chuniUser.classEmblemTop,
        honorBase = chuniUser.honorBase,
        honorText = chuniUser.honorText,
        friendCode = chuniUserExt.friendCode,
        point = chuniUserExt.point,
        totalPoint = chuniUserExt.totalPoint,
        playCount = chuniUserExt.playCount
    )
}