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

public val Fa.`Van-shuttle`: ImageVector
    get() {
        if (`_van-shuttle` != null) {
            return `_van-shuttle`!!
        }
        `_van-shuttle` = Builder(name = "Van-shuttle", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 128.0f)
                curveTo(60.7f, 128.0f, 32.0f, 156.7f, 32.0f, 192.0f)
                lineTo(32.0f, 400.0f)
                curveTo(32.0f, 435.3f, 60.7f, 464.0f, 96.0f, 464.0f)
                lineTo(96.4f, 464.0f)
                curveTo(100.4f, 508.9f, 138.1f, 544.0f, 184.0f, 544.0f)
                curveTo(229.9f, 544.0f, 267.6f, 508.9f, 271.6f, 464.0f)
                lineTo(376.3f, 464.0f)
                curveTo(380.3f, 508.9f, 418.0f, 544.0f, 463.9f, 544.0f)
                curveTo(510.0f, 544.0f, 547.8f, 508.6f, 551.6f, 463.5f)
                curveTo(583.3f, 459.7f, 607.9f, 432.7f, 607.9f, 400.0f)
                lineTo(607.9f, 298.7f)
                curveTo(607.9f, 284.9f, 603.4f, 271.4f, 595.1f, 260.3f)
                lineTo(515.1f, 153.6f)
                curveTo(503.1f, 137.5f, 484.1f, 128.0f, 464.0f, 128.0f)
                lineTo(96.0f, 128.0f)
                close()
                moveTo(536.0f, 288.0f)
                lineTo(416.0f, 288.0f)
                lineTo(416.0f, 192.0f)
                lineTo(464.0f, 192.0f)
                lineTo(536.0f, 288.0f)
                close()
                moveTo(96.0f, 288.0f)
                lineTo(96.0f, 192.0f)
                lineTo(192.0f, 192.0f)
                lineTo(192.0f, 288.0f)
                lineTo(96.0f, 288.0f)
                close()
                moveTo(256.0f, 288.0f)
                lineTo(256.0f, 192.0f)
                lineTo(352.0f, 192.0f)
                lineTo(352.0f, 288.0f)
                lineTo(256.0f, 288.0f)
                close()
                moveTo(424.0f, 456.0f)
                curveTo(424.0f, 433.9f, 441.9f, 416.0f, 464.0f, 416.0f)
                curveTo(486.1f, 416.0f, 504.0f, 433.9f, 504.0f, 456.0f)
                curveTo(504.0f, 478.1f, 486.1f, 496.0f, 464.0f, 496.0f)
                curveTo(441.9f, 496.0f, 424.0f, 478.1f, 424.0f, 456.0f)
                close()
                moveTo(184.0f, 416.0f)
                curveTo(206.1f, 416.0f, 224.0f, 433.9f, 224.0f, 456.0f)
                curveTo(224.0f, 478.1f, 206.1f, 496.0f, 184.0f, 496.0f)
                curveTo(161.9f, 496.0f, 144.0f, 478.1f, 144.0f, 456.0f)
                curveTo(144.0f, 433.9f, 161.9f, 416.0f, 184.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_van-shuttle`!!
    }

private var `_van-shuttle`: ImageVector? = null
