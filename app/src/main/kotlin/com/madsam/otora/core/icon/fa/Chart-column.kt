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

public val Fa.`Chart-column`: ImageVector
    get() {
        if (`_chart-column` != null) {
            return `_chart-column`!!
        }
        `_chart-column` = Builder(name = "Chart-column", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 96.0f)
                curveTo(113.7f, 96.0f, 128.0f, 110.3f, 128.0f, 128.0f)
                lineTo(128.0f, 464.0f)
                curveTo(128.0f, 472.8f, 135.2f, 480.0f, 144.0f, 480.0f)
                lineTo(544.0f, 480.0f)
                curveTo(561.7f, 480.0f, 576.0f, 494.3f, 576.0f, 512.0f)
                curveTo(576.0f, 529.7f, 561.7f, 544.0f, 544.0f, 544.0f)
                lineTo(144.0f, 544.0f)
                curveTo(99.8f, 544.0f, 64.0f, 508.2f, 64.0f, 464.0f)
                lineTo(64.0f, 128.0f)
                curveTo(64.0f, 110.3f, 78.3f, 96.0f, 96.0f, 96.0f)
                close()
                moveTo(208.0f, 288.0f)
                curveTo(225.7f, 288.0f, 240.0f, 302.3f, 240.0f, 320.0f)
                lineTo(240.0f, 384.0f)
                curveTo(240.0f, 401.7f, 225.7f, 416.0f, 208.0f, 416.0f)
                curveTo(190.3f, 416.0f, 176.0f, 401.7f, 176.0f, 384.0f)
                lineTo(176.0f, 320.0f)
                curveTo(176.0f, 302.3f, 190.3f, 288.0f, 208.0f, 288.0f)
                close()
                moveTo(352.0f, 224.0f)
                lineTo(352.0f, 384.0f)
                curveTo(352.0f, 401.7f, 337.7f, 416.0f, 320.0f, 416.0f)
                curveTo(302.3f, 416.0f, 288.0f, 401.7f, 288.0f, 384.0f)
                lineTo(288.0f, 224.0f)
                curveTo(288.0f, 206.3f, 302.3f, 192.0f, 320.0f, 192.0f)
                curveTo(337.7f, 192.0f, 352.0f, 206.3f, 352.0f, 224.0f)
                close()
                moveTo(432.0f, 256.0f)
                curveTo(449.7f, 256.0f, 464.0f, 270.3f, 464.0f, 288.0f)
                lineTo(464.0f, 384.0f)
                curveTo(464.0f, 401.7f, 449.7f, 416.0f, 432.0f, 416.0f)
                curveTo(414.3f, 416.0f, 400.0f, 401.7f, 400.0f, 384.0f)
                lineTo(400.0f, 288.0f)
                curveTo(400.0f, 270.3f, 414.3f, 256.0f, 432.0f, 256.0f)
                close()
                moveTo(576.0f, 160.0f)
                lineTo(576.0f, 384.0f)
                curveTo(576.0f, 401.7f, 561.7f, 416.0f, 544.0f, 416.0f)
                curveTo(526.3f, 416.0f, 512.0f, 401.7f, 512.0f, 384.0f)
                lineTo(512.0f, 160.0f)
                curveTo(512.0f, 142.3f, 526.3f, 128.0f, 544.0f, 128.0f)
                curveTo(561.7f, 128.0f, 576.0f, 142.3f, 576.0f, 160.0f)
                close()
            }
        }
        .build()
        return `_chart-column`!!
    }

private var `_chart-column`: ImageVector? = null
