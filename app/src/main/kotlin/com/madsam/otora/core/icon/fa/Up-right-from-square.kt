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

public val Fa.`Up-right-from-square`: ImageVector
    get() {
        if (`_up-right-from-square` != null) {
            return `_up-right-from-square`!!
        }
        `_up-right-from-square` = Builder(name = "Up-right-from-square", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(354.4f, 83.8f)
                curveTo(359.4f, 71.8f, 371.1f, 64.0f, 384.0f, 64.0f)
                lineTo(544.0f, 64.0f)
                curveTo(561.7f, 64.0f, 576.0f, 78.3f, 576.0f, 96.0f)
                lineTo(576.0f, 256.0f)
                curveTo(576.0f, 268.9f, 568.2f, 280.6f, 556.2f, 285.6f)
                curveTo(544.2f, 290.6f, 530.5f, 287.8f, 521.3f, 278.7f)
                lineTo(464.0f, 221.3f)
                lineTo(310.6f, 374.6f)
                curveTo(298.1f, 387.1f, 277.8f, 387.1f, 265.3f, 374.6f)
                curveTo(252.8f, 362.1f, 252.8f, 341.8f, 265.3f, 329.3f)
                lineTo(418.7f, 176.0f)
                lineTo(361.4f, 118.6f)
                curveTo(352.2f, 109.4f, 349.5f, 95.7f, 354.5f, 83.7f)
                close()
                moveTo(64.0f, 240.0f)
                curveTo(64.0f, 195.8f, 99.8f, 160.0f, 144.0f, 160.0f)
                lineTo(224.0f, 160.0f)
                curveTo(241.7f, 160.0f, 256.0f, 174.3f, 256.0f, 192.0f)
                curveTo(256.0f, 209.7f, 241.7f, 224.0f, 224.0f, 224.0f)
                lineTo(144.0f, 224.0f)
                curveTo(135.2f, 224.0f, 128.0f, 231.2f, 128.0f, 240.0f)
                lineTo(128.0f, 496.0f)
                curveTo(128.0f, 504.8f, 135.2f, 512.0f, 144.0f, 512.0f)
                lineTo(400.0f, 512.0f)
                curveTo(408.8f, 512.0f, 416.0f, 504.8f, 416.0f, 496.0f)
                lineTo(416.0f, 416.0f)
                curveTo(416.0f, 398.3f, 430.3f, 384.0f, 448.0f, 384.0f)
                curveTo(465.7f, 384.0f, 480.0f, 398.3f, 480.0f, 416.0f)
                lineTo(480.0f, 496.0f)
                curveTo(480.0f, 540.2f, 444.2f, 576.0f, 400.0f, 576.0f)
                lineTo(144.0f, 576.0f)
                curveTo(99.8f, 576.0f, 64.0f, 540.2f, 64.0f, 496.0f)
                lineTo(64.0f, 240.0f)
                close()
            }
        }
        .build()
        return `_up-right-from-square`!!
    }

private var `_up-right-from-square`: ImageVector? = null
