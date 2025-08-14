package com.madsam.otora.data.bof.remote.model

/**
 * BOFTT API响应的数据结构
 * 对应work.json的原始数据格式
 */
internal data class BofTTApiResponse(
    val works: Map<String, BofTTWork>
) {
    // 将Map转换为方便使用的形式
    fun getWorksAsList(): List<BofTTWork> {
        return works.map { (id, work) ->
            work.copy(id = id)
        }
    }
}

/**
 * 单个作品的数据结构
 */
internal data class BofTTWork(
    var id: String = "",
    val Score: List<BofTTScoreYear>? = null,
    val Title: List<BofTTMetadataItem>? = null,
    val Artist: List<BofTTMetadataItem>? = null,
    val Team: String? = null,
    val Genre: String? = null
)

/**
 * 年度得分数据
 */
internal data class BofTTScoreYear(
    val y: Int, // year
    val c: List<BofTTScoreMonth> // months
)

/**
 * 月度得分数据
 */
internal data class BofTTScoreMonth(
    val m: Int, // month
    val c: List<BofTTScoreDay> // days
)

/**
 * 日度得分数据
 */
internal data class BofTTScoreDay(
    val d: Int, // day
    val c: List<BofTTScoreHour> // hours
)

/**
 * 小时得分数据
 */
internal data class BofTTScoreHour(
    val h: Int, // hour
    val c: List<BofTTScoreMinute> // minutes
)

/**
 * 分钟得分数据
 */
internal data class BofTTScoreMinute(
    val n: Int, // minute
    val v: BofTTScoreValue // value
)

/**
 * 得分值
 */
internal data class BofTTScoreValue(
    val i: Int, // index
    val t: Int, // total score
    val m: Double, // current score
    val a: Double // average score
)

/**
 * 元数据项 (标题或艺术家变更记录)
 */
internal data class BofTTMetadataItem(
    val time: String, // 时间字符串
    val value: String // 值
)
