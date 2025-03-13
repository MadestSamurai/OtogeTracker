package com.madsam.otora.data.bof.ui.model

/**
 * 可排序接口
 * @property oldIndex Int 旧索引
 * @property index Int 排序索引
 */
internal interface Rankable {
    var oldIndex: Int
    var index: Int
}