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

public val Fa.`Pump-soap`: ImageVector
    get() {
        if (`_pump-soap` != null) {
            return `_pump-soap`!!
        }
        `_pump-soap` = Builder(name = "Pump-soap", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 64.0f)
                lineTo(256.0f, 144.0f)
                lineTo(384.0f, 144.0f)
                lineTo(384.0f, 120.0f)
                lineTo(456.0f, 120.0f)
                curveTo(469.3f, 120.0f, 480.0f, 109.3f, 480.0f, 96.0f)
                curveTo(480.0f, 82.7f, 469.3f, 72.0f, 456.0f, 72.0f)
                lineTo(384.0f, 72.0f)
                lineTo(384.0f, 64.0f)
                curveTo(384.0f, 46.3f, 369.7f, 32.0f, 352.0f, 32.0f)
                lineTo(288.0f, 32.0f)
                curveTo(270.3f, 32.0f, 256.0f, 46.3f, 256.0f, 64.0f)
                close()
                moveTo(224.0f, 192.0f)
                curveTo(188.7f, 192.0f, 160.0f, 220.7f, 160.0f, 256.0f)
                lineTo(160.0f, 512.0f)
                curveTo(160.0f, 547.3f, 188.7f, 576.0f, 224.0f, 576.0f)
                lineTo(416.0f, 576.0f)
                curveTo(451.3f, 576.0f, 480.0f, 547.3f, 480.0f, 512.0f)
                lineTo(480.0f, 256.0f)
                curveTo(480.0f, 220.7f, 451.3f, 192.0f, 416.0f, 192.0f)
                lineTo(224.0f, 192.0f)
                close()
                moveTo(384.0f, 408.0f)
                curveTo(384.0f, 443.3f, 355.3f, 464.0f, 320.0f, 464.0f)
                curveTo(284.7f, 464.0f, 256.0f, 443.3f, 256.0f, 408.0f)
                curveTo(256.0f, 375.5f, 293.0f, 327.1f, 306.9f, 310.1f)
                curveTo(310.1f, 306.2f, 315.0f, 304.0f, 320.0f, 304.0f)
                curveTo(325.0f, 304.0f, 329.9f, 306.2f, 333.1f, 310.1f)
                curveTo(347.0f, 327.1f, 384.0f, 375.5f, 384.0f, 408.0f)
                close()
            }
        }
        .build()
        return `_pump-soap`!!
    }

private var `_pump-soap`: ImageVector? = null
