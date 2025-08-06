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

public val Fa.`Paint-roller`: ImageVector
    get() {
        if (`_paint-roller` != null) {
            return `_paint-roller`!!
        }
        `_paint-roller` = Builder(name = "Paint-roller", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 128.0f)
                curveTo(64.0f, 92.7f, 92.7f, 64.0f, 128.0f, 64.0f)
                lineTo(416.0f, 64.0f)
                curveTo(451.3f, 64.0f, 480.0f, 92.7f, 480.0f, 128.0f)
                lineTo(496.0f, 128.0f)
                curveTo(540.2f, 128.0f, 576.0f, 163.8f, 576.0f, 208.0f)
                lineTo(576.0f, 304.0f)
                curveTo(576.0f, 348.2f, 540.2f, 384.0f, 496.0f, 384.0f)
                lineTo(336.0f, 384.0f)
                curveTo(327.2f, 384.0f, 320.0f, 391.2f, 320.0f, 400.0f)
                lineTo(320.0f, 418.7f)
                curveTo(338.6f, 425.3f, 352.0f, 443.1f, 352.0f, 464.0f)
                lineTo(352.0f, 560.0f)
                curveTo(352.0f, 586.5f, 330.5f, 608.0f, 304.0f, 608.0f)
                lineTo(272.0f, 608.0f)
                curveTo(245.5f, 608.0f, 224.0f, 586.5f, 224.0f, 560.0f)
                lineTo(224.0f, 464.0f)
                curveTo(224.0f, 443.1f, 237.4f, 425.3f, 256.0f, 418.7f)
                lineTo(256.0f, 400.0f)
                curveTo(256.0f, 355.8f, 291.8f, 320.0f, 336.0f, 320.0f)
                lineTo(496.0f, 320.0f)
                curveTo(504.8f, 320.0f, 512.0f, 312.8f, 512.0f, 304.0f)
                lineTo(512.0f, 208.0f)
                curveTo(512.0f, 199.2f, 504.8f, 192.0f, 496.0f, 192.0f)
                lineTo(480.0f, 192.0f)
                curveTo(480.0f, 227.3f, 451.3f, 256.0f, 416.0f, 256.0f)
                lineTo(128.0f, 256.0f)
                curveTo(92.7f, 256.0f, 64.0f, 227.3f, 64.0f, 192.0f)
                lineTo(64.0f, 128.0f)
                close()
            }
        }
        .build()
        return `_paint-roller`!!
    }

private var `_paint-roller`: ImageVector? = null
