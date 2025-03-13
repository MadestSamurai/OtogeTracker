package com.madsam.otora.data.osu.remote.model

internal data class OsuBeatmapRecordDTO(
    var count: Int = 0,
    var items: List<OsuBeatmapItemDTO> = listOf(),
    var pagination: OsuPaginationDTO = OsuPaginationDTO()
)
