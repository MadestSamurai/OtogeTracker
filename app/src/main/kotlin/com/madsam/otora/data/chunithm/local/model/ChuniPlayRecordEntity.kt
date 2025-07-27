package com.madsam.otora.data.chunithm.local.model

import io.github.xilinjia.krdb.types.RealmObject
import io.github.xilinjia.krdb.types.annotations.PrimaryKey

internal class ChuniPlayRecordEntity : RealmObject {
    @PrimaryKey
    var id: String = "" // difficulty level as primary key
    
    // Rating statistics (count, total)
    var rateSSSpCount: Int = 0
    var rateSSSpTotal: Int = 0
    var rateSSSCount: Int = 0
    var rateSSSTotal: Int = 0
    var rateSSPCount: Int = 0
    var rateSSPTotal: Int = 0
    var rateSSCount: Int = 0
    var rateSSTotal: Int = 0
    var rateSpCount: Int = 0
    var rateSpTotal: Int = 0
    var rateSCount: Int = 0
    var rateSTotal: Int = 0
    
    // Clear statistics (count, total)
    var rateClearCount: Int = 0
    var rateClearTotal: Int = 0
    var rateFCCount: Int = 0
    var rateFCTotal: Int = 0
    var rateAJCount: Int = 0
    var rateAJTotal: Int = 0
    var rateAJCCount: Int = 0
    var rateAJCTotal: Int = 0
    var rateFChainCount: Int = 0
    var rateFChainTotal: Int = 0
    var rateFChainPCount: Int = 0
    var rateFChainPTotal: Int = 0
    
    // Difficulty statistics (count, total)
    var rateHardCount: Int = 0
    var rateHardTotal: Int = 0
    var rateAbsCount: Int = 0
    var rateAbsTotal: Int = 0
    var rateAbsPCount: Int = 0
    var rateAbsPTotal: Int = 0
    var rateCatasCount: Int = 0
    var rateCatasTotal: Int = 0
    
    var lastUpdated: String = ""
}
