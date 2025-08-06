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

public val Fa.`Fighter-jet`: ImageVector
    get() {
        if (`_fighter-jet` != null) {
            return `_fighter-jet`!!
        }
        `_fighter-jet` = Builder(name = "Fighter-jet", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(528.2f, 270.8f)
                curveTo(517.5f, 266.3f, 506.0f, 264.0f, 494.4f, 264.0f)
                lineTo(394.0f, 264.0f)
                lineTo(280.0f, 112.0f)
                lineTo(328.0f, 112.0f)
                curveTo(341.3f, 112.0f, 352.0f, 101.3f, 352.0f, 88.0f)
                curveTo(352.0f, 74.7f, 341.3f, 64.0f, 328.0f, 64.0f)
                lineTo(184.0f, 64.0f)
                curveTo(170.7f, 64.0f, 160.0f, 74.7f, 160.0f, 88.0f)
                curveTo(160.0f, 101.3f, 170.7f, 112.0f, 184.0f, 112.0f)
                lineTo(192.0f, 112.0f)
                lineTo(192.0f, 264.0f)
                lineTo(137.6f, 264.0f)
                lineTo(84.8f, 198.0f)
                curveTo(81.8f, 194.2f, 77.2f, 192.0f, 72.3f, 192.0f)
                lineTo(48.0f, 192.0f)
                curveTo(39.2f, 192.0f, 32.0f, 199.2f, 32.0f, 208.0f)
                lineTo(32.0f, 296.0f)
                lineTo(72.0f, 296.0f)
                curveTo(85.3f, 296.0f, 96.0f, 306.7f, 96.0f, 320.0f)
                curveTo(96.0f, 333.3f, 85.3f, 344.0f, 72.0f, 344.0f)
                lineTo(32.0f, 344.0f)
                lineTo(32.0f, 432.0f)
                curveTo(32.0f, 440.8f, 39.2f, 448.0f, 48.0f, 448.0f)
                lineTo(72.3f, 448.0f)
                curveTo(77.2f, 448.0f, 81.8f, 445.8f, 84.8f, 442.0f)
                lineTo(137.6f, 376.0f)
                lineTo(192.0f, 376.0f)
                lineTo(192.0f, 528.0f)
                lineTo(184.0f, 528.0f)
                curveTo(170.7f, 528.0f, 160.0f, 538.7f, 160.0f, 552.0f)
                curveTo(160.0f, 565.3f, 170.7f, 576.0f, 184.0f, 576.0f)
                lineTo(328.0f, 576.0f)
                curveTo(341.3f, 576.0f, 352.0f, 565.3f, 352.0f, 552.0f)
                curveTo(352.0f, 538.7f, 341.3f, 528.0f, 328.0f, 528.0f)
                lineTo(280.0f, 528.0f)
                lineTo(394.0f, 376.0f)
                lineTo(494.4f, 376.0f)
                curveTo(506.0f, 376.0f, 517.5f, 373.7f, 528.2f, 369.2f)
                lineTo(593.2f, 342.1f)
                curveTo(602.1f, 338.4f, 608.0f, 329.6f, 608.0f, 319.9f)
                curveTo(608.0f, 310.2f, 602.2f, 301.5f, 593.2f, 297.7f)
                lineTo(528.2f, 270.6f)
                close()
            }
        }
        .build()
        return `_fighter-jet`!!
    }

private var `_fighter-jet`: ImageVector? = null
