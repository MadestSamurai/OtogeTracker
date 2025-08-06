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

public val Fa.`Face-flushed`: ImageVector
    get() {
        if (`_face-flushed` != null) {
            return `_face-flushed`!!
        }
        `_face-flushed` = Builder(name = "Face-flushed", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
                moveTo(232.0f, 456.0f)
                curveTo(232.0f, 469.3f, 242.7f, 480.0f, 256.0f, 480.0f)
                lineTo(384.0f, 480.0f)
                curveTo(397.3f, 480.0f, 408.0f, 469.3f, 408.0f, 456.0f)
                curveTo(408.0f, 442.7f, 397.3f, 432.0f, 384.0f, 432.0f)
                lineTo(256.0f, 432.0f)
                curveTo(242.7f, 432.0f, 232.0f, 442.7f, 232.0f, 456.0f)
                close()
                moveTo(224.0f, 360.0f)
                curveTo(263.8f, 360.0f, 296.0f, 327.8f, 296.0f, 288.0f)
                curveTo(296.0f, 248.2f, 263.8f, 216.0f, 224.0f, 216.0f)
                curveTo(184.2f, 216.0f, 152.0f, 248.2f, 152.0f, 288.0f)
                curveTo(152.0f, 327.8f, 184.2f, 360.0f, 224.0f, 360.0f)
                close()
                moveTo(488.0f, 288.0f)
                curveTo(488.0f, 248.2f, 455.8f, 216.0f, 416.0f, 216.0f)
                curveTo(376.2f, 216.0f, 344.0f, 248.2f, 344.0f, 288.0f)
                curveTo(344.0f, 327.8f, 376.2f, 360.0f, 416.0f, 360.0f)
                curveTo(455.8f, 360.0f, 488.0f, 327.8f, 488.0f, 288.0f)
                close()
                moveTo(200.0f, 288.0f)
                curveTo(200.0f, 274.7f, 210.7f, 264.0f, 224.0f, 264.0f)
                curveTo(237.3f, 264.0f, 248.0f, 274.7f, 248.0f, 288.0f)
                curveTo(248.0f, 301.3f, 237.3f, 312.0f, 224.0f, 312.0f)
                curveTo(210.7f, 312.0f, 200.0f, 301.3f, 200.0f, 288.0f)
                close()
                moveTo(392.0f, 288.0f)
                curveTo(392.0f, 274.7f, 402.7f, 264.0f, 416.0f, 264.0f)
                curveTo(429.3f, 264.0f, 440.0f, 274.7f, 440.0f, 288.0f)
                curveTo(440.0f, 301.3f, 429.3f, 312.0f, 416.0f, 312.0f)
                curveTo(402.7f, 312.0f, 392.0f, 301.3f, 392.0f, 288.0f)
                close()
            }
        }
        .build()
        return `_face-flushed`!!
    }

private var `_face-flushed`: ImageVector? = null
