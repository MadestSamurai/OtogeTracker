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

public val Fa.Box: ImageVector
    get() {
        if (_box != null) {
            return _box!!
        }
        _box = Builder(name = "Box", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(465.4f, 192.0f)
                lineTo(431.1f, 144.0f)
                lineTo(209.0f, 144.0f)
                lineTo(174.7f, 192.0f)
                lineTo(465.4f, 192.0f)
                close()
                moveTo(96.0f, 212.5f)
                curveTo(96.0f, 199.2f, 100.2f, 186.2f, 107.9f, 175.3f)
                lineTo(156.9f, 106.8f)
                curveTo(168.9f, 90.0f, 188.3f, 80.0f, 208.9f, 80.0f)
                lineTo(431.0f, 80.0f)
                curveTo(451.7f, 80.0f, 471.1f, 90.0f, 483.1f, 106.8f)
                lineTo(532.0f, 175.3f)
                curveTo(539.8f, 186.2f, 543.9f, 199.2f, 543.9f, 212.5f)
                lineTo(544.0f, 480.0f)
                curveTo(544.0f, 515.3f, 515.3f, 544.0f, 480.0f, 544.0f)
                lineTo(160.0f, 544.0f)
                curveTo(124.7f, 544.0f, 96.0f, 515.3f, 96.0f, 480.0f)
                lineTo(96.0f, 212.5f)
                close()
            }
        }
        .build()
        return _box!!
    }

private var _box: ImageVector? = null
