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

public val Fa.`Broom-ball`: ImageVector
    get() {
        if (`_broom-ball` != null) {
            return `_broom-ball`!!
        }
        `_broom-ball` = Builder(name = "Broom-ball", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(528.0f, 608.0f)
                curveTo(483.8f, 608.0f, 448.0f, 572.2f, 448.0f, 528.0f)
                curveTo(448.0f, 483.8f, 483.8f, 448.0f, 528.0f, 448.0f)
                curveTo(572.2f, 448.0f, 608.0f, 483.8f, 608.0f, 528.0f)
                curveTo(608.0f, 572.2f, 572.2f, 608.0f, 528.0f, 608.0f)
                close()
                moveTo(138.8f, 341.2f)
                curveTo(169.4f, 310.6f, 211.9f, 295.3f, 254.6f, 299.0f)
                lineTo(373.0f, 417.3f)
                curveTo(376.7f, 460.1f, 361.4f, 502.5f, 330.8f, 533.2f)
                curveTo(303.4f, 560.6f, 266.2f, 576.0f, 227.5f, 576.0f)
                lineTo(54.1f, 576.0f)
                curveTo(41.9f, 576.0f, 32.0f, 566.1f, 32.0f, 553.9f)
                curveTo(32.0f, 547.6f, 34.7f, 541.6f, 39.3f, 537.4f)
                lineTo(165.7f, 423.7f)
                curveTo(169.9f, 420.0f, 165.3f, 413.3f, 160.3f, 415.8f)
                lineTo(109.2f, 441.4f)
                curveTo(103.1f, 444.4f, 96.0f, 440.0f, 96.0f, 433.2f)
                curveTo(96.0f, 401.7f, 108.5f, 371.4f, 130.8f, 349.2f)
                lineTo(138.8f, 341.2f)
                close()
                moveTo(555.8f, 71.2f)
                curveTo(568.4f, 60.9f, 586.9f, 61.7f, 598.6f, 73.4f)
                curveTo(610.3f, 85.1f, 611.0f, 103.6f, 600.8f, 116.2f)
                lineTo(598.6f, 118.6f)
                lineTo(406.6f, 310.6f)
                lineTo(441.4f, 345.3f)
                curveTo(445.6f, 349.5f, 448.0f, 355.3f, 448.0f, 361.3f)
                curveTo(448.0f, 373.8f, 437.9f, 383.9f, 425.4f, 383.9f)
                lineTo(396.3f, 383.9f)
                lineTo(288.0f, 275.6f)
                lineTo(288.0f, 246.5f)
                curveTo(288.0f, 234.0f, 298.1f, 223.9f, 310.6f, 223.9f)
                curveTo(316.6f, 223.9f, 322.4f, 226.3f, 326.6f, 230.5f)
                lineTo(361.4f, 265.2f)
                lineTo(553.4f, 73.2f)
                lineTo(555.8f, 71.0f)
                close()
            }
        }
        .build()
        return `_broom-ball`!!
    }

private var `_broom-ball`: ImageVector? = null
