package com.madsam.otora.data.bof.local.api

import com.madsam.otora.data.bof.local.objectbox.BofObjectBoxService
import com.madsam.otora.data.bof.ui.model.BofCommentUI

internal class BofLocalService {
    
    private val bofObjectBoxService = BofObjectBoxService()

    suspend fun getBofttCommentByTime(currentDate: String): List<BofCommentUI> {
        return bofObjectBoxService.getBofttCommentByTime(currentDate)
    }

    suspend fun getBofttCommentLatest(): List<BofCommentUI> {
        return bofObjectBoxService.getBofttCommentLatest()
    }
}
