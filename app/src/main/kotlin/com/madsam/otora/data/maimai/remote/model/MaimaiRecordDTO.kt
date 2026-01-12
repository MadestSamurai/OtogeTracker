package com.madsam.otora.data.maimai.remote.model

/**
 * Maimai 游戏记录统计 DTO
 */
internal data class MaimaiPlayRecordDTO(
    var difficulty: String = "",                 // 难度名称
    
    // Clear 统计
    var clearCount: Int = 0,                     // CLEAR 数量
    var clearTotal: Int = 0,                     // CLEAR 总曲数
    
    // Full Combo 统计
    var fcCount: Int = 0,                        // Full Combo 数量
    var fcTotal: Int = 0,                        // Full Combo 总曲数
    
    var fcpCount: Int = 0,                       // Full Combo+ 数量
    var fcpTotal: Int = 0,                       // Full Combo+ 总曲数
    
    var apCount: Int = 0,                        // All Perfect 数量
    var apTotal: Int = 0,                        // All Perfect 总曲数
    
    var appCount: Int = 0,                       // All Perfect+ 数量
    var appTotal: Int = 0,                       // All Perfect+ 总曲数
    
    // Sync 统计
    var fsCount: Int = 0,                        // Full Sync 数量
    var fsTotal: Int = 0,                        // Full Sync 总曲数
    
    var fspCount: Int = 0,                       // Full Sync+ 数量
    var fspTotal: Int = 0,                       // Full Sync+ 总曲数
    
    var fdxCount: Int = 0,                       // Full Sync DX 数量
    var fdxTotal: Int = 0,                       // Full Sync DX 总曲数
    
    var fdxpCount: Int = 0,                      // Full Sync DX+ 数量
    var fdxpTotal: Int = 0                       // Full Sync DX+ 总曲数
)
