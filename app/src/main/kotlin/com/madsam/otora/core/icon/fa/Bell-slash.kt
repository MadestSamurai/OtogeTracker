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

public val Fa.`Bell-slash`: ImageVector
    get() {
        if (`_bell-slash` != null) {
            return `_bell-slash`!!
        }
        `_bell-slash` = Builder(name = "Bell-slash", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(513.4f, 479.7f)
                curveTo(530.6f, 477.3f, 543.9f, 462.4f, 543.9f, 444.5f)
                curveTo(543.9f, 436.4f, 541.2f, 428.6f, 536.1f, 422.3f)
                lineTo(526.3f, 410.1f)
                curveTo(496.4f, 372.5f, 480.0f, 325.8f, 480.0f, 277.7f)
                lineTo(480.0f, 256.0f)
                curveTo(480.0f, 178.6f, 425.0f, 114.0f, 352.0f, 99.2f)
                lineTo(352.0f, 96.0f)
                curveTo(352.0f, 78.3f, 337.7f, 64.0f, 320.0f, 64.0f)
                curveTo(302.3f, 64.0f, 288.0f, 78.3f, 288.0f, 96.0f)
                lineTo(288.0f, 99.2f)
                curveTo(249.4f, 107.0f, 215.8f, 128.8f, 192.8f, 158.9f)
                lineTo(73.0f, 39.1f)
                close()
                moveTo(160.0f, 277.6f)
                curveTo(160.0f, 325.7f, 143.6f, 372.4f, 113.6f, 410.0f)
                lineTo(103.8f, 422.2f)
                curveTo(98.8f, 428.5f, 96.0f, 436.3f, 96.0f, 444.4f)
                curveTo(96.0f, 464.0f, 111.9f, 479.9f, 131.5f, 479.9f)
                lineTo(366.8f, 479.9f)
                lineTo(159.9f, 273.0f)
                lineTo(159.9f, 277.5f)
                close()
                moveTo(320.0f, 576.0f)
                curveTo(349.8f, 576.0f, 374.9f, 555.6f, 382.0f, 528.0f)
                lineTo(258.0f, 528.0f)
                curveTo(265.1f, 555.6f, 290.2f, 576.0f, 320.0f, 576.0f)
                close()
            }
        }
        .build()
        return `_bell-slash`!!
    }

private var `_bell-slash`: ImageVector? = null
