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

public val Fa.`Person-praying`: ImageVector
    get() {
        if (`_person-praying` != null) {
            return `_person-praying`!!
        }
        `_person-praying` = Builder(name = "Person-praying", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(448.0f, 128.0f)
                curveTo(448.0f, 92.7f, 419.3f, 64.0f, 384.0f, 64.0f)
                curveTo(348.7f, 64.0f, 320.0f, 92.7f, 320.0f, 128.0f)
                curveTo(320.0f, 163.3f, 348.7f, 192.0f, 384.0f, 192.0f)
                curveTo(419.3f, 192.0f, 448.0f, 163.3f, 448.0f, 128.0f)
                close()
                moveTo(328.7f, 328.0f)
                lineTo(351.6f, 359.5f)
                curveTo(358.1f, 368.4f, 367.9f, 374.2f, 378.8f, 375.6f)
                curveTo(389.7f, 377.0f, 400.7f, 373.9f, 409.2f, 366.9f)
                lineTo(497.2f, 294.9f)
                curveTo(514.3f, 280.9f, 516.8f, 255.7f, 502.8f, 238.6f)
                curveTo(488.8f, 221.5f, 463.6f, 219.0f, 446.5f, 233.0f)
                lineTo(391.3f, 278.2f)
                lineTo(365.1f, 242.2f)
                curveTo(349.5f, 220.7f, 324.5f, 208.0f, 297.9f, 208.0f)
                curveTo(267.0f, 208.0f, 238.7f, 225.1f, 224.3f, 252.4f)
                lineTo(175.8f, 344.9f)
                curveTo(155.6f, 383.4f, 166.4f, 430.8f, 201.4f, 456.7f)
                lineTo(254.6f, 496.0f)
                lineTo(168.0f, 496.0f)
                curveTo(145.9f, 496.0f, 128.0f, 513.9f, 128.0f, 536.0f)
                curveTo(128.0f, 558.1f, 145.9f, 576.0f, 168.0f, 576.0f)
                lineTo(376.0f, 576.0f)
                curveTo(393.3f, 576.0f, 408.6f, 564.9f, 414.0f, 548.5f)
                curveTo(419.4f, 532.1f, 413.7f, 514.1f, 399.8f, 503.8f)
                lineTo(283.7f, 418.0f)
                lineTo(328.7f, 328.0f)
                close()
            }
        }
        .build()
        return `_person-praying`!!
    }

private var `_person-praying`: ImageVector? = null
