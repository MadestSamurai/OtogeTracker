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

public val Fa.Crow: ImageVector
    get() {
        if (_crow != null) {
            return _crow!!
        }
        _crow = Builder(name = "Crow", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(456.5f, 64.0f)
                curveTo(407.9f, 64.0f, 368.5f, 103.4f, 368.5f, 152.0f)
                lineTo(368.5f, 188.0f)
                lineTo(13.3f, 454.4f)
                curveTo(-0.8f, 465.0f, -3.7f, 485.0f, 6.9f, 499.2f)
                curveTo(17.5f, 513.4f, 37.5f, 516.2f, 51.7f, 505.6f)
                lineTo(128.5f, 448.0f)
                lineTo(259.8f, 448.0f)
                lineTo(306.4f, 561.1f)
                lineTo(307.4f, 563.3f)
                curveTo(313.1f, 574.0f, 326.2f, 578.8f, 337.7f, 574.1f)
                curveTo(349.2f, 569.4f, 355.0f, 556.8f, 351.6f, 545.1f)
                lineTo(350.8f, 542.8f)
                lineTo(311.7f, 447.9f)
                lineTo(352.6f, 447.9f)
                curveTo(353.7f, 447.9f, 354.8f, 447.9f, 355.8f, 447.9f)
                lineTo(402.4f, 561.1f)
                lineTo(403.4f, 563.3f)
                curveTo(409.1f, 574.0f, 422.2f, 578.8f, 433.7f, 574.1f)
                curveTo(445.2f, 569.4f, 451.0f, 556.8f, 447.6f, 545.1f)
                lineTo(446.8f, 542.8f)
                lineTo(404.8f, 440.8f)
                curveTo(485.3f, 418.1f, 544.5f, 344.0f, 544.5f, 256.0f)
                lineTo(544.5f, 184.0f)
                lineTo(625.0f, 163.9f)
                curveTo(633.6f, 161.8f, 638.8f, 153.1f, 636.6f, 144.5f)
                curveTo(629.5f, 116.0f, 603.9f, 96.0f, 574.5f, 96.0f)
                lineTo(524.4f, 96.0f)
                curveTo(508.2f, 76.5f, 483.8f, 64.0f, 456.5f, 64.0f)
                close()
                moveTo(456.5f, 128.0f)
                curveTo(469.8f, 128.0f, 480.5f, 138.7f, 480.5f, 152.0f)
                curveTo(480.5f, 165.3f, 469.8f, 176.0f, 456.5f, 176.0f)
                curveTo(443.2f, 176.0f, 432.5f, 165.3f, 432.5f, 152.0f)
                curveTo(432.5f, 138.7f, 443.2f, 128.0f, 456.5f, 128.0f)
                close()
            }
        }
        .build()
        return _crow!!
    }

private var _crow: ImageVector? = null
