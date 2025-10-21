package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * BOF 评论用户主实体（时序数据版本）
 * 存储用户的基本信息和最新统计
 */
@Entity
internal data class BofCommentTimeSeriesEntity(
    @Id var id: Long = 0,
    
    // 用户唯一标识（用户名作为主键）
    @Index var username: String = "",
    
    // 所属比赛路径
    @Index var path: String = "",
    
    // 当前用户信息（最新值）
    var currentUser: String = "",
    var currentPattern: String = "",
    var currentCountry: String = "",
    
    // ID代码列表（JSON字符串）
    var idCodesJson: String = "[]",
    
    // 最新统计数据
    var latestVote: Int = 0,
    var latestVoteTotal: Int = 0,
    var latestShort: Int = 0,
    var latestShortTotal: Int = 0,
    var latestShortComment: Int = 0,
    var latestLong: Int = 0,
    var latestLongTotal: Int = 0,
    var latestLongComment: Int = 0,
    var latestTotal: Int = 0,
    
    // 时间范围
    var earliestTimestamp: Long = 0,
    var latestTimestamp: Long = 0,
    
    // 更新时间
    var lastUpdated: Long = 0
) {
    constructor() : this(
        id = 0,
        username = "",
        path = "",
        currentUser = "",
        currentPattern = "",
        currentCountry = "",
        idCodesJson = "[]",
        latestVote = 0,
        latestVoteTotal = 0,
        latestShort = 0,
        latestShortTotal = 0,
        latestShortComment = 0,
        latestLong = 0,
        latestLongTotal = 0,
        latestLongComment = 0,
        latestTotal = 0,
        earliestTimestamp = 0,
        latestTimestamp = 0,
        lastUpdated = 0
    )
    
    companion object {
        fun createCompositeId(path: String, username: String): String {
            return "${path}_${username}"
        }
    }
}
