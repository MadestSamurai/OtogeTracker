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

public val Fa.Camera: ImageVector
    get() {
        if (_camera != null) {
            return _camera!!
        }
        _camera = Builder(name = "Camera", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(213.1f, 128.8f)
                lineTo(202.7f, 160.0f)
                lineTo(128.0f, 160.0f)
                curveTo(92.7f, 160.0f, 64.0f, 188.7f, 64.0f, 224.0f)
                lineTo(64.0f, 480.0f)
                curveTo(64.0f, 515.3f, 92.7f, 544.0f, 128.0f, 544.0f)
                lineTo(512.0f, 544.0f)
                curveTo(547.3f, 544.0f, 576.0f, 515.3f, 576.0f, 480.0f)
                lineTo(576.0f, 224.0f)
                curveTo(576.0f, 188.7f, 547.3f, 160.0f, 512.0f, 160.0f)
                lineTo(437.3f, 160.0f)
                lineTo(426.9f, 128.8f)
                curveTo(420.4f, 109.2f, 402.1f, 96.0f, 381.4f, 96.0f)
                lineTo(258.6f, 96.0f)
                curveTo(237.9f, 96.0f, 219.6f, 109.2f, 213.1f, 128.8f)
                close()
                moveTo(320.0f, 256.0f)
                curveTo(373.0f, 256.0f, 416.0f, 299.0f, 416.0f, 352.0f)
                curveTo(416.0f, 405.0f, 373.0f, 448.0f, 320.0f, 448.0f)
                curveTo(267.0f, 448.0f, 224.0f, 405.0f, 224.0f, 352.0f)
                curveTo(224.0f, 299.0f, 267.0f, 256.0f, 320.0f, 256.0f)
                close()
            }
        }
        .build()
        return _camera!!
    }

private var _camera: ImageVector? = null
