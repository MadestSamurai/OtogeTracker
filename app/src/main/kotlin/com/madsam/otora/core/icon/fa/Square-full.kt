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

public val Fa.`Square-full`: ImageVector
    get() {
        if (`_square-full` != null) {
            return `_square-full`!!
        }
        `_square-full` = Builder(name = "Square-full", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 128.0f)
                curveTo(64.0f, 92.7f, 92.7f, 64.0f, 128.0f, 64.0f)
                lineTo(512.0f, 64.0f)
                curveTo(547.3f, 64.0f, 576.0f, 92.7f, 576.0f, 128.0f)
                lineTo(576.0f, 512.0f)
                curveTo(576.0f, 547.3f, 547.3f, 576.0f, 512.0f, 576.0f)
                lineTo(128.0f, 576.0f)
                curveTo(92.7f, 576.0f, 64.0f, 547.3f, 64.0f, 512.0f)
                lineTo(64.0f, 128.0f)
                close()
            }
        }
        .build()
        return `_square-full`!!
    }

private var `_square-full`: ImageVector? = null
