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

public val Fa.Dumbbell: ImageVector
    get() {
        if (_dumbbell != null) {
            return _dumbbell!!
        }
        _dumbbell = Builder(name = "Dumbbell", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 176.0f)
                curveTo(96.0f, 149.5f, 117.5f, 128.0f, 144.0f, 128.0f)
                curveTo(170.5f, 128.0f, 192.0f, 149.5f, 192.0f, 176.0f)
                lineTo(192.0f, 288.0f)
                lineTo(448.0f, 288.0f)
                lineTo(448.0f, 176.0f)
                curveTo(448.0f, 149.5f, 469.5f, 128.0f, 496.0f, 128.0f)
                curveTo(522.5f, 128.0f, 544.0f, 149.5f, 544.0f, 176.0f)
                lineTo(544.0f, 192.0f)
                lineTo(560.0f, 192.0f)
                curveTo(586.5f, 192.0f, 608.0f, 213.5f, 608.0f, 240.0f)
                lineTo(608.0f, 288.0f)
                curveTo(625.7f, 288.0f, 640.0f, 302.3f, 640.0f, 320.0f)
                curveTo(640.0f, 337.7f, 625.7f, 352.0f, 608.0f, 352.0f)
                lineTo(608.0f, 400.0f)
                curveTo(608.0f, 426.5f, 586.5f, 448.0f, 560.0f, 448.0f)
                lineTo(544.0f, 448.0f)
                lineTo(544.0f, 464.0f)
                curveTo(544.0f, 490.5f, 522.5f, 512.0f, 496.0f, 512.0f)
                curveTo(469.5f, 512.0f, 448.0f, 490.5f, 448.0f, 464.0f)
                lineTo(448.0f, 352.0f)
                lineTo(192.0f, 352.0f)
                lineTo(192.0f, 464.0f)
                curveTo(192.0f, 490.5f, 170.5f, 512.0f, 144.0f, 512.0f)
                curveTo(117.5f, 512.0f, 96.0f, 490.5f, 96.0f, 464.0f)
                lineTo(96.0f, 448.0f)
                lineTo(80.0f, 448.0f)
                curveTo(53.5f, 448.0f, 32.0f, 426.5f, 32.0f, 400.0f)
                lineTo(32.0f, 352.0f)
                curveTo(14.3f, 352.0f, 0.0f, 337.7f, 0.0f, 320.0f)
                curveTo(0.0f, 302.3f, 14.3f, 288.0f, 32.0f, 288.0f)
                lineTo(32.0f, 240.0f)
                curveTo(32.0f, 213.5f, 53.5f, 192.0f, 80.0f, 192.0f)
                lineTo(96.0f, 192.0f)
                lineTo(96.0f, 176.0f)
                close()
            }
        }
        .build()
        return _dumbbell!!
    }

private var _dumbbell: ImageVector? = null
