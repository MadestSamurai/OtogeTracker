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

public val Fa.`Arrow-left-long`: ImageVector
    get() {
        if (`_arrow-left-long` != null) {
            return `_arrow-left-long`!!
        }
        `_arrow-left-long` = Builder(name = "Arrow-left-long", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(41.4f, 297.4f)
                curveTo(28.9f, 309.9f, 28.9f, 330.2f, 41.4f, 342.7f)
                lineTo(169.4f, 470.7f)
                curveTo(181.9f, 483.2f, 202.2f, 483.2f, 214.7f, 470.7f)
                curveTo(227.2f, 458.2f, 227.2f, 437.9f, 214.7f, 425.4f)
                lineTo(141.3f, 352.0f)
                lineTo(576.0f, 352.0f)
                curveTo(593.7f, 352.0f, 608.0f, 337.7f, 608.0f, 320.0f)
                curveTo(608.0f, 302.3f, 593.7f, 288.0f, 576.0f, 288.0f)
                lineTo(141.3f, 288.0f)
                lineTo(214.7f, 214.6f)
                curveTo(227.2f, 202.1f, 227.2f, 181.8f, 214.7f, 169.3f)
                curveTo(202.2f, 156.8f, 181.9f, 156.8f, 169.4f, 169.3f)
                lineTo(41.4f, 297.3f)
                close()
            }
        }
        .build()
        return `_arrow-left-long`!!
    }

private var `_arrow-left-long`: ImageVector? = null
