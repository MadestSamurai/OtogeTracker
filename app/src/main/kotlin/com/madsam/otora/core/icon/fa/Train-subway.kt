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

public val Fa.`Train-subway`: ImageVector
    get() {
        if (`_train-subway` != null) {
            return `_train-subway`!!
        }
        `_train-subway` = Builder(name = "Train-subway", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 160.0f)
                curveTo(128.0f, 107.0f, 171.0f, 64.0f, 224.0f, 64.0f)
                lineTo(416.0f, 64.0f)
                curveTo(469.0f, 64.0f, 512.0f, 107.0f, 512.0f, 160.0f)
                lineTo(512.0f, 416.0f)
                curveTo(512.0f, 456.1f, 487.4f, 490.5f, 452.5f, 504.8f)
                lineTo(506.4f, 568.5f)
                curveTo(515.0f, 578.6f, 513.7f, 593.8f, 503.6f, 602.3f)
                curveTo(493.5f, 610.8f, 478.3f, 609.6f, 469.8f, 599.5f)
                lineTo(395.8f, 512.0f)
                lineTo(244.5f, 512.0f)
                lineTo(170.5f, 599.5f)
                curveTo(161.9f, 609.6f, 146.8f, 610.9f, 136.7f, 602.3f)
                curveTo(126.6f, 593.7f, 125.3f, 578.6f, 133.9f, 568.5f)
                lineTo(187.8f, 504.8f)
                curveTo(152.6f, 490.5f, 128.0f, 456.1f, 128.0f, 416.0f)
                lineTo(128.0f, 160.0f)
                close()
                moveTo(192.0f, 192.0f)
                lineTo(192.0f, 288.0f)
                curveTo(192.0f, 305.7f, 206.3f, 320.0f, 224.0f, 320.0f)
                lineTo(296.0f, 320.0f)
                lineTo(296.0f, 160.0f)
                lineTo(224.0f, 160.0f)
                curveTo(206.3f, 160.0f, 192.0f, 174.3f, 192.0f, 192.0f)
                close()
                moveTo(344.0f, 320.0f)
                lineTo(416.0f, 320.0f)
                curveTo(433.7f, 320.0f, 448.0f, 305.7f, 448.0f, 288.0f)
                lineTo(448.0f, 192.0f)
                curveTo(448.0f, 174.3f, 433.7f, 160.0f, 416.0f, 160.0f)
                lineTo(344.0f, 160.0f)
                lineTo(344.0f, 320.0f)
                close()
                moveTo(224.0f, 448.0f)
                curveTo(241.7f, 448.0f, 256.0f, 433.7f, 256.0f, 416.0f)
                curveTo(256.0f, 398.3f, 241.7f, 384.0f, 224.0f, 384.0f)
                curveTo(206.3f, 384.0f, 192.0f, 398.3f, 192.0f, 416.0f)
                curveTo(192.0f, 433.7f, 206.3f, 448.0f, 224.0f, 448.0f)
                close()
                moveTo(448.0f, 416.0f)
                curveTo(448.0f, 398.3f, 433.7f, 384.0f, 416.0f, 384.0f)
                curveTo(398.3f, 384.0f, 384.0f, 398.3f, 384.0f, 416.0f)
                curveTo(384.0f, 433.7f, 398.3f, 448.0f, 416.0f, 448.0f)
                curveTo(433.7f, 448.0f, 448.0f, 433.7f, 448.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_train-subway`!!
    }

private var `_train-subway`: ImageVector? = null
