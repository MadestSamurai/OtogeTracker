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

public val Fa.`User-alt-slash`: ImageVector
    get() {
        if (`_user-alt-slash` != null) {
            return `_user-alt-slash`!!
        }
        `_user-alt-slash` = Builder(name = "User-alt-slash", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(343.5f, 309.7f)
                curveTo(398.5f, 298.8f, 440.0f, 250.2f, 440.0f, 192.0f)
                curveTo(440.0f, 125.7f, 386.3f, 72.0f, 320.0f, 72.0f)
                curveTo(261.8f, 72.0f, 213.2f, 113.5f, 202.3f, 168.5f)
                lineTo(73.0f, 39.1f)
                close()
                moveTo(267.6f, 369.4f)
                curveTo(179.9f, 380.6f, 112.0f, 455.5f, 112.0f, 546.3f)
                curveTo(112.0f, 562.7f, 125.3f, 576.0f, 141.7f, 576.0f)
                lineTo(474.2f, 576.0f)
                lineTo(267.6f, 369.4f)
                close()
            }
        }
        .build()
        return `_user-alt-slash`!!
    }

private var `_user-alt-slash`: ImageVector? = null
