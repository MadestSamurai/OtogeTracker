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

public val Fa.`Location-dot`: ImageVector
    get() {
        if (`_location-dot` != null) {
            return `_location-dot`!!
        }
        `_location-dot` = Builder(name = "Location-dot", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 252.6f)
                curveTo(128.0f, 148.4f, 214.0f, 64.0f, 320.0f, 64.0f)
                curveTo(426.0f, 64.0f, 512.0f, 148.4f, 512.0f, 252.6f)
                curveTo(512.0f, 371.9f, 391.8f, 514.9f, 341.6f, 569.4f)
                curveTo(329.8f, 582.2f, 310.1f, 582.2f, 298.3f, 569.4f)
                curveTo(248.1f, 514.9f, 127.9f, 371.9f, 127.9f, 252.6f)
                close()
                moveTo(320.0f, 320.0f)
                curveTo(355.3f, 320.0f, 384.0f, 291.3f, 384.0f, 256.0f)
                curveTo(384.0f, 220.7f, 355.3f, 192.0f, 320.0f, 192.0f)
                curveTo(284.7f, 192.0f, 256.0f, 220.7f, 256.0f, 256.0f)
                curveTo(256.0f, 291.3f, 284.7f, 320.0f, 320.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_location-dot`!!
    }

private var `_location-dot`: ImageVector? = null
