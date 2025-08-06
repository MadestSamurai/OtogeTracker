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

public val Fa.Magic: ImageVector
    get() {
        if (_magic != null) {
            return _magic!!
        }
        _magic = Builder(name = "Magic", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(462.5f, 76.2f)
                lineTo(374.3f, 164.4f)
                lineTo(475.6f, 265.7f)
                lineTo(563.8f, 177.5f)
                curveTo(571.6f, 169.6f, 576.0f, 159.0f, 576.0f, 148.0f)
                curveTo(576.0f, 137.0f, 571.6f, 126.4f, 563.8f, 118.5f)
                lineTo(521.5f, 76.2f)
                curveTo(513.6f, 68.4f, 503.0f, 64.0f, 492.0f, 64.0f)
                curveTo(481.0f, 64.0f, 470.4f, 68.4f, 462.5f, 76.2f)
                close()
                moveTo(340.4f, 198.3f)
                lineTo(76.2f, 462.5f)
                curveTo(68.4f, 470.4f, 64.0f, 481.0f, 64.0f, 492.0f)
                curveTo(64.0f, 503.0f, 68.4f, 513.6f, 76.2f, 521.5f)
                lineTo(118.5f, 563.8f)
                curveTo(126.4f, 571.6f, 137.0f, 576.0f, 148.0f, 576.0f)
                curveTo(159.0f, 576.0f, 169.6f, 571.6f, 177.5f, 563.8f)
                lineTo(441.7f, 299.6f)
                lineTo(340.4f, 198.3f)
                close()
            }
        }
        .build()
        return _magic!!
    }

private var _magic: ImageVector? = null
