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

public val Fa.Thermometer: ImageVector
    get() {
        if (_thermometer != null) {
            return _thermometer!!
        }
        _thermometer = Builder(name = "Thermometer", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 446.1f)
                lineTo(160.0f, 357.3f)
                curveTo(160.0f, 342.4f, 165.9f, 328.2f, 176.4f, 317.7f)
                lineTo(198.1f, 296.0f)
                lineTo(239.1f, 337.0f)
                curveTo(248.5f, 346.4f, 263.7f, 346.4f, 273.0f, 337.0f)
                curveTo(282.3f, 327.6f, 282.4f, 312.4f, 273.0f, 303.1f)
                lineTo(232.0f, 262.1f)
                lineTo(278.1f, 216.0f)
                lineTo(319.1f, 257.0f)
                curveTo(328.5f, 266.4f, 343.7f, 266.4f, 353.0f, 257.0f)
                curveTo(362.3f, 247.6f, 362.4f, 232.4f, 353.0f, 223.1f)
                lineTo(312.0f, 182.1f)
                lineTo(358.1f, 136.0f)
                lineTo(399.1f, 177.0f)
                curveTo(408.5f, 186.4f, 423.7f, 186.4f, 433.0f, 177.0f)
                curveTo(442.3f, 167.6f, 442.4f, 152.4f, 433.0f, 143.1f)
                lineTo(392.0f, 102.1f)
                lineTo(399.8f, 94.3f)
                curveTo(419.2f, 74.9f, 445.4f, 64.1f, 472.8f, 64.1f)
                curveTo(529.8f, 64.1f, 576.0f, 110.3f, 576.0f, 167.3f)
                curveTo(576.0f, 194.7f, 565.1f, 220.9f, 545.8f, 240.3f)
                lineTo(322.3f, 463.6f)
                curveTo(311.8f, 474.1f, 297.6f, 480.0f, 282.7f, 480.0f)
                lineTo(193.9f, 480.0f)
                lineTo(104.9f, 569.0f)
                curveTo(95.5f, 578.4f, 80.3f, 578.4f, 71.0f, 569.0f)
                curveTo(61.7f, 559.6f, 61.7f, 544.4f, 71.0f, 535.0f)
                lineTo(160.0f, 446.0f)
                close()
            }
        }
        .build()
        return _thermometer!!
    }

private var _thermometer: ImageVector? = null
