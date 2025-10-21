package com.madsam.otora.data.bof.remote.model

import com.squareup.moshi.Json

/**
 * BOF 时序评论数据 API 响应
 * 对应 comment.json 的数据结构
 */
internal data class BofCommentTimeSeriesResponse(
    // Map<用户名, 用户数据>
    val users: Map<String, BofUserCommentData> = emptyMap()
)

/**
 * 用户评论数据
 */
internal data class BofUserCommentData(
    // 统计数据（树形时间索引）
    @param:Json(name = "Stats") val stats: List<StatsYearNode>? = null,
    
    // 文本字段（简单时间序列）
    @param:Json(name = "user") val user: List<TimeValueRecord>? = null,
    @param:Json(name = "pattern") val pattern: List<TimeValueRecord>? = null,
    @param:Json(name = "country") val country: List<TimeValueRecord>? = null,
    
    // 静态字段
    @param:Json(name = "id_code") val idCode: List<String>? = null,
    
    // 详细评价记录
    @param:Json(name = "vote_detail") val voteDetail: List<DetailRecord>? = null,
    @param:Json(name = "short_detail") val shortDetail: List<DetailRecord>? = null,
    @param:Json(name = "long_detail") val longDetail: List<DetailRecord>? = null
)

/**
 * 时间-值记录
 */
internal data class TimeValueRecord(
    @param:Json(name = "time") val time: String = "",
    @param:Json(name = "value") val value: String = ""
)

/**
 * 详细评价记录
 */
internal data class DetailRecord(
    @param:Json(name = "date") val date: String = "",
    @param:Json(name = "score") val score: Int = 0,
    @param:Json(name = "work_id") val workId: String = ""
)

/**
 * Stats 树形结构 - 年节点
 */
internal data class StatsYearNode(
    @param:Json(name = "y") val year: Int = 0,
    @param:Json(name = "c") val children: List<StatsMonthNode>? = null
)

/**
 * Stats 树形结构 - 月节点
 */
internal data class StatsMonthNode(
    @param:Json(name = "m") val month: Int = 0,
    @param:Json(name = "c") val children: List<StatsDayNode>? = null
)

/**
 * Stats 树形结构 - 日节点
 */
internal data class StatsDayNode(
    @param:Json(name = "d") val day: Int = 0,
    @param:Json(name = "c") val children: List<StatsHourNode>? = null
)

/**
 * Stats 树形结构 - 小时节点
 */
internal data class StatsHourNode(
    @param:Json(name = "h") val hour: Int = 0,
    @param:Json(name = "c") val children: List<StatsMinuteNode>? = null
)

/**
 * Stats 树形结构 - 分钟节点
 */
internal data class StatsMinuteNode(
    @param:Json(name = "n") val minute: Int = 0,
    @param:Json(name = "v") val values: StatsValue? = null
)

/**
 * Stats 值
 */
internal data class StatsValue(
    @param:Json(name = "v") val vote: Int = 0,              // 投票数
    @param:Json(name = "vt") val voteTotal: Int = 0,        // 投票总分
    @param:Json(name = "s") val short: Int = 0,             // 短评数
    @param:Json(name = "st") val shortTotal: Int = 0,       // 短评总分
    @param:Json(name = "sc") val shortComment: Int = 0,     // 短评评论数
    @param:Json(name = "l") val long: Int = 0,              // 长评数
    @param:Json(name = "lt") val longTotal: Int = 0,        // 长评总分
    @param:Json(name = "lc") val longComment: Int = 0,      // 长评评论数
    @param:Json(name = "t") val total: Int = 0              // 总计
)
