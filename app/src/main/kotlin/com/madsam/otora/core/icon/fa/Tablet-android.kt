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

public val Fa.`Tablet-android`: ImageVector
    get() {
        if (`_tablet-android` != null) {
            return `_tablet-android`!!
        }
        `_tablet-android` = Builder(name = "Tablet-android", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 64.0f)
                curveTo(124.7f, 64.0f, 96.0f, 92.7f, 96.0f, 128.0f)
                lineTo(96.0f, 512.0f)
                curveTo(96.0f, 547.3f, 124.7f, 576.0f, 160.0f, 576.0f)
                lineTo(480.0f, 576.0f)
                curveTo(515.3f, 576.0f, 544.0f, 547.3f, 544.0f, 512.0f)
                lineTo(544.0f, 128.0f)
                curveTo(544.0f, 92.7f, 515.3f, 64.0f, 480.0f, 64.0f)
                lineTo(160.0f, 64.0f)
                close()
                moveTo(280.0f, 464.0f)
                lineTo(360.0f, 464.0f)
                curveTo(373.3f, 464.0f, 384.0f, 474.7f, 384.0f, 488.0f)
                curveTo(384.0f, 501.3f, 373.3f, 512.0f, 360.0f, 512.0f)
                lineTo(280.0f, 512.0f)
                curveTo(266.7f, 512.0f, 256.0f, 501.3f, 256.0f, 488.0f)
                curveTo(256.0f, 474.7f, 266.7f, 464.0f, 280.0f, 464.0f)
                close()
            }
        }
        .build()
        return `_tablet-android`!!
    }

private var `_tablet-android`: ImageVector? = null
