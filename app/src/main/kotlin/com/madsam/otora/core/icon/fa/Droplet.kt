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

public val Fa.Droplet: ImageVector
    get() {
        if (_droplet != null) {
            return _droplet!!
        }
        _droplet = Builder(name = "Droplet", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(214.0f, 576.0f, 128.0f, 490.0f, 128.0f, 384.0f)
                curveTo(128.0f, 292.8f, 258.2f, 109.9f, 294.6f, 60.5f)
                curveTo(300.5f, 52.5f, 309.8f, 48.0f, 319.8f, 48.0f)
                lineTo(320.2f, 48.0f)
                curveTo(330.2f, 48.0f, 339.5f, 52.5f, 345.4f, 60.5f)
                curveTo(381.8f, 109.9f, 512.0f, 292.8f, 512.0f, 384.0f)
                curveTo(512.0f, 490.0f, 426.0f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(240.0f, 376.0f)
                curveTo(240.0f, 362.7f, 229.3f, 352.0f, 216.0f, 352.0f)
                curveTo(202.7f, 352.0f, 192.0f, 362.7f, 192.0f, 376.0f)
                curveTo(192.0f, 451.1f, 252.9f, 512.0f, 328.0f, 512.0f)
                curveTo(341.3f, 512.0f, 352.0f, 501.3f, 352.0f, 488.0f)
                curveTo(352.0f, 474.7f, 341.3f, 464.0f, 328.0f, 464.0f)
                curveTo(279.4f, 464.0f, 240.0f, 424.6f, 240.0f, 376.0f)
                close()
            }
        }
        .build()
        return _droplet!!
    }

private var _droplet: ImageVector? = null
