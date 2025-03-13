package com.madsam.otora.data.osu.remote.model

internal data class OsuUserBeatmapDTO(
    var favourite: OsuBeatmapRecordDTO = OsuBeatmapRecordDTO(),
    var graveyard: OsuBeatmapRecordDTO = OsuBeatmapRecordDTO(),
    var guest: OsuBeatmapRecordDTO = OsuBeatmapRecordDTO(),
    var loved: OsuBeatmapRecordDTO = OsuBeatmapRecordDTO(),
    var nominated: OsuBeatmapRecordDTO = OsuBeatmapRecordDTO(),
    var pending: OsuBeatmapRecordDTO = OsuBeatmapRecordDTO(),
    var ranked: OsuBeatmapRecordDTO = OsuBeatmapRecordDTO()
)
