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

public val Fa.`Star-half`: ImageVector
    get() {
        if (`_star-half` != null) {
            return `_star-half`!!
        }
        `_star-half` = Builder(name = "Star-half", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(336.1f, 71.6f)
                curveTo(336.1f, 60.5f, 328.5f, 50.9f, 317.7f, 48.3f)
                curveTo(306.9f, 45.7f, 295.8f, 50.8f, 290.7f, 60.7f)
                lineTo(225.1f, 189.3f)
                lineTo(65.2f, 214.7f)
                curveTo(56.3f, 216.1f, 48.9f, 222.4f, 46.1f, 231.0f)
                curveTo(43.3f, 239.6f, 45.6f, 249.0f, 51.9f, 255.4f)
                lineTo(166.3f, 369.9f)
                lineTo(141.1f, 529.8f)
                curveTo(139.7f, 538.7f, 143.4f, 547.7f, 150.7f, 553.0f)
                curveTo(158.0f, 558.3f, 167.6f, 559.1f, 175.7f, 555.0f)
                lineTo(323.0f, 480.1f)
                curveTo(331.0f, 476.0f, 336.1f, 467.7f, 336.1f, 458.7f)
                lineTo(336.1f, 71.6f)
                close()
            }
        }
        .build()
        return `_star-half`!!
    }

private var `_star-half`: ImageVector? = null
