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

public val Fa.`Apple-whole`: ImageVector
    get() {
        if (`_apple-whole` != null) {
            return `_apple-whole`!!
        }
        `_apple-whole` = Builder(name = "Apple-whole", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 176.0f)
                curveTo(311.2f, 176.0f, 304.0f, 168.8f, 304.0f, 160.0f)
                lineTo(304.0f, 144.0f)
                curveTo(304.0f, 99.8f, 339.8f, 64.0f, 384.0f, 64.0f)
                lineTo(400.0f, 64.0f)
                curveTo(408.8f, 64.0f, 416.0f, 71.2f, 416.0f, 80.0f)
                lineTo(416.0f, 96.0f)
                curveTo(416.0f, 140.2f, 380.2f, 176.0f, 336.0f, 176.0f)
                lineTo(320.0f, 176.0f)
                close()
                moveTo(96.0f, 352.0f)
                curveTo(96.0f, 275.7f, 131.7f, 192.0f, 208.0f, 192.0f)
                curveTo(235.3f, 192.0f, 267.7f, 202.3f, 290.7f, 211.3f)
                curveTo(309.5f, 218.6f, 330.6f, 218.6f, 349.4f, 211.3f)
                curveTo(372.3f, 202.4f, 404.8f, 192.0f, 432.1f, 192.0f)
                curveTo(508.4f, 192.0f, 544.1f, 275.7f, 544.1f, 352.0f)
                curveTo(544.1f, 480.0f, 464.1f, 576.0f, 384.1f, 576.0f)
                curveTo(367.6f, 576.0f, 346.0f, 569.4f, 332.6f, 564.7f)
                curveTo(324.5f, 561.9f, 315.7f, 561.9f, 307.6f, 564.7f)
                curveTo(294.2f, 569.4f, 272.6f, 576.0f, 256.1f, 576.0f)
                curveTo(176.1f, 576.0f, 96.1f, 480.0f, 96.1f, 352.0f)
                close()
            }
        }
        .build()
        return `_apple-whole`!!
    }

private var `_apple-whole`: ImageVector? = null
