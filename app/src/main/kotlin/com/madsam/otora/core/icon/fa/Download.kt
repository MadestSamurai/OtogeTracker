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

public val Fa.Download: ImageVector
    get() {
        if (_download != null) {
            return _download!!
        }
        _download = Builder(name = "Download", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 96.0f)
                curveTo(352.0f, 78.3f, 337.7f, 64.0f, 320.0f, 64.0f)
                curveTo(302.3f, 64.0f, 288.0f, 78.3f, 288.0f, 96.0f)
                lineTo(288.0f, 306.7f)
                lineTo(246.6f, 265.3f)
                curveTo(234.1f, 252.8f, 213.8f, 252.8f, 201.3f, 265.3f)
                curveTo(188.8f, 277.8f, 188.8f, 298.1f, 201.3f, 310.6f)
                lineTo(297.3f, 406.6f)
                curveTo(309.8f, 419.1f, 330.1f, 419.1f, 342.6f, 406.6f)
                lineTo(438.6f, 310.6f)
                curveTo(451.1f, 298.1f, 451.1f, 277.8f, 438.6f, 265.3f)
                curveTo(426.1f, 252.8f, 405.8f, 252.8f, 393.3f, 265.3f)
                lineTo(352.0f, 306.7f)
                lineTo(352.0f, 96.0f)
                close()
                moveTo(160.0f, 384.0f)
                curveTo(124.7f, 384.0f, 96.0f, 412.7f, 96.0f, 448.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 448.0f)
                curveTo(544.0f, 412.7f, 515.3f, 384.0f, 480.0f, 384.0f)
                lineTo(433.1f, 384.0f)
                lineTo(376.5f, 440.6f)
                curveTo(345.3f, 471.8f, 294.6f, 471.8f, 263.4f, 440.6f)
                lineTo(206.9f, 384.0f)
                lineTo(160.0f, 384.0f)
                close()
                moveTo(464.0f, 440.0f)
                curveTo(477.3f, 440.0f, 488.0f, 450.7f, 488.0f, 464.0f)
                curveTo(488.0f, 477.3f, 477.3f, 488.0f, 464.0f, 488.0f)
                curveTo(450.7f, 488.0f, 440.0f, 477.3f, 440.0f, 464.0f)
                curveTo(440.0f, 450.7f, 450.7f, 440.0f, 464.0f, 440.0f)
                close()
            }
        }
        .build()
        return _download!!
    }

private var _download: ImageVector? = null
