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

public val Fa.`Indian-rupee`: ImageVector
    get() {
        if (`_indian-rupee` != null) {
            return `_indian-rupee`!!
        }
        `_indian-rupee` = Builder(name = "Indian-rupee", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 128.0f)
                curveTo(160.0f, 110.3f, 174.3f, 96.0f, 192.0f, 96.0f)
                lineTo(456.0f, 96.0f)
                curveTo(469.3f, 96.0f, 480.0f, 106.7f, 480.0f, 120.0f)
                curveTo(480.0f, 133.3f, 469.3f, 144.0f, 456.0f, 144.0f)
                lineTo(379.3f, 144.0f)
                curveTo(397.0f, 163.8f, 409.4f, 188.6f, 414.0f, 216.0f)
                lineTo(456.0f, 216.0f)
                curveTo(469.3f, 216.0f, 480.0f, 226.7f, 480.0f, 240.0f)
                curveTo(480.0f, 253.3f, 469.3f, 264.0f, 456.0f, 264.0f)
                lineTo(414.0f, 264.0f)
                curveTo(403.6f, 326.2f, 353.2f, 374.9f, 290.2f, 382.9f)
                lineTo(434.6f, 486.0f)
                curveTo(449.0f, 496.3f, 452.3f, 516.3f, 442.0f, 530.6f)
                curveTo(431.7f, 544.9f, 411.7f, 548.3f, 397.4f, 538.0f)
                lineTo(173.4f, 378.0f)
                curveTo(162.1f, 370.0f, 157.3f, 355.5f, 161.5f, 342.2f)
                curveTo(165.7f, 328.9f, 178.1f, 320.0f, 192.0f, 320.0f)
                lineTo(272.0f, 320.0f)
                curveTo(307.8f, 320.0f, 338.1f, 296.5f, 348.3f, 264.0f)
                lineTo(184.0f, 264.0f)
                curveTo(170.7f, 264.0f, 160.0f, 253.3f, 160.0f, 240.0f)
                curveTo(160.0f, 226.7f, 170.7f, 216.0f, 184.0f, 216.0f)
                lineTo(348.3f, 216.0f)
                curveTo(338.1f, 183.5f, 307.8f, 160.0f, 272.0f, 160.0f)
                lineTo(192.0f, 160.0f)
                curveTo(174.3f, 160.0f, 160.0f, 145.7f, 160.0f, 128.0f)
                close()
            }
        }
        .build()
        return `_indian-rupee`!!
    }

private var `_indian-rupee`: ImageVector? = null
