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

public val Fa.`Contact-book`: ImageVector
    get() {
        if (`_contact-book` != null) {
            return `_contact-book`!!
        }
        `_contact-book` = Builder(name = "Contact-book", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 64.0f)
                curveTo(124.7f, 64.0f, 96.0f, 92.7f, 96.0f, 128.0f)
                lineTo(96.0f, 512.0f)
                curveTo(96.0f, 547.3f, 124.7f, 576.0f, 160.0f, 576.0f)
                lineTo(448.0f, 576.0f)
                curveTo(483.3f, 576.0f, 512.0f, 547.3f, 512.0f, 512.0f)
                lineTo(512.0f, 128.0f)
                curveTo(512.0f, 92.7f, 483.3f, 64.0f, 448.0f, 64.0f)
                lineTo(160.0f, 64.0f)
                close()
                moveTo(272.0f, 352.0f)
                lineTo(336.0f, 352.0f)
                curveTo(380.2f, 352.0f, 416.0f, 387.8f, 416.0f, 432.0f)
                curveTo(416.0f, 440.8f, 408.8f, 448.0f, 400.0f, 448.0f)
                lineTo(208.0f, 448.0f)
                curveTo(199.2f, 448.0f, 192.0f, 440.8f, 192.0f, 432.0f)
                curveTo(192.0f, 387.8f, 227.8f, 352.0f, 272.0f, 352.0f)
                close()
                moveTo(248.0f, 256.0f)
                curveTo(248.0f, 225.1f, 273.1f, 200.0f, 304.0f, 200.0f)
                curveTo(334.9f, 200.0f, 360.0f, 225.1f, 360.0f, 256.0f)
                curveTo(360.0f, 286.9f, 334.9f, 312.0f, 304.0f, 312.0f)
                curveTo(273.1f, 312.0f, 248.0f, 286.9f, 248.0f, 256.0f)
                close()
                moveTo(576.0f, 144.0f)
                curveTo(576.0f, 135.2f, 568.8f, 128.0f, 560.0f, 128.0f)
                curveTo(551.2f, 128.0f, 544.0f, 135.2f, 544.0f, 144.0f)
                lineTo(544.0f, 208.0f)
                curveTo(544.0f, 216.8f, 551.2f, 224.0f, 560.0f, 224.0f)
                curveTo(568.8f, 224.0f, 576.0f, 216.8f, 576.0f, 208.0f)
                lineTo(576.0f, 144.0f)
                close()
                moveTo(576.0f, 272.0f)
                curveTo(576.0f, 263.2f, 568.8f, 256.0f, 560.0f, 256.0f)
                curveTo(551.2f, 256.0f, 544.0f, 263.2f, 544.0f, 272.0f)
                lineTo(544.0f, 336.0f)
                curveTo(544.0f, 344.8f, 551.2f, 352.0f, 560.0f, 352.0f)
                curveTo(568.8f, 352.0f, 576.0f, 344.8f, 576.0f, 336.0f)
                lineTo(576.0f, 272.0f)
                close()
                moveTo(560.0f, 384.0f)
                curveTo(551.2f, 384.0f, 544.0f, 391.2f, 544.0f, 400.0f)
                lineTo(544.0f, 464.0f)
                curveTo(544.0f, 472.8f, 551.2f, 480.0f, 560.0f, 480.0f)
                curveTo(568.8f, 480.0f, 576.0f, 472.8f, 576.0f, 464.0f)
                lineTo(576.0f, 400.0f)
                curveTo(576.0f, 391.2f, 568.8f, 384.0f, 560.0f, 384.0f)
                close()
            }
        }
        .build()
        return `_contact-book`!!
    }

private var `_contact-book`: ImageVector? = null
