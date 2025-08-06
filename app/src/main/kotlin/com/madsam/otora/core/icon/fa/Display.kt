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

public val Fa.Display: ImageVector
    get() {
        if (_display != null) {
            return _display!!
        }
        _display = Builder(name = "Display", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(512.0f, 160.0f)
                lineTo(512.0f, 416.0f)
                lineTo(128.0f, 416.0f)
                lineTo(128.0f, 160.0f)
                lineTo(512.0f, 160.0f)
                close()
                moveTo(128.0f, 96.0f)
                curveTo(92.7f, 96.0f, 64.0f, 124.7f, 64.0f, 160.0f)
                lineTo(64.0f, 416.0f)
                curveTo(64.0f, 451.3f, 92.7f, 480.0f, 128.0f, 480.0f)
                lineTo(272.0f, 480.0f)
                lineTo(256.0f, 528.0f)
                lineTo(184.0f, 528.0f)
                curveTo(170.7f, 528.0f, 160.0f, 538.7f, 160.0f, 552.0f)
                curveTo(160.0f, 565.3f, 170.7f, 576.0f, 184.0f, 576.0f)
                lineTo(456.0f, 576.0f)
                curveTo(469.3f, 576.0f, 480.0f, 565.3f, 480.0f, 552.0f)
                curveTo(480.0f, 538.7f, 469.3f, 528.0f, 456.0f, 528.0f)
                lineTo(384.0f, 528.0f)
                lineTo(368.0f, 480.0f)
                lineTo(512.0f, 480.0f)
                curveTo(547.3f, 480.0f, 576.0f, 451.3f, 576.0f, 416.0f)
                lineTo(576.0f, 160.0f)
                curveTo(576.0f, 124.7f, 547.3f, 96.0f, 512.0f, 96.0f)
                lineTo(128.0f, 96.0f)
                close()
            }
        }
        .build()
        return _display!!
    }

private var _display: ImageVector? = null
