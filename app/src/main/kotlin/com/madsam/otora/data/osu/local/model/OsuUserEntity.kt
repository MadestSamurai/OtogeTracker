package com.madsam.otora.data.osu.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import io.objectbox.annotation.Unique

/**
 * osu! 用户数据实体
 * 按天存储历史记录，同一天内多次刷新只更新当天记录
 */
@Entity
internal data class OsuUserEntity(
    @Id var id: Long = 0,
    @Index var odUserId: Long = 0,         // osu! 用户ID
    @Index var dateKey: String = "",       // "2025-12-16" 格式，按天存储
    @Unique var uniqueKey: String = "",    // "${odUserId}_${dateKey}"
    
    // 用户基础信息
    var username: String = "",
    var country: String = "",
    var countryCode: String = "",
    var avatarUrl: String = "",
    var coverUrl: String = "",
    var customCoverUrl: String = "",
    var profileHue: Int = -1,              // -1 表示未设置
    var profileColour: String = "",
    var title: String = "",
    var isSupporter: Boolean = false,
    var supportLevel: Int = 0,
    var isOnline: Boolean = false,
    var isBot: Boolean = false,
    var isDeleted: Boolean = false,
    
    // 统计数据（当天快照）
    var globalRank: Int = 0,
    var countryRank: Int = 0,
    var pp: Double = 0.0,
    var playCount: Int = 0,
    var playTime: Int = 0,
    var rankedScore: Long = 0,
    var totalScore: Long = 0,
    var totalHits: Long = 0,
    var maxCombo: Int = 0,
    var accuracy: Double = 0.0,
    var levelCurrent: Int = 0,
    var levelProgress: Int = 0,
    
    // Grade counts
    var gradeSsh: Int = 0,
    var gradeSs: Int = 0,
    var gradeSh: Int = 0,
    var gradeS: Int = 0,
    var gradeA: Int = 0,
    
    // 其他
    var followerCount: Int = 0,
    var formerUsernames: String = "",      // 逗号分隔
    var tournamentBannerUrl: String = "",
    var highestRank: Int = 0,
    var highestRankDate: String = "",
    var medalCount: Int = 0,
    
    // Team信息
    var teamId: Int = 0,
    var teamName: String = "",
    var teamShortName: String = "",
    var teamFlagUrl: String = "",
    
    // 模式
    var currentMode: String = "osu",
    
    // Mania Variants
    var mania4kGlobalRank: Int = 0,
    var mania4kCountryRank: Int = 0,
    var mania7kGlobalRank: Int = 0,
    var mania7kCountryRank: Int = 0,
    
    // 时间戳
    var updatedAt: Long = 0                // 当天最后更新的毫秒时间戳
) {
    constructor() : this(id = 0)
}
