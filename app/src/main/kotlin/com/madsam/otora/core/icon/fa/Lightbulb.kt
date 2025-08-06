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

public val Fa.Lightbulb: ImageVector
    get() {
        if (_lightbulb != null) {
            return _lightbulb!!
        }
        _lightbulb = Builder(name = "Lightbulb", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(420.9f, 448.0f)
                curveTo(428.2f, 425.7f, 442.8f, 405.5f, 459.3f, 388.1f)
                curveTo(492.0f, 353.7f, 512.0f, 307.2f, 512.0f, 256.0f)
                curveTo(512.0f, 150.0f, 426.0f, 64.0f, 320.0f, 64.0f)
                curveTo(214.0f, 64.0f, 128.0f, 150.0f, 128.0f, 256.0f)
                curveTo(128.0f, 307.2f, 148.0f, 353.7f, 180.7f, 388.1f)
                curveTo(197.2f, 405.5f, 211.9f, 425.7f, 219.1f, 448.0f)
                lineTo(420.8f, 448.0f)
                close()
                moveTo(416.0f, 496.0f)
                lineTo(224.0f, 496.0f)
                lineTo(224.0f, 512.0f)
                curveTo(224.0f, 556.2f, 259.8f, 592.0f, 304.0f, 592.0f)
                lineTo(336.0f, 592.0f)
                curveTo(380.2f, 592.0f, 416.0f, 556.2f, 416.0f, 512.0f)
                lineTo(416.0f, 496.0f)
                close()
                moveTo(312.0f, 176.0f)
                curveTo(272.2f, 176.0f, 240.0f, 208.2f, 240.0f, 248.0f)
                curveTo(240.0f, 261.3f, 229.3f, 272.0f, 216.0f, 272.0f)
                curveTo(202.7f, 272.0f, 192.0f, 261.3f, 192.0f, 248.0f)
                curveTo(192.0f, 181.7f, 245.7f, 128.0f, 312.0f, 128.0f)
                curveTo(325.3f, 128.0f, 336.0f, 138.7f, 336.0f, 152.0f)
                curveTo(336.0f, 165.3f, 325.3f, 176.0f, 312.0f, 176.0f)
                close()
            }
        }
        .build()
        return _lightbulb!!
    }

private var _lightbulb: ImageVector? = null
