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

public val Fa.`Text-slash`: ImageVector
    get() {
        if (`_text-slash` != null) {
            return `_text-slash`!!
        }
        `_text-slash` = Builder(name = "Text-slash", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(354.7f, 320.9f)
                lineTo(400.2f, 160.0f)
                lineTo(503.0f, 160.0f)
                lineTo(497.0f, 184.2f)
                curveTo(492.7f, 201.3f, 503.1f, 218.7f, 520.3f, 223.0f)
                curveTo(537.5f, 227.3f, 554.8f, 216.9f, 559.1f, 199.7f)
                lineTo(570.1f, 155.6f)
                curveTo(577.6f, 125.3f, 554.7f, 96.0f, 523.5f, 96.0f)
                lineTo(204.5f, 96.0f)
                curveTo(184.7f, 96.0f, 167.2f, 108.1f, 160.0f, 126.1f)
                lineTo(73.0f, 39.1f)
                close()
                moveTo(212.4f, 178.5f)
                lineTo(217.0f, 160.0f)
                lineTo(333.7f, 160.0f)
                lineTo(302.9f, 269.0f)
                lineTo(212.4f, 178.5f)
                close()
                moveTo(273.0f, 374.8f)
                lineTo(243.3f, 480.0f)
                lineTo(192.0f, 480.0f)
                curveTo(174.3f, 480.0f, 160.0f, 494.3f, 160.0f, 512.0f)
                curveTo(160.0f, 529.7f, 174.3f, 544.0f, 192.0f, 544.0f)
                lineTo(352.0f, 544.0f)
                curveTo(369.7f, 544.0f, 384.0f, 529.7f, 384.0f, 512.0f)
                curveTo(384.0f, 494.3f, 369.7f, 480.0f, 352.0f, 480.0f)
                lineTo(309.8f, 480.0f)
                lineTo(324.9f, 426.7f)
                lineTo(273.0f, 374.8f)
                close()
            }
        }
        .build()
        return `_text-slash`!!
    }

private var `_text-slash`: ImageVector? = null
