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

public val Fa.`Hand-holding-heart`: ImageVector
    get() {
        if (`_hand-holding-heart` != null) {
            return `_hand-holding-heart`!!
        }
        `_hand-holding-heart` = Builder(name = "Hand-holding-heart", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(311.6f, 95.0f)
                curveTo(297.5f, 75.5f, 274.9f, 64.0f, 250.9f, 64.0f)
                curveTo(209.5f, 64.0f, 176.0f, 97.5f, 176.0f, 138.9f)
                lineTo(176.0f, 141.3f)
                curveTo(176.0f, 205.7f, 258.0f, 274.7f, 298.2f, 304.6f)
                curveTo(311.2f, 314.3f, 328.7f, 314.3f, 341.7f, 304.6f)
                curveTo(381.9f, 274.6f, 463.9f, 205.7f, 463.9f, 141.3f)
                lineTo(463.9f, 138.9f)
                curveTo(463.9f, 97.5f, 430.4f, 64.0f, 389.0f, 64.0f)
                curveTo(365.0f, 64.0f, 342.4f, 75.5f, 328.3f, 95.0f)
                lineTo(320.0f, 106.7f)
                lineTo(311.6f, 95.0f)
                close()
                moveTo(141.3f, 405.5f)
                lineTo(98.7f, 448.0f)
                lineTo(64.0f, 448.0f)
                curveTo(46.3f, 448.0f, 32.0f, 462.3f, 32.0f, 480.0f)
                lineTo(32.0f, 544.0f)
                curveTo(32.0f, 561.7f, 46.3f, 576.0f, 64.0f, 576.0f)
                lineTo(384.5f, 576.0f)
                curveTo(413.5f, 576.0f, 441.8f, 566.7f, 465.2f, 549.5f)
                lineTo(591.8f, 456.2f)
                curveTo(609.6f, 443.1f, 613.4f, 418.1f, 600.3f, 400.3f)
                curveTo(587.2f, 382.5f, 562.2f, 378.7f, 544.4f, 391.8f)
                lineTo(424.6f, 480.0f)
                lineTo(312.0f, 480.0f)
                curveTo(298.7f, 480.0f, 288.0f, 469.3f, 288.0f, 456.0f)
                curveTo(288.0f, 442.7f, 298.7f, 432.0f, 312.0f, 432.0f)
                lineTo(384.0f, 432.0f)
                curveTo(401.7f, 432.0f, 416.0f, 417.7f, 416.0f, 400.0f)
                curveTo(416.0f, 382.3f, 401.7f, 368.0f, 384.0f, 368.0f)
                lineTo(231.8f, 368.0f)
                curveTo(197.9f, 368.0f, 165.3f, 381.5f, 141.3f, 405.5f)
                close()
            }
        }
        .build()
        return `_hand-holding-heart`!!
    }

private var `_hand-holding-heart`: ImageVector? = null
