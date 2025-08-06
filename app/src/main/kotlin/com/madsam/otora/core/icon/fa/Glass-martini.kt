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

public val Fa.`Glass-martini`: ImageVector
    get() {
        if (`_glass-martini` != null) {
            return `_glass-martini`!!
        }
        `_glass-martini` = Builder(name = "Glass-martini", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 96.0f)
                curveTo(83.1f, 96.0f, 71.4f, 103.8f, 66.4f, 115.8f)
                curveTo(61.4f, 127.8f, 64.2f, 141.5f, 73.4f, 150.6f)
                lineTo(288.0f, 365.2f)
                lineTo(288.0f, 511.9f)
                lineTo(224.0f, 511.9f)
                curveTo(206.3f, 511.9f, 192.0f, 526.2f, 192.0f, 543.9f)
                curveTo(192.0f, 561.6f, 206.3f, 575.9f, 224.0f, 575.9f)
                lineTo(416.0f, 575.9f)
                curveTo(433.7f, 575.9f, 448.0f, 561.6f, 448.0f, 543.9f)
                curveTo(448.0f, 526.2f, 433.7f, 511.9f, 416.0f, 511.9f)
                lineTo(352.0f, 511.9f)
                lineTo(352.0f, 365.2f)
                lineTo(566.6f, 150.6f)
                curveTo(575.8f, 141.4f, 578.5f, 127.7f, 573.5f, 115.7f)
                curveTo(568.5f, 103.7f, 556.9f, 96.0f, 544.0f, 96.0f)
                lineTo(96.0f, 96.0f)
                close()
                moveTo(320.0f, 306.7f)
                lineTo(173.3f, 160.0f)
                lineTo(466.7f, 160.0f)
                lineTo(320.0f, 306.7f)
                close()
            }
        }
        .build()
        return `_glass-martini`!!
    }

private var `_glass-martini`: ImageVector? = null
