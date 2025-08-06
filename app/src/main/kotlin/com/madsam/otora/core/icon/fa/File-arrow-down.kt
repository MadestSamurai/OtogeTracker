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

public val Fa.`File-arrow-down`: ImageVector
    get() {
        if (`_file-arrow-down` != null) {
            return `_file-arrow-down`!!
        }
        `_file-arrow-down` = Builder(name = "File-arrow-down", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
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
                moveTo(303.0f, 505.0f)
                curveTo(312.4f, 514.4f, 327.6f, 514.4f, 336.9f, 505.0f)
                lineTo(400.9f, 441.0f)
                curveTo(410.3f, 431.6f, 410.3f, 416.4f, 400.9f, 407.1f)
                curveTo(391.5f, 397.8f, 376.3f, 397.7f, 367.0f, 407.1f)
                lineTo(344.0f, 430.1f)
                lineTo(344.0f, 344.0f)
                curveTo(344.0f, 330.7f, 333.3f, 320.0f, 320.0f, 320.0f)
                curveTo(306.7f, 320.0f, 296.0f, 330.7f, 296.0f, 344.0f)
                lineTo(296.0f, 430.1f)
                lineTo(273.0f, 407.1f)
                curveTo(263.6f, 397.7f, 248.4f, 397.7f, 239.1f, 407.1f)
                curveTo(229.8f, 416.5f, 229.7f, 431.7f, 239.1f, 441.0f)
                lineTo(303.1f, 505.0f)
                close()
            }
        }
        .build()
        return `_file-arrow-down`!!
    }

private var `_file-arrow-down`: ImageVector? = null
