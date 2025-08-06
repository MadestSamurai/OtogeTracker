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

public val Fa.`Piggy-bank`: ImageVector
    get() {
        if (`_piggy-bank` != null) {
            return `_piggy-bank`!!
        }
        `_piggy-bank` = Builder(name = "Piggy-bank", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 32.0f)
                curveTo(373.0f, 32.0f, 416.0f, 75.0f, 416.0f, 128.0f)
                curveTo(416.0f, 181.0f, 373.0f, 224.0f, 320.0f, 224.0f)
                curveTo(267.0f, 224.0f, 224.0f, 181.0f, 224.0f, 128.0f)
                curveTo(224.0f, 75.0f, 267.0f, 32.0f, 320.0f, 32.0f)
                close()
                moveTo(80.0f, 368.0f)
                curveTo(80.0f, 297.9f, 127.0f, 236.6f, 197.1f, 203.1f)
                curveTo(222.4f, 244.4f, 268.0f, 272.0f, 320.0f, 272.0f)
                curveTo(375.7f, 272.0f, 424.1f, 240.3f, 448.0f, 194.0f)
                curveTo(463.8f, 182.7f, 483.1f, 176.0f, 504.0f, 176.0f)
                lineTo(523.5f, 176.0f)
                curveTo(533.9f, 176.0f, 541.5f, 185.8f, 539.0f, 195.9f)
                lineTo(521.9f, 264.2f)
                curveTo(531.8f, 276.6f, 540.1f, 289.9f, 546.3f, 304.0f)
                lineTo(568.0f, 304.0f)
                curveTo(581.3f, 304.0f, 592.0f, 314.7f, 592.0f, 328.0f)
                lineTo(592.0f, 440.0f)
                curveTo(592.0f, 453.3f, 581.3f, 464.0f, 568.0f, 464.0f)
                lineTo(528.0f, 464.0f)
                curveTo(511.5f, 486.0f, 489.5f, 503.6f, 464.0f, 514.7f)
                lineTo(464.0f, 544.0f)
                curveTo(464.0f, 561.7f, 449.7f, 576.0f, 432.0f, 576.0f)
                lineTo(399.0f, 576.0f)
                curveTo(384.7f, 576.0f, 372.2f, 566.5f, 368.2f, 552.8f)
                lineTo(361.1f, 528.0f)
                lineTo(278.8f, 528.0f)
                lineTo(271.7f, 552.8f)
                curveTo(267.8f, 566.5f, 255.3f, 576.0f, 241.0f, 576.0f)
                lineTo(208.0f, 576.0f)
                curveTo(190.3f, 576.0f, 176.0f, 561.7f, 176.0f, 544.0f)
                lineTo(176.0f, 514.7f)
                curveTo(119.5f, 490.0f, 80.0f, 433.6f, 80.0f, 368.0f)
                close()
                moveTo(456.0f, 384.0f)
                curveTo(469.3f, 384.0f, 480.0f, 373.3f, 480.0f, 360.0f)
                curveTo(480.0f, 346.7f, 469.3f, 336.0f, 456.0f, 336.0f)
                curveTo(442.7f, 336.0f, 432.0f, 346.7f, 432.0f, 360.0f)
                curveTo(432.0f, 373.3f, 442.7f, 384.0f, 456.0f, 384.0f)
                close()
            }
        }
        .build()
        return `_piggy-bank`!!
    }

private var `_piggy-bank`: ImageVector? = null
