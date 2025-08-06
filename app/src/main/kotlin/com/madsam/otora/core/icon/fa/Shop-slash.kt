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

public val Fa.`Shop-slash`: ImageVector
    get() {
        if (`_shop-slash` != null) {
            return `_shop-slash`!!
        }
        `_shop-slash` = Builder(name = "Shop-slash", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(543.9f, 510.2f)
                lineTo(543.9f, 319.9f)
                curveTo(570.7f, 318.0f, 591.9f, 295.6f, 591.9f, 268.3f)
                curveTo(591.9f, 260.3f, 590.0f, 252.3f, 586.4f, 245.1f)
                lineTo(529.7f, 131.4f)
                curveTo(518.8f, 109.7f, 496.7f, 96.0f, 472.4f, 96.0f)
                lineTo(167.6f, 96.0f)
                curveTo(156.9f, 96.0f, 146.6f, 98.7f, 137.4f, 103.6f)
                lineTo(73.0f, 39.1f)
                close()
                moveTo(353.8f, 320.0f)
                lineTo(480.0f, 320.0f)
                lineTo(480.0f, 446.2f)
                lineTo(353.8f, 320.0f)
                close()
                moveTo(384.0f, 485.8f)
                lineTo(320.0f, 421.8f)
                lineTo(320.0f, 432.0f)
                curveTo(320.0f, 440.8f, 312.8f, 448.0f, 304.0f, 448.0f)
                lineTo(176.0f, 448.0f)
                curveTo(167.2f, 448.0f, 160.0f, 440.8f, 160.0f, 432.0f)
                lineTo(160.0f, 320.0f)
                lineTo(218.2f, 320.0f)
                lineTo(83.4f, 185.2f)
                lineTo(53.5f, 245.1f)
                curveTo(49.9f, 252.3f, 48.0f, 260.2f, 48.0f, 268.3f)
                curveTo(48.0f, 295.6f, 69.2f, 318.0f, 96.0f, 319.9f)
                lineTo(96.0f, 496.0f)
                curveTo(96.0f, 522.5f, 117.5f, 544.0f, 144.0f, 544.0f)
                lineTo(336.0f, 544.0f)
                curveTo(362.5f, 544.0f, 384.0f, 522.5f, 384.0f, 496.0f)
                lineTo(384.0f, 485.8f)
                close()
            }
        }
        .build()
        return `_shop-slash`!!
    }

private var `_shop-slash`: ImageVector? = null
