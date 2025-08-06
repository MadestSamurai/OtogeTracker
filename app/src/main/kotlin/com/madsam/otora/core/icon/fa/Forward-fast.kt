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

public val Fa.`Forward-fast`: ImageVector
    get() {
        if (`_forward-fast` != null) {
            return `_forward-fast`!!
        }
        `_forward-fast` = Builder(name = "Forward-fast", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(83.8f, 541.6f)
                curveTo(95.8f, 546.6f, 109.5f, 543.8f, 118.7f, 534.7f)
                lineTo(288.0f, 365.3f)
                lineTo(288.0f, 512.0f)
                curveTo(288.0f, 524.9f, 295.8f, 536.6f, 307.8f, 541.6f)
                curveTo(319.8f, 546.6f, 333.5f, 543.8f, 342.7f, 534.7f)
                lineTo(512.0f, 365.3f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 529.7f, 526.3f, 544.0f, 544.0f, 544.0f)
                curveTo(561.7f, 544.0f, 576.0f, 529.7f, 576.0f, 512.0f)
                lineTo(576.0f, 128.0f)
                curveTo(576.0f, 110.3f, 561.7f, 96.0f, 544.0f, 96.0f)
                curveTo(526.3f, 96.0f, 512.0f, 110.3f, 512.0f, 128.0f)
                lineTo(512.0f, 274.7f)
                lineTo(342.6f, 105.3f)
                curveTo(333.4f, 96.1f, 319.7f, 93.4f, 307.7f, 98.4f)
                curveTo(295.7f, 103.4f, 288.0f, 115.1f, 288.0f, 128.0f)
                lineTo(288.0f, 274.7f)
                lineTo(118.6f, 105.4f)
                curveTo(109.4f, 96.2f, 95.7f, 93.5f, 83.7f, 98.5f)
                curveTo(71.7f, 103.5f, 64.0f, 115.1f, 64.0f, 128.0f)
                lineTo(64.0f, 512.0f)
                curveTo(64.0f, 524.9f, 71.8f, 536.6f, 83.8f, 541.6f)
                close()
            }
        }
        .build()
        return `_forward-fast`!!
    }

private var `_forward-fast`: ImageVector? = null
