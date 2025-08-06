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

public val Fa.`Cloud-upload-alt`: ImageVector
    get() {
        if (`_cloud-upload-alt` != null) {
            return `_cloud-upload-alt`!!
        }
        `_cloud-upload-alt` = Builder(name = "Cloud-upload-alt", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(176.0f, 544.0f)
                curveTo(96.5f, 544.0f, 32.0f, 479.5f, 32.0f, 400.0f)
                curveTo(32.0f, 336.6f, 73.0f, 282.8f, 129.9f, 263.5f)
                curveTo(128.6f, 255.8f, 128.0f, 248.0f, 128.0f, 240.0f)
                curveTo(128.0f, 160.5f, 192.5f, 96.0f, 272.0f, 96.0f)
                curveTo(327.4f, 96.0f, 375.5f, 127.3f, 399.6f, 173.1f)
                curveTo(413.8f, 164.8f, 430.4f, 160.0f, 448.0f, 160.0f)
                curveTo(501.0f, 160.0f, 544.0f, 203.0f, 544.0f, 256.0f)
                curveTo(544.0f, 271.7f, 540.2f, 286.6f, 533.5f, 299.7f)
                curveTo(577.5f, 320.0f, 608.0f, 364.4f, 608.0f, 416.0f)
                curveTo(608.0f, 486.7f, 550.7f, 544.0f, 480.0f, 544.0f)
                lineTo(176.0f, 544.0f)
                close()
                moveTo(337.0f, 255.0f)
                curveTo(327.6f, 245.6f, 312.4f, 245.6f, 303.1f, 255.0f)
                lineTo(231.1f, 327.0f)
                curveTo(221.7f, 336.4f, 221.7f, 351.6f, 231.1f, 360.9f)
                curveTo(240.5f, 370.2f, 255.7f, 370.3f, 265.0f, 360.9f)
                lineTo(296.0f, 329.9f)
                lineTo(296.0f, 432.0f)
                curveTo(296.0f, 445.3f, 306.7f, 456.0f, 320.0f, 456.0f)
                curveTo(333.3f, 456.0f, 344.0f, 445.3f, 344.0f, 432.0f)
                lineTo(344.0f, 329.9f)
                lineTo(375.0f, 360.9f)
                curveTo(384.4f, 370.3f, 399.6f, 370.3f, 408.9f, 360.9f)
                curveTo(418.2f, 351.5f, 418.3f, 336.3f, 408.9f, 327.0f)
                lineTo(336.9f, 255.0f)
                close()
            }
        }
        .build()
        return `_cloud-upload-alt`!!
    }

private var `_cloud-upload-alt`: ImageVector? = null
