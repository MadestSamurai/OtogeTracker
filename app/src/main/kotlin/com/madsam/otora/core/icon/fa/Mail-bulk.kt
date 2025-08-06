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

public val Fa.`Mail-bulk`: ImageVector
    get() {
        if (`_mail-bulk` != null) {
            return `_mail-bulk`!!
        }
        `_mail-bulk` = Builder(name = "Mail-bulk", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(144.0f, 64.0f)
                curveTo(117.5f, 64.0f, 96.0f, 85.5f, 96.0f, 112.0f)
                lineTo(96.0f, 272.0f)
                lineTo(176.0f, 272.0f)
                lineTo(176.0f, 240.0f)
                curveTo(176.0f, 187.0f, 219.0f, 144.0f, 272.0f, 144.0f)
                lineTo(480.0f, 144.0f)
                lineTo(480.0f, 112.0f)
                curveTo(480.0f, 85.5f, 458.5f, 64.0f, 432.0f, 64.0f)
                lineTo(144.0f, 64.0f)
                close()
                moveTo(272.0f, 192.0f)
                curveTo(245.5f, 192.0f, 224.0f, 213.5f, 224.0f, 240.0f)
                lineTo(224.0f, 272.0f)
                lineTo(304.0f, 272.0f)
                curveTo(357.0f, 272.0f, 400.0f, 315.0f, 400.0f, 368.0f)
                lineTo(400.0f, 480.0f)
                lineTo(560.0f, 480.0f)
                curveTo(586.5f, 480.0f, 608.0f, 458.5f, 608.0f, 432.0f)
                lineTo(608.0f, 240.0f)
                curveTo(608.0f, 213.5f, 586.5f, 192.0f, 560.0f, 192.0f)
                lineTo(272.0f, 192.0f)
                close()
                moveTo(472.0f, 256.0f)
                lineTo(520.0f, 256.0f)
                curveTo(533.3f, 256.0f, 544.0f, 266.7f, 544.0f, 280.0f)
                lineTo(544.0f, 328.0f)
                curveTo(544.0f, 341.3f, 533.3f, 352.0f, 520.0f, 352.0f)
                lineTo(472.0f, 352.0f)
                curveTo(458.7f, 352.0f, 448.0f, 341.3f, 448.0f, 328.0f)
                lineTo(448.0f, 280.0f)
                curveTo(448.0f, 266.7f, 458.7f, 256.0f, 472.0f, 256.0f)
                close()
                moveTo(80.0f, 320.0f)
                curveTo(53.5f, 320.0f, 32.0f, 341.5f, 32.0f, 368.0f)
                lineTo(32.0f, 378.4f)
                lineTo(188.6f, 464.6f)
                curveTo(189.7f, 465.2f, 190.8f, 465.5f, 192.0f, 465.5f)
                curveTo(193.2f, 465.5f, 194.4f, 465.2f, 195.4f, 464.6f)
                lineTo(352.0f, 378.4f)
                lineTo(352.0f, 368.0f)
                curveTo(352.0f, 341.5f, 330.5f, 320.0f, 304.0f, 320.0f)
                lineTo(80.0f, 320.0f)
                close()
                moveTo(352.0f, 433.2f)
                lineTo(218.6f, 506.6f)
                curveTo(210.5f, 511.1f, 201.3f, 513.4f, 192.0f, 513.4f)
                curveTo(182.7f, 513.4f, 173.6f, 511.0f, 165.4f, 506.6f)
                lineTo(32.0f, 433.2f)
                lineTo(32.0f, 528.0f)
                curveTo(32.0f, 554.5f, 53.5f, 576.0f, 80.0f, 576.0f)
                lineTo(304.0f, 576.0f)
                curveTo(330.5f, 576.0f, 352.0f, 554.5f, 352.0f, 528.0f)
                lineTo(352.0f, 433.2f)
                close()
            }
        }
        .build()
        return `_mail-bulk`!!
    }

private var `_mail-bulk`: ImageVector? = null
