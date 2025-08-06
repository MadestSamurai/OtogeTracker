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

public val Fa.Globe: ImageVector
    get() {
        if (_globe != null) {
            return _globe!!
        }
        _globe = Builder(name = "Globe", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(415.9f, 344.0f)
                lineTo(225.0f, 344.0f)
                curveTo(227.9f, 408.5f, 242.2f, 467.9f, 262.5f, 511.4f)
                curveTo(273.9f, 535.9f, 286.2f, 553.2f, 297.6f, 563.8f)
                curveTo(308.8f, 574.3f, 316.5f, 576.0f, 320.5f, 576.0f)
                curveTo(324.5f, 576.0f, 332.2f, 574.3f, 343.4f, 563.8f)
                curveTo(354.8f, 553.2f, 367.1f, 535.8f, 378.5f, 511.4f)
                curveTo(398.8f, 467.9f, 413.1f, 408.5f, 416.0f, 344.0f)
                close()
                moveTo(224.9f, 296.0f)
                lineTo(415.8f, 296.0f)
                curveTo(413.0f, 231.5f, 398.7f, 172.1f, 378.4f, 128.6f)
                curveTo(367.0f, 104.2f, 354.7f, 86.8f, 343.3f, 76.2f)
                curveTo(332.1f, 65.7f, 324.4f, 64.0f, 320.4f, 64.0f)
                curveTo(316.4f, 64.0f, 308.7f, 65.7f, 297.5f, 76.2f)
                curveTo(286.1f, 86.8f, 273.8f, 104.2f, 262.4f, 128.6f)
                curveTo(242.1f, 172.1f, 227.8f, 231.5f, 224.9f, 296.0f)
                close()
                moveTo(176.9f, 296.0f)
                curveTo(180.4f, 210.4f, 202.5f, 130.9f, 234.8f, 78.7f)
                curveTo(142.7f, 111.3f, 74.9f, 195.2f, 65.5f, 296.0f)
                lineTo(176.9f, 296.0f)
                close()
                moveTo(65.5f, 344.0f)
                curveTo(74.9f, 444.8f, 142.7f, 528.7f, 234.8f, 561.3f)
                curveTo(202.5f, 509.1f, 180.4f, 429.6f, 176.9f, 344.0f)
                lineTo(65.5f, 344.0f)
                close()
                moveTo(463.9f, 344.0f)
                curveTo(460.4f, 429.6f, 438.3f, 509.1f, 406.0f, 561.3f)
                curveTo(498.1f, 528.6f, 565.9f, 444.8f, 575.3f, 344.0f)
                lineTo(463.9f, 344.0f)
                close()
                moveTo(575.3f, 296.0f)
                curveTo(565.9f, 195.2f, 498.1f, 111.3f, 406.0f, 78.7f)
                curveTo(438.3f, 130.9f, 460.4f, 210.4f, 463.9f, 296.0f)
                lineTo(575.3f, 296.0f)
                close()
            }
        }
        .build()
        return _globe!!
    }

private var _globe: ImageVector? = null
