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

public val Fa.Monument: ImageVector
    get() {
        if (_monument != null) {
            return _monument!!
        }
        _monument = Builder(name = "Monument", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(337.0f, 31.0f)
                curveTo(327.6f, 21.6f, 312.4f, 21.6f, 303.1f, 31.0f)
                lineTo(223.0f, 111.0f)
                curveTo(218.9f, 115.1f, 216.5f, 120.4f, 216.0f, 126.1f)
                lineTo(186.4f, 512.0f)
                lineTo(176.0f, 512.0f)
                curveTo(158.3f, 512.0f, 144.0f, 526.3f, 144.0f, 544.0f)
                curveTo(144.0f, 561.7f, 158.3f, 576.0f, 176.0f, 576.0f)
                lineTo(464.0f, 576.0f)
                curveTo(481.7f, 576.0f, 496.0f, 561.7f, 496.0f, 544.0f)
                curveTo(496.0f, 526.3f, 481.7f, 512.0f, 464.0f, 512.0f)
                lineTo(453.6f, 512.0f)
                lineTo(423.9f, 126.2f)
                curveTo(423.5f, 120.5f, 421.0f, 115.1f, 416.9f, 111.1f)
                lineTo(337.0f, 31.0f)
                close()
                moveTo(256.0f, 360.0f)
                curveTo(256.0f, 346.7f, 266.7f, 336.0f, 280.0f, 336.0f)
                lineTo(360.0f, 336.0f)
                curveTo(373.3f, 336.0f, 384.0f, 346.7f, 384.0f, 360.0f)
                curveTo(384.0f, 373.3f, 373.3f, 384.0f, 360.0f, 384.0f)
                lineTo(280.0f, 384.0f)
                curveTo(266.7f, 384.0f, 256.0f, 373.3f, 256.0f, 360.0f)
                close()
            }
        }
        .build()
        return _monument!!
    }

private var _monument: ImageVector? = null
