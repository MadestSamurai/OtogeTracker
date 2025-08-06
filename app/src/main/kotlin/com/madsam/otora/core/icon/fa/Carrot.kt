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

public val Fa.Carrot: ImageVector
    get() {
        if (_carrot != null) {
            return _carrot!!
        }
        _carrot = Builder(name = "Carrot", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(453.1f, 27.3f)
                lineTo(440.9f, 39.4f)
                curveTo(409.7f, 70.6f, 409.7f, 121.3f, 440.9f, 152.5f)
                curveTo(456.5f, 168.1f, 472.1f, 183.7f, 487.8f, 199.4f)
                curveTo(519.0f, 230.6f, 569.7f, 230.6f, 600.9f, 199.4f)
                lineTo(613.0f, 187.3f)
                curveTo(619.2f, 181.1f, 619.2f, 170.9f, 613.0f, 164.7f)
                lineTo(600.9f, 152.6f)
                curveTo(569.7f, 121.4f, 519.0f, 121.4f, 487.8f, 152.6f)
                curveTo(519.0f, 121.4f, 519.0f, 70.7f, 487.8f, 39.5f)
                lineTo(475.7f, 27.3f)
                curveTo(469.5f, 21.1f, 459.3f, 21.1f, 453.1f, 27.3f)
                close()
                moveTo(331.6f, 160.0f)
                curveTo(286.4f, 160.0f, 244.5f, 180.4f, 216.6f, 214.3f)
                lineTo(273.3f, 271.0f)
                curveTo(282.7f, 280.4f, 282.7f, 295.6f, 273.3f, 304.9f)
                curveTo(263.9f, 314.2f, 248.7f, 314.3f, 239.4f, 304.9f)
                lineTo(191.6f, 257.2f)
                lineTo(67.2f, 530.8f)
                curveTo(61.7f, 542.9f, 64.3f, 557.2f, 73.7f, 566.7f)
                curveTo(83.1f, 576.2f, 97.4f, 578.7f, 109.6f, 573.2f)
                lineTo(251.2f, 508.8f)
                lineTo(207.4f, 465.0f)
                curveTo(198.0f, 455.6f, 198.0f, 440.4f, 207.4f, 431.1f)
                curveTo(216.8f, 421.8f, 232.0f, 421.7f, 241.3f, 431.1f)
                lineTo(297.8f, 487.6f)
                lineTo(393.1f, 444.3f)
                curveTo(446.2f, 420.2f, 480.3f, 367.2f, 480.3f, 308.8f)
                curveTo(480.3f, 226.6f, 413.7f, 160.0f, 331.5f, 160.0f)
                close()
            }
        }
        .build()
        return _carrot!!
    }

private var _carrot: ImageVector? = null
