package com.madsam.otora.core.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.madsam.otora.R


val plexFamily = FontFamily(
    Font(R.font.plex_light, FontWeight.Light),
    Font(R.font.plex_regular, FontWeight.Normal),
    Font(R.font.plex_medium, FontWeight.SemiBold),
    Font(R.font.plex_bold, FontWeight.Bold)
)

val plexRegular = FontFamily(
    Font(R.font.plex_regular)
)
val plexSemi = FontFamily(
    Font(R.font.plex_medium)
)
val plexBold = FontFamily(
    Font(R.font.plex_bold)
)