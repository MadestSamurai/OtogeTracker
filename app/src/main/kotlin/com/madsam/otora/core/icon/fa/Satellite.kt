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

public val Fa.Satellite: ImageVector
    get() {
        if (_satellite != null) {
            return _satellite!!
        }
        _satellite = Builder(name = "Satellite", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(263.0f, 71.0f)
                curveTo(272.4f, 61.6f, 287.6f, 61.6f, 296.9f, 71.0f)
                lineTo(386.3f, 160.4f)
                lineTo(441.3f, 105.4f)
                curveTo(453.8f, 92.9f, 474.1f, 92.9f, 486.6f, 105.4f)
                lineTo(534.6f, 153.4f)
                curveTo(547.1f, 165.9f, 547.1f, 186.2f, 534.6f, 198.7f)
                lineTo(479.6f, 253.7f)
                lineTo(569.0f, 343.1f)
                curveTo(578.4f, 352.5f, 578.4f, 367.7f, 569.0f, 377.0f)
                lineTo(473.0f, 473.0f)
                curveTo(463.6f, 482.4f, 448.4f, 482.4f, 439.1f, 473.0f)
                lineTo(349.7f, 383.6f)
                lineTo(334.2f, 399.1f)
                curveTo(345.6f, 423.7f, 352.0f, 451.1f, 352.0f, 480.0f)
                curveTo(352.0f, 511.7f, 344.3f, 541.5f, 330.8f, 567.8f)
                curveTo(326.1f, 576.8f, 314.1f, 578.1f, 307.0f, 570.9f)
                lineTo(210.7f, 474.6f)
                lineTo(150.7f, 534.6f)
                curveTo(138.2f, 547.1f, 117.9f, 547.1f, 105.4f, 534.6f)
                curveTo(92.9f, 522.1f, 92.9f, 501.8f, 105.4f, 489.3f)
                lineTo(165.4f, 429.3f)
                lineTo(69.1f, 333.0f)
                curveTo(61.9f, 325.8f, 63.2f, 313.8f, 72.2f, 309.2f)
                curveTo(98.5f, 295.6f, 128.4f, 288.0f, 160.0f, 288.0f)
                curveTo(188.9f, 288.0f, 216.3f, 294.4f, 240.9f, 305.8f)
                lineTo(256.4f, 290.3f)
                lineTo(167.0f, 201.0f)
                curveTo(157.6f, 191.6f, 157.6f, 176.4f, 167.0f, 167.1f)
                lineTo(263.0f, 71.0f)
                close()
                moveTo(280.0f, 121.9f)
                lineTo(217.9f, 184.0f)
                lineTo(290.3f, 256.4f)
                lineTo(352.4f, 194.3f)
                lineTo(280.0f, 121.9f)
                close()
                moveTo(456.0f, 422.1f)
                lineTo(518.1f, 360.0f)
                lineTo(445.7f, 287.6f)
                lineTo(383.6f, 349.7f)
                lineTo(456.0f, 422.1f)
                close()
            }
        }
        .build()
        return _satellite!!
    }

private var _satellite: ImageVector? = null
