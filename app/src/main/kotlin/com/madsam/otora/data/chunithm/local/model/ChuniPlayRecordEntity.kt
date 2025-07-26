package com.madsam.otora.data.chunithm.local.model

import io.github.xilinjia.krdb.types.RealmObject
import io.github.xilinjia.krdb.types.annotations.PrimaryKey

internal class ChuniPlayRecordEntity : RealmObject {
    @PrimaryKey
    var id: String = "" // difficulty level as primary key
    
    // Rating statistics (count, total)
    var rateSSSp_count: Int = 0
    var rateSSSp_total: Int = 0
    var rateSSS_count: Int = 0
    var rateSSS_total: Int = 0
    var rateSSp_count: Int = 0
    var rateSSp_total: Int = 0
    var rateSS_count: Int = 0
    var rateSS_total: Int = 0
    var rateSp_count: Int = 0
    var rateSp_total: Int = 0
    var rateS_count: Int = 0
    var rateS_total: Int = 0
    
    // Clear statistics (count, total)
    var rateClear_count: Int = 0
    var rateClear_total: Int = 0
    var rateFC_count: Int = 0
    var rateFC_total: Int = 0
    var rateAJ_count: Int = 0
    var rateAJ_total: Int = 0
    var rateAJC_count: Int = 0
    var rateAJC_total: Int = 0
    var rateFChain_count: Int = 0
    var rateFChain_total: Int = 0
    var rateFChainP_count: Int = 0
    var rateFChainP_total: Int = 0
    
    // Difficulty statistics (count, total)
    var rateHard_count: Int = 0
    var rateHard_total: Int = 0
    var rateAbs_count: Int = 0
    var rateAbs_total: Int = 0
    var rateAbsP_count: Int = 0
    var rateAbsP_total: Int = 0
    var rateCatas_count: Int = 0
    var rateCatas_total: Int = 0
    
    var lastUpdated: String = ""
}
