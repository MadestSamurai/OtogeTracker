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

public val Fa._4: ImageVector
    get() {
        if (__4 != null) {
            return __4!!
        }
        __4 = Builder(name = "_4", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth
                = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 128.0f)
                curveTo(192.0f, 110.3f, 177.7f, 96.0f, 160.0f, 96.0f)
                curveTo(142.3f, 96.0f, 128.0f, 110.3f, 128.0f, 128.0f)
                lineTo(128.0f, 352.0f)
                curveTo(128.0f, 387.3f, 156.7f, 416.0f, 192.0f, 416.0f)
                lineTo(384.0f, 416.0f)
                lineTo(384.0f, 512.0f)
                curveTo(384.0f, 529.7f, 398.3f, 544.0f, 416.0f, 544.0f)
                curveTo(433.7f, 544.0f, 448.0f, 529.7f, 448.0f, 512.0f)
                lineTo(448.0f, 416.0f)
                lineTo(480.0f, 416.0f)
                curveTo(497.7f, 416.0f, 512.0f, 401.7f, 512.0f, 384.0f)
                curveTo(512.0f, 366.3f, 497.7f, 352.0f, 480.0f, 352.0f)
                lineTo(448.0f, 352.0f)
                lineTo(448.0f, 128.0f)
                curveTo(448.0f, 110.3f, 433.7f, 96.0f, 416.0f, 96.0f)
                curveTo(398.3f, 96.0f, 384.0f, 110.3f, 384.0f, 128.0f)
                lineTo(384.0f, 352.0f)
                lineTo(192.0f, 352.0f)
                lineTo(192.0f, 128.0f)
                close()
            }
        }
        .build()
        return __4!!
    }

private var __4: ImageVector? = null
