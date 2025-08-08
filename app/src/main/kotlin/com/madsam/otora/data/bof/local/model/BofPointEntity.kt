package com.madsam.otora.data.bof.local.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
internal data class BofPointEntity(
    @Id var id: Long = 0,
    
    @Index var pointId: String = "", // 用于存储原来的 id: "${timeInMillis}_${entry.no}"
    @Index var no: Int = 0,
    @Index var time: Long = 0, // 时间戳
    var total: Int = 0,
    var impr: Int = 0,
    var median: Double = 0.0,
    var avg: Double = 0.0
) {
    constructor() : this(
        id = 0,
        pointId = "",
        no = 0,
        time = 0,
        total = 0,
        impr = 0,
        median = 0.0,
        avg = 0.0
    )
}
