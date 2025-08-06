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

public val Fa.`Notes-medical`: ImageVector
    get() {
        if (`_notes-medical` != null) {
            return `_notes-medical`!!
        }
        `_notes-medical` = Builder(name = "Notes-medical", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 416.0f)
                curveTo(160.0f, 451.3f, 188.7f, 480.0f, 224.0f, 480.0f)
                lineTo(405.5f, 480.0f)
                curveTo(422.5f, 480.0f, 438.8f, 473.3f, 450.8f, 461.3f)
                lineTo(557.3f, 354.7f)
                curveTo(569.3f, 342.7f, 576.0f, 326.4f, 576.0f, 309.4f)
                lineTo(576.0f, 128.0f)
                curveTo(576.0f, 92.7f, 547.3f, 64.0f, 512.0f, 64.0f)
                lineTo(224.0f, 64.0f)
                curveTo(188.7f, 64.0f, 160.0f, 92.7f, 160.0f, 128.0f)
                lineTo(160.0f, 416.0f)
                close()
                moveTo(352.0f, 176.0f)
                lineTo(384.0f, 176.0f)
                curveTo(392.8f, 176.0f, 400.0f, 183.2f, 400.0f, 192.0f)
                lineTo(400.0f, 240.0f)
                lineTo(448.0f, 240.0f)
                curveTo(456.8f, 240.0f, 464.0f, 247.2f, 464.0f, 256.0f)
                lineTo(464.0f, 288.0f)
                curveTo(464.0f, 296.8f, 456.8f, 304.0f, 448.0f, 304.0f)
                lineTo(400.0f, 304.0f)
                lineTo(400.0f, 352.0f)
                curveTo(400.0f, 360.8f, 392.8f, 368.0f, 384.0f, 368.0f)
                lineTo(352.0f, 368.0f)
                curveTo(343.2f, 368.0f, 336.0f, 360.8f, 336.0f, 352.0f)
                lineTo(336.0f, 304.0f)
                lineTo(288.0f, 304.0f)
                curveTo(279.2f, 304.0f, 272.0f, 296.8f, 272.0f, 288.0f)
                lineTo(272.0f, 256.0f)
                curveTo(272.0f, 247.2f, 279.2f, 240.0f, 288.0f, 240.0f)
                lineTo(336.0f, 240.0f)
                lineTo(336.0f, 192.0f)
                curveTo(336.0f, 183.2f, 343.2f, 176.0f, 352.0f, 176.0f)
                close()
                moveTo(112.0f, 184.0f)
                curveTo(112.0f, 170.7f, 101.3f, 160.0f, 88.0f, 160.0f)
                curveTo(74.7f, 160.0f, 64.0f, 170.7f, 64.0f, 184.0f)
                lineTo(64.0f, 512.0f)
                curveTo(64.0f, 547.3f, 92.7f, 576.0f, 128.0f, 576.0f)
                lineTo(392.0f, 576.0f)
                curveTo(405.3f, 576.0f, 416.0f, 565.3f, 416.0f, 552.0f)
                curveTo(416.0f, 538.7f, 405.3f, 528.0f, 392.0f, 528.0f)
                lineTo(128.0f, 528.0f)
                curveTo(119.2f, 528.0f, 112.0f, 520.8f, 112.0f, 512.0f)
                lineTo(112.0f, 184.0f)
                close()
            }
        }
        .build()
        return `_notes-medical`!!
    }

private var `_notes-medical`: ImageVector? = null
