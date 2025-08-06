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

public val Fa.`Pizza-slice`: ImageVector
    get() {
        if (`_pizza-slice` != null) {
            return `_pizza-slice`!!
        }
        `_pizza-slice` = Builder(name = "Pizza-slice", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(233.7f, 64.9f)
                curveTo(210.9f, 63.3f, 191.8f, 78.9f, 186.2f, 99.6f)
                lineTo(176.5f, 136.0f)
                curveTo(357.3f, 136.3f, 503.7f, 282.7f, 504.0f, 463.5f)
                lineTo(540.4f, 453.8f)
                curveTo(561.2f, 448.3f, 576.7f, 429.1f, 575.1f, 406.3f)
                curveTo(562.5f, 223.5f, 416.5f, 77.5f, 233.7f, 64.9f)
                close()
                moveTo(455.7f, 476.4f)
                curveTo(455.9f, 472.3f, 456.0f, 468.2f, 456.0f, 464.0f)
                curveTo(456.0f, 309.4f, 330.6f, 184.0f, 176.0f, 184.0f)
                curveTo(171.9f, 184.0f, 167.7f, 184.1f, 163.6f, 184.3f)
                lineTo(64.5f, 555.9f)
                curveTo(63.0f, 561.4f, 64.6f, 567.3f, 68.6f, 571.3f)
                curveTo(72.6f, 575.3f, 78.5f, 576.9f, 84.0f, 575.4f)
                lineTo(455.6f, 476.3f)
                close()
                moveTo(240.0f, 272.0f)
                curveTo(257.7f, 272.0f, 272.0f, 286.3f, 272.0f, 304.0f)
                curveTo(272.0f, 321.7f, 257.7f, 336.0f, 240.0f, 336.0f)
                curveTo(222.3f, 336.0f, 208.0f, 321.7f, 208.0f, 304.0f)
                curveTo(208.0f, 286.3f, 222.3f, 272.0f, 240.0f, 272.0f)
                close()
                moveTo(304.0f, 400.0f)
                curveTo(304.0f, 382.3f, 318.3f, 368.0f, 336.0f, 368.0f)
                curveTo(353.7f, 368.0f, 368.0f, 382.3f, 368.0f, 400.0f)
                curveTo(368.0f, 417.7f, 353.7f, 432.0f, 336.0f, 432.0f)
                curveTo(318.3f, 432.0f, 304.0f, 417.7f, 304.0f, 400.0f)
                close()
                moveTo(160.0f, 448.0f)
                curveTo(160.0f, 430.3f, 174.3f, 416.0f, 192.0f, 416.0f)
                curveTo(209.7f, 416.0f, 224.0f, 430.3f, 224.0f, 448.0f)
                curveTo(224.0f, 465.7f, 209.7f, 480.0f, 192.0f, 480.0f)
                curveTo(174.3f, 480.0f, 160.0f, 465.7f, 160.0f, 448.0f)
                close()
            }
        }
        .build()
        return `_pizza-slice`!!
    }

private var `_pizza-slice`: ImageVector? = null
