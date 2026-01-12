package com.madsam.otora.data.maimai.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Maimai 游戏记录实体
 */
@Entity
internal data class MaimaiPlayRecordEntity(
    @Id var id: Long = 0,
    @Index var difficulty: String = "",
    
    var clearCount: Int = 0,
    var clearTotal: Int = 0,
    var fcCount: Int = 0,
    var fcTotal: Int = 0,
    var fcpCount: Int = 0,
    var fcpTotal: Int = 0,
    var apCount: Int = 0,
    var apTotal: Int = 0,
    var appCount: Int = 0,
    var appTotal: Int = 0,
    var fsCount: Int = 0,
    var fsTotal: Int = 0,
    var fspCount: Int = 0,
    var fspTotal: Int = 0,
    var fdxCount: Int = 0,
    var fdxTotal: Int = 0,
    var fdxpCount: Int = 0,
    var fdxpTotal: Int = 0,
    var syncedAt: Long = 0
) {
    constructor() : this(
        id = 0,
        difficulty = "",
        clearCount = 0,
        clearTotal = 0,
        fcCount = 0,
        fcTotal = 0,
        fcpCount = 0,
        fcpTotal = 0,
        apCount = 0,
        apTotal = 0,
        appCount = 0,
        appTotal = 0,
        fsCount = 0,
        fsTotal = 0,
        fspCount = 0,
        fspTotal = 0,
        fdxCount = 0,
        fdxTotal = 0,
        fdxpCount = 0,
        fdxpTotal = 0,
        syncedAt = 0
    )
}
