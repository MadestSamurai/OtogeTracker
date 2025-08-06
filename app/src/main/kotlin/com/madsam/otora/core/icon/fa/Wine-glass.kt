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

public val Fa.`Wine-glass`: ImageVector
    get() {
        if (`_wine-glass` != null) {
            return `_wine-glass`!!
        }
        `_wine-glass` = Builder(name = "Wine-glass", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.6f, 89.7f)
                curveTo(195.6f, 74.8f, 208.7f, 64.0f, 224.0f, 64.0f)
                lineTo(416.0f, 64.0f)
                curveTo(431.3f, 64.0f, 444.4f, 74.8f, 447.4f, 89.7f)
                lineTo(476.8f, 237.0f)
                curveTo(478.9f, 247.5f, 480.0f, 258.2f, 480.0f, 269.0f)
                lineTo(480.0f, 272.0f)
                curveTo(480.0f, 349.4f, 425.0f, 414.0f, 352.0f, 428.8f)
                lineTo(352.0f, 544.0f)
                lineTo(416.0f, 544.0f)
                curveTo(433.7f, 544.0f, 448.0f, 558.3f, 448.0f, 576.0f)
                curveTo(448.0f, 593.7f, 433.7f, 608.0f, 416.0f, 608.0f)
                lineTo(224.0f, 608.0f)
                curveTo(206.3f, 608.0f, 192.0f, 593.7f, 192.0f, 576.0f)
                curveTo(192.0f, 558.3f, 206.3f, 544.0f, 224.0f, 544.0f)
                lineTo(288.0f, 544.0f)
                lineTo(288.0f, 428.8f)
                curveTo(215.0f, 414.0f, 160.0f, 349.4f, 160.0f, 272.0f)
                lineTo(160.0f, 269.0f)
                curveTo(160.0f, 258.3f, 161.1f, 247.6f, 163.2f, 237.0f)
                lineTo(192.6f, 89.7f)
                close()
                moveTo(237.4f, 192.0f)
                lineTo(402.5f, 192.0f)
                lineTo(389.7f, 128.0f)
                lineTo(250.2f, 128.0f)
                lineTo(237.4f, 192.0f)
                close()
            }
        }
        .build()
        return `_wine-glass`!!
    }

private var `_wine-glass`: ImageVector? = null
