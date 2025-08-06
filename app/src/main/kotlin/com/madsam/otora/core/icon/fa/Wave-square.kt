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

public val Fa.`Wave-square`: ImageVector
    get() {
        if (`_wave-square` != null) {
            return `_wave-square`!!
        }
        `_wave-square` = Builder(name = "Wave-square", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 160.0f)
                curveTo(128.0f, 142.3f, 142.3f, 128.0f, 160.0f, 128.0f)
                lineTo(320.0f, 128.0f)
                curveTo(337.7f, 128.0f, 352.0f, 142.3f, 352.0f, 160.0f)
                lineTo(352.0f, 448.0f)
                lineTo(448.0f, 448.0f)
                lineTo(448.0f, 320.0f)
                curveTo(448.0f, 302.3f, 462.3f, 288.0f, 480.0f, 288.0f)
                lineTo(544.0f, 288.0f)
                curveTo(561.7f, 288.0f, 576.0f, 302.3f, 576.0f, 320.0f)
                curveTo(576.0f, 337.7f, 561.7f, 352.0f, 544.0f, 352.0f)
                lineTo(512.0f, 352.0f)
                lineTo(512.0f, 480.0f)
                curveTo(512.0f, 497.7f, 497.7f, 512.0f, 480.0f, 512.0f)
                lineTo(320.0f, 512.0f)
                curveTo(302.3f, 512.0f, 288.0f, 497.7f, 288.0f, 480.0f)
                lineTo(288.0f, 192.0f)
                lineTo(192.0f, 192.0f)
                lineTo(192.0f, 320.0f)
                curveTo(192.0f, 337.7f, 177.7f, 352.0f, 160.0f, 352.0f)
                lineTo(96.0f, 352.0f)
                curveTo(78.3f, 352.0f, 64.0f, 337.7f, 64.0f, 320.0f)
                curveTo(64.0f, 302.3f, 78.3f, 288.0f, 96.0f, 288.0f)
                lineTo(128.0f, 288.0f)
                lineTo(128.0f, 160.0f)
                close()
            }
        }
        .build()
        return `_wave-square`!!
    }

private var `_wave-square`: ImageVector? = null
