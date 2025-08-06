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

public val Fa.Cross: ImageVector
    get() {
        if (_cross != null) {
            return _cross!!
        }
        _cross = Builder(name = "Cross", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(304.0f, 64.0f)
                curveTo(277.5f, 64.0f, 256.0f, 85.5f, 256.0f, 112.0f)
                lineTo(256.0f, 192.0f)
                lineTo(176.0f, 192.0f)
                curveTo(149.5f, 192.0f, 128.0f, 213.5f, 128.0f, 240.0f)
                lineTo(128.0f, 272.0f)
                curveTo(128.0f, 298.5f, 149.5f, 320.0f, 176.0f, 320.0f)
                lineTo(256.0f, 320.0f)
                lineTo(256.0f, 528.0f)
                curveTo(256.0f, 554.5f, 277.5f, 576.0f, 304.0f, 576.0f)
                lineTo(336.0f, 576.0f)
                curveTo(362.5f, 576.0f, 384.0f, 554.5f, 384.0f, 528.0f)
                lineTo(384.0f, 320.0f)
                lineTo(464.0f, 320.0f)
                curveTo(490.5f, 320.0f, 512.0f, 298.5f, 512.0f, 272.0f)
                lineTo(512.0f, 240.0f)
                curveTo(512.0f, 213.5f, 490.5f, 192.0f, 464.0f, 192.0f)
                lineTo(384.0f, 192.0f)
                lineTo(384.0f, 112.0f)
                curveTo(384.0f, 85.5f, 362.5f, 64.0f, 336.0f, 64.0f)
                lineTo(304.0f, 64.0f)
                close()
            }
        }
        .build()
        return _cross!!
    }

private var _cross: ImageVector? = null
