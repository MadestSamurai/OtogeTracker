package com.madsam.otora.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

val Typography = Typography(
    // Display 系列 - 大标题，使用Medium权重避免过细
    displayLarge = TextStyle(
        fontFamily = interTightSemiBold,
        fontSize = 57.sp
    ),
    displayMedium = TextStyle(
        fontFamily = interTightSemiBold,
        fontSize = 45.sp
    ),
    displaySmall = TextStyle(
        fontFamily = interTightSemiBold,
        fontSize = 36.sp
    ),
    
    // Headline 系列 - 页面标题，使用Medium权重增强可读性
    headlineLarge = TextStyle(
        fontFamily = interTightBold,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = interTightBold,
        fontSize = 28.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = interTightBold,
        fontSize = 24.sp
    ),
    
    // Title 系列 - 保持原有配置，小标题用Medium
    titleLarge = TextStyle(
        fontFamily = interTightBold,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = interTightBold,
        fontSize = 16.sp
    ),
    titleSmall = TextStyle(
        fontFamily = interTightBold,
        fontSize = 14.sp
    ),
    
    // Body 系列 - 正文使用稍重的字重提升可读性
    bodyLarge = TextStyle(
        fontFamily = interTightRegular,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = interTightRegular,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = interTightRegular,
        fontSize = 12.sp
    ),
    
    // Label 系列 - 标签使用Medium保持清晰
    labelLarge = TextStyle(
        fontFamily = interTightSemiBold,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = interTightSemiBold,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = interTightSemiBold,
        fontSize = 11.sp
    )
)