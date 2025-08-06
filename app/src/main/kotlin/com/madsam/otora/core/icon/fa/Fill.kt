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

public val Fa.Fill: ImageVector
    get() {
        if (_fill != null) {
            return _fill!!
        }
        _fill = Builder(name = "Fill", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(360.0f, 128.0f)
                curveTo(366.9f, 128.0f, 373.5f, 130.7f, 378.3f, 135.6f)
                lineTo(504.4f, 261.7f)
                curveTo(509.3f, 266.6f, 512.0f, 273.2f, 512.0f, 280.0f)
                curveTo(512.0f, 286.8f, 509.3f, 293.5f, 504.4f, 298.3f)
                lineTo(450.7f, 352.0f)
                lineTo(129.3f, 352.0f)
                curveTo(130.6f, 348.1f, 132.7f, 344.6f, 135.6f, 341.7f)
                lineTo(232.0f, 245.3f)
                lineTo(265.4f, 278.7f)
                curveTo(277.9f, 291.2f, 298.2f, 291.2f, 310.7f, 278.7f)
                curveTo(323.2f, 266.2f, 323.2f, 245.9f, 310.7f, 233.4f)
                lineTo(277.3f, 200.0f)
                lineTo(341.7f, 135.6f)
                curveTo(346.6f, 130.7f, 353.2f, 128.0f, 360.0f, 128.0f)
                close()
                moveTo(186.7f, 200.0f)
                lineTo(90.3f, 296.4f)
                curveTo(73.5f, 313.3f, 64.0f, 336.1f, 64.0f, 360.0f)
                curveTo(64.0f, 383.9f, 73.5f, 406.7f, 90.3f, 423.6f)
                lineTo(216.4f, 549.7f)
                curveTo(233.3f, 566.5f, 256.1f, 576.0f, 280.0f, 576.0f)
                curveTo(303.9f, 576.0f, 326.7f, 566.5f, 343.6f, 549.7f)
                lineTo(549.7f, 343.6f)
                curveTo(566.5f, 326.7f, 576.0f, 303.9f, 576.0f, 280.0f)
                curveTo(576.0f, 256.1f, 566.5f, 233.3f, 549.7f, 216.4f)
                lineTo(423.6f, 90.3f)
                curveTo(406.7f, 73.5f, 383.9f, 64.0f, 360.0f, 64.0f)
                curveTo(336.1f, 64.0f, 313.3f, 73.5f, 296.4f, 90.3f)
                lineTo(232.0f, 154.7f)
                lineTo(182.6f, 105.4f)
                curveTo(170.1f, 92.9f, 149.8f, 92.9f, 137.3f, 105.4f)
                curveTo(124.8f, 117.9f, 124.8f, 138.2f, 137.3f, 150.7f)
                lineTo(186.7f, 200.0f)
                close()
            }
        }
        .build()
        return _fill!!
    }

private var _fill: ImageVector? = null
