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

public val Fa.C: ImageVector
    get() {
        if (_c != null) {
            return _c!!
        }
        _c = Builder(name = "C", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(457.1f, 206.9f)
                curveTo(394.6f, 144.4f, 301.3f, 144.4f, 238.8f, 206.9f)
                curveTo(176.3f, 269.4f, 176.3f, 370.7f, 238.8f, 433.2f)
                curveTo(301.3f, 495.7f, 394.6f, 495.7f, 457.1f, 433.2f)
                curveTo(469.6f, 420.7f, 489.9f, 420.7f, 502.4f, 433.2f)
                curveTo(514.9f, 445.7f, 514.9f, 466.0f, 502.4f, 478.5f)
                curveTo(414.9f, 566.0f, 281.1f, 566.0f, 193.6f, 478.5f)
                curveTo(106.1f, 391.0f, 106.1f, 249.2f, 193.6f, 161.7f)
                curveTo(281.1f, 74.2f, 414.9f, 74.2f, 502.4f, 161.7f)
                curveTo(514.9f, 174.2f, 514.9f, 194.5f, 502.4f, 207.0f)
                curveTo(489.9f, 219.5f, 469.6f, 219.5f, 457.1f, 207.0f)
                close()
            }
        }
        .build()
        return _c!!
    }

private var _c: ImageVector? = null
