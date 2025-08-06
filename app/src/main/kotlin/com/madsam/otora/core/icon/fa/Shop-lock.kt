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

public val Fa.`Shop-lock`: ImageVector
    get() {
        if (`_shop-lock` != null) {
            return `_shop-lock`!!
        }
        `_shop-lock` = Builder(name = "Shop-lock", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(21.5f, 245.1f)
                lineTo(78.3f, 131.4f)
                curveTo(89.2f, 109.7f, 111.3f, 96.0f, 135.6f, 96.0f)
                lineTo(440.5f, 96.0f)
                curveTo(464.7f, 96.0f, 486.9f, 109.7f, 497.7f, 131.4f)
                lineTo(553.3f, 242.5f)
                curveTo(545.1f, 240.9f, 536.7f, 240.0f, 528.1f, 240.0f)
                curveTo(474.4f, 240.0f, 428.4f, 273.1f, 409.4f, 320.0f)
                lineTo(352.1f, 320.0f)
                lineTo(352.1f, 496.0f)
                curveTo(352.1f, 522.5f, 330.6f, 544.0f, 304.1f, 544.0f)
                lineTo(112.1f, 544.0f)
                curveTo(85.6f, 544.0f, 64.1f, 522.5f, 64.1f, 496.0f)
                lineTo(64.1f, 319.9f)
                curveTo(37.3f, 318.0f, 16.1f, 295.6f, 16.1f, 268.3f)
                curveTo(16.1f, 260.3f, 18.0f, 252.3f, 21.6f, 245.1f)
                close()
                moveTo(128.0f, 320.0f)
                lineTo(128.0f, 432.0f)
                curveTo(128.0f, 440.8f, 135.2f, 448.0f, 144.0f, 448.0f)
                lineTo(272.0f, 448.0f)
                curveTo(280.8f, 448.0f, 288.0f, 440.8f, 288.0f, 432.0f)
                lineTo(288.0f, 320.0f)
                lineTo(128.0f, 320.0f)
                close()
                moveTo(560.0f, 368.1f)
                curveTo(560.0f, 350.4f, 545.7f, 336.1f, 528.0f, 336.1f)
                curveTo(510.3f, 336.1f, 496.0f, 350.4f, 496.0f, 368.1f)
                lineTo(496.0f, 416.0f)
                lineTo(560.0f, 416.0f)
                lineTo(560.0f, 368.1f)
                close()
                moveTo(416.0f, 464.0f)
                curveTo(416.0f, 443.1f, 429.4f, 425.3f, 448.0f, 418.7f)
                lineTo(448.0f, 368.1f)
                curveTo(448.0f, 323.9f, 483.8f, 288.1f, 528.0f, 288.1f)
                curveTo(572.2f, 288.1f, 608.0f, 323.9f, 608.0f, 368.1f)
                lineTo(608.0f, 418.7f)
                curveTo(626.6f, 425.3f, 640.0f, 443.1f, 640.0f, 464.0f)
                lineTo(640.0f, 560.0f)
                curveTo(640.0f, 586.5f, 618.5f, 608.0f, 592.0f, 608.0f)
                lineTo(464.0f, 608.0f)
                curveTo(437.5f, 608.0f, 416.0f, 586.5f, 416.0f, 560.0f)
                lineTo(416.0f, 464.0f)
                close()
            }
        }
        .build()
        return `_shop-lock`!!
    }

private var `_shop-lock`: ImageVector? = null
