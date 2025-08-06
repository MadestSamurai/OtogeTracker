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

public val Fa.`Arrow-right-to-bracket`: ImageVector
    get() {
        if (`_arrow-right-to-bracket` != null) {
            return `_arrow-right-to-bracket`!!
        }
        `_arrow-right-to-bracket` = Builder(name = "Arrow-right-to-bracket", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(416.0f, 160.0f)
                lineTo(480.0f, 160.0f)
                curveTo(497.7f, 160.0f, 512.0f, 174.3f, 512.0f, 192.0f)
                lineTo(512.0f, 448.0f)
                curveTo(512.0f, 465.7f, 497.7f, 480.0f, 480.0f, 480.0f)
                lineTo(416.0f, 480.0f)
                curveTo(398.3f, 480.0f, 384.0f, 494.3f, 384.0f, 512.0f)
                curveTo(384.0f, 529.7f, 398.3f, 544.0f, 416.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(533.0f, 544.0f, 576.0f, 501.0f, 576.0f, 448.0f)
                lineTo(576.0f, 192.0f)
                curveTo(576.0f, 139.0f, 533.0f, 96.0f, 480.0f, 96.0f)
                lineTo(416.0f, 96.0f)
                curveTo(398.3f, 96.0f, 384.0f, 110.3f, 384.0f, 128.0f)
                curveTo(384.0f, 145.7f, 398.3f, 160.0f, 416.0f, 160.0f)
                close()
                moveTo(406.6f, 342.6f)
                curveTo(419.1f, 330.1f, 419.1f, 309.8f, 406.6f, 297.3f)
                lineTo(278.6f, 169.3f)
                curveTo(266.1f, 156.8f, 245.8f, 156.8f, 233.3f, 169.3f)
                curveTo(220.8f, 181.8f, 220.8f, 202.1f, 233.3f, 214.6f)
                lineTo(306.7f, 288.0f)
                lineTo(96.0f, 288.0f)
                curveTo(78.3f, 288.0f, 64.0f, 302.3f, 64.0f, 320.0f)
                curveTo(64.0f, 337.7f, 78.3f, 352.0f, 96.0f, 352.0f)
                lineTo(306.7f, 352.0f)
                lineTo(233.3f, 425.4f)
                curveTo(220.8f, 437.9f, 220.8f, 458.2f, 233.3f, 470.7f)
                curveTo(245.8f, 483.2f, 266.1f, 483.2f, 278.6f, 470.7f)
                lineTo(406.6f, 342.7f)
                close()
            }
        }
        .build()
        return `_arrow-right-to-bracket`!!
    }

private var `_arrow-right-to-bracket`: ImageVector? = null
