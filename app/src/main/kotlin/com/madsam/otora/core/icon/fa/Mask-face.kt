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

public val Fa.`Mask-face`: ImageVector
    get() {
        if (`_mask-face` != null) {
            return `_mask-face`!!
        }
        `_mask-face` = Builder(name = "Mask-face", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 128.0f)
                curveTo(292.8f, 128.0f, 266.2f, 136.0f, 243.6f, 151.1f)
                lineTo(206.5f, 175.9f)
                curveTo(190.7f, 186.4f, 172.2f, 192.0f, 153.2f, 192.0f)
                lineTo(64.0f, 192.0f)
                curveTo(28.7f, 192.0f, 0.0f, 220.7f, 0.0f, 256.0f)
                lineTo(0.0f, 334.7f)
                curveTo(0.0f, 397.3f, 45.2f, 450.7f, 107.0f, 461.0f)
                lineTo(204.9f, 477.3f)
                curveTo(237.9f, 499.3f, 277.5f, 512.0f, 320.0f, 512.0f)
                curveTo(362.5f, 512.0f, 402.2f, 499.2f, 435.1f, 477.3f)
                lineTo(533.0f, 460.9f)
                curveTo(594.7f, 450.6f, 640.0f, 397.2f, 640.0f, 334.6f)
                lineTo(640.0f, 255.9f)
                curveTo(640.0f, 220.6f, 611.3f, 191.9f, 576.0f, 191.9f)
                lineTo(486.8f, 191.9f)
                curveTo(467.8f, 191.9f, 449.3f, 186.3f, 433.5f, 175.8f)
                lineTo(396.4f, 151.1f)
                curveTo(373.8f, 136.0f, 347.2f, 128.0f, 320.0f, 128.0f)
                close()
                moveTo(135.9f, 400.9f)
                lineTo(117.5f, 397.8f)
                curveTo(86.6f, 392.7f, 64.0f, 366.0f, 64.0f, 334.7f)
                lineTo(64.0f, 256.0f)
                lineTo(112.0f, 256.0f)
                lineTo(112.0f, 304.0f)
                curveTo(112.0f, 339.0f, 120.6f, 371.9f, 135.9f, 400.9f)
                close()
                moveTo(522.5f, 397.8f)
                lineTo(504.1f, 400.9f)
                curveTo(519.4f, 371.9f, 528.0f, 339.0f, 528.0f, 304.0f)
                lineTo(528.0f, 256.0f)
                lineTo(576.0f, 256.0f)
                lineTo(576.0f, 334.7f)
                curveTo(576.0f, 366.0f, 553.4f, 392.7f, 522.5f, 397.8f)
                close()
                moveTo(192.0f, 296.0f)
                curveTo(192.0f, 282.7f, 202.7f, 272.0f, 216.0f, 272.0f)
                lineTo(424.0f, 272.0f)
                curveTo(437.3f, 272.0f, 448.0f, 282.7f, 448.0f, 296.0f)
                curveTo(448.0f, 309.3f, 437.3f, 320.0f, 424.0f, 320.0f)
                lineTo(216.0f, 320.0f)
                curveTo(202.7f, 320.0f, 192.0f, 309.3f, 192.0f, 296.0f)
                close()
                moveTo(248.0f, 352.0f)
                lineTo(392.0f, 352.0f)
                curveTo(405.3f, 352.0f, 416.0f, 362.7f, 416.0f, 376.0f)
                curveTo(416.0f, 389.3f, 405.3f, 400.0f, 392.0f, 400.0f)
                lineTo(248.0f, 400.0f)
                curveTo(234.7f, 400.0f, 224.0f, 389.3f, 224.0f, 376.0f)
                curveTo(224.0f, 362.7f, 234.7f, 352.0f, 248.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_mask-face`!!
    }

private var `_mask-face`: ImageVector? = null
