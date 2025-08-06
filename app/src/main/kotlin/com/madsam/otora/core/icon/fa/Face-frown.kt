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

public val Fa.`Face-frown`: ImageVector
    get() {
        if (`_face-frown` != null) {
            return `_face-frown`!!
        }
        `_face-frown` = Builder(name = "Face-frown", defaultWidth = 640.0.dp, defaultHeight =
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
                moveTo(410.6f, 462.1f)
                curveTo(390.2f, 434.1f, 357.2f, 416.0f, 320.0f, 416.0f)
                curveTo(282.8f, 416.0f, 249.8f, 434.1f, 229.4f, 462.1f)
                curveTo(221.6f, 472.8f, 206.6f, 475.2f, 195.9f, 467.4f)
                curveTo(185.2f, 459.6f, 182.8f, 444.6f, 190.6f, 433.9f)
                curveTo(219.7f, 394.0f, 266.8f, 368.0f, 320.0f, 368.0f)
                curveTo(373.2f, 368.0f, 420.3f, 394.0f, 449.4f, 433.9f)
                curveTo(457.2f, 444.6f, 454.8f, 459.6f, 444.1f, 467.4f)
                curveTo(433.4f, 475.2f, 418.4f, 472.8f, 410.6f, 462.1f)
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
        return `_face-frown`!!
    }

private var `_face-frown`: ImageVector? = null
