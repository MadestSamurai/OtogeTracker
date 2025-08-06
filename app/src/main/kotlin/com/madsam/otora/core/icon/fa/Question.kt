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

public val Fa.Question: ImageVector
    get() {
        if (_question != null) {
            return _question!!
        }
        _question = Builder(name = "Question", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 224.0f)
                curveTo(224.0f, 171.0f, 267.0f, 128.0f, 320.0f, 128.0f)
                curveTo(373.0f, 128.0f, 416.0f, 171.0f, 416.0f, 224.0f)
                curveTo(416.0f, 266.7f, 388.1f, 302.9f, 349.5f, 315.4f)
                curveTo(321.1f, 324.6f, 288.0f, 350.7f, 288.0f, 392.0f)
                lineTo(288.0f, 416.0f)
                curveTo(288.0f, 433.7f, 302.3f, 448.0f, 320.0f, 448.0f)
                curveTo(337.7f, 448.0f, 352.0f, 433.7f, 352.0f, 416.0f)
                lineTo(352.0f, 392.0f)
                curveTo(352.0f, 390.3f, 352.6f, 387.9f, 355.5f, 384.7f)
                curveTo(358.5f, 381.4f, 363.4f, 378.2f, 369.2f, 376.3f)
                curveTo(433.5f, 355.6f, 480.0f, 295.3f, 480.0f, 224.0f)
                curveTo(480.0f, 135.6f, 408.4f, 64.0f, 320.0f, 64.0f)
                curveTo(231.6f, 64.0f, 160.0f, 135.6f, 160.0f, 224.0f)
                curveTo(160.0f, 241.7f, 174.3f, 256.0f, 192.0f, 256.0f)
                curveTo(209.7f, 256.0f, 224.0f, 241.7f, 224.0f, 224.0f)
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
        return _question!!
    }

private var _question: ImageVector? = null
