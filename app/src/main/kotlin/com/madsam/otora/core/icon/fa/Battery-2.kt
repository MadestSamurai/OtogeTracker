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

public val Fa.`Battery-2`: ImageVector
    get() {
        if (`_battery-2` != null) {
            return `_battery-2`!!
        }
        `_battery-2` = Builder(name = "Battery-2", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(528.0f, 192.0f)
                curveTo(536.8f, 192.0f, 544.0f, 199.2f, 544.0f, 208.0f)
                lineTo(544.0f, 432.0f)
                curveTo(544.0f, 440.8f, 536.8f, 448.0f, 528.0f, 448.0f)
                lineTo(112.0f, 448.0f)
                curveTo(103.2f, 448.0f, 96.0f, 440.8f, 96.0f, 432.0f)
                lineTo(96.0f, 208.0f)
                curveTo(96.0f, 199.2f, 103.2f, 192.0f, 112.0f, 192.0f)
                lineTo(528.0f, 192.0f)
                close()
                moveTo(112.0f, 128.0f)
                curveTo(67.8f, 128.0f, 32.0f, 163.8f, 32.0f, 208.0f)
                lineTo(32.0f, 432.0f)
                curveTo(32.0f, 476.2f, 67.8f, 512.0f, 112.0f, 512.0f)
                lineTo(528.0f, 512.0f)
                curveTo(572.2f, 512.0f, 608.0f, 476.2f, 608.0f, 432.0f)
                lineTo(608.0f, 384.0f)
                curveTo(625.7f, 384.0f, 640.0f, 369.7f, 640.0f, 352.0f)
                lineTo(640.0f, 288.0f)
                curveTo(640.0f, 270.3f, 625.7f, 256.0f, 608.0f, 256.0f)
                lineTo(608.0f, 208.0f)
                curveTo(608.0f, 163.8f, 572.2f, 128.0f, 528.0f, 128.0f)
                lineTo(112.0f, 128.0f)
                close()
                moveTo(168.0f, 240.0f)
                curveTo(154.7f, 240.0f, 144.0f, 250.7f, 144.0f, 264.0f)
                lineTo(144.0f, 376.0f)
                curveTo(144.0f, 389.3f, 154.7f, 400.0f, 168.0f, 400.0f)
                lineTo(232.0f, 400.0f)
                curveTo(245.3f, 400.0f, 256.0f, 389.3f, 256.0f, 376.0f)
                lineTo(256.0f, 264.0f)
                curveTo(256.0f, 250.7f, 245.3f, 240.0f, 232.0f, 240.0f)
                lineTo(168.0f, 240.0f)
                close()
            }
        }
        .build()
        return `_battery-2`!!
    }

private var `_battery-2`: ImageVector? = null
