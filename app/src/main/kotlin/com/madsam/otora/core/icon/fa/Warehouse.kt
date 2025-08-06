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

public val Fa.Warehouse: ImageVector
    get() {
        if (_warehouse != null) {
            return _warehouse!!
        }
        _warehouse = Builder(name = "Warehouse", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(32.0f, 206.1f)
                lineTo(32.0f, 544.0f)
                curveTo(32.0f, 561.7f, 46.3f, 576.0f, 64.0f, 576.0f)
                curveTo(81.7f, 576.0f, 96.0f, 561.7f, 96.0f, 544.0f)
                lineTo(96.0f, 304.0f)
                curveTo(96.0f, 286.3f, 110.3f, 272.0f, 128.0f, 272.0f)
                lineTo(512.0f, 272.0f)
                curveTo(529.7f, 272.0f, 544.0f, 286.3f, 544.0f, 304.0f)
                lineTo(544.0f, 544.0f)
                curveTo(544.0f, 561.7f, 558.3f, 576.0f, 576.0f, 576.0f)
                curveTo(593.7f, 576.0f, 608.0f, 561.7f, 608.0f, 544.0f)
                lineTo(608.0f, 206.1f)
                curveTo(608.0f, 178.6f, 590.4f, 154.1f, 564.2f, 145.4f)
                lineTo(335.2f, 69.1f)
                curveTo(325.3f, 65.8f, 314.7f, 65.8f, 304.8f, 69.1f)
                lineTo(75.8f, 145.4f)
                curveTo(49.6f, 154.1f, 32.0f, 178.6f, 32.0f, 206.1f)
                close()
                moveTo(496.0f, 320.0f)
                lineTo(144.0f, 320.0f)
                lineTo(144.0f, 384.0f)
                lineTo(496.0f, 384.0f)
                lineTo(496.0f, 320.0f)
                close()
                moveTo(144.0f, 480.0f)
                lineTo(496.0f, 480.0f)
                lineTo(496.0f, 416.0f)
                lineTo(144.0f, 416.0f)
                lineTo(144.0f, 480.0f)
                close()
                moveTo(496.0f, 512.0f)
                lineTo(144.0f, 512.0f)
                lineTo(144.0f, 576.0f)
                lineTo(496.0f, 576.0f)
                lineTo(496.0f, 512.0f)
                close()
            }
        }
        .build()
        return _warehouse!!
    }

private var _warehouse: ImageVector? = null
