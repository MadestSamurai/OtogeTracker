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

public val Fa.`Kip-sign`: ImageVector
    get() {
        if (`_kip-sign` != null) {
            return `_kip-sign`!!
        }
        `_kip-sign` = Builder(name = "Kip-sign", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(468.8f, 152.3f)
                curveTo(482.2f, 140.8f, 483.8f, 120.6f, 472.3f, 107.2f)
                curveTo(460.8f, 93.8f, 440.6f, 92.2f, 427.2f, 103.7f)
                lineTo(256.0f, 250.4f)
                lineTo(256.0f, 128.0f)
                curveTo(256.0f, 110.3f, 241.7f, 96.0f, 224.0f, 96.0f)
                curveTo(206.3f, 96.0f, 192.0f, 110.3f, 192.0f, 128.0f)
                lineTo(192.0f, 296.0f)
                lineTo(160.0f, 296.0f)
                curveTo(146.7f, 296.0f, 136.0f, 306.7f, 136.0f, 320.0f)
                curveTo(136.0f, 333.3f, 146.7f, 344.0f, 160.0f, 344.0f)
                lineTo(192.0f, 344.0f)
                lineTo(192.0f, 512.0f)
                curveTo(192.0f, 529.7f, 206.3f, 544.0f, 224.0f, 544.0f)
                curveTo(241.7f, 544.0f, 256.0f, 529.7f, 256.0f, 512.0f)
                lineTo(256.0f, 389.6f)
                lineTo(427.2f, 536.3f)
                curveTo(440.6f, 547.8f, 460.8f, 546.2f, 472.3f, 532.8f)
                curveTo(483.8f, 519.4f, 482.2f, 499.2f, 468.8f, 487.7f)
                lineTo(301.2f, 344.0f)
                lineTo(480.0f, 344.0f)
                curveTo(493.3f, 344.0f, 504.0f, 333.3f, 504.0f, 320.0f)
                curveTo(504.0f, 306.7f, 493.3f, 296.0f, 480.0f, 296.0f)
                lineTo(301.2f, 296.0f)
                lineTo(468.8f, 152.3f)
                close()
            }
        }
        .build()
        return `_kip-sign`!!
    }

private var `_kip-sign`: ImageVector? = null
