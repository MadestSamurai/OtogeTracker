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

public val Fa.`Toggle-on`: ImageVector
    get() {
        if (`_toggle-on` != null) {
            return `_toggle-on`!!
        }
        `_toggle-on` = Builder(name = "Toggle-on", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 128.0f)
                curveTo(118.0f, 128.0f, 32.0f, 214.0f, 32.0f, 320.0f)
                curveTo(32.0f, 426.0f, 118.0f, 512.0f, 224.0f, 512.0f)
                lineTo(416.0f, 512.0f)
                curveTo(522.0f, 512.0f, 608.0f, 426.0f, 608.0f, 320.0f)
                curveTo(608.0f, 214.0f, 522.0f, 128.0f, 416.0f, 128.0f)
                lineTo(224.0f, 128.0f)
                close()
                moveTo(416.0f, 224.0f)
                curveTo(469.0f, 224.0f, 512.0f, 267.0f, 512.0f, 320.0f)
                curveTo(512.0f, 373.0f, 469.0f, 416.0f, 416.0f, 416.0f)
                curveTo(363.0f, 416.0f, 320.0f, 373.0f, 320.0f, 320.0f)
                curveTo(320.0f, 267.0f, 363.0f, 224.0f, 416.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_toggle-on`!!
    }

private var `_toggle-on`: ImageVector? = null
