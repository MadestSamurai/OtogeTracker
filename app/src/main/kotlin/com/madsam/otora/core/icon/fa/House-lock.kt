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

public val Fa.`House-lock`: ImageVector
    get() {
        if (`_house-lock` != null) {
            return `_house-lock`!!
        }
        `_house-lock` = Builder(name = "House-lock", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(528.0f, 288.1f)
                curveTo(572.2f, 288.1f, 608.0f, 323.9f, 608.0f, 368.1f)
                lineTo(608.0f, 418.7f)
                curveTo(626.6f, 425.3f, 640.0f, 443.1f, 640.0f, 464.0f)
                lineTo(640.0f, 560.0f)
                curveTo(640.0f, 586.5f, 618.5f, 608.0f, 592.0f, 608.0f)
                lineTo(464.0f, 608.0f)
                curveTo(437.5f, 608.0f, 416.0f, 586.5f, 416.0f, 560.0f)
                lineTo(416.0f, 464.0f)
                curveTo(416.0f, 443.1f, 429.4f, 425.3f, 448.0f, 418.7f)
                lineTo(448.0f, 368.1f)
                curveTo(448.0f, 323.9f, 483.8f, 288.1f, 528.0f, 288.1f)
                close()
                moveTo(268.6f, 70.5f)
                curveTo(280.8f, 61.2f, 298.3f, 61.8f, 309.8f, 72.5f)
                lineTo(494.8f, 244.3f)
                curveTo(440.2f, 259.0f, 400.0f, 308.8f, 400.0f, 368.0f)
                lineTo(400.0f, 392.4f)
                curveTo(380.4f, 410.0f, 368.0f, 435.5f, 368.0f, 463.9f)
                lineTo(368.0f, 559.9f)
                curveTo(368.0f, 565.4f, 368.5f, 570.8f, 369.3f, 576.0f)
                lineTo(144.0f, 576.0f)
                curveTo(108.7f, 576.0f, 80.0f, 547.3f, 80.0f, 512.0f)
                lineTo(80.0f, 336.0f)
                lineTo(64.0f, 336.0f)
                curveTo(50.8f, 336.0f, 39.0f, 327.9f, 34.2f, 315.7f)
                curveTo(29.4f, 303.5f, 32.6f, 289.5f, 42.2f, 280.6f)
                lineTo(266.2f, 72.6f)
                lineTo(268.6f, 70.6f)
                close()
                moveTo(272.0f, 384.0f)
                curveTo(245.5f, 384.0f, 224.0f, 405.5f, 224.0f, 432.0f)
                lineTo(224.0f, 528.0f)
                lineTo(320.0f, 528.0f)
                lineTo(320.0f, 440.7f)
                curveTo(320.0f, 424.2f, 327.0f, 409.2f, 338.4f, 398.6f)
                curveTo(329.7f, 389.6f, 317.5f, 384.0f, 304.0f, 384.0f)
                lineTo(272.0f, 384.0f)
                close()
                moveTo(528.0f, 336.1f)
                curveTo(510.3f, 336.1f, 496.0f, 350.4f, 496.0f, 368.1f)
                lineTo(496.0f, 416.0f)
                lineTo(560.0f, 416.0f)
                lineTo(560.0f, 368.1f)
                curveTo(560.0f, 350.4f, 545.7f, 336.1f, 528.0f, 336.1f)
                close()
            }
        }
        .build()
        return `_house-lock`!!
    }

private var `_house-lock`: ImageVector? = null
