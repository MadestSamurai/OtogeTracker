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

public val Fa.Trash: ImageVector
    get() {
        if (_trash != null) {
            return _trash!!
        }
        _trash = Builder(name = "Trash", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(232.7f, 69.9f)
                lineTo(224.0f, 96.0f)
                lineTo(128.0f, 96.0f)
                curveTo(110.3f, 96.0f, 96.0f, 110.3f, 96.0f, 128.0f)
                curveTo(96.0f, 145.7f, 110.3f, 160.0f, 128.0f, 160.0f)
                lineTo(512.0f, 160.0f)
                curveTo(529.7f, 160.0f, 544.0f, 145.7f, 544.0f, 128.0f)
                curveTo(544.0f, 110.3f, 529.7f, 96.0f, 512.0f, 96.0f)
                lineTo(416.0f, 96.0f)
                lineTo(407.3f, 69.9f)
                curveTo(402.9f, 56.8f, 390.7f, 48.0f, 376.9f, 48.0f)
                lineTo(263.1f, 48.0f)
                curveTo(249.3f, 48.0f, 237.1f, 56.8f, 232.7f, 69.9f)
                close()
                moveTo(512.0f, 208.0f)
                lineTo(128.0f, 208.0f)
                lineTo(149.1f, 531.1f)
                curveTo(150.7f, 556.4f, 171.7f, 576.0f, 197.0f, 576.0f)
                lineTo(443.0f, 576.0f)
                curveTo(468.3f, 576.0f, 489.3f, 556.4f, 490.9f, 531.1f)
                lineTo(512.0f, 208.0f)
                close()
            }
        }
        .build()
        return _trash!!
    }

private var _trash: ImageVector? = null
