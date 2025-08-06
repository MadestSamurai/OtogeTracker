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

public val Fa.`Pie-chart`: ImageVector
    get() {
        if (`_pie-chart` != null) {
            return `_pie-chart`!!
        }
        `_pie-chart` = Builder(name = "Pie-chart", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(544.4f, 304.0f)
                lineTo(368.4f, 304.0f)
                curveTo(350.7f, 304.0f, 336.4f, 289.7f, 336.4f, 272.0f)
                lineTo(336.4f, 96.0f)
                curveTo(336.4f, 78.3f, 350.8f, 63.8f, 368.3f, 66.1f)
                curveTo(475.3f, 80.3f, 560.1f, 165.1f, 574.3f, 272.1f)
                curveTo(576.6f, 289.6f, 562.1f, 304.0f, 544.4f, 304.0f)
                close()
                moveTo(254.6f, 101.2f)
                curveTo(272.7f, 97.4f, 288.4f, 112.2f, 288.4f, 130.7f)
                lineTo(288.4f, 328.0f)
                curveTo(288.4f, 333.6f, 290.4f, 339.0f, 293.9f, 343.3f)
                lineTo(426.0f, 502.7f)
                curveTo(437.7f, 516.8f, 435.2f, 538.1f, 419.1f, 546.8f)
                curveTo(385.0f, 565.4f, 345.9f, 576.0f, 304.4f, 576.0f)
                curveTo(171.9f, 576.0f, 64.4f, 468.5f, 64.4f, 336.0f)
                curveTo(64.4f, 220.5f, 145.9f, 124.1f, 254.6f, 101.2f)
                close()
                moveTo(509.8f, 352.0f)
                lineTo(573.8f, 352.0f)
                curveTo(592.3f, 352.0f, 607.1f, 367.7f, 603.3f, 385.8f)
                curveTo(593.1f, 434.2f, 568.3f, 477.2f, 533.7f, 510.0f)
                curveTo(521.4f, 521.7f, 502.1f, 519.2f, 491.3f, 506.1f)
                lineTo(406.9f, 404.4f)
                curveTo(389.6f, 383.5f, 404.5f, 352.0f, 431.5f, 352.0f)
                lineTo(509.7f, 352.0f)
                close()
            }
        }
        .build()
        return `_pie-chart`!!
    }

private var `_pie-chart`: ImageVector? = null
