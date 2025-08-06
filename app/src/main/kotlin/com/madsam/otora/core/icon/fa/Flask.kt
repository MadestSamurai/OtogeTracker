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

public val Fa.Flask: ImageVector
    get() {
        if (_flask != null) {
            return _flask!!
        }
        _flask = Builder(name = "Flask", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(384.0f, 64.0f)
                lineTo(224.0f, 64.0f)
                curveTo(206.3f, 64.0f, 192.0f, 78.3f, 192.0f, 96.0f)
                curveTo(192.0f, 113.7f, 206.3f, 128.0f, 224.0f, 128.0f)
                lineTo(224.0f, 279.5f)
                lineTo(103.5f, 490.3f)
                curveTo(98.6f, 499.0f, 96.0f, 508.7f, 96.0f, 518.7f)
                curveTo(96.0f, 550.4f, 121.6f, 576.0f, 153.3f, 576.0f)
                lineTo(486.7f, 576.0f)
                curveTo(518.3f, 576.0f, 544.0f, 550.4f, 544.0f, 518.7f)
                curveTo(544.0f, 508.7f, 541.4f, 498.9f, 536.5f, 490.3f)
                lineTo(416.0f, 279.5f)
                lineTo(416.0f, 128.0f)
                curveTo(433.7f, 128.0f, 448.0f, 113.7f, 448.0f, 96.0f)
                curveTo(448.0f, 78.3f, 433.7f, 64.0f, 416.0f, 64.0f)
                lineTo(384.0f, 64.0f)
                close()
                moveTo(288.0f, 279.5f)
                lineTo(288.0f, 128.0f)
                lineTo(352.0f, 128.0f)
                lineTo(352.0f, 279.5f)
                curveTo(352.0f, 290.6f, 354.9f, 301.6f, 360.4f, 311.3f)
                lineTo(402.0f, 384.0f)
                lineTo(238.0f, 384.0f)
                lineTo(279.6f, 311.3f)
                curveTo(285.1f, 301.6f, 288.0f, 290.7f, 288.0f, 279.5f)
                close()
            }
        }
        .build()
        return _flask!!
    }

private var _flask: ImageVector? = null
