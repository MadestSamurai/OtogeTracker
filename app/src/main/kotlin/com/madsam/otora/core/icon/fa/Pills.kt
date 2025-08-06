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

public val Fa.Pills: ImageVector
    get() {
        if (_pills != null) {
            return _pills!!
        }
        _pills = Builder(name = "Pills", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 176.0f)
                curveTo(128.0f, 149.5f, 149.5f, 128.0f, 176.0f, 128.0f)
                curveTo(202.5f, 128.0f, 224.0f, 149.5f, 224.0f, 176.0f)
                lineTo(224.0f, 288.0f)
                lineTo(128.0f, 288.0f)
                lineTo(128.0f, 176.0f)
                close()
                moveTo(240.0f, 432.0f)
                curveTo(240.0f, 383.3f, 258.1f, 338.8f, 288.0f, 305.0f)
                lineTo(288.0f, 176.0f)
                curveTo(288.0f, 114.1f, 237.9f, 64.0f, 176.0f, 64.0f)
                curveTo(114.1f, 64.0f, 64.0f, 114.1f, 64.0f, 176.0f)
                lineTo(64.0f, 464.0f)
                curveTo(64.0f, 525.9f, 114.1f, 576.0f, 176.0f, 576.0f)
                curveTo(213.3f, 576.0f, 246.3f, 557.8f, 266.7f, 529.7f)
                curveTo(249.7f, 501.1f, 240.0f, 467.7f, 240.0f, 432.0f)
                close()
                moveTo(304.7f, 499.4f)
                curveTo(309.3f, 508.1f, 321.0f, 509.1f, 328.0f, 502.1f)
                lineTo(502.1f, 328.0f)
                curveTo(509.1f, 321.0f, 508.1f, 309.3f, 499.4f, 304.7f)
                curveTo(479.3f, 294.0f, 456.4f, 288.0f, 432.0f, 288.0f)
                curveTo(352.5f, 288.0f, 288.0f, 352.5f, 288.0f, 432.0f)
                curveTo(288.0f, 456.3f, 294.0f, 479.3f, 304.7f, 499.4f)
                close()
                moveTo(361.9f, 536.0f)
                curveTo(354.9f, 543.0f, 355.9f, 554.7f, 364.6f, 559.3f)
                curveTo(384.7f, 570.0f, 407.6f, 576.0f, 432.0f, 576.0f)
                curveTo(511.5f, 576.0f, 576.0f, 511.5f, 576.0f, 432.0f)
                curveTo(576.0f, 407.7f, 570.0f, 384.7f, 559.3f, 364.6f)
                curveTo(554.7f, 355.9f, 543.0f, 354.9f, 536.0f, 361.9f)
                lineTo(361.9f, 536.0f)
                close()
            }
        }
        .build()
        return _pills!!
    }

private var _pills: ImageVector? = null
