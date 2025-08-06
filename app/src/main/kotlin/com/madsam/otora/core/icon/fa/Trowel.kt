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

public val Fa.Trowel: ImageVector
    get() {
        if (_trowel != null) {
            return _trowel!!
        }
        _trowel = Builder(name = "Trowel", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(439.9f, 245.4f)
                lineTo(309.3f, 376.0f)
                lineTo(374.6f, 441.4f)
                curveTo(382.5f, 449.3f, 385.7f, 460.8f, 383.0f, 471.7f)
                curveTo(380.3f, 482.6f, 372.2f, 491.3f, 361.5f, 494.6f)
                lineTo(105.5f, 574.6f)
                curveTo(94.1f, 578.1f, 81.7f, 575.1f, 73.3f, 566.7f)
                curveTo(64.9f, 558.3f, 61.8f, 545.9f, 65.4f, 534.5f)
                lineTo(145.4f, 278.5f)
                curveTo(148.7f, 267.8f, 157.4f, 259.6f, 168.3f, 257.0f)
                curveTo(179.2f, 254.4f, 190.7f, 257.5f, 198.6f, 265.4f)
                lineTo(264.0f, 330.7f)
                lineTo(394.6f, 200.1f)
                curveTo(380.3f, 185.5f, 380.4f, 162.1f, 394.9f, 147.6f)
                lineTo(490.3f, 52.2f)
                curveTo(517.2f, 25.3f, 560.8f, 25.3f, 587.8f, 52.2f)
                curveTo(614.8f, 79.1f, 614.7f, 122.7f, 587.8f, 149.7f)
                lineTo(492.4f, 245.1f)
                curveTo(477.9f, 259.6f, 454.5f, 259.7f, 439.9f, 245.4f)
                close()
            }
        }
        .build()
        return _trowel!!
    }

private var _trowel: ImageVector? = null
