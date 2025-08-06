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

public val Fa.`Prescription-bottle`: ImageVector
    get() {
        if (`_prescription-bottle` != null) {
            return `_prescription-bottle`!!
        }
        `_prescription-bottle` = Builder(name = "Prescription-bottle", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
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
                lineTo(232.0f, 512.0f)
                curveTo(245.3f, 512.0f, 256.0f, 501.3f, 256.0f, 488.0f)
                curveTo(256.0f, 474.7f, 245.3f, 464.0f, 232.0f, 464.0f)
                lineTo(160.0f, 464.0f)
                lineTo(160.0f, 416.0f)
                lineTo(232.0f, 416.0f)
                curveTo(245.3f, 416.0f, 256.0f, 405.3f, 256.0f, 392.0f)
                curveTo(256.0f, 378.7f, 245.3f, 368.0f, 232.0f, 368.0f)
                lineTo(160.0f, 368.0f)
                lineTo(160.0f, 320.0f)
                lineTo(232.0f, 320.0f)
                curveTo(245.3f, 320.0f, 256.0f, 309.3f, 256.0f, 296.0f)
                curveTo(256.0f, 282.7f, 245.3f, 272.0f, 232.0f, 272.0f)
                lineTo(160.0f, 272.0f)
                lineTo(160.0f, 208.0f)
                close()
            }
        }
        .build()
        return `_prescription-bottle`!!
    }

private var `_prescription-bottle`: ImageVector? = null
