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

public val Fa.`Chess-king`: ImageVector
    get() {
        if (`_chess-king` != null) {
            return `_chess-king`!!
        }
        `_chess-king` = Builder(name = "Chess-king", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 32.0f)
                curveTo(337.7f, 32.0f, 352.0f, 46.3f, 352.0f, 64.0f)
                lineTo(352.0f, 96.0f)
                lineTo(384.0f, 96.0f)
                curveTo(401.7f, 96.0f, 416.0f, 110.3f, 416.0f, 128.0f)
                curveTo(416.0f, 145.7f, 401.7f, 160.0f, 384.0f, 160.0f)
                lineTo(352.0f, 160.0f)
                lineTo(352.0f, 224.0f)
                lineTo(505.8f, 224.0f)
                curveTo(526.9f, 224.0f, 544.0f, 241.1f, 544.0f, 262.2f)
                curveTo(544.0f, 268.6f, 542.4f, 274.9f, 539.3f, 280.5f)
                lineTo(448.0f, 448.0f)
                lineTo(504.2f, 518.3f)
                curveTo(509.2f, 524.6f, 512.0f, 532.4f, 512.0f, 540.5f)
                curveTo(512.0f, 560.1f, 496.1f, 576.0f, 476.5f, 576.0f)
                lineTo(163.5f, 576.0f)
                curveTo(143.9f, 576.0f, 128.0f, 560.1f, 128.0f, 540.5f)
                curveTo(128.0f, 532.4f, 130.7f, 524.6f, 135.8f, 518.3f)
                lineTo(192.0f, 448.0f)
                lineTo(100.7f, 280.6f)
                curveTo(97.6f, 274.9f, 96.0f, 268.6f, 96.0f, 262.2f)
                curveTo(96.0f, 241.1f, 113.1f, 224.0f, 134.2f, 224.0f)
                lineTo(288.0f, 224.0f)
                lineTo(288.0f, 160.0f)
                lineTo(256.0f, 160.0f)
                curveTo(238.3f, 160.0f, 224.0f, 145.7f, 224.0f, 128.0f)
                curveTo(224.0f, 110.3f, 238.3f, 96.0f, 256.0f, 96.0f)
                lineTo(288.0f, 96.0f)
                lineTo(288.0f, 64.0f)
                curveTo(288.0f, 46.3f, 302.3f, 32.0f, 320.0f, 32.0f)
                close()
            }
        }
        .build()
        return `_chess-king`!!
    }

private var `_chess-king`: ImageVector? = null
