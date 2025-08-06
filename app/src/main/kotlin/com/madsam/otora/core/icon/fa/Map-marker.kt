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

public val Fa.`Map-marker`: ImageVector
    get() {
        if (`_map-marker` != null) {
            return `_map-marker`!!
        }
        `_map-marker` = Builder(name = "Map-marker", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(214.0f, 64.0f, 128.0f, 148.4f, 128.0f, 252.6f)
                curveTo(128.0f, 371.9f, 248.2f, 514.9f, 298.4f, 569.4f)
                curveTo(310.2f, 582.2f, 329.8f, 582.2f, 341.6f, 569.4f)
                curveTo(391.8f, 514.9f, 512.0f, 371.9f, 512.0f, 252.6f)
                curveTo(512.0f, 148.4f, 426.0f, 64.0f, 320.0f, 64.0f)
                close()
            }
        }
        .build()
        return `_map-marker`!!
    }

private var `_map-marker`: ImageVector? = null
