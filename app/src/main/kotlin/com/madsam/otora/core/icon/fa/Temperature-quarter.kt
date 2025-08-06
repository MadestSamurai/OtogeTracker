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

public val Fa.`Temperature-quarter`: ImageVector
    get() {
        if (`_temperature-quarter` != null) {
            return `_temperature-quarter`!!
        }
        `_temperature-quarter` = Builder(name = "Temperature-quarter", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(267.0f, 64.0f, 224.0f, 107.0f, 224.0f, 160.0f)
                lineTo(224.0f, 324.7f)
                curveTo(194.5f, 351.0f, 176.0f, 389.4f, 176.0f, 432.0f)
                curveTo(176.0f, 511.5f, 240.5f, 576.0f, 320.0f, 576.0f)
                curveTo(399.5f, 576.0f, 464.0f, 511.5f, 464.0f, 432.0f)
                curveTo(464.0f, 389.4f, 445.5f, 351.0f, 416.0f, 324.7f)
                lineTo(416.0f, 160.0f)
                curveTo(416.0f, 107.0f, 373.0f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(384.0f, 432.0f)
                curveTo(384.0f, 467.3f, 355.3f, 496.0f, 320.0f, 496.0f)
                curveTo(284.7f, 496.0f, 256.0f, 467.3f, 256.0f, 432.0f)
                curveTo(256.0f, 405.1f, 272.5f, 382.1f, 296.0f, 372.7f)
                lineTo(296.0f, 344.0f)
                curveTo(296.0f, 330.7f, 306.7f, 320.0f, 320.0f, 320.0f)
                curveTo(333.3f, 320.0f, 344.0f, 330.7f, 344.0f, 344.0f)
                lineTo(344.0f, 372.7f)
                curveTo(367.5f, 382.2f, 384.0f, 405.2f, 384.0f, 432.0f)
                close()
            }
        }
        .build()
        return `_temperature-quarter`!!
    }

private var `_temperature-quarter`: ImageVector? = null
