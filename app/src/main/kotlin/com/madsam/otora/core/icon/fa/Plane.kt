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

public val Fa.Plane: ImageVector
    get() {
        if (_plane != null) {
            return _plane!!
        }
        _plane = Builder(name = "Plane", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(552.0f, 264.0f)
                curveTo(582.9f, 264.0f, 608.0f, 289.1f, 608.0f, 320.0f)
                curveTo(608.0f, 350.9f, 582.9f, 376.0f, 552.0f, 376.0f)
                lineTo(424.7f, 376.0f)
                lineTo(265.5f, 549.6f)
                curveTo(259.4f, 556.2f, 250.9f, 560.0f, 241.9f, 560.0f)
                lineTo(198.2f, 560.0f)
                curveTo(187.3f, 560.0f, 179.6f, 549.3f, 183.0f, 538.9f)
                lineTo(237.3f, 376.0f)
                lineTo(137.6f, 376.0f)
                lineTo(84.8f, 442.0f)
                curveTo(81.8f, 445.8f, 77.2f, 448.0f, 72.3f, 448.0f)
                lineTo(52.5f, 448.0f)
                curveTo(42.1f, 448.0f, 34.5f, 438.2f, 37.0f, 428.1f)
                lineTo(64.0f, 320.0f)
                lineTo(37.0f, 211.9f)
                curveTo(34.4f, 201.8f, 42.1f, 192.0f, 52.5f, 192.0f)
                lineTo(72.3f, 192.0f)
                curveTo(77.2f, 192.0f, 81.8f, 194.2f, 84.8f, 198.0f)
                lineTo(137.6f, 264.0f)
                lineTo(237.3f, 264.0f)
                lineTo(183.0f, 101.1f)
                curveTo(179.6f, 90.7f, 187.3f, 80.0f, 198.2f, 80.0f)
                lineTo(241.9f, 80.0f)
                curveTo(250.9f, 80.0f, 259.4f, 83.8f, 265.5f, 90.4f)
                lineTo(424.7f, 264.0f)
                lineTo(552.0f, 264.0f)
                close()
            }
        }
        .build()
        return _plane!!
    }

private var _plane: ImageVector? = null
