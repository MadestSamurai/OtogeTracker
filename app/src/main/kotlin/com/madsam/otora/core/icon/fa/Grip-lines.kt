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

public val Fa.`Grip-lines`: ImageVector
    get() {
        if (`_grip-lines` != null) {
            return `_grip-lines`!!
        }
        `_grip-lines` = Builder(name = "Grip-lines", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 352.0f)
                curveTo(110.3f, 352.0f, 96.0f, 366.3f, 96.0f, 384.0f)
                curveTo(96.0f, 401.7f, 110.3f, 416.0f, 128.0f, 416.0f)
                lineTo(512.0f, 416.0f)
                curveTo(529.7f, 416.0f, 544.0f, 401.7f, 544.0f, 384.0f)
                curveTo(544.0f, 366.3f, 529.7f, 352.0f, 512.0f, 352.0f)
                lineTo(128.0f, 352.0f)
                close()
                moveTo(128.0f, 224.0f)
                curveTo(110.3f, 224.0f, 96.0f, 238.3f, 96.0f, 256.0f)
                curveTo(96.0f, 273.7f, 110.3f, 288.0f, 128.0f, 288.0f)
                lineTo(512.0f, 288.0f)
                curveTo(529.7f, 288.0f, 544.0f, 273.7f, 544.0f, 256.0f)
                curveTo(544.0f, 238.3f, 529.7f, 224.0f, 512.0f, 224.0f)
                lineTo(128.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_grip-lines`!!
    }

private var `_grip-lines`: ImageVector? = null
