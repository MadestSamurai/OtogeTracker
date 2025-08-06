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

public val Fa.`Baseball-bat-ball`: ImageVector
    get() {
        if (`_baseball-bat-ball` != null) {
            return `_baseball-bat-ball`!!
        }
        `_baseball-bat-ball` = Builder(name = "Baseball-bat-ball", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(496.1f, 608.0f)
                curveTo(451.9f, 608.0f, 416.1f, 572.2f, 416.1f, 528.0f)
                curveTo(416.1f, 483.8f, 451.9f, 448.0f, 496.1f, 448.0f)
                curveTo(540.3f, 448.0f, 576.1f, 483.8f, 576.1f, 528.0f)
                curveTo(576.1f, 572.2f, 540.3f, 608.0f, 496.1f, 608.0f)
                close()
                moveTo(504.5f, 32.0f)
                curveTo(519.6f, 32.0f, 534.2f, 37.8f, 545.2f, 48.2f)
                lineTo(592.4f, 93.0f)
                curveTo(605.0f, 105.0f, 611.5f, 122.0f, 609.9f, 139.3f)
                curveTo(608.7f, 152.6f, 602.9f, 165.1f, 593.4f, 174.5f)
                lineTo(395.1f, 373.0f)
                curveTo(387.8f, 380.3f, 379.4f, 386.4f, 370.1f, 391.0f)
                lineTo(238.0f, 457.0f)
                curveTo(228.8f, 461.6f, 220.3f, 467.7f, 213.0f, 475.0f)
                lineTo(121.0f, 567.0f)
                lineTo(122.7f, 568.8f)
                curveTo(130.4f, 578.2f, 129.8f, 592.1f, 121.0f, 600.9f)
                curveTo(112.2f, 609.7f, 98.3f, 610.2f, 88.9f, 602.6f)
                lineTo(87.1f, 600.9f)
                lineTo(39.1f, 552.9f)
                lineTo(37.4f, 551.1f)
                curveTo(29.7f, 541.7f, 30.3f, 527.8f, 39.1f, 519.0f)
                curveTo(47.9f, 510.2f, 61.8f, 509.7f, 71.2f, 517.3f)
                lineTo(73.0f, 519.0f)
                lineTo(165.0f, 427.0f)
                curveTo(172.3f, 419.7f, 178.4f, 411.3f, 183.0f, 402.0f)
                lineTo(249.1f, 269.9f)
                curveTo(253.7f, 260.7f, 259.8f, 252.2f, 267.1f, 244.9f)
                lineTo(462.8f, 49.3f)
                curveTo(473.9f, 38.2f, 488.9f, 32.0f, 504.5f, 32.0f)
                close()
            }
        }
        .build()
        return `_baseball-bat-ball`!!
    }

private var `_baseball-bat-ball`: ImageVector? = null
