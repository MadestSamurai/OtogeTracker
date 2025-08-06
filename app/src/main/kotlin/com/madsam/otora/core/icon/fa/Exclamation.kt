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

public val Fa.Exclamation: ImageVector
    get() {
        if (_exclamation != null) {
            return _exclamation!!
        }
        _exclamation = Builder(name = "Exclamation", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 96.0f)
                curveTo(352.0f, 78.3f, 337.7f, 64.0f, 320.0f, 64.0f)
                curveTo(302.3f, 64.0f, 288.0f, 78.3f, 288.0f, 96.0f)
                lineTo(288.0f, 416.0f)
                curveTo(288.0f, 433.7f, 302.3f, 448.0f, 320.0f, 448.0f)
                curveTo(337.7f, 448.0f, 352.0f, 433.7f, 352.0f, 416.0f)
                lineTo(352.0f, 96.0f)
                close()
                moveTo(320.0f, 576.0f)
                curveTo(342.1f, 576.0f, 360.0f, 558.1f, 360.0f, 536.0f)
                curveTo(360.0f, 513.9f, 342.1f, 496.0f, 320.0f, 496.0f)
                curveTo(297.9f, 496.0f, 280.0f, 513.9f, 280.0f, 536.0f)
                curveTo(280.0f, 558.1f, 297.9f, 576.0f, 320.0f, 576.0f)
                close()
            }
        }
        .build()
        return _exclamation!!
    }

private var _exclamation: ImageVector? = null
