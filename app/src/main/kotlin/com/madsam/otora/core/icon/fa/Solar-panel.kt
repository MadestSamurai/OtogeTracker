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

public val Fa.`Solar-panel`: ImageVector
    get() {
        if (`_solar-panel` != null) {
            return `_solar-panel`!!
        }
        `_solar-panel` = Builder(name = "Solar-panel", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(153.8f, 96.0f)
                curveTo(123.8f, 96.0f, 97.8f, 116.8f, 91.3f, 146.1f)
                lineTo(41.6f, 370.1f)
                curveTo(32.7f, 410.1f, 63.1f, 448.0f, 104.0f, 448.0f)
                lineTo(288.1f, 448.0f)
                lineTo(288.1f, 512.0f)
                lineTo(224.1f, 512.0f)
                curveTo(206.4f, 512.0f, 192.1f, 526.3f, 192.1f, 544.0f)
                curveTo(192.1f, 561.7f, 206.4f, 576.0f, 224.1f, 576.0f)
                lineTo(416.1f, 576.0f)
                curveTo(433.8f, 576.0f, 448.1f, 561.7f, 448.1f, 544.0f)
                curveTo(448.1f, 526.3f, 433.8f, 512.0f, 416.1f, 512.0f)
                lineTo(352.1f, 512.0f)
                lineTo(352.1f, 448.0f)
                lineTo(536.2f, 448.0f)
                curveTo(577.1f, 448.0f, 607.6f, 410.1f, 598.7f, 370.1f)
                lineTo(548.9f, 146.1f)
                curveTo(542.4f, 116.8f, 516.5f, 96.0f, 486.5f, 96.0f)
                lineTo(153.8f, 96.0f)
                close()
                moveTo(277.6f, 160.0f)
                lineTo(362.8f, 160.0f)
                lineTo(370.1f, 248.0f)
                lineTo(270.3f, 248.0f)
                lineTo(277.6f, 160.0f)
                close()
                moveTo(222.1f, 248.0f)
                lineTo(134.3f, 248.0f)
                lineTo(153.9f, 160.0f)
                lineTo(229.5f, 160.0f)
                lineTo(222.2f, 248.0f)
                close()
                moveTo(123.6f, 296.0f)
                lineTo(218.1f, 296.0f)
                lineTo(210.8f, 384.0f)
                lineTo(104.1f, 384.0f)
                lineTo(123.7f, 296.0f)
                close()
                moveTo(266.2f, 296.0f)
                lineTo(374.0f, 296.0f)
                lineTo(381.3f, 384.0f)
                lineTo(258.8f, 384.0f)
                lineTo(266.1f, 296.0f)
                close()
                moveTo(422.2f, 296.0f)
                lineTo(516.7f, 296.0f)
                lineTo(536.3f, 384.0f)
                lineTo(429.6f, 384.0f)
                lineTo(422.3f, 296.0f)
                close()
                moveTo(506.0f, 248.0f)
                lineTo(418.2f, 248.0f)
                lineTo(410.9f, 160.0f)
                lineTo(486.5f, 160.0f)
                lineTo(506.1f, 248.0f)
                close()
            }
        }
        .build()
        return `_solar-panel`!!
    }

private var `_solar-panel`: ImageVector? = null
