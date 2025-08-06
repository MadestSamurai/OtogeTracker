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

public val Fa.Play: ImageVector
    get() {
        if (_play != null) {
            return _play!!
        }
        _play = Builder(name = "Play", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(187.2f, 100.9f)
                curveTo(174.8f, 94.1f, 159.8f, 94.4f, 147.6f, 101.6f)
                curveTo(135.4f, 108.8f, 128.0f, 121.9f, 128.0f, 136.0f)
                lineTo(128.0f, 504.0f)
                curveTo(128.0f, 518.1f, 135.5f, 531.2f, 147.6f, 538.4f)
                curveTo(159.7f, 545.6f, 174.8f, 545.9f, 187.2f, 539.1f)
                lineTo(523.2f, 355.1f)
                curveTo(536.0f, 348.1f, 544.0f, 334.6f, 544.0f, 320.0f)
                curveTo(544.0f, 305.4f, 536.0f, 291.9f, 523.2f, 284.9f)
                lineTo(187.2f, 100.9f)
                close()
            }
        }
        .build()
        return _play!!
    }

private var _play: ImageVector? = null
