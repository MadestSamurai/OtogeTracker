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

public val Fa.Cancel: ImageVector
    get() {
        if (_cancel != null) {
            return _cancel!!
        }
        _cancel = Builder(name = "Cancel", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(431.2f, 476.5f)
                lineTo(163.5f, 208.8f)
                curveTo(141.1f, 240.2f, 128.0f, 278.6f, 128.0f, 320.0f)
                curveTo(128.0f, 426.0f, 214.0f, 512.0f, 320.0f, 512.0f)
                curveTo(361.5f, 512.0f, 399.9f, 498.9f, 431.2f, 476.5f)
                close()
                moveTo(476.5f, 431.2f)
                curveTo(498.9f, 399.8f, 512.0f, 361.4f, 512.0f, 320.0f)
                curveTo(512.0f, 214.0f, 426.0f, 128.0f, 320.0f, 128.0f)
                curveTo(278.5f, 128.0f, 240.1f, 141.1f, 208.8f, 163.5f)
                lineTo(476.5f, 431.2f)
                close()
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
            }
        }
        .build()
        return _cancel!!
    }

private var _cancel: ImageVector? = null
