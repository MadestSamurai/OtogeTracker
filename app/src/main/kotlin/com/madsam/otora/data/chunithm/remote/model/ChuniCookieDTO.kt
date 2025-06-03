package com.madsam.otora.data.chunithm.remote.model

internal data class ChuniCookieDTO(
    var token: String,
    var expires: String,
    val maxAge: String,
    val path: String,
    val sameSite: String,
    var userId: String,
    val friendCodeList: String,
    var ga: String,
    var gaKey: String,
    var gaValue: String
)
