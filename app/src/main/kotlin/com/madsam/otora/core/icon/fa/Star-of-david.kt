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

public val Fa.`Star-of-david`: ImageVector
    get() {
        if (`_star-of-david` != null) {
            return `_star-of-david`!!
        }
        `_star-of-david` = Builder(name = "Star-of-david", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(479.9f, 375.9f)
                lineTo(452.1f, 424.0f)
                lineTo(507.8f, 424.0f)
                lineTo(480.0f, 375.9f)
                close()
                moveTo(447.6f, 320.0f)
                lineTo(387.4f, 216.0f)
                lineTo(252.6f, 216.0f)
                lineTo(192.4f, 320.0f)
                lineTo(252.6f, 424.0f)
                lineTo(387.4f, 424.0f)
                lineTo(447.6f, 320.0f)
                close()
                moveTo(512.3f, 320.0f)
                lineTo(570.7f, 420.9f)
                curveTo(574.2f, 426.9f, 576.0f, 433.7f, 576.0f, 440.6f)
                curveTo(576.0f, 462.3f, 558.4f, 480.0f, 536.6f, 480.0f)
                lineTo(419.6f, 480.0f)
                lineTo(358.3f, 585.8f)
                curveTo(350.5f, 599.6f, 335.8f, 608.0f, 320.0f, 608.0f)
                curveTo(304.2f, 608.0f, 289.5f, 599.6f, 281.6f, 585.8f)
                lineTo(220.3f, 480.0f)
                lineTo(103.3f, 480.0f)
                curveTo(81.6f, 480.0f, 63.9f, 462.4f, 63.9f, 440.6f)
                curveTo(63.9f, 433.7f, 65.7f, 426.9f, 69.2f, 420.9f)
                lineTo(127.7f, 320.0f)
                lineTo(69.3f, 219.1f)
                curveTo(65.8f, 213.1f, 64.0f, 206.3f, 64.0f, 199.4f)
                curveTo(64.0f, 177.6f, 81.6f, 160.0f, 103.4f, 160.0f)
                lineTo(220.4f, 160.0f)
                lineTo(281.7f, 54.2f)
                curveTo(289.5f, 40.4f, 304.2f, 32.0f, 320.0f, 32.0f)
                curveTo(335.8f, 32.0f, 350.5f, 40.4f, 358.4f, 54.2f)
                lineTo(419.7f, 160.0f)
                lineTo(536.7f, 160.0f)
                curveTo(558.4f, 160.0f, 576.1f, 177.6f, 576.1f, 199.4f)
                curveTo(576.1f, 206.3f, 574.3f, 213.1f, 570.8f, 219.1f)
                lineTo(512.3f, 320.0f)
                close()
                moveTo(452.1f, 216.0f)
                lineTo(479.9f, 264.1f)
                lineTo(507.7f, 216.0f)
                lineTo(452.0f, 216.0f)
                close()
                moveTo(355.0f, 160.0f)
                lineTo(320.0f, 99.6f)
                lineTo(285.0f, 160.0f)
                lineTo(355.0f, 160.0f)
                close()
                moveTo(187.9f, 216.0f)
                lineTo(132.2f, 216.0f)
                lineTo(160.0f, 264.1f)
                lineTo(187.8f, 216.0f)
                close()
                moveTo(160.1f, 375.9f)
                lineTo(132.3f, 424.0f)
                lineTo(188.0f, 424.0f)
                lineTo(160.2f, 375.9f)
                close()
                moveTo(285.0f, 480.0f)
                lineTo(320.0f, 540.4f)
                lineTo(355.0f, 480.0f)
                lineTo(285.0f, 480.0f)
                close()
            }
        }
        .build()
        return `_star-of-david`!!
    }

private var `_star-of-david`: ImageVector? = null
