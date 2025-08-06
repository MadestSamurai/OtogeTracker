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

public val Fa.Mars: ImageVector
    get() {
        if (_mars != null) {
            return _mars!!
        }
        _mars = Builder(name = "Mars", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(384.0f, 96.0f)
                curveTo(384.0f, 78.3f, 398.3f, 64.0f, 416.0f, 64.0f)
                lineTo(544.0f, 64.0f)
                curveTo(561.7f, 64.0f, 576.0f, 78.3f, 576.0f, 96.0f)
                lineTo(576.0f, 224.0f)
                curveTo(576.0f, 241.7f, 561.7f, 256.0f, 544.0f, 256.0f)
                curveTo(526.3f, 256.0f, 512.0f, 241.7f, 512.0f, 224.0f)
                lineTo(512.0f, 173.3f)
                lineTo(417.0f, 268.3f)
                curveTo(436.5f, 296.7f, 448.0f, 331.0f, 448.0f, 368.1f)
                curveTo(448.0f, 465.3f, 369.2f, 544.1f, 272.0f, 544.1f)
                curveTo(174.8f, 544.1f, 96.0f, 465.2f, 96.0f, 368.0f)
                curveTo(96.0f, 270.8f, 174.8f, 192.0f, 272.0f, 192.0f)
                curveTo(309.0f, 192.0f, 343.4f, 203.4f, 371.8f, 223.0f)
                lineTo(466.8f, 128.0f)
                lineTo(416.1f, 128.0f)
                curveTo(398.4f, 128.0f, 384.1f, 113.7f, 384.1f, 96.0f)
                close()
                moveTo(272.0f, 480.0f)
                curveTo(333.9f, 480.0f, 384.0f, 429.9f, 384.0f, 368.0f)
                curveTo(384.0f, 306.1f, 333.9f, 256.0f, 272.0f, 256.0f)
                curveTo(210.1f, 256.0f, 160.0f, 306.1f, 160.0f, 368.0f)
                curveTo(160.0f, 429.9f, 210.1f, 480.0f, 272.0f, 480.0f)
                close()
            }
        }
        .build()
        return _mars!!
    }

private var _mars: ImageVector? = null
