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

public val Fa.`Face-smile`: ImageVector
    get() {
        if (`_face-smile` != null) {
            return `_face-smile`!!
        }
        `_face-smile` = Builder(name = "Face-smile", defaultWidth = 640.0.dp, defaultHeight =
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
                moveTo(229.4f, 385.9f)
                curveTo(249.8f, 413.9f, 282.8f, 432.0f, 320.0f, 432.0f)
                curveTo(357.2f, 432.0f, 390.2f, 413.9f, 410.6f, 385.9f)
                curveTo(418.4f, 375.2f, 433.4f, 372.8f, 444.1f, 380.6f)
                curveTo(454.8f, 388.4f, 457.2f, 403.4f, 449.4f, 414.1f)
                curveTo(420.3f, 454.0f, 373.2f, 480.0f, 320.0f, 480.0f)
                curveTo(266.8f, 480.0f, 219.7f, 454.0f, 190.6f, 414.1f)
                curveTo(182.8f, 403.4f, 185.2f, 388.4f, 195.9f, 380.6f)
                curveTo(206.6f, 372.8f, 221.6f, 375.2f, 229.4f, 385.9f)
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
        return `_face-smile`!!
    }

private var `_face-smile`: ImageVector? = null
