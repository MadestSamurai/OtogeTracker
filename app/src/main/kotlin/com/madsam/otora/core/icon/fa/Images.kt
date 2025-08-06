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

public val Fa.Images: ImageVector
    get() {
        if (_images != null) {
            return _images!!
        }
        _images = Builder(name = "Images", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 160.0f)
                curveTo(128.0f, 124.7f, 156.7f, 96.0f, 192.0f, 96.0f)
                lineTo(512.0f, 96.0f)
                curveTo(547.3f, 96.0f, 576.0f, 124.7f, 576.0f, 160.0f)
                lineTo(576.0f, 416.0f)
                curveTo(576.0f, 451.3f, 547.3f, 480.0f, 512.0f, 480.0f)
                lineTo(192.0f, 480.0f)
                curveTo(156.7f, 480.0f, 128.0f, 451.3f, 128.0f, 416.0f)
                lineTo(128.0f, 160.0f)
                close()
                moveTo(56.0f, 192.0f)
                curveTo(69.3f, 192.0f, 80.0f, 202.7f, 80.0f, 216.0f)
                lineTo(80.0f, 512.0f)
                curveTo(80.0f, 520.8f, 87.2f, 528.0f, 96.0f, 528.0f)
                lineTo(456.0f, 528.0f)
                curveTo(469.3f, 528.0f, 480.0f, 538.7f, 480.0f, 552.0f)
                curveTo(480.0f, 565.3f, 469.3f, 576.0f, 456.0f, 576.0f)
                lineTo(96.0f, 576.0f)
                curveTo(60.7f, 576.0f, 32.0f, 547.3f, 32.0f, 512.0f)
                lineTo(32.0f, 216.0f)
                curveTo(32.0f, 202.7f, 42.7f, 192.0f, 56.0f, 192.0f)
                close()
                moveTo(224.0f, 224.0f)
                curveTo(241.7f, 224.0f, 256.0f, 209.7f, 256.0f, 192.0f)
                curveTo(256.0f, 174.3f, 241.7f, 160.0f, 224.0f, 160.0f)
                curveTo(206.3f, 160.0f, 192.0f, 174.3f, 192.0f, 192.0f)
                curveTo(192.0f, 209.7f, 206.3f, 224.0f, 224.0f, 224.0f)
                close()
                moveTo(420.5f, 235.5f)
                curveTo(416.1f, 228.4f, 408.4f, 224.0f, 400.0f, 224.0f)
                curveTo(391.6f, 224.0f, 383.9f, 228.4f, 379.5f, 235.5f)
                lineTo(323.2f, 327.6f)
                lineTo(298.7f, 297.0f)
                curveTo(294.1f, 291.3f, 287.3f, 288.0f, 280.0f, 288.0f)
                curveTo(272.7f, 288.0f, 265.8f, 291.3f, 261.3f, 297.0f)
                lineTo(197.3f, 377.0f)
                curveTo(191.5f, 384.2f, 190.4f, 394.1f, 194.4f, 402.4f)
                curveTo(198.4f, 410.7f, 206.8f, 416.0f, 216.0f, 416.0f)
                lineTo(488.0f, 416.0f)
                curveTo(496.7f, 416.0f, 504.7f, 411.3f, 508.9f, 403.7f)
                curveTo(513.1f, 396.1f, 513.0f, 386.9f, 508.4f, 379.4f)
                lineTo(420.4f, 235.4f)
                close()
            }
        }
        .build()
        return _images!!
    }

private var _images: ImageVector? = null
