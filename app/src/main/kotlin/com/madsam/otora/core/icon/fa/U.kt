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

public val Fa.U: ImageVector
    get() {
        if (_u != null) {
            return _u!!
        }
        _u = Builder(name = "U", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(177.7f, 96.0f, 192.0f, 110.3f, 192.0f, 128.0f)
                lineTo(192.0f, 352.0f)
                curveTo(192.0f, 422.7f, 249.3f, 480.0f, 320.0f, 480.0f)
                curveTo(390.7f, 480.0f, 448.0f, 422.7f, 448.0f, 352.0f)
                lineTo(448.0f, 128.0f)
                curveTo(448.0f, 110.3f, 462.3f, 96.0f, 480.0f, 96.0f)
                curveTo(497.7f, 96.0f, 512.0f, 110.3f, 512.0f, 128.0f)
                lineTo(512.0f, 352.0f)
                curveTo(512.0f, 458.0f, 426.0f, 544.0f, 320.0f, 544.0f)
                curveTo(214.0f, 544.0f, 128.0f, 458.0f, 128.0f, 352.0f)
                lineTo(128.0f, 128.0f)
                curveTo(128.0f, 110.3f, 142.3f, 96.0f, 160.0f, 96.0f)
                close()
            }
        }
        .build()
        return _u!!
    }

private var _u: ImageVector? = null
