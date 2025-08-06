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

public val Fa.Sort: ImageVector
    get() {
        if (_sort != null) {
            return _sort!!
        }
        _sort = Builder(name = "Sort", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(130.4f, 268.2f)
                curveTo(135.4f, 280.2f, 147.0f, 288.0f, 160.0f, 288.0f)
                lineTo(480.0f, 288.0f)
                curveTo(492.9f, 288.0f, 504.6f, 280.2f, 509.6f, 268.2f)
                curveTo(514.6f, 256.2f, 511.8f, 242.5f, 502.7f, 233.3f)
                lineTo(342.7f, 73.3f)
                curveTo(330.2f, 60.8f, 309.9f, 60.8f, 297.4f, 73.3f)
                lineTo(137.4f, 233.3f)
                curveTo(128.2f, 242.5f, 125.5f, 256.2f, 130.5f, 268.2f)
                close()
                moveTo(130.4f, 371.7f)
                curveTo(125.4f, 383.7f, 128.2f, 397.4f, 137.3f, 406.6f)
                lineTo(297.3f, 566.6f)
                curveTo(309.8f, 579.1f, 330.1f, 579.1f, 342.6f, 566.6f)
                lineTo(502.6f, 406.6f)
                curveTo(511.8f, 397.4f, 514.5f, 383.7f, 509.5f, 371.7f)
                curveTo(504.5f, 359.7f, 492.9f, 352.0f, 480.0f, 352.0f)
                lineTo(160.0f, 352.0f)
                curveTo(147.1f, 352.0f, 135.4f, 359.8f, 130.4f, 371.8f)
                close()
            }
        }
        .build()
        return _sort!!
    }

private var _sort: ImageVector? = null
