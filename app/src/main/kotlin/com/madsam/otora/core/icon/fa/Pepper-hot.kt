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

public val Fa.`Pepper-hot`: ImageVector
    get() {
        if (`_pepper-hot` != null) {
            return `_pepper-hot`!!
        }
        `_pepper-hot` = Builder(name = "Pepper-hot", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(577.0f, 129.0f)
                curveTo(586.4f, 119.6f, 586.4f, 104.4f, 577.0f, 95.1f)
                curveTo(567.6f, 85.8f, 552.4f, 85.7f, 543.1f, 95.1f)
                lineTo(510.9f, 127.2f)
                curveTo(484.3f, 107.6f, 451.5f, 96.0f, 416.0f, 96.0f)
                curveTo(380.9f, 96.0f, 348.5f, 107.3f, 322.1f, 126.4f)
                curveTo(306.1f, 138.1f, 316.2f, 160.0f, 336.0f, 160.0f)
                lineTo(360.0f, 160.0f)
                curveTo(373.3f, 160.0f, 384.0f, 170.7f, 384.0f, 184.0f)
                lineTo(384.0f, 264.0f)
                curveTo(384.0f, 277.3f, 394.7f, 288.0f, 408.0f, 288.0f)
                lineTo(488.0f, 288.0f)
                curveTo(501.3f, 288.0f, 512.0f, 298.7f, 512.0f, 312.0f)
                lineTo(512.0f, 336.0f)
                curveTo(512.0f, 355.8f, 533.9f, 365.9f, 545.6f, 349.9f)
                curveTo(564.7f, 323.5f, 576.0f, 291.1f, 576.0f, 256.0f)
                curveTo(576.0f, 220.5f, 564.4f, 187.7f, 544.8f, 161.1f)
                lineTo(577.0f, 129.0f)
                close()
                moveTo(302.0f, 199.5f)
                lineTo(142.4f, 427.5f)
                curveTo(133.3f, 440.4f, 118.7f, 448.0f, 103.0f, 448.0f)
                lineTo(96.0f, 448.0f)
                curveTo(69.5f, 448.0f, 48.0f, 469.5f, 48.0f, 496.0f)
                curveTo(48.0f, 522.5f, 69.5f, 544.0f, 96.0f, 544.0f)
                lineTo(123.1f, 544.0f)
                curveTo(188.8f, 544.0f, 252.8f, 523.8f, 306.6f, 486.2f)
                lineTo(472.5f, 370.1f)
                curveTo(467.0f, 359.9f, 464.0f, 348.2f, 464.0f, 336.0f)
                lineTo(408.0f, 336.0f)
                curveTo(368.2f, 336.0f, 336.0f, 303.8f, 336.0f, 264.0f)
                lineTo(336.0f, 208.0f)
                curveTo(323.8f, 208.0f, 312.1f, 205.0f, 302.0f, 199.5f)
                close()
            }
        }
        .build()
        return `_pepper-hot`!!
    }

private var `_pepper-hot`: ImageVector? = null
