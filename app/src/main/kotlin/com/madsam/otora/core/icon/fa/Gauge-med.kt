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

public val Fa.`Gauge-med`: ImageVector
    get() {
        if (`_gauge-med` != null) {
            return `_gauge-med`!!
        }
        `_gauge-med` = Builder(name = "Gauge-med", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
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
                moveTo(208.0f, 240.0f)
                curveTo(225.7f, 240.0f, 240.0f, 225.7f, 240.0f, 208.0f)
                curveTo(240.0f, 190.3f, 225.7f, 176.0f, 208.0f, 176.0f)
                curveTo(190.3f, 176.0f, 176.0f, 190.3f, 176.0f, 208.0f)
                curveTo(176.0f, 225.7f, 190.3f, 240.0f, 208.0f, 240.0f)
                close()
                moveTo(192.0f, 320.0f)
                curveTo(192.0f, 302.3f, 177.7f, 288.0f, 160.0f, 288.0f)
                curveTo(142.3f, 288.0f, 128.0f, 302.3f, 128.0f, 320.0f)
                curveTo(128.0f, 337.7f, 142.3f, 352.0f, 160.0f, 352.0f)
                curveTo(177.7f, 352.0f, 192.0f, 337.7f, 192.0f, 320.0f)
                close()
                moveTo(480.0f, 352.0f)
                curveTo(497.7f, 352.0f, 512.0f, 337.7f, 512.0f, 320.0f)
                curveTo(512.0f, 302.3f, 497.7f, 288.0f, 480.0f, 288.0f)
                curveTo(462.3f, 288.0f, 448.0f, 302.3f, 448.0f, 320.0f)
                curveTo(448.0f, 337.7f, 462.3f, 352.0f, 480.0f, 352.0f)
                close()
                moveTo(464.0f, 208.0f)
                curveTo(464.0f, 190.3f, 449.7f, 176.0f, 432.0f, 176.0f)
                curveTo(414.3f, 176.0f, 400.0f, 190.3f, 400.0f, 208.0f)
                curveTo(400.0f, 225.7f, 414.3f, 240.0f, 432.0f, 240.0f)
                curveTo(449.7f, 240.0f, 464.0f, 225.7f, 464.0f, 208.0f)
                close()
            }
        }
        .build()
        return `_gauge-med`!!
    }

private var `_gauge-med`: ImageVector? = null
