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

public val Fa.Stairs: ImageVector
    get() {
        if (_stairs != null) {
            return _stairs!!
        }
        _stairs = Builder(name = "Stairs", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(416.0f, 128.0f)
                curveTo(416.0f, 110.3f, 430.3f, 96.0f, 448.0f, 96.0f)
                lineTo(576.0f, 96.0f)
                curveTo(593.7f, 96.0f, 608.0f, 110.3f, 608.0f, 128.0f)
                curveTo(608.0f, 145.7f, 593.7f, 160.0f, 576.0f, 160.0f)
                lineTo(480.0f, 160.0f)
                lineTo(480.0f, 256.0f)
                curveTo(480.0f, 273.7f, 465.7f, 288.0f, 448.0f, 288.0f)
                lineTo(352.0f, 288.0f)
                lineTo(352.0f, 384.0f)
                curveTo(352.0f, 401.7f, 337.7f, 416.0f, 320.0f, 416.0f)
                lineTo(224.0f, 416.0f)
                lineTo(224.0f, 512.0f)
                curveTo(224.0f, 529.7f, 209.7f, 544.0f, 192.0f, 544.0f)
                lineTo(64.0f, 544.0f)
                curveTo(46.3f, 544.0f, 32.0f, 529.7f, 32.0f, 512.0f)
                curveTo(32.0f, 494.3f, 46.3f, 480.0f, 64.0f, 480.0f)
                lineTo(160.0f, 480.0f)
                lineTo(160.0f, 384.0f)
                curveTo(160.0f, 366.3f, 174.3f, 352.0f, 192.0f, 352.0f)
                lineTo(288.0f, 352.0f)
                lineTo(288.0f, 256.0f)
                curveTo(288.0f, 238.3f, 302.3f, 224.0f, 320.0f, 224.0f)
                lineTo(416.0f, 224.0f)
                lineTo(416.0f, 128.0f)
                close()
            }
        }
        .build()
        return _stairs!!
    }

private var _stairs: ImageVector? = null
