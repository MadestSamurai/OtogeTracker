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

public val Fa.`Backward-fast`: ImageVector
    get() {
        if (`_backward-fast` != null) {
            return `_backward-fast`!!
        }
        `_backward-fast` = Builder(name = "Backward-fast", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(556.2f, 541.6f)
                curveTo(544.2f, 546.6f, 530.5f, 543.8f, 521.3f, 534.7f)
                lineTo(352.0f, 365.3f)
                lineTo(352.0f, 512.0f)
                curveTo(352.0f, 524.9f, 344.2f, 536.6f, 332.2f, 541.6f)
                curveTo(320.2f, 546.6f, 306.5f, 543.8f, 297.3f, 534.7f)
                lineTo(128.0f, 365.3f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 529.7f, 113.7f, 544.0f, 96.0f, 544.0f)
                curveTo(78.3f, 544.0f, 64.0f, 529.7f, 64.0f, 512.0f)
                lineTo(64.0f, 128.0f)
                curveTo(64.0f, 110.3f, 78.3f, 96.0f, 96.0f, 96.0f)
                curveTo(113.7f, 96.0f, 128.0f, 110.3f, 128.0f, 128.0f)
                lineTo(128.0f, 274.7f)
                lineTo(297.4f, 105.4f)
                curveTo(306.6f, 96.2f, 320.3f, 93.5f, 332.3f, 98.5f)
                curveTo(344.3f, 103.5f, 352.0f, 115.1f, 352.0f, 128.0f)
                lineTo(352.0f, 274.7f)
                lineTo(521.4f, 105.3f)
                curveTo(530.6f, 96.1f, 544.3f, 93.4f, 556.3f, 98.4f)
                curveTo(568.3f, 103.4f, 576.0f, 115.1f, 576.0f, 128.0f)
                lineTo(576.0f, 512.0f)
                curveTo(576.0f, 524.9f, 568.2f, 536.6f, 556.2f, 541.6f)
                close()
            }
        }
        .build()
        return `_backward-fast`!!
    }

private var `_backward-fast`: ImageVector? = null
