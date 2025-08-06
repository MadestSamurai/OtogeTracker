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

public val Fa.`Chart-simple`: ImageVector
    get() {
        if (`_chart-simple` != null) {
            return `_chart-simple`!!
        }
        `_chart-simple` = Builder(name = "Chart-simple", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 144.0f)
                curveTo(256.0f, 117.5f, 277.5f, 96.0f, 304.0f, 96.0f)
                lineTo(336.0f, 96.0f)
                curveTo(362.5f, 96.0f, 384.0f, 117.5f, 384.0f, 144.0f)
                lineTo(384.0f, 496.0f)
                curveTo(384.0f, 522.5f, 362.5f, 544.0f, 336.0f, 544.0f)
                lineTo(304.0f, 544.0f)
                curveTo(277.5f, 544.0f, 256.0f, 522.5f, 256.0f, 496.0f)
                lineTo(256.0f, 144.0f)
                close()
                moveTo(64.0f, 336.0f)
                curveTo(64.0f, 309.5f, 85.5f, 288.0f, 112.0f, 288.0f)
                lineTo(144.0f, 288.0f)
                curveTo(170.5f, 288.0f, 192.0f, 309.5f, 192.0f, 336.0f)
                lineTo(192.0f, 496.0f)
                curveTo(192.0f, 522.5f, 170.5f, 544.0f, 144.0f, 544.0f)
                lineTo(112.0f, 544.0f)
                curveTo(85.5f, 544.0f, 64.0f, 522.5f, 64.0f, 496.0f)
                lineTo(64.0f, 336.0f)
                close()
                moveTo(496.0f, 160.0f)
                lineTo(528.0f, 160.0f)
                curveTo(554.5f, 160.0f, 576.0f, 181.5f, 576.0f, 208.0f)
                lineTo(576.0f, 496.0f)
                curveTo(576.0f, 522.5f, 554.5f, 544.0f, 528.0f, 544.0f)
                lineTo(496.0f, 544.0f)
                curveTo(469.5f, 544.0f, 448.0f, 522.5f, 448.0f, 496.0f)
                lineTo(448.0f, 208.0f)
                curveTo(448.0f, 181.5f, 469.5f, 160.0f, 496.0f, 160.0f)
                close()
            }
        }
        .build()
        return `_chart-simple`!!
    }

private var `_chart-simple`: ImageVector? = null
