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

public val Fa.Save: ImageVector
    get() {
        if (_save != null) {
            return _save!!
        }
        _save = Builder(name = "Save", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 237.3f)
                curveTo(544.0f, 220.3f, 537.3f, 204.0f, 525.3f, 192.0f)
                lineTo(448.0f, 114.7f)
                curveTo(436.0f, 102.7f, 419.7f, 96.0f, 402.7f, 96.0f)
                lineTo(160.0f, 96.0f)
                close()
                moveTo(192.0f, 192.0f)
                curveTo(192.0f, 174.3f, 206.3f, 160.0f, 224.0f, 160.0f)
                lineTo(384.0f, 160.0f)
                curveTo(401.7f, 160.0f, 416.0f, 174.3f, 416.0f, 192.0f)
                lineTo(416.0f, 256.0f)
                curveTo(416.0f, 273.7f, 401.7f, 288.0f, 384.0f, 288.0f)
                lineTo(224.0f, 288.0f)
                curveTo(206.3f, 288.0f, 192.0f, 273.7f, 192.0f, 256.0f)
                lineTo(192.0f, 192.0f)
                close()
                moveTo(320.0f, 352.0f)
                curveTo(355.3f, 352.0f, 384.0f, 380.7f, 384.0f, 416.0f)
                curveTo(384.0f, 451.3f, 355.3f, 480.0f, 320.0f, 480.0f)
                curveTo(284.7f, 480.0f, 256.0f, 451.3f, 256.0f, 416.0f)
                curveTo(256.0f, 380.7f, 284.7f, 352.0f, 320.0f, 352.0f)
                close()
            }
        }
        .build()
        return _save!!
    }

private var _save: ImageVector? = null
