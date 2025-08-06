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

public val Fa.`Map-pin`: ImageVector
    get() {
        if (`_map-pin` != null) {
            return `_map-pin`!!
        }
        `_map-pin` = Builder(name = "Map-pin", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 348.4f)
                curveTo(416.1f, 333.9f, 464.0f, 276.5f, 464.0f, 208.0f)
                curveTo(464.0f, 128.5f, 399.5f, 64.0f, 320.0f, 64.0f)
                curveTo(240.5f, 64.0f, 176.0f, 128.5f, 176.0f, 208.0f)
                curveTo(176.0f, 276.5f, 223.9f, 333.9f, 288.0f, 348.4f)
                lineTo(288.0f, 544.0f)
                curveTo(288.0f, 561.7f, 302.3f, 576.0f, 320.0f, 576.0f)
                curveTo(337.7f, 576.0f, 352.0f, 561.7f, 352.0f, 544.0f)
                lineTo(352.0f, 348.4f)
                close()
                moveTo(328.0f, 160.0f)
                curveTo(297.1f, 160.0f, 272.0f, 185.1f, 272.0f, 216.0f)
                curveTo(272.0f, 229.3f, 261.3f, 240.0f, 248.0f, 240.0f)
                curveTo(234.7f, 240.0f, 224.0f, 229.3f, 224.0f, 216.0f)
                curveTo(224.0f, 158.6f, 270.6f, 112.0f, 328.0f, 112.0f)
                curveTo(341.3f, 112.0f, 352.0f, 122.7f, 352.0f, 136.0f)
                curveTo(352.0f, 149.3f, 341.3f, 160.0f, 328.0f, 160.0f)
                close()
            }
        }
        .build()
        return `_map-pin`!!
    }

private var `_map-pin`: ImageVector? = null
