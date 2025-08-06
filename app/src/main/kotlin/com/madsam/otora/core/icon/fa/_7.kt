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

public val Fa._7: ImageVector
    get() {
        if (__7 != null) {
            return __7!!
        }
        __7 = Builder(name = "_7", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth
                = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 128.0f)
                curveTo(160.0f, 110.3f, 174.3f, 96.0f, 192.0f, 96.0f)
                lineTo(448.0f, 96.0f)
                curveTo(459.5f, 96.0f, 470.0f, 102.1f, 475.7f, 112.1f)
                curveTo(481.4f, 122.1f, 481.4f, 134.3f, 475.6f, 144.2f)
                lineTo(251.6f, 528.2f)
                curveTo(242.7f, 543.5f, 223.1f, 548.6f, 207.8f, 539.7f)
                curveTo(192.5f, 530.8f, 187.4f, 511.2f, 196.3f, 495.9f)
                lineTo(392.3f, 160.0f)
                lineTo(192.0f, 160.0f)
                curveTo(174.3f, 160.0f, 160.0f, 145.7f, 160.0f, 128.0f)
                close()
            }
        }
        .build()
        return __7!!
    }

private var __7: ImageVector? = null
