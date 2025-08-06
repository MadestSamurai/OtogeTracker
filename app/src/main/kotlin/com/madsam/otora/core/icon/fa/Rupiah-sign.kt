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

public val Fa.`Rupiah-sign`: ImageVector
    get() {
        if (`_rupiah-sign` != null) {
            return `_rupiah-sign`!!
        }
        `_rupiah-sign` = Builder(name = "Rupiah-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 128.0f)
                curveTo(64.0f, 110.3f, 78.3f, 96.0f, 96.0f, 96.0f)
                lineTo(176.0f, 96.0f)
                curveTo(255.5f, 96.0f, 320.0f, 160.5f, 320.0f, 240.0f)
                curveTo(320.0f, 294.3f, 290.0f, 341.5f, 245.6f, 366.1f)
                lineTo(286.6f, 502.8f)
                curveTo(291.7f, 519.7f, 282.1f, 537.6f, 265.1f, 542.6f)
                curveTo(248.1f, 547.6f, 230.3f, 538.1f, 225.3f, 521.1f)
                lineTo(184.1f, 383.8f)
                curveTo(181.4f, 383.9f, 178.7f, 384.0f, 176.0f, 384.0f)
                lineTo(128.0f, 384.0f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 529.7f, 113.7f, 544.0f, 96.0f, 544.0f)
                curveTo(78.3f, 544.0f, 64.0f, 529.7f, 64.0f, 512.0f)
                lineTo(64.0f, 128.0f)
                close()
                moveTo(128.0f, 320.0f)
                lineTo(176.0f, 320.0f)
                curveTo(220.2f, 320.0f, 256.0f, 284.2f, 256.0f, 240.0f)
                curveTo(256.0f, 195.8f, 220.2f, 160.0f, 176.0f, 160.0f)
                lineTo(128.0f, 160.0f)
                lineTo(128.0f, 320.0f)
                close()
                moveTo(384.0f, 288.0f)
                lineTo(464.0f, 288.0f)
                curveTo(525.9f, 288.0f, 576.0f, 338.1f, 576.0f, 400.0f)
                curveTo(576.0f, 461.9f, 525.9f, 512.0f, 464.0f, 512.0f)
                lineTo(416.0f, 512.0f)
                lineTo(416.0f, 576.0f)
                curveTo(416.0f, 593.7f, 401.7f, 608.0f, 384.0f, 608.0f)
                curveTo(366.3f, 608.0f, 352.0f, 593.7f, 352.0f, 576.0f)
                lineTo(352.0f, 320.0f)
                curveTo(352.0f, 302.3f, 366.3f, 288.0f, 384.0f, 288.0f)
                close()
                moveTo(464.0f, 448.0f)
                curveTo(490.5f, 448.0f, 512.0f, 426.5f, 512.0f, 400.0f)
                curveTo(512.0f, 373.5f, 490.5f, 352.0f, 464.0f, 352.0f)
                lineTo(416.0f, 352.0f)
                lineTo(416.0f, 448.0f)
                lineTo(464.0f, 448.0f)
                close()
            }
        }
        .build()
        return `_rupiah-sign`!!
    }

private var `_rupiah-sign`: ImageVector? = null
