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

public val Fa.`Calendar-check`: ImageVector
    get() {
        if (`_calendar-check` != null) {
            return `_calendar-check`!!
        }
        `_calendar-check` = Builder(name = "Calendar-check", defaultWidth = 640.0.dp, defaultHeight
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
                moveTo(404.4f, 292.7f)
                curveTo(411.4f, 281.5f, 408.0f, 266.7f, 396.8f, 259.6f)
                curveTo(385.6f, 252.5f, 370.8f, 256.0f, 363.7f, 267.2f)
                lineTo(302.3f, 365.5f)
                lineTo(275.3f, 329.5f)
                curveTo(267.3f, 318.9f, 252.3f, 316.7f, 241.7f, 324.7f)
                curveTo(231.1f, 332.7f, 228.9f, 347.7f, 236.9f, 358.3f)
                lineTo(284.9f, 422.3f)
                curveTo(289.6f, 428.6f, 297.2f, 432.2f, 305.1f, 431.9f)
                curveTo(313.0f, 431.6f, 320.2f, 427.4f, 324.4f, 420.6f)
                lineTo(404.4f, 292.6f)
                close()
            }
        }
        .build()
        return `_calendar-check`!!
    }

private var `_calendar-check`: ImageVector? = null
