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

public val Fa.`Heart-pulse`: ImageVector
    get() {
        if (`_heart-pulse` != null) {
            return `_heart-pulse`!!
        }
        `_heart-pulse` = Builder(name = "Heart-pulse", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 171.9f)
                lineTo(305.0f, 151.1f)
                curveTo(280.0f, 116.5f, 239.9f, 96.0f, 197.1f, 96.0f)
                curveTo(123.6f, 96.0f, 64.0f, 155.6f, 64.0f, 229.1f)
                lineTo(64.0f, 231.7f)
                curveTo(64.0f, 255.3f, 70.2f, 279.7f, 80.6f, 304.0f)
                lineTo(186.6f, 304.0f)
                curveTo(189.8f, 304.0f, 192.7f, 302.1f, 194.0f, 299.1f)
                lineTo(225.8f, 222.8f)
                curveTo(229.5f, 214.0f, 238.1f, 208.2f, 247.6f, 208.0f)
                curveTo(257.1f, 207.8f, 265.9f, 213.4f, 269.8f, 222.1f)
                lineTo(321.1f, 336.0f)
                lineTo(362.5f, 253.2f)
                curveTo(366.6f, 245.1f, 374.9f, 239.9f, 384.0f, 239.9f)
                curveTo(393.1f, 239.9f, 401.4f, 245.0f, 405.5f, 253.2f)
                lineTo(428.7f, 299.5f)
                curveTo(430.1f, 302.2f, 432.8f, 303.9f, 435.9f, 303.9f)
                lineTo(559.5f, 303.9f)
                curveTo(570.0f, 279.6f, 576.1f, 255.2f, 576.1f, 231.6f)
                lineTo(576.1f, 229.0f)
                curveTo(576.0f, 155.6f, 516.4f, 96.0f, 442.9f, 96.0f)
                curveTo(400.2f, 96.0f, 360.0f, 116.5f, 335.0f, 151.1f)
                lineTo(320.0f, 171.8f)
                close()
                moveTo(533.6f, 352.0f)
                lineTo(435.8f, 352.0f)
                curveTo(414.6f, 352.0f, 395.2f, 340.0f, 385.7f, 321.0f)
                lineTo(384.0f, 317.6f)
                lineTo(341.5f, 402.7f)
                curveTo(337.4f, 411.0f, 328.8f, 416.2f, 319.5f, 416.0f)
                curveTo(310.2f, 415.8f, 301.9f, 410.3f, 298.1f, 401.9f)
                lineTo(248.8f, 292.4f)
                lineTo(238.3f, 317.6f)
                curveTo(229.6f, 338.5f, 209.2f, 352.1f, 186.6f, 352.1f)
                lineTo(106.4f, 352.1f)
                curveTo(153.6f, 425.9f, 229.4f, 493.8f, 276.8f, 530.0f)
                curveTo(289.2f, 539.4f, 304.4f, 544.1f, 319.9f, 544.1f)
                curveTo(335.4f, 544.1f, 350.7f, 539.5f, 363.0f, 530.0f)
                curveTo(410.6f, 493.7f, 486.4f, 425.8f, 533.6f, 352.0f)
                close()
            }
        }
        .build()
        return `_heart-pulse`!!
    }

private var `_heart-pulse`: ImageVector? = null
