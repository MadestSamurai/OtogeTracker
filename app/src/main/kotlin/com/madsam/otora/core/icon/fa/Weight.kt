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

public val Fa.Weight: ImageVector
    get() {
        if (_weight != null) {
            return _weight!!
        }
        _weight = Builder(name = "Weight", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(212.6f, 256.0f)
                curveTo(209.6f, 245.9f, 208.0f, 235.1f, 208.0f, 224.0f)
                curveTo(208.0f, 162.1f, 258.1f, 112.0f, 320.0f, 112.0f)
                curveTo(381.9f, 112.0f, 432.0f, 162.1f, 432.0f, 224.0f)
                curveTo(432.0f, 235.1f, 430.4f, 245.9f, 427.4f, 256.0f)
                lineTo(356.4f, 256.0f)
                lineTo(381.0f, 211.7f)
                curveTo(387.4f, 200.1f, 383.3f, 185.5f, 371.7f, 179.1f)
                curveTo(360.1f, 172.7f, 345.5f, 176.8f, 339.1f, 188.4f)
                lineTo(301.5f, 256.1f)
                lineTo(212.7f, 256.1f)
                close()
                moveTo(224.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(416.0f, 96.0f)
                curveTo(389.3f, 75.9f, 356.0f, 64.0f, 320.0f, 64.0f)
                curveTo(284.0f, 64.0f, 250.7f, 75.9f, 224.0f, 96.0f)
                close()
            }
        }
        .build()
        return _weight!!
    }

private var _weight: ImageVector? = null
