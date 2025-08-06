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

public val Fa.`Diagram-project`: ImageVector
    get() {
        if (`_diagram-project` != null) {
            return `_diagram-project`!!
        }
        `_diagram-project` = Builder(name = "Diagram-project", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 144.0f)
                curveTo(64.0f, 117.5f, 85.5f, 96.0f, 112.0f, 96.0f)
                lineTo(208.0f, 96.0f)
                curveTo(234.5f, 96.0f, 256.0f, 117.5f, 256.0f, 144.0f)
                lineTo(256.0f, 160.0f)
                lineTo(384.0f, 160.0f)
                lineTo(384.0f, 144.0f)
                curveTo(384.0f, 117.5f, 405.5f, 96.0f, 432.0f, 96.0f)
                lineTo(528.0f, 96.0f)
                curveTo(554.5f, 96.0f, 576.0f, 117.5f, 576.0f, 144.0f)
                lineTo(576.0f, 240.0f)
                curveTo(576.0f, 266.5f, 554.5f, 288.0f, 528.0f, 288.0f)
                lineTo(432.0f, 288.0f)
                curveTo(405.5f, 288.0f, 384.0f, 266.5f, 384.0f, 240.0f)
                lineTo(384.0f, 224.0f)
                lineTo(256.0f, 224.0f)
                lineTo(256.0f, 240.0f)
                curveTo(256.0f, 247.3f, 254.3f, 254.3f, 251.4f, 260.5f)
                lineTo(320.0f, 352.0f)
                lineTo(400.0f, 352.0f)
                curveTo(426.5f, 352.0f, 448.0f, 373.5f, 448.0f, 400.0f)
                lineTo(448.0f, 496.0f)
                curveTo(448.0f, 522.5f, 426.5f, 544.0f, 400.0f, 544.0f)
                lineTo(304.0f, 544.0f)
                curveTo(277.5f, 544.0f, 256.0f, 522.5f, 256.0f, 496.0f)
                lineTo(256.0f, 400.0f)
                curveTo(256.0f, 392.7f, 257.7f, 385.7f, 260.6f, 379.5f)
                lineTo(192.0f, 288.0f)
                lineTo(112.0f, 288.0f)
                curveTo(85.5f, 288.0f, 64.0f, 266.5f, 64.0f, 240.0f)
                lineTo(64.0f, 144.0f)
                close()
            }
        }
        .build()
        return `_diagram-project`!!
    }

private var `_diagram-project`: ImageVector? = null
