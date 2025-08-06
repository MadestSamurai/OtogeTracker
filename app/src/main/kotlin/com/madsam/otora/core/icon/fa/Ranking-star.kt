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

public val Fa.`Ranking-star`: ImageVector
    get() {
        if (`_ranking-star` != null) {
            return `_ranking-star`!!
        }
        `_ranking-star` = Builder(name = "Ranking-star", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(353.8f, 118.1f)
                lineTo(330.2f, 70.3f)
                curveTo(326.3f, 62.0f, 314.1f, 61.7f, 309.8f, 70.3f)
                lineTo(286.2f, 118.1f)
                lineTo(233.9f, 125.6f)
                curveTo(224.6f, 127.0f, 220.6f, 138.5f, 227.5f, 145.4f)
                lineTo(265.5f, 182.4f)
                lineTo(256.5f, 234.5f)
                curveTo(255.1f, 243.8f, 264.7f, 251.0f, 273.3f, 246.7f)
                lineTo(320.2f, 221.9f)
                lineTo(366.8f, 246.3f)
                curveTo(375.4f, 250.6f, 385.1f, 243.4f, 383.6f, 234.1f)
                lineTo(374.6f, 182.0f)
                lineTo(412.6f, 145.4f)
                curveTo(419.4f, 138.6f, 415.5f, 127.1f, 406.2f, 125.6f)
                lineTo(353.9f, 118.1f)
                close()
                moveTo(288.0f, 320.0f)
                curveTo(261.5f, 320.0f, 240.0f, 341.5f, 240.0f, 368.0f)
                lineTo(240.0f, 528.0f)
                curveTo(240.0f, 554.5f, 261.5f, 576.0f, 288.0f, 576.0f)
                lineTo(352.0f, 576.0f)
                curveTo(378.5f, 576.0f, 400.0f, 554.5f, 400.0f, 528.0f)
                lineTo(400.0f, 368.0f)
                curveTo(400.0f, 341.5f, 378.5f, 320.0f, 352.0f, 320.0f)
                lineTo(288.0f, 320.0f)
                close()
                moveTo(80.0f, 384.0f)
                curveTo(53.5f, 384.0f, 32.0f, 405.5f, 32.0f, 432.0f)
                lineTo(32.0f, 528.0f)
                curveTo(32.0f, 554.5f, 53.5f, 576.0f, 80.0f, 576.0f)
                lineTo(144.0f, 576.0f)
                curveTo(170.5f, 576.0f, 192.0f, 554.5f, 192.0f, 528.0f)
                lineTo(192.0f, 432.0f)
                curveTo(192.0f, 405.5f, 170.5f, 384.0f, 144.0f, 384.0f)
                lineTo(80.0f, 384.0f)
                close()
                moveTo(448.0f, 496.0f)
                lineTo(448.0f, 528.0f)
                curveTo(448.0f, 554.5f, 469.5f, 576.0f, 496.0f, 576.0f)
                lineTo(560.0f, 576.0f)
                curveTo(586.5f, 576.0f, 608.0f, 554.5f, 608.0f, 528.0f)
                lineTo(608.0f, 496.0f)
                curveTo(608.0f, 469.5f, 586.5f, 448.0f, 560.0f, 448.0f)
                lineTo(496.0f, 448.0f)
                curveTo(469.5f, 448.0f, 448.0f, 469.5f, 448.0f, 496.0f)
                close()
            }
        }
        .build()
        return `_ranking-star`!!
    }

private var `_ranking-star`: ImageVector? = null
