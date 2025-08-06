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

public val Fa.`Rectangle-list`: ImageVector
    get() {
        if (`_rectangle-list` != null) {
            return `_rectangle-list`!!
        }
        `_rectangle-list` = Builder(name = "Rectangle-list", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(92.7f, 128.0f, 64.0f, 156.7f, 64.0f, 192.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                lineTo(512.0f, 512.0f)
                curveTo(547.3f, 512.0f, 576.0f, 483.3f, 576.0f, 448.0f)
                lineTo(576.0f, 192.0f)
                curveTo(576.0f, 156.7f, 547.3f, 128.0f, 512.0f, 128.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(224.0f, 384.0f)
                curveTo(224.0f, 401.7f, 209.7f, 416.0f, 192.0f, 416.0f)
                curveTo(174.3f, 416.0f, 160.0f, 401.7f, 160.0f, 384.0f)
                curveTo(160.0f, 366.3f, 174.3f, 352.0f, 192.0f, 352.0f)
                curveTo(209.7f, 352.0f, 224.0f, 366.3f, 224.0f, 384.0f)
                close()
                moveTo(192.0f, 288.0f)
                curveTo(174.3f, 288.0f, 160.0f, 273.7f, 160.0f, 256.0f)
                curveTo(160.0f, 238.3f, 174.3f, 224.0f, 192.0f, 224.0f)
                curveTo(209.7f, 224.0f, 224.0f, 238.3f, 224.0f, 256.0f)
                curveTo(224.0f, 273.7f, 209.7f, 288.0f, 192.0f, 288.0f)
                close()
                moveTo(312.0f, 232.0f)
                lineTo(456.0f, 232.0f)
                curveTo(469.3f, 232.0f, 480.0f, 242.7f, 480.0f, 256.0f)
                curveTo(480.0f, 269.3f, 469.3f, 280.0f, 456.0f, 280.0f)
                lineTo(312.0f, 280.0f)
                curveTo(298.7f, 280.0f, 288.0f, 269.3f, 288.0f, 256.0f)
                curveTo(288.0f, 242.7f, 298.7f, 232.0f, 312.0f, 232.0f)
                close()
                moveTo(312.0f, 360.0f)
                lineTo(456.0f, 360.0f)
                curveTo(469.3f, 360.0f, 480.0f, 370.7f, 480.0f, 384.0f)
                curveTo(480.0f, 397.3f, 469.3f, 408.0f, 456.0f, 408.0f)
                lineTo(312.0f, 408.0f)
                curveTo(298.7f, 408.0f, 288.0f, 397.3f, 288.0f, 384.0f)
                curveTo(288.0f, 370.7f, 298.7f, 360.0f, 312.0f, 360.0f)
                close()
            }
        }
        .build()
        return `_rectangle-list`!!
    }

private var `_rectangle-list`: ImageVector? = null
