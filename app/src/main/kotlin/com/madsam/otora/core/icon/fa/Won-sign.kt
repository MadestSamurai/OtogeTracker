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

public val Fa.`Won-sign`: ImageVector
    get() {
        if (`_won-sign` != null) {
            return `_won-sign`!!
        }
        `_won-sign` = Builder(name = "Won-sign", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(126.4f, 117.9f)
                curveTo(120.8f, 101.1f, 102.7f, 92.1f, 85.9f, 97.6f)
                curveTo(69.1f, 103.1f, 60.1f, 121.4f, 65.7f, 138.1f)
                lineTo(120.9f, 304.0f)
                lineTo(96.0f, 304.0f)
                curveTo(82.7f, 304.0f, 72.0f, 314.7f, 72.0f, 328.0f)
                curveTo(72.0f, 341.3f, 82.7f, 352.0f, 96.0f, 352.0f)
                lineTo(136.9f, 352.0f)
                lineTo(193.6f, 522.1f)
                curveTo(198.1f, 535.6f, 211.0f, 544.5f, 225.2f, 544.0f)
                curveTo(239.4f, 543.5f, 251.6f, 533.6f, 255.0f, 519.8f)
                lineTo(297.0f, 352.0f)
                lineTo(343.0f, 352.0f)
                lineTo(385.0f, 519.8f)
                curveTo(388.4f, 533.6f, 400.6f, 543.5f, 414.8f, 544.0f)
                curveTo(429.0f, 544.5f, 441.9f, 535.6f, 446.4f, 522.1f)
                lineTo(503.1f, 352.0f)
                lineTo(544.0f, 352.0f)
                curveTo(557.3f, 352.0f, 568.0f, 341.3f, 568.0f, 328.0f)
                curveTo(568.0f, 314.7f, 557.3f, 304.0f, 544.0f, 304.0f)
                lineTo(519.1f, 304.0f)
                lineTo(574.4f, 138.1f)
                curveTo(580.0f, 121.3f, 570.9f, 103.2f, 554.2f, 97.6f)
                curveTo(537.5f, 92.0f, 519.3f, 101.1f, 513.7f, 117.8f)
                lineTo(451.7f, 303.9f)
                lineTo(397.1f, 303.9f)
                lineTo(351.2f, 120.1f)
                curveTo(347.5f, 106.0f, 334.7f, 96.0f, 320.0f, 96.0f)
                curveTo(305.3f, 96.0f, 292.5f, 106.0f, 289.0f, 120.2f)
                lineTo(243.0f, 304.0f)
                lineTo(188.4f, 304.0f)
                lineTo(126.4f, 117.9f)
                close()
                moveTo(204.4f, 352.0f)
                lineTo(231.0f, 352.0f)
                lineTo(219.6f, 397.6f)
                lineTo(204.4f, 352.0f)
                close()
                moveTo(309.0f, 304.0f)
                lineTo(320.0f, 259.9f)
                lineTo(331.0f, 304.0f)
                lineTo(309.0f, 304.0f)
                close()
                moveTo(409.0f, 352.0f)
                lineTo(435.6f, 352.0f)
                lineTo(420.4f, 397.6f)
                lineTo(409.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_won-sign`!!
    }

private var `_won-sign`: ImageVector? = null
