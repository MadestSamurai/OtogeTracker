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

public val Fa.`Person-cane`: ImageVector
    get() {
        if (`_person-cane` != null) {
            return `_person-cane`!!
        }
        `_person-cane` = Builder(name = "Person-cane", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(328.0f, 32.0f)
                curveTo(358.9f, 32.0f, 384.0f, 57.1f, 384.0f, 88.0f)
                curveTo(384.0f, 118.9f, 358.9f, 144.0f, 328.0f, 144.0f)
                curveTo(297.1f, 144.0f, 272.0f, 118.9f, 272.0f, 88.0f)
                curveTo(272.0f, 57.1f, 297.1f, 32.0f, 328.0f, 32.0f)
                close()
                moveTo(240.0f, 300.7f)
                lineTo(193.7f, 363.1f)
                curveTo(183.2f, 377.3f, 163.1f, 380.3f, 148.9f, 369.7f)
                curveTo(134.7f, 359.1f, 131.7f, 339.1f, 142.3f, 324.9f)
                lineTo(212.8f, 229.9f)
                curveTo(238.0f, 196.0f, 277.7f, 176.0f, 320.0f, 176.0f)
                curveTo(362.3f, 176.0f, 402.0f, 196.0f, 427.2f, 229.9f)
                lineTo(497.7f, 324.9f)
                curveTo(508.2f, 339.1f, 505.3f, 359.1f, 491.1f, 369.7f)
                curveTo(476.9f, 380.3f, 456.9f, 377.3f, 446.3f, 363.1f)
                lineTo(400.0f, 300.7f)
                lineTo(400.0f, 576.0f)
                curveTo(400.0f, 593.7f, 385.7f, 608.0f, 368.0f, 608.0f)
                curveTo(350.3f, 608.0f, 336.0f, 593.7f, 336.0f, 576.0f)
                lineTo(336.0f, 416.0f)
                curveTo(336.0f, 407.2f, 328.8f, 400.0f, 320.0f, 400.0f)
                curveTo(311.2f, 400.0f, 304.0f, 407.2f, 304.0f, 416.0f)
                lineTo(304.0f, 576.0f)
                curveTo(304.0f, 593.7f, 289.7f, 608.0f, 272.0f, 608.0f)
                curveTo(254.3f, 608.0f, 240.0f, 593.7f, 240.0f, 576.0f)
                lineTo(240.0f, 300.7f)
                close()
                moveTo(488.0f, 448.0f)
                curveTo(483.6f, 448.0f, 480.0f, 451.6f, 480.0f, 456.0f)
                curveTo(480.0f, 469.3f, 469.3f, 480.0f, 456.0f, 480.0f)
                curveTo(442.7f, 480.0f, 432.0f, 469.3f, 432.0f, 456.0f)
                curveTo(432.0f, 425.1f, 457.1f, 400.0f, 488.0f, 400.0f)
                curveTo(518.9f, 400.0f, 544.0f, 425.1f, 544.0f, 456.0f)
                lineTo(544.0f, 584.0f)
                curveTo(544.0f, 597.3f, 533.3f, 608.0f, 520.0f, 608.0f)
                curveTo(506.7f, 608.0f, 496.0f, 597.3f, 496.0f, 584.0f)
                lineTo(496.0f, 456.0f)
                curveTo(496.0f, 451.6f, 492.4f, 448.0f, 488.0f, 448.0f)
                close()
            }
        }
        .build()
        return `_person-cane`!!
    }

private var `_person-cane`: ImageVector? = null
