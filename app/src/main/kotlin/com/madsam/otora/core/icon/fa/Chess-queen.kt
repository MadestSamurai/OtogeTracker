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

public val Fa.`Chess-queen`: ImageVector
    get() {
        if (`_chess-queen` != null) {
            return `_chess-queen`!!
        }
        `_chess-queen` = Builder(name = "Chess-queen", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 144.0f)
                curveTo(346.5f, 144.0f, 368.0f, 122.5f, 368.0f, 96.0f)
                curveTo(368.0f, 69.5f, 346.5f, 48.0f, 320.0f, 48.0f)
                curveTo(293.5f, 48.0f, 272.0f, 69.5f, 272.0f, 96.0f)
                curveTo(272.0f, 122.5f, 293.5f, 144.0f, 320.0f, 144.0f)
                close()
                moveTo(69.5f, 249.0f)
                lineTo(192.0f, 448.0f)
                lineTo(135.8f, 518.3f)
                curveTo(130.8f, 524.6f, 128.0f, 532.4f, 128.0f, 540.5f)
                curveTo(128.0f, 560.1f, 143.9f, 576.0f, 163.5f, 576.0f)
                lineTo(476.4f, 576.0f)
                curveTo(496.0f, 576.0f, 511.9f, 560.1f, 511.9f, 540.5f)
                curveTo(511.9f, 532.4f, 509.2f, 524.6f, 504.1f, 518.3f)
                lineTo(448.0f, 448.0f)
                lineTo(570.5f, 249.0f)
                curveTo(574.1f, 243.1f, 576.0f, 236.3f, 576.0f, 229.4f)
                lineTo(576.0f, 228.8f)
                curveTo(576.0f, 208.5f, 559.5f, 192.0f, 539.2f, 192.0f)
                curveTo(531.9f, 192.0f, 524.8f, 194.2f, 518.8f, 198.2f)
                lineTo(501.9f, 209.5f)
                curveTo(489.2f, 218.0f, 472.3f, 216.3f, 461.5f, 205.5f)
                lineTo(427.4f, 171.4f)
                curveTo(420.1f, 164.1f, 410.2f, 160.0f, 400.0f, 160.0f)
                curveTo(389.8f, 160.0f, 379.9f, 164.1f, 372.7f, 171.3f)
                lineTo(342.6f, 201.4f)
                curveTo(330.1f, 213.9f, 309.8f, 213.9f, 297.3f, 201.4f)
                lineTo(267.2f, 171.3f)
                curveTo(260.1f, 164.1f, 250.2f, 160.0f, 240.0f, 160.0f)
                curveTo(229.8f, 160.0f, 219.9f, 164.1f, 212.7f, 171.3f)
                lineTo(178.6f, 205.4f)
                curveTo(167.8f, 216.2f, 150.9f, 217.9f, 138.2f, 209.4f)
                lineTo(121.3f, 198.2f)
                curveTo(115.2f, 194.2f, 108.1f, 192.0f, 100.9f, 192.0f)
                curveTo(80.6f, 192.0f, 64.1f, 208.5f, 64.1f, 228.8f)
                lineTo(64.1f, 229.4f)
                curveTo(64.1f, 236.3f, 66.0f, 243.1f, 69.6f, 249.0f)
                close()
            }
        }
        .build()
        return `_chess-queen`!!
    }

private var `_chess-queen`: ImageVector? = null
