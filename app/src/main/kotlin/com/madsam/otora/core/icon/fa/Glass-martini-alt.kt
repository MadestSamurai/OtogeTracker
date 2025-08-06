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

public val Fa.`Glass-martini-alt`: ImageVector
    get() {
        if (`_glass-martini-alt` != null) {
            return `_glass-martini-alt`!!
        }
        `_glass-martini-alt` = Builder(name = "Glass-martini-alt", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(66.4f, 115.8f)
                curveTo(71.4f, 103.8f, 83.1f, 96.0f, 96.0f, 96.0f)
                lineTo(544.0f, 96.0f)
                curveTo(556.9f, 96.0f, 568.6f, 103.8f, 573.6f, 115.8f)
                curveTo(578.6f, 127.8f, 575.8f, 141.5f, 566.7f, 150.7f)
                lineTo(352.0f, 365.3f)
                lineTo(352.0f, 512.0f)
                lineTo(416.0f, 512.0f)
                curveTo(433.7f, 512.0f, 448.0f, 526.3f, 448.0f, 544.0f)
                curveTo(448.0f, 561.7f, 433.7f, 576.0f, 416.0f, 576.0f)
                lineTo(224.0f, 576.0f)
                curveTo(206.3f, 576.0f, 192.0f, 561.7f, 192.0f, 544.0f)
                curveTo(192.0f, 526.3f, 206.3f, 512.0f, 224.0f, 512.0f)
                lineTo(288.0f, 512.0f)
                lineTo(288.0f, 365.3f)
                lineTo(73.4f, 150.7f)
                curveTo(64.2f, 141.5f, 61.5f, 127.7f, 66.4f, 115.8f)
                close()
                moveTo(418.7f, 208.0f)
                lineTo(466.7f, 160.0f)
                lineTo(173.2f, 160.0f)
                lineTo(221.2f, 208.0f)
                lineTo(418.7f, 208.0f)
                close()
            }
        }
        .build()
        return `_glass-martini-alt`!!
    }

private var `_glass-martini-alt`: ImageVector? = null
