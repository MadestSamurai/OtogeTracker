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

public val Fa.T: ImageVector
    get() {
        if (_t != null) {
            return _t!!
        }
        _t = Builder(name = "T", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(142.3f, 96.0f, 128.0f, 110.3f, 128.0f, 128.0f)
                curveTo(128.0f, 145.7f, 142.3f, 160.0f, 160.0f, 160.0f)
                lineTo(288.0f, 160.0f)
                lineTo(288.0f, 512.0f)
                curveTo(288.0f, 529.7f, 302.3f, 544.0f, 320.0f, 544.0f)
                curveTo(337.7f, 544.0f, 352.0f, 529.7f, 352.0f, 512.0f)
                lineTo(352.0f, 160.0f)
                lineTo(480.0f, 160.0f)
                curveTo(497.7f, 160.0f, 512.0f, 145.7f, 512.0f, 128.0f)
                curveTo(512.0f, 110.3f, 497.7f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                close()
            }
        }
        .build()
        return _t!!
    }

private var _t: ImageVector? = null
