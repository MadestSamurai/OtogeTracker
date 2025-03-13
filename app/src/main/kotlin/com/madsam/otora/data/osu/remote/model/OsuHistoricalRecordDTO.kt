package com.madsam.otora.data.osu.remote.model

internal data class OsuHistoricalRecordDTO(
    var count: Int = 0,
    var items: List<OsuHistoricalItemDTO> = listOf(),
    var pagination: OsuPaginationDTO = OsuPaginationDTO()
)
