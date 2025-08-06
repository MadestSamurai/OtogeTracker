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

public val Fa.`Cloud-download-alt`: ImageVector
    get() {
        if (`_cloud-download-alt` != null) {
            return `_cloud-download-alt`!!
        }
        `_cloud-download-alt` = Builder(name = "Cloud-download-alt", defaultWidth = 640.0.dp,
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
                moveTo(409.0f, 377.0f)
                curveTo(418.4f, 367.6f, 418.4f, 352.4f, 409.0f, 343.1f)
                curveTo(399.6f, 333.8f, 384.4f, 333.7f, 375.1f, 343.1f)
                lineTo(344.1f, 374.1f)
                lineTo(344.1f, 272.0f)
                curveTo(344.1f, 258.7f, 333.4f, 248.0f, 320.1f, 248.0f)
                curveTo(306.8f, 248.0f, 296.1f, 258.7f, 296.1f, 272.0f)
                lineTo(296.1f, 374.1f)
                lineTo(265.1f, 343.1f)
                curveTo(255.7f, 333.7f, 240.5f, 333.7f, 231.2f, 343.1f)
                curveTo(221.9f, 352.5f, 221.8f, 367.7f, 231.2f, 377.0f)
                lineTo(303.2f, 449.0f)
                curveTo(312.6f, 458.4f, 327.8f, 458.4f, 337.1f, 449.0f)
                lineTo(409.1f, 377.0f)
                close()
            }
        }
        .build()
        return `_cloud-download-alt`!!
    }

private var `_cloud-download-alt`: ImageVector? = null
