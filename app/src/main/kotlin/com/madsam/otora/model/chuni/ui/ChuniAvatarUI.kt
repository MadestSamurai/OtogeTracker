package com.madsam.otora.model.chuni.ui

import com.madsam.otora.model.chuni.net.ChuniPenguin

data class ChuniAvatarUI(
    var back : String = "",
    var footR : String = "",
    var footL : String = "",
    var skin : String = "",
    var wear : String = "",
    var face : String = "",
    var faceCover : String = "",
    var head : String = "",
    var handR : String = "",
    var handL : String = "",
    var itemR : String = "",
    var itemL : String = "",
) {
    constructor(chuniPenguin: ChuniPenguin): this(
        back = chuniPenguin.back,
        footR = chuniPenguin.skinfootR,
        footL = chuniPenguin.skinfootL,
        skin = chuniPenguin.skin,
        wear = chuniPenguin.wear,
        face = chuniPenguin.face,
        faceCover = chuniPenguin.faceCover,
        head = chuniPenguin.head,
        handR = chuniPenguin.handR,
        handL = chuniPenguin.handL,
        itemR = chuniPenguin.itemR,
        itemL = chuniPenguin.itemL
    )
}
