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

public val Fa.`Virus-slash`: ImageVector
    get() {
        if (`_virus-slash` != null) {
            return `_virus-slash`!!
        }
        `_virus-slash` = Builder(name = "Virus-slash", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(512.3f, 478.6f)
                curveTo(514.0f, 466.5f, 510.3f, 453.8f, 501.0f, 444.6f)
                curveTo(469.8f, 413.4f, 491.9f, 360.1f, 536.0f, 360.1f)
                curveTo(558.1f, 360.1f, 576.0f, 342.2f, 576.0f, 320.1f)
                curveTo(576.0f, 298.0f, 558.1f, 280.1f, 536.0f, 280.1f)
                curveTo(491.9f, 280.1f, 469.9f, 226.8f, 501.0f, 195.6f)
                curveTo(516.6f, 180.0f, 516.6f, 154.7f, 501.0f, 139.0f)
                curveTo(485.4f, 123.3f, 460.1f, 123.4f, 444.4f, 139.0f)
                curveTo(413.2f, 170.2f, 359.9f, 148.1f, 359.9f, 104.0f)
                curveTo(359.9f, 81.9f, 342.0f, 64.0f, 319.9f, 64.0f)
                curveTo(297.8f, 64.0f, 279.9f, 81.9f, 279.9f, 104.0f)
                curveTo(279.9f, 148.1f, 226.6f, 170.1f, 195.4f, 139.0f)
                curveTo(186.1f, 129.7f, 173.4f, 126.0f, 161.4f, 127.7f)
                lineTo(73.0f, 39.1f)
                close()
                moveTo(104.0f, 280.0f)
                curveTo(81.9f, 280.0f, 64.0f, 297.9f, 64.0f, 320.0f)
                curveTo(64.0f, 342.1f, 81.9f, 360.0f, 104.0f, 360.0f)
                curveTo(148.1f, 360.0f, 170.1f, 413.3f, 139.0f, 444.5f)
                curveTo(123.4f, 460.1f, 123.4f, 485.4f, 139.0f, 501.1f)
                curveTo(154.6f, 516.8f, 179.9f, 516.7f, 195.6f, 501.1f)
                curveTo(226.8f, 469.9f, 280.1f, 492.0f, 280.1f, 536.1f)
                curveTo(280.1f, 558.2f, 298.0f, 576.1f, 320.1f, 576.1f)
                curveTo(342.2f, 576.1f, 360.1f, 558.2f, 360.1f, 536.1f)
                curveTo(360.1f, 514.7f, 372.7f, 498.5f, 389.2f, 491.0f)
                lineTo(149.2f, 251.0f)
                curveTo(141.6f, 267.4f, 125.4f, 280.0f, 104.0f, 280.0f)
                close()
            }
        }
        .build()
        return `_virus-slash`!!
    }

private var `_virus-slash`: ImageVector? = null
