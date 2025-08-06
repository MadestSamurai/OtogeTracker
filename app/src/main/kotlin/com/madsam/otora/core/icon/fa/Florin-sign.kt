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

public val Fa.`Florin-sign`: ImageVector
    get() {
        if (`_florin-sign` != null) {
            return `_florin-sign`!!
        }
        `_florin-sign` = Builder(name = "Florin-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(442.7f, 96.0f)
                curveTo(403.9f, 96.0f, 369.0f, 119.3f, 354.1f, 155.1f)
                lineTo(298.7f, 288.0f)
                lineTo(192.0f, 288.0f)
                curveTo(174.3f, 288.0f, 160.0f, 302.3f, 160.0f, 320.0f)
                curveTo(160.0f, 337.7f, 174.3f, 352.0f, 192.0f, 352.0f)
                lineTo(272.0f, 352.0f)
                lineTo(226.9f, 460.3f)
                curveTo(221.9f, 472.2f, 210.3f, 480.0f, 197.4f, 480.0f)
                lineTo(160.0f, 480.0f)
                curveTo(142.3f, 480.0f, 128.0f, 494.3f, 128.0f, 512.0f)
                curveTo(128.0f, 529.7f, 142.3f, 544.0f, 160.0f, 544.0f)
                lineTo(197.3f, 544.0f)
                curveTo(236.1f, 544.0f, 271.0f, 520.7f, 285.9f, 484.9f)
                lineTo(341.3f, 352.0f)
                lineTo(448.0f, 352.0f)
                curveTo(465.7f, 352.0f, 480.0f, 337.7f, 480.0f, 320.0f)
                curveTo(480.0f, 302.3f, 465.7f, 288.0f, 448.0f, 288.0f)
                lineTo(368.0f, 288.0f)
                lineTo(413.1f, 179.7f)
                curveTo(418.1f, 167.8f, 429.7f, 160.0f, 442.6f, 160.0f)
                lineTo(480.0f, 160.0f)
                curveTo(497.7f, 160.0f, 512.0f, 145.7f, 512.0f, 128.0f)
                curveTo(512.0f, 110.3f, 497.7f, 96.0f, 480.0f, 96.0f)
                lineTo(442.7f, 96.0f)
                close()
            }
        }
        .build()
        return `_florin-sign`!!
    }

private var `_florin-sign`: ImageVector? = null
