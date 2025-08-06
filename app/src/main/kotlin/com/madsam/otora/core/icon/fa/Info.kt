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

public val Fa.Info: ImageVector
    get() {
        if (_info != null) {
            return _info!!
        }
        _info = Builder(name = "Info", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(272.0f, 112.0f)
                curveTo(272.0f, 85.5f, 293.5f, 64.0f, 320.0f, 64.0f)
                curveTo(346.5f, 64.0f, 368.0f, 85.5f, 368.0f, 112.0f)
                curveTo(368.0f, 138.5f, 346.5f, 160.0f, 320.0f, 160.0f)
                curveTo(293.5f, 160.0f, 272.0f, 138.5f, 272.0f, 112.0f)
                close()
                moveTo(224.0f, 256.0f)
                curveTo(224.0f, 238.3f, 238.3f, 224.0f, 256.0f, 224.0f)
                lineTo(320.0f, 224.0f)
                curveTo(337.7f, 224.0f, 352.0f, 238.3f, 352.0f, 256.0f)
                lineTo(352.0f, 512.0f)
                lineTo(384.0f, 512.0f)
                curveTo(401.7f, 512.0f, 416.0f, 526.3f, 416.0f, 544.0f)
                curveTo(416.0f, 561.7f, 401.7f, 576.0f, 384.0f, 576.0f)
                lineTo(256.0f, 576.0f)
                curveTo(238.3f, 576.0f, 224.0f, 561.7f, 224.0f, 544.0f)
                curveTo(224.0f, 526.3f, 238.3f, 512.0f, 256.0f, 512.0f)
                lineTo(288.0f, 512.0f)
                lineTo(288.0f, 288.0f)
                lineTo(256.0f, 288.0f)
                curveTo(238.3f, 288.0f, 224.0f, 273.7f, 224.0f, 256.0f)
                close()
            }
        }
        .build()
        return _info!!
    }

private var _info: ImageVector? = null
