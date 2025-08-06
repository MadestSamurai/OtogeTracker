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

public val Fa.Rss: ImageVector
    get() {
        if (_rss != null) {
            return _rss!!
        }
        _rss = Builder(name = "Rss", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 128.0f)
                curveTo(96.0f, 110.3f, 110.3f, 96.0f, 128.0f, 96.0f)
                curveTo(357.8f, 96.0f, 544.0f, 282.2f, 544.0f, 512.0f)
                curveTo(544.0f, 529.7f, 529.7f, 544.0f, 512.0f, 544.0f)
                curveTo(494.3f, 544.0f, 480.0f, 529.7f, 480.0f, 512.0f)
                curveTo(480.0f, 317.6f, 322.4f, 160.0f, 128.0f, 160.0f)
                curveTo(110.3f, 160.0f, 96.0f, 145.7f, 96.0f, 128.0f)
                close()
                moveTo(96.0f, 480.0f)
                curveTo(96.0f, 444.7f, 124.7f, 416.0f, 160.0f, 416.0f)
                curveTo(195.3f, 416.0f, 224.0f, 444.7f, 224.0f, 480.0f)
                curveTo(224.0f, 515.3f, 195.3f, 544.0f, 160.0f, 544.0f)
                curveTo(124.7f, 544.0f, 96.0f, 515.3f, 96.0f, 480.0f)
                close()
                moveTo(128.0f, 224.0f)
                curveTo(287.1f, 224.0f, 416.0f, 352.9f, 416.0f, 512.0f)
                curveTo(416.0f, 529.7f, 401.7f, 544.0f, 384.0f, 544.0f)
                curveTo(366.3f, 544.0f, 352.0f, 529.7f, 352.0f, 512.0f)
                curveTo(352.0f, 388.3f, 251.7f, 288.0f, 128.0f, 288.0f)
                curveTo(110.3f, 288.0f, 96.0f, 273.7f, 96.0f, 256.0f)
                curveTo(96.0f, 238.3f, 110.3f, 224.0f, 128.0f, 224.0f)
                close()
            }
        }
        .build()
        return _rss!!
    }

private var _rss: ImageVector? = null
