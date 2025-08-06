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

public val Fa.`Car-tunnel`: ImageVector
    get() {
        if (`_car-tunnel` != null) {
            return `_car-tunnel`!!
        }
        `_car-tunnel` = Builder(name = "Car-tunnel", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                lineTo(64.0f, 512.0f)
                curveTo(64.0f, 547.3f, 92.7f, 576.0f, 128.0f, 576.0f)
                lineTo(170.8f, 576.0f)
                curveTo(164.2f, 570.1f, 160.0f, 561.6f, 160.0f, 552.0f)
                lineTo(160.0f, 438.9f)
                curveTo(160.0f, 425.4f, 163.1f, 412.1f, 169.0f, 400.0f)
                lineTo(208.7f, 319.2f)
                curveTo(218.1f, 300.1f, 237.6f, 287.9f, 258.9f, 287.9f)
                lineTo(381.0f, 288.0f)
                curveTo(402.3f, 288.0f, 421.8f, 300.1f, 431.2f, 319.3f)
                lineTo(471.0f, 400.0f)
                curveTo(476.9f, 412.1f, 480.0f, 425.4f, 480.0f, 438.9f)
                lineTo(480.0f, 552.0f)
                curveTo(480.0f, 561.6f, 475.8f, 570.1f, 469.2f, 576.0f)
                lineTo(512.0f, 576.0f)
                curveTo(547.3f, 576.0f, 576.0f, 547.3f, 576.0f, 512.0f)
                lineTo(576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(426.8f, 576.0f)
                curveTo(420.2f, 570.1f, 416.0f, 561.6f, 416.0f, 552.0f)
                lineTo(416.0f, 528.0f)
                lineTo(224.0f, 528.0f)
                lineTo(224.0f, 552.0f)
                curveTo(224.0f, 561.6f, 219.8f, 570.1f, 213.2f, 576.0f)
                lineTo(426.9f, 576.0f)
                close()
                moveTo(251.8f, 340.5f)
                lineTo(222.5f, 400.0f)
                lineTo(417.4f, 400.0f)
                lineTo(388.1f, 340.5f)
                curveTo(386.8f, 337.8f, 384.0f, 336.0f, 380.9f, 336.0f)
                lineTo(259.0f, 336.0f)
                curveTo(256.0f, 336.0f, 253.2f, 337.7f, 251.8f, 340.5f)
                close()
                moveTo(240.0f, 488.0f)
                curveTo(253.3f, 488.0f, 264.0f, 477.3f, 264.0f, 464.0f)
                curveTo(264.0f, 450.7f, 253.3f, 440.0f, 240.0f, 440.0f)
                curveTo(226.7f, 440.0f, 216.0f, 450.7f, 216.0f, 464.0f)
                curveTo(216.0f, 477.3f, 226.7f, 488.0f, 240.0f, 488.0f)
                close()
                moveTo(424.0f, 464.0f)
                curveTo(424.0f, 450.7f, 413.3f, 440.0f, 400.0f, 440.0f)
                curveTo(386.7f, 440.0f, 376.0f, 450.7f, 376.0f, 464.0f)
                curveTo(376.0f, 477.3f, 386.7f, 488.0f, 400.0f, 488.0f)
                curveTo(413.3f, 488.0f, 424.0f, 477.3f, 424.0f, 464.0f)
                close()
            }
        }
        .build()
        return `_car-tunnel`!!
    }

private var `_car-tunnel`: ImageVector? = null
