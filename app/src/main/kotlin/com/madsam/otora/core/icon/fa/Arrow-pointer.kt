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

public val Fa.`Arrow-pointer`: ImageVector
    get() {
        if (`_arrow-pointer` != null) {
            return `_arrow-pointer`!!
        }
        `_arrow-pointer` = Builder(name = "Arrow-pointer", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(173.3f, 66.5f)
                curveTo(181.4f, 62.4f, 191.2f, 63.3f, 198.4f, 68.8f)
                lineTo(518.4f, 308.7f)
                curveTo(526.7f, 314.9f, 530.0f, 325.7f, 526.8f, 335.5f)
                curveTo(523.6f, 345.3f, 514.4f, 351.9f, 504.0f, 351.9f)
                lineTo(351.7f, 351.9f)
                lineTo(440.6f, 529.6f)
                curveTo(448.5f, 545.4f, 442.1f, 564.6f, 426.3f, 572.5f)
                curveTo(410.5f, 580.4f, 391.3f, 574.0f, 383.4f, 558.2f)
                lineTo(294.5f, 380.5f)
                lineTo(203.2f, 502.3f)
                curveTo(197.0f, 510.6f, 186.2f, 513.9f, 176.4f, 510.7f)
                curveTo(166.6f, 507.5f, 160.0f, 498.3f, 160.0f, 488.0f)
                lineTo(160.0f, 88.0f)
                curveTo(160.0f, 78.9f, 165.1f, 70.6f, 173.3f, 66.5f)
                close()
            }
        }
        .build()
        return `_arrow-pointer`!!
    }

private var `_arrow-pointer`: ImageVector? = null
