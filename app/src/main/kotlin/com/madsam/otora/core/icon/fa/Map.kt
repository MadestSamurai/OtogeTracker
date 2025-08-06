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

public val Fa.Map: ImageVector
    get() {
        if (_map != null) {
            return _map!!
        }
        _map = Builder(name = "Map", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 112.0f)
                curveTo(576.0f, 100.9f, 570.3f, 90.6f, 560.8f, 84.8f)
                curveTo(551.3f, 79.0f, 539.6f, 78.4f, 529.7f, 83.4f)
                lineTo(413.5f, 141.5f)
                lineTo(234.1f, 81.6f)
                curveTo(226.0f, 78.9f, 217.3f, 79.5f, 209.7f, 83.3f)
                lineTo(81.7f, 147.3f)
                curveTo(70.8f, 152.8f, 64.0f, 163.9f, 64.0f, 176.0f)
                lineTo(64.0f, 528.0f)
                curveTo(64.0f, 539.1f, 69.7f, 549.4f, 79.2f, 555.2f)
                curveTo(88.7f, 561.0f, 100.4f, 561.6f, 110.3f, 556.6f)
                lineTo(226.4f, 498.5f)
                lineTo(405.8f, 558.3f)
                curveTo(413.9f, 561.0f, 422.6f, 560.4f, 430.2f, 556.6f)
                lineTo(558.2f, 492.6f)
                curveTo(569.0f, 487.2f, 575.9f, 476.1f, 575.9f, 464.0f)
                lineTo(575.9f, 112.0f)
                close()
                moveTo(256.0f, 440.9f)
                lineTo(256.0f, 156.4f)
                lineTo(384.0f, 199.1f)
                lineTo(384.0f, 483.6f)
                lineTo(256.0f, 440.9f)
                close()
            }
        }
        .build()
        return _map!!
    }

private var _map: ImageVector? = null
