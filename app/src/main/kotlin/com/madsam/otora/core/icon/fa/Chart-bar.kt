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

public val Fa.`Chart-bar`: ImageVector
    get() {
        if (`_chart-bar` != null) {
            return `_chart-bar`!!
        }
        `_chart-bar` = Builder(name = "Chart-bar", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 96.0f)
                curveTo(113.7f, 96.0f, 128.0f, 110.3f, 128.0f, 128.0f)
                lineTo(128.0f, 464.0f)
                curveTo(128.0f, 472.8f, 135.2f, 480.0f, 144.0f, 480.0f)
                lineTo(544.0f, 480.0f)
                curveTo(561.7f, 480.0f, 576.0f, 494.3f, 576.0f, 512.0f)
                curveTo(576.0f, 529.7f, 561.7f, 544.0f, 544.0f, 544.0f)
                lineTo(144.0f, 544.0f)
                curveTo(99.8f, 544.0f, 64.0f, 508.2f, 64.0f, 464.0f)
                lineTo(64.0f, 128.0f)
                curveTo(64.0f, 110.3f, 78.3f, 96.0f, 96.0f, 96.0f)
                close()
                moveTo(192.0f, 160.0f)
                curveTo(192.0f, 142.3f, 206.3f, 128.0f, 224.0f, 128.0f)
                lineTo(416.0f, 128.0f)
                curveTo(433.7f, 128.0f, 448.0f, 142.3f, 448.0f, 160.0f)
                curveTo(448.0f, 177.7f, 433.7f, 192.0f, 416.0f, 192.0f)
                lineTo(224.0f, 192.0f)
                curveTo(206.3f, 192.0f, 192.0f, 177.7f, 192.0f, 160.0f)
                close()
                moveTo(224.0f, 240.0f)
                lineTo(352.0f, 240.0f)
                curveTo(369.7f, 240.0f, 384.0f, 254.3f, 384.0f, 272.0f)
                curveTo(384.0f, 289.7f, 369.7f, 304.0f, 352.0f, 304.0f)
                lineTo(224.0f, 304.0f)
                curveTo(206.3f, 304.0f, 192.0f, 289.7f, 192.0f, 272.0f)
                curveTo(192.0f, 254.3f, 206.3f, 240.0f, 224.0f, 240.0f)
                close()
                moveTo(224.0f, 352.0f)
                lineTo(480.0f, 352.0f)
                curveTo(497.7f, 352.0f, 512.0f, 366.3f, 512.0f, 384.0f)
                curveTo(512.0f, 401.7f, 497.7f, 416.0f, 480.0f, 416.0f)
                lineTo(224.0f, 416.0f)
                curveTo(206.3f, 416.0f, 192.0f, 401.7f, 192.0f, 384.0f)
                curveTo(192.0f, 366.3f, 206.3f, 352.0f, 224.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_chart-bar`!!
    }

private var `_chart-bar`: ImageVector? = null
