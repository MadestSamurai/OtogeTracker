package com.madsam.otora.data.chunithm.ui.model

import com.madsam.otora.data.chunithm.remote.model.ChunithmPenguinDTO

internal data class ChunithmAvatarUiModel(
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
    constructor(chunithmPenguinDTO: ChunithmPenguinDTO): this(
        back = chunithmPenguinDTO.back,
        footR = chunithmPenguinDTO.skinfootR,
        footL = chunithmPenguinDTO.skinfootL,
        skin = chunithmPenguinDTO.skin,
        wear = chunithmPenguinDTO.wear,
        face = chunithmPenguinDTO.face,
        faceCover = chunithmPenguinDTO.faceCover,
        head = chunithmPenguinDTO.head,
        handR = chunithmPenguinDTO.handR,
        handL = chunithmPenguinDTO.handL,
        itemR = chunithmPenguinDTO.itemR,
        itemL = chunithmPenguinDTO.itemL
    )
}
