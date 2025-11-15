package com.madsam.otora.data.chunithm.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Chunithm 类别元数据实体
 */
@Entity
internal data class ChunithmCategoryEntity(
    @Id var id: Long = 0,
    @Index var category: String = ""
) {
    constructor() : this(id = 0, category = "")
}

/**
 * Chunithm 版本元数据实体
 */
@Entity
internal data class ChunithmVersionEntity(
    @Id var id: Long = 0,
    @Index var version: String = "",
    var abbr: String = "",
    var releaseDate: String = ""
) {
    constructor() : this(
        id = 0,
        version = "",
        abbr = "",
        releaseDate = ""
    )
}

/**
 * Chunithm 谱面类型元数据实体
 */
@Entity
internal data class ChunithmTypeEntity(
    @Id var id: Long = 0,
    @Index var type: String = "",
    var name: String = "",
    var abbr: String = ""
) {
    constructor() : this(
        id = 0,
        type = "",
        name = "",
        abbr = ""
    )
}

/**
 * Chunithm 难度元数据实体
 */
@Entity
internal data class ChunithmDifficultyEntity(
    @Id var id: Long = 0,
    @Index var difficulty: String = "",
    var name: String = "",
    var color: String = ""
) {
    constructor() : this(
        id = 0,
        difficulty = "",
        name = "",
        color = ""
    )
}

/**
 * Chunithm 区域元数据实体
 */
@Entity
internal data class ChunithmRegionEntity(
    @Id var id: Long = 0,
    @Index var region: String = "",
    var name: String = ""
) {
    constructor() : this(
        id = 0,
        region = "",
        name = ""
    )
}
