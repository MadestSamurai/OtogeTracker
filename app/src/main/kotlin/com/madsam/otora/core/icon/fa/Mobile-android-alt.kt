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

public val Fa.`Mobile-android-alt`: ImageVector
    get() {
        if (`_mobile-android-alt` != null) {
            return `_mobile-android-alt`!!
        }
        `_mobile-android-alt` = Builder(name = "Mobile-android-alt", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(144.0f, 128.0f)
                curveTo(144.0f, 92.7f, 172.7f, 64.0f, 208.0f, 64.0f)
                lineTo(432.0f, 64.0f)
                curveTo(467.3f, 64.0f, 496.0f, 92.7f, 496.0f, 128.0f)
                lineTo(496.0f, 512.0f)
                curveTo(496.0f, 547.3f, 467.3f, 576.0f, 432.0f, 576.0f)
                lineTo(208.0f, 576.0f)
                curveTo(172.7f, 576.0f, 144.0f, 547.3f, 144.0f, 512.0f)
                lineTo(144.0f, 128.0f)
                close()
                moveTo(256.0f, 504.0f)
                curveTo(256.0f, 517.3f, 266.7f, 528.0f, 280.0f, 528.0f)
                lineTo(360.0f, 528.0f)
                curveTo(373.3f, 528.0f, 384.0f, 517.3f, 384.0f, 504.0f)
                curveTo(384.0f, 490.7f, 373.3f, 480.0f, 360.0f, 480.0f)
                lineTo(280.0f, 480.0f)
                curveTo(266.7f, 480.0f, 256.0f, 490.7f, 256.0f, 504.0f)
                close()
                moveTo(432.0f, 128.0f)
                lineTo(208.0f, 128.0f)
                lineTo(208.0f, 432.0f)
                lineTo(432.0f, 432.0f)
                lineTo(432.0f, 128.0f)
                close()
            }
        }
        .build()
        return `_mobile-android-alt`!!
    }

private var `_mobile-android-alt`: ImageVector? = null
