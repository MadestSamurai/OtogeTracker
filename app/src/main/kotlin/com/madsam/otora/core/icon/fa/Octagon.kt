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

public val Fa.Octagon: ImageVector
    get() {
        if (_octagon != null) {
            return _octagon!!
        }
        _octagon = Builder(name = "Octagon", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(252.6f, 64.1f)
                curveTo(235.6f, 64.1f, 219.3f, 70.8f, 207.3f, 82.8f)
                lineTo(83.2f, 207.0f)
                curveTo(71.2f, 219.0f, 64.5f, 235.2f, 64.5f, 252.2f)
                lineTo(64.5f, 387.8f)
                curveTo(64.5f, 404.8f, 71.2f, 421.1f, 83.2f, 433.1f)
                lineTo(207.4f, 557.2f)
                curveTo(219.4f, 569.2f, 235.7f, 575.9f, 252.7f, 575.9f)
                lineTo(388.3f, 575.9f)
                curveTo(405.3f, 575.9f, 421.6f, 569.2f, 433.6f, 557.2f)
                lineTo(557.6f, 433.0f)
                curveTo(569.6f, 421.0f, 576.3f, 404.7f, 576.3f, 387.7f)
                lineTo(576.3f, 252.1f)
                curveTo(576.3f, 235.1f, 569.6f, 218.8f, 557.6f, 206.8f)
                lineTo(433.5f, 82.8f)
                curveTo(421.5f, 70.8f, 405.2f, 64.1f, 388.2f, 64.1f)
                lineTo(252.6f, 64.1f)
                close()
            }
        }
        .build()
        return _octagon!!
    }

private var _octagon: ImageVector? = null
