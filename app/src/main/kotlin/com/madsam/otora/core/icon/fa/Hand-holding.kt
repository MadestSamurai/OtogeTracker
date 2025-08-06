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

public val Fa.`Hand-holding`: ImageVector
    get() {
        if (`_hand-holding` != null) {
            return `_hand-holding`!!
        }
        `_hand-holding` = Builder(name = "Hand-holding", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(98.7f, 448.0f)
                lineTo(141.2f, 405.5f)
                curveTo(165.2f, 381.5f, 197.8f, 368.0f, 231.7f, 368.0f)
                lineTo(384.0f, 368.0f)
                curveTo(401.7f, 368.0f, 416.0f, 382.3f, 416.0f, 400.0f)
                curveTo(416.0f, 417.7f, 401.7f, 432.0f, 384.0f, 432.0f)
                lineTo(312.0f, 432.0f)
                curveTo(298.7f, 432.0f, 288.0f, 442.7f, 288.0f, 456.0f)
                curveTo(288.0f, 469.3f, 298.7f, 480.0f, 312.0f, 480.0f)
                lineTo(424.6f, 480.0f)
                lineTo(544.3f, 391.8f)
                curveTo(562.1f, 378.7f, 587.1f, 382.5f, 600.2f, 400.3f)
                curveTo(613.3f, 418.1f, 609.5f, 443.1f, 591.7f, 456.2f)
                lineTo(465.1f, 549.5f)
                curveTo(441.7f, 566.7f, 413.5f, 576.0f, 384.4f, 576.0f)
                lineTo(64.0f, 576.0f)
                curveTo(46.3f, 576.0f, 32.0f, 561.7f, 32.0f, 544.0f)
                lineTo(32.0f, 480.0f)
                curveTo(32.0f, 462.3f, 46.3f, 448.0f, 64.0f, 448.0f)
                lineTo(98.7f, 448.0f)
                close()
            }
        }
        .build()
        return `_hand-holding`!!
    }

private var `_hand-holding`: ImageVector? = null
