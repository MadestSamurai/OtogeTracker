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

public val Fa.`Arrows-left-right-to-line`: ImageVector
    get() {
        if (`_arrows-left-right-to-line` != null) {
            return `_arrows-left-right-to-line`!!
        }
        `_arrows-left-right-to-line` = Builder(name = "Arrows-left-right-to-line", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 160.0f)
                curveTo(46.3f, 160.0f, 32.0f, 174.3f, 32.0f, 192.0f)
                lineTo(32.0f, 448.0f)
                curveTo(32.0f, 465.7f, 46.3f, 480.0f, 64.0f, 480.0f)
                curveTo(81.7f, 480.0f, 96.0f, 465.7f, 96.0f, 448.0f)
                lineTo(96.0f, 192.0f)
                curveTo(96.0f, 174.3f, 81.7f, 160.0f, 64.0f, 160.0f)
                close()
                moveTo(422.6f, 406.6f)
                lineTo(486.6f, 342.6f)
                curveTo(499.1f, 330.1f, 499.1f, 309.8f, 486.6f, 297.3f)
                lineTo(422.6f, 233.3f)
                curveTo(410.1f, 220.8f, 389.8f, 220.8f, 377.3f, 233.3f)
                curveTo(364.8f, 245.8f, 364.8f, 266.1f, 377.3f, 278.6f)
                lineTo(386.7f, 288.0f)
                lineTo(253.2f, 288.0f)
                lineTo(262.6f, 278.6f)
                curveTo(275.1f, 266.1f, 275.1f, 245.8f, 262.6f, 233.3f)
                curveTo(250.1f, 220.8f, 229.8f, 220.8f, 217.3f, 233.3f)
                lineTo(153.3f, 297.3f)
                curveTo(147.3f, 303.3f, 143.9f, 311.4f, 143.9f, 319.9f)
                curveTo(143.9f, 328.4f, 147.3f, 336.5f, 153.3f, 342.5f)
                lineTo(217.3f, 406.5f)
                curveTo(229.8f, 419.0f, 250.1f, 419.0f, 262.6f, 406.5f)
                curveTo(275.1f, 394.0f, 275.1f, 373.7f, 262.6f, 361.2f)
                lineTo(253.2f, 351.8f)
                lineTo(386.7f, 351.8f)
                lineTo(377.3f, 361.2f)
                curveTo(364.8f, 373.7f, 364.8f, 394.0f, 377.3f, 406.5f)
                curveTo(389.8f, 419.0f, 410.1f, 419.0f, 422.6f, 406.5f)
                close()
                moveTo(608.0f, 192.0f)
                curveTo(608.0f, 174.3f, 593.7f, 160.0f, 576.0f, 160.0f)
                curveTo(558.3f, 160.0f, 544.0f, 174.3f, 544.0f, 192.0f)
                lineTo(544.0f, 448.0f)
                curveTo(544.0f, 465.7f, 558.3f, 480.0f, 576.0f, 480.0f)
                curveTo(593.7f, 480.0f, 608.0f, 465.7f, 608.0f, 448.0f)
                lineTo(608.0f, 192.0f)
                close()
            }
        }
        .build()
        return `_arrows-left-right-to-line`!!
    }

private var `_arrows-left-right-to-line`: ImageVector? = null
