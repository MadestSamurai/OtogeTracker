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

public val Fa.`File-import`: ImageVector
    get() {
        if (`_file-import` != null) {
            return `_file-import`!!
        }
        `_file-import` = Builder(name = "File-import", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 64.0f)
                curveTo(156.7f, 64.0f, 128.0f, 92.7f, 128.0f, 128.0f)
                lineTo(128.0f, 368.0f)
                lineTo(310.1f, 368.0f)
                lineTo(279.1f, 337.0f)
                curveTo(269.7f, 327.6f, 269.7f, 312.4f, 279.1f, 303.1f)
                curveTo(288.5f, 293.8f, 303.7f, 293.7f, 313.0f, 303.1f)
                lineTo(385.0f, 375.1f)
                curveTo(394.4f, 384.5f, 394.4f, 399.7f, 385.0f, 409.0f)
                lineTo(313.0f, 481.0f)
                curveTo(303.6f, 490.4f, 288.4f, 490.4f, 279.1f, 481.0f)
                curveTo(269.8f, 471.6f, 269.7f, 456.4f, 279.1f, 447.1f)
                lineTo(310.1f, 416.1f)
                lineTo(128.0f, 416.1f)
                lineTo(128.0f, 512.1f)
                curveTo(128.0f, 547.4f, 156.7f, 576.1f, 192.0f, 576.1f)
                lineTo(448.0f, 576.1f)
                curveTo(483.3f, 576.1f, 512.0f, 547.4f, 512.0f, 512.1f)
                lineTo(512.0f, 234.6f)
                curveTo(512.0f, 217.6f, 505.3f, 201.3f, 493.3f, 189.3f)
                lineTo(386.7f, 82.7f)
                curveTo(374.7f, 70.7f, 358.5f, 64.0f, 341.5f, 64.0f)
                lineTo(192.0f, 64.0f)
                close()
                moveTo(453.5f, 240.0f)
                lineTo(360.0f, 240.0f)
                curveTo(346.7f, 240.0f, 336.0f, 229.3f, 336.0f, 216.0f)
                lineTo(336.0f, 122.5f)
                lineTo(453.5f, 240.0f)
                close()
            }
        }
        .build()
        return `_file-import`!!
    }

private var `_file-import`: ImageVector? = null
