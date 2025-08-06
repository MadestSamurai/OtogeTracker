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

public val Fa.Moon: ImageVector
    get() {
        if (_moon != null) {
            return _moon!!
        }
        _moon = Builder(name = "Moon", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                curveTo(388.8f, 576.0f, 451.3f, 548.8f, 497.3f, 504.6f)
                curveTo(504.6f, 497.6f, 506.7f, 486.7f, 502.6f, 477.5f)
                curveTo(498.5f, 468.3f, 488.9f, 462.6f, 478.8f, 463.4f)
                curveTo(473.9f, 463.8f, 469.0f, 464.0f, 464.0f, 464.0f)
                curveTo(362.4f, 464.0f, 280.0f, 381.6f, 280.0f, 280.0f)
                curveTo(280.0f, 207.9f, 321.5f, 145.4f, 382.1f, 115.2f)
                curveTo(391.2f, 110.7f, 396.4f, 100.9f, 395.2f, 90.8f)
                curveTo(394.0f, 80.7f, 386.6f, 72.5f, 376.7f, 70.3f)
                curveTo(358.4f, 66.2f, 339.4f, 64.0f, 320.0f, 64.0f)
                close()
            }
        }
        .build()
        return _moon!!
    }

private var _moon: ImageVector? = null
