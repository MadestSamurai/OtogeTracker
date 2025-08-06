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

public val Fa.`Location-pin-lock`: ImageVector
    get() {
        if (`_location-pin-lock` != null) {
            return `_location-pin-lock`!!
        }
        `_location-pin-lock` = Builder(name = "Location-pin-lock", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 252.6f)
                curveTo(64.0f, 148.4f, 150.0f, 64.0f, 256.0f, 64.0f)
                curveTo(358.1f, 64.0f, 441.6f, 142.3f, 447.6f, 241.0f)
                curveTo(384.7f, 249.1f, 336.0f, 302.8f, 336.0f, 368.0f)
                lineTo(336.0f, 392.4f)
                curveTo(316.4f, 410.0f, 304.0f, 435.5f, 304.0f, 463.9f)
                lineTo(304.0f, 539.6f)
                curveTo(294.1f, 551.2f, 285.1f, 561.3f, 277.6f, 569.4f)
                curveTo(265.8f, 582.2f, 246.1f, 582.2f, 234.3f, 569.4f)
                curveTo(184.1f, 514.9f, 63.9f, 371.9f, 63.9f, 252.6f)
                close()
                moveTo(256.0f, 320.0f)
                curveTo(291.3f, 320.0f, 320.0f, 291.3f, 320.0f, 256.0f)
                curveTo(320.0f, 220.7f, 291.3f, 192.0f, 256.0f, 192.0f)
                curveTo(220.7f, 192.0f, 192.0f, 220.7f, 192.0f, 256.0f)
                curveTo(192.0f, 291.3f, 220.7f, 320.0f, 256.0f, 320.0f)
                close()
                moveTo(496.0f, 368.1f)
                curveTo(496.0f, 350.4f, 481.7f, 336.1f, 464.0f, 336.1f)
                curveTo(446.3f, 336.1f, 432.0f, 350.4f, 432.0f, 368.1f)
                lineTo(432.0f, 416.0f)
                lineTo(496.0f, 416.0f)
                lineTo(496.0f, 368.1f)
                close()
                moveTo(352.0f, 464.0f)
                curveTo(352.0f, 443.1f, 365.4f, 425.3f, 384.0f, 418.7f)
                lineTo(384.0f, 368.1f)
                curveTo(384.0f, 323.9f, 419.8f, 288.1f, 464.0f, 288.1f)
                curveTo(508.2f, 288.1f, 544.0f, 323.9f, 544.0f, 368.1f)
                lineTo(544.0f, 418.7f)
                curveTo(562.6f, 425.3f, 576.0f, 443.1f, 576.0f, 464.0f)
                lineTo(576.0f, 560.0f)
                curveTo(576.0f, 586.5f, 554.5f, 608.0f, 528.0f, 608.0f)
                lineTo(400.0f, 608.0f)
                curveTo(373.5f, 608.0f, 352.0f, 586.5f, 352.0f, 560.0f)
                lineTo(352.0f, 464.0f)
                close()
            }
        }
        .build()
        return `_location-pin-lock`!!
    }

private var `_location-pin-lock`: ImageVector? = null
