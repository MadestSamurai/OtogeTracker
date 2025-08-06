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

public val Fa.`First-aid`: ImageVector
    get() {
        if (`_first-aid` != null) {
            return `_first-aid`!!
        }
        `_first-aid` = Builder(name = "First-aid", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(92.7f, 128.0f, 64.0f, 156.7f, 64.0f, 192.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                lineTo(144.0f, 512.0f)
                lineTo(144.0f, 128.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(192.0f, 128.0f)
                lineTo(192.0f, 512.0f)
                lineTo(448.0f, 512.0f)
                lineTo(448.0f, 128.0f)
                lineTo(192.0f, 128.0f)
                close()
                moveTo(512.0f, 512.0f)
                curveTo(547.3f, 512.0f, 576.0f, 483.3f, 576.0f, 448.0f)
                lineTo(576.0f, 192.0f)
                curveTo(576.0f, 156.7f, 547.3f, 128.0f, 512.0f, 128.0f)
                lineTo(496.0f, 128.0f)
                lineTo(496.0f, 512.0f)
                lineTo(512.0f, 512.0f)
                close()
                moveTo(288.0f, 248.0f)
                curveTo(288.0f, 239.2f, 295.2f, 232.0f, 304.0f, 232.0f)
                lineTo(336.0f, 232.0f)
                curveTo(344.8f, 232.0f, 352.0f, 239.2f, 352.0f, 248.0f)
                lineTo(352.0f, 288.0f)
                lineTo(392.0f, 288.0f)
                curveTo(400.8f, 288.0f, 408.0f, 295.2f, 408.0f, 304.0f)
                lineTo(408.0f, 336.0f)
                curveTo(408.0f, 344.8f, 400.8f, 352.0f, 392.0f, 352.0f)
                lineTo(352.0f, 352.0f)
                lineTo(352.0f, 392.0f)
                curveTo(352.0f, 400.8f, 344.8f, 408.0f, 336.0f, 408.0f)
                lineTo(304.0f, 408.0f)
                curveTo(295.2f, 408.0f, 288.0f, 400.8f, 288.0f, 392.0f)
                lineTo(288.0f, 352.0f)
                lineTo(248.0f, 352.0f)
                curveTo(239.2f, 352.0f, 232.0f, 344.8f, 232.0f, 336.0f)
                lineTo(232.0f, 304.0f)
                curveTo(232.0f, 295.2f, 239.2f, 288.0f, 248.0f, 288.0f)
                lineTo(288.0f, 288.0f)
                lineTo(288.0f, 248.0f)
                close()
            }
        }
        .build()
        return `_first-aid`!!
    }

private var `_first-aid`: ImageVector? = null
