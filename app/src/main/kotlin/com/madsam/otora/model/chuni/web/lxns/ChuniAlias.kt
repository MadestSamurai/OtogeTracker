package com.madsam.otora.model.chuni.web.lxns

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.model.chuni.web.lxns.ChuniAlias
 * 创建者: MadSamurai
 * 创建时间: 2024/12/26
 * 描述: Chunithm别名
 */
data class ChuniAliases(
    @Json(name = "aliases") var aliases: List<ChuniAlias> = listOf()
) {
    data class ChuniAlias(
        @Json(name = "song_id") var id: Int = 0,
        @Json(name = "aliases") var aliases: List<String> = listOf()
    )
}