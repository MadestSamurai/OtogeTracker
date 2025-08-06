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

public val Fa.`Bezier-curve`: ImageVector
    get() {
        if (`_bezier-curve` != null) {
            return `_bezier-curve`!!
        }
        `_bezier-curve` = Builder(name = "Bezier-curve", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(296.0f, 200.0f)
                lineTo(296.0f, 152.0f)
                lineTo(344.0f, 152.0f)
                lineTo(344.0f, 200.0f)
                lineTo(296.0f, 200.0f)
                close()
                moveTo(288.0f, 96.0f)
                curveTo(261.5f, 96.0f, 240.0f, 117.5f, 240.0f, 144.0f)
                lineTo(240.0f, 148.0f)
                lineTo(121.6f, 148.0f)
                curveTo(111.2f, 126.7f, 89.3f, 112.0f, 64.0f, 112.0f)
                curveTo(28.7f, 112.0f, 0.0f, 140.7f, 0.0f, 176.0f)
                curveTo(0.0f, 211.3f, 28.7f, 240.0f, 64.0f, 240.0f)
                curveTo(89.3f, 240.0f, 111.2f, 225.3f, 121.6f, 204.0f)
                lineTo(188.5f, 204.0f)
                curveTo(129.6f, 243.6f, 89.6f, 309.0f, 84.5f, 384.0f)
                lineTo(80.0f, 384.0f)
                curveTo(53.5f, 384.0f, 32.0f, 405.5f, 32.0f, 432.0f)
                lineTo(32.0f, 496.0f)
                curveTo(32.0f, 522.5f, 53.5f, 544.0f, 80.0f, 544.0f)
                lineTo(144.0f, 544.0f)
                curveTo(170.5f, 544.0f, 192.0f, 522.5f, 192.0f, 496.0f)
                lineTo(192.0f, 432.0f)
                curveTo(192.0f, 405.5f, 170.5f, 384.0f, 144.0f, 384.0f)
                lineTo(140.7f, 384.0f)
                curveTo(146.6f, 317.0f, 189.2f, 260.6f, 248.2f, 234.9f)
                curveTo(256.8f, 247.6f, 271.4f, 256.0f, 288.0f, 256.0f)
                lineTo(352.0f, 256.0f)
                curveTo(368.6f, 256.0f, 383.1f, 247.6f, 391.8f, 234.9f)
                curveTo(450.8f, 260.6f, 493.4f, 317.0f, 499.3f, 384.0f)
                lineTo(496.0f, 384.0f)
                curveTo(469.5f, 384.0f, 448.0f, 405.5f, 448.0f, 432.0f)
                lineTo(448.0f, 496.0f)
                curveTo(448.0f, 522.5f, 469.5f, 544.0f, 496.0f, 544.0f)
                lineTo(560.0f, 544.0f)
                curveTo(586.5f, 544.0f, 608.0f, 522.5f, 608.0f, 496.0f)
                lineTo(608.0f, 432.0f)
                curveTo(608.0f, 405.5f, 586.5f, 384.0f, 560.0f, 384.0f)
                lineTo(555.5f, 384.0f)
                curveTo(550.5f, 309.0f, 510.4f, 243.6f, 451.5f, 204.0f)
                lineTo(518.4f, 204.0f)
                curveTo(528.8f, 225.3f, 550.7f, 240.0f, 576.0f, 240.0f)
                curveTo(611.3f, 240.0f, 640.0f, 211.3f, 640.0f, 176.0f)
                curveTo(640.0f, 140.7f, 611.3f, 112.0f, 576.0f, 112.0f)
                curveTo(550.7f, 112.0f, 528.8f, 126.7f, 518.4f, 148.0f)
                lineTo(400.0f, 148.0f)
                lineTo(400.0f, 144.0f)
                curveTo(400.0f, 117.5f, 378.5f, 96.0f, 352.0f, 96.0f)
                lineTo(288.0f, 96.0f)
                close()
                moveTo(88.0f, 440.0f)
                lineTo(136.0f, 440.0f)
                lineTo(136.0f, 488.0f)
                lineTo(88.0f, 488.0f)
                lineTo(88.0f, 440.0f)
                close()
                moveTo(504.0f, 488.0f)
                lineTo(504.0f, 440.0f)
                lineTo(552.0f, 440.0f)
                lineTo(552.0f, 488.0f)
                lineTo(504.0f, 488.0f)
                close()
            }
        }
        .build()
        return `_bezier-curve`!!
    }

private var `_bezier-curve`: ImageVector? = null
