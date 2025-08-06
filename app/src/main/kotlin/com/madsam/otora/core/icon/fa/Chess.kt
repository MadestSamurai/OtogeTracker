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

public val Fa.Chess: ImageVector
    get() {
        if (_chess != null) {
            return _chess!!
        }
        _chess = Builder(name = "Chess", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(232.0f, 120.0f)
                lineTo(232.0f, 160.0f)
                lineTo(153.9f, 160.0f)
                curveTo(139.6f, 160.0f, 128.0f, 171.6f, 128.0f, 185.9f)
                curveTo(128.0f, 189.9f, 128.9f, 193.9f, 130.7f, 197.5f)
                lineTo(164.1f, 264.3f)
                curveTo(152.7f, 266.1f, 143.9f, 276.0f, 143.9f, 288.0f)
                curveTo(143.9f, 301.3f, 154.6f, 312.0f, 167.9f, 312.0f)
                lineTo(173.5f, 312.0f)
                lineTo(159.9f, 448.0f)
                lineTo(103.7f, 518.3f)
                curveTo(98.7f, 524.6f, 95.9f, 532.4f, 95.9f, 540.5f)
                curveTo(95.9f, 560.1f, 111.8f, 576.0f, 131.4f, 576.0f)
                lineTo(380.3f, 576.0f)
                curveTo(399.9f, 576.0f, 415.8f, 560.1f, 415.8f, 540.5f)
                curveTo(415.8f, 532.4f, 413.1f, 524.6f, 408.0f, 518.3f)
                lineTo(352.0f, 448.0f)
                lineTo(338.4f, 312.0f)
                lineTo(344.0f, 312.0f)
                curveTo(357.3f, 312.0f, 368.0f, 301.3f, 368.0f, 288.0f)
                curveTo(368.0f, 276.1f, 359.3f, 266.1f, 347.8f, 264.3f)
                lineTo(381.2f, 197.5f)
                curveTo(383.0f, 193.9f, 383.9f, 189.9f, 383.9f, 185.9f)
                curveTo(383.9f, 171.6f, 372.3f, 160.0f, 358.0f, 160.0f)
                lineTo(279.9f, 160.0f)
                lineTo(279.9f, 120.0f)
                lineTo(295.9f, 120.0f)
                curveTo(309.2f, 120.0f, 319.9f, 109.3f, 319.9f, 96.0f)
                curveTo(319.9f, 82.7f, 309.3f, 72.0f, 296.0f, 72.0f)
                lineTo(280.0f, 72.0f)
                lineTo(280.0f, 56.0f)
                curveTo(280.0f, 42.7f, 269.3f, 32.0f, 256.0f, 32.0f)
                curveTo(242.7f, 32.0f, 232.0f, 42.7f, 232.0f, 56.0f)
                lineTo(232.0f, 72.0f)
                lineTo(216.0f, 72.0f)
                curveTo(202.7f, 72.0f, 192.0f, 82.7f, 192.0f, 96.0f)
                curveTo(192.0f, 109.3f, 202.7f, 120.0f, 216.0f, 120.0f)
                lineTo(232.0f, 120.0f)
                close()
                moveTo(389.8f, 343.6f)
                lineTo(398.3f, 429.1f)
                lineTo(445.7f, 488.3f)
                lineTo(449.9f, 494.0f)
                curveTo(459.1f, 507.7f, 464.0f, 523.9f, 464.0f, 540.5f)
                curveTo(464.0f, 553.2f, 461.2f, 565.3f, 456.1f, 576.0f)
                lineTo(539.2f, 576.0f)
                curveTo(559.5f, 576.0f, 576.0f, 559.5f, 576.0f, 539.2f)
                curveTo(576.0f, 531.9f, 573.8f, 524.8f, 569.8f, 518.8f)
                lineTo(544.0f, 480.1f)
                lineTo(544.0f, 416.1f)
                lineTo(557.3f, 402.8f)
                curveTo(569.3f, 390.8f, 576.0f, 374.5f, 576.0f, 357.5f)
                lineTo(576.0f, 256.0f)
                curveTo(576.0f, 238.3f, 561.7f, 224.0f, 544.0f, 224.0f)
                curveTo(526.3f, 224.0f, 512.0f, 238.3f, 512.0f, 256.0f)
                lineTo(512.0f, 272.0f)
                lineTo(480.0f, 272.0f)
                lineTo(480.0f, 256.0f)
                curveTo(480.0f, 238.3f, 465.7f, 224.0f, 448.0f, 224.0f)
                curveTo(430.3f, 224.0f, 416.0f, 238.3f, 416.0f, 256.0f)
                lineTo(416.0f, 288.0f)
                curveTo(416.0f, 310.4f, 405.8f, 330.4f, 389.8f, 343.6f)
                close()
            }
        }
        .build()
        return _chess!!
    }

private var _chess: ImageVector? = null
