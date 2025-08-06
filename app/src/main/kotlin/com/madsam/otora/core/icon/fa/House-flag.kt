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

public val Fa.`House-flag`: ImageVector
    get() {
        if (`_house-flag` != null) {
            return `_house-flag`!!
        }
        `_house-flag` = Builder(name = "House-flag", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(472.0f, 64.0f)
                curveTo(489.7f, 64.0f, 504.0f, 78.3f, 504.0f, 96.0f)
                lineTo(600.0f, 96.0f)
                curveTo(617.7f, 96.0f, 632.0f, 110.3f, 632.0f, 128.0f)
                lineTo(632.0f, 224.0f)
                curveTo(632.0f, 241.7f, 617.7f, 256.0f, 600.0f, 256.0f)
                lineTo(504.0f, 256.0f)
                lineTo(504.0f, 544.0f)
                curveTo(504.0f, 561.7f, 489.7f, 576.0f, 472.0f, 576.0f)
                curveTo(454.3f, 576.0f, 440.0f, 561.7f, 440.0f, 544.0f)
                lineTo(440.0f, 96.0f)
                curveTo(440.0f, 78.3f, 454.3f, 64.0f, 472.0f, 64.0f)
                close()
                moveTo(283.5f, 123.1f)
                lineTo(384.0f, 220.0f)
                lineTo(384.0f, 576.0f)
                lineTo(128.0f, 576.0f)
                curveTo(92.7f, 576.0f, 64.0f, 547.3f, 64.0f, 512.0f)
                lineTo(64.0f, 368.0f)
                lineTo(44.1f, 368.0f)
                curveTo(28.6f, 368.0f, 16.0f, 355.4f, 16.0f, 339.9f)
                curveTo(16.0f, 332.3f, 19.1f, 325.0f, 24.6f, 319.7f)
                lineTo(228.5f, 123.1f)
                curveTo(235.9f, 116.0f, 245.7f, 112.0f, 256.0f, 112.0f)
                curveTo(266.3f, 112.0f, 276.1f, 116.0f, 283.5f, 123.1f)
                close()
                moveTo(232.0f, 320.0f)
                curveTo(218.7f, 320.0f, 208.0f, 330.7f, 208.0f, 344.0f)
                lineTo(208.0f, 392.0f)
                curveTo(208.0f, 405.3f, 218.7f, 416.0f, 232.0f, 416.0f)
                lineTo(280.0f, 416.0f)
                curveTo(293.3f, 416.0f, 304.0f, 405.3f, 304.0f, 392.0f)
                lineTo(304.0f, 344.0f)
                curveTo(304.0f, 330.7f, 293.3f, 320.0f, 280.0f, 320.0f)
                lineTo(232.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_house-flag`!!
    }

private var `_house-flag`: ImageVector? = null
