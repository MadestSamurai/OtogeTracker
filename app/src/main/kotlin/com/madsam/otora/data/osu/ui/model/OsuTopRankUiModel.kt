package com.madsam.otora.data.osu.ui.model

/**
 * osu!顶级排名UI模型
 */
internal data class OsuTopRankUiModel(
    val scoreId: Long = 0,
    val cover2x: String = "",
    val bg2x: String = "",
    val beatmapSetTitle: String = "",
    val beatmapSetTitleUnicode: String = "",
    val beatmapSubTitle: String = "",
    val artist: String = "",
    val artistUnicode: String = "",
    val creator: String = "",
    val mode: String = "",
    val difficultyRating: Double = 0.0,
    val pp: Double = 0.0,
    val accuracy: String = "",
    val accuracyV2: String = "",
    val rank: String = "",
    val date: String = "",
    val maxCombo: Long = 0,
    val score: Long = 0,
    val scoreV2 : Long = 0,
    val weight: Double = 0.0,
    val weightPP: Double = 0.0,
    val mods: List<String> = listOf(),
    val beatmapId: Long = 0,
    val beatmapSetId: Long = 0,
    val status: String = ""
)