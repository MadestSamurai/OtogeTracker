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

public val Fa.`Hand-holding-water`: ImageVector
    get() {
        if (`_hand-holding-water` != null) {
            return `_hand-holding-water`!!
        }
        `_hand-holding-water` = Builder(name = "Hand-holding-water", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(307.5f, 70.6f)
                lineTo(241.2f, 167.0f)
                curveTo(230.0f, 183.3f, 224.0f, 202.6f, 224.0f, 222.3f)
                lineTo(224.0f, 224.0f)
                curveTo(224.0f, 277.0f, 267.0f, 320.0f, 320.0f, 320.0f)
                curveTo(373.0f, 320.0f, 416.0f, 277.0f, 416.0f, 224.0f)
                lineTo(416.0f, 222.3f)
                curveTo(416.0f, 202.5f, 410.0f, 183.3f, 398.8f, 167.0f)
                lineTo(332.5f, 70.6f)
                curveTo(329.7f, 66.5f, 325.0f, 64.0f, 320.0f, 64.0f)
                curveTo(315.0f, 64.0f, 310.3f, 66.5f, 307.5f, 70.6f)
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
        return `_hand-holding-water`!!
    }

private var `_hand-holding-water`: ImageVector? = null
