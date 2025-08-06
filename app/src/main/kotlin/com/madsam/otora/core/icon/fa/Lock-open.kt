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

public val Fa.`Lock-open`: ImageVector
    get() {
        if (`_lock-open` != null) {
            return `_lock-open`!!
        }
        `_lock-open` = Builder(name = "Lock-open", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(416.0f, 160.0f)
                curveTo(416.0f, 124.7f, 444.7f, 96.0f, 480.0f, 96.0f)
                curveTo(515.3f, 96.0f, 544.0f, 124.7f, 544.0f, 160.0f)
                lineTo(544.0f, 192.0f)
                curveTo(544.0f, 209.7f, 558.3f, 224.0f, 576.0f, 224.0f)
                curveTo(593.7f, 224.0f, 608.0f, 209.7f, 608.0f, 192.0f)
                lineTo(608.0f, 160.0f)
                curveTo(608.0f, 89.3f, 550.7f, 32.0f, 480.0f, 32.0f)
                curveTo(409.3f, 32.0f, 352.0f, 89.3f, 352.0f, 160.0f)
                lineTo(352.0f, 224.0f)
                lineTo(192.0f, 224.0f)
                curveTo(156.7f, 224.0f, 128.0f, 252.7f, 128.0f, 288.0f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 547.3f, 156.7f, 576.0f, 192.0f, 576.0f)
                lineTo(448.0f, 576.0f)
                curveTo(483.3f, 576.0f, 512.0f, 547.3f, 512.0f, 512.0f)
                lineTo(512.0f, 288.0f)
                curveTo(512.0f, 252.7f, 483.3f, 224.0f, 448.0f, 224.0f)
                lineTo(416.0f, 224.0f)
                lineTo(416.0f, 160.0f)
                close()
            }
        }
        .build()
        return `_lock-open`!!
    }

private var `_lock-open`: ImageVector? = null
