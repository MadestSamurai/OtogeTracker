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

public val Fa.Y: ImageVector
    get() {
        if (_y != null) {
            return _y!!
        }
        _y = Builder(name = "Y", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(186.0f, 109.4f)
                curveTo(175.8f, 95.0f, 155.8f, 91.7f, 141.4f, 102.0f)
                curveTo(127.0f, 112.3f, 123.7f, 132.2f, 134.0f, 146.6f)
                lineTo(288.0f, 362.3f)
                lineTo(288.0f, 512.0f)
                curveTo(288.0f, 529.7f, 302.3f, 544.0f, 320.0f, 544.0f)
                curveTo(337.7f, 544.0f, 352.0f, 529.7f, 352.0f, 512.0f)
                lineTo(352.0f, 362.3f)
                lineTo(506.0f, 146.6f)
                curveTo(516.3f, 132.2f, 512.9f, 112.2f, 498.6f, 102.0f)
                curveTo(484.3f, 91.8f, 464.2f, 95.0f, 454.0f, 109.4f)
                lineTo(320.0f, 296.9f)
                lineTo(186.0f, 109.4f)
                close()
            }
        }
        .build()
        return _y!!
    }

private var _y: ImageVector? = null
