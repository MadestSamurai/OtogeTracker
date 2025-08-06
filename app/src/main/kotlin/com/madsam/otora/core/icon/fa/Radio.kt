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

public val Fa.Radio: ImageVector
    get() {
        if (_radio != null) {
            return _radio!!
        }
        _radio = Builder(name = "Radio", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(558.8f, 79.0f)
                curveTo(571.5f, 75.3f, 578.8f, 61.9f, 575.1f, 49.2f)
                curveTo(571.4f, 36.5f, 558.0f, 29.2f, 545.3f, 33.0f)
                lineTo(115.8f, 158.9f)
                curveTo(106.4f, 161.6f, 97.9f, 166.1f, 90.6f, 172.0f)
                curveTo(74.5f, 183.7f, 64.0f, 202.6f, 64.0f, 224.0f)
                lineTo(64.0f, 480.0f)
                curveTo(64.0f, 515.3f, 92.7f, 544.0f, 128.0f, 544.0f)
                lineTo(512.0f, 544.0f)
                curveTo(547.3f, 544.0f, 576.0f, 515.3f, 576.0f, 480.0f)
                lineTo(576.0f, 224.0f)
                curveTo(576.0f, 188.7f, 547.3f, 160.0f, 512.0f, 160.0f)
                lineTo(282.5f, 160.0f)
                lineTo(558.8f, 79.0f)
                close()
                moveTo(432.0f, 272.0f)
                curveTo(476.2f, 272.0f, 512.0f, 307.8f, 512.0f, 352.0f)
                curveTo(512.0f, 396.2f, 476.2f, 432.0f, 432.0f, 432.0f)
                curveTo(387.8f, 432.0f, 352.0f, 396.2f, 352.0f, 352.0f)
                curveTo(352.0f, 307.8f, 387.8f, 272.0f, 432.0f, 272.0f)
                close()
                moveTo(128.0f, 312.0f)
                curveTo(128.0f, 298.7f, 138.7f, 288.0f, 152.0f, 288.0f)
                lineTo(264.0f, 288.0f)
                curveTo(277.3f, 288.0f, 288.0f, 298.7f, 288.0f, 312.0f)
                curveTo(288.0f, 325.3f, 277.3f, 336.0f, 264.0f, 336.0f)
                lineTo(152.0f, 336.0f)
                curveTo(138.7f, 336.0f, 128.0f, 325.3f, 128.0f, 312.0f)
                close()
                moveTo(128.0f, 408.0f)
                curveTo(128.0f, 394.7f, 138.7f, 384.0f, 152.0f, 384.0f)
                lineTo(264.0f, 384.0f)
                curveTo(277.3f, 384.0f, 288.0f, 394.7f, 288.0f, 408.0f)
                curveTo(288.0f, 421.3f, 277.3f, 432.0f, 264.0f, 432.0f)
                lineTo(152.0f, 432.0f)
                curveTo(138.7f, 432.0f, 128.0f, 421.3f, 128.0f, 408.0f)
                close()
            }
        }
        .build()
        return _radio!!
    }

private var _radio: ImageVector? = null
