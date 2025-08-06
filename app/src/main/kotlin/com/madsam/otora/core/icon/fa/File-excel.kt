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

public val Fa.`File-excel`: ImageVector
    get() {
        if (`_file-excel` != null) {
            return `_file-excel`!!
        }
        `_file-excel` = Builder(name = "File-excel", defaultWidth = 640.0.dp, defaultHeight =
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
                moveTo(292.0f, 330.7f)
                curveTo(284.6f, 319.7f, 269.7f, 316.7f, 258.7f, 324.0f)
                curveTo(247.7f, 331.3f, 244.7f, 346.3f, 252.0f, 357.3f)
                lineTo(291.2f, 416.0f)
                lineTo(252.0f, 474.7f)
                curveTo(244.6f, 485.7f, 247.6f, 500.6f, 258.7f, 508.0f)
                curveTo(269.8f, 515.4f, 284.6f, 512.4f, 292.0f, 501.3f)
                lineTo(320.0f, 459.3f)
                lineTo(348.0f, 501.3f)
                curveTo(355.4f, 512.3f, 370.3f, 515.3f, 381.3f, 508.0f)
                curveTo(392.3f, 500.7f, 395.3f, 485.7f, 388.0f, 474.7f)
                lineTo(348.8f, 416.0f)
                lineTo(388.0f, 357.3f)
                curveTo(395.4f, 346.3f, 392.4f, 331.4f, 381.3f, 324.0f)
                curveTo(370.2f, 316.6f, 355.4f, 319.6f, 348.0f, 330.7f)
                lineTo(320.0f, 372.7f)
                lineTo(292.0f, 330.7f)
                close()
            }
        }
        .build()
        return `_file-excel`!!
    }

private var `_file-excel`: ImageVector? = null
