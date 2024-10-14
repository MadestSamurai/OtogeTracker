package com.madsam.otora.model.chuni

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.chuni.ChuniCookie
 * 创建者: MadSamurai
 * 创建时间: 2024/9/4
 * 描述: 中二节奏Cookie
 */
data class ChuniCookie(
    var token: String,
    var expires: String,
    val maxAge: String,
    val path: String,
    val sameSite: String,
    var userId: String,
    val friendCodeList: String
)
