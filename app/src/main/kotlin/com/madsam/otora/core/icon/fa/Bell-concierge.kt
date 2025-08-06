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

public val Fa.`Bell-concierge`: ImageVector
    get() {
        if (`_bell-concierge` != null) {
            return `_bell-concierge`!!
        }
        `_bell-concierge` = Builder(name = "Bell-concierge", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(280.0f, 128.0f)
                curveTo(266.7f, 128.0f, 256.0f, 138.7f, 256.0f, 152.0f)
                curveTo(256.0f, 165.3f, 266.7f, 176.0f, 280.0f, 176.0f)
                lineTo(296.0f, 176.0f)
                lineTo(296.0f, 209.3f)
                curveTo(188.8f, 220.7f, 104.2f, 307.7f, 96.6f, 416.0f)
                lineTo(543.5f, 416.0f)
                curveTo(535.8f, 307.7f, 451.2f, 220.7f, 344.0f, 209.3f)
                lineTo(344.0f, 176.0f)
                lineTo(360.0f, 176.0f)
                curveTo(373.3f, 176.0f, 384.0f, 165.3f, 384.0f, 152.0f)
                curveTo(384.0f, 138.7f, 373.3f, 128.0f, 360.0f, 128.0f)
                lineTo(280.0f, 128.0f)
                close()
                moveTo(88.0f, 464.0f)
                curveTo(74.7f, 464.0f, 64.0f, 474.7f, 64.0f, 488.0f)
                curveTo(64.0f, 501.3f, 74.7f, 512.0f, 88.0f, 512.0f)
                lineTo(552.0f, 512.0f)
                curveTo(565.3f, 512.0f, 576.0f, 501.3f, 576.0f, 488.0f)
                curveTo(576.0f, 474.7f, 565.3f, 464.0f, 552.0f, 464.0f)
                lineTo(88.0f, 464.0f)
                close()
            }
        }
        .build()
        return `_bell-concierge`!!
    }

private var `_bell-concierge`: ImageVector? = null
