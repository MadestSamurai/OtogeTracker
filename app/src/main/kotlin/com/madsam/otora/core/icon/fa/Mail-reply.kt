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

public val Fa.`Mail-reply`: ImageVector
    get() {
        if (`_mail-reply` != null) {
            return `_mail-reply`!!
        }
        `_mail-reply` = Builder(name = "Mail-reply", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(268.2f, 82.4f)
                curveTo(280.2f, 87.4f, 288.0f, 99.0f, 288.0f, 112.0f)
                lineTo(288.0f, 192.0f)
                lineTo(400.0f, 192.0f)
                curveTo(497.2f, 192.0f, 576.0f, 270.8f, 576.0f, 368.0f)
                curveTo(576.0f, 481.3f, 494.5f, 531.9f, 475.8f, 542.1f)
                curveTo(473.3f, 543.5f, 470.5f, 544.0f, 467.7f, 544.0f)
                curveTo(456.8f, 544.0f, 448.0f, 535.1f, 448.0f, 524.3f)
                curveTo(448.0f, 516.8f, 452.3f, 509.9f, 457.8f, 504.8f)
                curveTo(467.2f, 496.0f, 480.0f, 478.4f, 480.0f, 448.1f)
                curveTo(480.0f, 395.1f, 437.0f, 352.1f, 384.0f, 352.1f)
                lineTo(288.0f, 352.1f)
                lineTo(288.0f, 432.1f)
                curveTo(288.0f, 445.0f, 280.2f, 456.7f, 268.2f, 461.7f)
                curveTo(256.2f, 466.7f, 242.5f, 463.9f, 233.3f, 454.8f)
                lineTo(73.3f, 294.8f)
                curveTo(60.8f, 282.3f, 60.8f, 262.0f, 73.3f, 249.5f)
                lineTo(233.3f, 89.5f)
                curveTo(242.5f, 80.3f, 256.2f, 77.6f, 268.2f, 82.6f)
                close()
            }
        }
        .build()
        return `_mail-reply`!!
    }

private var `_mail-reply`: ImageVector? = null
