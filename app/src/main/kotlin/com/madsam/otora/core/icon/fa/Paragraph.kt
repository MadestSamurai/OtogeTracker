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

public val Fa.Paragraph: ImageVector
    get() {
        if (_paragraph != null) {
            return _paragraph!!
        }
        _paragraph = Builder(name = "Paragraph", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 64.0f)
                lineTo(512.0f, 64.0f)
                curveTo(529.7f, 64.0f, 544.0f, 78.3f, 544.0f, 96.0f)
                curveTo(544.0f, 113.7f, 529.7f, 128.0f, 512.0f, 128.0f)
                lineTo(480.0f, 128.0f)
                lineTo(480.0f, 544.0f)
                curveTo(480.0f, 561.7f, 465.7f, 576.0f, 448.0f, 576.0f)
                curveTo(430.3f, 576.0f, 416.0f, 561.7f, 416.0f, 544.0f)
                lineTo(416.0f, 128.0f)
                lineTo(368.0f, 128.0f)
                lineTo(368.0f, 544.0f)
                curveTo(368.0f, 561.7f, 353.7f, 576.0f, 336.0f, 576.0f)
                curveTo(318.3f, 576.0f, 304.0f, 561.7f, 304.0f, 544.0f)
                lineTo(304.0f, 384.0f)
                lineTo(256.0f, 384.0f)
                curveTo(167.6f, 384.0f, 96.0f, 312.4f, 96.0f, 224.0f)
                curveTo(96.0f, 135.6f, 167.6f, 64.0f, 256.0f, 64.0f)
                close()
            }
        }
        .build()
        return _paragraph!!
    }

private var _paragraph: ImageVector? = null
