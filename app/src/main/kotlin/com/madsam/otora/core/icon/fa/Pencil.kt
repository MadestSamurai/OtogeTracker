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

public val Fa.Pencil: ImageVector
    get() {
        if (_pencil != null) {
            return _pencil!!
        }
        _pencil = Builder(name = "Pencil", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(100.4f, 417.2f)
                curveTo(104.5f, 402.6f, 112.2f, 389.3f, 123.0f, 378.5f)
                lineTo(304.2f, 197.3f)
                lineTo(338.1f, 163.4f)
                curveTo(354.7f, 180.0f, 389.4f, 214.7f, 442.1f, 267.4f)
                lineTo(476.0f, 301.3f)
                lineTo(442.1f, 335.2f)
                lineTo(260.9f, 516.4f)
                curveTo(250.2f, 527.1f, 236.8f, 534.9f, 222.2f, 539.0f)
                lineTo(94.4f, 574.6f)
                curveTo(86.1f, 576.9f, 77.1f, 574.6f, 71.0f, 568.4f)
                curveTo(64.9f, 562.2f, 62.6f, 553.3f, 64.9f, 545.0f)
                lineTo(100.4f, 417.2f)
                close()
                moveTo(156.0f, 413.5f)
                curveTo(151.6f, 418.2f, 148.4f, 423.9f, 146.7f, 430.1f)
                lineTo(122.6f, 517.0f)
                lineTo(209.5f, 492.9f)
                curveTo(215.9f, 491.1f, 221.7f, 487.8f, 226.5f, 483.2f)
                lineTo(155.9f, 413.5f)
                close()
                moveTo(510.0f, 267.4f)
                curveTo(493.4f, 250.8f, 458.7f, 216.1f, 406.0f, 163.4f)
                lineTo(372.0f, 129.5f)
                curveTo(398.5f, 103.0f, 413.4f, 88.1f, 416.9f, 84.6f)
                curveTo(430.4f, 71.0f, 448.8f, 63.4f, 468.0f, 63.4f)
                curveTo(487.2f, 63.4f, 505.6f, 71.0f, 519.1f, 84.6f)
                lineTo(554.8f, 120.3f)
                curveTo(568.4f, 133.9f, 576.0f, 152.3f, 576.0f, 171.4f)
                curveTo(576.0f, 190.5f, 568.4f, 209.0f, 554.8f, 222.5f)
                curveTo(551.3f, 226.0f, 536.4f, 240.9f, 509.9f, 267.4f)
                close()
            }
        }
        .build()
        return _pencil!!
    }

private var _pencil: ImageVector? = null
