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

public val Fa.`Window-minimize`: ImageVector
    get() {
        if (`_window-minimize` != null) {
            return `_window-minimize`!!
        }
        `_window-minimize` = Builder(name = "Window-minimize", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 480.0f)
                curveTo(64.0f, 462.3f, 78.3f, 448.0f, 96.0f, 448.0f)
                lineTo(544.0f, 448.0f)
                curveTo(561.7f, 448.0f, 576.0f, 462.3f, 576.0f, 480.0f)
                curveTo(576.0f, 497.7f, 561.7f, 512.0f, 544.0f, 512.0f)
                lineTo(96.0f, 512.0f)
                curveTo(78.3f, 512.0f, 64.0f, 497.7f, 64.0f, 480.0f)
                close()
            }
        }
        .build()
        return `_window-minimize`!!
    }

private var `_window-minimize`: ImageVector? = null
