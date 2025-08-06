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

public val Fa.`Window-maximize`: ImageVector
    get() {
        if (`_window-maximize` != null) {
            return `_window-maximize`!!
        }
        `_window-maximize` = Builder(name = "Window-maximize", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(92.7f, 128.0f, 64.0f, 156.7f, 64.0f, 192.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                lineTo(512.0f, 512.0f)
                curveTo(547.3f, 512.0f, 576.0f, 483.3f, 576.0f, 448.0f)
                lineTo(576.0f, 192.0f)
                curveTo(576.0f, 156.7f, 547.3f, 128.0f, 512.0f, 128.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(152.0f, 192.0f)
                lineTo(488.0f, 192.0f)
                curveTo(501.3f, 192.0f, 512.0f, 202.7f, 512.0f, 216.0f)
                curveTo(512.0f, 229.3f, 501.3f, 240.0f, 488.0f, 240.0f)
                lineTo(152.0f, 240.0f)
                curveTo(138.7f, 240.0f, 128.0f, 229.3f, 128.0f, 216.0f)
                curveTo(128.0f, 202.7f, 138.7f, 192.0f, 152.0f, 192.0f)
                close()
            }
        }
        .build()
        return `_window-maximize`!!
    }

private var `_window-maximize`: ImageVector? = null
