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

public val Fa.`Circle-h`: ImageVector
    get() {
        if (`_circle-h` != null) {
            return `_circle-h`!!
        }
        `_circle-h` = Builder(name = "Circle-h", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(416.0f, 232.0f)
                lineTo(416.0f, 408.0f)
                curveTo(416.0f, 421.3f, 405.3f, 432.0f, 392.0f, 432.0f)
                curveTo(378.7f, 432.0f, 368.0f, 421.3f, 368.0f, 408.0f)
                lineTo(368.0f, 344.0f)
                lineTo(272.0f, 344.0f)
                lineTo(272.0f, 408.0f)
                curveTo(272.0f, 421.3f, 261.3f, 432.0f, 248.0f, 432.0f)
                curveTo(234.7f, 432.0f, 224.0f, 421.3f, 224.0f, 408.0f)
                lineTo(224.0f, 232.0f)
                curveTo(224.0f, 218.7f, 234.7f, 208.0f, 248.0f, 208.0f)
                curveTo(261.3f, 208.0f, 272.0f, 218.7f, 272.0f, 232.0f)
                lineTo(272.0f, 296.0f)
                lineTo(368.0f, 296.0f)
                lineTo(368.0f, 232.0f)
                curveTo(368.0f, 218.7f, 378.7f, 208.0f, 392.0f, 208.0f)
                curveTo(405.3f, 208.0f, 416.0f, 218.7f, 416.0f, 232.0f)
                close()
            }
        }
        .build()
        return `_circle-h`!!
    }

private var `_circle-h`: ImageVector? = null
