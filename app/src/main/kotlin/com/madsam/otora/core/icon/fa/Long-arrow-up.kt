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

public val Fa.`Long-arrow-up`: ImageVector
    get() {
        if (`_long-arrow-up` != null) {
            return `_long-arrow-up`!!
        }
        `_long-arrow-up` = Builder(name = "Long-arrow-up", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(342.6f, 41.4f)
                curveTo(330.1f, 28.9f, 309.8f, 28.9f, 297.3f, 41.4f)
                lineTo(169.3f, 169.4f)
                curveTo(156.8f, 181.9f, 156.8f, 202.2f, 169.3f, 214.7f)
                curveTo(181.8f, 227.2f, 202.1f, 227.2f, 214.6f, 214.7f)
                lineTo(288.0f, 141.3f)
                lineTo(288.0f, 576.0f)
                curveTo(288.0f, 593.7f, 302.3f, 608.0f, 320.0f, 608.0f)
                curveTo(337.7f, 608.0f, 352.0f, 593.7f, 352.0f, 576.0f)
                lineTo(352.0f, 141.3f)
                lineTo(425.4f, 214.7f)
                curveTo(437.9f, 227.2f, 458.2f, 227.2f, 470.7f, 214.7f)
                curveTo(483.2f, 202.2f, 483.2f, 181.9f, 470.7f, 169.4f)
                lineTo(342.7f, 41.4f)
                close()
            }
        }
        .build()
        return `_long-arrow-up`!!
    }

private var `_long-arrow-up`: ImageVector? = null
