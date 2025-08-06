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

public val Fa.`Landmark-flag`: ImageVector
    get() {
        if (`_landmark-flag` != null) {
            return `_landmark-flag`!!
        }
        `_landmark-flag` = Builder(name = "Landmark-flag", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(416.0f, 32.0f)
                lineTo(304.0f, 32.0f)
                curveTo(295.2f, 32.0f, 288.0f, 39.2f, 288.0f, 48.0f)
                lineTo(288.0f, 192.0f)
                lineTo(112.0f, 192.0f)
                curveTo(94.3f, 192.0f, 80.0f, 206.3f, 80.0f, 224.0f)
                curveTo(80.0f, 241.7f, 94.3f, 256.0f, 112.0f, 256.0f)
                lineTo(128.0f, 256.0f)
                lineTo(128.0f, 480.0f)
                lineTo(76.8f, 518.4f)
                curveTo(68.7f, 524.4f, 64.0f, 533.9f, 64.0f, 544.0f)
                curveTo(64.0f, 561.7f, 78.3f, 576.0f, 96.0f, 576.0f)
                lineTo(544.0f, 576.0f)
                curveTo(561.7f, 576.0f, 576.0f, 561.7f, 576.0f, 544.0f)
                curveTo(576.0f, 533.9f, 571.3f, 524.4f, 563.2f, 518.4f)
                lineTo(512.0f, 480.0f)
                lineTo(512.0f, 256.0f)
                lineTo(528.0f, 256.0f)
                curveTo(545.7f, 256.0f, 560.0f, 241.7f, 560.0f, 224.0f)
                curveTo(560.0f, 206.3f, 545.7f, 192.0f, 528.0f, 192.0f)
                lineTo(336.0f, 192.0f)
                lineTo(336.0f, 128.0f)
                lineTo(416.0f, 128.0f)
                curveTo(424.8f, 128.0f, 432.0f, 120.8f, 432.0f, 112.0f)
                lineTo(432.0f, 48.0f)
                curveTo(432.0f, 39.2f, 424.8f, 32.0f, 416.0f, 32.0f)
                close()
                moveTo(464.0f, 256.0f)
                lineTo(464.0f, 480.0f)
                lineTo(400.0f, 480.0f)
                lineTo(400.0f, 256.0f)
                lineTo(464.0f, 256.0f)
                close()
                moveTo(352.0f, 256.0f)
                lineTo(352.0f, 480.0f)
                lineTo(288.0f, 480.0f)
                lineTo(288.0f, 256.0f)
                lineTo(352.0f, 256.0f)
                close()
                moveTo(240.0f, 256.0f)
                lineTo(240.0f, 480.0f)
                lineTo(176.0f, 480.0f)
                lineTo(176.0f, 256.0f)
                lineTo(240.0f, 256.0f)
                close()
            }
        }
        .build()
        return `_landmark-flag`!!
    }

private var `_landmark-flag`: ImageVector? = null
