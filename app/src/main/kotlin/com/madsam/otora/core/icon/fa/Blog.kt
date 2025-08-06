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

public val Fa.Blog: ImageVector
    get() {
        if (_blog != null) {
            return _blog!!
        }
        _blog = Builder(name = "Blog", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.0f, 88.0f)
                curveTo(288.0f, 74.7f, 298.7f, 64.0f, 312.0f, 64.0f)
                curveTo(457.8f, 64.0f, 576.0f, 182.2f, 576.0f, 328.0f)
                curveTo(576.0f, 341.3f, 565.3f, 352.0f, 552.0f, 352.0f)
                curveTo(538.7f, 352.0f, 528.0f, 341.3f, 528.0f, 328.0f)
                curveTo(528.0f, 208.7f, 431.3f, 112.0f, 312.0f, 112.0f)
                curveTo(298.7f, 112.0f, 288.0f, 101.3f, 288.0f, 88.0f)
                close()
                moveTo(144.0f, 160.0f)
                curveTo(170.5f, 160.0f, 192.0f, 181.5f, 192.0f, 208.0f)
                lineTo(192.0f, 432.0f)
                curveTo(192.0f, 458.5f, 213.5f, 480.0f, 240.0f, 480.0f)
                curveTo(266.5f, 480.0f, 288.0f, 458.5f, 288.0f, 432.0f)
                curveTo(288.0f, 405.5f, 266.5f, 384.0f, 240.0f, 384.0f)
                curveTo(231.2f, 384.0f, 224.0f, 376.8f, 224.0f, 368.0f)
                lineTo(224.0f, 304.0f)
                curveTo(224.0f, 295.2f, 231.2f, 288.0f, 240.0f, 288.0f)
                curveTo(319.5f, 288.0f, 384.0f, 352.5f, 384.0f, 432.0f)
                curveTo(384.0f, 511.5f, 319.5f, 576.0f, 240.0f, 576.0f)
                curveTo(160.5f, 576.0f, 96.0f, 511.5f, 96.0f, 432.0f)
                lineTo(96.0f, 208.0f)
                curveTo(96.0f, 181.5f, 117.5f, 160.0f, 144.0f, 160.0f)
                close()
                moveTo(312.0f, 160.0f)
                curveTo(404.8f, 160.0f, 480.0f, 235.2f, 480.0f, 328.0f)
                curveTo(480.0f, 341.3f, 469.3f, 352.0f, 456.0f, 352.0f)
                curveTo(442.7f, 352.0f, 432.0f, 341.3f, 432.0f, 328.0f)
                curveTo(432.0f, 261.7f, 378.3f, 208.0f, 312.0f, 208.0f)
                curveTo(298.7f, 208.0f, 288.0f, 197.3f, 288.0f, 184.0f)
                curveTo(288.0f, 170.7f, 298.7f, 160.0f, 312.0f, 160.0f)
                close()
            }
        }
        .build()
        return _blog!!
    }

private var _blog: ImageVector? = null
