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

public val Fa.`Face-grimace`: ImageVector
    get() {
        if (`_face-grimace` != null) {
            return `_face-grimace`!!
        }
        `_face-grimace` = Builder(name = "Face-grimace", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(464.0f, 416.0f)
                curveTo(464.0f, 441.2f, 444.6f, 461.8f, 420.0f, 463.8f)
                lineTo(420.0f, 368.1f)
                curveTo(444.6f, 370.1f, 464.0f, 390.8f, 464.0f, 415.9f)
                close()
                moveTo(340.0f, 368.0f)
                lineTo(380.0f, 368.0f)
                lineTo(380.0f, 464.0f)
                lineTo(340.0f, 464.0f)
                lineTo(340.0f, 368.0f)
                close()
                moveTo(260.0f, 464.0f)
                lineTo(260.0f, 368.0f)
                lineTo(300.0f, 368.0f)
                lineTo(300.0f, 464.0f)
                lineTo(260.0f, 464.0f)
                close()
                moveTo(220.0f, 368.2f)
                lineTo(220.0f, 463.9f)
                curveTo(195.4f, 461.9f, 176.0f, 441.2f, 176.0f, 416.1f)
                curveTo(176.0f, 391.0f, 195.4f, 370.3f, 220.0f, 368.3f)
                close()
                moveTo(208.0f, 272.0f)
                curveTo(208.0f, 254.3f, 222.3f, 240.0f, 240.0f, 240.0f)
                curveTo(257.7f, 240.0f, 272.0f, 254.3f, 272.0f, 272.0f)
                curveTo(272.0f, 289.7f, 257.7f, 304.0f, 240.0f, 304.0f)
                curveTo(222.3f, 304.0f, 208.0f, 289.7f, 208.0f, 272.0f)
                close()
                moveTo(400.0f, 240.0f)
                curveTo(417.7f, 240.0f, 432.0f, 254.3f, 432.0f, 272.0f)
                curveTo(432.0f, 289.7f, 417.7f, 304.0f, 400.0f, 304.0f)
                curveTo(382.3f, 304.0f, 368.0f, 289.7f, 368.0f, 272.0f)
                curveTo(368.0f, 254.3f, 382.3f, 240.0f, 400.0f, 240.0f)
                close()
            }
        }
        .build()
        return `_face-grimace`!!
    }

private var `_face-grimace`: ImageVector? = null
