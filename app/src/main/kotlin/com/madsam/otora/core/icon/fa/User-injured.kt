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

public val Fa.`User-injured`: ImageVector
    get() {
        if (`_user-injured` != null) {
            return `_user-injured`!!
        }
        `_user-injured` = Builder(name = "User-injured", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(338.7f, 144.0f)
                lineTo(430.0f, 144.0f)
                curveTo(419.3f, 119.4f, 400.5f, 99.1f, 377.1f, 86.4f)
                lineTo(338.7f, 144.0f)
                close()
                moveTo(337.8f, 73.3f)
                curveTo(332.0f, 72.4f, 326.0f, 72.0f, 320.0f, 72.0f)
                curveTo(270.8f, 72.0f, 228.5f, 101.6f, 210.0f, 144.0f)
                lineTo(290.6f, 144.0f)
                lineTo(337.7f, 73.3f)
                close()
                moveTo(320.0f, 312.0f)
                curveTo(386.3f, 312.0f, 440.0f, 258.3f, 440.0f, 192.0f)
                lineTo(200.0f, 192.0f)
                curveTo(200.0f, 258.3f, 253.7f, 312.0f, 320.0f, 312.0f)
                close()
                moveTo(194.7f, 405.8f)
                curveTo(145.3f, 434.2f, 112.0f, 487.5f, 112.0f, 548.6f)
                curveTo(112.0f, 563.7f, 124.3f, 576.0f, 139.4f, 576.0f)
                lineTo(290.4f, 576.0f)
                lineTo(194.6f, 405.8f)
                close()
                moveTo(239.8f, 388.1f)
                lineTo(282.5f, 464.0f)
                lineTo(368.0f, 464.0f)
                curveTo(412.2f, 464.0f, 448.0f, 499.8f, 448.0f, 544.0f)
                curveTo(448.0f, 555.4f, 445.6f, 566.2f, 441.3f, 576.0f)
                lineTo(500.5f, 576.0f)
                curveTo(515.6f, 576.0f, 527.9f, 563.7f, 527.9f, 548.6f)
                curveTo(527.9f, 457.7f, 454.2f, 384.0f, 363.3f, 384.0f)
                lineTo(276.4f, 384.0f)
                curveTo(263.8f, 384.0f, 251.5f, 385.4f, 239.7f, 388.1f)
                close()
                moveTo(309.5f, 512.0f)
                lineTo(345.5f, 576.0f)
                lineTo(368.0f, 576.0f)
                curveTo(385.7f, 576.0f, 400.0f, 561.7f, 400.0f, 544.0f)
                curveTo(400.0f, 526.3f, 385.7f, 512.0f, 368.0f, 512.0f)
                lineTo(309.5f, 512.0f)
                close()
            }
        }
        .build()
        return `_user-injured`!!
    }

private var `_user-injured`: ImageVector? = null
