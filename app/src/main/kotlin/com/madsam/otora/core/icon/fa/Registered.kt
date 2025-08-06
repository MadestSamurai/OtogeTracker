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

public val Fa.Registered: ImageVector
    get() {
        if (_registered != null) {
            return _registered!!
        }
        _registered = Builder(name = "Registered", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(264.0f, 208.0f)
                lineTo(344.0f, 208.0f)
                curveTo(383.8f, 208.0f, 416.0f, 240.2f, 416.0f, 280.0f)
                curveTo(416.0f, 308.9f, 399.0f, 333.8f, 374.4f, 345.3f)
                lineTo(404.6f, 395.6f)
                curveTo(411.4f, 407.0f, 407.7f, 421.7f, 396.4f, 428.5f)
                curveTo(385.1f, 435.3f, 370.3f, 431.6f, 363.5f, 420.3f)
                lineTo(322.5f, 352.0f)
                lineTo(288.1f, 352.0f)
                lineTo(288.1f, 408.0f)
                curveTo(288.1f, 421.3f, 277.4f, 432.0f, 264.1f, 432.0f)
                curveTo(250.8f, 432.0f, 240.1f, 421.3f, 240.1f, 408.0f)
                lineTo(240.1f, 232.0f)
                curveTo(240.1f, 218.7f, 250.8f, 208.0f, 264.1f, 208.0f)
                close()
                moveTo(336.0f, 304.0f)
                lineTo(344.0f, 304.0f)
                curveTo(357.3f, 304.0f, 368.0f, 293.3f, 368.0f, 280.0f)
                curveTo(368.0f, 266.7f, 357.3f, 256.0f, 344.0f, 256.0f)
                lineTo(288.0f, 256.0f)
                lineTo(288.0f, 304.0f)
                lineTo(336.0f, 304.0f)
                close()
            }
        }
        .build()
        return _registered!!
    }

private var _registered: ImageVector? = null
