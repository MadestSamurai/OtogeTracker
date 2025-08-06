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

public val Fa.K: ImageVector
    get() {
        if (_k != null) {
            return _k!!
        }
        _k = Builder(name = "K", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(471.0f, 150.3f)
                curveTo(483.3f, 137.6f, 483.0f, 117.4f, 470.3f, 105.1f)
                curveTo(457.6f, 92.8f, 437.4f, 93.1f, 425.1f, 105.8f)
                curveTo(303.4f, 231.2f, 236.4f, 300.3f, 224.0f, 313.0f)
                lineTo(224.0f, 128.0f)
                curveTo(224.0f, 110.3f, 209.7f, 96.0f, 192.0f, 96.0f)
                curveTo(174.3f, 96.0f, 160.0f, 110.3f, 160.0f, 128.0f)
                lineTo(160.0f, 512.0f)
                curveTo(160.0f, 529.7f, 174.3f, 544.0f, 192.0f, 544.0f)
                curveTo(209.7f, 544.0f, 224.0f, 529.7f, 224.0f, 512.0f)
                lineTo(224.0f, 405.0f)
                lineTo(288.7f, 338.3f)
                lineTo(421.7f, 530.3f)
                curveTo(431.8f, 544.8f, 451.7f, 548.4f, 466.2f, 538.4f)
                curveTo(480.7f, 528.4f, 484.3f, 508.4f, 474.3f, 493.9f)
                lineTo(334.1f, 291.4f)
                lineTo(471.0f, 150.3f)
                close()
            }
        }
        .build()
        return _k!!
    }

private var _k: ImageVector? = null
