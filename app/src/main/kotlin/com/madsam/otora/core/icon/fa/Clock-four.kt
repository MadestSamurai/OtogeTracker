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

public val Fa.`Clock-four`: ImageVector
    get() {
        if (`_clock-four` != null) {
            return `_clock-four`!!
        }
        `_clock-four` = Builder(name = "Clock-four", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(296.0f, 184.0f)
                lineTo(296.0f, 320.0f)
                curveTo(296.0f, 328.0f, 300.0f, 335.5f, 306.7f, 340.0f)
                lineTo(402.7f, 404.0f)
                curveTo(413.7f, 411.4f, 428.6f, 408.4f, 436.0f, 397.3f)
                curveTo(443.4f, 386.2f, 440.4f, 371.4f, 429.3f, 364.0f)
                lineTo(344.0f, 307.2f)
                lineTo(344.0f, 184.0f)
                curveTo(344.0f, 170.7f, 333.3f, 160.0f, 320.0f, 160.0f)
                curveTo(306.7f, 160.0f, 296.0f, 170.7f, 296.0f, 184.0f)
                close()
            }
        }
        .build()
        return `_clock-four`!!
    }

private var `_clock-four`: ImageVector? = null
