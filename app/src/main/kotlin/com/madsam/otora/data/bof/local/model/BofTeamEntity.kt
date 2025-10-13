package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import io.objectbox.annotation.Unique
import io.objectbox.annotation.ConflictStrategy

/**
 * BOF团队详细数据存储Entity
 */
@Entity
internal data class BofTeamEntity(
    @Id var id: Long = 0,
    @Unique(onConflict = ConflictStrategy.REPLACE) @Index var compositeTeamId: String = "",
    @Index var path: String = "", // 比赛类型路径 (tt, bms等)
    var teamName: String = "", // 团队名称
    
    // 注意：时序数据已迁移到独立的历史表中：
    // - BofTeamScoreHistoryEntity: 分数历史
    // - BofTeamTitleHistoryEntity: 标题历史（workSlot 1-4）
    // - BofTeamArtistHistoryEntity: 艺术家历史（workSlot 1-4）
    // - BofTeamFinalStrikerHistoryEntity: 决胜作品历史（workSlot 1-4）
    
    // 缓存的当前状态用于快速查询
    var currentTitle1: String = "",
    var currentTitle2: String = "",
    var currentTitle3: String = "",
    var currentTitle4: String = "",
    var currentArtist1: String = "",
    var currentArtist2: String = "",
    var currentArtist3: String = "",
    var currentArtist4: String = "",
    var currentFinalStriker1: String = "",
    var currentFinalStriker2: String = "",
    var currentFinalStriker3: String = "",
    var currentFinalStriker4: String = "",
    
    // 查询优化索引 (只对支持的类型使用@Index)
    @Index var earliestTimestamp: Long = 0,
    @Index var latestTimestamp: Long = 0,
    var latestTotalScore: Double = 0.0,
    var latestMedian: Double = 0.0,
    var latestImpression: Double = 0.0,
    // 最新的各作品分数
    var latestScore1: Double = 0.0,
    var latestScore2: Double = 0.0,
    var latestScore3: Double = 0.0,
    var latestScore4: Double = 0.0,
    var lastUpdated: Long = 0
) {
    constructor() : this(
        id = 0,
        compositeTeamId = "",
        path = "",
        teamName = "",
        currentTitle1 = "",
        currentTitle2 = "",
        currentTitle3 = "",
        currentTitle4 = "",
        currentArtist1 = "",
        currentArtist2 = "",
        currentArtist3 = "",
        currentArtist4 = "",
        currentFinalStriker1 = "",
        currentFinalStriker2 = "",
        currentFinalStriker3 = "",
        currentFinalStriker4 = "",
        earliestTimestamp = 0,
        latestTimestamp = 0,
        latestTotalScore = 0.0,
        latestMedian = 0.0,
        latestImpression = 0.0,
        latestScore1 = 0.0,
        latestScore2 = 0.0,
        latestScore3 = 0.0,
        latestScore4 = 0.0,
        lastUpdated = 0
    )
    
    companion object {
        /**
         * 构造复合teamId
         */
        fun createCompositeTeamId(path: String, teamName: String): String {
            return "${path}_${teamName}"
        }
    }
}
