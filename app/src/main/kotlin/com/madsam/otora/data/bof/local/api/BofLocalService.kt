package com.madsam.otora.data.bof.local.api

import com.madsam.otora.data.bof.local.objectbox.BofObjectBoxService
import com.madsam.otora.data.bof.ui.model.BofCommentUI

internal class BofLocalService {
    
    private val bofObjectBoxService = BofObjectBoxService()

    suspend fun getCommentByTime(date: String): List<BofCommentUI> {
        return bofObjectBoxService.getCommentByTime(date)
    }
    
    /**
     * 获取时序评论数据
     * @param path 比赛路径
     * @param timestamp 指定的时间戳（毫秒），如果为 null 则获取最新数据
     */
    suspend fun getCommentTimeSeries(
        path: String,
        timestamp: Long? = null
    ): List<BofCommentUI> {
        return bofObjectBoxService.getCommentTimeSeriesAsUI(path, timestamp)
    }
}
