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

public val Fa.Soap: ImageVector
    get() {
        if (_soap != null) {
            return _soap!!
        }
        _soap = Builder(name = "Soap", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(272.0f, 32.0f)
                curveTo(298.5f, 32.0f, 320.0f, 53.5f, 320.0f, 80.0f)
                curveTo(320.0f, 106.5f, 298.5f, 128.0f, 272.0f, 128.0f)
                curveTo(245.5f, 128.0f, 224.0f, 106.5f, 224.0f, 80.0f)
                curveTo(224.0f, 53.5f, 245.5f, 32.0f, 272.0f, 32.0f)
                close()
                moveTo(384.0f, 160.0f)
                curveTo(419.3f, 160.0f, 448.0f, 188.7f, 448.0f, 224.0f)
                curveTo(448.0f, 259.3f, 419.3f, 288.0f, 384.0f, 288.0f)
                curveTo(348.7f, 288.0f, 320.0f, 259.3f, 320.0f, 224.0f)
                curveTo(320.0f, 188.7f, 348.7f, 160.0f, 384.0f, 160.0f)
                close()
                moveTo(416.0f, 64.0f)
                curveTo(416.0f, 46.3f, 430.3f, 32.0f, 448.0f, 32.0f)
                curveTo(465.7f, 32.0f, 480.0f, 46.3f, 480.0f, 64.0f)
                curveTo(480.0f, 81.7f, 465.7f, 96.0f, 448.0f, 96.0f)
                curveTo(430.3f, 96.0f, 416.0f, 81.7f, 416.0f, 64.0f)
                close()
                moveTo(160.0f, 224.0f)
                lineTo(272.0f, 224.0f)
                curveTo(272.0f, 247.8f, 279.4f, 269.9f, 292.1f, 288.0f)
                lineTo(224.0f, 288.0f)
                curveTo(171.0f, 288.0f, 128.0f, 331.0f, 128.0f, 384.0f)
                curveTo(128.0f, 437.0f, 171.0f, 480.0f, 224.0f, 480.0f)
                lineTo(416.0f, 480.0f)
                curveTo(469.0f, 480.0f, 512.0f, 437.0f, 512.0f, 384.0f)
                curveTo(512.0f, 348.9f, 493.1f, 318.1f, 465.0f, 301.4f)
                curveTo(484.0f, 281.6f, 495.7f, 254.8f, 496.0f, 225.3f)
                curveTo(541.4f, 232.9f, 576.0f, 272.4f, 576.0f, 320.0f)
                lineTo(576.0f, 448.0f)
                curveTo(576.0f, 501.0f, 533.0f, 544.0f, 480.0f, 544.0f)
                lineTo(160.0f, 544.0f)
                curveTo(107.0f, 544.0f, 64.0f, 501.0f, 64.0f, 448.0f)
                lineTo(64.0f, 320.0f)
                curveTo(64.0f, 267.0f, 107.0f, 224.0f, 160.0f, 224.0f)
                close()
                moveTo(224.0f, 336.0f)
                lineTo(416.0f, 336.0f)
                curveTo(442.5f, 336.0f, 464.0f, 357.5f, 464.0f, 384.0f)
                curveTo(464.0f, 410.5f, 442.5f, 432.0f, 416.0f, 432.0f)
                lineTo(224.0f, 432.0f)
                curveTo(197.5f, 432.0f, 176.0f, 410.5f, 176.0f, 384.0f)
                curveTo(176.0f, 357.5f, 197.5f, 336.0f, 224.0f, 336.0f)
                close()
            }
        }
        .build()
        return _soap!!
    }

private var _soap: ImageVector? = null
