package com.madsam.otora.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    // Display 系列 - 大标题，使用Medium权重避免过细
    displayLarge = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Medium, // 改为Medium避免过细
        fontSize = 57.sp
    ),
    displayMedium = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Medium, // 改为Medium避免过细
        fontSize = 45.sp
    ),
    displaySmall = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Medium, // 改为Medium避免过细
        fontSize = 36.sp
    ),
    
    // Headline 系列 - 页面标题，使用Medium权重增强可读性
    headlineLarge = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Medium, // 改为Medium增强标题效果
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Medium, // 改为Medium增强标题效果
        fontSize = 28.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Medium, // 改为Medium增强标题效果
        fontSize = 24.sp
    ),
    
    // Title 系列 - 保持原有配置，小标题用Medium
    titleLarge = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Medium, // 使用Medium增强视觉效果
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    titleSmall = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    
    // Body 系列 - 正文使用稍重的字重提升可读性
    bodyLarge = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Normal, // 正文保持Normal，但通过多权重配置优化
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    
    // Label 系列 - 标签使用Medium保持清晰
    labelLarge = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = interTight,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp
    )
)