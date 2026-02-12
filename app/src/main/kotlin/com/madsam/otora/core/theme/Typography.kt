package com.madsam.otora.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    // Display 系列 - 大标题
    displayLarge = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp
    ),
    displayMedium = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp
    ),
    displaySmall = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp
    ),
    
    // Headline 系列 - 页面标题
    headlineLarge = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    
    // Title 系列 - 保持原有配置
    titleLarge = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    titleMedium = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    titleSmall = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    
    // Body 系列 - 正文使用稍重的字重提升可读性
    bodyLarge = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    
    // Label 系列
    labelLarge = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = plexFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp
    )
)