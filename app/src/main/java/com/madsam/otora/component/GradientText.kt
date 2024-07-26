package com.madsam.otora.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.component.GradientText
 * 创建者: MadSamurai
 * 创建时间: 2024/7/25
 * 描述: TODO
 */

@Composable
fun GradientText(
    fontSize: Float,
    text: String,
    gradientShader: (Rect) -> Shader) {
    Box(modifier = Modifier) {
        Canvas(modifier = Modifier.fillMaxWidth()) {
            drawIntoCanvas { canvas ->
                val paint = Paint().asFrameworkPaint().apply {
                    this.isAntiAlias = true
                    textSize = fontSize.sp.toPx()
                    typeface = android.graphics.Typeface.DEFAULT_BOLD
                    // 设置渐变
                    shader = gradientShader(Rect(0f, 0f, size.width, size.height))
                }
                canvas.nativeCanvas.drawText(text, 0f, size.height / 2, paint)
            }
        }
    }
}

