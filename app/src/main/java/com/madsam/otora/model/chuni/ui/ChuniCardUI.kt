package com.madsam.otora.model.chuni.ui

import com.madsam.otora.model.chuni.net.ChuniUser
import com.madsam.otora.model.chuni.net.ChuniUserExtend

data class ChuniCardUI(
    var charaInfo: String = "",
    var charaBase: String = "",
    var honorBase: String = "",
    var honorText: String = "",
    var reborn: Int = 0,
    var lv: Int = 0,
    var nameIn: String = "",
    var classEmblemBase: Int = 0,
    var classEmblemTop: Int = 0,
    var rating: String = "",
    var ratingMax: String = "",
    var overpower: String = "",
    var lastPlay: String = "",
    var friendCode : String = "",
    var point : String = "",
    var totalPoint : String = "",
    var playCount : String = "",
) {
    constructor(chuniUser: ChuniUser, chuniUserExt: ChuniUserExtend): this(
        charaInfo = chuniUser.charaInfo,
        charaBase = chuniUser.charaBase,
        honorBase = chuniUser.honorBase,
        honorText = chuniUser.honorText,
        reborn = chuniUser.reborn,
        lv = chuniUser.lv,
        nameIn = chuniUser.nameIn,
        classEmblemBase = chuniUser.classEmblemBase,
        classEmblemTop = chuniUser.classEmblemTop,
        rating = chuniUser.rating,
        ratingMax = chuniUser.ratingMax,
        overpower = chuniUser.overpower,
        lastPlay = chuniUser.lastPlay,
        friendCode = chuniUserExt.friendCode,
        point = chuniUserExt.point,
        totalPoint = chuniUserExt.totalPoint,
        playCount = chuniUserExt.playCount
    )
}