package com.madsam.otora.core.icon.fa

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.icon.Fa

public val Fa.`Circle-chevron-down`: ImageVector
    get() {
        if (`_circle-chevron-down` != null) {
            return `_circle-chevron-down`!!
        }
        `_circle-chevron-down` = Builder(name = "Circle-chevron-down", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(199.0f, 305.0f)
                curveTo(189.6f, 295.6f, 189.6f, 280.4f, 199.0f, 271.1f)
                curveTo(208.4f, 261.8f, 223.6f, 261.7f, 232.9f, 271.1f)
                lineTo(319.9f, 358.1f)
                lineTo(406.9f, 271.1f)
                curveTo(416.3f, 261.7f, 431.5f, 261.7f, 440.8f, 271.1f)
                curveTo(450.1f, 280.5f, 450.2f, 295.7f, 440.8f, 305.0f)
                lineTo(337.0f, 409.0f)
                curveTo(327.6f, 418.4f, 312.4f, 418.4f, 303.1f, 409.0f)
                lineTo(199.0f, 305.0f)
                close()
            }
        }
        .build()
        return `_circle-chevron-down`!!
    }

private var `_circle-chevron-down`: ImageVector? = null
