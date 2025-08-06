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

public val Fa.Suitcase: ImageVector
    get() {
        if (_suitcase != null) {
            return _suitcase!!
        }
        _suitcase = Builder(name = "Suitcase", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(264.0f, 112.0f)
                lineTo(376.0f, 112.0f)
                curveTo(380.4f, 112.0f, 384.0f, 115.6f, 384.0f, 120.0f)
                lineTo(384.0f, 160.0f)
                lineTo(256.0f, 160.0f)
                lineTo(256.0f, 120.0f)
                curveTo(256.0f, 115.6f, 259.6f, 112.0f, 264.0f, 112.0f)
                close()
                moveTo(208.0f, 120.0f)
                lineTo(208.0f, 544.0f)
                lineTo(432.0f, 544.0f)
                lineTo(432.0f, 120.0f)
                curveTo(432.0f, 89.1f, 406.9f, 64.0f, 376.0f, 64.0f)
                lineTo(264.0f, 64.0f)
                curveTo(233.1f, 64.0f, 208.0f, 89.1f, 208.0f, 120.0f)
                close()
                moveTo(480.0f, 160.0f)
                lineTo(480.0f, 544.0f)
                lineTo(512.0f, 544.0f)
                curveTo(547.3f, 544.0f, 576.0f, 515.3f, 576.0f, 480.0f)
                lineTo(576.0f, 224.0f)
                curveTo(576.0f, 188.7f, 547.3f, 160.0f, 512.0f, 160.0f)
                lineTo(480.0f, 160.0f)
                close()
                moveTo(160.0f, 544.0f)
                lineTo(160.0f, 160.0f)
                lineTo(128.0f, 160.0f)
                curveTo(92.7f, 160.0f, 64.0f, 188.7f, 64.0f, 224.0f)
                lineTo(64.0f, 480.0f)
                curveTo(64.0f, 515.3f, 92.7f, 544.0f, 128.0f, 544.0f)
                lineTo(160.0f, 544.0f)
                close()
            }
        }
        .build()
        return _suitcase!!
    }

private var _suitcase: ImageVector? = null
