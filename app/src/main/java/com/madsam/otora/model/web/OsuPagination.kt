package com.madsam.otora.model.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuPagination
 * 创建者: MadSamurai
 * 创建时间: 2024/3/8
 * 描述: Osu分页实体类
 */
data class OsuPagination(
    @Json(name = "has_more") var hasMore: Boolean = false
)
