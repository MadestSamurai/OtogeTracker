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

public val Fa.Bucket: ImageVector
    get() {
        if (_bucket != null) {
            return _bucket!!
        }
        _bucket = Builder(name = "Bucket", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(539.7f, 272.0f)
                curveTo(542.4f, 276.7f, 544.0f, 282.2f, 544.0f, 288.0f)
                curveTo(544.0f, 305.7f, 529.7f, 320.0f, 512.0f, 320.0f)
                lineTo(506.9f, 320.0f)
                lineTo(484.5f, 533.0f)
                curveTo(481.9f, 557.4f, 461.3f, 576.0f, 436.7f, 576.0f)
                lineTo(203.1f, 576.0f)
                curveTo(178.5f, 576.0f, 157.9f, 557.5f, 155.3f, 533.0f)
                lineTo(133.1f, 320.0f)
                lineTo(128.0f, 320.0f)
                curveTo(110.3f, 320.0f, 96.0f, 305.7f, 96.0f, 288.0f)
                curveTo(96.0f, 282.2f, 97.6f, 276.7f, 100.3f, 272.0f)
                lineTo(539.7f, 272.0f)
                close()
                moveTo(320.0f, 48.0f)
                curveTo(399.5f, 48.0f, 464.0f, 112.5f, 464.0f, 192.0f)
                lineTo(464.0f, 224.0f)
                lineTo(416.0f, 224.0f)
                lineTo(416.0f, 192.0f)
                curveTo(416.0f, 139.0f, 373.0f, 96.0f, 320.0f, 96.0f)
                curveTo(267.0f, 96.0f, 224.0f, 139.0f, 224.0f, 192.0f)
                lineTo(224.0f, 224.0f)
                lineTo(176.0f, 224.0f)
                lineTo(176.0f, 192.0f)
                curveTo(176.0f, 112.5f, 240.5f, 48.0f, 320.0f, 48.0f)
                close()
            }
        }
        .build()
        return _bucket!!
    }

private var _bucket: ImageVector? = null
