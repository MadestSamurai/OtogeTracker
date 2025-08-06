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

public val Fa.`Mountain-sun`: ImageVector
    get() {
        if (`_mountain-sun` != null) {
            return `_mountain-sun`!!
        }
        `_mountain-sun` = Builder(name = "Mountain-sun", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.5f, 64.0f)
                curveTo(303.2f, 64.0f, 316.7f, 72.1f, 323.7f, 85.0f)
                lineTo(539.7f, 485.0f)
                curveTo(546.4f, 497.4f, 546.1f, 512.4f, 538.9f, 524.5f)
                curveTo(531.7f, 536.6f, 518.6f, 544.0f, 504.6f, 544.0f)
                lineTo(72.6f, 544.0f)
                curveTo(58.5f, 544.0f, 45.5f, 536.6f, 38.3f, 524.5f)
                curveTo(31.1f, 512.4f, 30.8f, 497.4f, 37.5f, 485.0f)
                lineTo(253.5f, 85.0f)
                lineTo(256.4f, 80.4f)
                curveTo(263.7f, 70.2f, 275.6f, 64.0f, 288.5f, 64.0f)
                close()
                moveTo(202.4f, 313.9f)
                lineTo(229.2f, 340.7f)
                curveTo(235.4f, 346.9f, 245.6f, 346.9f, 251.8f, 340.7f)
                lineTo(295.1f, 297.4f)
                curveTo(301.1f, 291.4f, 309.2f, 288.0f, 317.7f, 288.0f)
                lineTo(360.5f, 288.0f)
                lineTo(288.4f, 154.5f)
                lineTo(202.3f, 313.9f)
                close()
                moveTo(528.5f, 224.0f)
                curveTo(484.3f, 224.0f, 448.5f, 188.2f, 448.5f, 144.0f)
                curveTo(448.5f, 99.8f, 484.3f, 64.0f, 528.5f, 64.0f)
                curveTo(572.7f, 64.0f, 608.5f, 99.8f, 608.5f, 144.0f)
                curveTo(608.5f, 188.2f, 572.7f, 224.0f, 528.5f, 224.0f)
                close()
            }
        }
        .build()
        return `_mountain-sun`!!
    }

private var `_mountain-sun`: ImageVector? = null
