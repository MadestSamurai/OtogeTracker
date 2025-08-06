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

public val Fa.`Fish-fins`: ImageVector
    get() {
        if (`_fish-fins` != null) {
            return `_fish-fins`!!
        }
        `_fish-fins` = Builder(name = "Fish-fins", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(307.2f, 102.4f)
                curveTo(296.6f, 94.4f, 282.2f, 93.9f, 270.9f, 100.9f)
                curveTo(259.6f, 107.9f, 254.0f, 121.3f, 256.6f, 134.3f)
                lineTo(266.3f, 182.9f)
                curveTo(246.9f, 191.9f, 229.4f, 202.8f, 213.9f, 214.4f)
                curveTo(198.6f, 225.9f, 184.9f, 238.3f, 173.2f, 250.7f)
                lineTo(80.1f, 196.4f)
                curveTo(67.6f, 189.1f, 51.7f, 191.1f, 41.4f, 201.3f)
                curveTo(31.1f, 211.5f, 29.0f, 227.3f, 36.1f, 239.9f)
                lineTo(82.0f, 320.0f)
                lineTo(36.2f, 400.1f)
                curveTo(29.0f, 412.7f, 31.2f, 428.5f, 41.5f, 438.7f)
                curveTo(51.8f, 448.9f, 67.6f, 450.9f, 80.2f, 443.6f)
                lineTo(173.3f, 389.3f)
                curveTo(185.1f, 401.6f, 198.7f, 414.1f, 214.0f, 425.6f)
                curveTo(229.5f, 437.2f, 247.0f, 448.1f, 266.4f, 457.1f)
                lineTo(256.7f, 505.7f)
                curveTo(254.1f, 518.7f, 259.8f, 532.0f, 271.0f, 539.0f)
                curveTo(282.2f, 546.0f, 296.6f, 545.5f, 307.3f, 537.5f)
                lineTo(384.9f, 479.3f)
                curveTo(439.8f, 475.3f, 486.4f, 452.3f, 522.1f, 425.5f)
                curveTo(561.3f, 396.1f, 589.3f, 360.8f, 603.7f, 336.0f)
                curveTo(609.5f, 326.1f, 609.5f, 313.8f, 603.7f, 303.9f)
                curveTo(589.3f, 279.1f, 561.2f, 243.8f, 522.1f, 214.4f)
                curveTo(486.3f, 187.6f, 439.8f, 164.6f, 384.9f, 160.6f)
                lineTo(307.2f, 102.4f)
                close()
                moveTo(416.0f, 320.0f)
                curveTo(416.0f, 302.3f, 430.3f, 288.0f, 448.0f, 288.0f)
                curveTo(465.7f, 288.0f, 480.0f, 302.3f, 480.0f, 320.0f)
                curveTo(480.0f, 337.7f, 465.7f, 352.0f, 448.0f, 352.0f)
                curveTo(430.3f, 352.0f, 416.0f, 337.7f, 416.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_fish-fins`!!
    }

private var `_fish-fins`: ImageVector? = null
