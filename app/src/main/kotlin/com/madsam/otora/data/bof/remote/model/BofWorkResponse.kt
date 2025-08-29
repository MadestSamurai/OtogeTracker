package com.madsam.otora.data.bof.remote.model

import com.squareup.moshi.JsonClass

/**
 * BOF API响应的数据结构
 * 对应work.json的原始数据格式
 */
internal data class BofApiResponse(
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
    val Score: List<BofScoreYear>? = null,
    val Title: List<BofMetadataItem>? = null,
    val Artist: List<BofMetadataItem>? = null,
    val Team: String? = null,
    val Genre: String? = null
)

/**
 * 年度得分数据
 */
internal data class BofScoreYear(
    val y: Int, // year
    val c: List<BofScoreMonth> // months
)

/**
 * 月度得分数据
 */
internal data class BofScoreMonth(
    val m: Int, // month
    val c: List<BofScoreDay> // days
)

/**
 * 日度得分数据
 */
internal data class BofScoreDay(
    val d: Int, // day
    val c: List<BofScoreHour> // hours
)

/**
 * 小时得分数据
 */
internal data class BofScoreHour(
    val h: Int, // hour
    val c: List<BofScoreMinute> // minutes
)

/**
 * 分钟得分数据
 */
internal data class BofScoreMinute(
    val n: Int, // minute
    val v: BofScoreValue // value
)

/**
 * 得分值
 */
internal data class BofScoreValue(
    val i: Int, // index
    val t: Int, // total score
    val m: Double, // current score
    val a: Double // average score
)

/**
 * 元数据项 (标题或艺术家变更记录)
 */
internal data class BofMetadataItem(
    val time: String, // 时间字符串
    val value: String // 值
)
