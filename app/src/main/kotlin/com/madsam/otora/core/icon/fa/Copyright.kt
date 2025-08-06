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

public val Fa.Copyright: ImageVector
    get() {
        if (_copyright != null) {
            return _copyright!!
        }
        _copyright = Builder(name = "Copyright", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(269.1f, 370.9f)
                curveTo(297.2f, 399.0f, 342.8f, 399.0f, 370.9f, 370.9f)
                curveTo(380.3f, 361.5f, 395.5f, 361.5f, 404.8f, 370.9f)
                curveTo(414.1f, 380.3f, 414.2f, 395.5f, 404.8f, 404.8f)
                curveTo(357.9f, 451.7f, 282.0f, 451.7f, 235.1f, 404.8f)
                curveTo(188.2f, 357.9f, 188.2f, 282.0f, 235.1f, 235.1f)
                curveTo(282.0f, 188.2f, 357.9f, 188.2f, 404.8f, 235.1f)
                curveTo(414.2f, 244.5f, 414.2f, 259.7f, 404.8f, 269.0f)
                curveTo(395.4f, 278.3f, 380.2f, 278.4f, 370.9f, 269.0f)
                curveTo(342.8f, 240.9f, 297.2f, 240.9f, 269.1f, 269.0f)
                curveTo(241.0f, 297.1f, 241.0f, 342.7f, 269.1f, 370.8f)
                close()
            }
        }
        .build()
        return _copyright!!
    }

private var _copyright: ImageVector? = null
