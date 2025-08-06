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

public val Fa.M: ImageVector
    get() {
        if (_m != null) {
            return _m!!
        }
        _m = Builder(name = "M", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(118.7f, 97.4f)
                curveTo(132.2f, 93.3f, 146.8f, 98.5f, 154.6f, 110.3f)
                lineTo(320.0f, 358.3f)
                lineTo(485.4f, 110.3f)
                curveTo(493.2f, 98.6f, 507.8f, 93.3f, 521.3f, 97.4f)
                curveTo(534.8f, 101.5f, 544.0f, 113.9f, 544.0f, 128.0f)
                lineTo(544.0f, 512.0f)
                curveTo(544.0f, 529.7f, 529.7f, 544.0f, 512.0f, 544.0f)
                curveTo(494.3f, 544.0f, 480.0f, 529.7f, 480.0f, 512.0f)
                lineTo(480.0f, 233.7f)
                lineTo(346.6f, 433.8f)
                curveTo(340.7f, 442.7f, 330.7f, 448.0f, 320.0f, 448.0f)
                curveTo(309.3f, 448.0f, 299.3f, 442.7f, 293.4f, 433.8f)
                lineTo(160.0f, 233.7f)
                lineTo(160.0f, 512.0f)
                curveTo(160.0f, 529.7f, 145.7f, 544.0f, 128.0f, 544.0f)
                curveTo(110.3f, 544.0f, 96.0f, 529.7f, 96.0f, 512.0f)
                lineTo(96.0f, 128.0f)
                curveTo(96.0f, 113.9f, 105.2f, 101.5f, 118.7f, 97.4f)
                close()
            }
        }
        .build()
        return _m!!
    }

private var _m: ImageVector? = null
