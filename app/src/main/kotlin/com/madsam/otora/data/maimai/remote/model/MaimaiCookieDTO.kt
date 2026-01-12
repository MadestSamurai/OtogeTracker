package com.madsam.otora.data.maimai.remote.model

internal data class MaimaiCookieDTO(
    var token: String,
    var userId: String,
    val friendCodeList: String
)
