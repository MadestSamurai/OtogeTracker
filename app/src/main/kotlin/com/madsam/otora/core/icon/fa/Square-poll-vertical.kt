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

public val Fa.`Square-poll-vertical`: ImageVector
    get() {
        if (`_square-poll-vertical` != null) {
            return `_square-poll-vertical`!!
        }
        `_square-poll-vertical` = Builder(name = "Square-poll-vertical", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                close()
                moveTo(216.0f, 288.0f)
                curveTo(229.3f, 288.0f, 240.0f, 298.7f, 240.0f, 312.0f)
                lineTo(240.0f, 424.0f)
                curveTo(240.0f, 437.3f, 229.3f, 448.0f, 216.0f, 448.0f)
                curveTo(202.7f, 448.0f, 192.0f, 437.3f, 192.0f, 424.0f)
                lineTo(192.0f, 312.0f)
                curveTo(192.0f, 298.7f, 202.7f, 288.0f, 216.0f, 288.0f)
                close()
                moveTo(400.0f, 376.0f)
                curveTo(400.0f, 362.7f, 410.7f, 352.0f, 424.0f, 352.0f)
                curveTo(437.3f, 352.0f, 448.0f, 362.7f, 448.0f, 376.0f)
                lineTo(448.0f, 424.0f)
                curveTo(448.0f, 437.3f, 437.3f, 448.0f, 424.0f, 448.0f)
                curveTo(410.7f, 448.0f, 400.0f, 437.3f, 400.0f, 424.0f)
                lineTo(400.0f, 376.0f)
                close()
                moveTo(320.0f, 192.0f)
                curveTo(333.3f, 192.0f, 344.0f, 202.7f, 344.0f, 216.0f)
                lineTo(344.0f, 424.0f)
                curveTo(344.0f, 437.3f, 333.3f, 448.0f, 320.0f, 448.0f)
                curveTo(306.7f, 448.0f, 296.0f, 437.3f, 296.0f, 424.0f)
                lineTo(296.0f, 216.0f)
                curveTo(296.0f, 202.7f, 306.7f, 192.0f, 320.0f, 192.0f)
                close()
            }
        }
        .build()
        return `_square-poll-vertical`!!
    }

private var `_square-poll-vertical`: ImageVector? = null
