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

public val Fa.`Mug-saucer`: ImageVector
    get() {
        if (`_mug-saucer` != null) {
            return `_mug-saucer`!!
        }
        `_mug-saucer` = Builder(name = "Mug-saucer", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 128.0f)
                curveTo(96.0f, 110.3f, 110.3f, 96.0f, 128.0f, 96.0f)
                lineTo(480.0f, 96.0f)
                curveTo(550.7f, 96.0f, 608.0f, 153.3f, 608.0f, 224.0f)
                curveTo(608.0f, 294.7f, 550.7f, 352.0f, 480.0f, 352.0f)
                curveTo(480.0f, 405.0f, 437.0f, 448.0f, 384.0f, 448.0f)
                lineTo(192.0f, 448.0f)
                curveTo(139.0f, 448.0f, 96.0f, 405.0f, 96.0f, 352.0f)
                lineTo(96.0f, 128.0f)
                close()
                moveTo(544.0f, 224.0f)
                curveTo(544.0f, 188.7f, 515.3f, 160.0f, 480.0f, 160.0f)
                lineTo(480.0f, 288.0f)
                curveTo(515.3f, 288.0f, 544.0f, 259.3f, 544.0f, 224.0f)
                close()
                moveTo(96.0f, 512.0f)
                lineTo(480.0f, 512.0f)
                curveTo(497.7f, 512.0f, 512.0f, 526.3f, 512.0f, 544.0f)
                curveTo(512.0f, 561.7f, 497.7f, 576.0f, 480.0f, 576.0f)
                lineTo(96.0f, 576.0f)
                curveTo(78.3f, 576.0f, 64.0f, 561.7f, 64.0f, 544.0f)
                curveTo(64.0f, 526.3f, 78.3f, 512.0f, 96.0f, 512.0f)
                close()
            }
        }
        .build()
        return `_mug-saucer`!!
    }

private var `_mug-saucer`: ImageVector? = null
