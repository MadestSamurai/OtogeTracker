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

public val Fa.`Circle-pause`: ImageVector
    get() {
        if (`_circle-pause` != null) {
            return `_circle-pause`!!
        }
        `_circle-pause` = Builder(name = "Circle-pause", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(288.0f, 256.0f)
                lineTo(288.0f, 384.0f)
                curveTo(288.0f, 401.7f, 273.7f, 416.0f, 256.0f, 416.0f)
                curveTo(238.3f, 416.0f, 224.0f, 401.7f, 224.0f, 384.0f)
                lineTo(224.0f, 256.0f)
                curveTo(224.0f, 238.3f, 238.3f, 224.0f, 256.0f, 224.0f)
                curveTo(273.7f, 224.0f, 288.0f, 238.3f, 288.0f, 256.0f)
                close()
                moveTo(416.0f, 256.0f)
                lineTo(416.0f, 384.0f)
                curveTo(416.0f, 401.7f, 401.7f, 416.0f, 384.0f, 416.0f)
                curveTo(366.3f, 416.0f, 352.0f, 401.7f, 352.0f, 384.0f)
                lineTo(352.0f, 256.0f)
                curveTo(352.0f, 238.3f, 366.3f, 224.0f, 384.0f, 224.0f)
                curveTo(401.7f, 224.0f, 416.0f, 238.3f, 416.0f, 256.0f)
                close()
            }
        }
        .build()
        return `_circle-pause`!!
    }

private var `_circle-pause`: ImageVector? = null
