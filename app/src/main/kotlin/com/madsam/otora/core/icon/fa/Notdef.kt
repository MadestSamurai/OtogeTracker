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

public val Fa.Notdef: ImageVector
    get() {
        if (_notdef != null) {
            return _notdef!!
        }
        _notdef = Builder(name = "Notdef", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 454.3f)
                lineTo(281.5f, 320.0f)
                lineTo(192.0f, 185.7f)
                lineTo(192.0f, 454.3f)
                close()
                moveTo(230.5f, 512.0f)
                lineTo(409.5f, 512.0f)
                lineTo(320.0f, 377.7f)
                lineTo(230.5f, 512.0f)
                close()
                moveTo(358.5f, 320.0f)
                lineTo(448.0f, 454.3f)
                lineTo(448.0f, 185.7f)
                lineTo(358.5f, 320.0f)
                close()
                moveTo(409.5f, 128.0f)
                lineTo(230.5f, 128.0f)
                lineTo(320.0f, 262.3f)
                lineTo(409.5f, 128.0f)
                close()
                moveTo(128.0f, 112.0f)
                curveTo(128.0f, 85.5f, 149.5f, 64.0f, 176.0f, 64.0f)
                lineTo(464.0f, 64.0f)
                curveTo(490.5f, 64.0f, 512.0f, 85.5f, 512.0f, 112.0f)
                lineTo(512.0f, 528.0f)
                curveTo(512.0f, 554.5f, 490.5f, 576.0f, 464.0f, 576.0f)
                lineTo(176.0f, 576.0f)
                curveTo(149.5f, 576.0f, 128.0f, 554.5f, 128.0f, 528.0f)
                lineTo(128.0f, 112.0f)
                close()
            }
        }
        .build()
        return _notdef!!
    }

private var _notdef: ImageVector? = null
