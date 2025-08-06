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

public val Fa.`Chess-pawn`: ImageVector
    get() {
        if (`_chess-pawn` != null) {
            return `_chess-pawn`!!
        }
        `_chess-pawn` = Builder(name = "Chess-pawn", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 32.0f)
                curveTo(386.3f, 32.0f, 440.0f, 85.7f, 440.0f, 152.0f)
                curveTo(440.0f, 179.0f, 431.1f, 203.9f, 416.0f, 224.0f)
                curveTo(433.7f, 224.0f, 448.0f, 238.3f, 448.0f, 256.0f)
                curveTo(448.0f, 273.7f, 433.7f, 288.0f, 416.0f, 288.0f)
                lineTo(405.3f, 288.0f)
                lineTo(432.0f, 448.0f)
                lineTo(488.2f, 518.3f)
                curveTo(493.2f, 524.6f, 496.0f, 532.4f, 496.0f, 540.5f)
                curveTo(496.0f, 560.1f, 480.1f, 576.0f, 460.5f, 576.0f)
                lineTo(179.5f, 576.0f)
                curveTo(159.9f, 576.0f, 144.0f, 560.1f, 144.0f, 540.5f)
                curveTo(144.0f, 532.4f, 146.7f, 524.6f, 151.8f, 518.3f)
                lineTo(208.0f, 448.0f)
                lineTo(234.7f, 288.0f)
                lineTo(224.0f, 288.0f)
                curveTo(206.3f, 288.0f, 192.0f, 273.7f, 192.0f, 256.0f)
                curveTo(192.0f, 238.3f, 206.3f, 224.0f, 224.0f, 224.0f)
                curveTo(208.9f, 203.9f, 200.0f, 179.0f, 200.0f, 152.0f)
                curveTo(200.0f, 85.7f, 253.7f, 32.0f, 320.0f, 32.0f)
                close()
            }
        }
        .build()
        return `_chess-pawn`!!
    }

private var `_chess-pawn`: ImageVector? = null
