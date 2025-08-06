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

public val Fa.Eraser: ImageVector
    get() {
        if (_eraser != null) {
            return _eraser!!
        }
        _eraser = Builder(name = "Eraser", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(210.5f, 480.0f)
                lineTo(333.5f, 480.0f)
                lineTo(398.8f, 414.7f)
                lineTo(225.3f, 241.2f)
                lineTo(98.6f, 367.9f)
                lineTo(210.6f, 479.9f)
                close()
                moveTo(256.0f, 544.0f)
                lineTo(210.5f, 544.0f)
                curveTo(193.5f, 544.0f, 177.2f, 537.3f, 165.2f, 525.3f)
                lineTo(49.0f, 409.0f)
                curveTo(38.1f, 398.1f, 32.0f, 383.4f, 32.0f, 368.0f)
                curveTo(32.0f, 352.6f, 38.1f, 337.9f, 49.0f, 327.0f)
                lineTo(295.0f, 81.0f)
                curveTo(305.9f, 70.1f, 320.6f, 64.0f, 336.0f, 64.0f)
                curveTo(351.4f, 64.0f, 366.1f, 70.1f, 377.0f, 81.0f)
                lineTo(559.0f, 263.0f)
                curveTo(569.9f, 273.9f, 576.0f, 288.6f, 576.0f, 304.0f)
                curveTo(576.0f, 319.4f, 569.9f, 334.1f, 559.0f, 345.0f)
                lineTo(424.0f, 480.0f)
                lineTo(544.0f, 480.0f)
                curveTo(561.7f, 480.0f, 576.0f, 494.3f, 576.0f, 512.0f)
                curveTo(576.0f, 529.7f, 561.7f, 544.0f, 544.0f, 544.0f)
                lineTo(256.0f, 544.0f)
                close()
            }
        }
        .build()
        return _eraser!!
    }

private var _eraser: ImageVector? = null
