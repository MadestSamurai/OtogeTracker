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

public val Fa.Font: ImageVector
    get() {
        if (_font != null) {
            return _font!!
        }
        _font = Builder(name = "Font", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(349.1f, 114.7f)
                curveTo(343.9f, 103.3f, 332.5f, 96.0f, 320.0f, 96.0f)
                curveTo(307.5f, 96.0f, 296.1f, 103.3f, 290.9f, 114.7f)
                lineTo(123.5f, 480.0f)
                lineTo(112.0f, 480.0f)
                curveTo(94.3f, 480.0f, 80.0f, 494.3f, 80.0f, 512.0f)
                curveTo(80.0f, 529.7f, 94.3f, 544.0f, 112.0f, 544.0f)
                lineTo(200.0f, 544.0f)
                curveTo(217.7f, 544.0f, 232.0f, 529.7f, 232.0f, 512.0f)
                curveTo(232.0f, 494.3f, 217.7f, 480.0f, 200.0f, 480.0f)
                lineTo(193.9f, 480.0f)
                lineTo(215.9f, 432.0f)
                lineTo(424.2f, 432.0f)
                lineTo(446.2f, 480.0f)
                lineTo(440.1f, 480.0f)
                curveTo(422.4f, 480.0f, 408.1f, 494.3f, 408.1f, 512.0f)
                curveTo(408.1f, 529.7f, 422.4f, 544.0f, 440.1f, 544.0f)
                lineTo(528.1f, 544.0f)
                curveTo(545.8f, 544.0f, 560.1f, 529.7f, 560.1f, 512.0f)
                curveTo(560.1f, 494.3f, 545.8f, 480.0f, 528.1f, 480.0f)
                lineTo(516.6f, 480.0f)
                lineTo(349.2f, 114.7f)
                close()
                moveTo(394.8f, 368.0f)
                lineTo(245.2f, 368.0f)
                lineTo(320.0f, 204.8f)
                lineTo(394.8f, 368.0f)
                close()
            }
        }
        .build()
        return _font!!
    }

private var _font: ImageVector? = null
