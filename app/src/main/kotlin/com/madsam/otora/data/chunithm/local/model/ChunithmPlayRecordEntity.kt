package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class ChunithmPlayRecordEntity(
    @Id var id: Long = 0,
    @Index var difficulty: String = "", // difficulty level as unique identifier
    
    // Rating statistics (count, total)
    var rateSSSpCount: Int = 0,
    var rateSSSpTotal: Int = 0,
    var rateSSSCount: Int = 0,
    var rateSSSTotal: Int = 0,
    var rateSSPCount: Int = 0,
    var rateSSPTotal: Int = 0,
    var rateSSCount: Int = 0,
    var rateSSTotal: Int = 0,
    var rateSpCount: Int = 0,
    var rateSpTotal: Int = 0,
    var rateSCount: Int = 0,
    var rateSTotal: Int = 0,
    
    // Clear statistics (count, total)
    var rateClearCount: Int = 0,
    var rateClearTotal: Int = 0,
    var rateFCCount: Int = 0,
    var rateFCTotal: Int = 0,
    var rateAJCount: Int = 0,
    var rateAJTotal: Int = 0,
    var rateAJCCount: Int = 0,
    var rateAJCTotal: Int = 0,
    var rateFChainCount: Int = 0,
    var rateFChainTotal: Int = 0,
    var rateFChainPCount: Int = 0,
    var rateFChainPTotal: Int = 0,
    
    // Difficulty statistics (count, total)
    var rateHardCount: Int = 0,
    var rateHardTotal: Int = 0,
    var rateAbsCount: Int = 0,
    var rateAbsTotal: Int = 0,
    var rateAbsPCount: Int = 0,
    var rateAbsPTotal: Int = 0,
    var rateCatasCount: Int = 0,
    var rateCatasTotal: Int = 0,
    
    var lastUpdated: String = ""
) {
    constructor() : this(
        id = 0,
        difficulty = "",
        rateSSSpCount = 0,
        rateSSSpTotal = 0,
        rateSSSCount = 0,
        rateSSSTotal = 0,
        rateSSPCount = 0,
        rateSSPTotal = 0,
        rateSSCount = 0,
        rateSSTotal = 0,
        rateSpCount = 0,
        rateSpTotal = 0,
        rateSCount = 0,
        rateSTotal = 0,
        rateClearCount = 0,
        rateClearTotal = 0,
        rateFCCount = 0,
        rateFCTotal = 0,
        rateAJCount = 0,
        rateAJTotal = 0,
        rateAJCCount = 0,
        rateAJCTotal = 0,
        rateFChainCount = 0,
        rateFChainTotal = 0,
        rateFChainPCount = 0,
        rateFChainPTotal = 0,
        rateHardCount = 0,
        rateHardTotal = 0,
        rateAbsCount = 0,
        rateAbsTotal = 0,
        rateAbsPCount = 0,
        rateAbsPTotal = 0,
        rateCatasCount = 0,
        rateCatasTotal = 0,
        lastUpdated = ""
    )
}
