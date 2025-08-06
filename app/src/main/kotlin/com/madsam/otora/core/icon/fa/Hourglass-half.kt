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

public val Fa.`Hourglass-half`: ImageVector
    get() {
        if (`_hourglass-half` != null) {
            return `_hourglass-half`!!
        }
        `_hourglass-half` = Builder(name = "Hourglass-half", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 64.0f)
                curveTo(142.3f, 64.0f, 128.0f, 78.3f, 128.0f, 96.0f)
                curveTo(128.0f, 113.7f, 142.3f, 128.0f, 160.0f, 128.0f)
                lineTo(160.0f, 139.0f)
                curveTo(160.0f, 181.4f, 176.9f, 222.1f, 206.9f, 252.1f)
                lineTo(274.8f, 320.0f)
                lineTo(206.9f, 387.9f)
                curveTo(176.9f, 417.9f, 160.0f, 458.6f, 160.0f, 501.0f)
                lineTo(160.0f, 512.0f)
                curveTo(142.3f, 512.0f, 128.0f, 526.3f, 128.0f, 544.0f)
                curveTo(128.0f, 561.7f, 142.3f, 576.0f, 160.0f, 576.0f)
                lineTo(480.0f, 576.0f)
                curveTo(497.7f, 576.0f, 512.0f, 561.7f, 512.0f, 544.0f)
                curveTo(512.0f, 526.3f, 497.7f, 512.0f, 480.0f, 512.0f)
                lineTo(480.0f, 501.0f)
                curveTo(480.0f, 458.6f, 463.1f, 417.9f, 433.1f, 387.9f)
                lineTo(365.2f, 320.0f)
                lineTo(433.1f, 252.1f)
                curveTo(463.1f, 222.1f, 480.0f, 181.4f, 480.0f, 139.0f)
                lineTo(480.0f, 128.0f)
                curveTo(497.7f, 128.0f, 512.0f, 113.7f, 512.0f, 96.0f)
                curveTo(512.0f, 78.3f, 497.7f, 64.0f, 480.0f, 64.0f)
                lineTo(160.0f, 64.0f)
                close()
                moveTo(224.0f, 139.0f)
                lineTo(224.0f, 128.0f)
                lineTo(416.0f, 128.0f)
                lineTo(416.0f, 139.0f)
                curveTo(416.0f, 158.0f, 410.4f, 176.4f, 400.0f, 192.0f)
                lineTo(240.0f, 192.0f)
                curveTo(229.7f, 176.4f, 224.0f, 158.0f, 224.0f, 139.0f)
                close()
                moveTo(240.0f, 448.0f)
                curveTo(243.5f, 442.7f, 247.6f, 437.7f, 252.1f, 433.1f)
                lineTo(320.0f, 365.2f)
                lineTo(387.9f, 433.1f)
                curveTo(392.5f, 437.7f, 396.5f, 442.7f, 400.1f, 448.0f)
                lineTo(240.0f, 448.0f)
                close()
            }
        }
        .build()
        return `_hourglass-half`!!
    }

private var `_hourglass-half`: ImageVector? = null
