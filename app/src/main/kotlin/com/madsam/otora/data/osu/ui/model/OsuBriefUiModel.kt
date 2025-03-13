package com.madsam.otora.data.osu.ui.model

/**
 * 通用简略列表项UI模型
 * 用于处理需要分页加载或部分加载的列表数据
 * @param T 列表中的数据类型
 * @property items 当前已加载的列表数据
 * @property isComplete 标识列表是否已全部加载完成
 */
internal data class OsuBriefUiModel<T>(
    val items: List<T> = emptyList(),
    val isComplete: Boolean = false
)
