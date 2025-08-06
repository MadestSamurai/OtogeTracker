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

public val Fa.`Less-than`: ImageVector
    get() {
        if (`_less-than` != null) {
            return `_less-than`!!
        }
        `_less-than` = Builder(name = "Less-than", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(541.1f, 114.6f)
                curveTo(548.5f, 130.6f, 541.5f, 149.7f, 525.5f, 157.1f)
                lineTo(172.4f, 320.0f)
                lineTo(525.4f, 483.0f)
                curveTo(541.4f, 490.4f, 548.4f, 509.4f, 541.0f, 525.5f)
                curveTo(533.6f, 541.6f, 514.6f, 548.5f, 498.5f, 541.1f)
                lineTo(82.5f, 349.1f)
                curveTo(71.3f, 343.8f, 64.0f, 332.5f, 64.0f, 320.0f)
                curveTo(64.0f, 307.5f, 71.3f, 296.2f, 82.6f, 291.0f)
                lineTo(498.6f, 99.0f)
                curveTo(514.6f, 91.6f, 533.7f, 98.6f, 541.1f, 114.6f)
                close()
            }
        }
        .build()
        return `_less-than`!!
    }

private var `_less-than`: ImageVector? = null
