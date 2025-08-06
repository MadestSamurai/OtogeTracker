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

public val Fa.`Battery-car`: ImageVector
    get() {
        if (`_battery-car` != null) {
            return `_battery-car`!!
        }
        `_battery-car` = Builder(name = "Battery-car", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(144.0f, 128.0f)
                curveTo(144.0f, 110.3f, 158.3f, 96.0f, 176.0f, 96.0f)
                lineTo(240.0f, 96.0f)
                curveTo(257.7f, 96.0f, 272.0f, 110.3f, 272.0f, 128.0f)
                lineTo(368.0f, 128.0f)
                curveTo(368.0f, 110.3f, 382.3f, 96.0f, 400.0f, 96.0f)
                lineTo(464.0f, 96.0f)
                curveTo(481.7f, 96.0f, 496.0f, 110.3f, 496.0f, 128.0f)
                lineTo(512.0f, 128.0f)
                curveTo(547.3f, 128.0f, 576.0f, 156.7f, 576.0f, 192.0f)
                lineTo(576.0f, 448.0f)
                curveTo(576.0f, 483.3f, 547.3f, 512.0f, 512.0f, 512.0f)
                lineTo(128.0f, 512.0f)
                curveTo(92.7f, 512.0f, 64.0f, 483.3f, 64.0f, 448.0f)
                lineTo(64.0f, 192.0f)
                curveTo(64.0f, 156.7f, 92.7f, 128.0f, 128.0f, 128.0f)
                lineTo(144.0f, 128.0f)
                close()
                moveTo(456.0f, 248.0f)
                curveTo(456.0f, 234.7f, 445.3f, 224.0f, 432.0f, 224.0f)
                curveTo(418.7f, 224.0f, 408.0f, 234.7f, 408.0f, 248.0f)
                lineTo(408.0f, 280.0f)
                lineTo(376.0f, 280.0f)
                curveTo(362.7f, 280.0f, 352.0f, 290.7f, 352.0f, 304.0f)
                curveTo(352.0f, 317.3f, 362.7f, 328.0f, 376.0f, 328.0f)
                lineTo(408.0f, 328.0f)
                lineTo(408.0f, 360.0f)
                curveTo(408.0f, 373.3f, 418.7f, 384.0f, 432.0f, 384.0f)
                curveTo(445.3f, 384.0f, 456.0f, 373.3f, 456.0f, 360.0f)
                lineTo(456.0f, 328.0f)
                lineTo(488.0f, 328.0f)
                curveTo(501.3f, 328.0f, 512.0f, 317.3f, 512.0f, 304.0f)
                curveTo(512.0f, 290.7f, 501.3f, 280.0f, 488.0f, 280.0f)
                lineTo(456.0f, 280.0f)
                lineTo(456.0f, 248.0f)
                close()
                moveTo(128.0f, 304.0f)
                curveTo(128.0f, 317.3f, 138.7f, 328.0f, 152.0f, 328.0f)
                lineTo(264.0f, 328.0f)
                curveTo(277.3f, 328.0f, 288.0f, 317.3f, 288.0f, 304.0f)
                curveTo(288.0f, 290.7f, 277.3f, 280.0f, 264.0f, 280.0f)
                lineTo(152.0f, 280.0f)
                curveTo(138.7f, 280.0f, 128.0f, 290.7f, 128.0f, 304.0f)
                close()
            }
        }
        .build()
        return `_battery-car`!!
    }

private var `_battery-car`: ImageVector? = null
