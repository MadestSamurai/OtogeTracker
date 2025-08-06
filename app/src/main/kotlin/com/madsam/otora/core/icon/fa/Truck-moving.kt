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

public val Fa.`Truck-moving`: ImageVector
    get() {
        if (`_truck-moving` != null) {
            return `_truck-moving`!!
        }
        `_truck-moving` = Builder(name = "Truck-moving", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 96.0f)
                curveTo(28.7f, 96.0f, 0.0f, 124.7f, 0.0f, 160.0f)
                lineTo(0.0f, 488.0f)
                curveTo(0.0f, 536.6f, 39.4f, 576.0f, 88.0f, 576.0f)
                curveTo(113.2f, 576.0f, 136.0f, 565.4f, 152.0f, 548.4f)
                curveTo(168.0f, 565.4f, 190.8f, 576.0f, 216.0f, 576.0f)
                curveTo(256.3f, 576.0f, 290.2f, 548.9f, 300.7f, 512.0f)
                lineTo(435.3f, 512.0f)
                curveTo(445.7f, 548.9f, 479.7f, 576.0f, 520.0f, 576.0f)
                curveTo(563.0f, 576.0f, 598.9f, 545.1f, 606.5f, 504.3f)
                curveTo(626.5f, 493.5f, 640.0f, 472.3f, 640.0f, 448.0f)
                lineTo(640.0f, 301.3f)
                curveTo(640.0f, 284.3f, 633.3f, 268.0f, 621.3f, 256.0f)
                lineTo(576.0f, 210.7f)
                curveTo(564.0f, 198.7f, 547.7f, 192.0f, 530.7f, 192.0f)
                lineTo(480.0f, 192.0f)
                lineTo(480.0f, 160.0f)
                curveTo(480.0f, 124.7f, 451.3f, 96.0f, 416.0f, 96.0f)
                lineTo(64.0f, 96.0f)
                close()
                moveTo(480.0f, 256.0f)
                lineTo(530.7f, 256.0f)
                lineTo(576.0f, 301.3f)
                lineTo(576.0f, 352.0f)
                lineTo(480.0f, 352.0f)
                lineTo(480.0f, 256.0f)
                close()
                moveTo(88.0f, 448.0f)
                curveTo(110.1f, 448.0f, 128.0f, 465.9f, 128.0f, 488.0f)
                curveTo(128.0f, 510.1f, 110.1f, 528.0f, 88.0f, 528.0f)
                curveTo(65.9f, 528.0f, 48.0f, 510.1f, 48.0f, 488.0f)
                curveTo(48.0f, 465.9f, 65.9f, 448.0f, 88.0f, 448.0f)
                close()
                moveTo(480.0f, 488.0f)
                curveTo(480.0f, 465.9f, 497.9f, 448.0f, 520.0f, 448.0f)
                curveTo(542.1f, 448.0f, 560.0f, 465.9f, 560.0f, 488.0f)
                curveTo(560.0f, 510.1f, 542.1f, 528.0f, 520.0f, 528.0f)
                curveTo(497.9f, 528.0f, 480.0f, 510.1f, 480.0f, 488.0f)
                close()
                moveTo(216.0f, 448.0f)
                curveTo(238.1f, 448.0f, 256.0f, 465.9f, 256.0f, 488.0f)
                curveTo(256.0f, 510.1f, 238.1f, 528.0f, 216.0f, 528.0f)
                curveTo(193.9f, 528.0f, 176.0f, 510.1f, 176.0f, 488.0f)
                curveTo(176.0f, 465.9f, 193.9f, 448.0f, 216.0f, 448.0f)
                close()
            }
        }
        .build()
        return `_truck-moving`!!
    }

private var `_truck-moving`: ImageVector? = null
