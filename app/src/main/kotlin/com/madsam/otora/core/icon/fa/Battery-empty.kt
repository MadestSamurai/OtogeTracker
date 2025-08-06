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

public val Fa.`Battery-empty`: ImageVector
    get() {
        if (`_battery-empty` != null) {
            return `_battery-empty`!!
        }
        `_battery-empty` = Builder(name = "Battery-empty", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(112.0f, 224.0f)
                curveTo(103.2f, 224.0f, 96.0f, 231.2f, 96.0f, 240.0f)
                lineTo(96.0f, 464.0f)
                curveTo(96.0f, 472.8f, 103.2f, 480.0f, 112.0f, 480.0f)
                lineTo(528.0f, 480.0f)
                curveTo(536.8f, 480.0f, 544.0f, 472.8f, 544.0f, 464.0f)
                lineTo(544.0f, 240.0f)
                curveTo(544.0f, 231.2f, 536.8f, 224.0f, 528.0f, 224.0f)
                lineTo(112.0f, 224.0f)
                close()
                moveTo(32.0f, 240.0f)
                curveTo(32.0f, 195.8f, 67.8f, 160.0f, 112.0f, 160.0f)
                lineTo(528.0f, 160.0f)
                curveTo(572.2f, 160.0f, 608.0f, 195.8f, 608.0f, 240.0f)
                lineTo(608.0f, 288.0f)
                curveTo(625.7f, 288.0f, 640.0f, 302.3f, 640.0f, 320.0f)
                lineTo(640.0f, 384.0f)
                curveTo(640.0f, 401.7f, 625.7f, 416.0f, 608.0f, 416.0f)
                lineTo(608.0f, 464.0f)
                curveTo(608.0f, 508.2f, 572.2f, 544.0f, 528.0f, 544.0f)
                lineTo(112.0f, 544.0f)
                curveTo(67.8f, 544.0f, 32.0f, 508.2f, 32.0f, 464.0f)
                lineTo(32.0f, 240.0f)
                close()
            }
        }
        .build()
        return `_battery-empty`!!
    }

private var `_battery-empty`: ImageVector? = null
