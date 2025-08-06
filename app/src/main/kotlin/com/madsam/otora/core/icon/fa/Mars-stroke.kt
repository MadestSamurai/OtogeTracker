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

public val Fa.`Mars-stroke`: ImageVector
    get() {
        if (`_mars-stroke` != null) {
            return `_mars-stroke`!!
        }
        `_mars-stroke` = Builder(name = "Mars-stroke", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(448.0f, 32.0f)
                curveTo(430.3f, 32.0f, 416.0f, 46.3f, 416.0f, 64.0f)
                curveTo(416.0f, 81.7f, 430.3f, 96.0f, 448.0f, 96.0f)
                lineTo(498.7f, 96.0f)
                lineTo(440.0f, 154.7f)
                lineTo(422.6f, 137.3f)
                curveTo(410.1f, 124.8f, 389.8f, 124.8f, 377.3f, 137.3f)
                curveTo(364.8f, 149.8f, 364.8f, 170.1f, 377.3f, 182.6f)
                lineTo(394.7f, 200.0f)
                lineTo(371.7f, 223.0f)
                curveTo(343.3f, 203.5f, 309.0f, 192.0f, 271.9f, 192.0f)
                curveTo(174.7f, 192.0f, 95.9f, 270.8f, 95.9f, 368.0f)
                curveTo(95.9f, 465.2f, 174.7f, 544.0f, 271.9f, 544.0f)
                curveTo(369.1f, 544.0f, 447.9f, 465.2f, 447.9f, 368.0f)
                curveTo(447.9f, 331.0f, 436.5f, 296.6f, 416.9f, 268.2f)
                lineTo(439.9f, 245.2f)
                lineTo(457.3f, 262.6f)
                curveTo(469.8f, 275.1f, 490.1f, 275.1f, 502.6f, 262.6f)
                curveTo(515.1f, 250.1f, 515.1f, 229.8f, 502.6f, 217.3f)
                lineTo(485.3f, 200.0f)
                lineTo(544.0f, 141.3f)
                lineTo(544.0f, 192.0f)
                curveTo(544.0f, 209.7f, 558.3f, 224.0f, 576.0f, 224.0f)
                curveTo(593.7f, 224.0f, 608.0f, 209.7f, 608.0f, 192.0f)
                lineTo(608.0f, 64.0f)
                curveTo(608.0f, 46.3f, 593.7f, 32.0f, 576.0f, 32.0f)
                lineTo(448.0f, 32.0f)
                close()
                moveTo(160.0f, 368.0f)
                curveTo(160.0f, 306.1f, 210.1f, 256.0f, 272.0f, 256.0f)
                curveTo(333.9f, 256.0f, 384.0f, 306.1f, 384.0f, 368.0f)
                curveTo(384.0f, 429.9f, 333.9f, 480.0f, 272.0f, 480.0f)
                curveTo(210.1f, 480.0f, 160.0f, 429.9f, 160.0f, 368.0f)
                close()
            }
        }
        .build()
        return `_mars-stroke`!!
    }

private var `_mars-stroke`: ImageVector? = null
