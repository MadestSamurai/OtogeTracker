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

public val Fa.`Lines-leaning`: ImageVector
    get() {
        if (`_lines-leaning` != null) {
            return `_lines-leaning`!!
        }
        `_lines-leaning` = Builder(name = "Lines-leaning", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(318.4f, 138.1f)
                curveTo(324.0f, 121.3f, 314.9f, 103.2f, 298.2f, 97.6f)
                curveTo(281.5f, 92.0f, 263.3f, 101.1f, 257.7f, 117.8f)
                lineTo(129.7f, 501.8f)
                curveTo(124.1f, 518.6f, 133.2f, 536.7f, 149.9f, 542.3f)
                curveTo(166.6f, 547.9f, 184.8f, 538.8f, 190.4f, 522.1f)
                lineTo(318.4f, 138.1f)
                close()
                moveTo(389.3f, 96.4f)
                curveTo(371.9f, 93.5f, 355.4f, 105.3f, 352.5f, 122.7f)
                lineTo(288.5f, 506.7f)
                curveTo(285.6f, 524.1f, 297.4f, 540.6f, 314.8f, 543.5f)
                curveTo(332.2f, 546.4f, 348.7f, 534.6f, 351.6f, 517.2f)
                lineTo(415.6f, 133.2f)
                curveTo(418.5f, 115.8f, 406.7f, 99.3f, 389.3f, 96.4f)
                close()
                moveTo(480.0f, 96.0f)
                curveTo(462.3f, 96.0f, 448.0f, 110.3f, 448.0f, 128.0f)
                lineTo(448.0f, 512.0f)
                curveTo(448.0f, 529.7f, 462.3f, 544.0f, 480.0f, 544.0f)
                curveTo(497.7f, 544.0f, 512.0f, 529.7f, 512.0f, 512.0f)
                lineTo(512.0f, 128.0f)
                curveTo(512.0f, 110.3f, 497.7f, 96.0f, 480.0f, 96.0f)
                close()
            }
        }
        .build()
        return `_lines-leaning`!!
    }

private var `_lines-leaning`: ImageVector? = null
