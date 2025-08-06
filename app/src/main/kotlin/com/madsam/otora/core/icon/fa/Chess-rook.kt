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

public val Fa.`Chess-rook`: ImageVector
    get() {
        if (`_chess-rook` != null) {
            return `_chess-rook`!!
        }
        `_chess-rook` = Builder(name = "Chess-rook", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 96.0f)
                lineTo(128.0f, 197.5f)
                curveTo(128.0f, 214.5f, 134.7f, 230.8f, 146.7f, 242.8f)
                lineTo(192.0f, 288.0f)
                lineTo(192.0f, 448.0f)
                lineTo(135.8f, 518.3f)
                curveTo(130.7f, 524.6f, 128.0f, 532.4f, 128.0f, 540.5f)
                curveTo(128.0f, 560.1f, 143.9f, 576.0f, 163.5f, 576.0f)
                lineTo(476.4f, 576.0f)
                curveTo(496.0f, 576.0f, 511.9f, 560.1f, 511.9f, 540.5f)
                curveTo(511.9f, 532.4f, 509.2f, 524.6f, 504.1f, 518.3f)
                lineTo(447.9f, 448.0f)
                lineTo(447.9f, 288.0f)
                lineTo(493.2f, 242.7f)
                curveTo(505.2f, 230.7f, 511.9f, 214.4f, 511.9f, 197.4f)
                lineTo(512.0f, 96.0f)
                curveTo(512.0f, 78.3f, 497.7f, 64.0f, 480.0f, 64.0f)
                lineTo(448.0f, 64.0f)
                curveTo(430.3f, 64.0f, 416.0f, 78.3f, 416.0f, 96.0f)
                lineTo(416.0f, 128.0f)
                lineTo(368.0f, 128.0f)
                lineTo(368.0f, 96.0f)
                curveTo(368.0f, 78.3f, 353.7f, 64.0f, 336.0f, 64.0f)
                lineTo(304.0f, 64.0f)
                curveTo(286.3f, 64.0f, 272.0f, 78.3f, 272.0f, 96.0f)
                lineTo(272.0f, 128.0f)
                lineTo(224.0f, 128.0f)
                lineTo(224.0f, 96.0f)
                curveTo(224.0f, 78.3f, 209.7f, 64.0f, 192.0f, 64.0f)
                lineTo(160.0f, 64.0f)
                curveTo(142.3f, 64.0f, 128.0f, 78.3f, 128.0f, 96.0f)
                close()
            }
        }
        .build()
        return `_chess-rook`!!
    }

private var `_chess-rook`: ImageVector? = null
