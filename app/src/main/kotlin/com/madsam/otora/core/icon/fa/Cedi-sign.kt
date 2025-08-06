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

public val Fa.`Cedi-sign`: ImageVector
    get() {
        if (`_cedi-sign` != null) {
            return `_cedi-sign`!!
        }
        `_cedi-sign` = Builder(name = "Cedi-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(360.0f, 96.0f)
                curveTo(360.0f, 82.7f, 349.3f, 72.0f, 336.0f, 72.0f)
                curveTo(322.7f, 72.0f, 312.0f, 82.7f, 312.0f, 96.0f)
                lineTo(312.0f, 122.5f)
                curveTo(216.8f, 137.9f, 144.0f, 220.4f, 144.0f, 320.0f)
                curveTo(144.0f, 419.6f, 216.8f, 502.1f, 312.0f, 517.5f)
                lineTo(312.0f, 544.0f)
                curveTo(312.0f, 557.3f, 322.7f, 568.0f, 336.0f, 568.0f)
                curveTo(349.3f, 568.0f, 360.0f, 557.3f, 360.0f, 544.0f)
                lineTo(360.0f, 519.4f)
                curveTo(406.8f, 515.7f, 449.1f, 495.8f, 481.3f, 465.5f)
                curveTo(494.2f, 453.4f, 494.7f, 433.1f, 482.6f, 420.3f)
                curveTo(470.5f, 407.5f, 450.2f, 406.9f, 437.4f, 419.0f)
                curveTo(416.7f, 438.6f, 389.8f, 451.7f, 360.1f, 455.2f)
                lineTo(360.1f, 185.1f)
                curveTo(389.9f, 188.6f, 416.7f, 201.7f, 437.4f, 221.3f)
                curveTo(450.3f, 233.4f, 470.5f, 232.8f, 482.6f, 220.0f)
                curveTo(494.7f, 207.2f, 494.1f, 186.9f, 481.3f, 174.8f)
                curveTo(449.1f, 144.2f, 406.8f, 124.3f, 360.0f, 120.6f)
                lineTo(360.0f, 96.0f)
                close()
                moveTo(312.0f, 187.8f)
                lineTo(312.0f, 452.2f)
                curveTo(252.3f, 437.8f, 208.0f, 384.1f, 208.0f, 320.0f)
                curveTo(208.0f, 255.9f, 252.3f, 202.2f, 312.0f, 187.8f)
                close()
            }
        }
        .build()
        return `_cedi-sign`!!
    }

private var `_cedi-sign`: ImageVector? = null
