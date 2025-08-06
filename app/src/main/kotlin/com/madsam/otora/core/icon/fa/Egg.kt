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

public val Fa.Egg: ImageVector
    get() {
        if (_egg != null) {
            return _egg!!
        }
        _egg = Builder(name = "Egg", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 560.0f)
                curveTo(214.0f, 560.0f, 128.0f, 458.0f, 128.0f, 352.0f)
                curveTo(128.0f, 240.0f, 192.0f, 80.0f, 320.0f, 80.0f)
                curveTo(448.0f, 80.0f, 512.0f, 240.0f, 512.0f, 352.0f)
                curveTo(512.0f, 458.0f, 426.0f, 560.0f, 320.0f, 560.0f)
                close()
                moveTo(282.8f, 198.0f)
                curveTo(289.3f, 192.0f, 289.8f, 181.9f, 283.8f, 175.4f)
                curveTo(277.8f, 168.9f, 267.7f, 168.4f, 261.2f, 174.4f)
                curveTo(237.3f, 196.2f, 220.1f, 227.1f, 208.9f, 258.6f)
                curveTo(197.7f, 290.2f, 192.0f, 323.7f, 192.0f, 352.1f)
                curveTo(192.0f, 360.9f, 199.2f, 368.1f, 208.0f, 368.1f)
                curveTo(216.8f, 368.1f, 224.0f, 360.9f, 224.0f, 352.1f)
                curveTo(224.0f, 327.6f, 229.0f, 297.7f, 239.1f, 269.3f)
                curveTo(249.2f, 240.8f, 264.1f, 215.2f, 282.8f, 198.1f)
                close()
            }
        }
        .build()
        return _egg!!
    }

private var _egg: ImageVector? = null
