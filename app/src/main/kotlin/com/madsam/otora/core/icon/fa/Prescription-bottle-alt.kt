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

public val Fa.`Prescription-bottle-alt`: ImageVector
    get() {
        if (`_prescription-bottle-alt` != null) {
            return `_prescription-bottle-alt`!!
        }
        `_prescription-bottle-alt` = Builder(name = "Prescription-bottle-alt", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 96.0f)
                curveTo(128.0f, 78.3f, 142.3f, 64.0f, 160.0f, 64.0f)
                lineTo(480.0f, 64.0f)
                curveTo(497.7f, 64.0f, 512.0f, 78.3f, 512.0f, 96.0f)
                lineTo(512.0f, 128.0f)
                curveTo(512.0f, 145.7f, 497.7f, 160.0f, 480.0f, 160.0f)
                lineTo(160.0f, 160.0f)
                curveTo(142.3f, 160.0f, 128.0f, 145.7f, 128.0f, 128.0f)
                lineTo(128.0f, 96.0f)
                close()
                moveTo(160.0f, 208.0f)
                lineTo(480.0f, 208.0f)
                lineTo(480.0f, 512.0f)
                curveTo(480.0f, 547.3f, 451.3f, 576.0f, 416.0f, 576.0f)
                lineTo(224.0f, 576.0f)
                curveTo(188.7f, 576.0f, 160.0f, 547.3f, 160.0f, 512.0f)
                lineTo(160.0f, 208.0f)
                close()
                moveTo(288.0f, 312.0f)
                lineTo(288.0f, 352.0f)
                lineTo(248.0f, 352.0f)
                curveTo(239.2f, 352.0f, 232.0f, 359.2f, 232.0f, 368.0f)
                lineTo(232.0f, 400.0f)
                curveTo(232.0f, 408.8f, 239.2f, 416.0f, 248.0f, 416.0f)
                lineTo(288.0f, 416.0f)
                lineTo(288.0f, 456.0f)
                curveTo(288.0f, 464.8f, 295.2f, 472.0f, 304.0f, 472.0f)
                lineTo(336.0f, 472.0f)
                curveTo(344.8f, 472.0f, 352.0f, 464.8f, 352.0f, 456.0f)
                lineTo(352.0f, 416.0f)
                lineTo(392.0f, 416.0f)
                curveTo(400.8f, 416.0f, 408.0f, 408.8f, 408.0f, 400.0f)
                lineTo(408.0f, 368.0f)
                curveTo(408.0f, 359.2f, 400.8f, 352.0f, 392.0f, 352.0f)
                lineTo(352.0f, 352.0f)
                lineTo(352.0f, 312.0f)
                curveTo(352.0f, 303.2f, 344.8f, 296.0f, 336.0f, 296.0f)
                lineTo(304.0f, 296.0f)
                curveTo(295.2f, 296.0f, 288.0f, 303.2f, 288.0f, 312.0f)
                close()
            }
        }
        .build()
        return `_prescription-bottle-alt`!!
    }

private var `_prescription-bottle-alt`: ImageVector? = null
