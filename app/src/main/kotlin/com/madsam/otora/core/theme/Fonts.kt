package com.madsam.otora.core.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.madsam.otora.R

// 英文优先字体族 - Inter Tight -> Mona Sans -> Source Sans
val interTight = FontFamily(
    // Inter Tight 全字重
    Font(R.font.inter_tight_thin, FontWeight.Thin),
    Font(R.font.inter_tight_extralight, FontWeight.ExtraLight),
    Font(R.font.inter_tight_light, FontWeight.Light),
    Font(R.font.inter_tight, FontWeight.Normal),
    Font(R.font.inter_tight_medium, FontWeight.Medium),
    Font(R.font.inter_tight_semibold, FontWeight.SemiBold),
    Font(R.font.inter_tight_bold, FontWeight.Bold),
    Font(R.font.inter_tight_extrabold, FontWeight.ExtraBold),
    Font(R.font.inter_tight_black, FontWeight.Black),
    // 后备字体
    Font(R.font.source_sans)
)