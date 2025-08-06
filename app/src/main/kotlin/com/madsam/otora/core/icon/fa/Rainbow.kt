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

public val Fa.Rainbow: ImageVector
    get() {
        if (_rainbow != null) {
            return _rainbow!!
        }
        _rainbow = Builder(name = "Rainbow", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 160.0f)
                curveTo(178.6f, 160.0f, 64.0f, 274.6f, 64.0f, 416.0f)
                lineTo(64.0f, 480.0f)
                curveTo(64.0f, 497.7f, 49.7f, 512.0f, 32.0f, 512.0f)
                curveTo(14.3f, 512.0f, 0.0f, 497.7f, 0.0f, 480.0f)
                lineTo(0.0f, 416.0f)
                curveTo(0.0f, 239.3f, 143.3f, 96.0f, 320.0f, 96.0f)
                curveTo(496.7f, 96.0f, 640.0f, 239.3f, 640.0f, 416.0f)
                lineTo(640.0f, 480.0f)
                curveTo(640.0f, 497.7f, 625.7f, 512.0f, 608.0f, 512.0f)
                curveTo(590.3f, 512.0f, 576.0f, 497.7f, 576.0f, 480.0f)
                lineTo(576.0f, 416.0f)
                curveTo(576.0f, 274.6f, 461.4f, 160.0f, 320.0f, 160.0f)
                close()
                moveTo(320.0f, 272.0f)
                curveTo(240.5f, 272.0f, 176.0f, 336.5f, 176.0f, 416.0f)
                lineTo(176.0f, 480.0f)
                curveTo(176.0f, 497.7f, 161.7f, 512.0f, 144.0f, 512.0f)
                curveTo(126.3f, 512.0f, 112.0f, 497.7f, 112.0f, 480.0f)
                lineTo(112.0f, 416.0f)
                curveTo(112.0f, 301.1f, 205.1f, 208.0f, 320.0f, 208.0f)
                curveTo(434.9f, 208.0f, 528.0f, 301.1f, 528.0f, 416.0f)
                lineTo(528.0f, 480.0f)
                curveTo(528.0f, 497.7f, 513.7f, 512.0f, 496.0f, 512.0f)
                curveTo(478.3f, 512.0f, 464.0f, 497.7f, 464.0f, 480.0f)
                lineTo(464.0f, 416.0f)
                curveTo(464.0f, 336.5f, 399.5f, 272.0f, 320.0f, 272.0f)
                close()
                moveTo(288.0f, 416.0f)
                lineTo(288.0f, 480.0f)
                curveTo(288.0f, 497.7f, 273.7f, 512.0f, 256.0f, 512.0f)
                curveTo(238.3f, 512.0f, 224.0f, 497.7f, 224.0f, 480.0f)
                lineTo(224.0f, 416.0f)
                curveTo(224.0f, 363.0f, 267.0f, 320.0f, 320.0f, 320.0f)
                curveTo(373.0f, 320.0f, 416.0f, 363.0f, 416.0f, 416.0f)
                lineTo(416.0f, 480.0f)
                curveTo(416.0f, 497.7f, 401.7f, 512.0f, 384.0f, 512.0f)
                curveTo(366.3f, 512.0f, 352.0f, 497.7f, 352.0f, 480.0f)
                lineTo(352.0f, 416.0f)
                curveTo(352.0f, 398.3f, 337.7f, 384.0f, 320.0f, 384.0f)
                curveTo(302.3f, 384.0f, 288.0f, 398.3f, 288.0f, 416.0f)
                close()
            }
        }
        .build()
        return _rainbow!!
    }

private var _rainbow: ImageVector? = null
