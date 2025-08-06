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

public val Fa.`Toilet-paper-alt`: ImageVector
    get() {
        if (`_toilet-paper-alt` != null) {
            return `_toilet-paper-alt`!!
        }
        `_toilet-paper-alt` = Builder(name = "Toilet-paper-alt", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(391.1f, 96.0f)
                curveTo(382.3f, 107.1f, 375.1f, 119.1f, 369.2f, 130.8f)
                curveTo(347.8f, 173.5f, 336.0f, 229.2f, 336.0f, 288.0f)
                lineTo(336.0f, 552.0f)
                curveTo(336.0f, 582.9f, 310.9f, 608.0f, 280.0f, 608.0f)
                lineTo(120.0f, 608.0f)
                curveTo(89.1f, 608.0f, 64.0f, 582.9f, 64.0f, 552.0f)
                lineTo(64.0f, 288.0f)
                curveTo(64.0f, 182.0f, 107.0f, 96.0f, 160.0f, 96.0f)
                lineTo(391.1f, 96.0f)
                close()
                moveTo(480.0f, 480.0f)
                curveTo(427.0f, 480.0f, 384.0f, 394.0f, 384.0f, 288.0f)
                curveTo(384.0f, 182.0f, 427.0f, 96.0f, 480.0f, 96.0f)
                curveTo(533.0f, 96.0f, 576.0f, 182.0f, 576.0f, 288.0f)
                curveTo(576.0f, 394.0f, 533.0f, 480.0f, 480.0f, 480.0f)
                close()
                moveTo(480.0f, 352.0f)
                curveTo(497.7f, 352.0f, 512.0f, 323.3f, 512.0f, 288.0f)
                curveTo(512.0f, 252.7f, 497.7f, 224.0f, 480.0f, 224.0f)
                curveTo(462.3f, 224.0f, 448.0f, 252.7f, 448.0f, 288.0f)
                curveTo(448.0f, 323.3f, 462.3f, 352.0f, 480.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_toilet-paper-alt`!!
    }

private var `_toilet-paper-alt`: ImageVector? = null
