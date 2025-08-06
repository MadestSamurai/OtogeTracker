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

public val Fa.`Naira-sign`: ImageVector
    get() {
        if (`_naira-sign` != null) {
            return `_naira-sign`!!
        }
        `_naira-sign` = Builder(name = "Naira-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(218.6f, 110.3f)
                curveTo(210.8f, 98.6f, 196.2f, 93.3f, 182.7f, 97.4f)
                curveTo(169.2f, 101.5f, 160.0f, 113.9f, 160.0f, 128.0f)
                lineTo(160.0f, 320.0f)
                lineTo(128.0f, 320.0f)
                curveTo(114.7f, 320.0f, 104.0f, 330.7f, 104.0f, 344.0f)
                curveTo(104.0f, 357.3f, 114.7f, 368.0f, 128.0f, 368.0f)
                lineTo(160.0f, 368.0f)
                lineTo(160.0f, 512.0f)
                curveTo(160.0f, 529.7f, 174.3f, 544.0f, 192.0f, 544.0f)
                curveTo(209.7f, 544.0f, 224.0f, 529.7f, 224.0f, 512.0f)
                lineTo(224.0f, 368.0f)
                lineTo(313.5f, 368.0f)
                lineTo(421.3f, 529.8f)
                curveTo(429.1f, 541.5f, 443.7f, 546.8f, 457.2f, 542.7f)
                curveTo(470.7f, 538.6f, 480.0f, 526.1f, 480.0f, 512.0f)
                lineTo(480.0f, 368.0f)
                lineTo(512.0f, 368.0f)
                curveTo(525.3f, 368.0f, 536.0f, 357.3f, 536.0f, 344.0f)
                curveTo(536.0f, 330.7f, 525.3f, 320.0f, 512.0f, 320.0f)
                lineTo(480.0f, 320.0f)
                lineTo(480.0f, 128.0f)
                curveTo(480.0f, 110.3f, 465.7f, 96.0f, 448.0f, 96.0f)
                curveTo(430.3f, 96.0f, 416.0f, 110.3f, 416.0f, 128.0f)
                lineTo(416.0f, 320.0f)
                lineTo(358.5f, 320.0f)
                lineTo(218.7f, 110.3f)
                close()
                moveTo(390.5f, 368.0f)
                lineTo(416.0f, 368.0f)
                lineTo(416.0f, 406.3f)
                lineTo(390.5f, 368.0f)
                close()
                moveTo(281.5f, 320.0f)
                lineTo(224.0f, 320.0f)
                lineTo(224.0f, 233.7f)
                lineTo(281.5f, 320.0f)
                close()
            }
        }
        .build()
        return `_naira-sign`!!
    }

private var `_naira-sign`: ImageVector? = null
