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

public val Fa.`Wine-bottle`: ImageVector
    get() {
        if (`_wine-bottle` != null) {
            return `_wine-bottle`!!
        }
        `_wine-bottle` = Builder(name = "Wine-bottle", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(240.0f, 32.0f)
                curveTo(240.0f, 14.3f, 254.3f, 0.0f, 272.0f, 0.0f)
                lineTo(368.0f, 0.0f)
                curveTo(385.7f, 0.0f, 400.0f, 14.3f, 400.0f, 32.0f)
                curveTo(400.0f, 43.8f, 393.6f, 54.2f, 384.0f, 59.7f)
                lineTo(384.0f, 205.3f)
                curveTo(440.5f, 230.0f, 480.0f, 286.4f, 480.0f, 352.0f)
                lineTo(480.0f, 576.0f)
                curveTo(480.0f, 611.3f, 451.3f, 640.0f, 416.0f, 640.0f)
                lineTo(224.0f, 640.0f)
                curveTo(188.7f, 640.0f, 160.0f, 611.3f, 160.0f, 576.0f)
                lineTo(160.0f, 352.0f)
                curveTo(160.0f, 286.4f, 199.5f, 230.0f, 256.0f, 205.3f)
                lineTo(256.0f, 59.7f)
                curveTo(246.4f, 54.2f, 240.0f, 43.8f, 240.0f, 32.0f)
                close()
                moveTo(256.0f, 352.0f)
                curveTo(238.3f, 352.0f, 224.0f, 366.3f, 224.0f, 384.0f)
                lineTo(224.0f, 512.0f)
                curveTo(224.0f, 529.7f, 238.3f, 544.0f, 256.0f, 544.0f)
                lineTo(384.0f, 544.0f)
                curveTo(401.7f, 544.0f, 416.0f, 529.7f, 416.0f, 512.0f)
                lineTo(416.0f, 384.0f)
                curveTo(416.0f, 366.3f, 401.7f, 352.0f, 384.0f, 352.0f)
                lineTo(256.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_wine-bottle`!!
    }

private var `_wine-bottle`: ImageVector? = null
