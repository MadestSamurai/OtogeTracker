package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import io.objectbox.annotation.Unique

@Entity
internal data class BofRangeEntity(
    @Id var id: Long = 0,
    @Unique @Index var path: String = "", // 比赛类型路径
    var start: String = "", // 开始日期
    var current: String = "", // 当前日期
    var shortName: String = "", // 短名称
    var fullName: String = "", // 完整名称
    var isStart: Boolean = false, // 是否已开始
    var isEnd: Boolean = false, // 是否已结束
    var singleComment: Boolean = false, // 是否单个评论
    var lastUpdated: Long = 0 // 最后更新时间戳
) {
    constructor() : this(
        id = 0,
        path = "",
        start = "",
        current = "",
        shortName = "",
        fullName = "",
        isStart = false,
        isEnd = false,
        singleComment = false,
        lastUpdated = 0
    )
}
