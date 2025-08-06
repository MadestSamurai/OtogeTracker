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

public val Fa.Helicopter: ImageVector
    get() {
        if (_helicopter != null) {
            return _helicopter!!
        }
        _helicopter = Builder(name = "Helicopter", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(208.0f, 96.0f)
                curveTo(194.7f, 96.0f, 184.0f, 106.7f, 184.0f, 120.0f)
                curveTo(184.0f, 133.3f, 194.7f, 144.0f, 208.0f, 144.0f)
                lineTo(360.0f, 144.0f)
                lineTo(360.0f, 192.0f)
                lineTo(139.2f, 192.0f)
                lineTo(106.4f, 152.6f)
                curveTo(101.9f, 147.2f, 95.1f, 144.0f, 88.0f, 144.0f)
                lineTo(56.0f, 144.0f)
                curveTo(47.7f, 144.0f, 40.0f, 148.3f, 35.6f, 155.4f)
                curveTo(31.2f, 162.5f, 30.8f, 171.3f, 34.5f, 178.8f)
                lineTo(82.5f, 274.8f)
                curveTo(86.6f, 282.9f, 94.9f, 288.0f, 104.0f, 288.0f)
                lineTo(211.8f, 288.0f)
                lineTo(315.8f, 431.1f)
                curveTo(330.9f, 451.8f, 354.9f, 464.0f, 380.5f, 464.0f)
                lineTo(456.0f, 464.0f)
                curveTo(531.1f, 464.0f, 592.0f, 403.1f, 592.0f, 328.0f)
                curveTo(592.0f, 252.9f, 531.1f, 192.0f, 456.0f, 192.0f)
                lineTo(408.0f, 192.0f)
                lineTo(408.0f, 144.0f)
                lineTo(560.0f, 144.0f)
                curveTo(573.3f, 144.0f, 584.0f, 133.3f, 584.0f, 120.0f)
                curveTo(584.0f, 106.7f, 573.3f, 96.0f, 560.0f, 96.0f)
                lineTo(208.0f, 96.0f)
                close()
                moveTo(408.0f, 256.0f)
                lineTo(456.0f, 256.0f)
                curveTo(495.8f, 256.0f, 528.0f, 288.2f, 528.0f, 328.0f)
                curveTo(528.0f, 367.8f, 495.8f, 400.0f, 456.0f, 400.0f)
                lineTo(408.0f, 400.0f)
                lineTo(408.0f, 256.0f)
                close()
                moveTo(584.0f, 480.0f)
                curveTo(570.7f, 480.0f, 560.0f, 490.7f, 560.0f, 504.0f)
                curveTo(560.0f, 508.4f, 556.4f, 512.0f, 552.0f, 512.0f)
                lineTo(280.0f, 512.0f)
                curveTo(266.7f, 512.0f, 256.0f, 522.7f, 256.0f, 536.0f)
                curveTo(256.0f, 549.3f, 266.7f, 560.0f, 280.0f, 560.0f)
                lineTo(552.0f, 560.0f)
                curveTo(582.9f, 560.0f, 608.0f, 534.9f, 608.0f, 504.0f)
                curveTo(608.0f, 490.7f, 597.3f, 480.0f, 584.0f, 480.0f)
                close()
            }
        }
        .build()
        return _helicopter!!
    }

private var _helicopter: ImageVector? = null
