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

public val Fa.`Dice-d20`: ImageVector
    get() {
        if (`_dice-d20` != null) {
            return `_dice-d20`!!
        }
        `_dice-d20` = Builder(name = "Dice-d20", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.4f, 55.8f)
                curveTo(308.0f, 44.7f, 332.0f, 44.7f, 351.5f, 55.8f)
                lineTo(543.5f, 164.6f)
                curveTo(563.5f, 176.0f, 575.9f, 197.2f, 575.9f, 220.3f)
                lineTo(575.9f, 435.9f)
                curveTo(575.9f, 458.9f, 563.5f, 480.2f, 543.5f, 491.6f)
                lineTo(351.5f, 600.4f)
                curveTo(331.9f, 611.5f, 307.9f, 611.5f, 288.4f, 600.4f)
                lineTo(96.4f, 491.5f)
                curveTo(76.4f, 480.1f, 64.0f, 458.8f, 64.0f, 435.8f)
                lineTo(64.0f, 220.2f)
                curveTo(64.0f, 197.2f, 76.4f, 175.9f, 96.4f, 164.5f)
                lineTo(288.4f, 55.8f)
                close()
                moveTo(340.4f, 129.0f)
                curveTo(331.0f, 113.8f, 309.0f, 113.8f, 299.6f, 129.0f)
                lineTo(223.0f, 252.7f)
                lineTo(137.6f, 206.4f)
                lineTo(133.8f, 204.8f)
                curveTo(124.9f, 202.1f, 115.0f, 205.9f, 110.4f, 214.4f)
                curveTo(105.8f, 222.9f, 108.0f, 233.3f, 115.1f, 239.2f)
                lineTo(118.4f, 241.5f)
                lineTo(201.8f, 286.7f)
                lineTo(127.2f, 407.3f)
                curveTo(119.3f, 420.2f, 125.0f, 437.0f, 139.0f, 442.4f)
                lineTo(300.0f, 504.3f)
                lineTo(300.0f, 544.0f)
                curveTo(300.0f, 555.0f, 309.0f, 564.0f, 320.0f, 564.0f)
                curveTo(331.0f, 564.0f, 340.0f, 555.0f, 340.0f, 544.0f)
                lineTo(340.0f, 504.3f)
                lineTo(501.0f, 442.4f)
                curveTo(515.0f, 437.0f, 520.7f, 420.2f, 512.8f, 407.4f)
                lineTo(438.1f, 286.8f)
                lineTo(521.5f, 241.6f)
                curveTo(531.2f, 236.3f, 534.8f, 224.2f, 529.6f, 214.5f)
                curveTo(524.4f, 204.8f, 512.2f, 201.2f, 502.5f, 206.4f)
                lineTo(417.0f, 252.7f)
                lineTo(340.4f, 129.0f)
                close()
                moveTo(293.4f, 458.9f)
                lineTo(171.4f, 412.0f)
                lineTo(225.9f, 323.9f)
                lineTo(293.4f, 458.9f)
                close()
                moveTo(468.6f, 412.0f)
                lineTo(346.6f, 458.9f)
                lineTo(414.1f, 323.9f)
                lineTo(468.6f, 412.0f)
                close()
                moveTo(383.3f, 296.0f)
                lineTo(320.0f, 422.6f)
                lineTo(256.7f, 296.0f)
                lineTo(383.3f, 296.0f)
                close()
                moveTo(372.0f, 256.0f)
                lineTo(267.9f, 256.0f)
                lineTo(319.9f, 172.0f)
                lineTo(371.9f, 256.0f)
                close()
            }
        }
        .build()
        return `_dice-d20`!!
    }

private var `_dice-d20`: ImageVector? = null
