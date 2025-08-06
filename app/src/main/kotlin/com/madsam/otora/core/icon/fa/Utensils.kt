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

public val Fa.Utensils: ImageVector
    get() {
        if (_utensils != null) {
            return _utensils!!
        }
        _utensils = Builder(name = "Utensils", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(127.9f, 78.4f)
                curveTo(127.1f, 70.2f, 120.2f, 64.0f, 112.0f, 64.0f)
                curveTo(103.8f, 64.0f, 96.9f, 70.2f, 96.0f, 78.3f)
                lineTo(81.9f, 213.7f)
                curveTo(80.6f, 219.7f, 80.0f, 225.8f, 80.0f, 231.9f)
                curveTo(80.0f, 277.8f, 115.1f, 315.5f, 160.0f, 319.6f)
                lineTo(160.0f, 544.0f)
                curveTo(160.0f, 561.7f, 174.3f, 576.0f, 192.0f, 576.0f)
                curveTo(209.7f, 576.0f, 224.0f, 561.7f, 224.0f, 544.0f)
                lineTo(224.0f, 319.6f)
                curveTo(268.9f, 315.5f, 304.0f, 277.8f, 304.0f, 231.9f)
                curveTo(304.0f, 225.8f, 303.4f, 219.7f, 302.1f, 213.7f)
                lineTo(287.9f, 78.3f)
                curveTo(287.1f, 70.2f, 280.2f, 64.0f, 272.0f, 64.0f)
                curveTo(263.8f, 64.0f, 256.9f, 70.2f, 256.1f, 78.4f)
                lineTo(242.5f, 213.9f)
                curveTo(241.9f, 219.6f, 237.1f, 224.0f, 231.4f, 224.0f)
                curveTo(225.6f, 224.0f, 220.8f, 219.6f, 220.2f, 213.8f)
                lineTo(207.9f, 78.6f)
                curveTo(207.2f, 70.3f, 200.3f, 64.0f, 192.0f, 64.0f)
                curveTo(183.7f, 64.0f, 176.8f, 70.3f, 176.1f, 78.6f)
                lineTo(163.8f, 213.8f)
                curveTo(163.3f, 219.6f, 158.4f, 224.0f, 152.6f, 224.0f)
                curveTo(146.8f, 224.0f, 142.0f, 219.6f, 141.5f, 213.9f)
                lineTo(127.9f, 78.4f)
                close()
                moveTo(512.0f, 64.0f)
                curveTo(496.0f, 64.0f, 384.0f, 96.0f, 384.0f, 240.0f)
                lineTo(384.0f, 352.0f)
                curveTo(384.0f, 387.3f, 412.7f, 416.0f, 448.0f, 416.0f)
                lineTo(480.0f, 416.0f)
                lineTo(480.0f, 544.0f)
                curveTo(480.0f, 561.7f, 494.3f, 576.0f, 512.0f, 576.0f)
                curveTo(529.7f, 576.0f, 544.0f, 561.7f, 544.0f, 544.0f)
                lineTo(544.0f, 96.0f)
                curveTo(544.0f, 78.3f, 529.7f, 64.0f, 512.0f, 64.0f)
                close()
            }
        }
        .build()
        return _utensils!!
    }

private var _utensils: ImageVector? = null
