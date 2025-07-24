package com.madsam.otora.core.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 精确文本行高控制工具
 * 解决"如何保证两行文本的高度刚好是行高"的问题
 */
object PreciseTextUtils {
    
    /**
     * 文本配置数据类
     */
    data class TextConfig(
        val fontSize: TextUnit,
        val lineHeight: TextUnit,
        val actualHeight: Dp
    ) {
        companion object {
            // 预定义的文本配置
            val primary = TextConfig(
                fontSize = 15.sp,
                lineHeight = 18.sp,
                actualHeight = 18.dp
            )
            
            val secondary = TextConfig(
                fontSize = 12.sp,
                lineHeight = 14.sp,
                actualHeight = 14.dp
            )
            
            val large = TextConfig(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                actualHeight = 22.dp
            )
        }
    }
    
    /**
     * 精确的双行文本组件
     * 确保文本高度精确匹配容器高度
     */
    @Composable
    fun PreciseTwoLineText(
        primaryText: String,
        secondaryText: String,
        modifier: Modifier = Modifier,
        primaryConfig: TextConfig = TextConfig.primary,
        secondaryConfig: TextConfig = TextConfig.secondary,
        primaryColor: Color = Color.White,
        secondaryColor: Color = Color.Gray,
        textAlign: TextAlign = TextAlign.Start,
        fontWeight: FontWeight = FontWeight.Normal
    ) {
        // 计算总高度：主文本高度 + 副文本高度
        val totalHeight = primaryConfig.actualHeight + secondaryConfig.actualHeight
        
        Column(
            modifier = modifier.height(totalHeight),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // 主文本 - 精确控制高度
            Text(
                text = primaryText,
                fontSize = primaryConfig.fontSize,
                lineHeight = primaryConfig.lineHeight,
                color = primaryColor,
                fontWeight = fontWeight,
                textAlign = textAlign,
                maxLines = 1,
                modifier = Modifier.height(primaryConfig.actualHeight)
            )
            
            // 副文本 - 精确控制高度
            Text(
                text = secondaryText,
                fontSize = secondaryConfig.fontSize,
                lineHeight = secondaryConfig.lineHeight,
                color = secondaryColor,
                fontWeight = fontWeight,
                textAlign = textAlign,
                maxLines = 1,
                modifier = Modifier.height(secondaryConfig.actualHeight)
            )
        }
    }
    
    /**
     * 精确的单行文本组件
     */
    @Composable
    fun PreciseSingleLineText(
        text: String,
        modifier: Modifier = Modifier,
        config: TextConfig = TextConfig.primary,
        color: Color = Color.White,
        textAlign: TextAlign = TextAlign.Start,
        fontWeight: FontWeight = FontWeight.Normal
    ) {
        Box(
            modifier = modifier.height(config.actualHeight),
            contentAlignment = when (textAlign) {
                TextAlign.Center -> Alignment.Center
                TextAlign.End -> Alignment.CenterEnd
                else -> Alignment.CenterStart
            }
        ) {
            Text(
                text = text,
                fontSize = config.fontSize,
                lineHeight = config.lineHeight,
                color = color,
                fontWeight = fontWeight,
                textAlign = textAlign,
                maxLines = 1,
                modifier = Modifier.height(config.actualHeight)
            )
        }
    }
    
    /**
     * 根据文本配置计算行高
     */
    fun calculateRowHeight(
        primaryConfig: TextConfig,
        secondaryConfig: TextConfig? = null,
        verticalPadding: Dp = 8.dp
    ): Dp {
        return if (secondaryConfig != null) {
            primaryConfig.actualHeight + secondaryConfig.actualHeight + verticalPadding
        } else {
            primaryConfig.actualHeight + verticalPadding
        }
    }
    
    /**
     * 从 sp 转换为 dp（近似值）
     * 注意：这是近似转换，实际转换依赖于设备的字体缩放设置
     */
    @Composable
    fun TextUnit.toDpApprox(): Dp {
        val density = LocalDensity.current
        return with(density) { this@toDpApprox.toDp() }
    }
}

/**
 * 使用示例
 */
@Composable
fun PreciseTextExample() {
    Column {
        // 示例1：精确双行文本
        PreciseTextUtils.PreciseTwoLineText(
            primaryText = "主要文本内容",
            secondaryText = "次要文本内容",
            modifier = Modifier.fillMaxWidth(),
            primaryColor = Color.White,
            secondaryColor = Color.Gray,
            textAlign = TextAlign.End
        )
        
        // 示例2：精确单行文本
        PreciseTextUtils.PreciseSingleLineText(
            text = "单行文本",
            modifier = Modifier.fillMaxWidth(),
            config = PreciseTextUtils.TextConfig.large,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        
        // 示例3：计算行高
        val rowHeight = PreciseTextUtils.calculateRowHeight(
            primaryConfig = PreciseTextUtils.TextConfig.primary,
            secondaryConfig = PreciseTextUtils.TextConfig.secondary,
            verticalPadding = 8.dp
        )
        // rowHeight = 18dp + 14dp + 8dp = 40dp
    }
}
