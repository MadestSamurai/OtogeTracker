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

public val Fa.Swatchbook: ImageVector
    get() {
        if (_swatchbook != null) {
            return _swatchbook!!
        }
        _swatchbook = Builder(name = "Swatchbook", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 112.0f)
                curveTo(64.0f, 85.5f, 85.5f, 64.0f, 112.0f, 64.0f)
                lineTo(208.0f, 64.0f)
                curveTo(234.5f, 64.0f, 256.0f, 85.5f, 256.0f, 112.0f)
                lineTo(256.0f, 480.0f)
                curveTo(256.0f, 533.0f, 213.0f, 576.0f, 160.0f, 576.0f)
                curveTo(107.0f, 576.0f, 64.0f, 533.0f, 64.0f, 480.0f)
                lineTo(64.0f, 112.0f)
                close()
                moveTo(304.0f, 473.6f)
                lineTo(304.0f, 202.1f)
                lineTo(352.1f, 154.0f)
                curveTo(370.8f, 135.3f, 401.2f, 135.3f, 420.0f, 154.0f)
                lineTo(487.9f, 221.9f)
                curveTo(506.6f, 240.6f, 506.6f, 271.0f, 487.9f, 289.8f)
                lineTo(304.0f, 473.6f)
                close()
                moveTo(269.5f, 576.0f)
                lineTo(461.5f, 384.0f)
                lineTo(528.1f, 384.0f)
                curveTo(554.6f, 384.0f, 576.1f, 405.5f, 576.1f, 432.0f)
                lineTo(576.1f, 528.0f)
                curveTo(576.1f, 554.5f, 554.6f, 576.0f, 528.1f, 576.0f)
                lineTo(269.6f, 576.0f)
                close()
                moveTo(144.0f, 128.0f)
                curveTo(135.2f, 128.0f, 128.0f, 135.2f, 128.0f, 144.0f)
                lineTo(128.0f, 176.0f)
                curveTo(128.0f, 184.8f, 135.2f, 192.0f, 144.0f, 192.0f)
                lineTo(176.0f, 192.0f)
                curveTo(184.8f, 192.0f, 192.0f, 184.8f, 192.0f, 176.0f)
                lineTo(192.0f, 144.0f)
                curveTo(192.0f, 135.2f, 184.8f, 128.0f, 176.0f, 128.0f)
                lineTo(144.0f, 128.0f)
                close()
                moveTo(128.0f, 272.0f)
                lineTo(128.0f, 304.0f)
                curveTo(128.0f, 312.8f, 135.2f, 320.0f, 144.0f, 320.0f)
                lineTo(176.0f, 320.0f)
                curveTo(184.8f, 320.0f, 192.0f, 312.8f, 192.0f, 304.0f)
                lineTo(192.0f, 272.0f)
                curveTo(192.0f, 263.2f, 184.8f, 256.0f, 176.0f, 256.0f)
                lineTo(144.0f, 256.0f)
                curveTo(135.2f, 256.0f, 128.0f, 263.2f, 128.0f, 272.0f)
                close()
                moveTo(160.0f, 504.0f)
                curveTo(173.3f, 504.0f, 184.0f, 493.3f, 184.0f, 480.0f)
                curveTo(184.0f, 466.7f, 173.3f, 456.0f, 160.0f, 456.0f)
                curveTo(146.7f, 456.0f, 136.0f, 466.7f, 136.0f, 480.0f)
                curveTo(136.0f, 493.3f, 146.7f, 504.0f, 160.0f, 504.0f)
                close()
            }
        }
        .build()
        return _swatchbook!!
    }

private var _swatchbook: ImageVector? = null
