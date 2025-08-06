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

public val Fa.Tornado: ImageVector
    get() {
        if (_tornado != null) {
            return _tornado!!
        }
        _tornado = Builder(name = "Tornado", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 96.0f)
                lineTo(96.0f, 109.6f)
                curveTo(96.0f, 126.7f, 97.7f, 143.6f, 101.0f, 160.0f)
                lineTo(453.8f, 160.0f)
                curveTo(457.0f, 153.1f, 461.3f, 146.7f, 466.8f, 141.2f)
                lineTo(505.4f, 102.6f)
                curveTo(509.6f, 98.4f, 512.0f, 92.6f, 512.0f, 86.6f)
                curveTo(512.0f, 74.1f, 501.9f, 64.0f, 489.4f, 64.0f)
                lineTo(128.0f, 64.0f)
                curveTo(110.3f, 64.0f, 96.0f, 78.3f, 96.0f, 96.0f)
                close()
                moveTo(451.7f, 208.0f)
                lineTo(115.7f, 208.0f)
                curveTo(128.1f, 237.7f, 145.9f, 264.8f, 168.4f, 288.0f)
                lineTo(508.0f, 288.0f)
                lineTo(460.8f, 225.1f)
                curveTo(456.9f, 219.9f, 453.8f, 214.1f, 451.6f, 208.0f)
                close()
                moveTo(338.6f, 398.7f)
                curveTo(346.8f, 403.5f, 354.4f, 409.4f, 361.1f, 416.0f)
                lineTo(541.0f, 416.0f)
                curveTo(543.0f, 406.2f, 544.0f, 396.1f, 544.0f, 385.9f)
                curveTo(544.0f, 368.8f, 541.1f, 351.9f, 535.4f, 336.0f)
                lineTo(232.0f, 336.0f)
                lineTo(338.6f, 398.7f)
                close()
                moveTo(390.3f, 464.0f)
                curveTo(395.6f, 481.0f, 396.8f, 499.2f, 393.9f, 517.0f)
                lineTo(388.0f, 552.7f)
                curveTo(386.0f, 564.9f, 395.4f, 576.1f, 407.8f, 576.1f)
                curveTo(413.1f, 576.1f, 418.2f, 574.0f, 422.0f, 570.2f)
                lineTo(500.2f, 492.0f)
                curveTo(508.7f, 483.5f, 516.0f, 474.2f, 522.1f, 464.1f)
                lineTo(390.3f, 464.1f)
                close()
            }
        }
        .build()
        return _tornado!!
    }

private var _tornado: ImageVector? = null
