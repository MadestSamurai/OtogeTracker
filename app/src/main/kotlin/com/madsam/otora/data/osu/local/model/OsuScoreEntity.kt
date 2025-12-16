package com.madsam.otora.data.osu.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import io.objectbox.annotation.Unique

/**
 * osu! 成绩实体
 * 存储 BP (Best Performance) 成绩
 */
@Entity
internal data class OsuScoreEntity(
    @Id var id: Long = 0,
    @Index var odUserId: Long = 0,         // osu! 用户ID
    @Unique var odScoreId: Long = 0,       // osu! 成绩ID，全局唯一
    
    // 成绩类型（"best", "first"等）
    var scoreType: String = "best",
    
    // 成绩基本信息
    var score: Long = 0,
    var maxCombo: Int = 0,
    var accuracy: Double = 0.0,
    var pp: Double = 0.0,
    var ppWeight: Double = 0.0,
    var rank: String = "",                 // SSH, SS, SH, S, A, B, C, D
    var mods: String = "",                 // 逗号分隔的mod列表
    var passed: Boolean = true,
    var perfect: Boolean = false,
    
    // 统计
    var countGeki: Int = 0,
    var count300: Int = 0,
    var countKatu: Int = 0,
    var count100: Int = 0,
    var count50: Int = 0,
    var countMiss: Int = 0,
    
    // 谱面信息
    var beatmapId: Long = 0,
    var beatmapSetId: Long = 0,
    var beatmapTitle: String = "",
    var beatmapArtist: String = "",
    var beatmapVersion: String = "",       // 难度名
    var beatmapDifficulty: Double = 0.0,   // 星级
    var beatmapBpm: Double = 0.0,
    var beatmapCs: Double = 0.0,
    var beatmapAr: Double = 0.0,
    var beatmapOd: Double = 0.0,
    var beatmapHp: Double = 0.0,
    var beatmapLength: Int = 0,
    var beatmapMode: String = "osu",
    var beatmapStatus: String = "",
    var beatmapCoverUrl: String = "",
    var beatmapCreator: String = "",
    var beatmapCreatorId: Long = 0,
    
    // 位置信息（第几个BP）
    var position: Int = 0,
    
    // 时间戳
    var playedAt: String = "",             // ISO8601 格式
    var updatedAt: Long = 0
) {
    constructor() : this(id = 0)
}
