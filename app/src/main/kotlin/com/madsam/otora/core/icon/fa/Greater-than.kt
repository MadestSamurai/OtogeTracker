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

public val Fa.`Greater-than`: ImageVector
    get() {
        if (`_greater-than` != null) {
            return `_greater-than`!!
        }
        `_greater-than` = Builder(name = "Greater-than", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(98.9f, 114.6f)
                curveTo(91.5f, 130.6f, 98.5f, 149.7f, 114.5f, 157.1f)
                lineTo(467.6f, 320.0f)
                lineTo(114.6f, 483.0f)
                curveTo(98.6f, 490.4f, 91.5f, 509.4f, 99.0f, 525.5f)
                curveTo(106.5f, 541.6f, 125.4f, 548.5f, 141.5f, 541.1f)
                lineTo(557.5f, 349.1f)
                curveTo(568.8f, 343.9f, 576.1f, 332.5f, 576.1f, 320.0f)
                curveTo(576.1f, 307.5f, 568.8f, 296.2f, 557.5f, 290.9f)
                lineTo(141.4f, 99.0f)
                curveTo(125.4f, 91.6f, 106.3f, 98.6f, 98.9f, 114.6f)
                close()
            }
        }
        .build()
        return `_greater-than`!!
    }

private var `_greater-than`: ImageVector? = null
