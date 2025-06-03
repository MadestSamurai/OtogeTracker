package com.madsam.otora.data.bof.ui.model

/**
 * 可排序接口
 * @property previousRank Int 旧索引
 * @property currentRank Int 排序索引
 */
internal interface RankTracking {
    var previousRank: Int
    var currentRank: Int
}