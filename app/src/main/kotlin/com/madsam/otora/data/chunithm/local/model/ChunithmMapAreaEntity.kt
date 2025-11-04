package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Chunithm 地图格子详情实体
 * 存储地图每个格子的详细信息
 */
@Entity
internal data class ChunithmMapAreaEntity(
    @Id var id: Long = 0,
    
    // 关联信息
    @Index var mapName: String = "",    // 地图名称（外键，建立索引）
    @Index var pageNumber: Int = 0,     // 页码（从1开始，建立索引）
    @Index var position: Int = 0,       // 格子位置（0-8，从左到右、从上到下）
    
    // 格子内容
    var imageUrl: String = "",           // 图标URL
    var remain: Int = 0,                 // 剩余数量
    var skillSeed: String = "",          // 技能种子
    var isEmpty: Boolean = false,        // 是否为空格子
    
    // 时间戳
    var syncedAt: Long = 0               // 同步时间（毫秒时间戳）
) {
    constructor() : this(
        id = 0,
        mapName = "",
        pageNumber = 0,
        position = 0,
        imageUrl = "",
        remain = 0,
        skillSeed = "",
        isEmpty = false,
        syncedAt = 0
    )
    
    companion object {
        /**
         * 格子位置枚举
         * 3x3 网格，从左到右、从上到下编号 0-8
         */
        enum class Position(val index: Int, val row: Int, val col: Int) {
            TOP_LEFT(0, 0, 0),
            TOP_CENTER(1, 0, 1),
            TOP_RIGHT(2, 0, 2),
            MID_LEFT(3, 1, 0),
            MID_CENTER(4, 1, 1),
            MID_RIGHT(5, 1, 2),
            BOT_LEFT(6, 2, 0),
            BOT_CENTER(7, 2, 1),
            BOT_RIGHT(8, 2, 2);
            
            companion object {
                fun fromIndex(index: Int) = entries.firstOrNull { it.index == index }
                fun fromRowCol(row: Int, col: Int) = entries.firstOrNull { it.row == row && it.col == col }
            }
        }
    }
}
