package com.madsam.otora.data.bof.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * BOF API响应的数据结构
 * 对应work.json的原始数据格式
 */
internal data class BofWorkResponse(
    val works: Map<String, BofWorkData>
) {
    // 将Map转换为方便使用的形式
    fun getWorksAsList(): List<BofWorkData> {
        return works.map { (id, work) ->
            work.copy(id = id)
        }
    }
}

/**
 * BOF Work数据，单个作品的原始API结构
 */
@JsonClass(generateAdapter = true)
internal data class BofWorkData(
    var id: String = "",
    @param:Json(name = "Score") val score: List<BofScoreYear>? = null,
    @param:Json(name = "Title") val title: List<BofMetadataItem>? = null,
    @param:Json(name = "Artist") val artist: List<BofMetadataItem>? = null,
    @param:Json(name = "Team") val team: String? = null,
    @param:Json(name = "Genre") val genre: String? = null
)

/**
 * 年度得分数据
 */
internal data class BofScoreYear(
    @param:Json(name = "y") val year: Int,
    @param:Json(name = "c") val months: List<BofScoreMonth>
)

/**
 * 月度得分数据
 */
internal data class BofScoreMonth(
    @param:Json(name = "m") val month: Int,
    @param:Json(name = "c") val days: List<BofScoreDay>
)

/**
 * 日度得分数据
 */
internal data class BofScoreDay(
    @param:Json(name = "d") val day: Int,
    @param:Json(name = "c") val hours: List<BofScoreHour>
)

/**
 * 小时得分数据
 */
internal data class BofScoreHour(
    @param:Json(name = "h") val hour: Int,
    @param:Json(name = "c") val minutes: List<BofScoreMinute>
)

/**
 * 分钟得分数据
 */
internal data class BofScoreMinute(
    @param:Json(name = "n") val minute: Int,
    @param:Json(name = "v") val values: BofScoreValue
)

/**
 * 得分值
 */
internal data class BofScoreValue(
    @param:Json(name = "i") val impression: Int,
    @param:Json(name = "t") val total: Int,
    @param:Json(name = "m") val median: Double,
    @param:Json(name = "a")val average: Double
)

/**
 * 元数据项 (标题或艺术家变更记录)
 */
internal data class BofMetadataItem(
    val time: String, // 时间字符串
    val value: String // 值
)
