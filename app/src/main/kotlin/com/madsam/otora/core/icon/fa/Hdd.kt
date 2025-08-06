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

public val Fa.Hdd: ImageVector
    get() {
        if (_hdd != null) {
            return _hdd!!
        }
        _hdd = Builder(name = "Hdd", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 324.1f)
                curveTo(114.1f, 311.4f, 136.2f, 304.0f, 160.0f, 304.0f)
                lineTo(480.0f, 304.0f)
                curveTo(503.8f, 304.0f, 525.9f, 311.4f, 544.0f, 324.1f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                close()
                moveTo(544.0f, 416.0f)
                curveTo(544.0f, 380.7f, 515.3f, 352.0f, 480.0f, 352.0f)
                lineTo(160.0f, 352.0f)
                curveTo(124.7f, 352.0f, 96.0f, 380.7f, 96.0f, 416.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 416.0f)
                close()
                moveTo(320.0f, 448.0f)
                curveTo(320.0f, 430.3f, 334.3f, 416.0f, 352.0f, 416.0f)
                curveTo(369.7f, 416.0f, 384.0f, 430.3f, 384.0f, 448.0f)
                curveTo(384.0f, 465.7f, 369.7f, 480.0f, 352.0f, 480.0f)
                curveTo(334.3f, 480.0f, 320.0f, 465.7f, 320.0f, 448.0f)
                close()
                moveTo(448.0f, 416.0f)
                curveTo(465.7f, 416.0f, 480.0f, 430.3f, 480.0f, 448.0f)
                curveTo(480.0f, 465.7f, 465.7f, 480.0f, 448.0f, 480.0f)
                curveTo(430.3f, 480.0f, 416.0f, 465.7f, 416.0f, 448.0f)
                curveTo(416.0f, 430.3f, 430.3f, 416.0f, 448.0f, 416.0f)
                close()
            }
        }
        .build()
        return _hdd!!
    }

private var _hdd: ImageVector? = null
