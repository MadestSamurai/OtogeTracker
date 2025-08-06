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

public val Fa.Grin: ImageVector
    get() {
        if (_grin != null) {
            return _grin!!
        }
        _grin = Builder(name = "Grin", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(450.7f, 372.9f)
                curveTo(462.6f, 369.2f, 474.6f, 379.2f, 470.3f, 391.0f)
                curveTo(447.9f, 452.3f, 389.0f, 496.1f, 320.0f, 496.1f)
                curveTo(251.0f, 496.1f, 192.1f, 452.2f, 169.7f, 390.9f)
                curveTo(165.4f, 379.1f, 177.4f, 369.1f, 189.3f, 372.8f)
                curveTo(228.5f, 385.0f, 273.0f, 391.9f, 320.0f, 391.9f)
                curveTo(367.0f, 391.9f, 411.5f, 385.0f, 450.7f, 372.8f)
                close()
                moveTo(208.0f, 272.0f)
                curveTo(208.0f, 254.3f, 222.3f, 240.0f, 240.0f, 240.0f)
                curveTo(257.7f, 240.0f, 272.0f, 254.3f, 272.0f, 272.0f)
                curveTo(272.0f, 289.7f, 257.7f, 304.0f, 240.0f, 304.0f)
                curveTo(222.3f, 304.0f, 208.0f, 289.7f, 208.0f, 272.0f)
                close()
                moveTo(400.0f, 240.0f)
                curveTo(417.7f, 240.0f, 432.0f, 254.3f, 432.0f, 272.0f)
                curveTo(432.0f, 289.7f, 417.7f, 304.0f, 400.0f, 304.0f)
                curveTo(382.3f, 304.0f, 368.0f, 289.7f, 368.0f, 272.0f)
                curveTo(368.0f, 254.3f, 382.3f, 240.0f, 400.0f, 240.0f)
                close()
            }
        }
        .build()
        return _grin!!
    }

private var _grin: ImageVector? = null
