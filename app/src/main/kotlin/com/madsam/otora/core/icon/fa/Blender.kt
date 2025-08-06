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

public val Fa.Blender: ImageVector
    get() {
        if (_blender != null) {
            return _blender!!
        }
        _blender = Builder(name = "Blender", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 120.0f)
                curveTo(64.0f, 89.1f, 89.1f, 64.0f, 120.0f, 64.0f)
                lineTo(501.6f, 64.0f)
                curveTo(522.9f, 64.0f, 538.2f, 84.3f, 532.4f, 104.8f)
                lineTo(521.1f, 144.0f)
                lineTo(408.0f, 144.0f)
                curveTo(394.7f, 144.0f, 384.0f, 154.7f, 384.0f, 168.0f)
                curveTo(384.0f, 181.3f, 394.7f, 192.0f, 408.0f, 192.0f)
                lineTo(507.4f, 192.0f)
                lineTo(489.1f, 256.0f)
                lineTo(408.0f, 256.0f)
                curveTo(394.7f, 256.0f, 384.0f, 266.7f, 384.0f, 280.0f)
                curveTo(384.0f, 293.3f, 394.7f, 304.0f, 408.0f, 304.0f)
                lineTo(475.4f, 304.0f)
                lineTo(448.0f, 400.0f)
                lineTo(192.0f, 400.0f)
                lineTo(182.9f, 304.0f)
                lineTo(120.0f, 304.0f)
                curveTo(89.1f, 304.0f, 64.0f, 278.9f, 64.0f, 248.0f)
                lineTo(64.0f, 120.0f)
                close()
                moveTo(178.3f, 256.0f)
                lineTo(164.6f, 112.0f)
                lineTo(120.0f, 112.0f)
                curveTo(115.6f, 112.0f, 112.0f, 115.6f, 112.0f, 120.0f)
                lineTo(112.0f, 248.0f)
                curveTo(112.0f, 252.4f, 115.6f, 256.0f, 120.0f, 256.0f)
                lineTo(178.3f, 256.0f)
                close()
                moveTo(200.0f, 448.0f)
                lineTo(440.0f, 448.0f)
                curveTo(462.1f, 448.0f, 480.0f, 465.9f, 480.0f, 488.0f)
                lineTo(480.0f, 536.0f)
                curveTo(480.0f, 558.1f, 462.1f, 576.0f, 440.0f, 576.0f)
                lineTo(200.0f, 576.0f)
                curveTo(177.9f, 576.0f, 160.0f, 558.1f, 160.0f, 536.0f)
                lineTo(160.0f, 488.0f)
                curveTo(160.0f, 465.9f, 177.9f, 448.0f, 200.0f, 448.0f)
                close()
                moveTo(320.0f, 536.0f)
                curveTo(333.3f, 536.0f, 344.0f, 525.3f, 344.0f, 512.0f)
                curveTo(344.0f, 498.7f, 333.3f, 488.0f, 320.0f, 488.0f)
                curveTo(306.7f, 488.0f, 296.0f, 498.7f, 296.0f, 512.0f)
                curveTo(296.0f, 525.3f, 306.7f, 536.0f, 320.0f, 536.0f)
                close()
            }
        }
        .build()
        return _blender!!
    }

private var _blender: ImageVector? = null
