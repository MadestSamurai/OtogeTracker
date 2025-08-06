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

public val Fa.`Paint-brush`: ImageVector
    get() {
        if (`_paint-brush` != null) {
            return `_paint-brush`!!
        }
        `_paint-brush` = Builder(name = "Paint-brush", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(512.5f, 74.3f)
                lineTo(291.1f, 222.0f)
                curveTo(262.0f, 241.4f, 243.5f, 272.9f, 240.5f, 307.3f)
                curveTo(302.8f, 320.1f, 351.9f, 369.2f, 364.8f, 431.6f)
                curveTo(399.3f, 428.6f, 430.7f, 410.1f, 450.1f, 381.0f)
                lineTo(597.7f, 159.5f)
                curveTo(604.4f, 149.4f, 608.0f, 137.6f, 608.0f, 125.4f)
                curveTo(608.0f, 91.5f, 580.5f, 64.0f, 546.6f, 64.0f)
                curveTo(534.5f, 64.0f, 522.6f, 67.6f, 512.5f, 74.3f)
                close()
                moveTo(320.0f, 464.0f)
                curveTo(320.0f, 402.1f, 269.9f, 352.0f, 208.0f, 352.0f)
                curveTo(146.1f, 352.0f, 96.0f, 402.1f, 96.0f, 464.0f)
                curveTo(96.0f, 467.9f, 96.2f, 471.8f, 96.6f, 475.6f)
                curveTo(98.4f, 493.1f, 86.4f, 512.0f, 68.8f, 512.0f)
                lineTo(64.0f, 512.0f)
                curveTo(46.3f, 512.0f, 32.0f, 526.3f, 32.0f, 544.0f)
                curveTo(32.0f, 561.7f, 46.3f, 576.0f, 64.0f, 576.0f)
                lineTo(208.0f, 576.0f)
                curveTo(269.9f, 576.0f, 320.0f, 525.9f, 320.0f, 464.0f)
                close()
            }
        }
        .build()
        return `_paint-brush`!!
    }

private var `_paint-brush`: ImageVector? = null
