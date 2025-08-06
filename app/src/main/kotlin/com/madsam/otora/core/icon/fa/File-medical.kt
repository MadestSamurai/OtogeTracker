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

public val Fa.`File-medical`: ImageVector
    get() {
        if (`_file-medical` != null) {
            return `_file-medical`!!
        }
        `_file-medical` = Builder(name = "File-medical", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(128.0f, 92.7f, 156.7f, 64.0f, 192.0f, 64.0f)
                lineTo(341.5f, 64.0f)
                curveTo(358.5f, 64.0f, 374.8f, 70.7f, 386.8f, 82.7f)
                lineTo(493.3f, 189.3f)
                curveTo(505.3f, 201.3f, 512.0f, 217.6f, 512.0f, 234.6f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 547.3f, 483.3f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(156.7f, 576.0f, 128.0f, 547.3f, 128.0f, 512.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(336.0f, 122.5f)
                lineTo(336.0f, 216.0f)
                curveTo(336.0f, 229.3f, 346.7f, 240.0f, 360.0f, 240.0f)
                lineTo(453.5f, 240.0f)
                lineTo(336.0f, 122.5f)
                close()
                moveTo(288.0f, 344.0f)
                lineTo(288.0f, 384.0f)
                lineTo(248.0f, 384.0f)
                curveTo(239.2f, 384.0f, 232.0f, 391.2f, 232.0f, 400.0f)
                lineTo(232.0f, 432.0f)
                curveTo(232.0f, 440.8f, 239.2f, 448.0f, 248.0f, 448.0f)
                lineTo(288.0f, 448.0f)
                lineTo(288.0f, 488.0f)
                curveTo(288.0f, 496.8f, 295.2f, 504.0f, 304.0f, 504.0f)
                lineTo(336.0f, 504.0f)
                curveTo(344.8f, 504.0f, 352.0f, 496.8f, 352.0f, 488.0f)
                lineTo(352.0f, 448.0f)
                lineTo(392.0f, 448.0f)
                curveTo(400.8f, 448.0f, 408.0f, 440.8f, 408.0f, 432.0f)
                lineTo(408.0f, 400.0f)
                curveTo(408.0f, 391.2f, 400.8f, 384.0f, 392.0f, 384.0f)
                lineTo(352.0f, 384.0f)
                lineTo(352.0f, 344.0f)
                curveTo(352.0f, 335.2f, 344.8f, 328.0f, 336.0f, 328.0f)
                lineTo(304.0f, 328.0f)
                curveTo(295.2f, 328.0f, 288.0f, 335.2f, 288.0f, 344.0f)
                close()
            }
        }
        .build()
        return `_file-medical`!!
    }

private var `_file-medical`: ImageVector? = null
