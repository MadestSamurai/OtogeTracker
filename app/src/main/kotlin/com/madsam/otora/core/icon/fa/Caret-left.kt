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

public val Fa.`Caret-left`: ImageVector
    get() {
        if (`_caret-left` != null) {
            return `_caret-left`!!
        }
        `_caret-left` = Builder(name = "Caret-left", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(416.0f, 160.0f)
                curveTo(416.0f, 147.1f, 408.2f, 135.4f, 396.2f, 130.4f)
                curveTo(384.2f, 125.4f, 370.5f, 128.2f, 361.3f, 137.3f)
                lineTo(201.3f, 297.3f)
                curveTo(188.8f, 309.8f, 188.8f, 330.1f, 201.3f, 342.6f)
                lineTo(361.3f, 502.6f)
                curveTo(370.5f, 511.8f, 384.2f, 514.5f, 396.2f, 509.5f)
                curveTo(408.2f, 504.5f, 416.0f, 492.9f, 416.0f, 480.0f)
                lineTo(416.0f, 160.0f)
                close()
            }
        }
        .build()
        return `_caret-left`!!
    }

private var `_caret-left`: ImageVector? = null
