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

public val Fa.`Mail-reply-all`: ImageVector
    get() {
        if (`_mail-reply-all` != null) {
            return `_mail-reply-all`!!
        }
        `_mail-reply-all` = Builder(name = "Mail-reply-all", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(364.2f, 82.4f)
                curveTo(376.2f, 87.4f, 384.0f, 99.0f, 384.0f, 112.0f)
                lineTo(384.0f, 192.0f)
                lineTo(432.0f, 192.0f)
                curveTo(529.2f, 192.0f, 608.0f, 270.8f, 608.0f, 368.0f)
                curveTo(608.0f, 481.3f, 526.5f, 531.9f, 507.8f, 542.1f)
                curveTo(505.3f, 543.5f, 502.5f, 544.0f, 499.7f, 544.0f)
                curveTo(488.8f, 544.0f, 480.0f, 535.1f, 480.0f, 524.3f)
                curveTo(480.0f, 516.8f, 484.3f, 509.9f, 489.8f, 504.8f)
                curveTo(499.2f, 496.0f, 512.0f, 478.4f, 512.0f, 448.1f)
                curveTo(512.0f, 395.1f, 469.0f, 352.1f, 416.0f, 352.1f)
                lineTo(384.0f, 352.1f)
                lineTo(384.0f, 432.1f)
                curveTo(384.0f, 445.0f, 376.2f, 456.7f, 364.2f, 461.7f)
                curveTo(352.2f, 466.7f, 338.5f, 463.9f, 329.3f, 454.8f)
                lineTo(169.3f, 294.8f)
                curveTo(156.8f, 282.3f, 156.8f, 262.0f, 169.3f, 249.5f)
                lineTo(329.3f, 89.5f)
                curveTo(338.5f, 80.3f, 352.2f, 77.6f, 364.2f, 82.6f)
                close()
                moveTo(237.6f, 87.1f)
                curveTo(247.0f, 96.5f, 247.0f, 111.7f, 237.6f, 121.0f)
                lineTo(86.6f, 272.0f)
                lineTo(237.6f, 422.9f)
                curveTo(247.0f, 432.3f, 247.0f, 447.5f, 237.6f, 456.8f)
                curveTo(228.2f, 466.1f, 213.0f, 466.2f, 203.7f, 456.8f)
                lineTo(42.0f, 295.2f)
                curveTo(35.6f, 289.2f, 32.0f, 280.8f, 32.0f, 272.0f)
                curveTo(32.0f, 263.2f, 35.6f, 254.8f, 42.0f, 248.8f)
                lineTo(203.6f, 87.1f)
                curveTo(213.0f, 77.7f, 228.2f, 77.7f, 237.5f, 87.1f)
                close()
            }
        }
        .build()
        return `_mail-reply-all`!!
    }

private var `_mail-reply-all`: ImageVector? = null
