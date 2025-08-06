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

public val Fa.`Oil-well`: ImageVector
    get() {
        if (`_oil-well` != null) {
            return `_oil-well`!!
        }
        `_oil-well` = Builder(name = "Oil-well", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(560.3f, 125.3f)
                curveTo(548.9f, 82.6f, 505.0f, 57.3f, 462.3f, 68.7f)
                lineTo(446.9f, 72.8f)
                curveTo(429.8f, 77.4f, 419.7f, 95.0f, 424.3f, 112.0f)
                lineTo(448.8f, 203.4f)
                lineTo(340.6f, 231.5f)
                lineTo(334.3f, 213.4f)
                curveTo(329.7f, 200.6f, 317.6f, 192.0f, 304.0f, 192.0f)
                curveTo(290.4f, 192.0f, 278.3f, 200.6f, 273.8f, 213.4f)
                lineTo(260.2f, 252.4f)
                lineTo(128.0f, 286.7f)
                lineTo(128.0f, 248.1f)
                curveTo(128.0f, 234.8f, 117.3f, 224.1f, 104.0f, 224.1f)
                curveTo(90.7f, 224.1f, 80.0f, 234.8f, 80.0f, 248.1f)
                lineTo(80.0f, 512.1f)
                lineTo(64.0f, 512.1f)
                curveTo(46.3f, 512.1f, 32.0f, 526.4f, 32.0f, 544.1f)
                curveTo(32.0f, 561.8f, 46.3f, 576.1f, 64.0f, 576.1f)
                lineTo(576.0f, 576.1f)
                curveTo(593.7f, 576.1f, 608.0f, 561.8f, 608.0f, 544.1f)
                curveTo(608.0f, 526.4f, 593.7f, 512.1f, 576.0f, 512.1f)
                lineTo(438.7f, 512.1f)
                lineTo(377.3f, 336.7f)
                lineTo(315.1f, 352.8f)
                lineTo(337.2f, 416.0f)
                lineTo(270.6f, 416.0f)
                lineTo(290.5f, 359.1f)
                lineTo(215.9f, 378.4f)
                lineTo(169.2f, 511.9f)
                lineTo(127.9f, 511.9f)
                lineTo(127.9f, 352.7f)
                lineTo(465.3f, 265.2f)
                lineTo(490.5f, 359.2f)
                curveTo(495.1f, 376.3f, 512.6f, 386.4f, 529.7f, 381.8f)
                lineTo(545.2f, 377.7f)
                curveTo(587.9f, 366.3f, 613.2f, 322.4f, 601.8f, 279.7f)
                lineTo(560.3f, 125.3f)
                close()
                moveTo(237.1f, 512.0f)
                lineTo(253.9f, 464.0f)
                lineTo(354.1f, 464.0f)
                lineTo(370.9f, 512.0f)
                lineTo(237.1f, 512.0f)
                close()
            }
        }
        .build()
        return `_oil-well`!!
    }

private var `_oil-well`: ImageVector? = null
