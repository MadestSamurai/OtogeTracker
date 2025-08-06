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

public val Fa.`Tent-arrow-down-to-line`: ImageVector
    get() {
        if (`_tent-arrow-down-to-line` != null) {
            return `_tent-arrow-down-to-line`!!
        }
        `_tent-arrow-down-to-line` = Builder(name = "Tent-arrow-down-to-line", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(217.0f, 185.0f)
                curveTo(226.4f, 175.6f, 226.4f, 160.4f, 217.0f, 151.1f)
                curveTo(207.6f, 141.8f, 192.4f, 141.7f, 183.1f, 151.1f)
                lineTo(152.1f, 182.1f)
                lineTo(152.1f, 80.0f)
                curveTo(152.0f, 66.7f, 141.3f, 56.0f, 128.0f, 56.0f)
                curveTo(114.7f, 56.0f, 104.0f, 66.7f, 104.0f, 80.0f)
                lineTo(104.0f, 182.1f)
                lineTo(73.0f, 151.1f)
                curveTo(63.6f, 141.7f, 48.4f, 141.7f, 39.0f, 151.0f)
                curveTo(29.6f, 160.3f, 29.7f, 175.6f, 39.0f, 185.0f)
                lineTo(111.0f, 257.0f)
                curveTo(120.4f, 266.4f, 135.6f, 266.4f, 144.9f, 257.0f)
                lineTo(216.9f, 185.0f)
                close()
                moveTo(187.8f, 324.6f)
                lineTo(164.1f, 512.0f)
                lineTo(64.0f, 512.0f)
                curveTo(46.3f, 512.0f, 32.0f, 526.3f, 32.0f, 544.0f)
                curveTo(32.0f, 561.7f, 46.3f, 576.0f, 64.0f, 576.0f)
                lineTo(576.0f, 576.0f)
                curveTo(593.7f, 576.0f, 608.0f, 561.7f, 608.0f, 544.0f)
                curveTo(608.0f, 541.2f, 607.6f, 538.5f, 607.0f, 536.0f)
                lineTo(580.2f, 324.7f)
                curveTo(579.0f, 315.0f, 573.3f, 306.3f, 564.9f, 301.3f)
                lineTo(399.4f, 201.9f)
                curveTo(389.2f, 195.8f, 376.5f, 195.8f, 366.3f, 202.0f)
                lineTo(202.9f, 301.3f)
                curveTo(194.6f, 306.4f, 189.0f, 315.0f, 187.8f, 324.6f)
                close()
                moveTo(480.0f, 512.0f)
                lineTo(382.9f, 512.0f)
                lineTo(382.9f, 362.6f)
                curveTo(382.9f, 356.7f, 387.6f, 352.0f, 393.5f, 352.0f)
                curveTo(397.5f, 352.0f, 401.2f, 354.3f, 403.0f, 357.9f)
                lineTo(480.0f, 512.0f)
                close()
            }
        }
        .build()
        return `_tent-arrow-down-to-line`!!
    }

private var `_tent-arrow-down-to-line`: ImageVector? = null
