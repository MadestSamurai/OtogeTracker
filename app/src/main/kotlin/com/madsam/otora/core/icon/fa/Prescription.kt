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

public val Fa.Prescription: ImageVector
    get() {
        if (_prescription != null) {
            return _prescription!!
        }
        _prescription = Builder(name = "Prescription", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 64.0f)
                curveTo(110.3f, 64.0f, 96.0f, 78.3f, 96.0f, 96.0f)
                lineTo(96.0f, 352.0f)
                curveTo(96.0f, 369.7f, 110.3f, 384.0f, 128.0f, 384.0f)
                curveTo(145.7f, 384.0f, 160.0f, 369.7f, 160.0f, 352.0f)
                lineTo(160.0f, 288.0f)
                lineTo(210.7f, 288.0f)
                lineTo(338.7f, 416.0f)
                lineTo(233.3f, 521.4f)
                curveTo(220.8f, 533.9f, 220.8f, 554.2f, 233.3f, 566.7f)
                curveTo(245.8f, 579.2f, 266.1f, 579.2f, 278.6f, 566.7f)
                lineTo(384.0f, 461.3f)
                lineTo(489.4f, 566.6f)
                curveTo(501.9f, 579.1f, 522.2f, 579.1f, 534.7f, 566.6f)
                curveTo(547.2f, 554.1f, 547.2f, 533.8f, 534.7f, 521.3f)
                lineTo(429.3f, 416.0f)
                lineTo(534.6f, 310.6f)
                curveTo(547.1f, 298.1f, 547.1f, 277.8f, 534.6f, 265.3f)
                curveTo(522.1f, 252.8f, 501.8f, 252.8f, 489.3f, 265.3f)
                lineTo(384.0f, 370.7f)
                lineTo(298.2f, 284.9f)
                curveTo(347.4f, 273.1f, 384.0f, 228.8f, 384.0f, 176.0f)
                curveTo(384.0f, 114.1f, 333.9f, 64.0f, 272.0f, 64.0f)
                lineTo(128.0f, 64.0f)
                close()
                moveTo(272.0f, 224.0f)
                lineTo(160.0f, 224.0f)
                lineTo(160.0f, 128.0f)
                lineTo(272.0f, 128.0f)
                curveTo(298.5f, 128.0f, 320.0f, 149.5f, 320.0f, 176.0f)
                curveTo(320.0f, 202.5f, 298.5f, 224.0f, 272.0f, 224.0f)
                close()
            }
        }
        .build()
        return _prescription!!
    }

private var _prescription: ImageVector? = null
