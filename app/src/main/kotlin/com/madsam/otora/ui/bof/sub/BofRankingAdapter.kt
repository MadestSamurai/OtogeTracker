package com.madsam.otora.ui.bof.sub

import com.madsam.otora.data.bof.local.repository.WorkRanking
import com.madsam.otora.ui.common.RankingItem

// BOF WorkRanking 的适配器
data class BofRankingItem(
    private val workRanking: WorkRanking
) : RankingItem {
    override val rank: Int = workRanking.rank
    override val title: String = workRanking.title
    override val artist: String = workRanking.artist
    override val score: Number = workRanking.score
    override val extraData: Number? = if (workRanking.impression > 0) workRanking.impression else null
    override val avgScore: Double? = if (workRanking.average > 0) workRanking.average else null
    override val medianScore: Double? = if (workRanking.median > 0) workRanking.median else null
}

// 将 WorkRanking 列表转换为 RankingItem 列表
fun List<WorkRanking>.toRankingItems(): List<RankingItem> {
    return this.map { BofRankingItem(it) }
}
