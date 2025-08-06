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

public val Fa.`Arrow-turn-down`: ImageVector
    get() {
        if (`_arrow-turn-down` != null) {
            return `_arrow-turn-down`!!
        }
        `_arrow-turn-down` = Builder(name = "Arrow-turn-down", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 128.0f)
                curveTo(142.3f, 128.0f, 128.0f, 113.7f, 128.0f, 96.0f)
                curveTo(128.0f, 78.3f, 142.3f, 64.0f, 160.0f, 64.0f)
                lineTo(256.0f, 64.0f)
                curveTo(309.0f, 64.0f, 352.0f, 107.0f, 352.0f, 160.0f)
                lineTo(352.0f, 466.7f)
                lineTo(425.4f, 393.3f)
                curveTo(437.9f, 380.8f, 458.2f, 380.8f, 470.7f, 393.3f)
                curveTo(483.2f, 405.8f, 483.2f, 426.1f, 470.7f, 438.6f)
                lineTo(342.7f, 566.6f)
                curveTo(330.2f, 579.1f, 309.9f, 579.1f, 297.4f, 566.6f)
                lineTo(169.4f, 438.6f)
                curveTo(156.9f, 426.1f, 156.9f, 405.8f, 169.4f, 393.3f)
                curveTo(181.9f, 380.8f, 202.2f, 380.8f, 214.7f, 393.3f)
                lineTo(288.0f, 466.7f)
                lineTo(288.0f, 160.0f)
                curveTo(288.0f, 142.3f, 273.7f, 128.0f, 256.0f, 128.0f)
                lineTo(160.0f, 128.0f)
                close()
            }
        }
        .build()
        return `_arrow-turn-down`!!
    }

private var `_arrow-turn-down`: ImageVector? = null
