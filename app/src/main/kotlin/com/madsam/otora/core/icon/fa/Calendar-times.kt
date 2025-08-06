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

public val Fa.`Calendar-times`: ImageVector
    get() {
        if (`_calendar-times` != null) {
            return `_calendar-times`!!
        }
        `_calendar-times` = Builder(name = "Calendar-times", defaultWidth = 640.0.dp, defaultHeight
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
                moveTo(387.9f, 284.1f)
                curveTo(378.5f, 274.7f, 363.3f, 274.7f, 354.0f, 284.1f)
                lineTo(320.1f, 318.0f)
                lineTo(286.2f, 284.1f)
                curveTo(276.8f, 274.7f, 261.6f, 274.7f, 252.3f, 284.1f)
                curveTo(243.0f, 293.5f, 242.9f, 308.7f, 252.3f, 318.0f)
                lineTo(286.2f, 351.9f)
                lineTo(252.3f, 385.8f)
                curveTo(242.9f, 395.2f, 242.9f, 410.4f, 252.3f, 419.7f)
                curveTo(261.7f, 429.0f, 276.9f, 429.1f, 286.2f, 419.7f)
                lineTo(320.1f, 385.8f)
                lineTo(354.0f, 419.7f)
                curveTo(363.4f, 429.1f, 378.6f, 429.1f, 387.9f, 419.7f)
                curveTo(397.2f, 410.3f, 397.3f, 395.1f, 387.9f, 385.8f)
                lineTo(354.0f, 351.9f)
                lineTo(387.9f, 318.0f)
                curveTo(397.3f, 308.6f, 397.3f, 293.4f, 387.9f, 284.1f)
                close()
            }
        }
        .build()
        return `_calendar-times`!!
    }

private var `_calendar-times`: ImageVector? = null
