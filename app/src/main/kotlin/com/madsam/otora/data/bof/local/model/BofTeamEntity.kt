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
    @Unique(onConflict = ConflictStrategy.REPLACE) @Index var compositeTeamId: String = "", // {path}_{teamName} 格式的复合ID
    @Index var path: String = "", // 比赛类型路径 (tt, bms等)
    var teamName: String = "", // 团队名称
    
    // JSON数据存储 - 存储完整的嵌套结构
    var scoreDataJson: String = "", // Score数据的JSON字符串
    var title1Json: String = "", // Title1的历史数据JSON
    var title2Json: String = "", // Title2的历史数据JSON
    var title3Json: String = "", // Title3的历史数据JSON
    var title4Json: String = "", // Title4的历史数据JSON
    var artist1Json: String = "", // Artist1的历史数据JSON
    var artist2Json: String = "", // Artist2的历史数据JSON
    var artist3Json: String = "", // Artist3的历史数据JSON
    var artist4Json: String = "", // Artist4的历史数据JSON
    var finalStriker1Json: String = "", // FinalStriker1的历史数据JSON
    var finalStriker2Json: String = "", // FinalStriker2的历史数据JSON
    var finalStriker3Json: String = "", // FinalStriker3的历史数据JSON
    var finalStriker4Json: String = "", // FinalStriker4的历史数据JSON
    
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
    var latestTotalScore: Double = 0.0, // 移除@Index，Double类型不支持索引
    var latestAverage: Double = 0.0,
    var latestImpression: Double = 0.0,
    var lastUpdated: Long = 0
) {
    constructor() : this(
        id = 0,
        compositeTeamId = "",
        path = "",
        teamName = "",
        scoreDataJson = "",
        title1Json = "",
        title2Json = "",
        title3Json = "",
        title4Json = "",
        artist1Json = "",
        artist2Json = "",
        artist3Json = "",
        artist4Json = "",
        finalStriker1Json = "",
        finalStriker2Json = "",
        finalStriker3Json = "",
        finalStriker4Json = "",
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
        latestAverage = 0.0,
        latestImpression = 0.0,
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
