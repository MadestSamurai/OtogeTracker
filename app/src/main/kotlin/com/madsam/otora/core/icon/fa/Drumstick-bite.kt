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

public val Fa.`Drumstick-bite`: ImageVector
    get() {
        if (`_drumstick-bite` != null) {
            return `_drumstick-bite`!!
        }
        `_drumstick-bite` = Builder(name = "Drumstick-bite", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 329.2f)
                curveTo(224.0f, 337.7f, 220.6f, 345.8f, 214.6f, 351.8f)
                lineTo(187.8f, 378.6f)
                curveTo(175.5f, 390.9f, 155.3f, 390.0f, 138.4f, 385.8f)
                curveTo(133.8f, 384.7f, 128.9f, 384.0f, 123.9f, 384.0f)
                curveTo(90.8f, 384.0f, 63.9f, 410.9f, 63.9f, 444.0f)
                curveTo(63.9f, 477.1f, 90.8f, 504.0f, 123.9f, 504.0f)
                curveTo(130.2f, 504.0f, 135.9f, 509.7f, 135.9f, 516.0f)
                curveTo(135.9f, 549.1f, 162.8f, 576.0f, 195.9f, 576.0f)
                curveTo(229.0f, 576.0f, 255.9f, 549.1f, 255.9f, 516.0f)
                curveTo(255.9f, 511.0f, 255.3f, 506.2f, 254.1f, 501.5f)
                curveTo(249.9f, 484.6f, 248.9f, 464.4f, 261.3f, 452.1f)
                lineTo(288.1f, 425.3f)
                curveTo(294.1f, 419.3f, 302.2f, 415.9f, 310.7f, 415.9f)
                lineTo(399.9f, 415.9f)
                curveTo(406.2f, 415.9f, 412.3f, 415.6f, 418.4f, 414.9f)
                curveTo(430.3f, 413.7f, 434.8f, 399.4f, 429.2f, 388.9f)
                curveTo(420.7f, 373.1f, 415.9f, 355.1f, 415.9f, 335.9f)
                curveTo(415.9f, 274.0f, 466.0f, 223.9f, 527.9f, 223.9f)
                curveTo(535.9f, 223.9f, 543.6f, 224.7f, 551.1f, 226.3f)
                curveTo(562.8f, 228.8f, 575.2f, 220.4f, 573.1f, 208.7f)
                curveTo(558.4f, 126.4f, 486.4f, 63.9f, 399.9f, 63.9f)
                curveTo(302.7f, 63.9f, 223.9f, 142.7f, 223.9f, 239.9f)
                lineTo(223.9f, 329.1f)
                close()
            }
        }
        .build()
        return `_drumstick-bite`!!
    }

private var `_drumstick-bite`: ImageVector? = null
