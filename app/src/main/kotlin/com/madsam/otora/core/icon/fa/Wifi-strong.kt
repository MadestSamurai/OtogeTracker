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

public val Fa.`Wifi-strong`: ImageVector
    get() {
        if (`_wifi-strong` != null) {
            return `_wifi-strong`!!
        }
        `_wifi-strong` = Builder(name = "Wifi-strong", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 160.0f)
                curveTo(229.1f, 160.0f, 146.8f, 196.0f, 86.3f, 254.6f)
                curveTo(73.6f, 266.9f, 53.3f, 266.6f, 41.1f, 253.9f)
                curveTo(28.9f, 241.2f, 29.1f, 220.9f, 41.8f, 208.7f)
                curveTo(113.7f, 138.9f, 211.9f, 96.0f, 320.0f, 96.0f)
                curveTo(428.1f, 96.0f, 526.3f, 138.9f, 598.3f, 208.7f)
                curveTo(611.0f, 221.0f, 611.3f, 241.3f, 599.0f, 253.9f)
                curveTo(586.7f, 266.5f, 566.4f, 266.9f, 553.8f, 254.6f)
                curveTo(493.2f, 196.0f, 410.9f, 160.0f, 320.0f, 160.0f)
                close()
                moveTo(272.0f, 496.0f)
                curveTo(272.0f, 469.5f, 293.5f, 448.0f, 320.0f, 448.0f)
                curveTo(346.5f, 448.0f, 368.0f, 469.5f, 368.0f, 496.0f)
                curveTo(368.0f, 522.5f, 346.5f, 544.0f, 320.0f, 544.0f)
                curveTo(293.5f, 544.0f, 272.0f, 522.5f, 272.0f, 496.0f)
                close()
                moveTo(200.0f, 390.2f)
                curveTo(188.3f, 403.5f, 168.1f, 404.7f, 154.8f, 393.0f)
                curveTo(141.5f, 381.3f, 140.3f, 361.1f, 152.0f, 347.8f)
                curveTo(193.0f, 301.4f, 253.1f, 272.0f, 320.0f, 272.0f)
                curveTo(386.9f, 272.0f, 447.0f, 301.4f, 488.0f, 347.8f)
                curveTo(499.7f, 361.1f, 498.4f, 381.3f, 485.2f, 393.0f)
                curveTo(472.0f, 404.7f, 451.7f, 403.4f, 440.0f, 390.2f)
                curveTo(410.6f, 356.9f, 367.8f, 336.0f, 320.0f, 336.0f)
                curveTo(272.2f, 336.0f, 229.4f, 356.9f, 200.0f, 390.2f)
                close()
            }
        }
        .build()
        return `_wifi-strong`!!
    }

private var `_wifi-strong`: ImageVector? = null
