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

public val Fa.`Laptop-medical`: ImageVector
    get() {
        if (`_laptop-medical` != null) {
            return `_laptop-medical`!!
        }
        `_laptop-medical` = Builder(name = "Laptop-medical", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 160.0f)
                curveTo(64.0f, 124.7f, 92.7f, 96.0f, 128.0f, 96.0f)
                lineTo(512.0f, 96.0f)
                curveTo(547.3f, 96.0f, 576.0f, 124.7f, 576.0f, 160.0f)
                lineTo(576.0f, 400.0f)
                lineTo(512.0f, 400.0f)
                lineTo(512.0f, 160.0f)
                lineTo(128.0f, 160.0f)
                lineTo(128.0f, 400.0f)
                lineTo(64.0f, 400.0f)
                lineTo(64.0f, 160.0f)
                close()
                moveTo(0.0f, 467.2f)
                curveTo(0.0f, 456.6f, 8.6f, 448.0f, 19.2f, 448.0f)
                lineTo(620.8f, 448.0f)
                curveTo(631.4f, 448.0f, 640.0f, 456.6f, 640.0f, 467.2f)
                curveTo(640.0f, 509.6f, 605.6f, 544.0f, 563.2f, 544.0f)
                lineTo(76.8f, 544.0f)
                curveTo(34.4f, 544.0f, 0.0f, 509.6f, 0.0f, 467.2f)
                close()
                moveTo(288.0f, 224.0f)
                curveTo(288.0f, 215.2f, 295.2f, 208.0f, 304.0f, 208.0f)
                lineTo(336.0f, 208.0f)
                curveTo(344.8f, 208.0f, 352.0f, 215.2f, 352.0f, 224.0f)
                lineTo(352.0f, 264.0f)
                lineTo(392.0f, 264.0f)
                curveTo(400.8f, 264.0f, 408.0f, 271.2f, 408.0f, 280.0f)
                lineTo(408.0f, 312.0f)
                curveTo(408.0f, 320.8f, 400.8f, 328.0f, 392.0f, 328.0f)
                lineTo(352.0f, 328.0f)
                lineTo(352.0f, 368.0f)
                curveTo(352.0f, 376.8f, 344.8f, 384.0f, 336.0f, 384.0f)
                lineTo(304.0f, 384.0f)
                curveTo(295.2f, 384.0f, 288.0f, 376.8f, 288.0f, 368.0f)
                lineTo(288.0f, 328.0f)
                lineTo(248.0f, 328.0f)
                curveTo(239.2f, 328.0f, 232.0f, 320.8f, 232.0f, 312.0f)
                lineTo(232.0f, 280.0f)
                curveTo(232.0f, 271.2f, 239.2f, 264.0f, 248.0f, 264.0f)
                lineTo(288.0f, 264.0f)
                lineTo(288.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_laptop-medical`!!
    }

private var `_laptop-medical`: ImageVector? = null
