package com.madsam.otora.data.chunithm.ui.model

import com.madsam.otora.data.chunithm.remote.model.ChuniPenguinDTO

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
    constructor(chuniPenguinDTO: ChuniPenguinDTO): this(
        back = chuniPenguinDTO.back,
        footR = chuniPenguinDTO.skinfootR,
        footL = chuniPenguinDTO.skinfootL,
        skin = chuniPenguinDTO.skin,
        wear = chuniPenguinDTO.wear,
        face = chuniPenguinDTO.face,
        faceCover = chuniPenguinDTO.faceCover,
        head = chuniPenguinDTO.head,
        handR = chuniPenguinDTO.handR,
        handL = chuniPenguinDTO.handL,
        itemR = chuniPenguinDTO.itemR,
        itemL = chuniPenguinDTO.itemL
    )
}
