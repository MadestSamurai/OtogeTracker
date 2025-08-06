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

public val Fa.Copy: ImageVector
    get() {
        if (_copy != null) {
            return _copy!!
        }
        _copy = Builder(name = "Copy", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.0f, 64.0f)
                curveTo(252.7f, 64.0f, 224.0f, 92.7f, 224.0f, 128.0f)
                lineTo(224.0f, 384.0f)
                curveTo(224.0f, 419.3f, 252.7f, 448.0f, 288.0f, 448.0f)
                lineTo(480.0f, 448.0f)
                curveTo(515.3f, 448.0f, 544.0f, 419.3f, 544.0f, 384.0f)
                lineTo(544.0f, 183.4f)
                curveTo(544.0f, 166.0f, 536.9f, 149.3f, 524.3f, 137.2f)
                lineTo(466.6f, 81.8f)
                curveTo(454.7f, 70.4f, 438.8f, 64.0f, 422.3f, 64.0f)
                lineTo(288.0f, 64.0f)
                close()
                moveTo(160.0f, 192.0f)
                curveTo(124.7f, 192.0f, 96.0f, 220.7f, 96.0f, 256.0f)
                lineTo(96.0f, 512.0f)
                curveTo(96.0f, 547.3f, 124.7f, 576.0f, 160.0f, 576.0f)
                lineTo(352.0f, 576.0f)
                curveTo(387.3f, 576.0f, 416.0f, 547.3f, 416.0f, 512.0f)
                lineTo(416.0f, 496.0f)
                lineTo(352.0f, 496.0f)
                lineTo(352.0f, 512.0f)
                lineTo(160.0f, 512.0f)
                lineTo(160.0f, 256.0f)
                lineTo(176.0f, 256.0f)
                lineTo(176.0f, 192.0f)
                lineTo(160.0f, 192.0f)
                close()
            }
        }
        .build()
        return _copy!!
    }

private var _copy: ImageVector? = null
