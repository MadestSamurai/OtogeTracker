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

public val Fa.`Person-snowboarding`: ImageVector
    get() {
        if (`_person-snowboarding` != null) {
            return `_person-snowboarding`!!
        }
        `_person-snowboarding` = Builder(name = "Person-snowboarding", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(456.5f, 80.0f)
                curveTo(487.4f, 80.0f, 512.5f, 105.1f, 512.5f, 136.0f)
                curveTo(512.5f, 166.9f, 487.4f, 192.0f, 456.5f, 192.0f)
                curveTo(425.6f, 192.0f, 400.5f, 166.9f, 400.5f, 136.0f)
                curveTo(400.5f, 105.1f, 425.6f, 80.0f, 456.5f, 80.0f)
                close()
                moveTo(198.4f, 109.5f)
                curveTo(208.6f, 95.1f, 228.6f, 91.6f, 243.0f, 101.8f)
                lineTo(515.0f, 293.8f)
                curveTo(529.4f, 304.0f, 532.9f, 324.0f, 522.7f, 338.4f)
                curveTo(512.5f, 352.8f, 492.5f, 356.3f, 478.1f, 346.1f)
                lineTo(385.9f, 281.0f)
                lineTo(323.7f, 334.3f)
                lineTo(355.8f, 361.0f)
                curveTo(374.0f, 376.2f, 384.6f, 398.7f, 384.6f, 422.5f)
                lineTo(384.6f, 510.3f)
                lineTo(462.1f, 525.5f)
                curveTo(468.3f, 526.7f, 474.7f, 526.4f, 480.8f, 524.7f)
                lineTo(522.0f, 512.9f)
                curveTo(534.7f, 509.3f, 548.0f, 516.6f, 551.7f, 529.4f)
                curveTo(555.4f, 542.2f, 548.0f, 555.4f, 535.2f, 559.1f)
                lineTo(494.0f, 570.9f)
                curveTo(480.6f, 574.7f, 466.6f, 575.3f, 452.9f, 572.7f)
                lineTo(119.1f, 507.3f)
                curveTo(101.9f, 503.9f, 86.1f, 495.5f, 73.8f, 483.2f)
                lineTo(47.5f, 457.0f)
                curveTo(38.1f, 447.6f, 38.1f, 432.4f, 47.5f, 423.1f)
                curveTo(56.9f, 413.8f, 72.1f, 413.7f, 81.4f, 423.1f)
                lineTo(107.6f, 449.3f)
                curveTo(113.2f, 454.9f, 120.4f, 458.7f, 128.2f, 460.3f)
                lineTo(192.4f, 472.9f)
                lineTo(192.4f, 349.2f)
                curveTo(192.4f, 321.5f, 204.4f, 295.2f, 225.2f, 277.0f)
                lineTo(294.2f, 216.6f)
                lineTo(206.0f, 154.3f)
                curveTo(191.6f, 144.0f, 188.2f, 124.0f, 198.4f, 109.5f)
                close()
                moveTo(256.5f, 485.2f)
                lineTo(320.5f, 497.7f)
                lineTo(320.5f, 422.4f)
                curveTo(320.5f, 417.7f, 318.4f, 413.1f, 314.7f, 410.1f)
                lineTo(256.5f, 361.6f)
                lineTo(256.5f, 485.2f)
                close()
            }
        }
        .build()
        return `_person-snowboarding`!!
    }

private var `_person-snowboarding`: ImageVector? = null
