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

public val Fa.Spiral: ImageVector
    get() {
        if (_spiral != null) {
            return _spiral!!
        }
        _spiral = Builder(name = "Spiral", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(179.5f, 71.4f)
                curveTo(193.1f, 60.1f, 213.3f, 61.9f, 224.6f, 75.5f)
                curveTo(235.9f, 89.1f, 234.1f, 109.3f, 220.5f, 120.6f)
                curveTo(164.2f, 167.5f, 128.0f, 239.2f, 128.0f, 320.0f)
                curveTo(128.0f, 426.0f, 214.0f, 512.0f, 320.0f, 512.0f)
                curveTo(426.0f, 512.0f, 512.0f, 426.0f, 512.0f, 320.0f)
                curveTo(512.0f, 244.9f, 451.1f, 184.0f, 376.0f, 184.0f)
                curveTo(300.9f, 184.0f, 240.0f, 244.9f, 240.0f, 320.0f)
                curveTo(240.0f, 364.2f, 275.8f, 400.0f, 320.0f, 400.0f)
                curveTo(364.2f, 400.0f, 400.0f, 364.2f, 400.0f, 320.0f)
                curveTo(400.0f, 306.7f, 389.3f, 296.0f, 376.0f, 296.0f)
                curveTo(362.7f, 296.0f, 352.0f, 306.7f, 352.0f, 320.0f)
                curveTo(352.0f, 337.7f, 337.7f, 352.0f, 320.0f, 352.0f)
                curveTo(302.3f, 352.0f, 288.0f, 337.7f, 288.0f, 320.0f)
                curveTo(288.0f, 271.4f, 327.4f, 232.0f, 376.0f, 232.0f)
                curveTo(424.6f, 232.0f, 464.0f, 271.4f, 464.0f, 320.0f)
                curveTo(464.0f, 399.5f, 399.5f, 464.0f, 320.0f, 464.0f)
                curveTo(240.5f, 464.0f, 176.0f, 399.5f, 176.0f, 320.0f)
                curveTo(176.0f, 209.5f, 265.5f, 120.0f, 376.0f, 120.0f)
                curveTo(486.5f, 120.0f, 576.0f, 209.5f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                curveTo(64.0f, 219.8f, 109.0f, 130.1f, 179.5f, 71.4f)
                close()
            }
        }
        .build()
        return _spiral!!
    }

private var _spiral: ImageVector? = null
