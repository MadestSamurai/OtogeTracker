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

public val Fa.Divide: ImageVector
    get() {
        if (_divide != null) {
            return _divide!!
        }
        _divide = Builder(name = "Divide", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 112.0f)
                curveTo(350.9f, 112.0f, 376.0f, 137.1f, 376.0f, 168.0f)
                curveTo(376.0f, 198.9f, 350.9f, 224.0f, 320.0f, 224.0f)
                curveTo(289.1f, 224.0f, 264.0f, 198.9f, 264.0f, 168.0f)
                curveTo(264.0f, 137.1f, 289.1f, 112.0f, 320.0f, 112.0f)
                close()
                moveTo(96.0f, 320.0f)
                curveTo(96.0f, 302.3f, 110.3f, 288.0f, 128.0f, 288.0f)
                lineTo(512.0f, 288.0f)
                curveTo(529.7f, 288.0f, 544.0f, 302.3f, 544.0f, 320.0f)
                curveTo(544.0f, 337.7f, 529.7f, 352.0f, 512.0f, 352.0f)
                lineTo(128.0f, 352.0f)
                curveTo(110.3f, 352.0f, 96.0f, 337.7f, 96.0f, 320.0f)
                close()
                moveTo(264.0f, 472.0f)
                curveTo(264.0f, 441.1f, 289.1f, 416.0f, 320.0f, 416.0f)
                curveTo(350.9f, 416.0f, 376.0f, 441.1f, 376.0f, 472.0f)
                curveTo(376.0f, 502.9f, 350.9f, 528.0f, 320.0f, 528.0f)
                curveTo(289.1f, 528.0f, 264.0f, 502.9f, 264.0f, 472.0f)
                close()
            }
        }
        .build()
        return _divide!!
    }

private var _divide: ImageVector? = null
