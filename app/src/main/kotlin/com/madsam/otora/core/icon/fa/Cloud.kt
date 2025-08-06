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

public val Fa.Cloud: ImageVector
    get() {
        if (_cloud != null) {
            return _cloud!!
        }
        _cloud = Builder(name = "Cloud", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(32.0f, 400.0f)
                curveTo(32.0f, 479.5f, 96.5f, 544.0f, 176.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(550.7f, 544.0f, 608.0f, 486.7f, 608.0f, 416.0f)
                curveTo(608.0f, 364.4f, 577.5f, 319.9f, 533.5f, 299.7f)
                curveTo(540.2f, 286.6f, 544.0f, 271.7f, 544.0f, 256.0f)
                curveTo(544.0f, 203.0f, 501.0f, 160.0f, 448.0f, 160.0f)
                curveTo(430.3f, 160.0f, 413.8f, 164.8f, 399.6f, 173.1f)
                curveTo(375.5f, 127.3f, 327.4f, 96.0f, 272.0f, 96.0f)
                curveTo(192.5f, 96.0f, 128.0f, 160.5f, 128.0f, 240.0f)
                curveTo(128.0f, 248.0f, 128.7f, 255.9f, 129.9f, 263.5f)
                curveTo(73.0f, 282.7f, 32.0f, 336.6f, 32.0f, 400.0f)
                close()
            }
        }
        .build()
        return _cloud!!
    }

private var _cloud: ImageVector? = null
