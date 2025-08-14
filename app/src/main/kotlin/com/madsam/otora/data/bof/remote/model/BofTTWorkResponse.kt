package com.madsam.otora.data.bof.remote.model

import com.squareup.moshi.JsonClass

/**
 * BOF TT Work数据，单个作品的原始API结构
 */
@JsonClass(generateAdapter = true)
internal data class BofTTWorkData(
    val Score: List<BofTTScoreYear>,
    val Title: List<BofTTMetadataItem>,
    val Artist: List<BofTTMetadataItem>,  
    val Team: String,
    val Genre: String
)
