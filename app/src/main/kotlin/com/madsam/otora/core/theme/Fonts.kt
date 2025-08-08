package com.madsam.otora.core.theme

import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import com.madsam.otora.R

// 英文优先字体族 - Inter Tight -> Source Sans
@OptIn(ExperimentalTextApi::class)
val interTightThin = FontFamily(
    Font(R.font.inter_tight_thin),
    Font(R.font.source_sans, variationSettings = FontVariation.Settings(
        FontVariation.weight(100)
    ))
)

@OptIn(ExperimentalTextApi::class)
val interTightExtraLight = FontFamily(
    Font(R.font.inter_tight_extralight),
    Font(R.font.source_sans, variationSettings = FontVariation.Settings(
        FontVariation.weight(200)
    ))
)

@OptIn(ExperimentalTextApi::class)
val interTightLight = FontFamily(
    Font(R.font.inter_tight_light),
    Font(R.font.source_sans, variationSettings = FontVariation.Settings(
        FontVariation.weight(300)
    ))
)

@OptIn(ExperimentalTextApi::class)
val interTightRegular = FontFamily(
    Font(R.font.inter_tight),
    Font(R.font.source_sans, variationSettings = FontVariation.Settings(
        FontVariation.weight(400)
    ))
)

@OptIn(ExperimentalTextApi::class)
val interTightMedium = FontFamily(
    Font(R.font.inter_tight_medium),
    Font(R.font.source_sans, variationSettings = FontVariation.Settings(
        FontVariation.weight(500)
    ))
)

@OptIn(ExperimentalTextApi::class)
val interTightSemiBold = FontFamily(
    Font(R.font.inter_tight_semibold),
    Font(R.font.source_sans, variationSettings = FontVariation.Settings(
        FontVariation.weight(600)
    ))
)

@OptIn(ExperimentalTextApi::class)
val interTightBold = FontFamily(
    Font(R.font.inter_tight_bold),
    Font(R.font.source_sans, variationSettings = FontVariation.Settings(
        FontVariation.weight(700)
    ))
)

@OptIn(ExperimentalTextApi::class)
val interTightExtraBold = FontFamily(
    Font(R.font.inter_tight_extrabold),
    Font(R.font.source_sans, variationSettings = FontVariation.Settings(
        FontVariation.weight(800)
    ))
)

@OptIn(ExperimentalTextApi::class)
val interTightBlack = FontFamily(
    Font(R.font.inter_tight_black),
    Font(R.font.source_sans, variationSettings = FontVariation.Settings(
        FontVariation.weight(900)
    ))
)