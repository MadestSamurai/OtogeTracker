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

public val Fa.Parking: ImageVector
    get() {
        if (_parking != null) {
            return _parking!!
        }
        _parking = Builder(name = "Parking", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                close()
                moveTo(288.0f, 320.0f)
                lineTo(336.0f, 320.0f)
                curveTo(353.7f, 320.0f, 368.0f, 305.7f, 368.0f, 288.0f)
                curveTo(368.0f, 270.3f, 353.7f, 256.0f, 336.0f, 256.0f)
                lineTo(288.0f, 256.0f)
                lineTo(288.0f, 320.0f)
                close()
                moveTo(336.0f, 384.0f)
                lineTo(288.0f, 384.0f)
                lineTo(288.0f, 416.0f)
                curveTo(288.0f, 433.7f, 273.7f, 448.0f, 256.0f, 448.0f)
                curveTo(238.3f, 448.0f, 224.0f, 433.7f, 224.0f, 416.0f)
                lineTo(224.0f, 232.0f)
                curveTo(224.0f, 209.9f, 241.9f, 192.0f, 264.0f, 192.0f)
                lineTo(336.0f, 192.0f)
                curveTo(389.0f, 192.0f, 432.0f, 235.0f, 432.0f, 288.0f)
                curveTo(432.0f, 341.0f, 389.0f, 384.0f, 336.0f, 384.0f)
                close()
            }
        }
        .build()
        return _parking!!
    }

private var _parking: ImageVector? = null
