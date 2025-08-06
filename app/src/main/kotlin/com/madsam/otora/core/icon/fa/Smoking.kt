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

public val Fa.Smoking: ImageVector
    get() {
        if (_smoking != null) {
            return _smoking!!
        }
        _smoking = Builder(name = "Smoking", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(392.0f, 64.0f)
                curveTo(405.3f, 64.0f, 416.0f, 74.7f, 416.0f, 88.0f)
                lineTo(416.0f, 107.0f)
                curveTo(416.0f, 147.3f, 432.0f, 186.0f, 460.5f, 214.5f)
                lineTo(481.5f, 235.5f)
                curveTo(501.0f, 255.0f, 512.0f, 281.4f, 512.0f, 309.0f)
                lineTo(512.0f, 328.0f)
                curveTo(512.0f, 341.3f, 501.3f, 352.0f, 488.0f, 352.0f)
                curveTo(474.7f, 352.0f, 464.0f, 341.3f, 464.0f, 328.0f)
                lineTo(464.0f, 309.0f)
                curveTo(464.0f, 294.1f, 458.1f, 279.9f, 447.6f, 269.4f)
                lineTo(426.6f, 248.4f)
                curveTo(389.1f, 210.9f, 368.0f, 160.0f, 368.0f, 107.0f)
                lineTo(368.0f, 88.0f)
                curveTo(368.0f, 74.7f, 378.7f, 64.0f, 392.0f, 64.0f)
                close()
                moveTo(584.0f, 352.0f)
                curveTo(570.7f, 352.0f, 560.0f, 341.3f, 560.0f, 328.0f)
                lineTo(560.0f, 309.0f)
                curveTo(560.0f, 268.7f, 544.0f, 230.0f, 515.5f, 201.5f)
                lineTo(494.5f, 180.5f)
                curveTo(475.0f, 161.0f, 464.0f, 134.6f, 464.0f, 107.0f)
                lineTo(464.0f, 88.0f)
                curveTo(464.0f, 74.7f, 474.7f, 64.0f, 488.0f, 64.0f)
                curveTo(501.3f, 64.0f, 512.0f, 74.7f, 512.0f, 88.0f)
                lineTo(512.0f, 107.0f)
                curveTo(512.0f, 121.9f, 517.9f, 136.1f, 528.4f, 146.6f)
                lineTo(549.4f, 167.6f)
                curveTo(586.9f, 205.1f, 608.0f, 256.0f, 608.0f, 309.0f)
                lineTo(608.0f, 328.0f)
                curveTo(608.0f, 341.3f, 597.3f, 352.0f, 584.0f, 352.0f)
                close()
                moveTo(352.0f, 512.0f)
                lineTo(448.0f, 512.0f)
                lineTo(448.0f, 480.0f)
                lineTo(352.0f, 480.0f)
                lineTo(352.0f, 512.0f)
                close()
                moveTo(32.0f, 480.0f)
                curveTo(32.0f, 444.7f, 60.7f, 416.0f, 96.0f, 416.0f)
                lineTo(480.0f, 416.0f)
                curveTo(497.7f, 416.0f, 512.0f, 430.3f, 512.0f, 448.0f)
                lineTo(512.0f, 544.0f)
                curveTo(512.0f, 561.7f, 497.7f, 576.0f, 480.0f, 576.0f)
                lineTo(96.0f, 576.0f)
                curveTo(60.7f, 576.0f, 32.0f, 547.3f, 32.0f, 512.0f)
                lineTo(32.0f, 480.0f)
                close()
                moveTo(608.0f, 440.0f)
                lineTo(608.0f, 552.0f)
                curveTo(608.0f, 565.3f, 597.3f, 576.0f, 584.0f, 576.0f)
                curveTo(570.7f, 576.0f, 560.0f, 565.3f, 560.0f, 552.0f)
                lineTo(560.0f, 440.0f)
                curveTo(560.0f, 426.7f, 570.7f, 416.0f, 584.0f, 416.0f)
                curveTo(597.3f, 416.0f, 608.0f, 426.7f, 608.0f, 440.0f)
                close()
            }
        }
        .build()
        return _smoking!!
    }

private var _smoking: ImageVector? = null
