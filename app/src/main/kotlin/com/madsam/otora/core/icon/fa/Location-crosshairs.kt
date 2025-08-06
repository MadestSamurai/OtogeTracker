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

public val Fa.`Location-crosshairs`: ImageVector
    get() {
        if (`_location-crosshairs` != null) {
            return `_location-crosshairs`!!
        }
        `_location-crosshairs` = Builder(name = "Location-crosshairs", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 48.0f)
                curveTo(337.7f, 48.0f, 352.0f, 62.3f, 352.0f, 80.0f)
                lineTo(352.0f, 98.3f)
                curveTo(450.1f, 112.3f, 527.7f, 189.9f, 541.7f, 288.0f)
                lineTo(560.0f, 288.0f)
                curveTo(577.7f, 288.0f, 592.0f, 302.3f, 592.0f, 320.0f)
                curveTo(592.0f, 337.7f, 577.7f, 352.0f, 560.0f, 352.0f)
                lineTo(541.7f, 352.0f)
                curveTo(527.7f, 450.1f, 450.1f, 527.7f, 352.0f, 541.7f)
                lineTo(352.0f, 560.0f)
                curveTo(352.0f, 577.7f, 337.7f, 592.0f, 320.0f, 592.0f)
                curveTo(302.3f, 592.0f, 288.0f, 577.7f, 288.0f, 560.0f)
                lineTo(288.0f, 541.7f)
                curveTo(189.9f, 527.7f, 112.3f, 450.1f, 98.3f, 352.0f)
                lineTo(80.0f, 352.0f)
                curveTo(62.3f, 352.0f, 48.0f, 337.7f, 48.0f, 320.0f)
                curveTo(48.0f, 302.3f, 62.3f, 288.0f, 80.0f, 288.0f)
                lineTo(98.3f, 288.0f)
                curveTo(112.3f, 189.9f, 189.9f, 112.3f, 288.0f, 98.3f)
                lineTo(288.0f, 80.0f)
                curveTo(288.0f, 62.3f, 302.3f, 48.0f, 320.0f, 48.0f)
                close()
                moveTo(160.0f, 320.0f)
                curveTo(160.0f, 408.4f, 231.6f, 480.0f, 320.0f, 480.0f)
                curveTo(408.4f, 480.0f, 480.0f, 408.4f, 480.0f, 320.0f)
                curveTo(480.0f, 231.6f, 408.4f, 160.0f, 320.0f, 160.0f)
                curveTo(231.6f, 160.0f, 160.0f, 231.6f, 160.0f, 320.0f)
                close()
                moveTo(320.0f, 224.0f)
                curveTo(373.0f, 224.0f, 416.0f, 267.0f, 416.0f, 320.0f)
                curveTo(416.0f, 373.0f, 373.0f, 416.0f, 320.0f, 416.0f)
                curveTo(267.0f, 416.0f, 224.0f, 373.0f, 224.0f, 320.0f)
                curveTo(224.0f, 267.0f, 267.0f, 224.0f, 320.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_location-crosshairs`!!
    }

private var `_location-crosshairs`: ImageVector? = null
