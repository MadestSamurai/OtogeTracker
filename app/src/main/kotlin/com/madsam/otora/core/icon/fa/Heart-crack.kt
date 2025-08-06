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

public val Fa.`Heart-crack`: ImageVector
    get() {
        if (`_heart-crack` != null) {
            return `_heart-crack`!!
        }
        `_heart-crack` = Builder(name = "Heart-crack", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(197.1f, 96.0f)
                curveTo(214.4f, 96.0f, 231.3f, 99.4f, 247.0f, 105.7f)
                lineTo(301.8f, 190.9f)
                lineTo(226.4f, 266.3f)
                curveTo(224.9f, 267.8f, 224.0f, 269.9f, 224.1f, 272.1f)
                curveTo(224.2f, 274.3f, 225.1f, 276.3f, 226.7f, 277.8f)
                lineTo(338.7f, 381.8f)
                curveTo(341.6f, 384.5f, 346.1f, 384.7f, 349.2f, 382.1f)
                curveTo(352.3f, 379.5f, 353.0f, 375.1f, 350.9f, 371.7f)
                lineTo(290.5f, 273.6f)
                lineTo(381.2f, 198.0f)
                curveTo(383.8f, 195.9f, 384.7f, 192.3f, 383.6f, 189.2f)
                lineTo(360.4f, 124.6f)
                curveTo(383.6f, 106.3f, 412.6f, 96.0f, 442.9f, 96.0f)
                curveTo(516.4f, 96.0f, 576.0f, 155.6f, 576.0f, 229.1f)
                lineTo(576.0f, 231.7f)
                curveTo(576.0f, 343.9f, 436.1f, 474.2f, 363.1f, 529.9f)
                curveTo(350.7f, 539.3f, 335.5f, 544.0f, 320.0f, 544.0f)
                curveTo(304.5f, 544.0f, 289.2f, 539.4f, 276.9f, 529.9f)
                curveTo(203.9f, 474.2f, 64.0f, 343.9f, 64.0f, 231.7f)
                lineTo(64.0f, 229.1f)
                curveTo(64.0f, 155.6f, 123.6f, 96.0f, 197.1f, 96.0f)
                close()
            }
        }
        .build()
        return `_heart-crack`!!
    }

private var `_heart-crack`: ImageVector? = null
