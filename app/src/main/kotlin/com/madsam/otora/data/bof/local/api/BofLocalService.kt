package com.madsam.otora.data.bof.local.api

import com.madsam.otora.data.bof.local.objectbox.BofObjectBoxService
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import com.madsam.otora.data.bof.ui.model.BofEntryUI
import com.madsam.otora.data.bof.ui.model.BofTeamUI

/**
 * BOF 数据本地服务 - ObjectBox 版本
 * 替代原来的 Realm 版本
 */
internal class BofLocalService {
    
    private val bofObjectBoxService = BofObjectBoxService()

    suspend fun getBofttEntryByTime(currentTime: Long, compareTime: Long): List<BofEntryUI> {
        return bofObjectBoxService.getBofttEntryByTime(currentTime, compareTime)
    }

    suspend fun getBofttTeamByTime(currentTime: Long, compareTime: Long): List<BofTeamUI> {
        return bofObjectBoxService.getBofttTeamByTime(currentTime, compareTime)
    }

    suspend fun getBofttCommentByTime(currentDate: String): List<BofCommentUI> {
        return bofObjectBoxService.getBofttCommentByTime(currentDate)
    }

    suspend fun getBofttEntryLatest(): List<BofEntryUI> {
        return bofObjectBoxService.getBofttEntryLatest()
    }

    suspend fun getBofttTeamLatest(): List<BofTeamUI> {
        return bofObjectBoxService.getBofttTeamLatest()
    }

    suspend fun getBofttCommentLatest(): List<BofCommentUI> {
        return bofObjectBoxService.getBofttCommentLatest()
    }
}
