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

public val Fa.Laptop: ImageVector
    get() {
        if (_laptop != null) {
            return _laptop!!
        }
        _laptop = Builder(name = "Laptop", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 96.0f)
                curveTo(92.7f, 96.0f, 64.0f, 124.7f, 64.0f, 160.0f)
                lineTo(64.0f, 400.0f)
                lineTo(128.0f, 400.0f)
                lineTo(128.0f, 160.0f)
                lineTo(512.0f, 160.0f)
                lineTo(512.0f, 400.0f)
                lineTo(576.0f, 400.0f)
                lineTo(576.0f, 160.0f)
                curveTo(576.0f, 124.7f, 547.3f, 96.0f, 512.0f, 96.0f)
                lineTo(128.0f, 96.0f)
                close()
                moveTo(19.2f, 448.0f)
                curveTo(8.6f, 448.0f, 0.0f, 456.6f, 0.0f, 467.2f)
                curveTo(0.0f, 509.6f, 34.4f, 544.0f, 76.8f, 544.0f)
                lineTo(563.2f, 544.0f)
                curveTo(605.6f, 544.0f, 640.0f, 509.6f, 640.0f, 467.2f)
                curveTo(640.0f, 456.6f, 631.4f, 448.0f, 620.8f, 448.0f)
                lineTo(19.2f, 448.0f)
                close()
            }
        }
        .build()
        return _laptop!!
    }

private var _laptop: ImageVector? = null
