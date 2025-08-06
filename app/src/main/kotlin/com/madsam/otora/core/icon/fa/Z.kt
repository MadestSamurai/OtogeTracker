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

public val Fa.Z: ImageVector
    get() {
        if (_z != null) {
            return _z!!
        }
        _z = Builder(name = "Z", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(128.0f, 110.3f, 142.3f, 96.0f, 160.0f, 96.0f)
                lineTo(480.0f, 96.0f)
                curveTo(492.4f, 96.0f, 503.7f, 103.2f, 509.0f, 114.4f)
                curveTo(514.3f, 125.6f, 512.6f, 138.9f, 504.6f, 148.5f)
                lineTo(228.3f, 480.0f)
                lineTo(480.0f, 480.0f)
                curveTo(497.7f, 480.0f, 512.0f, 494.3f, 512.0f, 512.0f)
                curveTo(512.0f, 529.7f, 497.7f, 544.0f, 480.0f, 544.0f)
                lineTo(160.0f, 544.0f)
                curveTo(147.6f, 544.0f, 136.3f, 536.8f, 131.0f, 525.6f)
                curveTo(125.7f, 514.4f, 127.4f, 501.1f, 135.4f, 491.5f)
                lineTo(411.7f, 160.0f)
                lineTo(160.0f, 160.0f)
                curveTo(142.3f, 160.0f, 128.0f, 145.7f, 128.0f, 128.0f)
                close()
            }
        }
        .build()
        return _z!!
    }

private var _z: ImageVector? = null
