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

public val Fa.`Home-lg`: ImageVector
    get() {
        if (`_home-lg` != null) {
            return `_home-lg`!!
        }
        `_home-lg` = Builder(name = "Home-lg", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(298.2f, 72.6f)
                curveTo(310.5f, 61.2f, 329.5f, 61.2f, 341.7f, 72.6f)
                lineTo(432.0f, 156.3f)
                lineTo(432.0f, 144.0f)
                curveTo(432.0f, 126.3f, 446.3f, 112.0f, 464.0f, 112.0f)
                lineTo(496.0f, 112.0f)
                curveTo(513.7f, 112.0f, 528.0f, 126.3f, 528.0f, 144.0f)
                lineTo(528.0f, 245.5f)
                lineTo(565.8f, 280.6f)
                curveTo(575.4f, 289.6f, 578.6f, 303.5f, 573.8f, 315.7f)
                curveTo(569.0f, 327.9f, 557.2f, 336.0f, 544.0f, 336.0f)
                lineTo(528.0f, 336.0f)
                lineTo(528.0f, 512.0f)
                curveTo(528.0f, 547.3f, 499.3f, 576.0f, 464.0f, 576.0f)
                lineTo(176.0f, 576.0f)
                curveTo(140.7f, 576.0f, 112.0f, 547.3f, 112.0f, 512.0f)
                lineTo(112.0f, 336.0f)
                lineTo(96.0f, 336.0f)
                curveTo(82.8f, 336.0f, 71.0f, 327.9f, 66.2f, 315.7f)
                curveTo(61.4f, 303.5f, 64.6f, 289.5f, 74.2f, 280.6f)
                lineTo(298.2f, 72.6f)
                close()
                moveTo(304.0f, 384.0f)
                curveTo(277.5f, 384.0f, 256.0f, 405.5f, 256.0f, 432.0f)
                lineTo(256.0f, 528.0f)
                lineTo(384.0f, 528.0f)
                lineTo(384.0f, 432.0f)
                curveTo(384.0f, 405.5f, 362.5f, 384.0f, 336.0f, 384.0f)
                lineTo(304.0f, 384.0f)
                close()
            }
        }
        .build()
        return `_home-lg`!!
    }

private var `_home-lg`: ImageVector? = null
