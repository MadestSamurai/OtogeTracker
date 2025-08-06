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

public val Fa.Clone: ImageVector
    get() {
        if (_clone != null) {
            return _clone!!
        }
        _clone = Builder(name = "Clone", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 512.0f)
                lineTo(128.0f, 512.0f)
                lineTo(128.0f, 288.0f)
                lineTo(176.0f, 288.0f)
                lineTo(176.0f, 224.0f)
                lineTo(128.0f, 224.0f)
                curveTo(92.7f, 224.0f, 64.0f, 252.7f, 64.0f, 288.0f)
                lineTo(64.0f, 512.0f)
                curveTo(64.0f, 547.3f, 92.7f, 576.0f, 128.0f, 576.0f)
                lineTo(352.0f, 576.0f)
                curveTo(387.3f, 576.0f, 416.0f, 547.3f, 416.0f, 512.0f)
                lineTo(416.0f, 464.0f)
                lineTo(352.0f, 464.0f)
                lineTo(352.0f, 512.0f)
                close()
                moveTo(288.0f, 416.0f)
                lineTo(512.0f, 416.0f)
                curveTo(547.3f, 416.0f, 576.0f, 387.3f, 576.0f, 352.0f)
                lineTo(576.0f, 128.0f)
                curveTo(576.0f, 92.7f, 547.3f, 64.0f, 512.0f, 64.0f)
                lineTo(288.0f, 64.0f)
                curveTo(252.7f, 64.0f, 224.0f, 92.7f, 224.0f, 128.0f)
                lineTo(224.0f, 352.0f)
                curveTo(224.0f, 387.3f, 252.7f, 416.0f, 288.0f, 416.0f)
                close()
            }
        }
        .build()
        return _clone!!
    }

private var _clone: ImageVector? = null
