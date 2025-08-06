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

public val Fa.`Unlock-alt`: ImageVector
    get() {
        if (`_unlock-alt` != null) {
            return `_unlock-alt`!!
        }
        `_unlock-alt` = Builder(name = "Unlock-alt", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 96.0f)
                curveTo(284.7f, 96.0f, 256.0f, 124.7f, 256.0f, 160.0f)
                lineTo(256.0f, 224.0f)
                lineTo(448.0f, 224.0f)
                curveTo(483.3f, 224.0f, 512.0f, 252.7f, 512.0f, 288.0f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 547.3f, 483.3f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(156.7f, 576.0f, 128.0f, 547.3f, 128.0f, 512.0f)
                lineTo(128.0f, 288.0f)
                curveTo(128.0f, 252.7f, 156.7f, 224.0f, 192.0f, 224.0f)
                lineTo(192.0f, 160.0f)
                curveTo(192.0f, 89.3f, 249.3f, 32.0f, 320.0f, 32.0f)
                curveTo(383.5f, 32.0f, 436.1f, 78.1f, 446.2f, 138.7f)
                curveTo(449.1f, 156.1f, 437.4f, 172.6f, 419.9f, 175.6f)
                curveTo(402.4f, 178.6f, 386.0f, 166.8f, 383.0f, 149.3f)
                curveTo(378.0f, 119.1f, 351.7f, 96.0f, 320.0f, 96.0f)
                close()
                moveTo(360.0f, 424.0f)
                curveTo(373.3f, 424.0f, 384.0f, 413.3f, 384.0f, 400.0f)
                curveTo(384.0f, 386.7f, 373.3f, 376.0f, 360.0f, 376.0f)
                lineTo(280.0f, 376.0f)
                curveTo(266.7f, 376.0f, 256.0f, 386.7f, 256.0f, 400.0f)
                curveTo(256.0f, 413.3f, 266.7f, 424.0f, 280.0f, 424.0f)
                lineTo(360.0f, 424.0f)
                close()
            }
        }
        .build()
        return `_unlock-alt`!!
    }

private var `_unlock-alt`: ImageVector? = null
