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

public val Fa.Wrench: ImageVector
    get() {
        if (_wrench != null) {
            return _wrench!!
        }
        _wrench = Builder(name = "Wrench", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(541.4f, 162.6f)
                curveTo(549.0f, 155.0f, 561.7f, 156.9f, 565.5f, 166.9f)
                curveTo(572.3f, 184.6f, 576.0f, 203.9f, 576.0f, 224.0f)
                curveTo(576.0f, 312.4f, 504.4f, 384.0f, 416.0f, 384.0f)
                curveTo(398.5f, 384.0f, 381.6f, 381.2f, 365.8f, 376.0f)
                lineTo(178.9f, 562.9f)
                curveTo(150.8f, 591.0f, 105.2f, 591.0f, 77.1f, 562.9f)
                curveTo(49.0f, 534.8f, 49.0f, 489.2f, 77.1f, 461.1f)
                lineTo(264.0f, 274.2f)
                curveTo(258.8f, 258.4f, 256.0f, 241.6f, 256.0f, 224.0f)
                curveTo(256.0f, 135.6f, 327.6f, 64.0f, 416.0f, 64.0f)
                curveTo(436.1f, 64.0f, 455.4f, 67.7f, 473.1f, 74.5f)
                curveTo(483.1f, 78.3f, 484.9f, 91.0f, 477.4f, 98.6f)
                lineTo(388.7f, 187.3f)
                curveTo(385.7f, 190.3f, 384.0f, 194.4f, 384.0f, 198.6f)
                lineTo(384.0f, 240.0f)
                curveTo(384.0f, 248.8f, 391.2f, 256.0f, 400.0f, 256.0f)
                lineTo(441.4f, 256.0f)
                curveTo(445.6f, 256.0f, 449.7f, 254.3f, 452.7f, 251.3f)
                lineTo(541.4f, 162.6f)
                close()
            }
        }
        .build()
        return _wrench!!
    }

private var _wrench: ImageVector? = null
