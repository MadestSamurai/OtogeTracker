package com.madsam.otora.data.bof.local.api

import com.madsam.otora.data.bof.local.objectbox.BofObjectBoxService
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import com.madsam.otora.data.bof.ui.model.BofTeamUI

internal class BofLocalService {
    
    private val bofObjectBoxService = BofObjectBoxService()

    suspend fun getBofttTeamByTime(currentTime: Long, compareTime: Long): List<BofTeamUI> {
        return bofObjectBoxService.getBofttTeamByTime(currentTime, compareTime)
    }

    suspend fun getBofttCommentByTime(currentDate: String): List<BofCommentUI> {
        return bofObjectBoxService.getBofttCommentByTime(currentDate)
    }

    suspend fun getBofttTeamLatest(): List<BofTeamUI> {
        return bofObjectBoxService.getBofttTeamLatest()
    }

    suspend fun getBofttCommentLatest(): List<BofCommentUI> {
        return bofObjectBoxService.getBofttCommentLatest()
    }
}
