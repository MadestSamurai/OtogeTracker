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

public val Fa.`Mail-forward`: ImageVector
    get() {
        if (`_mail-forward` != null) {
            return `_mail-forward`!!
        }
        `_mail-forward` = Builder(name = "Mail-forward", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(371.8f, 82.4f)
                curveTo(359.8f, 87.4f, 352.0f, 99.0f, 352.0f, 112.0f)
                lineTo(352.0f, 192.0f)
                lineTo(240.0f, 192.0f)
                curveTo(142.8f, 192.0f, 64.0f, 270.8f, 64.0f, 368.0f)
                curveTo(64.0f, 481.3f, 145.5f, 531.9f, 164.2f, 542.1f)
                curveTo(166.7f, 543.5f, 169.5f, 544.0f, 172.3f, 544.0f)
                curveTo(183.2f, 544.0f, 192.0f, 535.1f, 192.0f, 524.3f)
                curveTo(192.0f, 516.8f, 187.7f, 509.9f, 182.2f, 504.8f)
                curveTo(172.8f, 496.0f, 160.0f, 478.4f, 160.0f, 448.1f)
                curveTo(160.0f, 395.1f, 203.0f, 352.1f, 256.0f, 352.1f)
                lineTo(352.0f, 352.1f)
                lineTo(352.0f, 432.1f)
                curveTo(352.0f, 445.0f, 359.8f, 456.7f, 371.8f, 461.7f)
                curveTo(383.8f, 466.7f, 397.5f, 463.9f, 406.7f, 454.8f)
                lineTo(566.7f, 294.8f)
                curveTo(579.2f, 282.3f, 579.2f, 262.0f, 566.7f, 249.5f)
                lineTo(406.7f, 89.5f)
                curveTo(397.5f, 80.3f, 383.8f, 77.6f, 371.8f, 82.6f)
                close()
            }
        }
        .build()
        return `_mail-forward`!!
    }

private var `_mail-forward`: ImageVector? = null
