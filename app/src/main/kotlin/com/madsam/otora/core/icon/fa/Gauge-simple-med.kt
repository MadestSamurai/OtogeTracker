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

public val Fa.`Gauge-simple-med`: ImageVector
    get() {
        if (`_gauge-simple-med` != null) {
            return `_gauge-simple-med`!!
        }
        `_gauge-simple-med` = Builder(name = "Gauge-simple-med", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
                moveTo(384.0f, 416.0f)
                curveTo(384.0f, 389.1f, 367.5f, 366.1f, 344.0f, 356.7f)
                lineTo(344.0f, 184.0f)
                curveTo(344.0f, 170.7f, 333.3f, 160.0f, 320.0f, 160.0f)
                curveTo(306.7f, 160.0f, 296.0f, 170.7f, 296.0f, 184.0f)
                lineTo(296.0f, 356.7f)
                curveTo(272.5f, 366.2f, 256.0f, 389.2f, 256.0f, 416.0f)
                curveTo(256.0f, 451.3f, 284.7f, 480.0f, 320.0f, 480.0f)
                curveTo(355.3f, 480.0f, 384.0f, 451.3f, 384.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_gauge-simple-med`!!
    }

private var `_gauge-simple-med`: ImageVector? = null
