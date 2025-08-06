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

public val Fa.`Calendar-day`: ImageVector
    get() {
        if (`_calendar-day` != null) {
            return `_calendar-day`!!
        }
        `_calendar-day` = Builder(name = "Calendar-day", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
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
                moveTo(224.0f, 320.0f)
                curveTo(206.3f, 320.0f, 192.0f, 334.3f, 192.0f, 352.0f)
                lineTo(192.0f, 416.0f)
                curveTo(192.0f, 433.7f, 206.3f, 448.0f, 224.0f, 448.0f)
                lineTo(288.0f, 448.0f)
                curveTo(305.7f, 448.0f, 320.0f, 433.7f, 320.0f, 416.0f)
                lineTo(320.0f, 352.0f)
                curveTo(320.0f, 334.3f, 305.7f, 320.0f, 288.0f, 320.0f)
                lineTo(224.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_calendar-day`!!
    }

private var `_calendar-day`: ImageVector? = null
