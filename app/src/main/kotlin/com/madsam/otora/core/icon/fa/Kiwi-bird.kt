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

public val Fa.`Kiwi-bird`: ImageVector
    get() {
        if (`_kiwi-bird` != null) {
            return `_kiwi-bird`!!
        }
        `_kiwi-bird` = Builder(name = "Kiwi-bird", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(323.2f, 452.4f)
                curveTo(354.4f, 433.6f, 387.9f, 416.0f, 424.3f, 416.0f)
                lineTo(480.0f, 416.0f)
                curveTo(484.6f, 416.0f, 489.1f, 415.8f, 493.6f, 415.3f)
                lineTo(578.9f, 537.2f)
                curveTo(582.9f, 542.9f, 590.2f, 545.4f, 596.8f, 543.3f)
                curveTo(603.4f, 541.2f, 608.0f, 535.0f, 608.0f, 528.0f)
                lineTo(608.0f, 288.0f)
                curveTo(608.0f, 217.3f, 550.7f, 160.0f, 480.0f, 160.0f)
                lineTo(424.3f, 160.0f)
                curveTo(387.9f, 160.0f, 354.4f, 142.4f, 323.2f, 123.6f)
                curveTo(294.3f, 106.1f, 260.3f, 96.0f, 224.0f, 96.0f)
                curveTo(118.0f, 96.0f, 32.0f, 182.0f, 32.0f, 288.0f)
                curveTo(32.0f, 359.1f, 70.6f, 421.1f, 128.0f, 454.3f)
                lineTo(128.0f, 520.0f)
                curveTo(128.0f, 533.3f, 138.7f, 544.0f, 152.0f, 544.0f)
                curveTo(165.3f, 544.0f, 176.0f, 533.3f, 176.0f, 520.0f)
                lineTo(176.0f, 474.0f)
                curveTo(191.3f, 477.9f, 207.4f, 480.0f, 224.0f, 480.0f)
                curveTo(229.4f, 480.0f, 234.7f, 479.8f, 240.0f, 479.3f)
                lineTo(240.0f, 520.0f)
                curveTo(240.0f, 533.3f, 250.7f, 544.0f, 264.0f, 544.0f)
                curveTo(277.3f, 544.0f, 288.0f, 533.3f, 288.0f, 520.0f)
                lineTo(288.0f, 469.1f)
                curveTo(300.4f, 464.7f, 312.2f, 459.1f, 323.2f, 452.4f)
                close()
                moveTo(480.0f, 264.0f)
                curveTo(493.3f, 264.0f, 504.0f, 274.7f, 504.0f, 288.0f)
                curveTo(504.0f, 301.3f, 493.3f, 312.0f, 480.0f, 312.0f)
                curveTo(466.7f, 312.0f, 456.0f, 301.3f, 456.0f, 288.0f)
                curveTo(456.0f, 274.7f, 466.7f, 264.0f, 480.0f, 264.0f)
                close()
            }
        }
        .build()
        return `_kiwi-bird`!!
    }

private var `_kiwi-bird`: ImageVector? = null
