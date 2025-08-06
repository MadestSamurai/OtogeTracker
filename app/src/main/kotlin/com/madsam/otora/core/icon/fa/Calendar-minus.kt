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

public val Fa.`Calendar-minus`: ImageVector
    get() {
        if (`_calendar-minus` != null) {
            return `_calendar-minus`!!
        }
        `_calendar-minus` = Builder(name = "Calendar-minus", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 64.0f)
                curveTo(241.7f, 64.0f, 256.0f, 78.3f, 256.0f, 96.0f)
                lineTo(256.0f, 128.0f)
                lineTo(384.0f, 128.0f)
                lineTo(384.0f, 96.0f)
                curveTo(384.0f, 78.3f, 398.3f, 64.0f, 416.0f, 64.0f)
                curveTo(433.7f, 64.0f, 448.0f, 78.3f, 448.0f, 96.0f)
                lineTo(448.0f, 128.0f)
                lineTo(480.0f, 128.0f)
                curveTo(515.3f, 128.0f, 544.0f, 156.7f, 544.0f, 192.0f)
                lineTo(544.0f, 480.0f)
                curveTo(544.0f, 515.3f, 515.3f, 544.0f, 480.0f, 544.0f)
                lineTo(160.0f, 544.0f)
                curveTo(124.7f, 544.0f, 96.0f, 515.3f, 96.0f, 480.0f)
                lineTo(96.0f, 192.0f)
                curveTo(96.0f, 156.7f, 124.7f, 128.0f, 160.0f, 128.0f)
                lineTo(192.0f, 128.0f)
                lineTo(192.0f, 96.0f)
                curveTo(192.0f, 78.3f, 206.3f, 64.0f, 224.0f, 64.0f)
                close()
                moveTo(248.0f, 328.0f)
                curveTo(234.7f, 328.0f, 224.0f, 338.7f, 224.0f, 352.0f)
                curveTo(224.0f, 365.3f, 234.7f, 376.0f, 248.0f, 376.0f)
                lineTo(392.0f, 376.0f)
                curveTo(405.3f, 376.0f, 416.0f, 365.3f, 416.0f, 352.0f)
                curveTo(416.0f, 338.7f, 405.3f, 328.0f, 392.0f, 328.0f)
                lineTo(248.0f, 328.0f)
                close()
            }
        }
        .build()
        return `_calendar-minus`!!
    }

private var `_calendar-minus`: ImageVector? = null
