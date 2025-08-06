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

public val Fa.`External-link-square`: ImageVector
    get() {
        if (`_external-link-square` != null) {
            return `_external-link-square`!!
        }
        `_external-link-square` = Builder(name = "External-link-square", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 96.0f)
                curveTo(515.3f, 96.0f, 544.0f, 124.7f, 544.0f, 160.0f)
                lineTo(544.0f, 480.0f)
                curveTo(544.0f, 515.3f, 515.3f, 544.0f, 480.0f, 544.0f)
                lineTo(160.0f, 544.0f)
                curveTo(124.7f, 544.0f, 96.0f, 515.3f, 96.0f, 480.0f)
                lineTo(96.0f, 160.0f)
                curveTo(96.0f, 124.7f, 124.7f, 96.0f, 160.0f, 96.0f)
                lineTo(480.0f, 96.0f)
                close()
                moveTo(368.0f, 360.0f)
                curveTo(368.0f, 373.3f, 378.7f, 384.0f, 392.0f, 384.0f)
                curveTo(405.3f, 384.0f, 416.0f, 373.3f, 416.0f, 360.0f)
                lineTo(416.0f, 248.0f)
                curveTo(416.0f, 234.7f, 405.3f, 224.0f, 392.0f, 224.0f)
                lineTo(280.0f, 224.0f)
                curveTo(266.7f, 224.0f, 256.0f, 234.7f, 256.0f, 248.0f)
                curveTo(256.0f, 261.3f, 266.7f, 272.0f, 280.0f, 272.0f)
                lineTo(334.1f, 272.0f)
                lineTo(231.1f, 375.0f)
                curveTo(221.7f, 384.4f, 221.7f, 399.6f, 231.1f, 408.9f)
                curveTo(240.5f, 418.2f, 255.7f, 418.3f, 265.0f, 408.9f)
                lineTo(368.0f, 305.9f)
                lineTo(368.0f, 360.0f)
                close()
            }
        }
        .build()
        return `_external-link-square`!!
    }

private var `_external-link-square`: ImageVector? = null
