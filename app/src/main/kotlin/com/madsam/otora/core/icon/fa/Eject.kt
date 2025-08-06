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

public val Fa.Eject: ImageVector
    get() {
        if (_eject != null) {
            return _eject!!
        }
        _eject = Builder(name = "Eject", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 96.0f)
                curveTo(333.5f, 96.0f, 346.3f, 101.6f, 355.4f, 111.6f)
                lineTo(531.4f, 303.6f)
                curveTo(544.3f, 317.6f, 547.6f, 337.9f, 540.0f, 355.4f)
                curveTo(532.4f, 372.9f, 515.0f, 384.0f, 496.0f, 384.0f)
                lineTo(144.0f, 384.0f)
                curveTo(125.0f, 384.0f, 107.7f, 372.8f, 100.1f, 355.3f)
                curveTo(92.5f, 337.8f, 95.8f, 317.6f, 108.7f, 303.5f)
                lineTo(284.7f, 111.5f)
                curveTo(293.7f, 101.6f, 306.5f, 96.0f, 320.0f, 96.0f)
                close()
                moveTo(96.0f, 496.0f)
                curveTo(96.0f, 469.5f, 117.5f, 448.0f, 144.0f, 448.0f)
                lineTo(496.0f, 448.0f)
                curveTo(522.5f, 448.0f, 544.0f, 469.5f, 544.0f, 496.0f)
                curveTo(544.0f, 522.5f, 522.5f, 544.0f, 496.0f, 544.0f)
                lineTo(144.0f, 544.0f)
                curveTo(117.5f, 544.0f, 96.0f, 522.5f, 96.0f, 496.0f)
                close()
            }
        }
        .build()
        return _eject!!
    }

private var _eject: ImageVector? = null
