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

public val Fa.Diamond: ImageVector
    get() {
        if (_diamond != null) {
            return _diamond!!
        }
        _diamond = Builder(name = "Diamond", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(81.0f, 279.0f)
                lineTo(279.0f, 81.0f)
                curveTo(289.9f, 70.1f, 304.6f, 64.0f, 320.0f, 64.0f)
                curveTo(335.4f, 64.0f, 350.1f, 70.1f, 361.0f, 81.0f)
                lineTo(559.0f, 279.0f)
                curveTo(569.9f, 289.9f, 576.0f, 304.6f, 576.0f, 320.0f)
                curveTo(576.0f, 335.4f, 569.9f, 350.1f, 559.0f, 361.0f)
                lineTo(361.0f, 559.0f)
                curveTo(350.1f, 569.9f, 335.4f, 576.0f, 320.0f, 576.0f)
                curveTo(304.6f, 576.0f, 289.9f, 569.9f, 279.0f, 559.0f)
                lineTo(81.0f, 361.0f)
                curveTo(70.1f, 350.1f, 64.0f, 335.4f, 64.0f, 320.0f)
                curveTo(64.0f, 304.6f, 70.1f, 289.9f, 81.0f, 279.0f)
                close()
            }
        }
        .build()
        return _diamond!!
    }

private var _diamond: ImageVector? = null
