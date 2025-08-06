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

public val Fa.`Toggle-off`: ImageVector
    get() {
        if (`_toggle-off` != null) {
            return `_toggle-off`!!
        }
        `_toggle-off` = Builder(name = "Toggle-off", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(416.0f, 192.0f)
                curveTo(486.7f, 192.0f, 544.0f, 249.3f, 544.0f, 320.0f)
                curveTo(544.0f, 390.7f, 486.7f, 448.0f, 416.0f, 448.0f)
                lineTo(224.0f, 448.0f)
                curveTo(153.3f, 448.0f, 96.0f, 390.7f, 96.0f, 320.0f)
                curveTo(96.0f, 249.3f, 153.3f, 192.0f, 224.0f, 192.0f)
                lineTo(416.0f, 192.0f)
                close()
                moveTo(608.0f, 320.0f)
                curveTo(608.0f, 214.0f, 522.0f, 128.0f, 416.0f, 128.0f)
                lineTo(224.0f, 128.0f)
                curveTo(118.0f, 128.0f, 32.0f, 214.0f, 32.0f, 320.0f)
                curveTo(32.0f, 426.0f, 118.0f, 512.0f, 224.0f, 512.0f)
                lineTo(416.0f, 512.0f)
                curveTo(522.0f, 512.0f, 608.0f, 426.0f, 608.0f, 320.0f)
                close()
                moveTo(224.0f, 400.0f)
                curveTo(268.2f, 400.0f, 304.0f, 364.2f, 304.0f, 320.0f)
                curveTo(304.0f, 275.8f, 268.2f, 240.0f, 224.0f, 240.0f)
                curveTo(179.8f, 240.0f, 144.0f, 275.8f, 144.0f, 320.0f)
                curveTo(144.0f, 364.2f, 179.8f, 400.0f, 224.0f, 400.0f)
                close()
            }
        }
        .build()
        return `_toggle-off`!!
    }

private var `_toggle-off`: ImageVector? = null
